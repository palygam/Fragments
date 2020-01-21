package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    private final static String bundleKey1 = "message1";
    private final static String bundleKey2 = "message2";
    private final static String selectedId1 = "id1";
    private final static String selectedId2 = "id2";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButtonsMainActivity();
    }


    public void addButtonsMainActivity() {
        final RadioGroup radioGroup = findViewById(R.id.radio_group);
        Button buttonMainActivity = findViewById(R.id.button_main_activity);
        buttonMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == R.id.radio_fragment1) {
                    setBundle(selectedId1);
                } else if (selectedId == R.id.radio_fragment2) {
                    setBundle(selectedId2);
                }
            }
        });
    }

    public void setBundle(String id) {
        EditText editTextView = findViewById(R.id.edit_text_view);
        String message = editTextView.getText().toString();
        Intent intent = new Intent(MainActivity.this, FragmentsActivity.class);
        Bundle extras = new Bundle();
        extras.putString(bundleKey1, id);
        extras.putString(bundleKey2, message);
        intent.putExtras(extras);
        startActivity(intent);
    }
}
