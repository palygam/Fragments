package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
    }


    public void addListenerOnButton() {
        radioGroup = findViewById(R.id.radio_group);

        Button button_main_activity = findViewById(R.id.button_main_activity);
        button_main_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();

                EditText editTextView = findViewById(R.id.edit_text_view);
                String message = editTextView.getText().toString();

                if (selectedId == R.id.radio_fragment1) {
                    Intent intent1 = new Intent(MainActivity.this, FragmentsActivity.class);
                    Bundle extras = new Bundle();
                    extras.putString("KEY", "id1");
                    extras.putString("KEY1", message);
                    intent1.putExtras(extras);
                    startActivity(intent1);
                } else if (selectedId == R.id.radio_fragment2) {
                    Intent intent2 = new Intent(MainActivity.this, FragmentsActivity.class);
                    Bundle extras = new Bundle();
                    extras.putString("KEY", "id2");
                    extras.putString("KEY1", message);
                    intent2.putExtras(extras);
                    startActivity(intent2);
                }
            }
        });
    }
}
