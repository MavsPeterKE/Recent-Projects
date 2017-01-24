package com.example.doctorsmobileapp;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.R.color;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText username,password;
    TextView register, forget;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.userpwd);
        register=(TextView)findViewById(R.id.register);
        forget=(TextView)findViewById(R.id.passresetbutton);
        forget.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View forgetview) {
				// TODO Auto-generated method stub
				//Dialog Containing List Items That user Selects
				final Dialog resetpasswd = new Dialog(forgetview.getContext());
		        resetpasswd.setTitle("Reset Password");
		        setTitleColor(color.holo_green_light);
		        
		        // Customize Dialogue Background
		        resetpasswd.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
		        
		        //Add Views  to the dialogue
		        LayoutInflater inflatereset = (LayoutInflater) forgetview.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		        View resetdisplay = inflatereset.inflate(R.layout.resetpassword, null, false);
		        resetpasswd.setContentView(resetdisplay);
		        resetpasswd.setCancelable(true);
		        resetpasswd.show();
		       
		       
		      //Initialize components in the dialog
		        final EditText resetemail=(EditText)resetpasswd.findViewById(R.id.confirmvalue);
		        final EditText staffno=(EditText)resetpasswd.findViewById(R.id.patientphone);
		        Button submit=(Button)resetpasswd.findViewById(R.id.registerpatientButton);
		        submit.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						String r_input=resetemail.getText().toString();
						String staffno_input=staffno.getText().toString();
						Toast.makeText(getApplicationContext(), "Reset details has been sent to your email", Toast.LENGTH_SHORT).show();
						resetpasswd.dismiss();
						
					}
				});
		        
		       
		        
		        

			}
		});
        
        login=(Button)findViewById(R.id.login);
        
        register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent staffreg = new Intent(MainActivity.this, Staffreg.class);
                startActivity(staffreg);
			}
		});
        
        login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				String a=username.getText().toString();
				String b=password.getText().toString();
				if(a.equals("reception@dma.com")){
					Intent recep= new Intent(MainActivity.this, Receptnistmain.class);
	                startActivity(recep);
					
				}else if(a.equals("doctor@dma.com")){
					Intent doct= new Intent(MainActivity.this, Doctorsmain.class);
	                startActivity(doct);
				}else if(a.equals("")){
					Toast.makeText(getApplicationContext(), "Enter Valid User", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(getApplicationContext(), "User not in staff database", Toast.LENGTH_SHORT).show();
				}
				
				/*
				//Get users input
				String a=username.getText().toString();
				String b=password.getText().toString();
				
				//Object that will make request to the server
				AsyncHttpClient client=new AsyncHttpClient();
				
				//Object to request parameters that will be sent to the server
				RequestParams params=new RequestParams();
				
				//Just like the array pairs, Sends the values to the php script
				params.put("username", a);
				params.put("password", b); 
			
				//post data to the script
				client.post("http://10.0.2.2/Projects/login.php",params,new AsyncHttpResponseHandler() {
					
					@Override
					public void onSuccess(int arg0, Header[] arg1, byte[] response) {
						// TODO Auto-generated method stub
						
						//convert server response from byte to string and trims
						String serverresponse=new String(response).trim();
						
					}
					
					@Override
					public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
						// TODO Auto-generated method stub
						
					}
				});*/
				
			/*	Intent receptionst= new Intent(MainActivity.this, Receptnistmain.class);
                startActivity(receptionst);*/
				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
