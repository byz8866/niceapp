package com.niceapp.view.webview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebSettings;

import com.cheddd.nqd.base.actionbar.ActionBarStyle;
import com.niceapp.R;
import com.niceapp.base.BaseActivity;
import com.niceapp.base.actionbar.ActionBar;

import org.jetbrains.annotations.NotNull;

public class BannerWebActivity extends BaseActivity {
    com.tencent.smtt.sdk.WebView webView;
    String url = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_web);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        webView = findViewById(R.id.webView_banner);
        webView.setWebViewClient(new com.tencent.smtt.sdk.WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(com.tencent.smtt.sdk.WebView webView, String s) {
                return super.shouldOverrideUrlLoading(webView, s);
            }


            @Override
            public void onReceivedError(com.tencent.smtt.sdk.WebView webView, int i, String s, String s1) {
                super.onReceivedError(webView, i, s, s1);
                hideProgress();
            }

            @Override
            public void onPageStarted(com.tencent.smtt.sdk.WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
                showProgress();
            }

            @Override
            public void onPageFinished(com.tencent.smtt.sdk.WebView webView, String s) {
                super.onPageFinished(webView, s);
                hideProgress();
            }
        });

        com.tencent.smtt.sdk.WebSettings webSettings = webView.getSettings();
        webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); //支持js
        webSettings.setUseWideViewPort(true); //自适应屏幕 可以任意比例缩放
        webSettings.setLoadWithOverviewMode(true);//设置网页是否支持概览模式
//        webSettings.setBuiltInZoomControls(true); //设置缩放按钮
        webSettings.setSupportZoom(true); //使页面支持缩放
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE); //不支持缓存

        //访问Android assets文件夹内的
//        String url="file:///android_asset/gonggao.webp";

        if (!TextUtils.isEmpty(url)) {
            webView.loadUrl(url);
        }
    }

    @NotNull
    @Override
    public ActionBarStyle setActionBarStyle() {
        return ActionBarStyle.GENERIC_BACK_BAR_NOT_DIVIDING;
    }

    @NotNull
    @Override
    public ActionBar setActionBar(@NotNull ActionBarStyle style) {
        ActionBar actionBar = super.setActionBar(style);
        actionBar.setLeftIv(R.mipmap.nav_back);
        actionBar.setTitle("");
        return actionBar;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.stopLoading();
            webView.destroy();
            webView = null;
        }
    }

    @Override
    public void finish() {
        //ZoomButtonsController 退出报错
        ViewGroup view = (ViewGroup) getWindow().getDecorView();
        view.removeAllViews();
        super.finish();
    }
}
