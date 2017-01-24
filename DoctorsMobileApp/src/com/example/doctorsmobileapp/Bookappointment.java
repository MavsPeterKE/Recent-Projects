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
public class Bookappointment extends Activity {
    
    Spinner doctors;
    private static final String doctorsA[]={"Dr. Edna Chelimo","Dr James Macharia","Dr. Laurence M","Dr. Edwin Kim","Dr.Cornel Kemboi"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookslot); 
    	doctors=(Spinner) findViewById(R.id.selectdoctor);
		ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item,doctorsA);
		aa.setDropDownViewResource(
		android.R.layout.simple_spinner_dropdown_item);
		doctors.setAdapter(aa);
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
