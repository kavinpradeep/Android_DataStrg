package com.example.android.datastrg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_pref(View view) {

        Intent i = new Intent(this,activ3.class);
        startActivity(i);
    }

    public void click_sqlite(View view) {

        Intent i = new Intent(this,activ2.class);
        startActivity(i);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        try {
            InputStream in = openFileInput(activ3.myFile);
            if (in != null) {
                InputStreamReader tmp = new InputStreamReader(in);
                BufferedReader reader = new BufferedReader(tmp);
                String str,str2="";
                StringBuilder buf = new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
                    str2=str;
                }

                in.close();
                TextView savedPref = (TextView) findViewById(R.id.textView3);
                savedPref.setText(str2);

                /*Displayed only the last line as suffient space not available*/
            }
        }
        catch (FileNotFoundException e)
        {

        }
        catch (IOException e)
        {

        }
    }
}
