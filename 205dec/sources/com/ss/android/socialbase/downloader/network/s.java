package com.ss.android.socialbase.downloader.network;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
class s {

    /* renamed from: a  reason: collision with root package name */
    private final int f50055a;
    private double bl = -1.0d;
    private final double ok;

    /* renamed from: s  reason: collision with root package name */
    private int f50056s;

    public s(double d4) {
        this.ok = d4;
        this.f50055a = d4 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d4);
    }

    public void ok(double d4) {
        double d5 = 1.0d - this.ok;
        int i4 = this.f50056s;
        if (i4 > this.f50055a) {
            this.bl = Math.exp((d5 * Math.log(this.bl)) + (this.ok * Math.log(d4)));
        } else if (i4 > 0) {
            double d6 = i4;
            Double.isNaN(d6);
            double d7 = i4;
            Double.isNaN(d7);
            double d8 = (d5 * d6) / (d7 + 1.0d);
            this.bl = Math.exp((d8 * Math.log(this.bl)) + ((1.0d - d8) * Math.log(d4)));
        } else {
            this.bl = d4;
        }
        this.f50056s++;
    }

    public double ok() {
        return this.bl;
    }
}
