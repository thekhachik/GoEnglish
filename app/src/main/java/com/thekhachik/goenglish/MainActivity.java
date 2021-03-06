package com.thekhachik.goenglish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.StatusBarManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavMenu);

        replaceFragment(new TutorialsFragment());

        if(Data.selectFragment.equals("tutor")){
            replaceFragment(new TutorialsFragment());
        }
        else if(Data.selectFragment.equals("test")){
            replaceFragment(new TestsFragment());
        }
        else if(Data.selectFragment.equals("prof")){
            replaceFragment(new ProfileFragment());
        }
        else if(Data.selectFragment.equals("read")){
            replaceFragment(new TutorialReadFragment());
        }
        else if(Data.selectFragment.equals("start")){
            replaceFragment(new TestStartFragment());
        }
        else if(Data.selectFragment.equals("polls")){
            replaceFragment(new PollsFragment());
        }

        bottomNavigationView.setSelectedItemId(R.id.tutorial);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.tutorial:
                    replaceFragment(new TutorialsFragment());
                    Data.selectFragment = "tutor";
                    break;

                case R.id.tests:
                    replaceFragment(new TestsFragment());
                    Data.selectFragment = "test";
                    break;

                case R.id.polls:
                    replaceFragment(new PollsFragment());
                    Data.selectFragment = "polls";
                    break;

                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    Data.selectFragment = "prof";
                    break;
            }
            return true;
        });
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
        ft.replace(R.id.mainFrame, fragment);
        ft.commit();
    }
}