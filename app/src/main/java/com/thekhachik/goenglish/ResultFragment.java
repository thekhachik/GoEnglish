package com.thekhachik.goenglish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ResultFragment extends Fragment {

    private FirebaseAuth mAuth;
    private FirebaseDatabase db;
    private DatabaseReference myRef;

    public TextView result, lvlRes;
    public Button check;

    public int count = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        myRef = db.getReference();
        FirebaseUser user = mAuth.getCurrentUser();

        result = view.findViewById(R.id.result);
        lvlRes = view.findViewById(R.id.lvlRes);
        check = view.findViewById(R.id.check);


        for(int i = 0; Data.ResultList.size() > i; i++){
            if (Data.ResultList.get(i) == true){
                count++;
            }
        }

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count > 15 && Data.checkTest == 1){
                    myRef.child("Users").child(user.getUid()).child("lvl").setValue("Elementary");
                    result.setText("Поздравляем с уровнем");
                    lvlRes.setText("Elementary");
                }
                else if (count < 15 && Data.checkTest == 1){
                    myRef.child("Users").child(user.getUid()).child("lvl").setValue("Noob");
                    result.setText("Повторите материал");
                    lvlRes.setText("Noob");
                }
                else if(count > 15 && Data.checkTest == 2){
                    myRef.child("Users").child(user.getUid()).child("lvl").setValue("Pre-Intermedia");
                    result.setText("Поздравляем с уровнем");
                    lvlRes.setText("Pre-Intermedia");
                }
                else if(count < 15 && Data.checkTest == 2){
                    myRef.child("Users").child(user.getUid()).child("lvl").setValue("Elementary");
                    result.setText("Повторите материал");
                    lvlRes.setText("Elementary");
                }
                else if(count > 15 && Data.checkTest == 3){
                    myRef.child("Users").child(user.getUid()).child("lvl").setValue("Intermedia");
                    result.setText("Поздравляем с уровнем");
                    lvlRes.setText("Intermedia");
                }
                else if(count < 15 && Data.checkTest == 3){
                    myRef.child("Users").child(user.getUid()).child("lvl").setValue("Pre-Intermedia");
                    result.setText("Повторите материал");
                    lvlRes.setText("Pre-Intermedia");
                }
                else if(count > 15 && Data.checkTest == 4){
                    myRef.child("Users").child(user.getUid()).child("lvl").setValue("Upper-Intermedia");
                    result.setText("Поздравляем с уровнем");
                    lvlRes.setText("Upper-Intermedia");
                }
                else if(count < 15 && Data.checkTest == 4){
                    myRef.child("Users").child(user.getUid()).child("lvl").setValue("Intermedia");
                    result.setText("Повторите материал");
                    lvlRes.setText("Intermedia");
                }
            }
        });



        System.out.println(count);
        System.out.println(Data.checkTest);
        return view;
    }
}