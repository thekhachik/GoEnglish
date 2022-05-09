package com.thekhachik.goenglish;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class TestStartFragment extends Fragment {

    public TextView textTask, ttt;
    public RadioButton answer1, answer2, answer3;
    public RadioGroup groupBtn;
    public Button next;

    public ArrayList<String> ListTask;
    public ArrayList<String> ListElemA;
    public ArrayList<String> ListElemB;
    public ArrayList<String> ListElemC;
    public ArrayList<String> ListAnswer;

    public ArrayList<Boolean> TrueOrFalseAnswer = new ArrayList<>();
    public Boolean bool;

    private FirebaseAuth mAuth;
    private FirebaseDatabase db;
    private DatabaseReference myRef;

    //Счетчик для списков
    public int ig = 0;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_start, container, false);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        myRef = db.getReference();

        //Связываем все элементы из XML
        textTask = view.findViewById(R.id.textTask);
        answer1 = view.findViewById(R.id.answer1);
        answer2 = view.findViewById(R.id.answer2);
        answer3 = view.findViewById(R.id.answer3);
        groupBtn = view.findViewById(R.id.groupBtn);
        next = view.findViewById(R.id.button);

        //Если был выбран тест Elementary, то мы передаем значения списков из ElementaryData в этот файл.
        if(Data.checkTest == 1){
            ListTask = ElementaryData.elementaryListTest;
            ListElemA = ElementaryData.elemA;
            ListElemB = ElementaryData.elemB;
            ListElemC = ElementaryData.elemC;
            ListAnswer = ElementaryData.answers2;
        }
        else if(Data.checkTest == 2){
            ListTask = PreIntData.PreIntTest;
            ListElemA = PreIntData.elemA;
            ListElemB = PreIntData.elemB;
            ListElemC = PreIntData.elemC;
            ListAnswer = PreIntData.answers2;
        }
        else if(Data.checkTest == 3){
            ListTask = IntermediaData.IntermediaTest;
            ListElemA = IntermediaData.elemA;
            ListElemB = IntermediaData.elemB;
            ListElemC = IntermediaData.elemC;
            ListAnswer = IntermediaData.answers2;
        }
        else if(Data.checkTest == 4){
            ListTask = UpperData.UpperTest;
            ListElemA = UpperData.elemA;
            ListElemB = UpperData.elemB;
            ListElemC = UpperData.elemC;
            ListAnswer = UpperData.answers2;
        }

        //Добавляем текст с заданием и пункты ответов.
        textTask.setText(ListTask.get(ig));
        answer1.setText(ListElemA.get(ig));
        answer2.setText(ListElemB.get(ig));
        answer3.setText(ListElemC.get(ig));

        FirebaseUser user = mAuth.getCurrentUser();

        //Проверка какой ответ верный
        groupBtn.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.answer1:
                        if(answer1.getText().toString().equals(ListAnswer.get(ig))){
                            bool = true;
                        }
                        else{
                            bool = false;
                        }
                        break;

                    case R.id.answer2:
                        if(answer2.getText().toString().equals(ListAnswer.get(ig))){
                            bool = true;
                        }
                        else{
                            bool = false;
                        }
                        break;

                    case R.id.answer3:
                        if(answer3.getText().toString().equals(ListAnswer.get(ig))){
                            bool = true;
                        }
                        else{
                            bool = false;
                        }
                        break;
                }
            }
        });

        //Следующее задание.
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(answer1.isChecked() || answer2.isChecked() || answer3.isChecked()){
                    if(ig+1 <= ListTask.size()-1){
                        //Увеличиваем счетчик на 1, чтобы указать следуюзие задания
                        ig++;
                        //Добавляем в список наши ответы, для результата.
                        TrueOrFalseAnswer.add(bool);
                        //Убираем выделение с RadioButton.
                        groupBtn.clearCheck();
                        //После добавления результата, обнуляем значение для того чтобы в следующем тесте эта переменная была пустая
                        bool = null;
                        //Установить следующее задание
                        textTask.setText(ListTask.get(ig));
                        answer1.setText(ListElemA.get(ig));
                        answer2.setText(ListElemB.get(ig));
                        answer3.setText(ListElemC.get(ig));


                    }
                    else {
                        Data.ResultList = TrueOrFalseAnswer;
                        Fragment fragment = new ResultFragment();
                        FragmentManager fm = getActivity().getSupportFragmentManager();
                        FragmentTransaction ft = fm.beginTransaction();
                        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                        ft.replace(R.id.mainFrame, fragment);
                        ft.commit();
                    }
                }
                else {
                    Toast toast = Toast.makeText(getContext(), "Выберите ответ", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });








        return view;
    }

}