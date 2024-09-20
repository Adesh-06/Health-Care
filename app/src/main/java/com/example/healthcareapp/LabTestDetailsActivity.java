package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kotlinx.coroutines.flow.SharedFlowSlot;

public class LabTestDetailsActivity extends AppCompatActivity {
    TextView tvPackageName,tvTotalCost;
    EditText edDetails;
    Button btnBack,btnAddtoCart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);

        tvPackageName=findViewById(R.id.LTDPc);
        tvTotalCost=findViewById(R.id.LTEdtextTotalCost);
        edDetails=findViewById(R.id.LTDtxt);
        btnBack=findViewById(R.id.btnBack);
        btnAddtoCart=findViewById(R.id.btnGtoCart);

        edDetails.setKeyListener(null);
        Intent intent = getIntent();  // Correctly retrieve the intent
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Total Cost : ₹" + intent.getStringExtra("text3") + "/-");


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestAct.class));
            }
        });
        btnAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                 String product=tvPackageName.getText().toString();
                 float price =Float.parseFloat(intent.getStringExtra("text3").toString());

                   Database db=new Database(getApplicationContext(),"healthcare",null,1);
                   if(db.checkCart(username,product)==1)
                   {
                       Toast.makeText(LabTestDetailsActivity.this, "Product Already Added ", Toast.LENGTH_SHORT).show();
                   }
                   else{
                       db.addToCart(username,product,price,"lab");
                       Toast.makeText(LabTestDetailsActivity.this, "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                       startActivity(new Intent(LabTestDetailsActivity.this,LabTestAct.class));
                   }
            }
        });

    }
}