package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.Calendar;

public class BookAppointment extends AppCompatActivity {
    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    Button dateButton, timeButton,btnBack,btnBook;
    private int selectedHour, selectedMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv = findViewById(R.id.BATitle);
        ed1 = findViewById(R.id.BAName);
        ed2 = findViewById(R.id.BAAdd);
        ed3 = findViewById(R.id.BACon);
        ed4 = findViewById(R.id.BACfee);
        dateButton = findViewById(R.id.BAbtnDate);
        timeButton = findViewById(R.id.BAbtnTime);
        btnBack=findViewById(R.id.BABtnBk);
        btnBook=findViewById(R.id.BABtn);

        // Set fields to read-only
        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        // Extract data from the Intent
        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullName = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        // Populate fields
        tv.setText(title);
        ed1.setText(fullName);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText("Cons Fees " + fees + " /-");

        // Initialize DatePicker and TimePicker
        initDatePicker();
        initTimePicker();

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BookAppointment.this,FindDoctor.class));
            }
        });

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    private void initDatePicker() {
        dateButton.setOnClickListener(v -> {
            DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month + 1; // Month is 0-based
                    String date = dayOfMonth + "/" + month + "/" + year;
                    dateButton.setText(date);
                }
            };

            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    this,
                    dateSetListener,
                    year, month, day);

            datePickerDialog.show();
        });
    }

    private void initTimePicker() {
        timeButton.setOnClickListener(v -> {
            TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    selectedHour = hourOfDay;
                    selectedMinute = minute;
                    String time = String.format("%02d:%02d", selectedHour, selectedMinute);
                    timeButton.setText(time);
                }
            };

            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(
                    this,
                    timeSetListener,
                    hour, minute,
                    true); // true for 24-hour format

            timePickerDialog.show();
        });
    }
}
