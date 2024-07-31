package com.acse.ottn.dsbridge;

import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.acse.ottn.dsbridge.f */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class RunnableC1544f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2871a;

    /* renamed from: b */
    final /* synthetic */ Map f2872b;

    /* renamed from: c */
    final /* synthetic */ DWebView f2873c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1544f(DWebView dWebView, String str, Map map) {
        this.f2873c = dWebView;
        this.f2871a = str;
        this.f2872b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f2871a;
        if (str != null && str.startsWith("javascript:")) {
            super/*android.webkit.WebView*/.loadUrl(this.f2871a, this.f2872b);
            return;
        }
        this.f2873c.f2853j = new ArrayList();
        super/*android.webkit.WebView*/.loadUrl(this.f2871a, this.f2872b);
    }
}
