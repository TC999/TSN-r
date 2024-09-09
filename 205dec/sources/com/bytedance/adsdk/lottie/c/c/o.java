package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.c.w.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class o implements b, r, c.b {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f25422a;

    /* renamed from: b  reason: collision with root package name */
    private final RectF f25423b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f25424c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f25425d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f25426e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25427f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f25428g;

    /* renamed from: h  reason: collision with root package name */
    private final List<t> f25429h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25430i;

    /* renamed from: j  reason: collision with root package name */
    private List<b> f25431j;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.f f25432k;

    public o(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.e eVar, com.bytedance.adsdk.lottie.e eVar2) {
        this(dVar, aVar, eVar.b(), eVar.d(), f(dVar, eVar2, aVar, eVar.c()), d(eVar.c()));
    }

    static com.bytedance.adsdk.lottie.xv.c.a d(List<com.bytedance.adsdk.lottie.xv.w.l> list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            com.bytedance.adsdk.lottie.xv.w.l lVar = list.get(i4);
            if (lVar instanceof com.bytedance.adsdk.lottie.xv.c.a) {
                return (com.bytedance.adsdk.lottie.xv.c.a) lVar;
            }
        }
        return null;
    }

    private static List<t> f(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, List<com.bytedance.adsdk.lottie.xv.w.l> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            t a4 = list.get(i4).a(dVar, eVar, aVar);
            if (a4 != null) {
                arrayList.add(a4);
            }
        }
        return arrayList;
    }

    private boolean g() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.f25429h.size(); i5++) {
            if ((this.f25429h.get(i5) instanceof r) && (i4 = i4 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void a(Canvas canvas, Matrix matrix, int i4) {
        if (this.f25428g) {
            return;
        }
        this.f25424c.set(matrix);
        com.bytedance.adsdk.lottie.c.w.f fVar = this.f25432k;
        if (fVar != null) {
            this.f25424c.preConcat(fVar.e());
            i4 = (int) (((((this.f25432k.a() == null ? 100 : this.f25432k.a().j().intValue()) / 100.0f) * i4) / 255.0f) * 255.0f);
        }
        boolean z3 = this.f25430i.V() && g() && i4 != 255;
        if (z3) {
            this.f25423b.set(0.0f, 0.0f, 0.0f, 0.0f);
            b(this.f25423b, this.f25424c, true);
            this.f25422a.setAlpha(i4);
            com.bytedance.adsdk.lottie.f.b.g(canvas, this.f25423b, this.f25422a);
        }
        if (z3) {
            i4 = 255;
        }
        for (int size = this.f25429h.size() - 1; size >= 0; size--) {
            t tVar = this.f25429h.get(size);
            if (tVar instanceof r) {
                ((r) tVar).a(canvas, this.f25424c, i4);
            }
        }
        if (z3) {
            canvas.restore();
        }
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        this.f25424c.set(matrix);
        com.bytedance.adsdk.lottie.c.w.f fVar = this.f25432k;
        if (fVar != null) {
            this.f25424c.preConcat(fVar.e());
        }
        this.f25426e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f25429h.size() - 1; size >= 0; size--) {
            t tVar = this.f25429h.get(size);
            if (tVar instanceof r) {
                ((r) tVar).b(this.f25426e, this.f25424c, z3);
                rectF.union(this.f25426e);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        this.f25430i.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<b> h() {
        if (this.f25431j == null) {
            this.f25431j = new ArrayList();
            for (int i4 = 0; i4 < this.f25429h.size(); i4++) {
                t tVar = this.f25429h.get(i4);
                if (tVar instanceof b) {
                    this.f25431j.add((b) tVar);
                }
            }
        }
        return this.f25431j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix i() {
        com.bytedance.adsdk.lottie.c.w.f fVar = this.f25432k;
        if (fVar != null) {
            return fVar.e();
        }
        this.f25424c.reset();
        return this.f25424c;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.b
    public Path sr() {
        this.f25424c.reset();
        com.bytedance.adsdk.lottie.c.w.f fVar = this.f25432k;
        if (fVar != null) {
            this.f25424c.set(fVar.e());
        }
        this.f25425d.reset();
        if (this.f25428g) {
            return this.f25425d;
        }
        for (int size = this.f25429h.size() - 1; size >= 0; size--) {
            t tVar = this.f25429h.get(size);
            if (tVar instanceof b) {
                this.f25425d.addPath(((b) tVar).sr(), this.f25424c);
            }
        }
        return this.f25425d;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f25429h.size());
        arrayList.addAll(list);
        for (int size = this.f25429h.size() - 1; size >= 0; size--) {
            t tVar = this.f25429h.get(size);
            tVar.c(arrayList, this.f25429h.subList(0, size));
            arrayList.add(tVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v0, types: [android.graphics.Paint, h0.a] */
    public o(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, String str, boolean z3, List<t> list, com.bytedance.adsdk.lottie.xv.c.a aVar2) {
        this.f25422a = new h0.a();
        this.f25423b = new RectF();
        this.f25424c = new Matrix();
        this.f25425d = new Path();
        this.f25426e = new RectF();
        this.f25427f = str;
        this.f25430i = dVar;
        this.f25428g = z3;
        this.f25429h = list;
        if (aVar2 != null) {
            com.bytedance.adsdk.lottie.c.w.f f4 = aVar2.f();
            this.f25432k = f4;
            f4.d(aVar);
            this.f25432k.c(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            t tVar = list.get(size);
            if (tVar instanceof l) {
                arrayList.add((l) tVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((l) arrayList.get(size2)).d(list.listIterator(list.size()));
        }
    }
}
