package com.example.coincatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_user);
        Button createBud = findViewById(R.id.create_budget);
        final TextView infoText = findViewById(R.id.text_info);
        final Button showInfo = findViewById(R.id.info);
        infoText.setMovementMethod(new ScrollingMovementMethod());

        createBud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent switchAct = new Intent(StartUser.this, Frequency.class);
                Log.v("SHIIIT","YO");
                startActivity(switchAct);


            }});

        showInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(infoText.getVisibility() == View.VISIBLE ) {
                    infoText.setVisibility(View.INVISIBLE);
                }
                else
                {
                    infoText.setVisibility(View.VISIBLE);

                }

            }});
            }



}
