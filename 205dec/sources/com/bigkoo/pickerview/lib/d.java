package com.bigkoo.pickerview.lib;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: OnItemSelectedRunnable.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final WheelView f16308a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WheelView wheelView) {
        this.f16308a = wheelView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        WheelView wheelView = this.f16308a;
        wheelView.f16278e.a(wheelView.getCurrentItem());
    }
}
