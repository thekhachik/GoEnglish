package com.thekhachik.goenglish;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TutorialReadFragment extends Fragment {

    public TextView themeTutorial;
    public TextView materials;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                Fragment fragment = new TutorialsFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                ft.replace(R.id.mainFrame, fragment);
                ft.commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutorial_read, container, false);



        themeTutorial = view.findViewById(R.id.themeTutorial);
        materials = view.findViewById(R.id.materials);

        if(Data.check == 0){
            themeTutorial.setText(Data.tutorialsList.get(0));
            materials.setText(TutorialsData.nouns);
        }
        else if(Data.check == 1){
            themeTutorial.setText(Data.tutorialsList.get(1));
            themeTutorial.setTextSize(26);
            materials.setText(TutorialsData.someAnyNo);
        }
        else if(Data.check == 2){
            themeTutorial.setText(Data.tutorialsList.get(2));
            themeTutorial.setTextSize(26);
            materials.setText(TutorialsData.pronouns);
        }
        else if (Data.check == 3){
            themeTutorial.setText(Data.tutorialsList.get(3));
            themeTutorial.setTextSize(20);
            materials.setText(TutorialsData.degree);
        }
        else if (Data.check == 4){
            themeTutorial.setText(Data.tutorialsList.get(4));
            materials.setText(TutorialsData.prepositions);
        }
        else if (Data.check == 5){
            themeTutorial.setText(Data.tutorialsList.get(5));
            materials.setText(TutorialsData.infinitive);
        }
        else if (Data.check == 6){
            themeTutorial.setText(Data.tutorialsList.get(6));
            materials.setText(TutorialsData.gerund);
        }
        else if (Data.check == 7){
            themeTutorial.setText(Data.tutorialsList.get(7));
            themeTutorial.setTextSize(26);
            materials.setText(TutorialsData.inVerbs);
        }
        else if (Data.check == 8){
            themeTutorial.setText(Data.tutorialsList.get(8));
            themeTutorial.setTextSize(26);
            materials.setText(TutorialsData.modVerbs);
        }
        else if (Data.check == 9){
            themeTutorial.setText(Data.tutorialsList.get(9));
            materials.setText(TutorialsData.time);
        }
        else if (Data.check == 10){
            themeTutorial.setText(Data.tutorialsList.get(10));
            themeTutorial.setTextSize(26);
            materials.setText(TutorialsData.passiveVoice);
        }
        else if (Data.check == 11){
            themeTutorial.setText(Data.tutorialsList.get(11));
            themeTutorial.setTextSize(26);
            materials.setText(TutorialsData.conditionals);
        }
        else if (Data.check == 12){
            themeTutorial.setText(Data.tutorialsList.get(12));
            materials.setText(TutorialsData.numerals);
        }

        return view;
    }
}