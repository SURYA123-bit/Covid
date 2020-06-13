package com.test.covidassesment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class PrecautionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precautions);

        ViewPager vp = findViewById(R.id.viewpager);
        PagerAdapter pA = new PagerAdapter(getSupportFragmentManager());
        vp.setAdapter(pA);

        TabLayout tL = findViewById(R.id.sliding_tabs);
        tL.setupWithViewPager(vp);


    }
}