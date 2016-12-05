package com.example.siscoursereg;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	TextView welcome,copyright;
	Button exit,studentlog,leclog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		welcome=(TextView) findViewById(R.id.welcome);
		studentlog=(Button) findViewById(R.id.studentlog);
		leclog=(Button) findViewById(R.id.leclog);
		
		
		studentlog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Logging As Student", Toast.LENGTH_SHORT).show();
				Intent b= new Intent(MainActivity.this,Students_login.class);
				startActivity(b);
			}
		});
                leclog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "Logging As Lecturer", Toast.LENGTH_SHORT).show();
				Intent a= new Intent(MainActivity.this,Lecs_authentication.class);
				startActivity(a);
				
			}
		});
               /* exit.setOnClickListener(new OnClickListener() {
        			
        			@Override
        			public void onClick(View v) {
        				// TODO Auto-generated method stub
        				Toast.makeText(MainActivity.this, "Exitting Application", Toast.LENGTH_SHORT).show();
        				android.os.Process.killProcess(android.os.Process.myPid());
                        System.exit(1);

        			}
        		});*/
	}}

