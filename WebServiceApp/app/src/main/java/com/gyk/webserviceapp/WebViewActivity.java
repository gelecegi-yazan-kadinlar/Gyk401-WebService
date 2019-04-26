package com.gyk.webserviceapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {
    String TAG = "WebViewAcitivity";
    WebView webView;
    News news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_web_view);
        webView = (WebView) findViewById(R.id.webView);
        news = new News();
        news.setUrl(getIntent().getStringExtra("url"));
        news.setTitle(getIntent().getStringExtra("title"));
        try{
            if(!news.getUrl().isEmpty())
                openWebPage();

        }catch (Exception e){

        }
    }
    private void openWebPage() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(news.getUrl());
        final ProgressDialog progressDialog =
                ProgressDialog.show(WebViewActivity.this, news.getTitle(),
                        "Yükleniyor...", true);
        progressDialog.show();
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(WebViewActivity.this, "Sayfa yüklendi!",
                        Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view,
                                        int errorCode, String description, String failingUrl) {
                Toast.makeText(WebViewActivity.this, "Bir hata oluştu",
                        Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
