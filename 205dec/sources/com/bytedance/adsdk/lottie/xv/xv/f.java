package com.bytedance.adsdk.lottie.xv.xv;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import com.bytedance.adsdk.lottie.s;
import com.bytedance.adsdk.lottie.xv.c.m;
import com.bytedance.adsdk.lottie.xv.xv.sr;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f extends com.bytedance.adsdk.lottie.xv.xv.a {
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> D;
    private final List<com.bytedance.adsdk.lottie.xv.xv.a> E;
    private final RectF F;
    private final RectF G;
    private final Paint H;
    private boolean I;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25949a;

        static {
            int[] iArr = new int[sr.w.values().length];
            f25949a = iArr;
            try {
                iArr[sr.w.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25949a[sr.w.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public f(com.bytedance.adsdk.lottie.d dVar, sr srVar, List<sr> list, com.bytedance.adsdk.lottie.e eVar) {
        super(dVar, srVar);
        int i4;
        com.bytedance.adsdk.lottie.xv.xv.a aVar;
        sr.w a4;
        int i5;
        this.E = new ArrayList();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new Paint();
        this.I = true;
        m j4 = srVar.j();
        if (j4 != null) {
            com.bytedance.adsdk.lottie.c.w.c<Float, Float> c4 = j4.c();
            this.D = c4;
            l(c4);
            this.D.f(this);
        } else {
            this.D = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(eVar.l().size());
        int size = list.size() - 1;
        com.bytedance.adsdk.lottie.xv.xv.a aVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            sr srVar2 = list.get(size);
            com.bytedance.adsdk.lottie.xv.xv.a d4 = com.bytedance.adsdk.lottie.xv.xv.a.d(this, srVar2, dVar, eVar);
            if (d4 != null) {
                longSparseArray.put(d4.A().v(), d4);
                if (aVar2 != null) {
                    aVar2.m(d4);
                    aVar2 = null;
                } else {
                    this.E.add(0, d4);
                    if (srVar2 != null && (a4 = srVar2.a()) != null && ((i5 = a.f25949a[a4.ordinal()]) == 1 || i5 == 2)) {
                        aVar2 = d4;
                    }
                }
            }
            size--;
        }
        for (i4 = 0; i4 < longSparseArray.size(); i4++) {
            com.bytedance.adsdk.lottie.xv.xv.a aVar3 = (com.bytedance.adsdk.lottie.xv.xv.a) longSparseArray.get(longSparseArray.keyAt(i4));
            if (aVar3 != null && (aVar = (com.bytedance.adsdk.lottie.xv.xv.a) longSparseArray.get(aVar3.A().b())) != null) {
                aVar3.E(aVar);
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a
    void B(Canvas canvas, Matrix matrix, int i4) {
        s.b("CompositionLayer#draw");
        this.G.set(0.0f, 0.0f, this.f25930q.e(), this.f25930q.i());
        matrix.mapRect(this.G);
        boolean z3 = this.f25929p.V() && this.E.size() > 1 && i4 != 255;
        if (z3) {
            this.H.setAlpha(i4);
            com.bytedance.adsdk.lottie.f.b.g(canvas, this.G, this.H);
        } else {
            canvas.save();
        }
        if (z3) {
            i4 = 255;
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            if (((!this.I && "__container".equals(this.f25930q.f())) || this.G.isEmpty()) ? true : canvas.clipRect(this.G)) {
                this.E.get(size).a(canvas, matrix, i4);
            }
        }
        canvas.restore();
        s.d("CompositionLayer#draw");
    }

    public void F(boolean z3) {
        this.I = z3;
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a, com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        super.b(rectF, matrix, z3);
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.F.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.E.get(size).b(this.F, this.f25928o, true);
            rectF.union(this.F);
        }
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a
    public void f(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        super.f(f4);
        if (this.D != null) {
            f4 = ((this.D.j().floatValue() * this.f25930q.c().j()) - this.f25930q.c().k()) / (this.f25929p.S().b() + 0.01f);
        }
        if (this.D == null) {
            f4 -= this.f25930q.x();
        }
        if (this.f25930q.w() != 0.0f && !"__container".equals(this.f25930q.f())) {
            f4 /= this.f25930q.w();
        }
        for (int size = this.E.size() - 1; size >= 0; size--) {
            this.E.get(size).f(f4);
        }
    }

    @Override // com.bytedance.adsdk.lottie.xv.xv.a
    public void o(boolean z3) {
        super.o(z3);
        for (com.bytedance.adsdk.lottie.xv.xv.a aVar : this.E) {
            aVar.o(z3);
        }
    }
}
