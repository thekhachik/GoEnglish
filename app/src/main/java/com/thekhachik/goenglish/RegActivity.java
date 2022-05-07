package com.thekhachik.goenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.thekhachik.goenglish.DataBase.App;
import com.thekhachik.goenglish.DataBase.AppDatabase;
import com.thekhachik.goenglish.DataBase.Person;
import com.thekhachik.goenglish.DataBase.PersonDao;

public class RegActivity extends AppCompatActivity {

    public EditText inputName, inputUserName, inputEmail, inputPassword;
    public Button signUpBtn;
    public TextView signInBtn;

    App app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        inputName = findViewById(R.id.inputName);
        inputUserName = findViewById(R.id.inputUserName);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        signUpBtn = findViewById(R.id.signUpBtn);
        signInBtn = findViewById(R.id.signInBtn);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegActivity.this, LogActivity.class);
                startActivity(intent);
            }
        });

        AppDatabase db = App.getInstance().getDatabase();
        Person person = new Person();
        PersonDao personDao = db.personDao();
        person.name = inputName.getText().toString();
        person.username = inputUserName.getText().toString();
        person.email = inputEmail.getText().toString();
        person.password = inputPassword.getText().toString();
        person.id = 1;
        person.ava = 2;

        personDao.insert(person);
    }
}