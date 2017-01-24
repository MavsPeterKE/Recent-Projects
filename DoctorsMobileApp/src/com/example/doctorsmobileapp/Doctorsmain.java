package com.example.doctorsmobileapp;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.R.anim;
import android.R.layout;
import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Doctorsmain extends Activity {
    ImageView home,doctor_diary,doctor_pending,doctor_cancel;
    TextView doctor_text,diary_text,pending_text,cancel_text;
  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorsmain);
        
        home=(ImageView)findViewById(R.id.home_icon);
        home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Redirecting to main", Toast.LENGTH_SHORT).show();
			}
		});
        doctor_diary=(ImageView)findViewById(R.id.doctor_diary);
        doctor_diary.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				
				Toast.makeText(getApplicationContext(), "Loading Doctors Diary", Toast.LENGTH_SHORT).show();
				Intent diary=new Intent(Doctorsmain.this,Doctordiary.class);
				startActivity(diary);
				
				
				
			}
		});
        doctor_pending=(ImageView)findViewById(R.id.doctor_pending);
        doctor_pending.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Loading Penging Confirmations", Toast.LENGTH_SHORT).show();
				Intent doctorconfirms=new Intent(Doctorsmain.this,Doctorconfirms.class);
				startActivity(doctorconfirms);
			}
		});
        doctor_cancel=(ImageView)findViewById(R.id.doctor_cancel);
        doctor_cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Loading Interface", Toast.LENGTH_SHORT).show();
				Intent doctorcancels=new Intent(Doctorsmain.this,Doctorcancels.class);
				startActivity(doctorcancels);
				
				
			}
		});
       
        
        diary_text=(TextView)findViewById(R.id.diary_text);
        diary_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Loading Doctor's Diary", Toast.LENGTH_SHORT).show();
				Intent diary=new Intent(Doctorsmain.this,Doctordiary.class);
				startActivity(diary);
			}
		});
       pending_text=(TextView)findViewById(R.id.pending_text);
        pending_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Loading Pending Confirmations ", Toast.LENGTH_SHORT).show();
				Intent doctorconfirms=new Intent(Doctorsmain.this,Doctorconfirms.class);
				startActivity(doctorconfirms);
				
			}
		});
        
        cancel_text=(TextView)findViewById(R.id.cancel_text);
        cancel_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Loading interface", Toast.LENGTH_SHORT).show();
				Intent doctorcancels=new Intent(Doctorsmain.this,Doctorcancels.class);
				startActivity(doctorcancels);
				
			}
		});
        
       
    }


    
    
}
