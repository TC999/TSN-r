package com.kwad.sdk.utils;

import android.os.Build;
import android.os.Message;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.MainThread;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bs {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface a {
        void a(Message message);
    }

    @MainThread
    public static WebSettings a(WebView webView) {
        webView.getSettings().setAllowFileAccess(false);
        return b(webView);
    }

    private static WebSettings b(WebView webView) {
        WebSettings settings = webView.getSettings();
        settings.setAllowContentAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setTextZoom(100);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            settings.setMixedContentMode(0);
        }
        if (i4 < 19) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
        if (i4 >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true);
        }
        webView.setSaveEnabled(false);
        return settings;
    }
}
