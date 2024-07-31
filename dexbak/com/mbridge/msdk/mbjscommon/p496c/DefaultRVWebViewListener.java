package com.mbridge.msdk.mbjscommon.p496c;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.windvane.InterfaceC11508c;

/* renamed from: com.mbridge.msdk.mbjscommon.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DefaultRVWebViewListener implements InterfaceC11508c {
    /* renamed from: a */
    public void m21500a(Object obj) {
        SameLogTool.m21738a("RVWindVaneWebView", "getEndScreenInfo");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: b */
    public final boolean mo21398b(WebView webView, String str) {
        SameLogTool.m21738a("RVWindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: c */
    public final void mo21397c(WebView webView, int i) {
        SameLogTool.m21738a("RVWindVaneWebView", "loadingResourceStatus");
    }

    /* renamed from: a */
    public void m21501a(WebView webView, String str, String str2, int i, int i2) {
        SameLogTool.m21738a("RVWindVaneWebView", "loadAds");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: b */
    public final void mo21399b(WebView webView, int i) {
        SameLogTool.m21738a("RVWindVaneWebView", "onProgressChanged");
    }

    /* renamed from: a */
    public void m21499a(Object obj, String str) {
        SameLogTool.m21738a("RVWindVaneWebView", "operateComponent");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public final void mo21400a(WebView webView, String str, Bitmap bitmap) {
        SameLogTool.m21738a("RVWindVaneWebView", "onPageStarted");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public void mo21138a(WebView webView, int i, String str, String str2) {
        SameLogTool.m21738a("RVWindVaneWebView", "onReceivedError");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public void mo21137a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        SameLogTool.m21738a("RVWindVaneWebView", "onReceivedSslError");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public void mo21037a(WebView webView, String str) {
        SameLogTool.m21738a("RVWindVaneWebView", "onPageFinished");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public void mo21139a(WebView webView, int i) {
        SameLogTool.m21738a("RVWindVaneWebView", "readyState");
    }
}
