package com.k.amulyacare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Onlineconsultation extends AppCompatActivity {
    Button bt_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlineconsultation);

        bt_submit=(Button)findViewById(R.id.submit);


        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText et=(EditText)findViewById(R.id.service_required);
                String s=et.getText().toString();

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.setPackage("com.google.android.gm");
                sendIntent.putExtra(Intent.EXTRA_TEXT,s);
                sendIntent.putExtra(Intent.EXTRA_EMAIL ,new String[]{"priyankareddythummala@gmail.com"});
                sendIntent.setType("text/plain");
                startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.send_to)));

            }
        });




    }


}
