package com.test.covidassesment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_PHONE_CALL = 1;
    ImageView profileImage;
    Button btnHelpline;
    ImageButton imgBtnHealthcheck,imgBtnHotspots,imgBtnPrecautions,imgBtnSymptoms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        profileImage = findViewById(R.id.imageView2);
        profileImage.setOnClickListener(this);
        btnHelpline = findViewById(R.id.btnHelpline);
        btnHelpline.setOnClickListener(this);
        imgBtnHealthcheck = findViewById(R.id.imgBtnHealthcheck);
        imgBtnHotspots= findViewById(R.id.imgBtnHotspots);
        imgBtnPrecautions= findViewById(R.id.imgBtnPrecautions);
        imgBtnSymptoms= findViewById(R.id.imgBtnSymptoms);
        imgBtnHealthcheck.setOnClickListener(this);
        imgBtnHotspots.setOnClickListener(this);
        imgBtnPrecautions.setOnClickListener(this);
        imgBtnSymptoms.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageView2:
                startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                break;
            case R.id.btnHelpline:
                navigateToHelpline();
                break;
            case R.id.imgBtnHealthcheck:
                startActivity(new Intent(getApplicationContext(),QuestionStartActivity.class));
                break;
            case R.id.imgBtnHotspots:
                startActivity(new Intent(getApplicationContext(),HotspotActivity.class));
                break;
            case R.id.imgBtnPrecautions:
                startActivity(new Intent(getApplicationContext(),PrecautionsActivity.class));
                break;
            case R.id.imgBtnSymptoms:
                startActivity(new Intent(getApplicationContext(),SymptomsActivity.class));
                break;

        }
    }

    private void navigateToHelpline() {
        String number = "4383341844";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));

        if (ContextCompat.checkSelfPermission(HomeActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(HomeActivity.this, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
        }else {
            startActivity(intent);
        }
    }
}
