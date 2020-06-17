package com.test.covidassesment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class HotspotActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotspot);
    }
    public void browser1(View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coronatracker.com/country/us/"));
        startActivity(browserIntent);
    }
    public void browser2(View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coronatracker.com/country/ca/"));
        startActivity(browserIntent);
    }
    public void browser3(View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coronatracker.com/country/ru/"));
        startActivity(browserIntent);
    }
    public void browser4(View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coronatracker.com/country/in/"));
        startActivity(browserIntent);
    }
    public void browser5(View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coronatracker.com/country/gb/"));
        startActivity(browserIntent);
    }
    public void browser6(View view){
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.coronatracker.com"));
        startActivity(browserIntent);
    }
}