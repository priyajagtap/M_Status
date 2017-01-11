package com.primol.m_status;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class Splash_Screen_Activity extends Activity {

    ImageView blue,yellow,green,purple,orange;
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onStart() {
        BallAnimation();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen_);

        blue = (ImageView)findViewById(R.id.iv_blue);
        yellow = (ImageView)findViewById(R.id.iv_yellow);
        green = (ImageView)findViewById(R.id.iv_green);
        purple = (ImageView)findViewById(R.id.iv_purple);
        orange = (ImageView)findViewById(R.id.iv_orange) ;

        // to check db is present or not, if not this will create a new db with given name
        OpenDbHelperClass odbhc_obj = new OpenDbHelperClass(getApplicationContext());
        if (odbhc_obj.checkDB()) {
            //presnet
        } else {
            try {
                odbhc_obj.createDB();
                //absent
            } catch (Exception e) {

            }
        }

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash_Screen_Activity.this, Home_Activity.class);
                startActivity(i);
                overridePendingTransition( R.anim.slide_in_up, R.anim.slide_out_up );

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);


    }

    public void BallAnimation()
    {
        final TranslateAnimation animation_p = new TranslateAnimation(Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -200.0f);
        animation_p.setDuration(10);
        yellow.startAnimation(animation_p);

        final TranslateAnimation animation1 = new TranslateAnimation(Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -200.0f);
        animation1.setDuration(600);
        animation1.setStartOffset(-300);

        final TranslateAnimation animation2 = new TranslateAnimation(Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -200.0f);
        animation2.setDuration(600);
        animation2.setStartOffset(-300);

        final TranslateAnimation animation3 = new TranslateAnimation(Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -200.0f);
        animation3.setDuration(600);
        animation3.setStartOffset(-300);

        final TranslateAnimation animation4 = new TranslateAnimation(Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, 0.0f,
                Animation.ABSOLUTE, 0.0f, Animation.ABSOLUTE, -200.0f);
        animation4.setDuration(600);
        animation4.setStartOffset(-300);

        animation_p.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                green.startAnimation(animation1);
            }
        });

        animation1.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                blue.startAnimation(animation2);
            }
        });

        animation2.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                orange.startAnimation(animation3);
            }
        });

        animation3.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation) {}
            @Override
            public void onAnimationRepeat(Animation animation) {}
            @Override
            public void onAnimationEnd(Animation animation) {
                purple.startAnimation(animation4);
            }
        });
    }
}
