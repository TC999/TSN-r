package com.acse.ottn.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class H extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SeedingLoadingActivity f4666a;

    H(SeedingLoadingActivity seedingLoadingActivity) {
        this.f4666a = seedingLoadingActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
