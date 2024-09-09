package com.qq.e.comm.plugin.q0;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface f {

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface a extends f {
        void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse);
    }

    void a();

    void a(int i4);

    void a(int i4, String str, String str2);

    void a(ValueCallback<Uri> valueCallback, Intent intent);

    void a(String str);

    void a(String str, Bitmap bitmap);

    void b(String str);

    boolean b(ValueCallback<Uri[]> valueCallback, Intent intent);

    void c(String str);
}
