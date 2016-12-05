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

public class Students_reg extends Activity  {
	TextView userreg_no,course,stud_year,contacts,studpassword,stud_cpassword,
	studpassword_match;
	EditText studreg_input,studcontact_input,studpassword_input,stud_cpassword_input,spinner_course;
	public Spinner stud_year_input;
	Button studcreate_account;
	private static final String gender [] = {"Male","Female"};
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.students_reg); 
		//Headers
		userreg_no=(TextView) findViewById(R.id.userreg_no);
		course=(TextView) findViewById(R.id.course);
		stud_year=(TextView) findViewById(R.id.stud_year);
		contacts=(TextView) findViewById(R.id.stud_contacts);
		studpassword=(TextView) findViewById(R.id.studpassword);
		stud_cpassword=(TextView) findViewById(R.id.stud_cpassword);
		//Inputs
		studreg_input=(EditText) findViewById(R.id.studreg_input);
		spinner_course=(EditText) findViewById(R.id.course_select);
		//spinner_course = getString(resId, formatArgs)
		
		studcontact_input=(EditText) findViewById(R.id.studcontact_input);
		studcreate_account=(Button) findViewById(R.id.studcreate_account);
		
		studpassword_input=(EditText) findViewById(R.id.studpassword_input);
		stud_cpassword_input=(EditText) findViewById(R.id.studcpassword_input);
		studpassword_match=(TextView)findViewById(R.id.studpassword_match);
		
		
		stud_cpassword_input.addTextChangedListener(new TextWatcher() {
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				String strPass1 = studpassword_input.getText().toString();
				String strPass2 = stud_cpassword_input.getText().toString();
				
				if (strPass1.equals(strPass2)) 
				{
				studpassword_match.setText(R.string.passmatch);
				} else {
					studpassword_match.setText(R.string.passdmatch);
				} if (strPass1.equals(null)) {
					studpassword_match.setText(R.string.Setpassword);
				} 
				}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}});
		
		
		stud_year_input=(Spinner) findViewById(R.id.stud_year_input);
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item,gender);
		aa.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
		stud_year_input.setAdapter(aa);
		stud_year_input.setOnItemSelectedListener(new OnItemSelectedListener()
		 {
				public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Students_reg.this, "Selected",Toast.LENGTH_SHORT).show();
				}

				public void onNothingSelected(AdapterView<?> arg0) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Students_reg.this, "Nothing Selected",Toast.LENGTH_SHORT).show();
				}
			
		 });
		
		

		
		studcreate_account.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try{
           //Toast.makeText(Students_reg.this, "Account Successfully Created", Toast.LENGTH_SHORT).show();
            String a = studreg_input.getText().toString();
         	String b= stud_year_input.getSelectedItem().toString();
         	String c = spinner_course.getText().toString();
        	String d= studcontact_input.getText().toString();
        	String e = studpassword_input.getText().toString();
        	
        	DefaultHttpClient httpclient = new DefaultHttpClient();
	           
	         HttpPost httppost = new HttpPost("http://10.0.2.2/Projects/studreg.php");
	         // Add your data
	       
	         
	            // Execute HTTP Post Request
	         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	          nameValuePairs.add(new BasicNameValuePair("reg_no", a));  
	          nameValuePairs.add(new BasicNameValuePair("year", b));
	          nameValuePairs.add(new BasicNameValuePair("course", c));
	          nameValuePairs.add(new BasicNameValuePair("contacts", d));
	          nameValuePairs.add(new BasicNameValuePair("pwd", e));
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
	            	 Intent one = new Intent (getApplicationContext(), Students_login.class);
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
	    


