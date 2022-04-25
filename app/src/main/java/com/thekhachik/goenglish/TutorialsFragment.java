package com.thekhachik.goenglish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TutorialsFragment extends Fragment {

    //ListView
    public ListView listTutorials;
    //Adapter
    public ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorials, container, false);
        //ListView
        listTutorials = view.findViewById(R.id.listTutorials);
        //Adapter
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.custom_list, Data.tutorialsList);
        listTutorials.setAdapter(adapter);

        listTutorials.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0){
                    Data.check = 0;
                    replaceRead();
                }
                else if(i == 1){
                    Data.check = 1;
                    replaceRead();
                }
                else if(i == 2){
                    Data.check = 2;
                    replaceRead();
                }
                else if(i == 3){
                    Data.check = 3;
                    replaceRead();
                }
                else if(i == 4){
                    Data.check = 4;
                    replaceRead();
                }
                else if(i == 5){
                    Data.check = 5;
                    replaceRead();
                }
                else if(i == 6){
                    Data.check = 6;
                    replaceRead();
                }
                else if(i == 7){
                    Data.check = 7;
                    replaceRead();
                }
                else if(i == 8){
                    Data.check = 8;
                    replaceRead();
                }
                else if(i == 9){
                    Data.check = 9;
                    replaceRead();
                }
                else if(i == 10){
                    Data.check = 10;
                    replaceRead();
                }
                else if(i == 11){
                    Data.check = 11;
                    replaceRead();
                }
                else if(i == 12){
                    Data.check = 12;
                    replaceRead();
                }
            }
        });


        return view;
    }

    public void replaceRead(){
        Data.selectFragment = "read";
        Fragment fragment = new TutorialReadFragment();
        FragmentManager fm = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        ft.replace(R.id.mainFrame, fragment);
        ft.commit();
    }
}