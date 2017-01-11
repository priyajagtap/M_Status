package com.primol.m_status;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.text.ClipboardManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;


public class MainActivity extends AppCompatActivity {

    ImageView iv_previous, iv_next, iv_share, iv_copy,iv_left,iv_right,iv_up,iv_down;
    TextView tv_status;
    String status;
    int id;
    static int index = 0;
    Animation myAnimation;
    private AdView mAdViewtop,adviewbtm;
    static int status1=0,status2=0,status3=0,status4=0,status5=0,status6=0,status7=0;
    /*@Override
    protected void onStart() {
        super.onStart();


        // sequence example
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500);
        config.setContentTextColor(Color.YELLOW);
        config.setDismissTextColor(Color.YELLOW);
        // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this,"showcaseid");

        sequence.setConfig(config);

        sequence.addSequenceItem(iv_left,
                "Swipe Left To View Next Status...", "GOT IT");

        sequence.addSequenceItem(iv_right,
                "Swipe Right To View Previous Status...", "GOT IT");

        sequence.addSequenceItem(iv_up,
                "Swipe Up To View Next Status...", "GOT IT");

        sequence.addSequenceItem(iv_down,
                "Swipe Down To View Previous Status...", "GOT IT");

        sequence.addSequenceItem(iv_previous,
                "Click Here To View Previous Status...", "GOT IT");

        sequence.addSequenceItem(iv_share,
                "Click Here To Share Status...", "GOT IT");

        sequence.addSequenceItem(iv_copy,
                "Click Here To Copy Status...", "GOT IT");

        sequence.addSequenceItem(iv_next,
                "Click Here To View Next Status...", "GOT IT");


        sequence.start();


       *//* if(status1 == 0) {
            Target listObjetivo = new ViewTarget(R.id.left, this);

            new ShowcaseView.Builder(this, false)
                    .setTarget(listObjetivo)
                    .setContentTitle("Swipe Left")
                    .setContentText("To View Previous Status...")
                    .setStyle(2)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            status1 = 1;
                        }
                    })
                    .build();
        }

        if(status1 == 1){

            Target listObjetivo = new ViewTarget(R.id.right, this);

            new ShowcaseView.Builder(this, false)
                    .setTarget(listObjetivo)
                    .setContentTitle("Swipe Right")
                    .setContentText("To View Next Status...")
                    .setStyle(2)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            status2 = 1;
                        }
                    })
                    .build();
        }
        if(status2 == 1){
            Target listObjetivo = new ViewTarget(R.id.up, this);

            new ShowcaseView.Builder(this, false)
                    .setTarget(listObjetivo)
                    .setContentTitle("Swipe Up")
                    .setContentText("To View Next Status...")
                    .setStyle(2)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            status3 = 1;
                        }
                    })
                    .build();

        }
        if(status3 == 1){

            Target listObjetivo = new ViewTarget(R.id.down, this);

            new ShowcaseView.Builder(this, false)
                    .setTarget(listObjetivo)
                    .setContentTitle("Swipe Down")
                    .setContentText("To View Previous Status...")
                    .setStyle(2)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            status4 = 1;
                        }
                    })
                    .build();
        }
        if(status4 == 1){
            Target listObjetivo = new ViewTarget(R.id.iv_previous, this);

            new ShowcaseView.Builder(this, false)
                    .setTarget(listObjetivo)
                    .setContentTitle("Click Here")
                    .setContentText("To View Previous Status...")
                    .setStyle(2)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            status5 = 1;
                        }
                    })
                    .build();
        }
        if(status5 == 1){

            Target listObjetivo = new ViewTarget(R.id.iv_share, this);

            new ShowcaseView.Builder(this, false)
                    .setTarget(listObjetivo)
                    .setContentTitle("Click Here")
                    .setContentText("To Share Status...")
                    .setStyle(2)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            status6 = 1;
                        }
                    })
                    .build();
        }
        if(status6 == 1){
            status7 = 1;
            Target listObjetivo = new ViewTarget(R.id.iv_copy, this);

            new ShowcaseView.Builder(this, false)
                    .setTarget(listObjetivo)
                    .setContentTitle("Click Here")
                    .setContentText("To Copy Status...")
                    .setStyle(2)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            status7 = 1;
                        }
                    })
                    .build();
        }
        if(status7 == 1){
            Target listObjetivo = new ViewTarget(R.id.iv_next, this);

            new ShowcaseView.Builder(this, false)
                    .setTarget(listObjetivo)
                    .setContentTitle("Click Here")
                    .setContentText("To View Next Status...")
                    .setStyle(2)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, "Finished..", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .build();
        }*//*
    }

    public void test(){
        Target listObjetivo = new ViewTarget(R.id.up, this);

        new ShowcaseView.Builder(this, false)
                .setTarget(listObjetivo)
                .setContentTitle("Swipe Up")
                .setContentText("To View Next Status...")
                .setStyle(2)
                .build();
    }
*/
    // http://evgenii.com/blog/spring-button-animation-on-android/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3629419195739803~4843984776");

        iv_previous = (ImageView) findViewById(R.id.iv_previous);
        iv_next = (ImageView) findViewById(R.id.iv_next);
        iv_copy = (ImageView) findViewById(R.id.iv_copy);
        iv_share = (ImageView) findViewById(R.id.iv_share);
        tv_status = (TextView) findViewById(R.id.tv_status);
        iv_left = (ImageView)findViewById(R.id.left);
        iv_right = (ImageView)findViewById(R.id.right);
        iv_up = (ImageView)findViewById(R.id.up);
        iv_down = (ImageView)findViewById(R.id.down);

      //  String android_id = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
     //   String deviceId = md5(android_id).toUpperCase();

