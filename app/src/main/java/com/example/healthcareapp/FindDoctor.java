package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctor extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit=findViewById(R.id.cardFDBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctor.this,HomeActivity.class));
            }
        });

        CardView familyDoc=findViewById(R.id.cardFDFamilyPhsician);
        familyDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctor.this,DoctorDetailsActivity.class);
                it.putExtra("title","Family physicians");
                startActivity(it);
            }
        });

        CardView dentist=findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctor.this,DoctorDetailsActivity.class);
                it.putExtra("title","Dnetist ");
                startActivity(it);
            }
        });

        CardView ditecian=findViewById(R.id.cardFDDietisian);
        ditecian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctor.this,DoctorDetailsActivity.class);
                it.putExtra("title"," Dietician");
                startActivity(it);
            }
        });

        CardView surgeon=findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctor.this,DoctorDetailsActivity.class);
                it.putExtra("title"," Surgeon");
                startActivity(it);
            }
        });

        CardView cardiologist=findViewById(R.id.cardFDCardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(FindDoctor.this,DoctorDetailsActivity.class);
                it.putExtra("title","Cardiologists ");
                startActivity(it);
            }
        });


    }
}