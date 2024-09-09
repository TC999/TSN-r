package com.acse.ottn.activity;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class P implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WhiteActivity f4675a;

    P(WhiteActivity whiteActivity) {
        this.f4675a = whiteActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4675a.finish();
    }
}
