package com.zulfa.androiddasar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashActivity extends Activity {

    private TextView textView, tvBio;
    Animation atgsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        atgsc = AnimationUtils.loadAnimation(this, R.anim.atgsc);
        tvBio = findViewById(R.id.tvBiodata);
        tvBio.startAnimation(atgsc);

        Thread thread = new Thread(){
            public void run(){
                try {
                    sleep(5000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
