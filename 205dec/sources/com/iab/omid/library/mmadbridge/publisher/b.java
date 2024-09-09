package com.iab.omid.library.mmadbridge.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class b extends a {
    @SuppressLint({"SetJavaScriptEnabled"})
    public b(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        c(webView);
    }
}
