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
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Postnews extends Activity  {
	TextView target_audience,target_year,lec,news;
	EditText name,news_input;
	public Spinner target_input,targetyear_input;
	Button post;
	
	private static final String year [] = {"1st Year","2nd Year","3rd Year","4th Year"};
	private static final String departments [] = {"Informatics","Information Science","Media Science"};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.postnews); 
		//Headers
		target_audience=(TextView) findViewById(R.id.target_audience);
		target_year=(TextView) findViewById(R.id.target_year);
		lec=(TextView) findViewById(R.id.lec);
		news=(TextView) findViewById(R.id.news_posted);
		
		//Setting content to spinner list using array adapter
		target_input=(Spinner) findViewById(R.id.target_input);
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item,departments);
				aa.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
				target_input.setAdapter(aa);
				target_input.setOnItemSelectedListener(new OnItemSelectedListener()
				 {
						public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) 
						{
							// TODO Auto-generated method stub
							Toast.makeText(Postnews.this, "Selected",Toast.LENGTH_SHORT).show();
						}

						public void onNothingSelected(AdapterView<?> arg0) 
						{
							// TODO Auto-generated method stub
							Toast.makeText(Postnews.this, "Nothing Selected",Toast.LENGTH_SHORT).show();
						}
					
				 });
		
		
		targetyear_input=(Spinner) findViewById(R.id.targetyear_input);
		ArrayAdapter<String> bb=new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item,year);
				bb.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item);
				targetyear_input.setAdapter(bb);
				targetyear_input.setOnItemSelectedListener(new OnItemSelectedListener()
				 {
						public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) 
						{
							// TODO Auto-generated method stub
							Toast.makeText(Postnews.this, "Selected",Toast.LENGTH_SHORT).show();
						}

						public void onNothingSelected(AdapterView<?> arg0) 
						{
							// TODO Auto-generated method stub
							Toast.makeText(Postnews.this, "Nothing Selected",Toast.LENGTH_SHORT).show();
						}
					
				 });
		
				name=(EditText) findViewById(R.id.lecname_entered);
				news=(EditText) findViewById(R.id.news_input);
		        post=(Button) findViewById(R.id.post_news);
	
		
		
		
		
		 post.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
           //Toast.makeText(Students_reg.this, "Account Successfully Created", Toast.LENGTH_SHORT).show();
            String a = target_input.getSelectedItem().toString();
         	String b=  targetyear_input.getSelectedItem().toString();
        	String c= name.getText().toString();
        	String d =news.getText().toString();
        	
        	 DefaultHttpClient httpclient = new DefaultHttpClient();
	           
	         HttpPost httppost = new HttpPost("http://10.0.2.2/Projects/postednews.php");
	         // Add your data
	       
	         
	            // Execute HTTP Post Request
	         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	          nameValuePairs.add(new BasicNameValuePair("target", a));  
	          nameValuePairs.add(new BasicNameValuePair("tyear", b));
	          nameValuePairs.add(new BasicNameValuePair("lec", c));
	          nameValuePairs.add(new BasicNameValuePair("news", d));
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
	            if(result.equals("2")){
		        	 Toast.makeText(getApplicationContext(), "Sorry Cannot Post Duplicate news", Toast.LENGTH_LONG).show();
		        	 
		         }
	            else if(result.equals("4")){
	            	 Toast.makeText(getApplicationContext(), "News Posted Successfully", Toast.LENGTH_LONG).show();
	            	 Intent one = new Intent (getApplicationContext(), Appmainlecs.class);
	 				startActivity(one);
	            }else if(result.equals("3")){
	            
	            	 Toast.makeText(getApplicationContext(), "Check That all Fields are Filled", Toast.LENGTH_LONG).show();
	            }
				}
	            catch (Exception e)
	            {
	                Toast.makeText(getApplicationContext(), "Error inside set:"+e.toString(), Toast.LENGTH_LONG).show();
	            }
		
			}
		});
	}}
	    


