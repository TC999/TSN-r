package com.iab.omid.library.mmadbridge.publisher;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* renamed from: com.iab.omid.library.mmadbridge.publisher.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7110b extends AbstractC7108a {
    @SuppressLint({"SetJavaScriptEnabled"})
    public C7110b(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        m34649c(webView);
    }
}
