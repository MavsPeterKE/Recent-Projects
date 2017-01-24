package com.example.zindukamtaani;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Towns extends Activity{
	ListView townlist;
	public static final String towns[]={"Nairobi","Mombasa","Nakuru","Eldoret","Thika","Kitale","Garissa","Kiambu","Kisumu","Malindi","Kakamega","Machakos"};


    @SuppressWarnings("static-access")
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.towns);
        //Initializing Textviews
       townlist=(ListView)findViewById(R.id.townlist);
       townlist.setChoiceMode(townlist.CHOICE_MODE_SINGLE);
       ArrayAdapter<String>aa=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,towns);
       townlist.setAdapter(aa);

        
    }
        protected void onPause() {
        super.onPause();
        finish();
    }
    }

