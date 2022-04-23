package com.example.smartgarden;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StatusActivity extends AppCompatActivity {

    Button menu;
    TextView status;
    Float hum, temp, mois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        menu = findViewById(R.id.back1);
        status = findViewById(R.id.stats);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("monitoring");

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(StatusActivity.this, MenuActivity.class);
                StatusActivity.this.startActivity(i);
            }
        });



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                hum = snapshot.child("humidity").getValue(Float.class);
                temp = snapshot.child("temperature").getValue(Float.class);
                mois = snapshot.child("moisture").getValue(Float.class);

                if(hum<= 70.0 && mois<= 10){
                    status.setText("Tidak Baik");
                } else if(hum >= 70.00 && mois >= 10) {
                    status.setText("Baik");
                } else {
                    status.setText("Error TV");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(getApplicationContext(),"ERROR FIREBASE",Toast. LENGTH_LONG);
            }
        });



    }
}