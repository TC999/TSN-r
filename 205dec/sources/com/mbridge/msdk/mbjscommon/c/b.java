package com.mbridge.msdk.mbjscommon.c;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.d;

/* compiled from: DefaultWebViewListener.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b implements d {
    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public final void a(WebView webView, String str, Bitmap bitmap) {
        x.a("WindVaneWebView", "onPageStarted");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public final boolean b(WebView webView, String str) {
        x.a("WindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public void c(WebView webView, int i4) {
        x.a("WindVaneWebView", "loadingResourceStatus");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public void a(WebView webView, int i4, String str, String str2) {
        x.a("WindVaneWebView", "onReceivedError");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public final void b(WebView webView, int i4) {
        x.a("WindVaneWebView", "onProgressChanged");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        x.a("WindVaneWebView", "onReceivedSslError");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public void a(WebView webView, String str) {
        x.a("WindVaneWebView", "onPageFinished");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.d
    public void a(WebView webView, int i4) {
        x.a("WindVaneWebView", "readyState");
    }
}
