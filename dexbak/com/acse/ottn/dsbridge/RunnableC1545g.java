package com.acse.ottn.dsbridge;

import java.util.ArrayList;

/* renamed from: com.acse.ottn.dsbridge.g */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1545g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ DWebView f2874a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1545g(DWebView dWebView) {
        this.f2874a = dWebView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2874a.f2853j = new ArrayList();
        super/*android.webkit.WebView*/.reload();
    }
}
