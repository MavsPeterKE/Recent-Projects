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
public class Receptnistmain extends Activity {
    ImageView home,search,book,confirmed,fine;
    TextView home_text,search_text,confirmed_text,book_text,fine_text;
    EditText searchkey;
    LinearLayout searchsection,searchlayout;
    ListView searchresults;
    
    private final String dummy[]={"Peter onyi","Edna Chelimo","James Masharia","Laurence Mtukutu",
    		"Cornel Kemboi","Nelson Mandela","Peter onyi","Edna Chelimo","James Masharia","Laurence Mtukutu",
    		"Cornel Kemboi","Nelson Mandela"};
    
  
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainreception);
        
        
        searchresults=(ListView)findViewById(R.id.searchresults);
        ArrayAdapter<String>aa=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,dummy);
        searchresults.setAdapter(aa);
        
        home=(ImageView)findViewById(R.id.home_icon);
        home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Redirecting to main", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.INVISIBLE);
				search_text.setVisibility(view.VISIBLE);
				book_text.setVisibility(view.VISIBLE);
				fine_text.setVisibility(view.VISIBLE);
				confirmed_text.setVisibility(view.VISIBLE);
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.INVISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.INVISIBLE);
			}
		});
        search=(ImageView)findViewById(R.id.doctor_diary);
        search.setOnClickListener(new OnClickListener() {
			
			@SuppressWarnings("static-access")
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.VISIBLE);
				Toast.makeText(getApplicationContext(), "Loading Search", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.VISIBLE);
				
				book_text.setVisibility(view.INVISIBLE);
				search_text.setVisibility(view.INVISIBLE);
				fine_text.setVisibility(view.INVISIBLE);
				confirmed_text.setVisibility(view.INVISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.VISIBLE);
				
				
				String a=searchkey.getText().toString();
				if(a.equals("")){Toast.makeText(getApplicationContext(), "Input Patient name", Toast.LENGTH_SHORT).show();}
				
				
			}
		});
        book=(ImageView)findViewById(R.id.doctor_pending);
        book.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Loading Booking interface", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.INVISIBLE);
				book_text.setVisibility(view.VISIBLE);
				fine_text.setVisibility(view.VISIBLE);
				search_text.setVisibility(view.VISIBLE);
				confirmed_text.setVisibility(view.VISIBLE);
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.INVISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.INVISIBLE);
				Intent bookslot = new Intent(Receptnistmain.this, Bookappointment.class);
                startActivity(bookslot);
			}
		});
        confirmed=(ImageView)findViewById(R.id.doctor_cancel);
        confirmed.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Confirmed Appoitments", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.INVISIBLE);
				book_text.setVisibility(view.VISIBLE);
				fine_text.setVisibility(view.VISIBLE);
				search_text.setVisibility(view.VISIBLE);
				confirmed_text.setVisibility(view.VISIBLE);
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.INVISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.INVISIBLE);
				Intent confirmed = new Intent(Receptnistmain.this, ConfirmCancel.class);
                startActivity(confirmed);
				
			}
		});
        fine=(ImageView)findViewById(R.id.fine_icon);
        fine.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Redirecting to main", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.INVISIBLE);
				book_text.setVisibility(view.VISIBLE);
				search_text.setVisibility(view.VISIBLE);
				fine_text.setVisibility(view.VISIBLE);
				confirmed_text.setVisibility(view.VISIBLE);
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.INVISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.INVISIBLE);
				Intent finespage= new Intent(Receptnistmain.this, Fines.class);
                startActivity(finespage);
			}
		});
        
        
        
        home_text=(TextView)findViewById(R.id.home_text);
        home_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Register Patient", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.INVISIBLE);
				search_text.setVisibility(view.VISIBLE);
				book_text.setVisibility(view.VISIBLE);
				fine_text.setVisibility(view.VISIBLE);
				confirmed_text.setVisibility(view.VISIBLE);
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.INVISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.INVISIBLE);
				Intent patientregi = new Intent(Receptnistmain.this, PatientsRegistry.class);
                startActivity(patientregi);
			}
		});
        search_text=(TextView)findViewById(R.id.search_text);
        search_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Loading Search ", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.VISIBLE);
				book_text.setVisibility(view.INVISIBLE);
				fine_text.setVisibility(view.INVISIBLE);
				search_text.setVisibility(view.VISIBLE);
				confirmed_text.setVisibility(view.INVISIBLE);
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.INVISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.VISIBLE);
				String a=searchkey.getText().toString();
				if(a.equals("")){Toast.makeText(getApplicationContext(), "Input Patient name", Toast.LENGTH_SHORT).show();}
			}
		});
        
        book_text=(TextView)findViewById(R.id.diary_text);
        book_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Loading Booking interface", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.INVISIBLE);
				book_text.setVisibility(view.VISIBLE);
				fine_text.setVisibility(view.VISIBLE);
				search_text.setVisibility(view.VISIBLE);
				confirmed_text.setVisibility(view.VISIBLE);
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.INVISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.INVISIBLE);
				Intent bookslot = new Intent(Receptnistmain.this, Bookappointment.class);
                startActivity(bookslot);
			}
		});
        confirmed_text=(TextView)findViewById(R.id.pending_text);
        confirmed_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Confirmed Appoitments", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.INVISIBLE);
				book_text.setVisibility(view.VISIBLE);
				fine_text.setVisibility(view.VISIBLE);
				search_text.setVisibility(view.VISIBLE);
				confirmed_text.setVisibility(view.VISIBLE);
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.INVISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.INVISIBLE);
				Intent confirmed = new Intent(Receptnistmain.this, ConfirmCancel.class);
                startActivity(confirmed);
			}
		});
        fine_text=(TextView)findViewById(R.id.cancel_text);
        fine_text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Loading Fines", Toast.LENGTH_SHORT).show();
				searchkey=(EditText)findViewById(R.id.searchkey);
				searchkey.setVisibility(view.INVISIBLE);
				book_text.setVisibility(view.VISIBLE);
				fine_text.setVisibility(view.VISIBLE);
				confirmed_text.setVisibility(view.VISIBLE);
				searchsection=(LinearLayout)findViewById(R.id.search_section);
				searchsection.setVisibility(view.INVISIBLE);
				search_text.setVisibility(view.VISIBLE);
				searchlayout=(LinearLayout)findViewById(R.id.searchlayout);
				searchlayout.setVisibility(view.INVISIBLE);
				Intent finespage= new Intent(Receptnistmain.this, Fines.class);
                startActivity(finespage);
			}
		});
       
    }
    
}
