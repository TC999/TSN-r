package com.bytedance.adsdk.lottie.xv.c;

import com.bytedance.adsdk.lottie.n;
import java.util.Arrays;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n extends k<com.bytedance.adsdk.lottie.xv.w.h, com.bytedance.adsdk.lottie.xv.w.h> {
    public n(List<n.h<com.bytedance.adsdk.lottie.xv.w.h>> list) {
        super(b(list));
    }

    private static n.h<com.bytedance.adsdk.lottie.xv.w.h> a(n.h<com.bytedance.adsdk.lottie.xv.w.h> hVar) {
        com.bytedance.adsdk.lottie.xv.w.h hVar2 = hVar.f25666b;
        com.bytedance.adsdk.lottie.xv.w.h hVar3 = hVar.f25667c;
        if (hVar2 == null || hVar3 == null || hVar2.d().length == hVar3.d().length) {
            return hVar;
        }
        float[] d4 = d(hVar2.d(), hVar3.d());
        return hVar.a(hVar2.b(d4), hVar3.b(d4));
    }

    private static List<n.h<com.bytedance.adsdk.lottie.xv.w.h>> b(List<n.h<com.bytedance.adsdk.lottie.xv.w.h>> list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            list.set(i4, a(list.get(i4)));
        }
        return list;
    }

    static float[] d(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f4 = Float.NaN;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            if (fArr3[i5] != f4) {
                fArr3[i4] = fArr3[i5];
                i4++;
                f4 = fArr3[i5];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i4);
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.b
    public com.bytedance.adsdk.lottie.c.w.c<com.bytedance.adsdk.lottie.xv.w.h, com.bytedance.adsdk.lottie.xv.w.h> c() {
        return new com.bytedance.adsdk.lottie.c.w.n(this.f25774a);
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.k
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.k, com.bytedance.adsdk.lottie.xv.c.b
    public /* bridge */ /* synthetic */ boolean w() {
        return super.w();
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.k, com.bytedance.adsdk.lottie.xv.c.b
    public /* bridge */ /* synthetic */ List xv() {
        return super.xv();
    }
}
