package com.test.covidassesment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progressBar;
    EditText emailId, password;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailId=findViewById(R.id.editText);
        password=findViewById(R.id.editText2);
        progressBar=findViewById(R.id.progressbar);

        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.textView).setOnClickListener(this);
    }

    private void registerUser(){
        String Email=emailId.getText().toString().trim();
        String Password=password.getText().toString().trim();
        if(Email.isEmpty()){
            emailId.setError("Email id required");
            emailId.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            emailId.setError("Please enter a valid Email");
            emailId.requestFocus();
            return;
        }

        if(Password.isEmpty()){
            password.setError("password id required");
            password.requestFocus();
            return;
        }
        if(Password.length()<6){
            password.setError("Minimum length of Password should be 6");
            password.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    finish();
                    Intent intent=new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "You already registered", Toast.LENGTH_SHORT).show();

                    }else {

                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }


    @Override
    public void onClick(View view) {
        switch(view.getId())  {

            case R.id.button2:

                registerUser();

                break;

            case R.id.textView:
                finish();

                startActivity(new Intent(this, LoginActivity.class));

                break;

        }

    }
}