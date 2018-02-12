package com.k.amulyacare;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.widget.TextView;

import static android.text.Layout.JUSTIFICATION_MODE_INTER_WORD;

public class Treatments extends AppCompatActivity {
    TextView tv;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatments);
        tv=(TextView)findViewById(R.id.sirodhara);
        tv.setJustificationMode(JUSTIFICATION_MODE_INTER_WORD);



    }
}
