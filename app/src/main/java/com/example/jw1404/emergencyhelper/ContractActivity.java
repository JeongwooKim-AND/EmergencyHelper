package com.example.jw1404.emergencyhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ContractActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contract);

        final TextView contractscroll = (TextView) findViewById(R.id.contractscroll);
        contractscroll.setMovementMethod(new ScrollingMovementMethod());
    }

}
