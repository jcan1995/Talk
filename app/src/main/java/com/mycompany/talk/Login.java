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
public class Login extends AppCompatActivity {
private final String TAG = "LoginAcivity";
    EditText etName, etPass;
    Button bLogin, bReg;
    String login_name,login_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
                   // login_name = etName.getText().toString();
                   // login_pass = etPass.getText().toString();
                   // String method = "login";
                   // BackgroundTask backgroundTask = new BackgroundTask(getApplicationContext());
                   // backgroundTask.execute(method,login_name,login_pass);
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