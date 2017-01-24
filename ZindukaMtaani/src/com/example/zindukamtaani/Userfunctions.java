package com.example.zindukamtaani;

import android.R.color;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Userfunctions extends Activity {
	TextView events,news,jobs,events_anime,news_anime,user_insights,personal,job_select;
	RelativeLayout eventscomponent,newscomponent,user_anime,jobscomponent,personal_component;
    ListView townlist;
    Dialog townsdialogue,newsdialog,jobsdialog;
    
    public static final String towns[]={"Nairobi","Mombasa","Nakuru","Eldoret","Thika","Kitale","Garissa","Kiambu","Kisumu","Malindi","Kakamega","Machakos"};
    public static final String news_items[]={"Technology","Business","Sports","Politics","Education","Entertainment","Lifestyle"};
    public static final String jobs_items[]={"Employment","Internships"};
    @SuppressWarnings("rawtypes")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userfunctions);
        getActionBar().hide();
        
        //Initializing Textviews
        events=(TextView)findViewById(R.id.events);
        personal=(TextView)findViewById(R.id.personalize);
        job_select=(TextView)findViewById(R.id.job_select);
        news=(TextView)findViewById(R.id.news);
        jobs=(TextView)findViewById(R.id.jobs);
        events_anime=(TextView)findViewById(R.id.events_towns);
        news_anime=(TextView)findViewById(R.id.news_type);
        user_insights=(TextView)findViewById(R.id.user_insights);
        
        events_anime.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void onClick(View v) {
				
				//Dialog Containing List Items That user Selects
				townsdialogue = new Dialog(v.getContext());
		        townsdialogue.setTitle("Select Town");
		        setTitleColor(color.holo_green_light);
		        
		        // Customize Dialogue Background
		        townsdialogue.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
		        
		        //Add Listview Items to the dialogue
		        LayoutInflater li = (LayoutInflater) v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		        View t = li.inflate(R.layout.towns, null, false);
		        townsdialogue.setContentView(t);
		        townsdialogue.setCancelable(true);
		       
		        //Defining the listview
		        ListView list1 = (ListView) townsdialogue.findViewById(R.id.townlist);
		        list1.setChoiceMode(list1.CHOICE_MODE_SINGLE);
		        
		        //Add custom content to the Dialog
		         list1.setAdapter(new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_multiple_choice, towns));
		         list1.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int pos, long arg3) {
						// TODO Auto-generated method stub
						Toast toast= Toast.makeText(Userfunctions.this,"Click on Events To Proceed", Toast.LENGTH_SHORT);
						toast.setGravity(Gravity.CENTER|Gravity.CENTER_VERTICAL,10,10);
						toast.show();
			            events_anime.setText(towns[pos]);			
						
						townsdialogue.dismiss();
					}
				});
		        townsdialogue.show();
		         
		      
		         
        
        news_anime.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				newsdialog = new Dialog(v.getContext());
		        newsdialog.setTitle("Select Category");
		        setTitleColor(color.holo_green_light);
		        newsdialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
		        LayoutInflater li = (LayoutInflater) v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		        View t = li.inflate(R.layout.news, null, false);
		        newsdialog.setContentView(t);
		        newsdialog.setCancelable(true);
		        ListView list2 = (ListView) newsdialog.findViewById(R.id.newslist);
		        list2.setChoiceMode(list2.CHOICE_MODE_SINGLE);
		         //Add custom content to the Dialog
		        list2.setAdapter(new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_multiple_choice, news_items));
		        list2.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int pos, long arg3) {
						// TODO Auto-generated method stub
						news_anime.setText(news_items[pos]);
						newsdialog.dismiss();
						
					}
				});
		        newsdialog.show();
			}
			 
		});
      job_select.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				jobsdialog = new Dialog(v.getContext());
		        jobsdialog.setTitle("Select Category");
		        setTitleColor(color.holo_green_light);
		        jobsdialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog);
		        LayoutInflater li = (LayoutInflater) v.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		        View t = li.inflate(R.layout.jobs, null, false);
		        jobsdialog.setContentView(t);
		        jobsdialog.setCancelable(true);
		        ListView list3 = (ListView) jobsdialog.findViewById(R.id.jobslist);
		        list3.setChoiceMode(list3.CHOICE_MODE_SINGLE);
		         
		        //Add custom content to the Dialog
		        list3.setAdapter(new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_list_item_multiple_choice, jobs_items));
		        list3.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1,
							int pos, long arg3) {
						// TODO Auto-generated method stub
						job_select.setText(jobs_items[pos]);
						jobsdialog.dismiss();
					}
				});
		        jobsdialog.show();
			}
		});
      
      
        //Initializing Layouts
        eventscomponent=(RelativeLayout)findViewById(R.id.eventscomponent);
        newscomponent=(RelativeLayout)findViewById(R.id.newscomponents);
        jobscomponent=(RelativeLayout)findViewById(R.id.jobscomponent);
        jobscomponent=(RelativeLayout)findViewById(R.id.jobscomponent);
        user_anime=(RelativeLayout)findViewById(R.id.app_anime);
        personal_component=(RelativeLayout)findViewById(R.id.personalcomponent);
        
        eventscomponent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Streaming Events", Toast.LENGTH_LONG).show();
			}
		});
        
       newscomponent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Incoming News", Toast.LENGTH_LONG).show();
			}
		});
       jobscomponent.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Jobs And Internships Updates", Toast.LENGTH_LONG).show();
			}
		});
       personal_component.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Personalized Services", Toast.LENGTH_LONG).show();
			}
		});
       
       
			}});
        
    }
        protected void onPause() {
        super.onPause();
        finish();
        
        }
        }

