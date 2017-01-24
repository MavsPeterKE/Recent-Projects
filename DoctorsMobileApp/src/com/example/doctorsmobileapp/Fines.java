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
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Fines extends Activity {
    
    ListView fineslist;
    ImageView fine24Button, fine500Button;
    private static final String fines24[]={"Lazy Haron","Drustart Twan","Phinty Dawin","Olesembei Twds","Ricky Steve"};
    private static final String fines500[]={"Marvin stania","Hillary Gredty","Nelson Stanyt","Vicky Trady","Olemanty Stve"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fines);
        
        fine24Button=(ImageView)findViewById(R.id.fine24);
        fine24Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			    	fineslist=(ListView) findViewById(R.id.slot2list);
					ArrayAdapter<String> aa=new ArrayAdapter<String>(Fines.this,
					android.R.layout.simple_list_item_1,fines24);
				    fineslist.setAdapter(aa);
				    Toast.makeText(getApplicationContext(), "Cancelled Confirmed Appointment within 24hrs", Toast.LENGTH_SHORT).show();
				   
				
			}
		});
       fine500Button=(ImageView)findViewById(R.id.fine2);
        fine500Button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				fineslist=(ListView) findViewById(R.id.slot2list);
				ArrayAdapter<String> aa=new ArrayAdapter<String>(Fines.this,
				android.R.layout.simple_list_item_1,fines500);
			    fineslist.setAdapter(aa);
			    Toast.makeText(getApplicationContext(), "Failed to Honour Confirmed Appointment", Toast.LENGTH_SHORT).show();
			   
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
