package com.acse.ottn.util;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class L implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ N f6765a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public L(N n4) {
        this.f6765a = n4;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6765a.f6773d.onFinish();
    }
}
