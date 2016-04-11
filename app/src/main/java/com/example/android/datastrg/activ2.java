package com.example.android.datastrg;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 * Created by kavin on 3/8/2016.
 */
public class activ2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
    }

    public void clk_save(View view) {

     //   Intent i = new Intent(this,activ3.class);
    //    startActivity(i);
        EditText e = (EditText)findViewById(R.id.editText);
        Log.v("This activity :", e.getText().toString());
        String message=e.getText().toString();
        DataFlow dataController=new DataFlow(getBaseContext());
        dataController.open();
        long retValue= dataController.insert(message);
        dataController.close();
    }
}
