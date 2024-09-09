package com.acse.ottn.dsbridge;

import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DWebView f5600a;

    g(DWebView dWebView) {
        this.f5600a = dWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5600a.f5559g = new ArrayList();
        super/*android.webkit.WebView*/.reload();
    }
}
