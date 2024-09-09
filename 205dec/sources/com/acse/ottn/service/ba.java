package com.acse.ottn.service;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class ba extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WebViewService f6539a;

    ba(WebViewService webViewService) {
        this.f6539a = webViewService;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
