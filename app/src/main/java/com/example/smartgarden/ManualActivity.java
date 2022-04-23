package com.example.smartgarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ManualActivity extends AppCompatActivity {

    Button menu, light_on, light_off, pump_on, pump_off, fan_on, fan_off;
    SeekBar con_ex, con_pump;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        menu = findViewById(R.id.back3);
        light_off = findViewById(R.id.lightoff);
        light_on = findViewById(R.id.lighton);
        con_ex = findViewById(R.id.bar_ex);
        con_pump = findViewById(R.id.bar_pump);
        pump_on = findViewById(R.id.pumpon);
        pump_off = findViewById(R.id.pumpoff);
        fan_on = findViewById(R.id.fanon);
        fan_off = findViewById(R.id.fanoff);


        //Menu
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ManualActivity.this, MenuActivity.class);
                ManualActivity.this.startActivity(i);
            }
        });

        //--------------------------FIREBASE------------------------------------------
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("mode");
        myRef.setValue(1); // MODE

        //LIGHT ON
        light_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference lion = database.getReference("control").child("ledState");
                lion.setValue(1);
            }
        });

        //LIGHT OFF
        light_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference lioff = database.getReference("control").child("ledState");
                lioff.setValue(0);
            }
        });

        //CONTROL FAN
        con_ex.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                DatabaseReference myRef3 = database.getReference("control").child("fanSpeed");
                myRef3.setValue(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //CONTROL PUMP
        con_pump.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                DatabaseReference myRef4 = database.getReference("control").child("pumpSpeed");
                myRef4.setValue(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        //PUMP ON
        pump_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference puon = database.getReference("control").child("pumpState");
                puon.setValue(1);
            }
        });

        //PUMP OFF
        pump_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference puoff = database.getReference("control").child("pumpState");
                puoff.setValue(0);
            }
        });


        //FAN ON
        fan_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference fanon = database.getReference("control").child("fanState");
                fanon.setValue(1);
            }
        });

        //FAN OFF
        fan_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference fanoff = database.getReference("control").child("fanState");
                fanoff.setValue(0);
            }
        });

    }

}