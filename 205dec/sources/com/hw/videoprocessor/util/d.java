package com.hw.videoprocessor.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: FrameDropper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private int f37612a;

    /* renamed from: b  reason: collision with root package name */
    private int f37613b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f37614c;

    /* renamed from: d  reason: collision with root package name */
    private int f37615d;

    /* renamed from: e  reason: collision with root package name */
    private int f37616e;

    public d(int i4, int i5) {
        this.f37612a = i4;
        this.f37613b = i5;
        if (i4 <= i5) {
            c.f("\u539f\u59cb\u5e27\u7387:" + i4 + "\u5c0f\u4e8e\u76ee\u6807\u5e27\u7387:" + i5 + "\uff0c\u4e0d\u652f\u6301\u8865\u5e27", new Object[0]);
            this.f37614c = true;
        }
    }

    public boolean a(int i4) {
        int i5;
        if (this.f37614c) {
            return false;
        }
        if (i4 == 0) {
            this.f37616e++;
            return false;
        }
        float f4 = (i5 - this.f37613b) / this.f37612a;
        int i6 = this.f37615d;
        int i7 = this.f37616e;
        boolean z3 = Math.abs((((float) (i6 + 1)) / ((float) (i6 + i7))) - f4) < Math.abs((((float) i6) / ((float) ((i6 + i7) + 1))) - f4);
        if (z3) {
            this.f37615d++;
        } else {
            this.f37616e++;
        }
        return z3;
    }

    public void b() {
        if (this.f37614c) {
            return;
        }
        int i4 = this.f37615d;
        int i5 = this.f37616e;
        int i6 = this.f37612a;
        float f4 = i5 / ((i4 + i5) / i6);
        float f5 = (i6 - this.f37613b) / i6;
        c.k("\u6700\u7ec8\u5e27\u7387\u4e3a:" + f4, new Object[0]);
        StringBuilder sb = new StringBuilder();
        sb.append("\u5b9e\u9645\u4e22\u5e27\u7387:");
        int i7 = this.f37615d;
        sb.append(i7 / (i7 + this.f37616e));
        sb.append(" \u76ee\u6807\u4e22\u5e27\u7387:");
        sb.append(f5);
        c.k(sb.toString(), new Object[0]);
    }
}
