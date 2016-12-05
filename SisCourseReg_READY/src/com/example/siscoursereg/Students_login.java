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

public class Students_login extends Activity {
	TextView username,password,student_create_account;
	EditText username_input,password_input;
	Button login;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.students_login);
		username=(TextView) findViewById(R.id.username);
		password=(TextView) findViewById(R.id.Password);
		student_create_account=(TextView) findViewById(R.id.student_create_account);
		login=(Button) findViewById(R.id.login);
		
		
		student_create_account.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent one = new Intent (getApplicationContext(), Students_reg.class);
				startActivity(one);
			}
		});
			
		
		
		
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
					username_input=(EditText) findViewById(R.id.studuser_input);
					password_input=(EditText) findViewById(R.id.studpwd_input);
		    		//converts to string
		        	String a = username_input.getText().toString();
		        	String b= password_input.getText().toString();
		        	//create a http default client - initialize the HTTp client
		          DefaultHttpClient httpclient = new DefaultHttpClient();
		            
		         HttpPost httppost = new HttpPost("http://10.0.2.2/Projects/slogin.php");
		         // Add your data
		       
		         
		            // Execute HTTP Post Request
		         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		          nameValuePairs.add(new BasicNameValuePair("username", a));  
		          nameValuePairs.add(new BasicNameValuePair("pwd", b));
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
			        	 Intent one = new Intent (getApplicationContext(), Appmain.class);
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