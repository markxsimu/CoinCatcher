package com.example.coincatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RecurCredit extends AppCompatActivity {

    EditText recur_cred;
    EditText budget_min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recur_credit);
        Button recur_cont = findViewById(R.id.recur_cont);
        recur_cred = findViewById(R.id.recur_credit);
        budget_min = findViewById(R.id.budget_min);

        recur_cont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st1 = recur_cred.getText().toString();
                if (st1.length() > 0) {
                    Toast.makeText(RecurCredit.this, "stuff " + st1, Toast.LENGTH_LONG).show();
                    MainActivity.setRecur(st1);
                }
                else {
                    Toast.makeText(RecurCredit.this, "sorry" + st1, Toast.LENGTH_LONG).show();
                    MainActivity.setRecur("0");
                }
                String st2 = budget_min.getText().toString();
                if (st2.length() > 0) {
                    Toast.makeText(RecurCredit.this, "stuff " + st2, Toast.LENGTH_LONG).show();
                    MainActivity.setBudMin(st2);
                }
                else {
                    Toast.makeText(RecurCredit.this, "sorry" + st2, Toast.LENGTH_LONG).show();
                    MainActivity.setBudMin("0");
                }
                Intent categor = new Intent(RecurCredit.this,Categories.class);
                startActivity(categor);
                finish();



            }
        });

    }
}
