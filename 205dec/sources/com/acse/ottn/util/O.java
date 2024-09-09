package com.acse.ottn.util;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class O implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Q f6779a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(Q q3) {
        this.f6779a = q3;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6779a.f6784d.onFinish();
    }
}
