package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class test_pakeg extends AppCompatActivity {
    RecyclerView recyclerView ;
    private Database db ;
    Button search;
    public static ArrayList<test_pac> data;
    EditText value_of_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_pakeg);
        recyclerView = findViewById(R.id.recycle_find_test_pac1);
        search = findViewById(R.id.findSearchPac1);
        value_of_search = findViewById(R.id.editTextValueSearch1);
        db = new Database(getApplicationContext());
        Database dbHelper = new Database(getApplicationContext());
        test_pac t = new test_pac("Annual wellness visit","to create or update a personalized prevention plan. This plan may help prevent illness based on your current health and risk factors") ;
        dbHelper.add_test_pac(t);
        test_pac t1 = new test_pac("Blood tests","such as cholesterol and blood sugar levels") ;
        db.add_test_pac(t1);
        test_pac t2 = new test_pac("Bone density tests","uses low dose X-rays to see how dense (or strong) your bones are.") ;
        db.add_test_pac(t2);
        test_pac t3 = new test_pac("Colonoscopies","s an exam used to look for changes — such as swollen, irritated tissues, polyps or cancer — in the large intestine (colon) and rectum.") ;
        db.add_test_pac(t3);
        test_pac t4 = new test_pac("Mammograms","an X-ray picture of the breast") ;
        db.add_test_pac(t4);
        test_pac t5 = new test_pac("Prostate-specific antigen (PSA) test","for prostate cancer screening") ;
        db.add_test_pac(t5);
        test_pac t6 = new test_pac("Cardiovascular tests","such as electrocardiograms, stress tests, and echocardiograms");
        db.add_test_pac(t6);
        data = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        ItemMarginDecoration itemDecoration = new ItemMarginDecoration(getResources().getDimensionPixelSize(R.dimen.item_margin));
        recyclerView.addItemDecoration(itemDecoration);
        ArrayList<test_pac> allContacts = db.listTest_pac();
        if (allContacts.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            test_pac_add mAdapter = new test_pac_add(allContacts);
            recyclerView.setAdapter(mAdapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(value_of_search.getText().toString().length()==0){
                    Toast.makeText(test_pakeg.this, "please add value to search", Toast.LENGTH_SHORT).show();
                }
                String va = value_of_search.getText().toString();
                data = new ArrayList<>();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(test_pakeg.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setHasFixedSize(true);
                ItemMarginDecoration itemDecoration = new ItemMarginDecoration(getResources().getDimensionPixelSize(R.dimen.item_margin));
                recyclerView.addItemDecoration(itemDecoration);
                ArrayList<test_pac> allContacts = db.listTest_pac_search(va);
                if (allContacts.size() > 0) {
                    recyclerView.setVisibility(View.VISIBLE);
                    test_pac_add mAdapter = new test_pac_add(allContacts);
                    recyclerView.setAdapter(mAdapter);
                } else {
                    recyclerView.setVisibility(View.GONE);
                    Toast.makeText(test_pakeg.this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}