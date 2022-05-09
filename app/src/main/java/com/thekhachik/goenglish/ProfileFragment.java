package com.thekhachik.goenglish;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileFragment extends Fragment {

    public Button privacy;
    public Button signOut;
    public TextView nameTXT, emailTXT, pointsTXT;
    private FirebaseAuth mAuth;
    private FirebaseDatabase db;
    private DatabaseReference myRef;

    public ShapeableImageView imgProf;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //Image
        imgProf = view.findViewById(R.id.imgProf);
        //Button
        privacy = view.findViewById(R.id.privacyButton);
        signOut = view.findViewById(R.id.signOutButton);
        nameTXT = view.findViewById(R.id.nameTXT);
        emailTXT = view.findViewById(R.id.emailTXT);
        pointsTXT = view.findViewById(R.id.pointsTXT);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();
        myRef = db.getReference();

        FirebaseUser user = mAuth.getCurrentUser();

        //Получаем из БД данные
        myRef.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object nameF = snapshot.child(user.getUid()).child("name").getValue();
                nameTXT.setText(nameF.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myRef.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object emailF = snapshot.child(user.getUid()).child("email").getValue();
                emailTXT.setText(emailF.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myRef.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object pointsF = snapshot.child(user.getUid()).child("lvl").getValue();
                pointsTXT.setText(pointsF.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myRef.child("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Object avaF = snapshot.child(user.getUid()).child("ava").getValue();
                int chekAva = Integer.parseInt(avaF.toString());
                if (chekAva == 1){
                    imgProf.setImageResource(R.drawable.ava1);
                }
                if (chekAva == 2){
                    imgProf.setImageResource(R.drawable.ava2);
                }
                if (chekAva == 3){
                    imgProf.setImageResource(R.drawable.ava3);
                }
                if (chekAva == 4){
                    imgProf.setImageResource(R.drawable.ava4);
                }
                if (chekAva == 5){
                    imgProf.setImageResource(R.drawable.ava5);
                }
                if (chekAva == 6){
                    imgProf.setImageResource(R.drawable.ava6);
                }
                if (chekAva == 7){
                    imgProf.setImageResource(R.drawable.ava8);
                }
                if (chekAva == 8){
                    imgProf.setImageResource(R.drawable.ava9);
                }
                if (chekAva == 9){
                    imgProf.setImageResource(R.drawable.ava10);
                }
                if (chekAva == 10){
                    imgProf.setImageResource(R.drawable.ava11);
                }
                if (chekAva == 11){
                    imgProf.setImageResource(R.drawable.ava12);
                }
                if (chekAva == 12){
                    imgProf.setImageResource(R.drawable.ava13);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new PrivacyFragment();
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
                ft.replace(R.id.mainFrame, fragment);
                ft.commit();
            }
        });


        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), LogActivity.class);
                startActivity(intent);
            }
        });

        imgProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle("Select avatars");
                LayoutInflater inflater = LayoutInflater.from(getActivity());
                View img = inflater.inflate(R.layout.custom_dialog_image, null);
                dialog.setView(img);

                ImageView ava1 = img.findViewById(R.id.ava1);
                ImageView ava2 = img.findViewById(R.id.ava2);
                ImageView ava3 = img.findViewById(R.id.ava3);
                ImageView ava4 = img.findViewById(R.id.ava4);
                ImageView ava5 = img.findViewById(R.id.ava5);
                ImageView ava6 = img.findViewById(R.id.ava6);
                ImageView ava7 = img.findViewById(R.id.ava7);
                ImageView ava8 = img.findViewById(R.id.ava8);
                ImageView ava9 = img.findViewById(R.id.ava9);
                ImageView ava10 = img.findViewById(R.id.ava10);
                ImageView ava11 = img.findViewById(R.id.ava11);
                ImageView ava12 = img.findViewById(R.id.ava12);

                ava1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava1);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(1);
                    }
                });
                ava2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava2);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(2);
                    }
                });
                ava3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava3);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(3);
                    }
                });
                ava4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava4);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(4);
                    }
                });
                ava5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava5);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(5);
                    }
                });
                ava6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava6);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(6);
                    }
                });
                ava7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava8);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(7);
                    }
                });
                ava8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava9);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(8);
                    }
                });
                ava9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava10);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(9);
                    }
                });
                ava10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava11);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(10);
                    }
                });
                ava11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava12);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(11);
                    }
                });
                ava12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava13);
                        myRef.child("Users").child(user.getUid()).child("ava").setValue(12);
                    }
                });

                dialog.show();
            }
        });

        return view;
    }
}