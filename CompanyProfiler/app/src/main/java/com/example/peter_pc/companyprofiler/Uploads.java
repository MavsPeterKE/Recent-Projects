package com.example.peter_pc.companyprofiler;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

import cz.msebera.android.httpclient.Header;

public class Uploads extends AppCompatActivity {

    EditText name, location, email, phone;
    Button upload, submit;
    String nameinput, locationinput, emailinput, phoneinput, url;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploads);

        name = (EditText) findViewById(R.id.company);
        location = (EditText) findViewById(R.id.location);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        upload = (Button) findViewById(R.id.upload);



    }

    public void postdata(View v) {

        nameinput = name.getText().toString();
        locationinput = location.getText().toString();
        emailinput = email.getText().toString();
        phoneinput = phone.getText().toString();


        //Check that no empty Field is passed
        if (nameinput.isEmpty()){
            name.setError("Required");
        }else if(locationinput.isEmpty()){
            location.setError("Required");
        }else if(emailinput.isEmpty()){
            email.setError("Required");
        }else if(phoneinput.isEmpty()){
            phone.setError("Required");
        }else{


        //Initialize the Ascync Client
        AsyncHttpClient net = new AsyncHttpClient();
        //Initialize param object to store the values
        RequestParams params = new RequestParams();


        //binding data to the object
        params.put("name", nameinput);
        params.put("location", locationinput);
        params.put("email", emailinput);
        params.put("phone", phoneinput);



        //Establishing connection and transmitting data to server

         try {

             net.post("http://cypressoutlook.com/config/post.php", params, new AsyncHttpResponseHandler() {
                 @Override
                 public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                     String result = new String(responseBody);

                     if (result.equals("5")) {
                         Toast.makeText(getApplicationContext(), "Data Saved Successfully", Toast.LENGTH_LONG).show();
                     } else if (result.equals("4"))

                     {
                         Toast.makeText(getApplicationContext(), "Cannot Save duplicate Record", Toast.LENGTH_LONG).show();
                     } else if (result.equals("0"))

                     {
                         Toast.makeText(getApplicationContext(), "Problem Communicating with server", Toast.LENGTH_LONG).show();
                     }

                 }

                 @Override
                 public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                     Toast.makeText(getApplicationContext(), "Problem Connecting To server", Toast.LENGTH_SHORT).show();

                 }
             });

         }catch (Exception e){


         }finally {
             Intent nextface=new Intent(Uploads.this,MainActivity.class);
             startActivity(nextface);
         }



            }



}}

