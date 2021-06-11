package com.example.jw1404.emergencyhelper;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jw140 on 2018-03-26.
 */

public class ChangeEmail extends StringRequest{
    final static private String URL = "https://ehapplication.000webhostapp.com/UserEmail.php";
    private Map<String, String> parameters;

    public ChangeEmail(String userEmail, Response.Listener<String> listener){
        super(Request.Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("userEmail",userEmail);

    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}