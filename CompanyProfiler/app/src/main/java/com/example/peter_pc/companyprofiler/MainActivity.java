package com.example.peter_pc.companyprofiler;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView mainlist;
    ArrayList<Item> data;
    CustomAdapter adapter;
     EditText search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainlist=(ListView)findViewById(R.id.mainlist);
        search=(EditText) findViewById(R.id.searchfinder);

        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                fetch_data();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                fetch_data();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                fetch_data();
            }
        });


        data=new ArrayList<>();
        fetch_data();
        adapter=new CustomAdapter(this,data);

        adapter.notifyDataSetChanged();


        mainlist.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();




        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            fetch_data();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();




        if (id == R.id.nav_camera) {
           if(!data.isEmpty())

            adapter.notifyDataSetChanged();


        } else if (id == R.id.nav_gallery) {


            if(!data.isEmpty())
            {
                data.clear();
            }
            data.add(new Item("Fargo Courier Hub","Central Business Park","Road C,Off Enterprice Road, behind Sameer Business Park Nairobi","0703077000/0728606461",R.drawable.fargo1));
            data.add(new Item("Easy coach","Corner Lusaka Road and Witu Road","Nairobi","0703078965/0708965345",R.drawable.easy1));
            data.add(new Item("DHL Worldwide","Corner Lusaka Road and Witu Road","Nairobi","0703078965/0708965345",R.drawable.dhl1));
            data.add(new Item("G4S","Opposite Eldoret Total","Main Office Nairobi","0703456672/0734567891",R.drawable.g4));
            adapter.notifyDataSetChanged();

        } else if (id == R.id.nav_slideshow) {


            if(!data.isEmpty())
            {
                data.clear();
            }
            data.add(new Item("KFC Hotel","Lyric House, Kimathi Street, CBD, Nairobi","info@kfc.co.ke","0713077020/0718676461",R.drawable.kfc));
            data.add(new Item("Boma In","Red Cross Road off Popo Rd, off Mombasa Rd  nfo@theboma.co.ke","Nairobi","+254 719 050000",R.drawable.boma));
            data.add(new Item("Jacaranda Hotel","Woodvale Close, Westlands P.O Box 14287, ","City: Nairobi, Kenya"," cro@jacarandahotels.com",R.drawable.jaca));
            adapter.notifyDataSetChanged();

        } else if (id == R.id.nav_manage) {


            if(!data.isEmpty())
            {
                data.clear();
            }
            data.add(new Item("Customer Profiler Support","support@profiler.co.ke","24/7 Service Center Call Us On:","0703314737",R.drawable.support));
            adapter.notifyDataSetChanged();

        } else if (id == R.id.nav_edu) {


            if(!data.isEmpty())
            {
                data.clear();
            }
            data.add(new Item("United States International University","Nairobi Kenya East Africa","info@usiu.ac.ke","07301166000/+254203606100",R.drawable.usiu));
            data.add(new Item("St Paul's University","Limuru Kenya","admissions@spu.ke/info@spu.ac.ke","+2542020205505/2546673033",R.drawable.pauli));
            data.add(new Item("Strathmore University","Madaraka Estate Ole Sangale Road","Nairobi","(+254) (0)703-034000\n" +
                    "(+254) (0)703-034200\n" +
                    "(+254) (0)703-034300",R.drawable.strathmore));
            adapter.notifyDataSetChanged();

        }
        else if (id == R.id.nav_collectors) {


            if(!data.isEmpty())
            {
                data.clear();
            }
            data.add(new Item("Kamongo Waste Paper Ltd","Off Enterprise Road, Industrial Area, Kampala Rd, Nairobi, Kenya","Nairobi","+254 20 8155294",R.drawable.kolnet));
            data.add(new Item("Colnet Collectors","1st Floor, Enterprise Centre, Addis Ababa Road, Enterprise Rd,","Nairobi","+254 20 555107",R.drawable.colnet));
            adapter.notifyDataSetChanged();

        }else if (id == R.id.nav_services) {


            if(!data.isEmpty())
            {
                data.clear();
            }
            data.add(new Item("St. Luke's Hospital","info@stlukes.co.ke","Eldoret","(314) 205-6060 or (888) 205-6556",R.drawable.lukes));
            data.add(new Item("Parklands Mediplaza,","3rd Parklands Avenue, Opp Aga-Khan Hospital,","Nairobi","+254 (0) 736638073\n" +
                    "+254 (0) 722218416",R.drawable.mediheal));
            data.add(new Item("Aga Khan University Hospital, "," 3rd Parklands Avenue, Limuru Road","Nairobi","+254 (0) 20 366 2000",R.drawable.agakhan));
            data.add(new Item("Eldoret Hospital ","P.O Box 2234, Eldoret 30100","info@eldorethospital.com/www.eldorethospital.com","0733-618833, 0722-231438",R.drawable.eldorethospital));
            adapter.notifyDataSetChanged();

        }
        else if (id == R.id.nav_insurance) {


            if(!data.isEmpty())
            {
                data.clear();
            }
            data.add(new Item("Co-operative Insurance  Company","CIC PLAZA, Mara Road, Upper Hill"," Nairobi","0721632713/0735750885",R.drawable.cooperative));
            data.add(new Item("Jubilee Insurance Company Ltd","Jubilee Insurance House Wabera Street","Nairobi","0709901000/0719222111",R.drawable.jubilee));
            data.add(new Item("Britam Insurance Company","Mara/Ragati Road Junction, Upperhill","Nairobi","0703078965/0708965345",R.drawable.britam));
            adapter.notifyDataSetChanged();

        }

        else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        } else if (id == R.id.nav_send) {

            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Here is the share content body";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public  void fetch_data()
    {

        String a=search.getText().toString();

        RequestParams p=new RequestParams();
        p.add("searchvalue",a);


        String url ="http://cypressoutlook.com/config/retrievedata.php";
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(url,p, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String json = new String(responseBody);
                Log.d("RESPONSe", json);
                Gson gson=new Gson();
                Item[] dataFromServer= gson.fromJson(json, Item[].class);
                if (!data.isEmpty())
                {
                  data.clear();
                }
                List<Item> data_list=new ArrayList<Item>(Arrays.asList(dataFromServer));
                data.addAll(data_list);
                adapter.notifyDataSetChanged();
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
        data=new ArrayList<>();

        adapter=new CustomAdapter(this,data);

        adapter.notifyDataSetChanged();


        mainlist.setAdapter(adapter);

    }


}
