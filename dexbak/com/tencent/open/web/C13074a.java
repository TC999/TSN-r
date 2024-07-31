package com.tencent.open.web;

import android.webkit.WebSettings;
import android.webkit.WebView;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.web.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13074a {
    /* renamed from: a */
    public static void m14910a(WebView webView) {
        if (webView == null) {
            return;
        }
        m14908b(webView);
        WebSettings settings = webView.getSettings();
        if (settings != null) {
            m14911a(settings);
            m14909b(settings);
        }
    }

    /* renamed from: b */
    private static void m14908b(WebView webView) {
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
    }

    /* renamed from: b */
    private static void m14909b(WebSettings webSettings) {
        webSettings.setJavaScriptEnabled(true);
    }

    /* renamed from: a */
    private static void m14911a(WebSettings webSettings) {
        try {
            webSettings.setSavePassword(false);
            webSettings.setAllowFileAccess(false);
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        } catch (Exception e) {
            SLog.m15128e("WebViewUtils", "Exception", e);
        }
    }
}
