package com.bytedance.adsdk.lottie.xv.w;

import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f25857a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f25858b;

    public h(float[] fArr, int[] iArr) {
        this.f25857a = fArr;
        this.f25858b = iArr;
    }

    private int a(float f4) {
        int binarySearch = Arrays.binarySearch(this.f25857a, f4);
        if (binarySearch >= 0) {
            return this.f25858b[binarySearch];
        }
        int i4 = -(binarySearch + 1);
        if (i4 == 0) {
            return this.f25858b[0];
        }
        int[] iArr = this.f25858b;
        if (i4 == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.f25857a;
        int i5 = i4 - 1;
        float f5 = fArr[i5];
        return com.bytedance.adsdk.lottie.f.g.b((f4 - f5) / (fArr[i4] - f5), iArr[i5], iArr[i4]);
    }

    public h b(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i4 = 0; i4 < fArr.length; i4++) {
            iArr[i4] = a(fArr[i4]);
        }
        return new h(fArr, iArr);
    }

    public void c(h hVar, h hVar2, float f4) {
        if (hVar.f25858b.length == hVar2.f25858b.length) {
            for (int i4 = 0; i4 < hVar.f25858b.length; i4++) {
                this.f25857a[i4] = com.bytedance.adsdk.lottie.f.d.a(hVar.f25857a[i4], hVar2.f25857a[i4], f4);
                this.f25858b[i4] = com.bytedance.adsdk.lottie.f.g.b(f4, hVar.f25858b[i4], hVar2.f25858b[i4]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + hVar.f25858b.length + " vs " + hVar2.f25858b.length + ")");
    }

    public float[] d() {
        return this.f25857a;
    }

    public int[] e() {
        return this.f25858b;
    }

    public int f() {
        return this.f25858b.length;
    }
}
