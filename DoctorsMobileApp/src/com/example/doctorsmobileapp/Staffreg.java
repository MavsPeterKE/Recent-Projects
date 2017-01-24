package com.example.doctorsmobileapp;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Staffreg extends Activity {
	EditText staffno,email,pass,cpass;
	Button regButton;
	TextView passmatch;
   
   
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.staffreg);
        staffno=(EditText)findViewById(R.id.staffno);
        email=(EditText)findViewById(R.id.confirmvalue);
        pass=(EditText)findViewById(R.id.pass);
        cpass=(EditText)findViewById(R.id.cpass);
        regButton=(Button)findViewById(R.id.registerpatientButton);
        passmatch=(TextView)findViewById(R.id.passmatch);
        passmatch.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				String pass1=pass.getText().toString();
				String pass2=cpass.getText().toString();
				if (pass1.equals(pass2)) 
				{
				passmatch.setText(R.string.passtrue);
				passmatch.setVisibility(View.VISIBLE);
				}else{cpass.setError("Passwords Do not match");}
			}
		});
        regButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String a=staffno.getText().toString();
				String b=email.getText().toString();
				String c=pass.getText().toString();
				
				AsyncHttpClient client= new AsyncHttpClient();
				Intent staffreg=new Intent(Staffreg.this,MainActivity.class);
				startActivity(staffreg);
				Toast.makeText(getApplicationContext(), "Staff successfully registered", Toast.LENGTH_SHORT).show();
				
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
