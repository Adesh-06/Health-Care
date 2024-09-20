package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LabTestBookActivity extends AppCompatActivity {
    EditText edtName,edtAddress,edtPincode,edtContact;
    Button btnBok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);
        edtName=findViewById(R.id.LTBName);
        edtAddress=findViewById(R.id.LTBAdd);
        edtPincode=findViewById(R.id.LTBCPin);
        edtContact=findViewById(R.id.LTBCon);
        btnBok=findViewById(R.id.LTBbtnBok);

        Intent intent=getIntent();
        String []price=intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date=intent.getStringExtra("date");
        String time=intent.getStringExtra("time");
        btnBok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                Database db=new Database(getApplicationContext(),"healthcare",null,1);
                db.addOrder(
                        username,
                        edtName.getText().toString(),
                        edtAddress.getText().toString(),
                        edtContact.getText().toString(),
                        Integer.parseInt(edtPincode.getText().toString()),
                        date.toString(),
                        time.toString(),
                        Float.parseFloat(price[1]), // Getting the price from the intent extra
                        "lab" // Assuming "lab" is the otype
                );
                db.removeCart(username,"lab");
                Toast.makeText(getApplicationContext(), "Your booking is done Successfully", Toast.LENGTH_LONG).show();
                startActivity(new Intent(LabTestBookActivity.this,HomeActivity.class));
            }
        });
    }
}