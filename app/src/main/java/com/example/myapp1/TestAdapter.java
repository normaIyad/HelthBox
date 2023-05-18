package com.example.myapp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.test_layout>
{
    ArrayList<Test> Tests ;

    public TestAdapter(ArrayList<Test> tests) {
        Tests = tests;
    }

    @NonNull
    @Override
    public test_layout onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_layout , null , false);
        test_layout c =new test_layout(v);
        return c;
    }

    @Override
    public void onBindViewHolder(@NonNull test_layout holder, int position) {
      Test t = Tests.get(position) ;
      holder.name.setText(t.getName());
      holder.dec.setText(t.getDescription());
    }

    @Override
    public int getItemCount() {
        return Tests.size();
    }


    public class test_layout extends RecyclerView.ViewHolder {
        TextView name , dec ;
        ImageView img ;
        public test_layout(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.contactNameTest);
            dec = itemView.findViewById(R.id.description);
            img = itemView.findViewById(R.id.img_doc);
        }
    }
}
