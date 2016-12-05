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

public class Commoncourses extends Activity  {
	TextView coursecommon,next_common;
	ListView common_courseslist;
	
	//Informatics course codes
	private static final String informatics_firstyear_sem1 [] = {"INF103","INF104","INF110","INF100","INF101",
		"INF102","IRD100","IRD103"};
	private static final String informatics_firstyear_sem2 [] = {"INF105","INF106","INF111","INF112","INF120",
		"INF130","INF131","IRD102"};
	//informatics second years
	private static final String informatics_secondyear_sem1 [] ={"INF210","INF211","INF230","INF240","INF41",
		"INF260","INF290","IRD200"};
	private static final String informatics_secondyear_sem2 [] = {"INF220","INF231","INF242","INF243","INF244",
		"INF245","INF290"};
	//informatics third years
	private static final String informatics_thirdyear_sem1 [] = {"INF310","INF311","INF312","INF330","INF331",
		"INF360","INF370"};
	private static final String informatics_thirdyear_sem2 [] = {"INF313","INF314","INF332","INF340","INF350",
		"INF371","INF131"};
	//informatics fourth years
	private static final String informatics_fourthyear_sem1 [] ={"INF430","INF440","INF410","INF490"};
	private static final String informatics_fourthyear_sem1electives [] ={"INF442E","INF450E","INF460E","INF470E"};
	private static final String informatics_fourthyear_sem2 [] = {"INF411","INF441","INF461","INF490"};
	private static final String informatics_fourthyear_sem2electives [] ={"INF431E","INF443E","INF444E","INF451E"};
	
	
	   //information first years sciences course codes
		private static final String is_firstyear_sem1 [] = {"INS110","INS111","INS112","INS113","INS114",
			"INS115","INS116","INS117"};
		private static final String is_firstyear_sem2 [] = {"INF111","INF130","INS120","INS120","INS121",
			"INS122","INS123","INS124","INS125"};
		
		//second years information sciences
		private static final String is_secondyear_sem1 [] = {"INS210","INF211","INF212","INS213","INS214",
			"INS215","INF216","INS217"};
		private static final String is_secondyear_sem2 [] = {"INS220","INS221","INS222","INS223","INS224",
			"INS225","INF226","INS227"};
		
		//thirtd years information sciences
		private static final String is_thirdyear_sem1common [] = {"INS302","INS303","INF304","INF330"};
		private static final String is_thirdyear_sem1speclzn_IT [] = {"INS320","INS321","INF322","INF323"};
		private static final String is_thirdyear_sem1speclzn_library [] = {"INS322","INS330","INF331","INS232"};
		private static final String is_thirdyear_sem2common [] = {"INS305","INS306","INS307","INS308"};
		private static final String is_thirdyear_sem2_IT [] = {"INF350","INS324","INS326","INS327"};
		private static final String is_thirdyear_sem2_LIB [] = {"INS340","INS341","INS342","INS343"};
		private static final String is_thirdyear_sem2_RAM [] = {"INS322","INS350","INS351","INS352"};
		private static final String is_thirdyear_sem2_PM [] =  {"INS340","INS341","INS342","INS343"};
		
		
		//fourth years information sciences
		private static final String is_fourthyear_sem1common [] ={"INF410","INS401","INS402","INS403","INS404"};
		private static final String is_fourthyear_sem1_IT [] ={"INF410","INS401","INS402","INS403","INS404"};
		private static final String is_fourthyear_sem1_LIB_ [] ={"INS430","INS431"};
		private static final String is_fourthyear_sem1_RAM [] ={"INS450","INS451"};
		private static final String is_fourthyear_sem1_PM [] ={"INS440","INS441"};
		private static final String is_fourthyear_sem2common [] ={"INF411","INS405","INS406","INS407","INS408"};
		private static final String is_fourthyear_sem2_IT [] = {"INF444","INF461"};
		private static final String is_fourthyear_sem2_LIB[] ={"INS432","INS433"};
		private static final String is_fourthyear_sem2_PM[] ={"INS442","INS410"};
		private static final String is_fourthyear_sem2_RAM[] ={"INS452","INS453"};

		   //information first years sciences course codes
			private static final String ms_firstyear_sem1 [] = {"MES110","MES111","IRD100","IRD101","IRD103"};
			private static final String ms_firstyear_sem1_electives [] = {"FRE101","BLL11","BLL116"};
			private static final String ms_firstyear_sem2 [] = {"MES120","MES121","IRD104"};
			private static final String ms_firstyear_sem2_electives [] = {"KIS110","FRE102","ENG214","LIT110"};
			
			//second years media sciences
			private static final String ms_secondyear_sem1 [] = {"MES210","INS214","MES214","INS212","MES216"};
			private static final String ms_secondyear_sem2 [] = {"INS216","INS218","INS221","INS223","MES220",
				"MES221","IRD200"};
			
			//thirtd years information sciences
			private static final String is_thirdyear_sem1 [] = {"INS310","INS313","MES312","MES313","MES312","MES313","IRD305"};
			private static final String is_thirdyear_sem2 [] =  {"INS319","INS321","MES317","MES320","MES321","MES322","MES323"};
			
			
			//fourth years information sciences
			private static final String is_fourthyear_sem1 [] ={"MES440","MES421","MES422","MES423","MES425","MES426","MES430"};
		;
			
			
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commoncourses); 
		//Headers
		coursecommon=(TextView) findViewById(R.id.course_common);
		next_common=(TextView) findViewById(R.id.next_common);
		next_common.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent elective= new Intent(Commoncourses.this,Electivecourses.class);
				startActivity(elective);
			}
		});
		
		Intent retrieve_senduser_details = getIntent();
	     String reg_no = retrieve_senduser_details.getStringExtra("reg_no");
	     String course = retrieve_senduser_details.getStringExtra("course");
	     String year = retrieve_senduser_details.getStringExtra("year");
	     String semester = retrieve_senduser_details.getStringExtra("semester");
	    coursecommon.setText( "Core Courses For:     "+reg_no);
		
	    //if(course=="Informatics" || year=="1st Year" || semester=="Semester 1")
	     //    {
	    	common_courseslist=(ListView) findViewById(R.id.common_courseslist);
			ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_multiple_choice,informatics_firstyear_sem1);
			common_courseslist.setAdapter(aa);		
			
	       // }
		//Setting content to spinner list using array adapter
		
		
		
		
	
	}}
	    


