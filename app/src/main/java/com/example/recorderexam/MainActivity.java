package com.example.recorderexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.Window;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_main);

        WebView wv = (WebView)findViewById(R.id.wvlocal);
        wv.loadUrl("file:///android_asset/www/index.html");

        WebViewInterface mWebViewInterface = new WebViewInterface(MainActivity.this, wv);
        wv.addJavascriptInterface(mWebViewInterface, "Android");

        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);

    }
}
