package com.gyk.webserviceapp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewAcitivity extends AppCompatActivity {
    WebView webView;
    News news;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_acitivity);
        webView = (WebView) findViewById(R.id.webView);
        news = new News();
        news.setUrl(getIntent().getStringExtra("url"));
        news.setTitle(getIntent().getStringExtra("title"));
        try{
            if(!news.getPhotoUrl().isEmpty())
                openWebPage();

        }catch (Exception e){

        }
        }
    private void openWebPage() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(news.getUrl());
        final ProgressDialog progressDialog =
                ProgressDialog.show(WebViewAcitivity.this, news.getTitle(),
                        "Yükleniyor...", true);
        progressDialog.show();
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Toast.makeText(WebViewAcitivity.this, "Sayfa yüklendi!",
                        Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

            @Override
            public void onReceivedError(WebView view,
                                        int errorCode, String description, String failingUrl) {
                Toast.makeText(WebViewAcitivity.this, "Bir hata oluştu",
                        Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }
}
