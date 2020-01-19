package com.example.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import android.app.Fragment;


public class Fragment1 extends Fragment {

    public Fragment1() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        TextView text = view.findViewById(R.id.text_fragment1);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            String message = bundle.getString("editText");
            if (message != null) {
                text.setText(message);
            }
        }
        return view;
    }
}
