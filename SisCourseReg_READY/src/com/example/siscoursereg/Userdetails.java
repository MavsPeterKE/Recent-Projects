package com.example.siscoursereg;



import java.io.BufferedReader;
import org.xml.sax.Parser;
import java.io.ObjectOutputStream.PutField;
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
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

@SuppressWarnings({ "unused", "deprecation" })
public class Userdetails extends Activity  {
	TextView userid,studentscourse,studentyear_current,next_userid,studentyear_currentsem;
	EditText studid_input;

	public Spinner studentscourse_input,stud_yearcurrent_input,semester;
	private static final String year [] = {"1st Year","2nd Year","3rd Year","4th Year"};
	private static final String departments [] = {"Informatics","Information Science","Media Science"};
	private static final String semester_choice [] = {"Semester 1","Semester 2"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.userdetails); 
		//Headers
		userid=(TextView) findViewById(R.id.user_id);
		studentscourse=(TextView) findViewById(R.id.students_course);
		studentyear_current=(TextView) findViewById(R.id.student_yearcurrent);
		next_userid=(TextView) findViewById(R.id.next_userid);
		studentyear_currentsem=(TextView) findViewById(R.id.student_currentsem);
		next_userid.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 
				Intent parse_userdetails = new Intent(Userdetails.this, Commoncourses.class); 
				parse_userdetails.putExtra("reg_no", studid_input.getText().toString());
				parse_userdetails.putExtra("course",studentscourse_input.getSelectedItem().toString());
				parse_userdetails.putExtra("year", stud_yearcurrent_input.getSelectedItem().toString());
				parse_userdetails.putExtra("semester", semester.getSelectedItem().toString());
			    startActivity(parse_userdetails);
			    
			    Intent senddetails = new Intent(Userdetails.this, Electivecourses.class); 
			    senddetails.putExtra("reg_no", studid_input.getText().toString());
			    senddetails.putExtra("course",studentscourse_input.getSelectedItem().toString());
			    senddetails.putExtra("year", stud_yearcurrent_input.getSelectedItem().toString());
			    senddetails.putExtra("semester", semester.getSelectedItem().toString());
			    startActivity(senddetails);
			}
		});
		
		//Inputs
		studid_input=(EditText) findViewById(R.id.studid_input);
		//spinner_course = getString(resId, formatArgs)
		
		studentscourse_input=(Spinner) findViewById(R.id.studentscourse_input);
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item,departments);
		aa.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
		studentscourse_input.setAdapter(aa);
		studentscourse_input.setOnItemSelectedListener(new OnItemSelectedListener()
		 {
				public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Userdetails.this, "Selected",Toast.LENGTH_SHORT).show();
				}

				public void onNothingSelected(AdapterView<?> arg0) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Userdetails.this, "Nothing Selected",Toast.LENGTH_SHORT).show();
				}
			
		 });
		stud_yearcurrent_input=(Spinner) findViewById(R.id.stud_yearcurrent_input);
		ArrayAdapter<String> bb=new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item,year);
		bb.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
		stud_yearcurrent_input.setAdapter(bb);
		stud_yearcurrent_input.setOnItemSelectedListener(new OnItemSelectedListener()
		 {
				public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Userdetails.this, "Selected",Toast.LENGTH_SHORT).show();
				}

				public void onNothingSelected(AdapterView<?> arg0) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Userdetails.this, "Nothing Selected",Toast.LENGTH_SHORT).show();
				}
			
		 });
		semester=(Spinner) findViewById(R.id.semester_input);
		ArrayAdapter<String> cc=new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item,semester_choice);
		cc.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
		semester.setAdapter(cc);
		semester.setOnItemSelectedListener(new OnItemSelectedListener()
		 {
				public void onItemSelected(AdapterView<?> arg0, View arg1, int index, long arg3) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Userdetails.this, "Selected",Toast.LENGTH_SHORT).show();
				}

				public void onNothingSelected(AdapterView<?> arg0) 
				{
					// TODO Auto-generated method stub
					Toast.makeText(Userdetails.this, "Nothing Selected",Toast.LENGTH_SHORT).show();
				}
			
		 });
		
	}}