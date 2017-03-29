package com.example.db;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.view.View.OnClickListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	//Your Input holders fiels
	EditText fname,lname,mname;
	Button save;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fname=(EditText)findViewById(R.id.fname);
		mname=(EditText)findViewById(R.id.mname);
		lname=(EditText)findViewById(R.id.lname);
		save=(Button)findViewById(R.id.save);
		
		save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0)
			{
				
				//gets the user input
				String a=fname.getText().toString();
				String b=mname.getText().toString();
				String c=lname.getText().toString();
				
			   //Object that will make request to the server
				AsyncHttpClient client=new AsyncHttpClient();
				
				/*map your input values collecteed from the user associating each with a keywork that 
				shall be received by your script interacting with the database, in ths case php script*/
				RequestParams params=new RequestParams();
				params.put("fname", a);
				params.put("mname", b); 
				params.put("lname", c);
				
				//the post client that receive your script url as a parameter ,the params you had fed and the response handler
				client.post("http://10.0.2.2/projects/savedate.php",params, new AsyncHttpResponseHandler() {
					
					@Override
					public void onSuccess(int arg0, Header[] arg1, byte[] response) 
					{
						// Converts the response from byte to string
						String serverresponse=new String(response);
						
						//Receives the response from your script and execute an action in java
						if(serverresponse.equals("3")){
							Toast.makeText(getApplicationContext(),"All Details Required",Toast.LENGTH_LONG).show();
						}else if(serverresponse.equals("2")){
							Toast.makeText(getApplicationContext(),"Records Already in The Database",Toast.LENGTH_LONG).show();
						}else if(serverresponse.equals("4"))
						
						{Toast.makeText(getApplicationContext(),"Record Saved Successfully",Toast.LENGTH_LONG).show();}
						
						else if(serverresponse.equals("5"))
							
						{Toast.makeText(getApplicationContext(),"Problem Communicating with server",Toast.LENGTH_LONG).show();}
						
					}
					
					@Override
					public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
						Toast.makeText(getApplicationContext(),"Unable to access server",Toast.LENGTH_LONG).show();
						
					}
				});
				
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
