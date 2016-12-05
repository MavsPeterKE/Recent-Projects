package com.example.siscoursereg;

import android.os.Bundle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.app.AlertDialog;


import android.view.View.OnClickListener;
import android.graphics.Color; 
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Appmain<Dialoginterface> extends Activity {
	TextView menu,log_out;
	ListView ml;
	ImageView rightimage,leftimage,schoolview;

	
	private static final String actions []={"Register Courses","School Timetable",
		"News","User Support"};
	protected static final Context Context = null;
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
		//Inputs
		
		log_out.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent j= new Intent(Appmain.this,MainActivity.class);
				startActivity(j);
				
			}
		});
		
		//Adding List elements
		ml=(ListView) findViewById(R.id.menulist);			
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1,actions){
		
		//@Override
        public View getView (int position, View convertView,
                ViewGroup parent) {
            View view =super.getView(position, convertView, parent);

            TextView text1=(TextView) view.findViewById(android.R.id.text1);

            /*Sets The color, alignment and fontsize of the list elements as specified*/
            text1.setTextColor(Color.BLUE);
            text1.setGravity(Gravity.CENTER);
            text1.setTextSize(20);

            return view;
        }

    };
		
    ml.setAdapter(aa);
		
    //Sets actions when list elements are clicked
		ml.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@SuppressLint("InlinedApi")
			public void onItemClick(AdapterView<?> parent, View itemClicked,
			int position, long id) {
			TextView textView = (TextView) itemClicked;
			String strText = textView.getText().toString();
			if (strText.equalsIgnoreCase(getResources().getString(
					
			R.string.Register_Courses))) {
			// Launch the Course Registration Activity
				Toast.makeText(Appmain.this, 
			   "Register Courses", Toast.LENGTH_SHORT).show();
				Intent w= new Intent(Appmain.this,Userdetails.class);
				startActivity(w);

			} else if (strText.equalsIgnoreCase(getResources().getString(
			R.string.School_Timetable))) {
			// Launch the Timetable Activity
				Toast.makeText(Appmain.this, 
						"View Timetable", Toast.LENGTH_SHORT).show();
				Intent n= new Intent(Appmain.this,Timetabledownload.class);
				startActivity(n);
				
			} else if (strText.equalsIgnoreCase(getResources().getString(
			R.string.News))) {
			// Launch the News Activity
				Toast.makeText(Appmain.this, 
						"View News", Toast.LENGTH_SHORT).show();
				Intent g= new Intent(Appmain.this,Studviewnews.class);
				startActivity(g);
			} else if (strText.equalsIgnoreCase(getResources().getString(
					
			R.string.Support))) {
			// Launch Support Dialog
				Toast.makeText(Appmain.this, 
						"User Support", Toast.LENGTH_SHORT).show();
				AlertDialog dialog= new AlertDialog.Builder(Appmain.this).create();
				TextView message=new TextView(Appmain.this);
				message.setText("SIS User Support");
				dialog.setCustomTitle(message);
				message.setTextColor(Color.BLUE);
	            message.setGravity(Gravity.CENTER);
	            message.setTextSize(20);
				dialog.setMessage("Click RegisterCourse  for courses Registration, View News from lectures and Download timetable. " +
						"For any challanges and issues kindly contact:0708000167");
				
				dialog.setButton(DialogInterface.BUTTON_POSITIVE,"OK", new DialogInterface.OnClickListener(){
					@SuppressWarnings("unused")
					public void onclick (Dialoginterface dialog,int which)
					{
						Intent h= new Intent(Appmain.this,Appmain.class);
						startActivity(h);
					}

					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// TODO Auto-generated method stub
						Intent i= new Intent(Appmain.this,Appmain.class);
						startActivity(i);
					}
				});
				dialog.show();
				
				
			
	
	
			}
			}
			
		});    
	}}
