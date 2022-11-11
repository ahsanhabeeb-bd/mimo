package com.example.mimo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button phone_log,mail_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone_log = findViewById(R.id.phone_log);
        mail_log = findViewById(R.id.mail_log);

        phone_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent go_phon_num = new Intent(MainActivity.this,Phone_number.class);
               startActivity(go_phon_num);
            }
        });



    }
}