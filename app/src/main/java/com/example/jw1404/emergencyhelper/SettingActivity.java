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

public class SettingActivity extends AppCompatActivity {

    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        final EditText passwordText = (EditText) findViewById(R.id.passwordText);
        final Button proceedBtn = (Button) findViewById(R.id.proceedBtn);

        proceedBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String userPassword = passwordText.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if (success){
                                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                                dialog = builder.setMessage("Proceeding")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                Intent intent = new Intent(SettingActivity.this, ChangeActivity .class);
                                SettingActivity.this.startActivity(intent);
                                finish();
                            }
                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                                dialog = builder.setMessage("Please Recheck Password")
                                        .setNegativeButton("Retry", null)
                                        .create();
                                dialog.show();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                SettingRequest settingRequest = new SettingRequest(userPassword,responseListener);
                RequestQueue queue = Volley.newRequestQueue(SettingActivity.this);
                queue.add(settingRequest);
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();;
        if(dialog != null){
            dialog.dismiss();
            dialog = null;
        }
    }
}
