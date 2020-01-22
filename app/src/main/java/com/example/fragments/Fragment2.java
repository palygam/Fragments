package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {
    private String message =" ";
    private final static String MESSAGE_TO_FRAGMENT = "messageToFragment";
    private final static String SAVED_STATE = "savedState";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            message = savedInstanceState.getString(SAVED_STATE);
        }
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            message = bundle.getString(MESSAGE_TO_FRAGMENT);

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment2, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView text = view.findViewById(R.id.text_fragment2);
            text.setText(message);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(SAVED_STATE, message);
    }
}
