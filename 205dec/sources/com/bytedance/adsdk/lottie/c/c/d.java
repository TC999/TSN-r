package com.bytedance.adsdk.lottie.c.c;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.c.w.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d implements k, r, c.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f25343a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f25344b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.xv.a f25345c;

    /* renamed from: d  reason: collision with root package name */
    private final LongSparseArray<LinearGradient> f25346d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private final LongSparseArray<RadialGradient> f25347e = new LongSparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private final Path f25348f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f25349g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f25350h;

    /* renamed from: i  reason: collision with root package name */
    private final List<b> f25351i;

    /* renamed from: j  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.w.r f25352j;

    /* renamed from: k  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<com.bytedance.adsdk.lottie.xv.w.h, com.bytedance.adsdk.lottie.xv.w.h> f25353k;

    /* renamed from: l  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> f25354l;

    /* renamed from: m  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> f25355m;

    /* renamed from: n  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> f25356n;

    /* renamed from: o  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> f25357o;

    /* renamed from: p  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.h f25358p;

    /* renamed from: q  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25359q;

    /* renamed from: r  reason: collision with root package name */
    private final int f25360r;

    /* renamed from: s  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> f25361s;

    /* renamed from: t  reason: collision with root package name */
    float f25362t;

    /* renamed from: u  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.p f25363u;

    /* JADX WARN: Type inference failed for: r1v0, types: [android.graphics.Paint, h0.a] */
    public d(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.j jVar) {
        Path path = new Path();
        this.f25348f = path;
        this.f25349g = new h0.a(1);
        this.f25350h = new RectF();
        this.f25351i = new ArrayList();
        this.f25362t = 0.0f;
        this.f25345c = aVar;
        this.f25343a = jVar.b();
        this.f25344b = jVar.c();
        this.f25359q = dVar;
        this.f25352j = jVar.h();
        path.setFillType(jVar.i());
        this.f25360r = (int) (eVar.q() / 32.0f);
        com.bytedance.adsdk.lottie.c.w.c<com.bytedance.adsdk.lottie.xv.w.h, com.bytedance.adsdk.lottie.xv.w.h> c4 = jVar.f().c();
        this.f25353k = c4;
        c4.f(this);
        aVar.l(c4);
        com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> c5 = jVar.g().c();
        this.f25354l = c5;
        c5.f(this);
        aVar.l(c5);
        com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c6 = jVar.d().c();
        this.f25355m = c6;
        c6.f(this);
        aVar.l(c6);
        com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c7 = jVar.e().c();
        this.f25356n = c7;
        c7.f(this);
        aVar.l(c7);
        if (aVar.q() != null) {
            com.bytedance.adsdk.lottie.c.w.c<Float, Float> c8 = aVar.q().a().c();
            this.f25361s = c8;
            c8.f(this);
            aVar.l(this.f25361s);
        }
        if (aVar.u() != null) {
            this.f25363u = new com.bytedance.adsdk.lottie.c.w.p(this, aVar, aVar.u());
        }
    }

    private int[] d(int[] iArr) {
        com.bytedance.adsdk.lottie.c.w.h hVar = this.f25358p;
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

    private int f() {
        int round = Math.round(this.f25355m.g() * this.f25360r);
        int round2 = Math.round(this.f25356n.g() * this.f25360r);
        int round3 = Math.round(this.f25353k.g() * this.f25360r);
        int i4 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i4 = i4 * 31 * round2;
        }
        return round3 != 0 ? i4 * 31 * round3 : i4;
    }

    private LinearGradient g() {
        long f4 = f();
        LinearGradient linearGradient = this.f25346d.get(f4);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF j4 = this.f25355m.j();
        PointF j5 = this.f25356n.j();
        com.bytedance.adsdk.lottie.xv.w.h j6 = this.f25353k.j();
        LinearGradient linearGradient2 = new LinearGradient(j4.x, j4.y, j5.x, j5.y, d(j6.e()), j6.d(), Shader.TileMode.CLAMP);
        this.f25346d.put(f4, linearGradient2);
        return linearGradient2;
    }

    private RadialGradient h() {
        long f4 = f();
        RadialGradient radialGradient = this.f25347e.get(f4);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF j4 = this.f25355m.j();
        PointF j5 = this.f25356n.j();
        com.bytedance.adsdk.lottie.xv.w.h j6 = this.f25353k.j();
        int[] d4 = d(j6.e());
        float[] d5 = j6.d();
        float f5 = j4.x;
        float f6 = j4.y;
        float hypot = (float) Math.hypot(j5.x - f5, j5.y - f6);
        RadialGradient radialGradient2 = new RadialGradient(f5, f6, hypot <= 0.0f ? 0.001f : hypot, d4, d5, Shader.TileMode.CLAMP);
        this.f25347e.put(f4, radialGradient2);
        return radialGradient2;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void a(Canvas canvas, Matrix matrix, int i4) {
        Shader h4;
        if (this.f25344b) {
            return;
        }
        com.bytedance.adsdk.lottie.s.b("GradientFillContent#draw");
        this.f25348f.reset();
        for (int i5 = 0; i5 < this.f25351i.size(); i5++) {
            this.f25348f.addPath(this.f25351i.get(i5).sr(), matrix);
        }
        this.f25348f.computeBounds(this.f25350h, false);
        if (this.f25352j == com.bytedance.adsdk.lottie.xv.w.r.LINEAR) {
            h4 = g();
        } else {
            h4 = h();
        }
        h4.setLocalMatrix(matrix);
        this.f25349g.setShader(h4);
        com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> cVar = this.f25357o;
        if (cVar != null) {
            this.f25349g.setColorFilter(cVar.j());
        }
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> cVar2 = this.f25361s;
        if (cVar2 != null) {
            float floatValue = cVar2.j().floatValue();
            if (floatValue == 0.0f) {
                this.f25349g.setMaskFilter(null);
            } else if (floatValue != this.f25362t) {
                this.f25349g.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.f25362t = floatValue;
        }
        com.bytedance.adsdk.lottie.c.w.p pVar = this.f25363u;
        if (pVar != null) {
            pVar.a(this.f25349g);
        }
        this.f25349g.setAlpha(com.bytedance.adsdk.lottie.f.d.e((int) ((((i4 / 255.0f) * this.f25354l.j().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f25348f, this.f25349g);
        com.bytedance.adsdk.lottie.s.d("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        this.f25348f.reset();
        for (int i4 = 0; i4 < this.f25351i.size(); i4++) {
            this.f25348f.addPath(this.f25351i.get(i4).sr(), matrix);
        }
        this.f25348f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        this.f25359q.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        for (int i4 = 0; i4 < list2.size(); i4++) {
            t tVar = list2.get(i4);
            if (tVar instanceof b) {
                this.f25351i.add((b) tVar);
            }
        }
    }
}
