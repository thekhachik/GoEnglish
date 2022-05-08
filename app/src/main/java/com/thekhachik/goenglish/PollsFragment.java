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


public class PollsFragment extends Fragment {

    public int ip = 0;

    public Button send;
    public TextView pollTask, checkTrueOrFalse;
    public RadioGroup groupAns;
    public RadioButton answerPoll1, answerPoll2, answerPoll3;

    public ArrayList<String> ListTaskPoll;
    public ArrayList<String> ListAnswerPoll;

    public Boolean boolPolls;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_polls, container, false);

        send = view.findViewById(R.id.button2);
        pollTask = view.findViewById(R.id.pollTask);
        checkTrueOrFalse = view.findViewById(R.id.checkTrueOrFalse);
        groupAns = view.findViewById(R.id.groupAns);
        answerPoll1 = view.findViewById(R.id.answerPoll1);
        answerPoll2 = view.findViewById(R.id.answerPoll2);
        answerPoll3 = view.findViewById(R.id.answerPoll3);

        ListTaskPoll = PollData.PollTests;
        ListAnswerPoll = PollData.answers2;

        int a = (int) (Math.random()*22);

        pollTask.setText(ListTaskPoll.get(a));

        answerPoll1.setText(PollData.elemA.get(a));
        answerPoll2.setText(PollData.elemB.get(a));
        answerPoll3.setText(PollData.elemC.get(a));

        System.out.println(a);

        groupAns.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.answerPoll1:
                        if(answerPoll1.getText().toString().equals(ListAnswerPoll.get(a))){
                            boolPolls = true;
                        }
                        else{
                            boolPolls = false;
                        }
                        break;

                    case R.id.answerPoll2:
                        if(answerPoll2.getText().toString().equals(ListAnswerPoll.get(a))){
                            boolPolls = true;
                        }
                        else{
                            boolPolls = false;
                        }
                        break;
                    case R.id.answerPoll3:
                        if(answerPoll3.getText().toString().equals(ListAnswerPoll.get(a))){
                            boolPolls = true;
                        }
                        else{
                            boolPolls = false;
                        }
                        break;
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boolPolls == true){
                    checkTrueOrFalse.setText("Верно");
                }
                else {
                    checkTrueOrFalse.setText("Неверно");
                }
            }
        });

        return view;
    }
}