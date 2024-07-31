package com.acse.ottn.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.acse.ottn.activity.H */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1270H extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ SeedingLoadingActivity f2113a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1270H(SeedingLoadingActivity seedingLoadingActivity) {
        this.f2113a = seedingLoadingActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
