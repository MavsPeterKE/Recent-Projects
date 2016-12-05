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
import android.annotation.SuppressLint;
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

@SuppressLint("CutPasteId")
public class Timetabledownload extends Activity  {
	TextView fromlink_download,alternative_download,file_location,fromlink_downloadbutton;
	Button download_file;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timetabledownload); 
		//Headers
		fromlink_download=(TextView) findViewById(R.id.fromlink_download);
		alternative_download=(TextView) findViewById(R.id.alternative_download);
		file_location=(TextView) findViewById(R.id.file_location);
		fromlink_downloadbutton=(TextView) findViewById(R.id.fromlink_download);
		download_file=(Button) findViewById(R.id.download_file);
		fromlink_downloadbutton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try {
		    		
		        	//create a http default client - initialize the HTTp client
		          DefaultHttpClient httpclient = new DefaultHttpClient();
		            
		         HttpPost httppost = new HttpPost("http://10.0.2.2/androiddb/linkretrieve");
		         // Add your data
		       
		         
		            // Execute HTTP Post Request
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
		        	 Toast.makeText(getApplicationContext(), "No Download Link", Toast.LENGTH_LONG).show();
		        	 
		         }
		         else {
		            String [] items = result.split("#");
		            fromlink_download.setText(items[5]);
		         }
		     }
		            catch (Exception e)
		            {
		                Toast.makeText(getApplicationContext(), "Error inside set:"+e.toString(), Toast.LENGTH_LONG).show();
		            }
		    	
		    
			}
		});
	}}