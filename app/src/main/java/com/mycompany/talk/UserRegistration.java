package com.mycompany.talk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by joshua on 12/18/2015.
 */
public class UserRegistration extends AppCompatActivity {

    EditText Email, Password, PhoneNumber, Gender;
    Button bRegister;
    String email, password,gender, userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);
// connect widgets. Grab references
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
        PhoneNumber = (EditText) findViewById(R.id.etPhoneNumber);
        PhoneNumber.addTextChangedListener(new TextWatcher() {
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

      //  email = Email.getText().toString();
      //  password = Password.getText().toString();
       // gender = Gender.getText().toString();
        /**
         * For now, userName will be the phone number of the user...
         */
      //  userName = PhoneNumber.getText().toString();

        ///////////////////////////////////////////////

        bRegister = (Button) findViewById(R.id.bRegister);
        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Talker talkee = new Talker(userName,password,gender,18,email);
                TalkerSingleton.get(getApplicationContext()).addTalker(talkee);

                Intent i = new Intent(UserRegistration.this,Login.class);
                startActivity(i);
            }
        });
    }
}