package com.test.covidassesment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class QuestionStartActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int REQUEST_PHONE_CALL = 1;
    Button next;
    public static int score = 0;
    Fragment fragment;
    int count = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_start);
         fragment = new Question1Fragment();
        transit(fragment);
        next = findViewById(R.id.nextBtn);
        next.setOnClickListener(this);
        score=0;

    }
    @Override
    public void onClick(View v) {
        count++;
        if(count==2){
            fragment = new Question2Fragment();
            transit(fragment);
             score+=Question1Fragment.t;
        }
        else if(count==3){
            fragment = new Question3Fragment();
            transit(fragment);
            score+=Question2Fragment.t2;
        }
        else if(count==4){
            fragment = new Question4Fragment();
            transit(fragment);
            score+=Question3Fragment.t3;
        }
        else if(count==5){
            fragment = new Question5Fragment();
            transit(fragment);
            score+=Question4Fragment.t4;
            next.setText("Submit");
        }
//        else if(count==6){
//            score+=Question5Fragment.t5;
//            AlertDialog.Builder builder = new AlertDialog.Builder(this);
//            builder.setTitle("Your Score is : ");
//            builder.setMessage(score+"");
//            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                @Override
//                public void onClick(DialogInterface dialog, int which) {
//                    finish();
//                    Intent intent = new Intent(QuestionStartActivity.this,MainActivity.class);
//                    startActivity(intent);
//                    score = 0;
//                }
//            });
//            AlertDialog alertDialog = builder.create();
//            alertDialog.show();
//        }
        else if(count==6){
            if(score >10){
                fragment = new danger();
                transit(fragment);
                next.setText("Medicalhelpline");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navigateToHelpline();
                    }
                });

            }
            else
            {
                fragment = new Safe();
                transit(fragment);
                next.setText("HOME");
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
                    }
                });
            }
        }
    }
    private void navigateToHelpline() {
        String number = "+18337844397";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ContextCompat.checkSelfPermission(QuestionStartActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(QuestionStartActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }else {
            startActivity(intent);
        }
    }
    void transit(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.framelayoutid,fragment);
        transaction.commit();
    }
}
