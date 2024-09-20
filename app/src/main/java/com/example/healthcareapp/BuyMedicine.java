package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BuyMedicine extends AppCompatActivity {

    // Example medicine data with names, descriptions, and prices
    private String[][] packages = {
            {"Uprise-D3 1000IU Capsule", "", "", "50"},
            {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "305"},
            {"Vitamin B Complex Capsules", "", "", "448"},
            {"Inlife Vitamin E Wheat Germ Oil Capsule", "", "", "539"},
            {"Dolo 650 Tablet", "", "", "50"},
            {"Strepsils Medicated Lozenges for Sore Throat", "", "", "408"},
            {"Tata 1mg Calcium + Vitamin D3", "", "", "30"},
            {"Feronia-XT Tablet", "", "", "130"},
            {"Crocin 500 Tablet", "", "", "45"}
    };

    // Descriptions of each medicine
    private String[] package_details = {
            "Building and keeping the bones & teeth strong. Supports calcium absorption and overall bone health.",
            "Reducing fatigue, stress, and muscular pains. Boosts energy and helps regulate metabolism.",
            "Boosts immunity and increases resistance against infection. Helps form red blood cells.",
            "An essential trace mineral that plays an important role in insulin regulation. Also provides antioxidant support.",
            "Provides relief from pain and helps reduce fever. Used for headaches, muscle pain, and common colds.",
            "Helps soothe sore throats and relieve discomfort caused by a cold or flu. Available in different flavors.",
            "A supplement for healthy bones and teeth. Provides calcium and vitamin D3 for better calcium absorption.",
            "Helps increase iron levels in the body. Used to treat anemia caused by chronic blood loss or low iron intake.",
            "Pain reliever commonly used for reducing mild to moderate pain such as headaches, menstrual pain, and muscle aches."
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack,btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst=findViewById(R.id.Mlst);
        btnBack=findViewById(R.id.btnBack);
        btnGoToCart=findViewById(R.id.btnGtoCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BuyMedicine.this,HomeActivity.class));
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });

        list=new ArrayList();
        for(int i=0;i<packages.length;i++)
        {
            item=new HashMap<String,String>();
            item.put("line1",packages[i][0]);
            item.put("line2",packages[i][1]);
            item.put("line3",packages[i][2]);
            item.put("line4",packages[i][3]);
            item.put("line5",packages[i][4]);
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,
                R.layout.multi_line,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

    }
}
