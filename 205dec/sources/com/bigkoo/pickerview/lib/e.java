package com.bigkoo.pickerview.lib;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SmoothScrollTimerTask.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class e extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    int f16309a = Integer.MAX_VALUE;

    /* renamed from: b  reason: collision with root package name */
    int f16310b = 0;

    /* renamed from: c  reason: collision with root package name */
    int f16311c;

    /* renamed from: d  reason: collision with root package name */
    final WheelView f16312d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WheelView wheelView, int i4) {
        this.f16312d = wheelView;
        this.f16311c = i4;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f16309a == Integer.MAX_VALUE) {
            this.f16309a = this.f16311c;
        }
        int i4 = this.f16309a;
        int i5 = (int) (i4 * 0.1f);
        this.f16310b = i5;
        if (i5 == 0) {
            if (i4 < 0) {
                this.f16310b = -1;
            } else {
                this.f16310b = 1;
            }
        }
        if (Math.abs(i4) <= 1) {
            this.f16312d.a();
            this.f16312d.f16276c.sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f16312d;
        wheelView.A += this.f16310b;
        if (!wheelView.f16296w) {
            float f4 = wheelView.f16290q;
            float f5 = (-wheelView.B) * f4;
            WheelView wheelView2 = this.f16312d;
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView2.B) * f4;
            int i6 = wheelView2.A;
            if (i6 <= f5 || i6 >= itemsCount) {
                wheelView2.A = i6 - this.f16310b;
                wheelView2.a();
                this.f16312d.f16276c.sendEmptyMessage(3000);
                return;
            }
        }
        this.f16312d.f16276c.sendEmptyMessage(1000);
        this.f16309a -= this.f16310b;
    }
}
