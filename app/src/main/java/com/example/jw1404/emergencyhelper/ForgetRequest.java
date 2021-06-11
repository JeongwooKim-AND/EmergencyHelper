package com.example.jw1404.emergencyhelper;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jw140 on 2018-02-27.
 */

public class ForgetRequest extends StringRequest {
    final static private String URL = "https://ehapplication.000webhostapp.com/userForget.php";
    private Map<String,String> parameters;

    public ForgetRequest(String userID, String userEmail, String userPassword, Response.Listener <String> listener){
        super(Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userEmail",userEmail);
        parameters.put("userPassword",userPassword);
    }
    @Override
    public Map<String ,String> getParams() {
        return parameters;
    }
}
