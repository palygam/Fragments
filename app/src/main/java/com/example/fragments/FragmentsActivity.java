package com.example.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class FragmentsActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragments_host_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String id = extras.getString("KEY");
        String message = extras.getString("KEY1");
        Bundle bundle = new Bundle();
        bundle.putString("editText", message);


        switch (id) {
            case "id1":
                Fragment1 fragment1 = new Fragment1();
                fragment1.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
                break;
            case "id2":
                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
                break;
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
