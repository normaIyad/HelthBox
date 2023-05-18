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

public class Available_test extends AppCompatActivity {
    RecyclerView r ;
    Button b ;
    EditText ed ;
    Database mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_test);
        r = findViewById(R.id.recycle_available_test);
        ed = findViewById(R.id.edittext_find_test);
        b = findViewById(R.id.Search_test);

        mDatabase = new Database(this);
        Test c = new Test("Donor Specific Antibodies", "can help improve the success and longevity of transplanted organ");
        mDatabase.addContacts_Test(c);
        Test c1 = new Test("Fasting Blood", "measures the amount of glucose (sugar) present in a person's blood");
        mDatabase.addContacts_Test(c1);
        Test c2 = new Test("Glucose Sugar 22", " check your blood sugar level.");
        mDatabase.addContacts_Test(c2);
        Test c3 = new Test("Interleukin-1beta", " used to measure the level of IL-1β in a person's blood,");
        mDatabase.addContacts_Test(c3);
//        Test c4 = new Test("US", "EEE");
//        mDatabase.addContacts_Test(c4);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        r.setLayoutManager(linearLayoutManager);
        r.setHasFixedSize(true);
        ItemMarginDecoration itemDecoration = new ItemMarginDecoration(getResources().getDimensionPixelSize(R.dimen.item_margin));
        r.addItemDecoration(itemDecoration);
        ArrayList<Test> allContacts = mDatabase.listTest();
        if (allContacts.size() > 0) {
            r.setVisibility(View.VISIBLE);
            TestAdapter mAdapter = new TestAdapter(allContacts);
            r.setAdapter(mAdapter);
        } else {
            r.setVisibility(View.GONE);
            Toast.makeText(this, "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = ed.getText().toString();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                r.setLayoutManager(linearLayoutManager);
                r.setHasFixedSize(true);
                ArrayList<Test> allContacts = mDatabase.listContacts_Found_Test(val);
                if (allContacts.size() > 0) {
                    r.setVisibility(View.VISIBLE);
                    TestAdapter mAdapter = new TestAdapter(allContacts);
                    r.setAdapter(mAdapter);
                } else {
                    r.setVisibility(View.GONE);
                    Toast.makeText(getBaseContext(), "There is no contact in the database. Start adding now", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}