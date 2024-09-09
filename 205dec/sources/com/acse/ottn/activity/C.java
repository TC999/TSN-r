package com.acse.ottn.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class C extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SeedWebViewActivity f4660a;

    C(SeedWebViewActivity seedWebViewActivity) {
        this.f4660a = seedWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
