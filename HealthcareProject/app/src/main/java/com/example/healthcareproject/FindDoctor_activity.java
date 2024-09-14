package com.example.healthcareproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class FindDoctor_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit= findViewById(R.id.cardBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctor_activity.this,Home_activity.class));


            }
        });

        CardView familyPhysician= findViewById(R.id.cardFamilyPhysicains);
        familyPhysician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctor_activity.this,Home_activity.class));
                Intent i= new Intent(FindDoctor_activity.this,DoctorDetails_activity.class);
                i.putExtra("title","Family Physicians");
            }
        });

        CardView dieteician= findViewById(R.id.cardDietation);
        dieteician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctor_activity.this,Home_activity.class));
                Intent i= new Intent(FindDoctor_activity.this,DoctorDetails_activity.class);
                i.putExtra("title","Dietician");
            }
        });

        CardView dentist= findViewById(R.id.cardDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctor_activity.this,Home_activity.class));
                Intent i= new Intent(FindDoctor_activity.this,DoctorDetails_activity.class);
                i.putExtra("title","Dentist");
            }
        });
        CardView surgeon= findViewById(R.id.cardSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctor_activity.this,Home_activity.class));
                Intent i= new Intent(FindDoctor_activity.this,DoctorDetails_activity.class);
                i.putExtra("title","Surgeon");
            }
        });
        CardView cardiologist= findViewById(R.id.cardCardiologist);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindDoctor_activity.this,Home_activity.class));
                Intent i= new Intent(FindDoctor_activity.this,DoctorDetails_activity.class);
                i.putExtra("title","Cardiologist");
            }
        });
    }
}