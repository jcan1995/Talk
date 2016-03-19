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

    EditText Email, Password, UserName, Gender,Age,Name,ID,Coordinates;
    Button bRegister;
    String email, password,gender, userName,age,name, id,coordinates ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        Email = (EditText)findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        UserName = (EditText)findViewById(R.id.etUserName);
        Gender = (EditText)findViewById(R.id.etGender);
        Age = (EditText)findViewById(R.id.etAge);
       /*
        Name = (EditText)findViewById(R.id.etName);
        ID = (EditText)findViewById(R.id.etid);
        Coordinates= (EditText)findViewById(R.id.etCoordinates);
        */
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "Joshua";
                String id = "1234";
                String coordinate = "9876";
                String age = "21";
                //Hardcoded for testing purposes. Integers as Strings for Backgroundtask.
                email = Email.getText().toString();
                userName = UserName.getText().toString();
                password = Password.getText().toString();
                gender = Gender.getText().toString();
              //  name = Name.getText().toString();

              //  age = Age.getText().toString();
                //At the moment we are storing single variables into mySQL

                String method = "regsiter";
                BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                backgroundTask.execute(method,name,userName,password,gender,age,email,id,coordinate);

                finish();
                //Talker talkee = new Talker(userName,password,gender,age,email);
                //TalkerSingleton.get(getApplicationContext()).addTalker(talkee);

                //Intent i = new Intent(UserRegistration.this, Login.class);
                //startActivity(i);
            }
        });
    }
}