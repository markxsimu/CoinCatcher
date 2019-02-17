package com.example.coincatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;

public class MainActivity extends AppCompatActivity {
    private static String FILE_NAME = "config.txt";
    private static String new_user = null;
    private static String save_type = null;
    private static String recur_cred = null;
    private static String budget_min = null;
    private static String trck_amt = null;

    EditText mEditText;

    public static void setFreq(String freq)
    {
        save_type = freq;
    }
    public static void setRecur(String recur) { recur_cred = recur; }
    public static void setBudMin(String min) { budget_min = min; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.edit_text);

        File cfg = new File(getFilesDir(),FILE_NAME);
        if(!cfg.exists()) {
            newFile();
            startUser();
        }
        else
        {
            readCfg();
        }
    }

    private void startUser() {
        Intent switchAct = new Intent(this,StartUser.class);
        startActivity(switchAct);
    }

    public void readCfg()
    {
        FileInputStream fis = null;
        try{
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String text;
            while ((text = br.readLine()) != null)
            {
                if(text == "new_user")
                {
                    new_user = text;
                }
                else if (text == "save_type")
                {
                    save_type = text;
                }
                else if (text == "recur_cred")
                {
                    recur_cred = text;
                }
                else if (text == "budget_min")
                {
                    budget_min = text;
                }
                else if (text == "trck_amt")
                {
                    trck_amt = text;
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void newFile()
    {
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write("new_user:false\n".getBytes());
            fos.write("save_type:none\n".getBytes());
            fos.write("recur_cred:none\n".getBytes());
            fos.write("budget_min:none\n".getBytes());
            fos.write("trck_amt:none\n".getBytes());

            Toast.makeText(this,"Saved to" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
            Toast.makeText(this,"Saved to" + getFilesDir() + "/" , Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fos != null)
            {
                try{
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public void save(View v){
        String text = mEditText.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(text.getBytes());
            mEditText.getText().clear();
            Toast.makeText(this,"Saved to" + getFilesDir() + "/" + FILE_NAME, Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fos != null)
            {
                try{
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void load(View v)
    {
        FileInputStream fis = null;
        try{
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null)
            {
                sb.append(text).append("\n");
                mEditText.setText(sb.toString());

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete(View v)
    {
        File cfg = new File(getFilesDir(),FILE_NAME);
        if(cfg.exists())
        {
            deleteFile(FILE_NAME);
            Toast.makeText(this,"file exists", Toast.LENGTH_LONG).show();
        }
        if(!cfg.exists())
        {
            cfg.delete();
            Toast.makeText(this,"file doesnt exists", Toast.LENGTH_LONG).show();
        }
    }
}