package com.bigkoo.pickerview.lib;

import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: InertiaTimerTask.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
final class a extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    float f16300a = 2.1474836E9f;

    /* renamed from: b  reason: collision with root package name */
    final float f16301b;

    /* renamed from: c  reason: collision with root package name */
    final WheelView f16302c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(WheelView wheelView, float f4) {
        this.f16302c = wheelView;
        this.f16301b = f4;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f16300a == 2.1474836E9f) {
            if (Math.abs(this.f16301b) > 2000.0f) {
                if (this.f16301b > 0.0f) {
                    this.f16300a = 2000.0f;
                } else {
                    this.f16300a = -2000.0f;
                }
            } else {
                this.f16300a = this.f16301b;
            }
        }
        if (Math.abs(this.f16300a) >= 0.0f && Math.abs(this.f16300a) <= 20.0f) {
            this.f16302c.a();
            this.f16302c.f16276c.sendEmptyMessage(2000);
            return;
        }
        int i4 = (int) ((this.f16300a * 10.0f) / 1000.0f);
        WheelView wheelView = this.f16302c;
        wheelView.A -= i4;
        if (!wheelView.f16296w) {
            float f4 = wheelView.f16290q;
            float f5 = (-wheelView.B) * f4;
            WheelView wheelView2 = this.f16302c;
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView2.B) * f4;
            int i5 = wheelView2.A;
            double d4 = i5;
            double d5 = f4;
            Double.isNaN(d5);
            double d6 = d5 * 0.3d;
            Double.isNaN(d4);
            if (d4 - d6 < f5) {
                f5 = i4 + i5;
            } else {
                double d7 = i5;
                Double.isNaN(d7);
                if (d7 + d6 > itemsCount) {
                    itemsCount = i4 + i5;
                }
            }
            if (i5 <= f5) {
                this.f16300a = 40.0f;
                wheelView2.A = (int) f5;
            } else if (i5 >= itemsCount) {
                wheelView2.A = (int) itemsCount;
                this.f16300a = -40.0f;
            }
        }
        float f6 = this.f16300a;
        if (f6 < 0.0f) {
            this.f16300a = f6 + 20.0f;
        } else {
            this.f16300a = f6 - 20.0f;
        }
        this.f16302c.f16276c.sendEmptyMessage(1000);
    }
}
