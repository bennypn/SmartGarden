package com.example.smartgarden;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btn_stats, btn_man, btn_oto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btn_man = findViewById(R.id.manual_btn);
        btn_oto = findViewById(R.id.otomatis_btn);
        btn_stats = findViewById(R.id.status_btn);

        btn_man.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this, ManualActivity.class);
                MenuActivity.this.startActivity(i);

            }
        });

        btn_oto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this, OtomatisActivity.class);
                MenuActivity.this.startActivity(i);
            }
        });

        btn_stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MenuActivity.this, StatusActivity.class);
                MenuActivity.this.startActivity(i);

            }
        });
    }
}