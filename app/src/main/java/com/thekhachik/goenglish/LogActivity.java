package com.thekhachik.goenglish;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {

    public EditText inputUserName2, inputPassword2;
    public Button signInBtn2;
    public TextView signUpBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        inputUserName2 = findViewById(R.id.inputUserName2);
        inputPassword2 = findViewById(R.id.inputPassword2);
        signInBtn2 = findViewById(R.id.signInBtn2);
        signUpBtn2 = findViewById(R.id.signUpBtn2);

        signUpBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogActivity.this, RegActivity.class);
                startActivity(intent);
            }
        });
    }
}