package com.example.automated_gatepass_system;

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


import android.R.string;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class Viewdata extends Activity  {

	private Button view_details;
	private TextView userdetails,userdata,stud_reg,stud_school,stud_course,stud_year;
	private EditText p_Code_input; 
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewuserdetails);
        view_details = (Button)findViewById(R.id.details_button);
        userdata = (TextView)findViewById(R.id.user_data);
        userdetails = (TextView)findViewById(R.id.user_details);
        stud_reg = (TextView)findViewById(R.id.studereg);
        stud_school = (TextView)findViewById(R.id.stud_school);
        stud_course = (TextView)findViewById(R.id.stud_course);
        stud_year = (TextView)findViewById(R.id.stud_year);
        
        
        
	    
        
        view_details.setOnClickListener(new OnClickListener() {
			
			@SuppressLint("ShowToast")
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
				try{
			          
					 
					 Intent retrieve_sentdata = getIntent();
					 final String scanContent = retrieve_sentdata.getStringExtra("code");
					 
				        
								
			        	
			        	DefaultHttpClient httpclient = new DefaultHttpClient();
				           
				         HttpPost httppost = new HttpPost("http://192.168.43.162/Projects/data.php");
				         // Add your data
				       
				         
				            // Execute HTTP Post Request
				         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				          nameValuePairs.add(new BasicNameValuePair("code",scanContent));  
				          
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
				            if (result.equals("1")) {
				    			//we have a result
				    			
				    			Toast.makeText(Viewdata.this,"Product Not Registered",Toast.LENGTH_SHORT).show();
				    			
				    			
				            }  else {
				            	String [] items = result.split("#");
				            	
				            	userdata.setText( "Product Code   : "+items[0]);
							    userdetails.setText( "Product Name:  "+items[1]);
							    stud_reg.setText( "Owner RegNo   : "+items[2]);
							    stud_school.setText( "School:  "+items[3]);
							    stud_course.setText( "Course   : "+items[4]);
							    stud_year.setText( "Year  : "+items[5]);
				            	
				               
				            }
				            
				            
							}
							catch (Exception e) 
							{
								// TODO: handle exception
							}}
			
		});
	
	        
	    }

}
