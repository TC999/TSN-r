package com.mbridge.msdk.mbjscommon.windvane;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.x;

/* compiled from: WindVaneWebViewClient.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m extends com.mbridge.msdk.mbjscommon.base.b {

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40365b = true;

    /* renamed from: a  reason: collision with root package name */
    protected String f40366a = null;

    /* renamed from: c  reason: collision with root package name */
    private int f40367c = 0;

    /* renamed from: d  reason: collision with root package name */
    private d f40368d;

    private WebResourceResponse a(String str) {
        try {
            if (TextUtils.isEmpty(str) || !k.d(str)) {
                return null;
            }
            x.b("WindVaneWebViewClient", "is image " + str);
            Bitmap a4 = com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.f().j()).a(str);
            x.b("WindVaneWebViewClient", "find image from cache " + str);
            if (a4 == null || a4.isRecycled()) {
                return null;
            }
            return new WebResourceResponse(k.e(str), "utf-8", com.mbridge.msdk.foundation.same.c.a.a(a4));
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f40366a = str;
        d dVar = this.f40368d;
        if (dVar != null) {
            dVar.a(webView, str, bitmap);
        }
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        WebResourceResponse a4 = a(str);
        if (a4 != null) {
            x.b("WindVaneWebViewClient", "find WebResourceResponse url is " + str);
            return a4;
        }
        return super.shouldInterceptRequest(webView, str);
    }
}
