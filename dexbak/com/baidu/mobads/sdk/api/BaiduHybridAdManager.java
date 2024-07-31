package com.baidu.mobads.sdk.api;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebView;
import com.baidu.mobads.sdk.internal.C2694dl;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BaiduHybridAdManager {
    private C2694dl mAdProd;
    private String mAppSid;
    private WebView mWebView;
    private BaiduHybridAdViewListener mBaiduHybridAdViewListener = new BaiduHybridAdViewListener() { // from class: com.baidu.mobads.sdk.api.BaiduHybridAdManager.1
        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdClick(int i, String str) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdFailed(int i, String str, String str2) {
        }

        @Override // com.baidu.mobads.sdk.api.BaiduHybridAdViewListener
        public void onAdShow(int i, String str) {
        }
    };
    private boolean mAppPageReceivedError = false;

    public void injectJavaScriptBridge(WebView webView) {
        if (this.mAppPageReceivedError) {
            return;
        }
        this.mWebView = webView;
        C2694dl c2694dl = new C2694dl(this.mWebView);
        this.mAdProd = c2694dl;
        c2694dl.m50809h(this.mAppSid);
        this.mAdProd.m50499a(this.mBaiduHybridAdViewListener);
        this.mAdProd.mo50356a();
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mAppPageReceivedError = false;
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.mAppPageReceivedError = true;
    }

    public void setAppSid(String str) {
        this.mAppSid = str;
    }

    public void setBaiduHybridAdViewListener(BaiduHybridAdViewListener baiduHybridAdViewListener) {
        this.mBaiduHybridAdViewListener = baiduHybridAdViewListener;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        C2694dl c2694dl;
        if (!this.mAppPageReceivedError && (c2694dl = this.mAdProd) != null) {
            c2694dl.m50498b(webView, str);
        }
        try {
            Uri parse = Uri.parse(str);
            if ("mobadssdk".equals(parse.getScheme())) {
                return true;
            }
            return "mobads".equals(parse.getScheme());
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
    }
}
