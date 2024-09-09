package com.acse.ottn.util;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class M implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ N f6767a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(N n4) {
        this.f6767a = n4;
    }

    @Override // java.lang.Runnable
    public void run() {
        N n4 = this.f6767a;
        n4.f6773d.a(n4.f6772c - n4.f6770a[0]);
    }
}
