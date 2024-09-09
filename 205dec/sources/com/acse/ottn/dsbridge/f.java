package com.acse.ottn.dsbridge;

import java.util.ArrayList;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5597a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Map f5598b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ DWebView f5599c;

    f(DWebView dWebView, String str, Map map) {
        this.f5599c = dWebView;
        this.f5597a = str;
        this.f5598b = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.f5597a;
        if (str != null && str.startsWith("javascript:")) {
            super/*android.webkit.WebView*/.loadUrl(this.f5597a, this.f5598b);
            return;
        }
        this.f5599c.f5559g = new ArrayList();
        super/*android.webkit.WebView*/.loadUrl(this.f5597a, this.f5598b);
    }
}
