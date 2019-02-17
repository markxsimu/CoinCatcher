package com.example.coincatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Categories extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button cat_cont;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        spinner = findViewById(R.id.spinner_categories);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.cat_spin_item, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        cat_cont = findViewById(R.id.button_cat_cont);
        cat_cont.setEnabled(false);
        cat_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String save_type = spinner.getSelectedItem().toString();
                //Toast.makeText(Frequency.this,"stuff " + save_type,Toast.LENGTH_LONG).show();
                //MainActivity.setFreq(save_type);
                //Intent recur = new Intent(Categories.this, MainActivity.class);
                //startActivity(recur);
                finish();
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(spinner.getSelectedItemPosition()>0)
        {
            cat_cont.setEnabled(true);
        }
        else
        {
            cat_cont.setEnabled(false);
        }    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
