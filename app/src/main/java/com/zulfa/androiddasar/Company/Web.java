package com.zulfa.androiddasar.Company;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zulfa.androiddasar.R;

public class Web extends AppCompatActivity {

    WebView web;
    ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progress = new ProgressDialog(Web.this);
        progress.setMessage("Menunggu....");
        progress.show();

        web = findViewById(R.id.webView);

        web.loadUrl("http://ads.id");

        web.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished (WebView view, String url){
                super.onPageFinished(view, url);
                progress.dismiss();
                getSupportActionBar().setTitle(web.getTitle());
            }


        });
    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();

        } else {
            super.onBackPressed();

        }

    }

}
