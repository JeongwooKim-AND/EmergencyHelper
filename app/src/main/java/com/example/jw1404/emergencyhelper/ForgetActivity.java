package com.example.jw1404.emergencyhelper;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.Random;

public class ForgetActivity extends AppCompatActivity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        final Button sendButton = (Button) findViewById(R.id.sendButton);
        final EditText idText = (EditText) findViewById(R.id.idText);
        final EditText emailText = (EditText) findViewById(R.id.emailText);
        final Random ran = new Random();
        final int min = 1000;
        final int max = 9999;

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userID = idText.getText().toString();
                String userEmail = emailText.getText().toString();
                int rand = ran.nextInt((max - min) + 1) + min;
                String userPassword = String.valueOf(rand);
                final Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(ForgetActivity.this);
                                dialog = builder.setMessage("Successfully Send")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                Intent intent = new Intent(ForgetActivity.this, LoginActivity.class);
                                ForgetActivity.this.startActivity(intent);
                                finish();
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ForgetActivity.this);
                                dialog = builder.setMessage("Send Fail")
                                        .setNegativeButton("Retry", null)
                                        .create();
                                dialog.show();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                ForgetRequest forgetRequest = new ForgetRequest(userID,userEmail,userPassword,responseListener);
                RequestQueue queue = Volley.newRequestQueue(ForgetActivity.this);
                queue.add(forgetRequest);
            }
        });
    }
    @Override
    protected void onStop(){
        super.onStop();
        if(dialog != null){
            dialog.dismiss();
            dialog = null;
        }
    }
}
