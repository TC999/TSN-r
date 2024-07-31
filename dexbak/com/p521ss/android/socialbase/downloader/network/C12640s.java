package com.p521ss.android.socialbase.downloader.network;

import com.github.mikephil.charting.utils.Utils;

/* renamed from: com.ss.android.socialbase.downloader.network.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12640s {

    /* renamed from: a */
    private final int f35613a;

    /* renamed from: bl */
    private double f35614bl = -1.0d;

    /* renamed from: ok */
    private final double f35615ok;

    /* renamed from: s */
    private int f35616s;

    public C12640s(double d) {
        this.f35615ok = d;
        this.f35613a = d == Utils.DOUBLE_EPSILON ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d);
    }

    /* renamed from: ok */
    public void m16899ok(double d) {
        double d2 = 1.0d - this.f35615ok;
        int i = this.f35616s;
        if (i > this.f35613a) {
            this.f35614bl = Math.exp((d2 * Math.log(this.f35614bl)) + (this.f35615ok * Math.log(d)));
        } else if (i > 0) {
            double d3 = i;
            Double.isNaN(d3);
            double d4 = i;
            Double.isNaN(d4);
            double d5 = (d2 * d3) / (d4 + 1.0d);
            this.f35614bl = Math.exp((d5 * Math.log(this.f35614bl)) + ((1.0d - d5) * Math.log(d)));
        } else {
            this.f35614bl = d;
        }
        this.f35616s++;
    }

    /* renamed from: ok */
    public double m16900ok() {
        return this.f35614bl;
    }
}
