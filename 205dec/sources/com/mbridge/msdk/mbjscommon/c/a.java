package com.mbridge.msdk.mbjscommon.c;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.c;

/* compiled from: DefaultRVWebViewListener.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a implements c {
    public void a(Object obj) {
        x.a("RVWindVaneWebView", "getEndScreenInfo");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public final boolean b(WebView webView, String str) {
        x.a("RVWindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public final void c(WebView webView, int i4) {
        x.a("RVWindVaneWebView", "loadingResourceStatus");
    }

    public void a(WebView webView, String str, String str2, int i4, int i5) {
        x.a("RVWindVaneWebView", "loadAds");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public final void b(WebView webView, int i4) {
        x.a("RVWindVaneWebView", "onProgressChanged");
    }

    public void a(Object obj, String str) {
        x.a("RVWindVaneWebView", "operateComponent");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public final void a(WebView webView, String str, Bitmap bitmap) {
        x.a("RVWindVaneWebView", "onPageStarted");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public void a(WebView webView, int i4, String str, String str2) {
        x.a("RVWindVaneWebView", "onReceivedError");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        x.a("RVWindVaneWebView", "onReceivedSslError");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public void a(WebView webView, String str) {
        x.a("RVWindVaneWebView", "onPageFinished");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public void a(WebView webView, int i4) {
        x.a("RVWindVaneWebView", "readyState");
    }
}
