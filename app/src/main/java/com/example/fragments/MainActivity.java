package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    private EditText editTextView;
    private String message;
    private final static String BUNDLE_KEY1 = "message1";
    private final static String BUNDLE_KEY2 = "message2";
    private final static String SELECTED_ID1 = "id1";
    private final static String SELECTED_ID2 = "id2";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButtonsMainActivity();
        editTextView = findViewById(R.id.edit_text_view);
    }

    public void addButtonsMainActivity() {
        final RadioGroup radioGroup = findViewById(R.id.radio_group);
        Button buttonMainActivity = findViewById(R.id.button_main_activity);
        buttonMainActivity.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();
            if (selectedId == R.id.radio_fragment1) {
                message = editTextView.getText().toString();
                startActivity(buildIntent(SELECTED_ID1, message));

            } else if (selectedId == R.id.radio_fragment2) {
                message = editTextView.getText().toString();
                startActivity(buildIntent(SELECTED_ID2, message));
            }
        });
    }

    private Intent buildIntent(String id, String message) {
        Intent intent = new Intent(MainActivity.this, FragmentsActivity.class);
        Bundle extras = new Bundle();
        extras.putString(BUNDLE_KEY1, id);
        extras.putString(BUNDLE_KEY2, message);
        intent.putExtras(extras);
        return intent;
    }
}
