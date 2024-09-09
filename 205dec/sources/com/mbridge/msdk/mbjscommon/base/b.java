package com.mbridge.msdk.mbjscommon.base;

import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: BaseWebViewClient.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    private a f40203a;

    /* renamed from: b  reason: collision with root package name */
    private com.mbridge.msdk.mbjscommon.windvane.d f40204b;

    public final void a(a aVar) {
        this.f40203a = aVar;
    }

    public final a b() {
        return this.f40203a;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        com.mbridge.msdk.mbjscommon.windvane.d dVar = this.f40204b;
        if (dVar != null) {
            dVar.a(webView, str);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i4, String str, String str2) {
        super.onReceivedError(webView, i4, str, str2);
        com.mbridge.msdk.mbjscommon.windvane.d dVar = this.f40204b;
        if (dVar != null) {
            dVar.a(webView, i4, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        com.mbridge.msdk.mbjscommon.windvane.d dVar = this.f40204b;
        if (dVar != null) {
            dVar.a(webView, sslErrorHandler, sslError);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        a aVar = this.f40203a;
        if (aVar == null || !aVar.a(str)) {
            com.mbridge.msdk.mbjscommon.windvane.d dVar = this.f40204b;
            if (dVar != null) {
                dVar.b(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
        return true;
    }

    public final void a(com.mbridge.msdk.mbjscommon.windvane.d dVar) {
        this.f40204b = dVar;
    }
}
