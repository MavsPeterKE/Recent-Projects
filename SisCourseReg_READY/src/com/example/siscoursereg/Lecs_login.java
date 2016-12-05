package com.example.siscoursereg;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Lecs_login extends Activity {
	TextView login_text,user_email,lec_password,create_account;
	EditText email_input,lec_password_input;
	Button loginuser_button;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lecs_login);
		login_text=(TextView) findViewById(R.id.Login_text);
		user_email=(TextView) findViewById(R.id.user_email);
		lec_password=(TextView) findViewById(R.id.lec_password);
		loginuser_button=(Button) findViewById(R.id.loginuser_button);
		
		create_account=(TextView) findViewById(R.id.create_account);
		create_account.setOnClickListener(new OnClickListener()
		{
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent one = new Intent (getApplicationContext(), Lecs_reg.class);
				startActivity(one);
			}
		});
		
		
		
		
		loginuser_button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
				email_input=(EditText) findViewById(R.id.email_input);
				lec_password_input=(EditText) findViewById(R.id.lec_password_input);
	    		//converts to string
	        	String a = email_input.getText().toString();
	        	String b= lec_password_input.getText().toString();
	        	//create a http default client - initialize the HTTp client
	          DefaultHttpClient httpclient = new DefaultHttpClient();
	            
	         HttpPost httppost = new HttpPost("http://10.0.2.2/Projects/lecslogin.php");
	         // Add your data
	       
	         
	            // Execute HTTP Post Request
	         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	          nameValuePairs.add(new BasicNameValuePair("email", a));  
	          nameValuePairs.add(new BasicNameValuePair("password", b));
	          httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
	          HttpResponse response = httpclient.execute(httppost);
	            
	            InputStream inputStream = response.getEntity().getContent();
	            
	            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream), 4096);
	            String line;
	            StringBuilder sb =  new StringBuilder();
	            
	            while ((line = rd.readLine()) != null) {
	            		sb.append(line);
	            }
	            rd.close();
	            String result = sb.toString();
	            
	            inputStream.close();
	            if(result.equals("3")){
		        	 Toast.makeText(getApplicationContext(), "Provide Username & Password", Toast.LENGTH_LONG).show();
		        	 
		         }
		         else if(result.equals("1")){
		        	 
		        	 Toast.makeText(getApplicationContext(), "Log In Successful", Toast.LENGTH_LONG).show();
		        	 Intent one = new Intent (getApplicationContext(), Appmainlecs.class);
		 				startActivity(one);
		        	 
			      }else if(result.equals("2")){
			    	  Toast.makeText(getApplicationContext(), "Wrong Username/Password", Toast.LENGTH_LONG).show();
			      }
			      }
	            
	            catch (Exception e)
	            {
	                Toast.makeText(getApplicationContext(), "Error inside set:"+e.toString(), Toast.LENGTH_LONG).show();
	            }
				}
			});
	}}