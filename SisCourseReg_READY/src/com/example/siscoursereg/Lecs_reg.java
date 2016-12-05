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
import android.text.Editable;
import android.text.TextWatcher;
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

public class Lecs_reg extends Activity {
	TextView lec_name,lec_department,lec_email,lec_contacts,
	lecpassword,lec_cpassword,password_match;
	EditText lecname_input,lec_email_input,leccontact_input,lecpassword_input,leccpassword_input;
	Button create_account;
	Spinner lecdepartment_input;
	private static final String departments [] = {"IT","LRM","PMS",};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lecs_reg); 
		//Headers
		lec_name=(TextView) findViewById(R.id.lec_name);
		lec_department=(TextView) findViewById(R.id.lec_department);
		lec_email=(TextView) findViewById(R.id.lec_email);
		lec_contacts=(TextView) findViewById(R.id.lec_contacts);
		lecpassword=(TextView) findViewById(R.id.lecpassword);
		lec_cpassword=(TextView) findViewById(R.id.lec_cpassword);
		//Inputs
		lecname_input=(EditText) findViewById(R.id.lecname_input);
		lec_email_input=(EditText) findViewById(R.id.lec_email_input);
		leccontact_input=(EditText) findViewById(R.id.leccontact_input);
		create_account=(Button) findViewById(R.id.create_account);
		
		
		
		lecpassword_input=(EditText) findViewById(R.id.lecpassword_input);
		leccpassword_input=(EditText) findViewById(R.id.leccpassword_input);
		password_match=(TextView) findViewById(R.id.password_match);
		
		leccpassword_input.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				String strPass1 = lecpassword_input.getText().toString();
				String strPass2 = leccpassword_input.getText().toString();
				
				if (strPass1.equals(strPass2)) 
					
				{
				   password_match.setText(R.string.passmatch);
				} 
				else {
					password_match.setText(R.string.passdmatch);
				}if (strPass1.equals(null)) {
					password_match.setText(R.string.Setpassword);
				} 
				}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				password_match.setText(R.string.Setpassword);
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
            if (lecpassword_input.equals(leccpassword_input)) 
					
				{
				   password_match.setText(R.string.passmatch);
				} else {
					password_match.setText(R.string.passdmatch);
				}
				
			}});
		
		lecdepartment_input=(Spinner) findViewById(R.id.lecdepartment_input);
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item,departments);
		aa.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
		lecdepartment_input.setAdapter(aa);
		lecdepartment_input.setOnItemSelectedListener(new OnItemSelectedListener()
		 {
				public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Lecs_reg.this, "Selected",Toast.LENGTH_SHORT).show();
				}

				public void onNothingSelected(AdapterView<?> arg0) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Lecs_reg.this, "Nothing Selected",Toast.LENGTH_SHORT).show();
				}
			
		 });
				
		
	

		
		
		create_account.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try{
			           //Toast.makeText(Students_reg.this, "Account Successfully Created", Toast.LENGTH_SHORT).show();
			            String a = lecname_input.getText().toString();
			         	String b= lecdepartment_input.getSelectedItem().toString();
			         	String c = lec_email_input.getText().toString();
			        	String d= leccontact_input.getText().toString();
			        	String e = leccpassword_input.getText().toString();
			        	
			           DefaultHttpClient httpclient = new DefaultHttpClient();
			           
				         HttpPost httppost = new HttpPost("http://10.0.2.2/Projects/lecreg.php");
				         // Add your data
				       
				         
				            // Execute HTTP Post Request
				         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				          nameValuePairs.add(new BasicNameValuePair("lname", a));  
				          nameValuePairs.add(new BasicNameValuePair("department", b));
				          nameValuePairs.add(new BasicNameValuePair("email", c));
				          nameValuePairs.add(new BasicNameValuePair("contacts", d));
				          nameValuePairs.add(new BasicNameValuePair("password", e));
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
					        	 Toast.makeText(getApplicationContext(), "Already Registered", Toast.LENGTH_LONG).show();
					        	 
					         }
				            else if(result.equals("4")){
				            	 Toast.makeText(getApplicationContext(), " Registered Successfully", Toast.LENGTH_LONG).show();
				            	 Intent one = new Intent (getApplicationContext(), Lecs_login.class);
				 				startActivity(one);
				            }else if(result.equals("3")){
				            
				            	 Toast.makeText(getApplicationContext(), " All Details Requirred", Toast.LENGTH_LONG).show();
				            }
							}
				            catch (Exception e)
				            {
				                Toast.makeText(getApplicationContext(), "Error inside set:"+e.toString(), Toast.LENGTH_LONG).show();
				            }
					
						}
					});
				}}
				    

