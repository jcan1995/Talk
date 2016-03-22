package com.mycompany.talk;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by joshua on 12/18/2015.
 */
public class UserRegistration extends AppCompatActivity {

    EditText Email, Password, UserName, Gender,Age,Name,ConPass;
    Button bRegister;
    String email, password,gender, userName,name,conpass;
    String age;
    AlertDialog.Builder builder;


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
        ConPass = (EditText)findViewById(R.id.et_con_Password);

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = Name.getText().toString();
                email = Email.getText().toString();
                userName = UserName.getText().toString();
                password = Password.getText().toString();
                gender = Gender.getText().toString();
                age = Age.getText().toString();
                conpass = ConPass.getText().toString();

                if(name.equals("")|| email.equals("")||password.equals("")||age.equals("")||gender.equals("")||conpass.equals("") ||userName.equals("")) {

                    builder = new AlertDialog.Builder(UserRegistration.this);
                    builder.setTitle("Oops. Something went wrong..");
                    builder.setMessage("Please fill all fields...");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });

                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
                else if(!password.equals(conpass)){
                    builder = new AlertDialog.Builder(UserRegistration.this);
                    builder.setTitle("Oops. Something went wrong..");
                    builder.setMessage("Passwords do not match.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Password.setText("");
                            ConPass.setText("");
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                }
                else{
                    String method = "register";
                    BackgroundTask backgroundTask = new BackgroundTask(UserRegistration.this);
                    backgroundTask.execute(method,name,userName,password,gender,age,email);
                }


               // finish();
                //Talker talkee = new Talker(userName,password,gender,age,email);
                //TalkerSingleton.get(getApplicationContext()).addTalker(talkee);
            }
        });
    }
}