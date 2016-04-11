package com.example.android.datastrg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by kavin on 3/8/2016.
 */
public class activ3  extends AppCompatActivity {

    public final static String myFile="shared.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
    }

    public void clk_save(View view) {

        EditText e1 = (EditText)findViewById(R.id.editText2);
        Log.v("This activity :", e1.getText().toString());

        try
        {

        SharedPreferences  sp= PreferenceManager.getDefaultSharedPreferences(this);
        int counter=sp.getInt("COUNTER", 0);
        counter++;
        SharedPreferences.Editor ed=sp.edit();
        ed.putInt("COUNTER",counter);
        ed.commit();

        OutputStreamWriter out=new OutputStreamWriter(openFileOutput(myFile,MODE_APPEND));
        String msg="\nSaved Preference "+counter+", "+e1.getText().toString();
        out.write(msg);
        out.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
