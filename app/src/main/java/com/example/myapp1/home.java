package com.example.myapp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class home extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    Button logout;
    TextView meeting;
    TextView my_res , packages , found , tests , ask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        logout = findViewById(R.id.button_logout);
        meeting = findViewById(R.id.textViewAppointments);
        my_res = findViewById(R.id.textViewMyResults);
        packages = findViewById(R.id.textViewPackages);
        found =findViewById(R.id.textViewfind);
        tests = findViewById(R.id.textViewmyResult1);
        ask = findViewById(R.id.textViewAsk_me);
        sharedPreferences =getSharedPreferences("shard_pref", Context.MODE_PRIVATE);
        String email =sharedPreferences.getString("user_email" , "").toString();
        Toast.makeText(this, "welcome"+ email, Toast.LENGTH_SHORT).show();
        tests.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this , Available_test.class));
            }
        });
       ask.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(home.this , ask_me.class));
           }
       });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
                Toast.makeText(getApplicationContext(), "log out ", Toast.LENGTH_SHORT).show();
            }
        });
     found.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(home.this , find_doctor.class));
         }
     });
     meeting.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(home.this , Appointments.class));
         }
     });
        packages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this , test_pakeg.class));
            }
        });
        my_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(home.this , log_in_my_results.class));
            }
        });
    }
    /* TODO: 16/04/2023 */






    private void logout() {
       SharedPreferences.Editor editor= sharedPreferences.edit();
       editor.clear();
       editor.apply();
       startActivity(new Intent(home.this , MainActivity.class) );
    }
}