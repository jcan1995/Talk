package com.mycompany.talk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by joshua on 12/18/2015.
 */
public class UserRegistration extends AppCompatActivity {

   // EditText Email, Password, UserName, Gender;
    Button bRegister;
   // String email, password,gender, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);

        /*
        Email = (EditText) findViewById(R.id.etEmail);
        Email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                email = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Password = (EditText) findViewById(R.id.etPassword);
        Password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        UserName = (EditText) findViewById(R.id.etUserName);
        UserName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                userName = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        Gender = (EditText) findViewById(R.id.etGender);
        Gender.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                gender = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

*/
        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Talker talkee = new Talker("Jcan","Granger2","Male", 10,"cante008@cougars.csusm.edu");

                TalkerSingleton.get(getApplicationContext()).addTalker(talkee);

             //   ArrayList<Talker> talkers = TalkerSingleton.get(getApplicationContext()).getTalkers();
/*
                if(talkers.size() == 0){
                    Log.e("Conditional", "There is no talkers in here");
                }

                else if(talkers.size() == 1){
                    Log.e("Conditional", "There is a talker in here");
                }
*/
                Intent i = new Intent(UserRegistration.this,Login.class);
                startActivity(i);
            }
        });
    }
}