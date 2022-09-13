package com.example.newsapp.views.webview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.newsapp.R;

public class webView extends AppCompatActivity {

    TextView tv;
    Toolbar toolbar;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        tv = findViewById(R.id.headingHaiJi);
        toolbar = findViewById(R.id.toolbar);
        webView = findViewById(R.id.webView);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String heading = intent.getStringExtra("title");
        tv.setText(heading);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(url);


    }
}