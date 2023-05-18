package com.example.myapp1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

;

public class testfileadd extends RecyclerView.Adapter<testfileadd.test> {
   ArrayList<TestResult> testResults ;
   Context c ;

    public testfileadd(ArrayList<TestResult> testResults, Context c) {
        this.testResults = testResults;
        this.c = c;
    }

    @NonNull
    @Override
    public test onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.files_show , parent , false);
        test c = new test(v);
        return (c);
    }
    @Override
    public void onBindViewHolder(@NonNull test holder,  int position) {
        TestResult ts = testResults.get(position);
        holder.name.setText(ts.getName());
        holder.date.setText(ts.getDate());
        holder.ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(c, "name "+ ts.getName() , Toast.LENGTH_SHORT).show();
                //Intent i = new Intent()
                Intent intent = new Intent(c , PDF.class);
                String Data = ts.getName();
                intent.putExtra("file", Data);
                c.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return testResults.size();
    }
    public class test extends RecyclerView.ViewHolder {
        TextView name , date ;

      // ConstraintLayout constraintLayout ;
        LinearLayout ln ;
        public test(@NonNull View itemView ) {
            super(itemView);
            name = itemView.findViewById(R.id.name_file);
            date = itemView.findViewById(R.id.date_file);
            ln = itemView.findViewById(R.id.layout);
        }
    }
}
