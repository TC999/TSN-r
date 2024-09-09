package com.mbridge.msdk.mbjscommon.windvane;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

/* compiled from: IWebViewListener.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface d {
    void a(WebView webView, int i4);

    void a(WebView webView, int i4, String str, String str2);

    void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    void a(WebView webView, String str);

    void a(WebView webView, String str, Bitmap bitmap);

    void b(WebView webView, int i4);

    boolean b(WebView webView, String str);

    void c(WebView webView, int i4);
}
