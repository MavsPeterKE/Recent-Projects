package com.example.automated_gatepass_system;





import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;


import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private Button scanBtn;
	private TextView formatTxt, contentTxt,userdetails,userdata;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        //scanBtn.setOnClickListener(new OnClickListener() {
			
			//@Override
			//public void onClick(View arg0) {
				// TODO Auto-generated method stub
				/*Intent a= new Intent(MainActivity.this, Viewdata.class);
				startActivity(a);
				
				String scanContent="2333";
				
				Intent senddata = new Intent(MainActivity.this, Viewdata.class);
				senddata.putExtra("code", scanContent);
				startActivity(senddata);
			}
		});*/
       
        scanBtn.setOnClickListener(this);
      }	
       			
	
	@SuppressLint("ShowToast")
			public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        		//retrieve scan result
        		IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
				// TODO Auto-generated method stub
				
        		if (scanningResult != null) {
	    			//we have a result
        			String scanContent = scanningResult.getContents();
					String scanFormat = scanningResult.getFormatName();
	    			formatTxt.setText("Format: " + scanFormat);
	    			contentTxt.setText("Serial No: " + scanContent);
	    			//String [] items = result.split("#");
	               
	    			Intent senddata = new Intent(MainActivity.this, Viewdata.class);
					senddata.putExtra("code", scanContent);
					startActivity(senddata); 	
	    			
	            }  else {
	    			@SuppressWarnings("unused")
					Toast toast = Toast.makeText(getApplicationContext(), 
	    				"No scan data received!", Toast.LENGTH_SHORT);
	    			//toast.show();/
	            }
	             
	            
				}
        	
	    	public void onClick(View v){
	    		//respond to clicks
	    		if(v.getId()==R.id.scan_button){
	    			//scan
	    			IntentIntegrator scanIntegrator = new IntentIntegrator(this);
	    			scanIntegrator.initiateScan();//Throws Result to the next activity 
	    			
	    			
	    			}
	    		
	    		}

	        @Override
	        public boolean onCreateOptionsMenu(Menu menu) {
	            // Inflate the menu; this adds items to the action bar if it is present.
	            getMenuInflater().inflate(R.menu.main, menu);
	            return true;
	        
	        }



 }


