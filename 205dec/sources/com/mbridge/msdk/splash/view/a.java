package com.mbridge.msdk.splash.view;

import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.base.b;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;

/* compiled from: SplashWebViewClient.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a extends b {

    /* renamed from: a  reason: collision with root package name */
    String f40833a;

    /* renamed from: b  reason: collision with root package name */
    com.mbridge.msdk.splash.d.a f40834b;

    /* renamed from: c  reason: collision with root package name */
    private final String f40835c = "SplashWebViewClient";

    public a(String str, com.mbridge.msdk.splash.d.a aVar) {
        this.f40833a = str;
        this.f40834b = aVar;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            StringBuilder sb = new StringBuilder("javascript:");
            sb.append(com.mbridge.msdk.c.b.b.a().b());
            if (Build.VERSION.SDK_INT <= 19) {
                webView.loadUrl(sb.toString());
            } else {
                webView.evaluateJavascript(sb.toString(), new ValueCallback<String>() { // from class: com.mbridge.msdk.splash.view.a.1
                    @Override // android.webkit.ValueCallback
                    public final /* bridge */ /* synthetic */ void onReceiveValue(String str2) {
                    }
                });
            }
        } catch (Throwable th) {
            x.b("SplashWebViewClient", "onPageStarted", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.base.b, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            WindVaneWebView windVaneWebView = (WindVaneWebView) webView;
            if (System.currentTimeMillis() - windVaneWebView.lastTouchTime <= com.mbridge.msdk.click.b.a.f38895c || !com.mbridge.msdk.click.b.a.a(((com.mbridge.msdk.splash.js.b) windVaneWebView.getObject()).b().get(0), windVaneWebView.getUrl(), com.mbridge.msdk.click.b.a.f38894b)) {
                x.d("SplashWebViewClient", "Use html to open url.");
                com.mbridge.msdk.splash.d.a aVar = this.f40834b;
                if (aVar != null) {
                    aVar.a(false, str);
                    return true;
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            x.b("SplashWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
