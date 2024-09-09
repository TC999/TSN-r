package com.qq.e.lib.d;

import android.graphics.Bitmap;
import android.graphics.Color;
import com.qq.e.lib.d.b;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final a[] f47405a;

    /* renamed from: b  reason: collision with root package name */
    private static final int f47406b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private final float f47407a;

        /* renamed from: b  reason: collision with root package name */
        private final float f47408b;

        /* renamed from: c  reason: collision with root package name */
        private final float f47409c;

        /* renamed from: d  reason: collision with root package name */
        private final int f47410d;

        a(float f4, int i4) {
            this.f47407a = (f4 > 1.0f || f4 < 0.0f) ? -1.0f : -1.0f;
            this.f47409c = -1.0f;
            this.f47408b = -1.0f;
            this.f47410d = i4;
        }

        final int a(float[] fArr) {
            float f4 = this.f47407a;
            if (f4 != -1.0f && fArr[1] > f4) {
                return c.f47406b;
            }
            float f5 = this.f47408b;
            if (f5 != -1.0f && fArr[0] < f5) {
                return c.f47406b;
            }
            float f6 = this.f47409c;
            if (f6 != -1.0f && fArr[0] >= f6) {
                return c.f47406b;
            }
            return this.f47410d;
        }

        a(float f4, float f5, int i4) {
            this.f47407a = -1.0f;
            this.f47408b = f4 < 0.0f ? -1.0f : f4;
            this.f47409c = f5 >= 360.0f ? -1.0f : f5;
            this.f47410d = i4;
        }
    }

    static {
        a[] aVarArr = {new a(0.0f, Color.rgb(161, 166, 178)), new a(0.0f, 10.0f, Color.rgb(178, 79, 71)), new a(340.0f, 360.0f, Color.rgb(178, 79, 71)), new a(10.0f, 30.0f, Color.rgb(204, 116, 82)), new a(30.0f, 60.0f, Color.rgb(204, 142, 71)), new a(60.0f, 120.0f, Color.rgb(159, 163, 95)), new a(120.0f, 180.0f, Color.rgb(120, 161, 112)), new a(180.0f, 190.0f, Color.rgb(107, 153, 153)), new a(190.0f, 240.0f, Color.rgb(125, 158, 184)), new a(240.0f, 260.0f, Color.rgb(142, 130, 178)), new a(260.0f, 310.0f, Color.rgb(158, 115, 148)), new a(310.0f, 340.0f, Color.rgb(184, 114, 135))};
        f47405a = aVarArr;
        f47406b = aVarArr[0].f47410d;
    }

    public static b b(Bitmap bitmap) {
        return new b.C0926b(bitmap).a();
    }

    public static b.d a(Bitmap bitmap) {
        b b4 = b(bitmap);
        b.d[] dVarArr = {b4.h(), b4.d(), b4.c(), b4.g(), b4.e(), b4.f()};
        b.d dVar = null;
        for (int i4 = 0; i4 < 6; i4++) {
            b.d dVar2 = dVarArr[i4];
            if (dVar2 != null && (dVar == null || dVar2.d() > dVar.d())) {
                dVar = dVar2;
            }
        }
        return dVar;
    }

    public static int a(Bitmap bitmap, int i4) {
        b.d a4 = a(bitmap);
        if (a4 == null) {
            return f47406b;
        }
        float[] c4 = a4.c();
        int i5 = 0;
        while (true) {
            a[] aVarArr = f47405a;
            if (i5 < aVarArr.length) {
                int a5 = aVarArr[i5].a(c4);
                if (a5 != f47406b) {
                    if (i4 != 0) {
                        a[] aVarArr2 = f47405a;
                        int length = (((i5 - 1) + i4) % (aVarArr2.length - 1)) + 1;
                        if (length < 0) {
                            length += aVarArr2.length;
                        }
                        return f47405a[length].f47410d;
                    }
                    return a5;
                }
                i5++;
            } else {
                return f47406b;
            }
        }
    }
}
