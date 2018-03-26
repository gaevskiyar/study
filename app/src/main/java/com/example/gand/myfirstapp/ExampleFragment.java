package com.example.gand.myfirstapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gand on 24.03.18.
 */

public class ExampleFragment extends Fragment {
    private static final String ARG_TEXT = "TEXT_KEY";
    private static final String ARG_COLOR = "COLOR_KEY";
    private TextView mExampleText;
    public static ExampleFragment newInstance(String textForTV, int color){
        Bundle args  =new Bundle();
        args.putString(ARG_TEXT, textForTV);
        args.putInt(ARG_COLOR, color);
        ExampleFragment fragment = new ExampleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_layout, container, false);
        mExampleText = view.findViewById(R.id.textView3);
        Bundle args = getArguments();
        String text = args.getString(ARG_TEXT);
        mExampleText.setText(text);
        view.setBackgroundColor(args.getInt(ARG_COLOR));
        return view;
    }
}
