package com.acse.ottn.receiver;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HomeKeyReceiver f6216a;

    a(HomeKeyReceiver homeKeyReceiver) {
        this.f6216a = homeKeyReceiver;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6216a.f6212d = false;
    }
}
