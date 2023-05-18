package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class Appointments extends AppCompatActivity {
    EditText  name , id_num ,address , co_name , doctor_name ,phone_num   ;
    Spinner test , ptest;
    RadioButton selectedRadioButton ;
    Button dates , done ;
    RadioGroup radioGroup;
    meeting me ;
    String da;
    int  button_click;
    String test_men[] = {  "select Test",  " Donor Specific Antibodies" ,
    "Fasting Blood" , "Glucose Sugar 22", "Interleukin-1beta "};
    String tests_pac []={"select Test Packages","Examinations of a healthy child",
    "Dear poultry" ,  "Unital Corporation " , "lab" ,
    "Vitamins and blood strength ",
    "Comprehensive screening campaign ",
    " National Beverage Campaign"
    };
    boolean is_date ;
    Database db = new Database(Appointments.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);
        dates = findViewById(R.id.meeting_date);
        done = findViewById(R.id.regest);
        name = findViewById(R.id.meet_username);
        id_num = findViewById(R.id.number);
        address = findViewById(R.id.address);
        co_name = findViewById(R.id.compony_name);
        doctor_name = findViewById(R.id.doctor_name);
        phone_num = findViewById(R.id.register_phone);
        test = (Spinner) findViewById(R.id.spinner);
        ptest =(Spinner) findViewById(R.id.spinner2);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        ArrayAdapter<String> adapter;
        adapter= new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,test_men);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        test.setAdapter(adapter);
        test.setSelection(0);
        ArrayAdapter<String> array_test_pac;
        array_test_pac= new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,tests_pac);
        array_test_pac.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item );
        ptest.setAdapter(array_test_pac);
        ptest.setSelection(0);
        dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                button_click++;
                Toast.makeText(Appointments.this, button_click+" ", Toast.LENGTH_SHORT).show();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                         Appointments.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                dates.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                                String da = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year ;
                            }
                        },
                        year, month, day);
                datePickerDialog.show();
            }
        });


        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedRbText = null;
                int selectedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                if (selectedRadioButtonId != -1) {
                    selectedRadioButton = findViewById(selectedRadioButtonId);
                    selectedRbText = selectedRadioButton.getText().toString();
                   } else {
                    selectedRbText = "in lap";
                }
                String name_v = name.getText().toString();
                String id_n = id_num.getText().toString();
                String address_v = address.getText().toString();
                String co = co_name.getText().toString();
                String d_name = doctor_name.getText().toString();
                String test_v = test.getSelectedItem() != null ? test.getSelectedItem().toString() : "";
                String ptest_v = ptest.getSelectedItem() != null ? ptest.getSelectedItem().toString() : "";
                String ph =phone_num.getText().toString();
                me = new meeting(name_v ,Integer.parseInt(id_n) , address_v , co , d_name , da,Integer.parseInt(ph), selectedRbText ,test_v ,ptest_v);
                if(checkFormFields() == false){
                    Toast.makeText(Appointments.this, "fill all data  or in valid date ", Toast.LENGTH_SHORT).show();
                }else {
                    db.meeting(me);
                    Toast.makeText(Appointments.this, "Done", Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(Appointments.this ,appointment_Done.class));
                }
            }
        });
    }
    private boolean checkFormFields() {
        EditText meetUsername = findViewById(R.id.meet_username);
        EditText number = findViewById(R.id.number);
        EditText address = findViewById(R.id.address);
        EditText componyName = findViewById(R.id.compony_name);
        EditText doctorName = findViewById(R.id.doctor_name);
        EditText registerPhone = findViewById(R.id.register_phone);

        if (TextUtils.isEmpty(meetUsername.getText().toString())) {
            //meetUsername.setError("Please enter your name");
            return false;
        }

        if (TextUtils.isEmpty(number.getText().toString())) {
           // number.setError("Please enter your ID number");
            return false;
        }

        if (TextUtils.isEmpty(address.getText().toString())) {
            //address.setError("Please enter your address");
            return false;
        }

        if (TextUtils.isEmpty(componyName.getText().toString())) {
            //componyName.setError("Please enter your company name");
            return false;
        }

        if (TextUtils.isEmpty(doctorName.getText().toString())) {
            //doctorName.setError("Please enter your doctor name");
            return false;
        }

        if (TextUtils.isEmpty(registerPhone.getText().toString())) {
            //registerPhone.setError("Please enter your phone number");
            return false;
        }

        return true;
    }


}