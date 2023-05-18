package com.example.myapp1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Doctor_adppter extends RecyclerView.Adapter<Doctor_adppter.Doctor_layout> {

    private ArrayList<Doctor> listContacts;

    public Doctor_adppter(ArrayList<Doctor> listContacts) {
        this.listContacts = listContacts;
    }

    @NonNull
    @Override
    public Doctor_layout onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list_layout, null, false);
        Doctor_layout c = new Doctor_layout(view);
        return (c);
    }

    @Override
    public void onBindViewHolder(@NonNull Doctor_layout holder, int position) {
      Doctor c =listContacts.get(position);
      holder.tvName.setText(c.getName());
      holder.tvPhoneNum.setText(c.getPhoneNumber());
      holder.add2.setText(c.getAddress());
//      holder.address.setText(c.getCity());

    }

    @Override
    public int getItemCount() {
        return listContacts.size();
    }

    public class Doctor_layout extends RecyclerView.ViewHolder {
        public TextView tvName;
        public TextView tvPhoneNum;
        public TextView address , add2  , spa;
        public Doctor_layout(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.contactName);
            tvPhoneNum = itemView.findViewById(R.id.phoneNum);
            address = itemView.findViewById(R.id.address);
            add2 = itemView.findViewById(R.id.address2);

        }
    }
}