        mAdViewtop = (AdView) findViewById(R.id.ad_Top);
     //   AdRequest adRequest = new AdRequest.Builder().addTestDevice(deviceId).build();
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdViewtop.loadAd(adRequest);

        adviewbtm = (AdView) findViewById(R.id.ad);
      //  AdRequest adRequestbtm = new AdRequest.Builder().addTestDevice(deviceId).build();
        AdRequest adRequestbtm = new AdRequest.Builder().build();
        adviewbtm.loadAd(adRequestbtm);


        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);

        // Use bounce interpolator with amplitude 0.2 and frequency 20
        MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
        myAnim.setInterpolator(interpolator);

        myAnimation = AnimationUtils.loadAnimation(this, R.anim.myanimation);


// http://android-er.blogspot.in/2013/07/apply-animation-on-textview.html
//        iv_previous.startAnimation(myAnim);

        tv_status.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv_status.startAnimation(myAnimation);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Intent intent = getIntent();
        id = intent.getIntExtra("id",1);
        status = intent.getStringExtra("status");

        Log.i("data_r",id+" "+status);

        boolean st = savedInstanceState == null;
        Log.i("bundle",st+"");
        if(savedInstanceState != null){
            /*Intent intent = getIntent();
            id = intent.getIntExtra("id",1);
            status = intent.getStringExtra("status");

            Log.i("data_r",id+" "+status);*/
        }
        tv_status.setText(status);

//        id_name_model im = new id_name_model(id,status);
       // index = Home_Activity.ar.indexOf(new id_name_model(id,status));
        index = id-1;
        Log.i("data_r","index"+index);

        //tv_status.setText(names[i]);

        iv_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_share.startAnimation(myAnim);
                String message = tv_status.getText().toString().trim();
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("text/plain");
                share.putExtra(Intent.EXTRA_TEXT, message);

                startActivity(Intent.createChooser(share, "Share With..."));
            }
        });
        iv_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_copy.startAnimation(myAnim);
                ClipboardManager cm = (ClipboardManager)getApplicationContext().getSystemService(Context.CLIPBOARD_SERVICE);
                cm.setText(tv_status.getText());
                Toast.makeText(getApplicationContext(), "Copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        });

        iv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_next.startAnimation(myAnim);
                Log.i("data_r","index"+index);

                index++;
                if(index < Home_Activity.ar.size()){
                    id_name_model it =Home_Activity.ar.get(index);
                    tv_status.setText(it.getStatus());
                }

            }
        });

        iv_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_previous.startAnimation(myAnim);
                Log.i("data_r","index"+index);
                index--;
                if(index >= 0){
                    id_name_model it =Home_Activity.ar.get(index);
                    tv_status.setText(it.getStatus());
                }


            }
        });





        /*iv_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.image_click));
                index++;
                id_name_model it =Home_Activity.ar.get(index);
                tv_status.setText(it.getStatus());
            }
        });
        iv_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.image_click));
                index--;
                id_name_model it =Home_Activity.ar.get(index);
                tv_status.setText(it.getStatus());
            }
        });
        iv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.image_click));
                index++;
                id_name_model it =Home_Activity.ar.get(index);
                tv_status.setText(it.getStatus());
            }
        });
        iv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.image_click));
                index--;
                id_name_model it =Home_Activity.ar.get(index);
                tv_status.setText(it.getStatus());
            }
        });*/
        View v = getWindow().getDecorView().getRootView();

        v.setOnTouchListener(new OnSwipeTouchListener() {
            public boolean onSwipeTop() {
                iv_down.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.image_click));
                index++;
                if(index < Home_Activity.ar.size()){
                    id_name_model it =Home_Activity.ar.get(index);
                    tv_status.setText(it.getStatus());
                }
                return true;
            }

            public boolean onSwipeRight() {
                iv_left.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.image_click));
                index--;
                if(index >= 0){
                    id_name_model it =Home_Activity.ar.get(index);
                    tv_status.setText(it.getStatus());
                }
                return true;
            }

            public boolean onSwipeLeft() {
                iv_right.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.image_click));
                index++;
                if(index < Home_Activity.ar.size()){
                    id_name_model it =Home_Activity.ar.get(index);
                    tv_status.setText(it.getStatus());
                }
                return true;
            }

            public boolean onSwipeBottom() {
                iv_up.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.image_click));
                index--;
                if(index >= 0){
                    id_name_model it =Home_Activity.ar.get(index);
                    tv_status.setText(it.getStatus());
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {

        super.onBackPressed();
    }

   /* public static final String md5(final String s) {
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
}
   /* public void addListenerOnButton() {
        try {
           *//* // to insert into table
            String Query = "insert into Sheet1" +
                    "(ID,NAME,roll_no)"
                    + " values('" + e_id.getText().toString().trim() + "','"
                    + e_name.getText().toString().trim()
                    + "')";

            Log.i("Log", Query);
            sql_handler_obj.executeQuery(Query);
            Log.i("Log", "Insert Successful");
*//*

            // to select from table

            String Query_select = "select status from Marathi_Status";
            c = sql_handler_obj.selectQuery(Query_select);
            c.moveToFirst();
            if (c.moveToFirst()) {
                do {
                    String status = c.getString(0);
                    ar.add(status);
                    status_ar_list.add(new id_name_model(status));
                    Log.i("Log", "Show Data status" + status);
                } while (c.moveToNext());
            }
            c.close();

        } catch (Exception e) {
            Log.i("Exception", e.toString());
        }

    }
}

// to read date from table
*//*    protected void showRecords() {

        if (c.moveToFirst()) {
            do {
                String id = c.getString(0);
                String name = c.getString(1);
                stud_ar_list.add(new id_name_model(id,name));
                Log.i("Log","Show Data"+id+"\n"+name);
            } while (c.moveToNext());
        }
        c.close();
    }*//*

*/