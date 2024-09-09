package com.acse.ottn.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class y extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ExcessActivity f4764a;

    y(ExcessActivity excessActivity) {
        this.f4764a = excessActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
