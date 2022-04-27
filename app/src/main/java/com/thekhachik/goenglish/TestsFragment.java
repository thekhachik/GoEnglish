package com.thekhachik.goenglish;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TestsFragment extends Fragment {

    public CardView elementary, preIntermediate, intermediate, upper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tests, container, false);

        elementary = view.findViewById(R.id.elementary);
        preIntermediate = view.findViewById(R.id.preIntermediate);
        intermediate = view.findViewById(R.id.intermediate);
        upper = view.findViewById(R.id.upper);

        elementary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.checkTest = 1;
                replaceTest();
            }
        });

        preIntermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.checkTest = 2;
                replaceTest();
            }
        });

        intermediate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.checkTest = 3;
                replaceTest();
            }
        });

        upper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Data.checkTest = 4;
                replaceTest();
            }
        });
        return view;
    }

    public void replaceTest(){
        Data.selectFragment = "start";
        Fragment fragment = new TestStartFragment();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        ft.replace(R.id.mainFrame, fragment);
        ft.commit();
    }
}