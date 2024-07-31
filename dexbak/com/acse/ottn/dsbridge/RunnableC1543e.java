package com.acse.ottn.dsbridge;

import java.util.ArrayList;

/* renamed from: com.acse.ottn.dsbridge.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1543e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2869a;

    /* renamed from: b */
    final /* synthetic */ DWebView f2870b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1543e(DWebView dWebView, String str) {
        this.f2870b = dWebView;
        this.f2869a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f2869a;
        if (str != null && str.startsWith("javascript:")) {
            super/*android.webkit.WebView*/.loadUrl(this.f2869a);
            return;
        }
        this.f2870b.f2853j = new ArrayList();
        super/*android.webkit.WebView*/.loadUrl(this.f2869a);
    }
}
