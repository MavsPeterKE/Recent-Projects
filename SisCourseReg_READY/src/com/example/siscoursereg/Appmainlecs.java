package com.example.siscoursereg;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;



import android.graphics.Color; 
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Appmainlecs<Dialoginterface> extends Activity {
	TextView menu,log_out;
	ListView ml;
	ImageView rightimage,leftimage,schoolview;

	
	
	private static final String actions []={"Post News","Upload Timetable","User Support"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.appmain); 
		//Headers
		menu=(TextView) findViewById(R.id.menu);
		log_out=(TextView) findViewById(R.id.log_out);
		rightimage=(ImageView)findViewById(R.id.rightimage);
		leftimage=(ImageView)findViewById(R.id.leftimage);
		schoolview=(ImageView)findViewById(R.id.schoolview);
       log_out.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent j= new Intent(Appmainlecs.this,MainActivity.class);
				startActivity(j);
				
			}
		});
		
		//Instantiates listview and populate it with actions
		ml=(ListView) findViewById(R.id.menulist);			
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,actions){
		
		//@Override
        public View getView (int position, View convertView,
                ViewGroup parent) {
            View view =super.getView(position, convertView, parent);

            TextView text1=(TextView) view.findViewById(android.R.id.text1);

            /*Sets texts attributes of the list elements*/
            text1.setTextColor(Color.BLUE);
            text1.setGravity(Gravity.CENTER);
            text1.setTextSize(20);

            return view;
        }

    };
		
    ml.setAdapter(aa);
		
		ml.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@SuppressLint("InlinedApi")
			public void onItemClick(AdapterView<?> parent, View itemClicked,
			int position, long id) {
			TextView textView = (TextView) itemClicked;
			String strText = textView.getText().toString();
			if (strText.equalsIgnoreCase(getResources().getString(
					
			R.string.Postnews))) {
			// Launch the Course Postnews Activity
				Toast.makeText(Appmainlecs.this, 
			   "Posting News", Toast.LENGTH_SHORT).show();
				Intent m= new Intent(Appmainlecs.this,Postnews.class);
				startActivity(m);
			} else if (strText.equalsIgnoreCase(getResources().getString(
					R.string.Posttimetable))) {
					// Launch the Timetable Activity
						Toast.makeText(Appmainlecs.this, 
								"Upload Timetable", Toast.LENGTH_SHORT).show();
						Intent two= new Intent(Appmainlecs.this,Timetableupload.class);
						startActivity(two);
						
					} else if (strText.equalsIgnoreCase(getResources().getString(
							
					R.string.Support))) {
					// Launch the Support Activity
						Toast.makeText(Appmainlecs.this, 
								"User Support", Toast.LENGTH_SHORT).show();
						AlertDialog dialog= new AlertDialog.Builder(Appmainlecs.this).create();
						TextView message=new TextView(Appmainlecs.this);
						message.setText("SIS User Support");
						dialog.setCustomTitle(message);
						message.setTextColor(Color.BLUE);
			            message.setGravity(Gravity.CENTER);
			            message.setTextSize(20);
						dialog.setMessage("Click On Post news to Disseminate News.You can also Upload Timetable. For Any Challanges Using the App Kindly contact: 0708000167");
						
						dialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener(){
							@SuppressWarnings("unused")
							public void onclick (Dialoginterface dialog,int which)
							{
								Intent h= new Intent(Appmainlecs.this,Appmainlecs.class);
								startActivity(h);
							}

							@Override
							public void onClick(DialogInterface arg0, int arg1) {
								// TODO Auto-generated method stub
								Intent i= new Intent(Appmainlecs.this,Appmainlecs.class);
								startActivity(i);
							}
						});
						dialog.show();
						
								
					}
					}
					
				});    	
	}}
