package com.primol.m_status;

/*full ad
App ID: ca-app-pub-3629419195739803~4843984776
 Ad unit ID: ca-app-pub-3629419195739803/

banner ad
App ID: ca-app-pub-3629419195739803~4843984776
        Ad unit ID: ca-app-pub-3629419195739803/7797451172

         SHA1: "56a35703cb7242fd80b4eb453477453f2a12ee4f"

        */


import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import angtrim.com.fivestarslibrary.FiveStarsDialog;

// import static com.primol.m_status.MainActivity.md5;

public class Home_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private FirebaseAnalytics mFirebaseAnalytics;
    static View.OnClickListener myOnClickListener;
    public static ArrayList<id_name_model> ar = new ArrayList<id_name_model>();
    SqlHandler sql_handler_obj;
    private AdView mAdhomebtm;
    InterstitialAd mInterstitialAd;

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3629419195739803~4843984776");


       // String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
      //  String deviceId = md5(android_id).toUpperCase();

        mAdhomebtm = (AdView) findViewById(R.id.adhomebtm);
      //  AdRequest adRequest = new AdRequest.Builder().addTestDevice(deviceId).build();
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdhomebtm.loadAd(adRequest);


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3629419195739803/6320717978");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mInterstitialAd.isLoaded()) {
                   // mInterstitialAd.show();
                }
                super.onAdLoaded();
            }

            @Override
            public void onAdClosed() {
               // requestNewInterstitial();
                finish();
            }
        });

        requestNewInterstitial();



/*        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        */
        sql_handler_obj = new SqlHandler(getApplicationContext());
        addListenerOnButton();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_home);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new RV_Adapter(ar);
        recyclerView.setAdapter(adapter);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

       /* // rate us
        FiveStarsDialog fiveStarsDialog = new FiveStarsDialog(this,"angelo.gallarello@gmail.com");
        fiveStarsDialog.setRateText("Your custom text")
                .setTitle("Your custom title")
                .setForceMode(false)
                .setUpperBound(2) // Market opened if a rating >= 2 is selected
                .setNegativeReviewListener(Home_Activity.this) // OVERRIDE mail intent for negative review
                .setReviewListener(this) // Used to listen for reviews (if you want to track them )
                .showAfter(0);
        // rate us finish*/
    }

    private void requestNewInterstitial() {
     //   String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
      //  String deviceId = md5(android_id).toUpperCase();

      /*  AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(deviceId)
                .build();*/

        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);
    }
  /*  public static final String md5(final String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++) {
                String h = Integer.toHexString(0xFF & messageDigest[i]);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            Log.i("Log",e.toString());
        }
        return "";
    }*/

    public void addListenerOnButton() {
        try {
            String Query_select = "select * from Marathi_Status";
            c = sql_handler_obj.selectQuery(Query_select);
            c.moveToFirst();
            if (c.moveToFirst()) {
                do {
                    int id = c.getInt(0);
                    String status = c.getString(1);

                    id_name_model in = new id_name_model(id,status);
                    ar.add(in);

                    Log.i("Log", "Show Data status" + status);
                } while (c.moveToNext());
            }
            c.close();

        } catch (Exception e) {
            Log.i("Exception", e.toString());
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            new AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Exit App")
                    .setMessage("Are you sure you want to exit from this app?")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Log.i("TestAd",mInterstitialAd.isLoaded()+"");
                            if (mInterstitialAd.isLoaded()) {
                                mInterstitialAd.show();
                            } else {
                                finish();
                            }
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_aboutus) {
            Intent aboutus_activity = new Intent(Home_Activity.this,AboutUs_Activity.class);
            startActivity(aboutus_activity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
           finish();
            Intent home_activity = new Intent(Home_Activity.this,Home_Activity.class);
            startActivity(home_activity);
        } else if (id == R.id.nav_reportbug) {

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","primolapps@gmail.com", null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Bug in Marathi Status App");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Report Bug...");
            startActivity(Intent.createChooser(emailIntent, "Email Bug..."));

        } else if (id == R.id.nav_share) {

            String message = "Primol - Marathi Status App offer – Get a surprise on download" +
                    "Download Primol - Marathi Status App from Google Play Via :  ";
            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(Intent.createChooser(share, "Share With..."));

        } else if (id == R.id.nav_aboutus) {
            Intent aboutus_activity = new Intent(Home_Activity.this,AboutUs_Activity.class);
            startActivity(aboutus_activity);
        } else if (id == R.id.nav_moreapps) {

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://search?q=pub:<primol>"));
          //  intent.setData(Uri.parse("market://details?id=com.example.android"));
            // http://play.google.com/store/search?q=pub:<publisher_name>
            startActivity(intent);
// https://developer.android.com/distribute/tools/promote/linking.html#UriSummary
            // https://developer.android.com/distribute/tools/promote/linking.html#OpeningPublisher
        } else if (id == R.id.nav_rateus) {
            startActivity(new Intent(Intent.ACTION_VIEW,  Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
