package com.example.myapp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class log_in_my_results extends AppCompatActivity {
    Button log_in ;
    EditText email , password  , id_number;
    private static int value;
    public static int getValue() {
        return value;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_my_results);
        log_in = findViewById(R.id.login_show_result);
        email = findViewById(R.id.email_show_result);
        password = findViewById(R.id.pass_show_result);
        id_number = findViewById(R.id.id_number_show_result);
        log_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_v = email.getText().toString();
                String pass_of =password.getText().toString();
                String id = password.getText().toString();
                Database db = new Database(getApplicationContext());
                if(email_v.length()==0 || pass_of.length()==0 || id.length()==0 ){
                    Toast.makeText(log_in_my_results.this, "please fell all data", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(db.log_in(email_v ,pass_of)==1){
                        value = Integer.parseInt(id_number.getText().toString().trim());
                        Toast.makeText(log_in_my_results.this, "log in successes", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shard_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("user_email", email_v);
                        editor.apply();
                        Intent intent = new Intent(log_in_my_results.this , Test_files.class);
                        //intent.putExtra("id",id );
                        startActivity(intent);


                }else{
                        Toast.makeText(log_in_my_results.this, "unveiled email or password  ", Toast.LENGTH_SHORT).show();
                    }
           } }
        });



    }
}