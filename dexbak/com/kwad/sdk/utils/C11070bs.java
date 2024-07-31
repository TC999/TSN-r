package com.kwad.sdk.utils;

import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.MainThread;

/* renamed from: com.kwad.sdk.utils.bs */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11070bs {
    @MainThread
    /* renamed from: a */
    public static WebSettings m23848a(WebView webView) {
        webView.getSettings().setAllowFileAccess(false);
        return m23847b(webView);
    }

    /* renamed from: b */
    private static WebSettings m23847b(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setTextZoom(100);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            settings.setMixedContentMode(0);
        }
        if (i < 19) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
        if (i >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        webView.setSaveEnabled(false);
        return settings;
    }
}
