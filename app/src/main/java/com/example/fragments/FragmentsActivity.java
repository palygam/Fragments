package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class FragmentsActivity extends AppCompatActivity {
    private final static String messageToFragment = "messageToFragment";
    private final static String bundleKey1 = "message1";
    private final static String bundleKey2 = "message2";
    private final static String selectedId1 = "id1";
    private final static String selectedId2 = "id2";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_host_activity);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String id = extras.getString(bundleKey1);
        String message = extras.getString(bundleKey2);
        Bundle bundle = new Bundle();
        bundle.putString(messageToFragment, message);

        if (id != null) {
            switch (id) {
                case selectedId1:
                    Fragment1 fragment1 = new Fragment1();
                    fragment1.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

                    break;
                case selectedId2:
                    Fragment2 fragment2 = new Fragment2();
                    fragment2.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                    break;
            }
        }
    }
}
