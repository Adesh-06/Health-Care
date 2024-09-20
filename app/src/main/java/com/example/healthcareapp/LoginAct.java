package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.SharedMemory;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class LoginAct extends AppCompatActivity {
    EditText lgnName,lgnPass;
    Button btnlgn;
    TextView lgnNewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lgnName=findViewById(R.id.lgnName);
        lgnPass=findViewById(R.id.lgnPass);
        btnlgn=findViewById(R.id.btnLgn);
        lgnNewUser=findViewById(R.id.lgnNewUsr);

        btnlgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName=lgnName.getText().toString();
                String Password=lgnPass.getText().toString();
                Database db=new Database(getApplicationContext(),"HealthCare",null,1);
                if(userName.length()==0 || Password.length()==0)
                {
                    Toast.makeText(getApplicationContext(), "Invalid Details", Toast.LENGTH_SHORT).show();
                }
                else {
                    if(db.login(userName,Password)==1) {
                        Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("username",userName);
                        editor.apply();
                        startActivity(new Intent(LoginAct.this,HomeActivity.class));
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalid Username and Password ", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        lgnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginAct.this,RegisterAct.class));
            }
        });



    }

}