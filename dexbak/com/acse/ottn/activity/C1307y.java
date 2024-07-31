package com.acse.ottn.activity;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.acse.ottn.activity.y */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1307y extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ ExcessActivity f2213a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1307y(ExcessActivity excessActivity) {
        this.f2213a = excessActivity;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
