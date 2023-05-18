package com.example.myapp1;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText name , number , email , pass1 , pass2  ;
    Button reg ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        name = findViewById(R.id.register_username);
        number =findViewById(R.id.register_phone);
        email =findViewById(R.id.register_email);
        pass1 =findViewById(R.id.register_pass1);
        pass2=findViewById(R.id.register_pass2);
        reg=findViewById(R.id.register_login_btn);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Database db = new Database(getApplicationContext());
                String name_u =name.getText().toString();
                String number_u = number.getText().toString();
                String email_u =email.getText().toString();
                String pass_u =pass1.getText().toString();
                String pass2_u =pass2.getText().toString();
                User user = new User(name_u , email_u , pass_u , pass2_u , Integer.parseInt(number_u));
                if(name_u.length()==0 || number_u.length()==0 || email_u.length()==0||pass_u.length()==0||pass2_u.length()==0){
                    Toast.makeText(MainActivity2.this, "please full the data", Toast.LENGTH_SHORT).show();
                }else {
                    if(pass_u.compareTo(pass2_u)==0){
                        if(isValidPassword(pass_u)){
                            db.register(user);
                            Toast.makeText(MainActivity2.this, "Record Inserted ", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(MainActivity2.this ,MainActivity.class));
                        }else {
                            Toast.makeText(MainActivity2.this, "its not voled password  ", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity2.this, "password not matches", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
    public static boolean isValidPassword(String password)
    {
        boolean isValid = true;
        if (password.length() > 15 || password.length() < 8)
        {
            isValid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars ))
        {
            isValid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars ))
        {
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers ))
        {
            isValid = false;
        }
        String specialChars = "(.*[@,#,$,%].*$)";
        if (!password.matches(specialChars ))
        {
            isValid = false;
        }
        return isValid;
    }
}