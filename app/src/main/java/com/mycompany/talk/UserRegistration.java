package com.mycompany.talk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by joshua on 12/18/2015.
 */
public class UserRegistration extends AppCompatActivity {

    EditText Email, Password, UserName, Gender,Age;
    Button bRegister;
    String email, password,gender, userName,age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        UserName = (EditText)findViewById(R.id.etUserName);
        Gender = (EditText)findViewById(R.id.etGender);
        Age = (EditText)findViewById(R.id.etAge);

        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                email = Email.getText().toString();
                userName = UserName.getText().toString();
                password = Password.getText().toString();
                gender = Gender.getText().toString();
                age = Age.getText().toString();

                Talker talkee = new Talker(userName,password,gender,age,email);
                TalkerSingleton.get(getApplicationContext()).addTalker(talkee);

                Intent i = new Intent(UserRegistration.this, Login.class);
                startActivity(i);
            }
        });
    }
}