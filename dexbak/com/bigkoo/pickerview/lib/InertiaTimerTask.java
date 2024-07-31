package com.bigkoo.pickerview.lib;

import java.util.TimerTask;

/* renamed from: com.bigkoo.pickerview.lib.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
final class InertiaTimerTask extends TimerTask {

    /* renamed from: a */
    float f13102a = 2.1474836E9f;

    /* renamed from: b */
    final float f13103b;

    /* renamed from: c */
    final WheelView f13104c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InertiaTimerTask(WheelView wheelView, float f) {
        this.f13104c = wheelView;
        this.f13103b = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f13102a == 2.1474836E9f) {
            if (Math.abs(this.f13103b) > 2000.0f) {
                if (this.f13103b > 0.0f) {
                    this.f13102a = 2000.0f;
                } else {
                    this.f13102a = -2000.0f;
                }
            } else {
                this.f13102a = this.f13103b;
            }
        }
        if (Math.abs(this.f13102a) >= 0.0f && Math.abs(this.f13102a) <= 20.0f) {
            this.f13104c.m45892a();
            this.f13104c.f13078c.sendEmptyMessage(2000);
            return;
        }
        int i = (int) ((this.f13102a * 10.0f) / 1000.0f);
        WheelView wheelView = this.f13104c;
        wheelView.f13058A -= i;
        if (!wheelView.f13098w) {
            float f = wheelView.f13092q;
            float f2 = (-wheelView.f13059B) * f;
            WheelView wheelView2 = this.f13104c;
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView2.f13059B) * f;
            int i2 = wheelView2.f13058A;
            double d = i2;
            double d2 = f;
            Double.isNaN(d2);
            double d3 = d2 * 0.3d;
            Double.isNaN(d);
            if (d - d3 < f2) {
                f2 = i + i2;
            } else {
                double d4 = i2;
                Double.isNaN(d4);
                if (d4 + d3 > itemsCount) {
                    itemsCount = i + i2;
                }
            }
            if (i2 <= f2) {
                this.f13102a = 40.0f;
                wheelView2.f13058A = (int) f2;
            } else if (i2 >= itemsCount) {
                wheelView2.f13058A = (int) itemsCount;
                this.f13102a = -40.0f;
            }
        }
        float f3 = this.f13102a;
        if (f3 < 0.0f) {
            this.f13102a = f3 + 20.0f;
        } else {
            this.f13102a = f3 - 20.0f;
        }
        this.f13104c.f13078c.sendEmptyMessage(1000);
    }
}
