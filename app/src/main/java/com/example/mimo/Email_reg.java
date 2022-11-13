package com.example.mimo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Email_reg extends AppCompatActivity {

    TextInputLayout t1,t2;
    ProgressBar bar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_reg);

        t1 = (TextInputLayout) findViewById(R.id.email);
        t2 = (TextInputLayout) findViewById(R.id.pwd);
        bar = (ProgressBar) findViewById(R.id.progressBar);


    }

    public void signuphere(View view)

    {
        bar.setVisibility(view.VISIBLE);
        String email = t1.getEditText().getText().toString();
        String password = t2.getEditText().getText().toString();

        mAuth = FirebaseAuth.getInstance();


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(Email_reg.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            bar.setVisibility(view.INVISIBLE);
                            t1.getEditText().setText("");
                            t2.getEditText().setText("");
                            Toast.makeText(getApplicationContext(), "suxexful", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Email_reg.this,Profile.class));
                            finish();
                        }
                        else
                        {
                            bar.setVisibility(view.INVISIBLE);
                            t1.getEditText().setText("");
                            t2.getEditText().setText("");
                            Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();

                        }
                    }
                });


    }

}