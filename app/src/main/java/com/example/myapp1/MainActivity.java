package com.example.myapp1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button log , reg ;
    EditText email , pass ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log =findViewById(R.id.login_loginop);
        reg =findViewById(R.id.login_regester);
        email=findViewById(R.id.login_email);
        pass =findViewById(R.id.login_pass);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String u_email = email.getText().toString();
                String pass_of =pass.getText().toString();
//                startActivity(new Intent(MainActivity.this , home.class));
                Database db = new Database(getApplicationContext());
                if(u_email.length()==0 || pass_of.length()==0){
                    Toast.makeText(MainActivity.this, "please fell all data", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(db.log_in(u_email ,pass_of)==1){
                Toast.makeText(MainActivity.this, "log in successes", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences = getSharedPreferences("shard_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        startActivity(new Intent(MainActivity.this , home.class));
                        editor.putString("user_email", u_email);
                        editor.apply();
                        startActivity(new Intent(MainActivity.this , home.class));
                }else{
                        Toast.makeText(MainActivity.this, "unveiled email or password  ", Toast.LENGTH_SHORT).show();
                    }

           }
        }});
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , MainActivity2.class));
            }
        });
    }
}