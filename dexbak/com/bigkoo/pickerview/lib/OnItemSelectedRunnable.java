package com.bigkoo.pickerview.lib;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bigkoo.pickerview.lib.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class OnItemSelectedRunnable implements Runnable {

    /* renamed from: a */
    final WheelView f13110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OnItemSelectedRunnable(WheelView wheelView) {
        this.f13110a = wheelView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WheelView wheelView = this.f13110a;
        wheelView.f13080e.mo12719a(wheelView.getCurrentItem());
    }
}
