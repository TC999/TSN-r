package com.mbridge.msdk.splash.view;

import android.graphics.Bitmap;
import android.os.Build;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.mbridge.msdk.click.p461b.DspFilterUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbjscommon.base.BaseWebViewClient;
import com.mbridge.msdk.mbjscommon.windvane.WindVaneWebView;
import com.mbridge.msdk.p457c.p459b.MraidJSController;
import com.mbridge.msdk.splash.p505d.SplashBridgeListener;
import com.mbridge.msdk.splash.p508js.SplashJSBridgeImpl;

/* renamed from: com.mbridge.msdk.splash.view.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class SplashWebViewClient extends BaseWebViewClient {

    /* renamed from: a */
    String f32082a;

    /* renamed from: b */
    SplashBridgeListener f32083b;

    /* renamed from: c */
    private final String f32084c = "SplashWebViewClient";

    public SplashWebViewClient(String str, SplashBridgeListener splashBridgeListener) {
        this.f32082a = str;
        this.f32083b = splashBridgeListener;
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        try {
            StringBuilder sb = new StringBuilder("javascript:");
            sb.append(MraidJSController.m23231a().m23228b());
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
            SameLogTool.m21735b("SplashWebViewClient", "onPageStarted", th);
        }
    }

    @Override // com.mbridge.msdk.mbjscommon.base.BaseWebViewClient, android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        try {
            WindVaneWebView windVaneWebView = (WindVaneWebView) webView;
            if (System.currentTimeMillis() - windVaneWebView.lastTouchTime <= DspFilterUtils.f30068c || !DspFilterUtils.m23081a(((SplashJSBridgeImpl) windVaneWebView.getObject()).m21029b().get(0), windVaneWebView.getUrl(), DspFilterUtils.f30067b)) {
                SameLogTool.m21733d("SplashWebViewClient", "Use html to open url.");
                SplashBridgeListener splashBridgeListener = this.f32083b;
                if (splashBridgeListener != null) {
                    splashBridgeListener.mo21114a(false, str);
                    return true;
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            SameLogTool.m21735b("SplashWebViewClient", "shouldOverrideUrlLoading", th);
            return false;
        }
    }
}
