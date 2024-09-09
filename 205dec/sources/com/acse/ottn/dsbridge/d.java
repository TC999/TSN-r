package com.acse.ottn.dsbridge;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f5593a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DWebView f5594b;

    d(DWebView dWebView, String str) {
        this.f5594b = dWebView;
        this.f5593a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5594b.a(this.f5593a);
    }
}
