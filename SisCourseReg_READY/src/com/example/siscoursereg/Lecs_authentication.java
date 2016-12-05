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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;
import android.widget.TextView;

public class Lecs_authentication extends Activity {
	TextView secret_word,authent_code;
	EditText secret_text,code;
	Button submit;
	private ProgressDialog progress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lecs_authentication);
		secret_word=(TextView) findViewById(R.id.Secret_word);
		authent_code=(TextView) findViewById(R.id.authent_code);
		submit=(Button) findViewById(R.id.submit);
		
	
		
	}
	
	
	
	    //method to save data to db
	    public void submit(View view){ 
        		
	    	try {
	    		secret_text= (EditText) findViewById(R.id.secret_text);
	    		code= (EditText) findViewById(R.id.code);
	    		
	    		//converts to string
	        	String a = secret_text.getText().toString();
	        	String b= code.getText().toString();
	        	
	        	//create a http default client - initialize the HTTp client
	          DefaultHttpClient httpclient = new DefaultHttpClient();
	            
	         HttpPost httppost = new HttpPost("http://10.0.2.2/Projects/retrievedata.php");
	         // Add your dat
	       
	         
	            // Execute HTTP Post Request
	         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
	          nameValuePairs.add(new BasicNameValuePair("sw", a));  
	          nameValuePairs.add(new BasicNameValuePair("code", b));
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
	        	 Toast.makeText(getApplicationContext(), "Provide Both Correct Credentials", Toast.LENGTH_LONG).show();
	        	 
	         }
	         else if(result.equals("1")){
	        	 
	        	 Toast.makeText(getApplicationContext(), "Aunthentification Successful", Toast.LENGTH_LONG).show();
	        	 
	        	 //Display action progressbar before launching next activity
	        	 progress=new ProgressDialog(this);
	    		 progress.setMessage("Setting Lecturer Login..");
	             progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
	    		 progress.setIndeterminate(false);
	    		 progress.setProgress(0);
	    		 progress.show();
	    								  		      
	    		final int totalProgressTime = 100;
	    		final Thread t = new Thread() {
	    	 @Override
	    		public void run() {
	            int jumpTime = 0;
	    								  		            
	    		             while(jumpTime <= totalProgressTime) {
	    						  try {
	    								 sleep(150);
	    								 jumpTime += 5;
	    								  progress.setProgress(jumpTime);
	    								  
	    							   }
	    	    catch (InterruptedException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    			  		                 
	    								  	   }
	    		 }
	    	  
	    	Intent a= new Intent(Lecs_authentication.this,Lecs_login.class);
	    	  startActivity(a);
	    	 
	    		 }
	    		 };
	    		t.start();
	         }
	     }
	            catch (Exception e)
	            {
	                Toast.makeText(getApplicationContext(), "Error inside set:"+e.toString(), Toast.LENGTH_LONG).show();
	            }
	    	
	    }
	    
}
			           
			            
			            
			              

		
			            
	

		   
			    	
		


		
		
				
				