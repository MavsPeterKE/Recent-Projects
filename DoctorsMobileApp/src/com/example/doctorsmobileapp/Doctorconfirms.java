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
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class Doctorconfirms extends Activity {
    ListView doctorconfirmlist;
    Button submitconfirmations;
    private static final String confirmed[]={"Edna Chelimo","James Macharia","Laurence M","Edwin Kim","Cornel Kemboi"};
    private static final String doctorsA[]={"Dr. Edna Chelimo","Dr James Macharia","Dr. Laurence M","Dr. Edwin Kim","Dr.Cornel Kemboi"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorconfirm); 
    	doctorconfirmlist=(ListView) findViewById(R.id.slot2list);
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_multiple_choice,confirmed);
		aa.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
		doctorconfirmlist.setAdapter(aa);
		
		submitconfirmations=(Button)findViewById(R.id.confirmationsButton);
	       submitconfirmations.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Confirmation Submitted Successfully", Toast.LENGTH_SHORT).show();
				Intent confirms=new Intent(Doctorconfirms.this,Doctorsmain.class);
				startActivity(confirms);
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
