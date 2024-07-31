package com.bigkoo.pickerview.lib;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.bigkoo.pickerview.lib.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SmoothScrollTimerTask extends TimerTask {

    /* renamed from: a */
    int f13111a = Integer.MAX_VALUE;

    /* renamed from: b */
    int f13112b = 0;

    /* renamed from: c */
    int f13113c;

    /* renamed from: d */
    final WheelView f13114d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SmoothScrollTimerTask(WheelView wheelView, int i) {
        this.f13114d = wheelView;
        this.f13113c = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.f13111a == Integer.MAX_VALUE) {
            this.f13111a = this.f13113c;
        }
        int i = this.f13111a;
        int i2 = (int) (i * 0.1f);
        this.f13112b = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.f13112b = -1;
            } else {
                this.f13112b = 1;
            }
        }
        if (Math.abs(i) <= 1) {
            this.f13114d.m45892a();
            this.f13114d.f13078c.sendEmptyMessage(3000);
            return;
        }
        WheelView wheelView = this.f13114d;
        wheelView.f13058A += this.f13112b;
        if (!wheelView.f13098w) {
            float f = wheelView.f13092q;
            float f2 = (-wheelView.f13059B) * f;
            WheelView wheelView2 = this.f13114d;
            float itemsCount = ((wheelView.getItemsCount() - 1) - wheelView2.f13059B) * f;
            int i3 = wheelView2.f13058A;
            if (i3 <= f2 || i3 >= itemsCount) {
                wheelView2.f13058A = i3 - this.f13112b;
                wheelView2.m45892a();
                this.f13114d.f13078c.sendEmptyMessage(3000);
                return;
            }
        }
        this.f13114d.f13078c.sendEmptyMessage(1000);
        this.f13111a -= this.f13112b;
    }
}
