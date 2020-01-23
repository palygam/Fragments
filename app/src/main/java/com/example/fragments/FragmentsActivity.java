package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class FragmentsActivity extends AppCompatActivity {
    private final static String MESSAGE_TO_FRAGMENT = "messageToFragment";
    private final static String BUNDLE_KEY1 = "message1";
    private final static String BUNDLE_KEY2 = "message2";
    private final static String SELECTED_ID1 = "id1";
    private final static String SELECTED_ID2 = "id2";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_host_activity);
        setupToolbar();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String bundleKey = extras.getString(BUNDLE_KEY1);
        String message = extras.getString(BUNDLE_KEY2);
        buildFragmentsBundle(bundleKey, message);
    }

    private void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    private void buildFragmentsBundle(String bundleKey, String message) {
        Bundle bundle = new Bundle();
        bundle.putString(MESSAGE_TO_FRAGMENT, message);
        if (bundleKey != null) {
            switch (bundleKey) {
                case SELECTED_ID1:
                    Fragment1 fragment1 = new Fragment1();
                    fragment1.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                    break;
                case SELECTED_ID2:
                    Fragment2 fragment2 = new Fragment2();
                    fragment2.setArguments(bundle);
                    getFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                    break;
            }
        }
    }
}
