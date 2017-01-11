package com.primol.m_status;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class AboutUs_Activity extends AppCompatActivity {

    TextView fbpage,twitterpage,linkedinpage,instagrampage;
    private AdView mAdViewtop,adviewbtm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us_);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3629419195739803~4843984776");

      //  String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
      //  String deviceId = md5(android_id).toUpperCase();

        mAdViewtop = (AdView) findViewById(R.id.ad_Top_au);
        //   AdRequest adRequest = new AdRequest.Builder().addTestDevice(deviceId).build();
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdViewtop.loadAd(adRequest);

        adviewbtm = (AdView) findViewById(R.id.ad_bottom_au);
        //  AdRequest adRequestbtm = new AdRequest.Builder().addTestDevice(deviceId).build();
        AdRequest adRequestbtm = new AdRequest.Builder().build();
        adviewbtm.loadAd(adRequestbtm);

        fbpage = (TextView)findViewById(R.id.link_fb_tv);

        Spanned Text = Html.fromHtml("<a href='http://www.google.com//'>आमचे Facebook पेज</a>");

        fbpage.setMovementMethod(LinkMovementMethod.getInstance());
        fbpage.setText(Text);

        twitterpage = (TextView)findViewById(R.id.link_twitter_tv);

        Spanned Text2 = Html.fromHtml("<a href='http://www.google.com//'>आमचे Twitter पेज</a>");

        twitterpage.setMovementMethod(LinkMovementMethod.getInstance());
        twitterpage.setText(Text2);

  /*      linkedinpage = (TextView)findViewById(R.id.link_linkedin_tv);

        Spanned Text3 = Html.fromHtml("<a href='http://www.google.com//'>आमचे LinkedIn पेज</a>");

        linkedinpage.setMovementMethod(LinkMovementMethod.getInstance());
        linkedinpage.setText(Text3);*/

        instagrampage = (TextView)findViewById(R.id.link_instagram_tv);

        Spanned Text4 = Html.fromHtml("<a href='http://www.google.com//'>आमचे Instagram पेज</a>");

        instagrampage.setMovementMethod(LinkMovementMethod.getInstance());
        instagrampage.setText(Text4);
    }
}/*

    INSERT INTO Marathi_Status(status) SELECT status FROM sms.marathi_status;
        DELETE FROM Marathi_Status WHERE id NOT IN(SELECT MIN(id) FROM Marathi_StatusGROUP BY status);*/