package com.ss.android.socialbase.downloader.network;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
class sr {

    /* renamed from: c  reason: collision with root package name */
    private final double f50057c;
    private int sr;

    /* renamed from: w  reason: collision with root package name */
    private final int f50058w;
    private double xv = -1.0d;

    public sr(double d4) {
        this.f50057c = d4;
        this.f50058w = d4 == 0.0d ? Integer.MAX_VALUE : (int) Math.ceil(1.0d / d4);
    }

    public void c(double d4) {
        double d5 = 1.0d - this.f50057c;
        int i4 = this.sr;
        if (i4 > this.f50058w) {
            this.xv = Math.exp((d5 * Math.log(this.xv)) + (this.f50057c * Math.log(d4)));
        } else if (i4 > 0) {
            double d6 = i4;
            Double.isNaN(d6);
            double d7 = i4;
            Double.isNaN(d7);
            double d8 = (d5 * d6) / (d7 + 1.0d);
            this.xv = Math.exp((d8 * Math.log(this.xv)) + ((1.0d - d8) * Math.log(d4)));
        } else {
            this.xv = d4;
        }
        this.sr++;
    }

    public double c() {
        return this.xv;
    }
}
