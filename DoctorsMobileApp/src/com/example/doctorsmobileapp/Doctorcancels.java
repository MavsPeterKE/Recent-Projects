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
public class Doctorcancels extends Activity {
    ListView doctorcancellist;
    Button submitcancels;
    private static final String cancelled[]={"Billy Omondi","Dxnanian M","Trinty H","Valary Twin","Stacious Trguy"};
    private static final String doctorsA[]={"Dr. Edna Chelimo","Dr James Macharia","Dr. Laurence M","Dr. Edwin Kim","Dr.Cornel Kemboi"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctorcancel); 
    	doctorcancellist=(ListView) findViewById(R.id.slot2list);
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
		android.R.layout.simple_list_item_multiple_choice,cancelled);
		aa.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
		doctorcancellist.setAdapter(aa);
       submitcancels=(Button)findViewById(R.id.submitconfirmButton);
       submitcancels.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(), "Cancellations Submitted Successfully", Toast.LENGTH_SHORT).show();
			Intent cancel=new Intent(Doctorcancels.this,Doctorsmain.class);
			startActivity(cancel);
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
