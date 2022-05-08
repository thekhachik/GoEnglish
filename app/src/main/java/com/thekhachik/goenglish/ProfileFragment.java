package com.thekhachik.goenglish;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;

public class ProfileFragment extends Fragment {

    public Button settings;
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
        settings = view.findViewById(R.id.settingsButton);
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
                Object pointsF = snapshot.child(user.getUid()).child("points").getValue();
                pointsTXT.setText(pointsF.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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
                    }
                });
                ava2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava2);
                    }
                });
                ava3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava3);
                    }
                });
                ava4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava4);
                    }
                });
                ava5.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava5);
                    }
                });
                ava6.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava6);
                    }
                });
                ava7.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava8);
                    }
                });
                ava8.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava9);
                    }
                });
                ava9.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava10);
                    }
                });
                ava10.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava11);
                    }
                });
                ava11.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava12);
                    }
                });
                ava12.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imgProf.setImageResource(R.drawable.ava13);
                    }
                });

                dialog.show();
            }
        });

        return view;
    }
}