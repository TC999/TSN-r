package com.beizi.ad.internal.download;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.CookieManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BeiZiWebView extends WebView {
    public BeiZiWebView(Context context) {
        super(context);
        a();
    }

    private void a() {
        try {
            b();
        } catch (Throwable unused) {
        }
    }

    private void b() {
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
        int i4 = Build.VERSION.SDK_INT;
        settings.setMediaPlaybackRequiresUserGesture(false);
        if (i4 >= 21) {
            settings.setMixedContentMode(0);
        }
        if (i4 >= 19) {
            WebView.setWebContentsDebuggingEnabled(false);
        }
        settings.setAppCachePath(getContext().getCacheDir().getAbsolutePath());
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(-1);
        if (i4 < 19) {
            removeJavascriptInterface("searchBoxJavaBridge_");
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        if (i4 >= 21 && (cookieManager = CookieManager.getInstance()) != null) {
            cookieManager.setAcceptThirdPartyCookies(this, true);
        }
        setHorizontalScrollbarOverlay(false);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setScrollBarStyle(0);
        setWebViewClient(new WebViewClient() { // from class: com.beizi.ad.internal.download.BeiZiWebView.1
            @Override // android.webkit.WebViewClient
            @RequiresApi(api = 21)
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                try {
                    Uri url = webResourceRequest.getUrl();
                    if (url == null) {
                        return false;
                    }
                    return !url.toString().startsWith("http");
                } catch (Exception e4) {
                    e4.printStackTrace();
                    return false;
                }
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return !str.startsWith("http");
            }
        });
    }

    public BeiZiWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public BeiZiWebView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a();
    }
}
