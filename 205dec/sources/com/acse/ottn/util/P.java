package com.acse.ottn.util;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class P implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Q f6780a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public P(Q q3) {
        this.f6780a = q3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Q q3 = this.f6780a;
        q3.f6784d.a(q3.f6783c - q3.f6781a[0]);
    }
}
