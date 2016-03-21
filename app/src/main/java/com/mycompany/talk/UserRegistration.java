package com.mycompany.talk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by joshua on 12/18/2015.
 */
public class UserRegistration extends AppCompatActivity {

    EditText Email, Password, UserName, Gender,Age,Name;
    Button bRegister;
    String email, password,gender, userName,name;
    String age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        Name = (EditText)findViewById(R.id.etName);
        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        UserName = (EditText)findViewById(R.id.etUserName);
        Gender = (EditText)findViewById(R.id.etGender);
        Age = (EditText)findViewById(R.id.etAge);
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = Name.getText().toString();
                email = Email.getText().toString();
                userName = UserName.getText().toString();
                password = Password.getText().toString();
                gender = Gender.getText().toString();
                age = Age.getText().toString();

                String method = "regsiter";
                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                backgroundTask.execute(method,name,userName,password,gender,age,email);

                finish();
                //Talker talkee = new Talker(userName,password,gender,age,email);
                //TalkerSingleton.get(getApplicationContext()).addTalker(talkee);

                //Intent i = new Intent(UserRegistration.this, Login.class);
                //startActivity(i);
            }
        });
    }
}