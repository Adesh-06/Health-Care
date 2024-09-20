package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 = {
            {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No : 89085989489", "600"},
            {"Doctor Name : Rajesh Patil", "Hospital Address : Chinchwad", "Exp : 10yrs", "Mobile No : 9876543210", "800"},
            {"Doctor Name : Priya Deshmukh", "Hospital Address : Nigdi", "Exp : 3yrs", "Mobile No : 8765432109", "500"},
            {"Doctor Name : Amit Sharma", "Hospital Address : Baner", "Exp : 7yrs", "Mobile No : 9988776655", "750"},
            {"Doctor Name : Neha Kulkarni", "Hospital Address : Wakad", "Exp : 4yrs", "Mobile No : 9090909090", "650"},
            {"Doctor Name : Anil Rathi", "Hospital Address : Kothrud", "Exp : 15yrs", "Mobile No : 9191919191", "1200"},
            {"Doctor Name : Smita Joshi", "Hospital Address : Viman Nagar", "Exp : 6yrs", "Mobile No : 8080808080", "700"}
    };

    private String[][] doctor_details2 = {
            {"Doctor Name : Ravi Gaikwad", "Hospital Address : Hadapsar", "Exp : 8yrs", "Mobile No : 7878787878", "900"},
            {"Doctor Name : Sunita Verma", "Hospital Address : Aundh", "Exp : 12yrs", "Mobile No : 7676767676", "1100"},
            {"Doctor Name : Rohit Pawar", "Hospital Address : Karve Nagar", "Exp : 2yrs", "Mobile No : 7272727272", "550"},
            {"Doctor Name : Kiran Bhosale", "Hospital Address : Shivaji Nagar", "Exp : 9yrs", "Mobile No : 7070707070", "850"},
            {"Doctor Name : Swati Ingle", "Hospital Address : Hinjewadi", "Exp : 11yrs", "Mobile No : 7171717171", "1050"},
            {"Doctor Name : Abhijit More", "Hospital Address : Kharadi", "Exp : 4yrs", "Mobile No : 7272727272", "650"},
            {"Doctor Name : Sheetal Mane", "Hospital Address : Pimple Saudagar", "Exp : 6yrs", "Mobile No : 7373737373", "750"}
    };

    private String[][] doctor_details3 = {
            {"Doctor Name : Suresh Kale", "Hospital Address : Nigdi", "Exp : 14yrs", "Mobile No : 7474747474", "1200"},
            {"Doctor Name : Nilesh Shinde", "Hospital Address : Baner", "Exp : 7yrs", "Mobile No : 7575757575", "900"},
            {"Doctor Name : Komal Dhonde", "Hospital Address : Aundh", "Exp : 5yrs", "Mobile No : 7676767676", "800"},
            {"Doctor Name : Tanmay Joshi", "Hospital Address : Kothrud", "Exp : 3yrs", "Mobile No : 7878787878", "550"},
            {"Doctor Name : Naina Wagh", "Hospital Address : Shivaji Nagar", "Exp : 2yrs", "Mobile No : 7979797979", "500"},
            {"Doctor Name : Mahesh Gaikwad", "Hospital Address : Kharadi", "Exp : 13yrs", "Mobile No : 7171717171", "1100"},
            {"Doctor Name : Vishal Pawar", "Hospital Address : Wakad", "Exp : 6yrs", "Mobile No : 9090909090", "850"}
    };

    private String[][] doctor_details4 = {
            {"Doctor Name : Sanjay Rathod", "Hospital Address : Hadapsar", "Exp : 9yrs", "Mobile No : 8282828282", "1000"},
            {"Doctor Name : Ruchi Shelar", "Hospital Address : Hinjewadi", "Exp : 4yrs", "Mobile No : 8383838383", "600"},
            {"Doctor Name : Anuj Kadam", "Hospital Address : Pimple Gurav", "Exp : 11yrs", "Mobile No : 8484848484", "1100"},
            {"Doctor Name : Seema Pawar", "Hospital Address : Nigdi", "Exp : 7yrs", "Mobile No : 8585858585", "800"},
            {"Doctor Name : Rohan Desai", "Hospital Address : Baner", "Exp : 5yrs", "Mobile No : 8686868686", "700"},
            {"Doctor Name : Vandana Patil", "Hospital Address : Viman Nagar", "Exp : 15yrs", "Mobile No : 8787878787", "1250"},
            {"Doctor Name : Kavita Gaikwad", "Hospital Address : Kothrud", "Exp : 6yrs", "Mobile No : 8989898989", "850"}
    };

    private String[][] doctor_details5 = {
            {"Doctor Name : Prakash Jadhav", "Hospital Address : Chinchwad", "Exp : 10yrs", "Mobile No : 9191919191", "950"},
            {"Doctor Name : Preeti Doke", "Hospital Address : Pimpri", "Exp : 12yrs", "Mobile No : 9292929292", "1050"},
            {"Doctor Name : Varun Deshmukh", "Hospital Address : Karve Nagar", "Exp : 3yrs", "Mobile No : 9393939393", "600"},
            {"Doctor Name : Rupesh Kale", "Hospital Address : Aundh", "Exp : 8yrs", "Mobile No : 9494949494", "900"},
            {"Doctor Name : Shweta Ingle", "Hospital Address : Pimple Nilakh", "Exp : 5yrs", "Mobile No : 9595959595", "700"},
            {"Doctor Name : Anjali Joshi", "Hospital Address : Wakad", "Exp : 14yrs", "Mobile No : 9696969696", "1200"},
            {"Doctor Name : Rakesh Patil", "Hospital Address : Kharadi", "Exp : 6yrs", "Mobile No : 9797979797", "800"}
    };


    TextView txtView;
    Button btnBack;
    String[][] doctor_details = {};
    ArrayList list;
    HashMap<String, String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        txtView = findViewById(R.id.textViewDDTitle);
        btnBack = findViewById(R.id.DDBtn);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        txtView.setText(title);

        if (title.compareTo("FAMILY PHYSICIAN") == 0)
            doctor_details = doctor_details1;
        else if (title.compareTo("DIETIIAN") == 0)
            doctor_details = doctor_details2;
        else if (title.compareTo("DENTIST") == 0)
            doctor_details = doctor_details3;
        else if (title.compareTo("SURGEON") == 0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctor.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < doctor_details.length; i++) {
            item = new HashMap<String, String>();
            {
                item.put("Line1", doctor_details[i][0]);
                item.put("Line2", doctor_details[i][1]);
                item.put("Line3", doctor_details[i][2]);
                item.put("Line4", doctor_details[i][3]);
                item.put("Line5", "Const Fees:" + doctor_details[i][4] + "/-");
                list.add(item);
            }
            sa = new SimpleAdapter(this, list,
                    R.layout.multi_line,
                    new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                    new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
            );
            ListView lst = findViewById(R.id.DDLstvw);
            lst.setAdapter(sa);
            lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                    Intent it=new Intent(DoctorDetailsActivity.this,BookAppointment.class);
                    it.putExtra("text1",title);
                    it.putExtra("text2",doctor_details[i][0]);
                    it.putExtra("text3",doctor_details[i][1]);
                    it.putExtra("text4",doctor_details[i][3]);
                    it.putExtra("text5",doctor_details[i][4]);
                    startActivity(it);

                }
            });
        }
    }
}