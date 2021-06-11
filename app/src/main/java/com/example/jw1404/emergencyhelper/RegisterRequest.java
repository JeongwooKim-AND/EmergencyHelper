package com.example.jw1404.emergencyhelper;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jw140 on 2018-01-18.
 */

public class RegisterRequest extends StringRequest {

    final static private String URL = "https://ehapplication.000webhostapp.com/UserRegister.php";
    private Map<String, String> parameters;

    public RegisterRequest(String userID, String userPassword, String userEmail, String userContact , Response.Listener<String> listener){
        super(Method.POST,URL,listener,null);
        parameters = new HashMap<>();
        parameters.put("userID",userID);
        parameters.put("userPassword",userPassword);
        parameters.put("userEmail",userEmail);
        parameters.put("userContact",userContact);
    }

    @Override
    public Map<String, String> getParams() {
        return parameters;
    }
}
