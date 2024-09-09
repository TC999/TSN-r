package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class h extends c {
    private final com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> A;
    private com.bytedance.adsdk.lottie.c.w.h B;

    /* renamed from: r  reason: collision with root package name */
    private final String f25382r;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f25383s;

    /* renamed from: t  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f25384t;

    /* renamed from: u  reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f25385u;

    /* renamed from: v  reason: collision with root package name */
    private final RectF f25386v;

    /* renamed from: w  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.w.r f25387w;

    /* renamed from: x  reason: collision with root package name */
    private final int f25388x;

    /* renamed from: y  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<com.bytedance.adsdk.lottie.xv.w.h, com.bytedance.adsdk.lottie.xv.w.h> f25389y;

    /* renamed from: z  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> f25390z;

    public h(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.d dVar2) {
        super(dVar, aVar, dVar2.e().c(), dVar2.g().c(), dVar2.b(), dVar2.k(), dVar2.j(), dVar2.i(), dVar2.h());
        this.f25384t = new LongSparseArray<>();
        this.f25385u = new LongSparseArray<>();
        this.f25386v = new RectF();
        this.f25382r = dVar2.d();
        this.f25387w = dVar2.m();
        this.f25383s = dVar2.c();
        this.f25388x = (int) (dVar.S().q() / 32.0f);
        com.bytedance.adsdk.lottie.c.w.c<com.bytedance.adsdk.lottie.xv.w.h, com.bytedance.adsdk.lottie.xv.w.h> c4 = dVar2.n().c();
        this.f25389y = c4;
        c4.f(this);
        aVar.l(c4);
        com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c5 = dVar2.l().c();
        this.f25390z = c5;
        c5.f(this);
        aVar.l(c5);
        com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c6 = dVar2.f().c();
        this.A = c6;
        c6.f(this);
        aVar.l(c6);
    }

    private int[] g(int[] iArr) {
        com.bytedance.adsdk.lottie.c.w.h hVar = this.B;
        if (hVar != null) {
            Integer[] numArr = (Integer[]) hVar.j();
            int i4 = 0;
            if (iArr.length == numArr.length) {
                while (i4 < iArr.length) {
                    iArr[i4] = numArr[i4].intValue();
                    i4++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i4 < numArr.length) {
                    iArr[i4] = numArr[i4].intValue();
                    i4++;
                }
            }
        }
        return iArr;
    }

    private int h() {
        int round = Math.round(this.f25390z.g() * this.f25388x);
        int round2 = Math.round(this.A.g() * this.f25388x);
        int round3 = Math.round(this.f25389y.g() * this.f25388x);
        int i4 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i4 = i4 * 31 * round2;
        }
        return round3 != 0 ? i4 * 31 * round3 : i4;
    }

    private LinearGradient i() {
        long h4 = h();
        LinearGradient linearGradient = this.f25384t.get(h4);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF j4 = this.f25390z.j();
        PointF j5 = this.A.j();
        com.bytedance.adsdk.lottie.xv.w.h j6 = this.f25389y.j();
        LinearGradient linearGradient2 = new LinearGradient(j4.x, j4.y, j5.x, j5.y, g(j6.e()), j6.d(), Shader.TileMode.CLAMP);
        this.f25384t.put(h4, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient j() {
        float f4;
        float f5;
        long h4 = h();
        RadialGradient radialGradient = this.f25385u.get(h4);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF j4 = this.f25390z.j();
        PointF j5 = this.A.j();
        com.bytedance.adsdk.lottie.xv.w.h j6 = this.f25389y.j();
        int[] g4 = g(j6.e());
        float[] d4 = j6.d();
        RadialGradient radialGradient2 = new RadialGradient(j4.x, j4.y, (float) Math.hypot(j5.x - f4, j5.y - f5), g4, d4, Shader.TileMode.CLAMP);
        this.f25385u.put(h4, radialGradient2);
        return radialGradient2;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.c, com.bytedance.adsdk.lottie.c.c.r
    public void a(Canvas canvas, Matrix matrix, int i4) {
        Shader j4;
        if (this.f25383s) {
            return;
        }
        b(this.f25386v, matrix, false);
        if (this.f25387w == com.bytedance.adsdk.lottie.xv.w.r.LINEAR) {
            j4 = i();
        } else {
            j4 = j();
        }
        j4.setLocalMatrix(matrix);
        this.f25332i.setShader(j4);
        super.a(canvas, matrix, i4);
    }
}
