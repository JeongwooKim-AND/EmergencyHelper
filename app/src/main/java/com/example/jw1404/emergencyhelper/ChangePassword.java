package com.example.jw1404.emergencyhelper;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jw140 on 2018-03-26.
 */

public class ChangePassword extends StringRequest{
    final static private String URL = "https://ehapplication.000webhostapp.com/UserPassword.php";
    private Map<String, String> parameters;

    public ChangePassword(String userPassword, Response.Listener<String> listener){
        super(Request.Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("userPassword",userPassword);

    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}