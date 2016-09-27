package com.example.wsunpachit.vulnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText txtUser;
    EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = (EditText)findViewById(R.id.txtLogin2);
        txtPass = (EditText)findViewById(R.id.txtLogin3);

        final Button btn1 = (Button) findViewById(R.id.cmdLogin);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if (isLogin(txtUser.getText().toString() , txtPass.getText().toString())) {
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                }
            }
        });

    }

    public boolean isLogin(String paramString1, String paramString2)
    {
        String str1 = "admin";
        String str2 = "password";
        return (paramString1.contentEquals(str1)) && (paramString2.contentEquals(str2));
    }
}
