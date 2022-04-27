package com.thekhachik.goenglish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TestStartFragment extends Fragment {

    public TextView textTask;
    public RadioButton answer1, answer2, answer3;
    public RadioGroup groupBtn;
    public Button next;

    public ArrayList<String> ListTask;
    public ArrayList<String> ListElemA;
    public ArrayList<String> ListElemB;
    public ArrayList<String> ListElemC;
    public ArrayList<Integer> ListAnswer;

    public ArrayList<Boolean> TrueOrFalseAnswer;

    public int ig = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_start, container, false);

        textTask = view.findViewById(R.id.textTask);
        answer1 = view.findViewById(R.id.answer1);
        answer2 = view.findViewById(R.id.answer2);
        answer3 = view.findViewById(R.id.answer3);
        groupBtn = view.findViewById(R.id.groupBtn);
        next = view.findViewById(R.id.button);

        if(Data.checkTest == 1){
            ListTask = ElementaryData.elementaryListTest;
            ListElemA = ElementaryData.elemA;
            ListElemB = ElementaryData.elemB;
            ListElemC = ElementaryData.elemC;
            ListAnswer = ElementaryData.answers;
        }


        textTask.setText(ListTask.get(ig));
        answer1.setText(ListElemA.get(ig));
        answer2.setText(ListElemB.get(ig));
        answer3.setText(ListElemC.get(ig));


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ig++;
                groupBtn.clearCheck();
                textTask.setText(ListTask.get(ig));
                answer1.setText(ListElemA.get(ig));
                answer2.setText(ListElemB.get(ig));
                answer3.setText(ListElemC.get(ig));


            }
        });

        return view;
    }

    public void checkTask(){
        groupBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });
    }
}