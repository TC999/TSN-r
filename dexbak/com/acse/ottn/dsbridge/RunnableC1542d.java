package com.acse.ottn.dsbridge;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.dsbridge.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class RunnableC1542d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f2867a;

    /* renamed from: b */
    final /* synthetic */ DWebView f2868b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1542d(DWebView dWebView, String str) {
        this.f2868b = dWebView;
        this.f2867a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2868b.m56462c(this.f2867a);
    }
}
