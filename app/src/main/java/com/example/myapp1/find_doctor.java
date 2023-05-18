package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class find_doctor extends AppCompatActivity {
     RecyclerView rc ;
    private Database mDatabase ;
     Button search;
     EditText value_of_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        rc = findViewById(R.id.recycle_find_doctor);
        RecyclerView contactView = findViewById(R.id.recycle_find_doctor);
        search = (Button) findViewById(R.id.foindSerch);
        value_of_search = findViewById(R.id.editTextValueSearch);
        mDatabase = new Database(this);
//        Doctor doctor1 = new Doctor("Jane Doe","","","", "Pediatrician");
//        Doctor doctor2 = new Doctor("Robert Johnson", "Dentist");
//        Doctor doctor3 = new Doctor("Emily Wilson", "Neurologist");
//        Doctor doctor4 = new Doctor("Michael Chen", "Oncologist");
//        Doctor doctor5 = new Doctor("Maria Rodriguez", "Cardiologist");
//
//        Doctor c = new Doctor("mo", "0594425736", "AAAAAAA");
//        mDatabase.addContacts(c);
//        Doctor c1 = new Doctor("noor", "06", "BBBB");
//        mDatabase.addContacts(c1);
//        Doctor c2 = new Doctor("Saleh", "06", "DDDD");
//        mDatabase.addContacts(c2);
//        Doctor c3 = new Doctor("Sa", "USA", "AAA");
//        mDatabase.addContacts(c3);
//        Doctor c4 = new Doctor("Saleh", "US", "EEE");
//        mDatabase.addContacts(c4);
        Doctor doctor1 = new Doctor("Jane Doe", "123456789", "New York City", "New York City", "Dermatologist");
        Doctor doctor2 = new Doctor("Bob Johnson", "987654321", "Los Angeles", "Los Angeles", "Psychiatrist");
        Doctor doctor3 = new Doctor("Sarah Lee", "5551234567", "Chicago", "Chicago", "Pediatrician");
        Doctor doctor4 = new Doctor("David Lee", "5559876543", "Houston", "Houston", "Cardiologist");
        Doctor doctor5 = new Doctor("Emily Smith", "1112223333", "Philadelphia", "Philadelphia", "Oncologist");
        mDatabase.addContacts(doctor1);
        mDatabase.addContacts(doctor2);
        mDatabase.addContacts(doctor3);
        mDatabase.addContacts(doctor4);
        mDatabase.addContacts(doctor5);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(linearLayoutManager);
        rc.setHasFixedSize(true);
        ArrayList<Doctor> allContacts = mDatabase.listContacts();
        if (allContacts.size() > 0) {
            rc.setVisibility(View.VISIBLE);
            Doctor_adppter mAdapter = new Doctor_adppter(allContacts);
            rc.setAdapter(mAdapter);
        } else {
            rc.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = value_of_search.getText().toString();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                rc.setLayoutManager(linearLayoutManager);
                ItemMarginDecoration itemDecoration = new ItemMarginDecoration(getResources().getDimensionPixelSize(R.dimen.item_margin));
                rc.addItemDecoration(itemDecoration);
                rc.setHasFixedSize(true);
                ArrayList<Doctor> allContacts = mDatabase.listContacts_Found(val);
                if (allContacts.size() > 0) {
                    rc.setVisibility(View.VISIBLE);
                    Doctor_adppter mAdapter = new Doctor_adppter(allContacts);
                    rc.setAdapter(mAdapter);
                } else {
                    rc.setVisibility(View.GONE);
                    Toast.makeText(getBaseContext(), "There is no doctor with value of " + val, Toast.LENGTH_LONG).show();
                }
            }
        });

////
// Doctor c = new Doctor("mo","0594425736" ,"AAAAAAA");
//        mDatabase.addContacts(c);
//        Doctor c1= new Doctor("noor","06","BBBB");
//        mDatabase.addContacts(c1);
//        Doctor c2= new Doctor("Saleh","06","DDDD");
//        mDatabase.addContacts(c2);
//         Doctor c3= new Doctor("Sa","USA","AAA");
//        mDatabase.addContacts(c3);
//        Doctor c4= new Doctor("Saleh","US","EEE");
//        mDatabase.addContacts(c4);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        rc.setLayoutManager(linearLayoutManager);
//        rc.setHasFixedSize(true);
//        ArrayList<Doctor> allContacts ;
//        allContacts = mDatabase.listContacts();
//        if (allContacts.size() > 0) {
//            rc.setVisibility(View.VISIBLE);
//            ContactAdapter mAdapter = new ContactAdapter(this, allContacts);
//            rc.setAdapter(mAdapter);
//        }
//        else {
//            rc.setVisibility(View.GONE);
//            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
//        }
//        search.setOnClickListener(new View.OnClickListener() {
//         @Override
//        public void onClick(View v) {
//             String val = value_of_search.getText().toString();
//             LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
//             rc.setLayoutManager(linearLayoutManager);
//
//             rc.setHasFixedSize(true);
//             ArrayList<Doctor> allContacts = mDatabase.listContacts_Found(val);
//             if (allContacts.size() > 0) {
//                 rc.setVisibility(View.VISIBLE);
//                 ContactAdapter mAdapter = new ContactAdapter(getApplicationContext(), allContacts);
//                 rc.setAdapter(mAdapter);
//            }
//             else {
//                 rc.setVisibility(View.GONE);
//                 Toast.makeText(getBaseContext(), "There is no doctor with value of " + val , Toast.LENGTH_LONG).show();
//             }
//         }
//     });


    }
}