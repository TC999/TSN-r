package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.c.w.c;
import com.bytedance.adsdk.lottie.xv.w.fz;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class c implements k, r, c.b {

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25328e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.bytedance.adsdk.lottie.xv.xv.a f25329f;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f25331h;

    /* renamed from: i  reason: collision with root package name */
    final Paint f25332i;

    /* renamed from: j  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25333j;

    /* renamed from: k  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Integer> f25334k;

    /* renamed from: l  reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.c.w.c<?, Float>> f25335l;

    /* renamed from: m  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25336m;

    /* renamed from: n  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> f25337n;

    /* renamed from: o  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> f25338o;

    /* renamed from: p  reason: collision with root package name */
    float f25339p;

    /* renamed from: q  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.p f25340q;

    /* renamed from: a  reason: collision with root package name */
    private final PathMeasure f25324a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f25325b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f25326c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f25327d = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final List<b> f25330g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<com.bytedance.adsdk.lottie.c.c.b> f25341a;

        /* renamed from: b  reason: collision with root package name */
        private final i f25342b;

        private b(i iVar) {
            this.f25341a = new ArrayList();
            this.f25342b = iVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.Paint, h0.a] */
    public c(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, Paint.Cap cap, Paint.Join join, float f4, com.bytedance.adsdk.lottie.xv.c.j jVar, com.bytedance.adsdk.lottie.xv.c.m mVar, List<com.bytedance.adsdk.lottie.xv.c.m> list, com.bytedance.adsdk.lottie.xv.c.m mVar2) {
        ?? aVar2 = new h0.a(1);
        this.f25332i = aVar2;
        this.f25339p = 0.0f;
        this.f25328e = dVar;
        this.f25329f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f4);
        this.f25334k = jVar.c();
        this.f25333j = mVar.c();
        if (mVar2 == null) {
            this.f25336m = null;
        } else {
            this.f25336m = mVar2.c();
        }
        this.f25335l = new ArrayList(list.size());
        this.f25331h = new float[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            this.f25335l.add(list.get(i4).c());
        }
        aVar.l(this.f25334k);
        aVar.l(this.f25333j);
        for (int i5 = 0; i5 < this.f25335l.size(); i5++) {
            aVar.l(this.f25335l.get(i5));
        }
        com.bytedance.adsdk.lottie.c.w.c<?, Float> cVar = this.f25336m;
        if (cVar != null) {
            aVar.l(cVar);
        }
        this.f25334k.f(this);
        this.f25333j.f(this);
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.f25335l.get(i6).f(this);
        }
        com.bytedance.adsdk.lottie.c.w.c<?, Float> cVar2 = this.f25336m;
        if (cVar2 != null) {
            cVar2.f(this);
        }
        if (aVar.q() != null) {
            com.bytedance.adsdk.lottie.c.w.c<Float, Float> c4 = aVar.q().a().c();
            this.f25338o = c4;
            c4.f(this);
            aVar.l(this.f25338o);
        }
        if (aVar.u() != null) {
            this.f25340q = new com.bytedance.adsdk.lottie.c.w.p(this, aVar, aVar.u());
        }
    }

    private void d(Canvas canvas, b bVar, Matrix matrix) {
        com.bytedance.adsdk.lottie.s.b("StrokeContent#applyTrimPath");
        if (bVar.f25342b == null) {
            com.bytedance.adsdk.lottie.s.d("StrokeContent#applyTrimPath");
            return;
        }
        this.f25325b.reset();
        for (int size = bVar.f25341a.size() - 1; size >= 0; size--) {
            this.f25325b.addPath(((com.bytedance.adsdk.lottie.c.c.b) bVar.f25341a.get(size)).sr(), matrix);
        }
        float floatValue = bVar.f25342b.h().j().floatValue() / 100.0f;
        float floatValue2 = bVar.f25342b.i().j().floatValue() / 100.0f;
        float floatValue3 = bVar.f25342b.f().j().floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.f25325b, this.f25332i);
            com.bytedance.adsdk.lottie.s.d("StrokeContent#applyTrimPath");
            return;
        }
        this.f25324a.setPath(this.f25325b, false);
        float length = this.f25324a.getLength();
        while (this.f25324a.nextContour()) {
            length += this.f25324a.getLength();
        }
        float f4 = floatValue3 * length;
        float f5 = (floatValue * length) + f4;
        float min = Math.min((floatValue2 * length) + f4, (f5 + length) - 1.0f);
        float f6 = 0.0f;
        for (int size2 = bVar.f25341a.size() - 1; size2 >= 0; size2--) {
            this.f25326c.set(((com.bytedance.adsdk.lottie.c.c.b) bVar.f25341a.get(size2)).sr());
            this.f25326c.transform(matrix);
            this.f25324a.setPath(this.f25326c, false);
            float length2 = this.f25324a.getLength();
            if (min > length) {
                float f7 = min - length;
                if (f7 < f6 + length2 && f6 < f7) {
                    com.bytedance.adsdk.lottie.f.b.i(this.f25326c, f5 > length ? (f5 - length) / length2 : 0.0f, Math.min(f7 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f25326c, this.f25332i);
                    f6 += length2;
                }
            }
            float f8 = f6 + length2;
            if (f8 >= f5 && f6 <= min) {
                if (f8 <= min && f5 < f6) {
                    canvas.drawPath(this.f25326c, this.f25332i);
                } else {
                    com.bytedance.adsdk.lottie.f.b.i(this.f25326c, f5 < f6 ? 0.0f : (f5 - f6) / length2, min > f8 ? 1.0f : (min - f6) / length2, 0.0f);
                    canvas.drawPath(this.f25326c, this.f25332i);
                }
            }
            f6 += length2;
        }
        com.bytedance.adsdk.lottie.s.d("StrokeContent#applyTrimPath");
    }

    private void f(Matrix matrix) {
        com.bytedance.adsdk.lottie.s.b("StrokeContent#applyDashPattern");
        if (this.f25335l.isEmpty()) {
            com.bytedance.adsdk.lottie.s.d("StrokeContent#applyDashPattern");
            return;
        }
        float c4 = com.bytedance.adsdk.lottie.f.b.c(matrix);
        for (int i4 = 0; i4 < this.f25335l.size(); i4++) {
            this.f25331h[i4] = this.f25335l.get(i4).j().floatValue();
            if (i4 % 2 == 0) {
                float[] fArr = this.f25331h;
                if (fArr[i4] < 1.0f) {
                    fArr[i4] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f25331h;
                if (fArr2[i4] < 0.1f) {
                    fArr2[i4] = 0.1f;
                }
            }
            float[] fArr3 = this.f25331h;
            fArr3[i4] = fArr3[i4] * c4;
        }
        com.bytedance.adsdk.lottie.c.w.c<?, Float> cVar = this.f25336m;
        this.f25332i.setPathEffect(new DashPathEffect(this.f25331h, cVar == null ? 0.0f : c4 * cVar.j().floatValue()));
        com.bytedance.adsdk.lottie.s.d("StrokeContent#applyDashPattern");
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void a(Canvas canvas, Matrix matrix, int i4) {
        com.bytedance.adsdk.lottie.s.b("StrokeContent#draw");
        if (com.bytedance.adsdk.lottie.f.b.n(matrix)) {
            com.bytedance.adsdk.lottie.s.d("StrokeContent#draw");
            return;
        }
        this.f25332i.setAlpha(com.bytedance.adsdk.lottie.f.d.e((int) ((((i4 / 255.0f) * ((com.bytedance.adsdk.lottie.c.w.e) this.f25334k).o()) / 100.0f) * 255.0f), 0, 255));
        this.f25332i.setStrokeWidth(((com.bytedance.adsdk.lottie.c.w.l) this.f25333j).i() * com.bytedance.adsdk.lottie.f.b.c(matrix));
        if (this.f25332i.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.lottie.s.d("StrokeContent#draw");
            return;
        }
        f(matrix);
        com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> cVar = this.f25337n;
        if (cVar != null) {
            this.f25332i.setColorFilter(cVar.j());
        }
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> cVar2 = this.f25338o;
        if (cVar2 != null) {
            float floatValue = cVar2.j().floatValue();
            if (floatValue == 0.0f) {
                this.f25332i.setMaskFilter(null);
            } else if (floatValue != this.f25339p) {
                this.f25332i.setMaskFilter(this.f25329f.z(floatValue));
            }
            this.f25339p = floatValue;
        }
        com.bytedance.adsdk.lottie.c.w.p pVar = this.f25340q;
        if (pVar != null) {
            pVar.a(this.f25332i);
        }
        for (int i5 = 0; i5 < this.f25330g.size(); i5++) {
            b bVar = this.f25330g.get(i5);
            if (bVar.f25342b != null) {
                d(canvas, bVar, matrix);
            } else {
                com.bytedance.adsdk.lottie.s.b("StrokeContent#buildPath");
                this.f25325b.reset();
                for (int size = bVar.f25341a.size() - 1; size >= 0; size--) {
                    this.f25325b.addPath(((com.bytedance.adsdk.lottie.c.c.b) bVar.f25341a.get(size)).sr(), matrix);
                }
                com.bytedance.adsdk.lottie.s.d("StrokeContent#buildPath");
                com.bytedance.adsdk.lottie.s.b("StrokeContent#drawPath");
                canvas.drawPath(this.f25325b, this.f25332i);
                com.bytedance.adsdk.lottie.s.d("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.lottie.s.d("StrokeContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        com.bytedance.adsdk.lottie.s.b("StrokeContent#getBounds");
        this.f25325b.reset();
        for (int i4 = 0; i4 < this.f25330g.size(); i4++) {
            b bVar = this.f25330g.get(i4);
            for (int i5 = 0; i5 < bVar.f25341a.size(); i5++) {
                this.f25325b.addPath(((com.bytedance.adsdk.lottie.c.c.b) bVar.f25341a.get(i5)).sr(), matrix);
            }
        }
        this.f25325b.computeBounds(this.f25327d, false);
        float i6 = ((com.bytedance.adsdk.lottie.c.w.l) this.f25333j).i();
        RectF rectF2 = this.f25327d;
        float f4 = i6 / 2.0f;
        rectF2.set(rectF2.left - f4, rectF2.top - f4, rectF2.right + f4, rectF2.bottom + f4);
        rectF.set(this.f25327d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.lottie.s.d("StrokeContent#getBounds");
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        this.f25328e.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        i iVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            t tVar = list.get(size);
            if (tVar instanceof i) {
                i iVar2 = (i) tVar;
                if (iVar2.getType() == fz.c.INDIVIDUALLY) {
                    iVar = iVar2;
                }
            }
        }
        if (iVar != null) {
            iVar.d(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            t tVar2 = list2.get(size2);
            if (tVar2 instanceof i) {
                i iVar3 = (i) tVar2;
                if (iVar3.getType() == fz.c.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f25330g.add(bVar);
                    }
                    bVar = new b(iVar3);
                    iVar3.d(this);
                }
            }
            if (tVar2 instanceof com.bytedance.adsdk.lottie.c.c.b) {
                if (bVar == null) {
                    bVar = new b(iVar);
                }
                bVar.f25341a.add((com.bytedance.adsdk.lottie.c.c.b) tVar2);
            }
        }
        if (bVar != null) {
            this.f25330g.add(bVar);
        }
    }
}
