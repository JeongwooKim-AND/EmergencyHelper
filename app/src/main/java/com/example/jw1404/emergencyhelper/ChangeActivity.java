package com.example.jw1404.emergencyhelper;

import android.app.AlertDialog;
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

public class ChangeActivity extends AppCompatActivity {

    private String userPassword;
    private String userEmail;
    private String userContact;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change);

        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final EditText emailText = (EditText) findViewById(R.id.emailText);
        final EditText contactText = (EditText) findViewById(R.id.contactText);
        final Button passwordChange = (Button) findViewById(R.id.passwordChange);
        final Button emailChange = (Button) findViewById(R.id.emailChange);
        final Button contactChange = (Button) findViewById(R.id.contactChange);
        final Button doneBtn = (Button) findViewById(R.id.doneBtn);

        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent done = new Intent(ChangeActivity.this , MainActivity.class);
                ChangeActivity.this.startActivity(done);
            }
        });

        passwordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userPassword = passwordText.getText().toString();

                if (userPassword.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChangeActivity.this);
                    dialog = builder.setMessage("Please Fill up the Blank")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(ChangeActivity.this);
                                dialog = builder.setMessage("This Password can be used")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                passwordText.setEnabled(false);
                                passwordText.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                passwordChange.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ChangeActivity.this);
                                dialog = builder.setMessage("This Password can't be used")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                ChangePassword changeRequest = new ChangePassword(userPassword,responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChangeActivity.this);
                queue.add(changeRequest);

            }
        });

        emailChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = emailText.getText().toString();

                if (userEmail.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChangeActivity.this);
                    dialog = builder.setMessage("Please Fill up the Blank")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(ChangeActivity.this);
                                dialog = builder.setMessage("This Email can be used")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                emailText.setEnabled(false);
                                emailText.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                emailChange.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ChangeActivity.this);
                                dialog = builder.setMessage("This Email can't be used")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                ChangeEmail changeRequest = new ChangeEmail(userEmail,responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChangeActivity.this);
                queue.add(changeRequest);

            }
        });

        contactChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userContact = contactText.getText().toString();

                if (userContact.equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ChangeActivity.this);
                    dialog = builder.setMessage("Please Fill up the Blank")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");
                            if (success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(ChangeActivity.this);
                                dialog = builder.setMessage("This Number can be used")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                contactText.setEnabled(false);
                                contactText.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                contactChange.setBackgroundColor(getResources().getColor(R.color.colorGray));
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ChangeActivity.this);
                                dialog = builder.setMessage("This Number can't be used")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                ChangeContact changeRequest = new ChangeContact(userContact,responseListener);
                RequestQueue queue = Volley.newRequestQueue(ChangeActivity.this);
                queue.add(changeRequest);

            }
        });
    }
}
