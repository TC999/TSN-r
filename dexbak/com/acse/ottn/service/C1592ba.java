package com.acse.ottn.service;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.acse.ottn.service.ba */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1592ba extends WebViewClient {

    /* renamed from: a */
    final /* synthetic */ WebViewService f3048a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1592ba(WebViewService webViewService) {
        this.f3048a = webViewService;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
