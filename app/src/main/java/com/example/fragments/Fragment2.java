package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {

    public Fragment2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);

        TextView text = view.findViewById(R.id.text_fragment2);
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
