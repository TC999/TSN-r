package com.umeng.analytics.pro;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ShortStack.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bp {

    /* renamed from: a  reason: collision with root package name */
    private short[] f52723a;

    /* renamed from: b  reason: collision with root package name */
    private int f52724b = -1;

    public bp(int i4) {
        this.f52723a = new short[i4];
    }

    private void d() {
        short[] sArr = this.f52723a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f52723a = sArr2;
    }

    public short a() {
        short[] sArr = this.f52723a;
        int i4 = this.f52724b;
        this.f52724b = i4 - 1;
        return sArr[i4];
    }

    public short b() {
        return this.f52723a[this.f52724b];
    }

    public void c() {
        this.f52724b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i4 = 0; i4 < this.f52723a.length; i4++) {
            if (i4 != 0) {
                sb.append(" ");
            }
            if (i4 == this.f52724b) {
                sb.append(">>");
            }
            sb.append((int) this.f52723a[i4]);
            if (i4 == this.f52724b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s3) {
        if (this.f52723a.length == this.f52724b + 1) {
            d();
        }
        short[] sArr = this.f52723a;
        int i4 = this.f52724b + 1;
        this.f52724b = i4;
        sArr[i4] = s3;
    }
}
