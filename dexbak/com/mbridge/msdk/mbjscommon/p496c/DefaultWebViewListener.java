package com.mbridge.msdk.mbjscommon.p496c;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.windvane.IWebViewListener;

/* renamed from: com.mbridge.msdk.mbjscommon.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DefaultWebViewListener implements IWebViewListener {
    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public final void mo21400a(WebView webView, String str, Bitmap bitmap) {
        SameLogTool.m21738a("WindVaneWebView", "onPageStarted");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: b */
    public final boolean mo21398b(WebView webView, String str) {
        SameLogTool.m21738a("WindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: c */
    public void mo21397c(WebView webView, int i) {
        SameLogTool.m21738a("WindVaneWebView", "loadingResourceStatus");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public void mo21138a(WebView webView, int i, String str, String str2) {
        SameLogTool.m21738a("WindVaneWebView", "onReceivedError");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: b */
    public final void mo21399b(WebView webView, int i) {
        SameLogTool.m21738a("WindVaneWebView", "onProgressChanged");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public void mo21137a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        SameLogTool.m21738a("WindVaneWebView", "onReceivedSslError");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public void mo21037a(WebView webView, String str) {
        SameLogTool.m21738a("WindVaneWebView", "onPageFinished");
    }

    @Override // com.mbridge.msdk.mbjscommon.windvane.IWebViewListener
    /* renamed from: a */
    public void mo21139a(WebView webView, int i) {
        SameLogTool.m21738a("WindVaneWebView", "readyState");
    }
}
