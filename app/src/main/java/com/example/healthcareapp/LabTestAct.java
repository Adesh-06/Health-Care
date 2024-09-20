package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestAct extends AppCompatActivity {
    private String[][] packages = {
            {"Package 1: Full Body Checkup", "", "", "","999"},
            {"Package 2: Blood Glucose Fasting", "", "","", "299"},
            {"Package 3: COVID-19 Antibody IgG", "", "","", "899"},
            {"Package 4: Thyroid Check", "", "","", "499"},
            {"Package 5: Immunity Check", "", "", "","699"}
    };

    // Package details
    private String[] package_details = {
            // Full Body Checkup details
            "Full Body Checkup:\n" +
                    "Blood Glucose Fasting\n" +
                    "Complete Hemogram\n" +
                    "HbA1c\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "LDH Lactate Dehydrogenase, Serum\n" +
                    "Lipid Profile\n" +
                    "Liver Function Test",

            // Blood Glucose Fasting details
            "Blood Glucose Fasting:\n" +
                    "This test is used to measure the glucose level in your blood after fasting.\n" +
                    "Helps in diagnosing diabetes and monitoring blood sugar levels.",

            // COVID-19 Antibody IgG details
            "COVID-19 Antibody IgG:\n" +
                    "This test detects the presence of antibodies to determine past infection with the COVID-19 virus.\n" +
                    "Useful in assessing immunity levels post-infection or vaccination.",

            // Thyroid Check details
            "Thyroid Check:\n" +
                    "This test measures the levels of T3, T4, and TSH hormones to evaluate thyroid function.\n" +
                    "Helps in diagnosing conditions such as hypothyroidism or hyperthyroidism.",

            // Immunity Check details
            "Immunity Check:\n" +
                    "This test evaluates the strength of your immune system by checking levels of various immune markers.\n" +
                    "Helps in assessing your body's ability to fight infections."
    };


    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.DDBtnCart);
        btnBack = findViewById(R.id.DDBtnBack);
        listView = findViewById(R.id.DDLstvw);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestAct.this, HomeActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost: ₹" + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_line,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        listView.setAdapter(sa);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                        Intent it=new Intent(LabTestAct.this,LabTestDetailsActivity.class);
                        it.putExtra("text1",packages[i][0]);
                        it.putExtra("text2",package_details[i]);
                        it.putExtra("text3",packages[i][4]);
                        startActivity(it);

                    }
                }
        );

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LabTestAct.this,CartActivity.class));
            }
        });
    }
}
