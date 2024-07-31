package com.acse.ottn.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.acse.ottn.activity.C */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1264C extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ SeedWebViewActivity f2105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1264C(SeedWebViewActivity seedWebViewActivity) {
        this.f2105a = seedWebViewActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
