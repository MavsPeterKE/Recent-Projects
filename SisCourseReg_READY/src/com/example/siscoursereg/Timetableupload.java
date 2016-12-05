package com.example.siscoursereg;



import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Timetableupload extends Activity  {
	TextView download_link,alternative,file_location;
	EditText link_input;
	Button post_link,upload_file;
	int serverResponseCode = 0;
    ProgressDialog dialog = null;
    String upLoadServerUri = null;
    
    /**********  File Path *************/
    final String uploadFilePath = "/mnt/sdcard/";
    final String uploadFileName = "service_lifecycle.png";
     
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.uploadtimetable); 
		//Headers
		download_link=(TextView) findViewById(R.id.posted_Link);
		alternative=(TextView) findViewById(R.id.alternative);
		file_location=(TextView) findViewById(R.id.file_location);
		link_input=(EditText) findViewById(R.id.link_input);
		post_link=(Button) findViewById(R.id.post_link);
		upload_file=(Button) findViewById(R.id.Upload_file);
		
		post_link.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				try{
			           //Toast.makeText(Students_reg.this, "Account Successfully Created", Toast.LENGTH_SHORT).show();
			           
					     String a = link_input.getText().toString();
			        	 DefaultHttpClient httpclient = new DefaultHttpClient();
				           
				         HttpPost httppost = new HttpPost("http://10.0.2.2/Projects/postlink.php");
				         // Add your data
				       
				         
				            // Execute HTTP Post Request
				         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				          nameValuePairs.add(new BasicNameValuePair("link", a));  
				          
				          httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
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
				            if(result.equals("2")){
					        	 Toast.makeText(getApplicationContext(), "Sorry Cannot Copy Duplicate Link", Toast.LENGTH_LONG).show();
					        	 
					         }
				            else if(result.equals("4")){
				            	 Toast.makeText(getApplicationContext(), "Link Posted Successfully", Toast.LENGTH_LONG).show();
				            	 Intent one = new Intent (getApplicationContext(), Appmainlecs.class);
				 				startActivity(one);
				            }else if(result.equals("3")){
				            
				            	 Toast.makeText(getApplicationContext(), "No link to Post", Toast.LENGTH_LONG).show();
				            }
							}
				            catch (Exception e)
				            {
				                Toast.makeText(getApplicationContext(), "Error inside set:"+e.toString(), Toast.LENGTH_LONG).show();
				            }
					
						}
		});
		file_location.setText("Uploading file path :- '/mnt/sdcard/"+uploadFileName+"'");
        
        /************* Php script path ****************/
        upLoadServerUri = "http://10.0.2.2/Projects/Uploadtimetable.php";
        upload_file.setOnClickListener(new OnClickListener() {            
            @Override
            public void onClick(View v) {
                 
                dialog = ProgressDialog.show(Timetableupload.this, "", "Uploading file...", true);
                 
                new Thread(new Runnable() {
                        public void run() {
                             runOnUiThread(new Runnable() {
                                    public void run() {
                                        file_location.setText("uploading started.....");
                                    }
                                });                     
 
                           
                             uploadFile(uploadFilePath + "" + uploadFileName);
                                                      
                        }
                      }).start();        
                }
            });
    }
      
    public int uploadFile(String sourceFileUri) {
           
           
          String fileName = sourceFileUri;
  
          HttpURLConnection conn = null;
          DataOutputStream dos = null;  
          String lineEnd = "\r\n";
          String twoHyphens = "--";
          String boundary = "*****";
          int bytesRead, bytesAvailable, bufferSize;
          byte[] buffer;
          int maxBufferSize = 1 * 1024 * 1024; 
          File sourceFile = new File(sourceFileUri); 
           
          if (!sourceFile.isFile()) {
               
               dialog.dismiss(); 
                
               Log.e("uploadFile", "Source File not exist :"
                                   +uploadFilePath + "" + uploadFileName);
                
               runOnUiThread(new Runnable() {
                   public void run() {
                     file_location.setText("Source File not exist :"
                               +uploadFilePath + "" + uploadFileName);
                   }
               }); 
                
               return 0;
            
          }
          else
          {
               try { 
                    
                     // open a URL connection to the Servlet
                   FileInputStream fileInputStream = new FileInputStream(sourceFile);
                   URL url = new URL(upLoadServerUri);
                    
                   // Open a HTTP  connection to  the URL
                   conn = (HttpURLConnection) url.openConnection(); 
                   conn.setDoInput(true); // Allow Inputs
                   conn.setDoOutput(true); // Allow Outputs
                   conn.setUseCaches(false); // Don't use a Cached Copy
                   conn.setRequestMethod("POST");
                   conn.setRequestProperty("Connection", "Keep-Alive");
                   conn.setRequestProperty("ENCTYPE", "multipart/form-data");
                   conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                   conn.setRequestProperty("uploaded_file", fileName); 
                    
                   dos = new DataOutputStream(conn.getOutputStream());
          
                  dos.writeBytes(twoHyphens + boundary + lineEnd); 
                   dos.writeBytes("Content-Disposition: form-data; name=");
                    
                   dos.writeBytes(lineEnd);
          
                   // create a buffer of  maximum size
                   bytesAvailable = fileInputStream.available(); 
          
                   bufferSize = Math.min(bytesAvailable, maxBufferSize);
                   buffer = new byte[bufferSize];
          
                   // read file and write it into form...
                   bytesRead = fileInputStream.read(buffer, 0, bufferSize);  
                      
                   while (bytesRead > 0) {
                        
                     dos.write(buffer, 0, bufferSize);
                     bytesAvailable = fileInputStream.available();
                     bufferSize = Math.min(bytesAvailable, maxBufferSize);
                     bytesRead = fileInputStream.read(buffer, 0, bufferSize);   
                      
                    }
          
                   // send multipart form data necesssary after file data...
                   dos.writeBytes(lineEnd);
                   dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);
          
                   // Responses from the server (code and message)
                   serverResponseCode = conn.getResponseCode();
                   String serverResponseMessage = conn.getResponseMessage();
                     
                   Log.i("uploadFile", "HTTP Response is : "
                           + serverResponseMessage + ": " + serverResponseCode);
                    
                   if(serverResponseCode == 200){
                        
                       runOnUiThread(new Runnable() {
                            public void run() {
                                 
                                String msg = "File Upload Completed.\n\n See uploaded file here : \n\n"
                                              +" http://www.androidexample.com/media/uploads/"
                                              +uploadFileName;
                                 
                                file_location.setText(msg);
                                Toast.makeText(Timetableupload.this, "File Upload Complete.", 
                                             Toast.LENGTH_SHORT).show();
                            }
                        });                
                   }    
                    
                   //close the streams //
                   fileInputStream.close();
                   dos.flush();
                   dos.close();
                     
              } catch (MalformedURLException ex) {
                   
                  dialog.dismiss();  
                  ex.printStackTrace();
                   
                  runOnUiThread(new Runnable() {
                      public void run() {
                          file_location.setText("MalformedURLException Exception : check script url.");
                          Toast.makeText(Timetableupload.this, "MalformedURLException", 
                                                              Toast.LENGTH_SHORT).show();
                      }
                  });
                   
                  Log.e("Upload file to server", "error: " + ex.getMessage(), ex);  
              } catch (Exception e) {
                   
                  dialog.dismiss();  
                  e.printStackTrace();
                   
                  runOnUiThread(new Runnable() {
                      public void run() {
                          file_location.setText("Got Exception : see logcat ");
                          Toast.makeText(Timetableupload.this, "Got Exception : see logcat ", 
                                  Toast.LENGTH_SHORT).show();
                      }
                  });
                  Log.e("Upload file to server Exception", "Exception : "
                                                   + e.getMessage(), e);  
              }
              dialog.dismiss();       
              return serverResponseCode; 
               
           } // End else block 
		
			
	}}
	    


