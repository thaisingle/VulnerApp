package com.example.wsunpachit.vulnerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.AlertDialog;

public class LoginActivity extends AppCompatActivity {

    EditText txtUser;
    EditText txtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtUser = (EditText)findViewById(R.id.txtLogin2);
        txtPass = (EditText)findViewById(R.id.txtLogin3);
        final Button cLogin = (Button) findViewById(R.id.cmdLogin);
        final Button cRegister = (Button) findViewById(R.id.cmdRegister);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        //True is Protected
        if (isEmulator()){
            builder.setTitle("Warning!!!");
            builder.setMessage("App installed in Emulator do not allow the user registration");
            builder.setPositiveButton("OK", null);
            AlertDialog dialog = builder.show();

            //hind Register button
            cRegister.setVisibility(View.INVISIBLE);
        }


        //True is Pass
        cLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

                if (isLogin(txtUser.getText().toString() , txtPass.getText().toString())) {
                    Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(i);
                }

            }
        });

    }

    public boolean isLogin(String paramString1, String paramString2)
    {
        //Backdoor admin and password
        String str1 = "admin";
        String str2 = "password";
        return (paramString1.contentEquals(str1)) && (paramString2.contentEquals(str2));
    }

    //public, protected, and static could be bypassed by Mobile substrate
    //private could not be bypassed by Mobile substrate
    private boolean isEmulator() {
        String strDevice = Build.FINGERPRINT;
        return  strDevice.indexOf("vbox86p") >= 0
                || Build.BRAND.equals("generic")
                || Build.BRAND.equals("generic_x86");
}

    public static String getDeviceListing() {
        return "Build.PRODUCT: " + Build.PRODUCT + "\n" +
                "Build.MANUFACTURER: " + Build.MANUFACTURER + "\n" +
                "Build.BRAND: " + Build.BRAND + "\n" +
                "Build.DEVICE: " + Build.DEVICE + "\n" +
                "Build.MODEL: " + Build.MODEL + "\n" +
                "Build.HARDWARE: " + Build.HARDWARE + "\n" +
                "Build.FINGERPRINT: " + Build.FINGERPRINT;
    }
}
