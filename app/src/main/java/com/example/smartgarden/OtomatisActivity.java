package com.example.smartgarden;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OtomatisActivity extends AppCompatActivity {

    Button menu;
    TextView humtv, moistv, temptv;
    Float mois, hum, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otomatis);

        menu = findViewById(R.id.back2);
        humtv = findViewById(R.id.hum_tv);
        moistv = findViewById(R.id.mois_tv);
        temptv = findViewById(R.id.temp_tv);

        //MENU

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OtomatisActivity.this, MenuActivity.class);
                OtomatisActivity.this.startActivity(i);
            }
        });

        //FIREBASE
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference myRef2 = database.getReference("mode");
        myRef2.setValue(0);

        DatabaseReference myRef = database.getReference();

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                hum = snapshot.child("monitoring").child("humidity").getValue(Float.class);
                temp = snapshot.child("monitoring").child("temperature").getValue(Float.class);
                mois = snapshot.child("monitoring").child("moisture").getValue(Float.class);

                String hh = Float.toString(hum);
                String tt = Float.toString(temp);
                String mm = Float.toString(mois);

                humtv.setText(hh);
                temptv.setText(tt);
                moistv.setText(mm);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}