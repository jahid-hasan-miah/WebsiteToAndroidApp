package com.example.websiteconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mywebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mywebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings=mywebView.getSettings();
        mywebView.setWebViewClient(new myWebClient());
        mywebView.loadUrl("https://brainstation-23.com/");
        webSettings.setJavaScriptEnabled(true);
    }
    public class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted (WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if(mywebView.canGoBack() ) {
            mywebView.goBack();
        } else{
            super.onBackPressed();
        }
    }

}
