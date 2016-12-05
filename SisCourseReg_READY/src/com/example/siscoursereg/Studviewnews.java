package com.example.siscoursereg;

/*
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Studviewnews extends Activity {


  TextView leccommunicator;
  TextView newsbody;
  ListView news;
  @Override
  public void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.studviewnews);
  StrictMode.enableDefaults(); //STRICT MODE ENABLED
 
 
 leccommunicator = (TextView) findViewById(R.id.leccommunicator);
 newsbody = (TextView) findViewById(R.id.news_body);
 
 getData();
 }
 
 public void getData(){
 String result = "";
 InputStream isr = null;
 try{
 HttpClient httpclient = new DefaultHttpClient();
 HttpPost httppost = new HttpPost("http://10.0.2.2/Projects/viewsnews.php");
 HttpResponse response = httpclient.execute(httppost);
 HttpEntity entity = response.getEntity();
 isr = entity.getContent();
 }
 catch(Exception e){
 Log.e("log_tag", "Error in http connection "+e.toString());
 //nameView.setText("Couldnt connect to database");
 }
 //convert response to string
 try{
 BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
 StringBuilder sb = new StringBuilder();
 String line = null;
 while ((line = reader.readLine()) != null) {
 sb.append(line + "\n");
 }
 isr.close();
 
 result=sb.toString();
}
 catch(Exception e){
 Log.e("log_tag", "Error converting result "+e.toString());
 }
 
 //parse json data
 try {
// String n = "";
 String a="";
 String b="";
 
 JSONArray jArray = new JSONArray(result);
 
 String [] retrievd = result.split("#");
 for(int i=0; i<jArray.length();i++){
 JSONObject json = jArray.getJSONObject(i);
 //n = n + "Name : "+json.getString("FirstName")+" "+json.getString("LastName")+"\n";
 a= a +json.getString("lecturer_name")+"\n";
 b= b +json.getString("news")+"\n";
}
 

 leccommunicator.setText(a);
 newsbody.setText(b);
	
news=(ListView)findViewById(R.id.newslist);
int  layoutID= R.layout.viewnews;
ArrayAdapter<String> cc = new ArrayAdapter<String>(this, layoutID, retrievd);
news.setAdapter(cc);


 
 } catch (Exception e) {
 
 Log.e("log_tag", "Error Parsing Data "+e.toString());
 }
 
 }}*/


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;





import android.R.string;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.ListActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Studviewnews extends Activity {
	InputStream inputStream;
	HttpClient httpclient;
	HttpPost httppost;
    List<NameValuePair> nameValuePairs;
    StringBuffer sb;
    String Splitteddata;
    String line, result, number;
    String lecturer_name ;
    String news_retrived ;
    byte[] data;
    ArrayAdapter<?> aa;
    ListView news;
    //Button dismiss;
    private static final String news_sent [] = {"Korongo: Submitt all your cats by Tuesday","Gichoya: I will not be availabe for our next class. Find assignment on the email",
    	"Moseti: Everyone should submit project proposal before end week","Samoei: Our network server is down. " +
    			"There shall be no internet up to monday. Kindly bare with us.","Owino: Find updated timetable version from my website",
    			"Gudu:For our tomorrow's Multimedia Class, Come with Your digital Cameras",
    			"Dean:All students are notified that no exam cards shall be issued without fee clearance",
    			"Korongo:Trip tomorrow lets meet at school 8am","Dean:MUISA Aspirants to submit their nomination papers"};

 @Override
 public void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.studviewnews);
 
  // dismiss = (Button) findViewById(R.id.dismiss);
   
   
  

 /*try {
	 TextView leccommunicator=(TextView) findViewById(R.id.leccommunicator);
	 TextView news_body=(TextView) findViewById(R.id.news_body);
	 
	 
     httpclient = new DefaultHttpClient();
     
     HttpPost httppost = new HttpPost("http://10.0.2.2/Projects/viewsnews.php");
     	                    
     HttpResponse response = httpclient.execute(httppost);
     
     InputStream inputStream = response.getEntity().getContent();
     
     BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream), 4096);
     String line;
     StringBuilder sb =  new StringBuilder();
     
     while ((line = rd.readLine()) != null) {
     		sb.append(line);
     }
     rd.close();
     String result = sb.toString();
     
     inputStream.close();
        
     String [] retrievd = result.split("#");
     leccommunicator.setText("Lecturer Name:"+ retrievd[3]);
     news_body.setText( retrievd[3]);	
//				
				/*int  layoutID= R.layout.viewnews;
				aa= new ArrayAdapter<String>(this, layoutID, retrievd);
				news.setAdapter(aa);*/
			
              news = (ListView) findViewById(R.id.newslist);
				ArrayAdapter<String> aa=new ArrayAdapter<String>(this,
						android.R.layout.simple_list_item_1,news_sent);
				news.setAdapter(aa);	
 /*}
    /*    catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Error inside set:"+e.toString(), Toast.LENGTH_LONG).show();
        }*/
      /*dismiss.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Studviewnews.this, Appmain.class);
		startActivity(intent);
	}
});*/
}

}
