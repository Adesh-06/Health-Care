package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class RegisterAct extends AppCompatActivity {

    EditText RegName,RegEmail,RegPass,RegConfPass;
    Button RegBtn;
    TextView RegExUsr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RegName=findViewById(R.id.RegName);
        RegEmail=findViewById(R.id.RegEmail);
        RegConfPass=findViewById(R.id.RegCnfPass);
        RegPass=findViewById(R.id.RegPass);
        RegBtn=findViewById(R.id.Regbtn);
        RegExUsr=findViewById(R.id.RegExUsr);
        
        RegExUsr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(RegisterAct.this,LoginAct.class));
            }
        });

        RegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrName=RegName.getText().toString();
                String usrPass=RegPass.getText().toString();
                String usrCofPass=RegConfPass.getText().toString();
                String usrEmail=RegEmail.getText().toString();
                Database db=new Database(getApplicationContext(),"HealthCare",null,1);

                if(usrName.length()==0 || usrPass.length()==0 || usrCofPass.length()==0 || usrEmail.length()==0 )
                {
                    Toast.makeText(getApplicationContext(), "Invalid Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(usrPass.compareTo(usrCofPass)==0)
                    {
                        boolean valid=isValidPassword(usrPass);
                        if(valid)
                        {
                            db.register(usrName,usrPass,usrEmail);
                            Toast.makeText(getApplicationContext(), "Registration Successfull ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterAct.this,LoginAct.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Password must having at least 8 character ,1 capatial letter,1 special symbol  ", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

    public static boolean isValidPassword(String password) {
        // Check if the password has at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasSpecialChar = false;

        // Iterate through the password to check for an uppercase letter and a special character
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        // Return true if the password meets all the criteria
        return hasUpperCase && hasSpecialChar;
    }
    }