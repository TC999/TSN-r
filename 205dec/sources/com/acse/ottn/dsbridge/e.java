package com.acse.ottn.dsbridge;

import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5595a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DWebView f5596b;

    e(DWebView dWebView, String str) {
        this.f5596b = dWebView;
        this.f5595a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f5595a;
        if (str != null && str.startsWith("javascript:")) {
            super/*android.webkit.WebView*/.loadUrl(this.f5595a);
            return;
        }
        this.f5596b.f5559g = new ArrayList();
        super/*android.webkit.WebView*/.loadUrl(this.f5595a);
    }
}
