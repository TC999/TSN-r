package com.beizi.p051ad.internal.download;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* renamed from: com.beizi.ad.internal.download.BeiZiWebView */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BeiZiWebView extends WebView {
    public BeiZiWebView(Context context) {
        super(context);
        m49527a();
    }

    /* renamed from: a */
    private void m49527a() {
        try {
            m49526b();
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private void m49526b() {
        CookieManager cookieManager;
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setBuiltInZoomControls(false);
        settings.setEnableSmoothTransition(true);
        settings.setLightTouchEnabled(false);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setLoadsImagesAutomatically(true);
        settings.setSavePassword(false);
        settings.setSupportZoom(false);
        settings.setUseWideViewPort(false);
        int i = Build.VERSION.SDK_INT;
        settings.setMediaPlaybackRequiresUserGesture(false);
        if (i >= 21) {
            settings.setMixedContentMode(0);
        }
        if (i >= 19) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        if (i < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        if (i >= 21 && (cookieManager = CookieManager.getInstance()) != null) {
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
        setHorizontalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(0);
    }

    public BeiZiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m49527a();
    }

    public BeiZiWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m49527a();
    }
}
