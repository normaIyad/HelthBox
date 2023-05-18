package com.example.myapp1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class test_pac_add extends RecyclerView.Adapter<test_pac_add.ViewHolder> {
    ArrayList<test_pac> Tests ;

    public test_pac_add(ArrayList<test_pac> tests) {
        Tests = tests;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_pac , null , false);
        ViewHolder c =new ViewHolder(v);
        return c;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        test_pac t = Tests.get(position) ;
        holder.name.setText(t.getName());
        holder.dec.setText(t.getDrs());
    }

    @Override
    public int getItemCount() {
        return Tests.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name , dec ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.contactNameTest_pac);
            dec = itemView.findViewById(R.id.description_pac);
        }
    }
}
