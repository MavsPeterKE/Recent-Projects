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
public class ConfirmCancel extends Activity {
    
    ListView confirmrefine;
    ImageView confirmButton, cancelButton;
    private static final String confirmed[]={"Edna Chelimo","James Macharia","Laurence M","Edwin Kim","Cornel Kemboi"};
    private static final String cancelled[]={"Billy Omondi","Dxnanian M","Trinty H","Valary Twin","Stacious Trguy"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmcancel);
        
        confirmButton=(ImageView)findViewById(R.id.fine24);
        confirmButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			    	confirmrefine=(ListView) findViewById(R.id.slot2list);
					ArrayAdapter<String> aa=new ArrayAdapter<String>(ConfirmCancel.this,
					android.R.layout.simple_list_item_1,confirmed);
				    confirmrefine.setAdapter(aa);
				
			}
		});
        cancelButton=(ImageView)findViewById(R.id.fine2);
        cancelButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				confirmrefine=(ListView) findViewById(R.id.slot2list);
				ArrayAdapter<String> aa=new ArrayAdapter<String>(ConfirmCancel.this,
				android.R.layout.simple_list_item_1,cancelled);
			    confirmrefine.setAdapter(aa);
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
