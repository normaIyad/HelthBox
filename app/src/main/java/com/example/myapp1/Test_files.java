package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Test_files extends AppCompatActivity {
    RecyclerView recyclerView;
    Database db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_files);
        recyclerView = findViewById(R.id.recycle_My_results);
        db = new Database(this);
//        TestResult t  = new TestResult("noor3",18 , "16/5/2023",56 ,101 );
//        db.addfile(t);
//        TestResult t1  = new TestResult("noor2",19 , "15/5/2023",55,11 );
//        db.addfile(t1);
//        TestResult t3  = new TestResult("noor1",20 , "15/5/2023",57 ,121 );
//        db.addfile(t3);
//        TestResult t4  = new TestResult("noor",21 , "15/5/2023",57 ,121 );
//        db.addfile(t4);
//        TestResult t5  = new TestResult("test1",29 , "15/5/2023",57 ,121 );
//        db.addfile(t5);
//        TestResult t6  = new TestResult("test2",30 , "15/5/2023",57 ,121 );
//        db.addfile(t6);
//        TestResult t7  = new TestResult("test3",33 , "15/5/2023",57 ,121 );
//        db.addfile(t7);
//        TestResult t8  = new TestResult("test1",34 , "15/5/2023",57 ,121 );
//        db.addfile(t8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        ItemMarginDecoration itemDecoration = new ItemMarginDecoration(getResources().getDimensionPixelSize(R.dimen.item_margin));
        recyclerView.addItemDecoration(itemDecoration);

        int s =log_in_my_results.getValue();
//        int s = 57;
        Toast.makeText(this, "string : "+ s, Toast.LENGTH_SHORT).show();
        ArrayList<TestResult> allContacts = db.listContacts_file(s);
        if (allContacts.size() > 0) {
            recyclerView.setVisibility(View.VISIBLE);
            testfileadd mAdapter = new testfileadd(allContacts ,Test_files.this );
            recyclerView.setAdapter(mAdapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
    }
}