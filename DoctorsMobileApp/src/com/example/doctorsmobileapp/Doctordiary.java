package com.example.doctorsmobileapp;

import org.apache.http.Header;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.R.anim;
import android.R.layout;
import android.os.Build;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class Doctordiary extends Activity {
     Switch switchd1,switchd2,switchd3,switchd4;
    ListView slot1list,slot2list,slot3list,slot4list;
    private static final String slot1[]={"Edna Chelimo","James Macharia","Laurence M","Edwin Kim","Cornel Kemboi",
    	"Peter Maina","Ducan tuwan","Tracy Banty","Elizabeth Thwai","Dixon cnede","David matry","Lilian tranty","Francis Bri"};
    private static final String []s1empty={""};
    private static final String slot2[]={"Elizabeth Thwai","Dixon cnede","Edna Chelimo","James Macharia","Laurence M","Edwin Kim","Cornel Kemboi",
    	"Peter Maina","Ducan tuwan","Tracy Banty","David matry","Lilian tranty","Francis Bri"};
    
    private static final String slot3[]={"Dixon cnede","David matry","Lilian tranty","Edna Chelimo","James Macharia","Laurence M","Edwin Kim","Cornel Kemboi",
    	"Peter Maina","Ducan tuwan","Tracy Banty","Elizabeth Thwai","Francis Bri"};
    
    private static final String slot4[]={"Tracy Banty","Elizabeth Thwai","Dixon cnede","David matry","Edna Chelimo","James Macharia","Laurence M","Edwin Kim","Cornel Kemboi",
    	"Peter Maina","Ducan tuwan","Lilian tranty","Francis Bri"};
   
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_diary); 
    	
        
            	slot1list=(ListView)findViewById(R.id.slot1lst);
               ArrayAdapter<String> saa=new ArrayAdapter<String>(Doctordiary.this,
   					android.R.layout.simple_list_item_1,slot1);
   				    slot1list.setAdapter(saa);
   				    
   				 slot2list=(ListView)findViewById(R.id.slot2lst);
                 ArrayAdapter<String> s2aa=new ArrayAdapter<String>(Doctordiary.this,
     					android.R.layout.simple_list_item_1,slot2);
     				    slot2list.setAdapter(s2aa);
     				    
     				   slot3list=(ListView)findViewById(R.id.slot3lst);
     	               ArrayAdapter<String> s3aa=new ArrayAdapter<String>(Doctordiary.this,
     	   					android.R.layout.simple_list_item_1,slot3);
     	   				    slot3list.setAdapter(s3aa);
     	   				    
     	   				slot4list=(ListView)findViewById(R.id.slot4lst);
     	               ArrayAdapter<String> s4aa=new ArrayAdapter<String>(Doctordiary.this,
     	   					android.R.layout.simple_list_item_1,slot4);
     	   				    slot4list.setAdapter(s4aa);

        
    }
    
    
 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
