package com.mycompany.talk;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


/**
 * Created by joshua on 12/18/2015.
 */
public class Login extends AppCompatActivity {
private final String TAG = "LoginAcivity";
    EditText etName, etPass;
    Button bLogin, bReg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "!!!!!!!!!!!!!!!Here I am!!!!!!!!!!", new Exception());
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);

        etName = (EditText) findViewById(R.id.etName);
        etPass = (EditText) findViewById(R.id.etPass);
        bLogin = (Button) findViewById(R.id.bLogin);
        bReg = (Button) findViewById(R.id.bReg);

        if (bLogin != null)
            bLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Login.this, MainAppActivity.class);
                    startActivity(intent);
                }
            });

        if (bReg != null)
            bReg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Login.this, UserRegistration.class);
                    startActivity(intent);
                }
            });


    }
}