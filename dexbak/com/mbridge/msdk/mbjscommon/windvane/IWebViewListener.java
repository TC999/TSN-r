package com.mbridge.msdk.mbjscommon.windvane;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

/* renamed from: com.mbridge.msdk.mbjscommon.windvane.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IWebViewListener {
    /* renamed from: a */
    void mo21139a(WebView webView, int i);

    /* renamed from: a */
    void mo21138a(WebView webView, int i, String str, String str2);

    /* renamed from: a */
    void mo21137a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError);

    /* renamed from: a */
    void mo21037a(WebView webView, String str);

    /* renamed from: a */
    void mo21400a(WebView webView, String str, Bitmap bitmap);

    /* renamed from: b */
    void mo21399b(WebView webView, int i);

    /* renamed from: b */
    boolean mo21398b(WebView webView, String str);

    /* renamed from: c */
    void mo21397c(WebView webView, int i);
}
