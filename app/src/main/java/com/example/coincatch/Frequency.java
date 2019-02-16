package com.example.coincatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Frequency extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button freq_cont;

    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_frequency);

        spinner = findViewById(R.id.spinner_frequency);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.freq_spin_item,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        freq_cont = findViewById(R.id.button_freq_cont);
        freq_cont.setEnabled(false);

        freq_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String save_type = spinner.getSelectedItem().toString();
                //Toast.makeText(Frequency.this,"stuff " + save_type,Toast.LENGTH_LONG).show();
                MainActivity.setFreq(save_type);

            }
        });




/*
        freq_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.setFreq(spinner.getSelectedItem().toString());

                Intent switchAct = new Intent(Frequency.this, MainActivity.class);
                startActivity(switchAct);


            }});
*/

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      if(spinner.getSelectedItemPosition()>0)
      {
          freq_cont.setEnabled(true);
      }
      else
      {
          freq_cont.setEnabled(false);
      }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        freq_cont.setEnabled(false);
    }
}
