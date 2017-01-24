package com.example.peter_pc.companyprofiler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView mainlist;
    ArrayList<Item> data;
    //Object of Class CustomAdapter that adds data to the list
    CustomAdapter adapter;

    NavDrawerAdapter nav;

    EditText search;
    Context context;
    ProgressBar pro;
    boolean adaptercheck=true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mainlist = (ListView) findViewById(R.id.mainlist);
        pro = (ProgressBar) findViewById(R.id.progress);
        //pro.getIndeterminateDrawable().setColorFilter(000000,android.graphics.PorterDuff.Mode.MULTIPLY);
        search = (EditText) findViewById(R.id.searchfinder);
        data = new ArrayList<>();
        adapter = new CustomAdapter(this, data);
        mainlist.setAdapter(adapter);



       //Load Progress
       // pro.setVisibility(View.VISIBLE);

        fetch_data();


        //Live search functionality
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

        mainlist.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item x = data.get(i);
                String name= x.getName();
                String loc = x.getLocation();
                String email = x.getEmail();
                String phone = x.getPhone();
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                //String shareBody = name +"/n";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, name+"\n"+loc+"\n"
                        +email+"\n"+phone);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
                return true;
            }
        });
        //List Listener
        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Loading Location on Map",Toast.LENGTH_LONG).show();
                getLocation(i);
            }

            //Setlongpress Listener


            public void getLocation(int i) {
                Item x = data.get(i);
                String longi= x.getLongitude();
                String lati = x.getLatitude();
                String name = x.getName();
                Intent getmap=new Intent(MainActivity.this,MapsActivity.class);
                //Avails data across the whole package
                SharedPreferences pref = getSharedPreferences("db",MODE_PRIVATE);
                SharedPreferences.Editor sharedata=pref.edit();
                sharedata.putString("name",name);
                sharedata.putString("longi",longi);
                sharedata.putString("lati",lati);
                sharedata.commit();
                startActivity(getmap);

            }
        });

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

        if (id == R.id.addrecord) {

            Intent nextface = new Intent(MainActivity.this, Uploads.class);
            startActivity(nextface);
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
            if (!data.isEmpty())

                fetch_data();


        } else if (id == R.id.nav_gallery) {


            if (!data.isEmpty()) {
                data.clear();
            }
            data.add(new Item("Fargo Courier Hub", "Central Business Park", "Road C,Off Enterprice Road, behind Sameer Business Park Nairobi", "0703077000/0728606461"));
            data.add(new Item("Easy coach", "Corner Lusaka Road and Witu Road", "Nairobi", "0703078965/0708965345"));
            data.add(new Item("DHL Worldwide", "Corner Lusaka Road and Witu Road", "Nairobi", "0703078965/0708965345"));
            data.add(new Item("G4S", "Opposite Eldoret Total", "Main Office Nairobi", "0703456672/0734567891"));


            nav = new NavDrawerAdapter(this, data);
            mainlist.setAdapter(nav);
               adaptercheck=false;
            nav.notifyDataSetChanged();

        } else if (id == R.id.nav_slideshow) {


            if (!data.isEmpty()) {
                data.clear();
            }

            data.add(new Item("KFC Hotel", "Lyric House, Kimathi Street, CBD, Nairobi", "info@kfc.co.ke", "0713077020/0718676461"));
            data.add(new Item("Boma In", "Red Cross Road off Popo Rd, off Mombasa Rd  nfo@theboma.co.ke", "Nairobi", "+254 719 050000"));
            data.add(new Item("Jacaranda Hotel", "Woodvale Close, Westlands P.O Box 14287, ", "City: Nairobi, Kenya", " cro@jacarandahotels.com"));



            adapter.notifyDataSetChanged();


        } else if (id == R.id.nav_manage) {


            if (!data.isEmpty()) {
                data.clear();
            }
            data.add(new Item("Customer Profiler Support", "support@profiler.co.ke", "24/7 Service Center Call Us On:", "0703314737"));
            adapter.notifyDataSetChanged();

        } else if (id == R.id.nav_edu) {


            if (!data.isEmpty()) {
                data.clear();
            }
            data.add(new Item("United States International University", "Nairobi Kenya East Africa", "info@usiu.ac.ke", "07301166000/+254203606100"));
            data.add(new Item("St Paul's University", "Limuru Kenya", "admissions@spu.ke/info@spu.ac.ke", "+2542020205505/2546673033"));
            data.add(new Item("Strathmore University", "Madaraka Estate Ole Sangale Road", "Nairobi", "(+254) (0)703-034000\n" +
                    "(+254) (0)703-034200\n" +
                    "(+254) (0)703-034300"));
            adapter.notifyDataSetChanged();

        } else if (id == R.id.nav_collectors) {


            if (!data.isEmpty()) {
                data.clear();
            }
            data.add(new Item("Kamongo Waste Paper Ltd", "Off Enterprise Road, Industrial Area, Kampala Rd, Nairobi, Kenya", "Nairobi", "+254 20 8155294"));
            data.add(new Item("Colnet Collectors", "1st Floor, Enterprise Centre, Addis Ababa Road, Enterprise Rd,", "Nairobi", "+254 20 555107"));
            adapter.notifyDataSetChanged();

        } else if (id == R.id.nav_services) {


            if (!data.isEmpty()) {
                data.clear();
            }
            data.add(new Item("St. Luke's Hospital", "info@stlukes.co.ke", "Eldoret", "(314) 205-6060 or (888) 205-6556"));
            data.add(new Item("Parklands Mediplaza,", "3rd Parklands Avenue, Opp Aga-Khan Hospital,", "Nairobi", "+254 (0) 736638073\n" +
                    "+254 (0) 722218416"));
            data.add(new Item("Aga Khan University Hospital, ", " 3rd Parklands Avenue, Limuru Road", "Nairobi", "+254 (0) 20 366 2000"));
            data.add(new Item("Eldoret Hospital ", "P.O Box 2234, Eldoret 30100", "info@eldorethospital.com/www.eldorethospital.com", "0733-618833, 0722-231438"));
            adapter.notifyDataSetChanged();

        } else if (id == R.id.nav_insurance) {


            if (!data.isEmpty()) {
                data.clear();
            }
            data.add(new Item("Co-operative Insurance  Company", "CIC PLAZA, Mara Road, Upper Hill", " Nairobi", "0721632713/0735750885"));
            data.add(new Item("Jubilee Insurance Company Ltd", "Jubilee Insurance House Wabera Street", "Nairobi", "0709901000/0719222111"));
            data.add(new Item("Britam Insurance Company", "Mara/Ragati Road Junction, Upperhill", "Nairobi", "0703078965/0708965345"));
            adapter.notifyDataSetChanged();

        } else if (id == R.id.nav_share) {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "Download Company Profiler/googleplayStore";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Companies Location");
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

    public void fetch_data() {
        if (!isConnected()) {
            showDialog();
            pro.setVisibility(View.INVISIBLE);

        } else {
            pro.setVisibility(View.VISIBLE);
            String a = search.getText().toString();
            RequestParams p = new RequestParams();
            p.add("searchvalue", a);
            String url = "http://cypressoutlook.com/config/retrievedata.php";
            AsyncHttpClient client = new AsyncHttpClient();
            client.get(url, p, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                    process(responseBody);
                    pro.setVisibility(View.INVISIBLE);
                }
                @Override
                public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                    pro.setVisibility(View.VISIBLE);
                }
            });
        }

    }

    private void process(byte[] responseBody) {
        String json = new String(responseBody);

        //JsonArray array=new JsonArray(json);
         if (adaptercheck==false)
         {
             mainlist.setAdapter(adapter);
             adaptercheck=true;
             Log.d("RESPONSE","Changed Adapter");
         }



        Log.d("RESPONSE", json);
        Gson gson = new Gson();
        Item[] dataFromServer = gson.fromJson(json, Item[].class);
        if (!data.isEmpty()) {
            data.clear();
        }
        List<Item> data_list = new ArrayList<Item>(Arrays.asList(dataFromServer));
        data.addAll(data_list);
        adapter.notifyDataSetChanged();
    }

    private void showDialog() {
        AlertDialog.Builder con = new AlertDialog.Builder(this)
                .setTitle("Network Error")
                .setMessage("No internet Connection")
                .setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        fetch_data();
                    }
                });
        AlertDialog dialog = con.create();
        dialog.show();
    }


    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }








}
