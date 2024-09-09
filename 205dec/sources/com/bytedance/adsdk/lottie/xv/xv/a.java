package com.bytedance.adsdk.lottie.xv.xv;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.bytedance.adsdk.lottie.c.c.r;
import com.bytedance.adsdk.lottie.c.c.t;
import com.bytedance.adsdk.lottie.c.w.c;
import com.bytedance.adsdk.lottie.c.w.l;
import com.bytedance.adsdk.lottie.s;
import com.bytedance.adsdk.lottie.xv.w.ev;
import com.bytedance.adsdk.lottie.xv.w.i;
import com.bytedance.adsdk.lottie.xv.xv.sr;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class a implements r, c.b {
    private Paint A;
    float B;
    BlurMaskFilter C;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25914a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f25915b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f25916c = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    private final Paint f25917d = new h0.a(1);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f25918e = new h0.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: f  reason: collision with root package name */
    private final Paint f25919f = new h0.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: g  reason: collision with root package name */
    private final Paint f25920g;

    /* renamed from: h  reason: collision with root package name */
    private final Paint f25921h;

    /* renamed from: i  reason: collision with root package name */
    private final RectF f25922i;

    /* renamed from: j  reason: collision with root package name */
    private final RectF f25923j;

    /* renamed from: k  reason: collision with root package name */
    private final RectF f25924k;

    /* renamed from: l  reason: collision with root package name */
    private final RectF f25925l;

    /* renamed from: m  reason: collision with root package name */
    private final RectF f25926m;

    /* renamed from: n  reason: collision with root package name */
    private final String f25927n;

    /* renamed from: o  reason: collision with root package name */
    final Matrix f25928o;

    /* renamed from: p  reason: collision with root package name */
    final com.bytedance.adsdk.lottie.d f25929p;

    /* renamed from: q  reason: collision with root package name */
    final sr f25930q;

    /* renamed from: r  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.d f25931r;

    /* renamed from: s  reason: collision with root package name */
    private l f25932s;

    /* renamed from: t  reason: collision with root package name */
    private a f25933t;

    /* renamed from: u  reason: collision with root package name */
    private a f25934u;

    /* renamed from: v  reason: collision with root package name */
    private List<a> f25935v;

    /* renamed from: w  reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.c.w.c<?, ?>> f25936w;

    /* renamed from: x  reason: collision with root package name */
    final com.bytedance.adsdk.lottie.c.w.f f25937x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f25938y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f25939z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.adsdk.lottie.xv.xv.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class C0354a implements c.b {
        C0354a() {
        }

        @Override // com.bytedance.adsdk.lottie.c.w.c.b
        public void c() {
            a aVar = a.this;
            aVar.F(aVar.f25932s.i() == 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25941a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f25942b;

        static {
            int[] iArr = new int[ev.c.values().length];
            f25942b = iArr;
            try {
                iArr[ev.c.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25942b[ev.c.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25942b[ev.c.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25942b[ev.c.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[sr.c.values().length];
            f25941a = iArr2;
            try {
                iArr2[sr.c.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25941a[sr.c.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25941a[sr.c.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25941a[sr.c.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25941a[sr.c.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25941a[sr.c.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25941a[sr.c.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.graphics.Paint, h0.a] */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.graphics.Paint, h0.a] */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.graphics.Paint, h0.a] */
    /* JADX WARN: Type inference failed for: r0v6, types: [android.graphics.Paint, h0.a] */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.graphics.Paint, h0.a] */
    public a(com.bytedance.adsdk.lottie.d dVar, sr srVar) {
        ?? aVar = new h0.a(1);
        this.f25920g = aVar;
        this.f25921h = new h0.a(PorterDuff.Mode.CLEAR);
        this.f25922i = new RectF();
        this.f25923j = new RectF();
        this.f25924k = new RectF();
        this.f25925l = new RectF();
        this.f25926m = new RectF();
        this.f25928o = new Matrix();
        this.f25936w = new ArrayList();
        this.f25938y = true;
        this.B = 0.0f;
        this.f25929p = dVar;
        this.f25930q = srVar;
        this.f25927n = srVar.f() + "#draw";
        if (srVar.a() == sr.w.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        com.bytedance.adsdk.lottie.c.w.f f4 = srVar.y().f();
        this.f25937x = f4;
        f4.c(this);
        if (srVar.o() != null && !srVar.o().isEmpty()) {
            com.bytedance.adsdk.lottie.c.w.d dVar2 = new com.bytedance.adsdk.lottie.c.w.d(srVar.o());
            this.f25931r = dVar2;
            for (com.bytedance.adsdk.lottie.c.w.c<i, Path> cVar : dVar2.b()) {
                cVar.f(this);
            }
            for (com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar2 : this.f25931r.c()) {
                l(cVar2);
                cVar2.f(this);
            }
        }
        p();
    }

    private void C(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.c.w.c<i, Path> cVar, com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar2) {
        com.bytedance.adsdk.lottie.f.b.g(canvas, this.f25922i, this.f25917d);
        canvas.drawRect(this.f25922i, this.f25917d);
        this.f25914a.set(cVar.j());
        this.f25914a.transform(matrix);
        this.f25917d.setAlpha((int) (cVar2.j().intValue() * 2.55f));
        canvas.drawPath(this.f25914a, this.f25919f);
        canvas.restore();
    }

    private void D(RectF rectF, Matrix matrix) {
        if (J() && this.f25930q.a() != sr.w.INVERT) {
            this.f25925l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f25933t.b(this.f25925l, matrix, true);
            if (rectF.intersect(this.f25925l)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(boolean z3) {
        if (z3 != this.f25938y) {
            this.f25938y = z3;
            r();
        }
    }

    private void H(float f4) {
        this.f25929p.S().u().a(this.f25930q.f(), f4);
    }

    private void I(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.c.w.c<i, Path> cVar, com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar2) {
        com.bytedance.adsdk.lottie.f.b.g(canvas, this.f25922i, this.f25919f);
        canvas.drawRect(this.f25922i, this.f25917d);
        this.f25919f.setAlpha((int) (cVar2.j().intValue() * 2.55f));
        this.f25914a.set(cVar.j());
        this.f25914a.transform(matrix);
        canvas.drawPath(this.f25914a, this.f25919f);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d(f fVar, sr srVar, com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar) {
        switch (b.f25941a[srVar.m().ordinal()]) {
            case 1:
                return new c(dVar, srVar, fVar, eVar);
            case 2:
                return new f(dVar, srVar, eVar.s(srVar.q()), eVar);
            case 3:
                return new d(dVar, srVar);
            case 4:
                return new g(dVar, srVar);
            case 5:
                return new e(dVar, srVar);
            case 6:
                return new com.bytedance.adsdk.lottie.xv.xv.b(dVar, srVar);
            default:
                com.bytedance.adsdk.lottie.f.e.c("Unknown layer type " + srVar.m());
                return null;
        }
    }

    private void g(Canvas canvas) {
        s.b("Layer#clearLayer");
        RectF rectF = this.f25922i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f25921h);
        s.d("Layer#clearLayer");
    }

    private void h(Canvas canvas, Matrix matrix) {
        s.b("Layer#saveLayer");
        com.bytedance.adsdk.lottie.f.b.h(canvas, this.f25922i, this.f25918e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            g(canvas);
        }
        s.d("Layer#saveLayer");
        for (int i4 = 0; i4 < this.f25931r.a().size(); i4++) {
            ev evVar = this.f25931r.a().get(i4);
            com.bytedance.adsdk.lottie.c.w.c<i, Path> cVar = this.f25931r.b().get(i4);
            com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar2 = this.f25931r.c().get(i4);
            int i5 = b.f25942b[evVar.a().ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    if (i4 == 0) {
                        this.f25917d.setColor(-16777216);
                        this.f25917d.setAlpha(255);
                        canvas.drawRect(this.f25922i, this.f25917d);
                    }
                    if (evVar.b()) {
                        I(canvas, matrix, cVar, cVar2);
                    } else {
                        i(canvas, matrix, cVar);
                    }
                } else if (i5 != 3) {
                    if (i5 == 4) {
                        if (evVar.b()) {
                            C(canvas, matrix, cVar, cVar2);
                        } else {
                            j(canvas, matrix, cVar, cVar2);
                        }
                    }
                } else if (evVar.b()) {
                    y(canvas, matrix, cVar, cVar2);
                } else {
                    v(canvas, matrix, cVar, cVar2);
                }
            } else if (t()) {
                this.f25917d.setAlpha(255);
                canvas.drawRect(this.f25922i, this.f25917d);
            }
        }
        s.b("Layer#restoreLayer");
        canvas.restore();
        s.d("Layer#restoreLayer");
    }

    private void i(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.c.w.c<i, Path> cVar) {
        this.f25914a.set(cVar.j());
        this.f25914a.transform(matrix);
        canvas.drawPath(this.f25914a, this.f25919f);
    }

    private void j(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.c.w.c<i, Path> cVar, com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar2) {
        this.f25914a.set(cVar.j());
        this.f25914a.transform(matrix);
        this.f25917d.setAlpha((int) (cVar2.j().intValue() * 2.55f));
        canvas.drawPath(this.f25914a, this.f25917d);
    }

    private void k(RectF rectF, Matrix matrix) {
        this.f25924k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (w()) {
            int size = this.f25931r.a().size();
            for (int i4 = 0; i4 < size; i4++) {
                ev evVar = this.f25931r.a().get(i4);
                Path j4 = this.f25931r.b().get(i4).j();
                if (j4 != null) {
                    this.f25914a.set(j4);
                    this.f25914a.transform(matrix);
                    int i5 = b.f25942b[evVar.a().ordinal()];
                    if (i5 == 1 || i5 == 2) {
                        return;
                    }
                    if ((i5 == 3 || i5 == 4) && evVar.b()) {
                        return;
                    }
                    this.f25914a.computeBounds(this.f25926m, false);
                    if (i4 == 0) {
                        this.f25924k.set(this.f25926m);
                    } else {
                        RectF rectF2 = this.f25924k;
                        rectF2.set(Math.min(rectF2.left, this.f25926m.left), Math.min(this.f25924k.top, this.f25926m.top), Math.max(this.f25924k.right, this.f25926m.right), Math.max(this.f25924k.bottom, this.f25926m.bottom));
                    }
                }
            }
            if (rectF.intersect(this.f25924k)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void p() {
        if (!this.f25930q.s().isEmpty()) {
            l lVar = new l(this.f25930q.s());
            this.f25932s = lVar;
            lVar.d();
            this.f25932s.f(new C0354a());
            F(this.f25932s.j().floatValue() == 1.0f);
            l(this.f25932s);
            return;
        }
        F(true);
    }

    private void r() {
        this.f25929p.invalidateSelf();
    }

    private void s() {
        if (this.f25935v != null) {
            return;
        }
        if (this.f25934u == null) {
            this.f25935v = Collections.emptyList();
            return;
        }
        this.f25935v = new ArrayList();
        for (a aVar = this.f25934u; aVar != null; aVar = aVar.f25934u) {
            this.f25935v.add(aVar);
        }
    }

    private boolean t() {
        if (this.f25931r.b().isEmpty()) {
            return false;
        }
        for (int i4 = 0; i4 < this.f25931r.a().size(); i4++) {
            if (this.f25931r.a().get(i4).a() != ev.c.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void v(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.c.w.c<i, Path> cVar, com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar2) {
        com.bytedance.adsdk.lottie.f.b.g(canvas, this.f25922i, this.f25918e);
        this.f25914a.set(cVar.j());
        this.f25914a.transform(matrix);
        this.f25917d.setAlpha((int) (cVar2.j().intValue() * 2.55f));
        canvas.drawPath(this.f25914a, this.f25917d);
        canvas.restore();
    }

    private void y(Canvas canvas, Matrix matrix, com.bytedance.adsdk.lottie.c.w.c<i, Path> cVar, com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> cVar2) {
        com.bytedance.adsdk.lottie.f.b.g(canvas, this.f25922i, this.f25918e);
        canvas.drawRect(this.f25922i, this.f25917d);
        this.f25919f.setAlpha((int) (cVar2.j().intValue() * 2.55f));
        this.f25914a.set(cVar.j());
        this.f25914a.transform(matrix);
        canvas.drawPath(this.f25914a, this.f25919f);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public sr A() {
        return this.f25930q;
    }

    abstract void B(Canvas canvas, Matrix matrix, int i4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(a aVar) {
        this.f25934u = aVar;
    }

    boolean J() {
        return this.f25933t != null;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void a(Canvas canvas, Matrix matrix, int i4) {
        Paint paint;
        Integer j4;
        s.b(this.f25927n);
        if (this.f25938y && !this.f25930q.p()) {
            s();
            s.b("Layer#parentMatrix");
            this.f25915b.reset();
            this.f25915b.set(matrix);
            for (int size = this.f25935v.size() - 1; size >= 0; size--) {
                this.f25915b.preConcat(this.f25935v.get(size).f25937x.e());
            }
            s.d("Layer#parentMatrix");
            int i5 = 100;
            com.bytedance.adsdk.lottie.c.w.c<?, Integer> a4 = this.f25937x.a();
            if (a4 != null && (j4 = a4.j()) != null) {
                i5 = j4.intValue();
            }
            int i6 = (int) ((((i4 / 255.0f) * i5) / 100.0f) * 255.0f);
            if (!J() && !w()) {
                this.f25915b.preConcat(this.f25937x.e());
                s.b("Layer#drawLayer");
                B(canvas, this.f25915b, i6);
                s.d("Layer#drawLayer");
                H(s.d(this.f25927n));
                return;
            }
            s.b("Layer#computeBounds");
            b(this.f25922i, this.f25915b, false);
            D(this.f25922i, matrix);
            this.f25915b.preConcat(this.f25937x.e());
            k(this.f25922i, this.f25915b);
            this.f25923j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
            canvas.getMatrix(this.f25916c);
            if (!this.f25916c.isIdentity()) {
                Matrix matrix2 = this.f25916c;
                matrix2.invert(matrix2);
                this.f25916c.mapRect(this.f25923j);
            }
            if (!this.f25922i.intersect(this.f25923j)) {
                this.f25922i.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            s.d("Layer#computeBounds");
            if (this.f25922i.width() >= 1.0f && this.f25922i.height() >= 1.0f) {
                s.b("Layer#saveLayer");
                this.f25917d.setAlpha(255);
                com.bytedance.adsdk.lottie.f.b.g(canvas, this.f25922i, this.f25917d);
                s.d("Layer#saveLayer");
                g(canvas);
                s.b("Layer#drawLayer");
                B(canvas, this.f25915b, i6);
                s.d("Layer#drawLayer");
                if (w()) {
                    h(canvas, this.f25915b);
                }
                if (J()) {
                    s.b("Layer#drawMatte");
                    s.b("Layer#saveLayer");
                    com.bytedance.adsdk.lottie.f.b.h(canvas, this.f25922i, this.f25920g, 19);
                    s.d("Layer#saveLayer");
                    g(canvas);
                    this.f25933t.a(canvas, matrix, i6);
                    s.b("Layer#restoreLayer");
                    canvas.restore();
                    s.d("Layer#restoreLayer");
                    s.d("Layer#drawMatte");
                }
                s.b("Layer#restoreLayer");
                canvas.restore();
                s.d("Layer#restoreLayer");
            }
            if (this.f25939z && (paint = this.A) != null) {
                paint.setStyle(Paint.Style.STROKE);
                this.A.setColor(-251901);
                this.A.setStrokeWidth(4.0f);
                canvas.drawRect(this.f25922i, this.A);
                this.A.setStyle(Paint.Style.FILL);
                this.A.setColor(1357638635);
                canvas.drawRect(this.f25922i, this.A);
            }
            H(s.d(this.f25927n));
            return;
        }
        s.d(this.f25927n);
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        this.f25922i.set(0.0f, 0.0f, 0.0f, 0.0f);
        s();
        this.f25928o.set(matrix);
        if (z3) {
            List<a> list = this.f25935v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f25928o.preConcat(this.f25935v.get(size).f25937x.e());
                }
            } else {
                a aVar = this.f25934u;
                if (aVar != null) {
                    this.f25928o.preConcat(aVar.f25937x.e());
                }
            }
        }
        this.f25928o.preConcat(this.f25937x.e());
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        r();
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        this.f25937x.b(f4);
        if (this.f25931r != null) {
            for (int i4 = 0; i4 < this.f25931r.b().size(); i4++) {
                this.f25931r.b().get(i4).e(f4);
            }
        }
        l lVar = this.f25932s;
        if (lVar != null) {
            lVar.e(f4);
        }
        a aVar = this.f25933t;
        if (aVar != null) {
            aVar.f(f4);
        }
        for (int i5 = 0; i5 < this.f25936w.size(); i5++) {
            this.f25936w.get(i5).e(f4);
        }
    }

    public void l(com.bytedance.adsdk.lottie.c.w.c<?, ?> cVar) {
        if (cVar == null) {
            return;
        }
        this.f25936w.add(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a aVar) {
        this.f25933t = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.graphics.Paint, h0.a] */
    public void o(boolean z3) {
        if (z3 && this.A == null) {
            this.A = new h0.a();
        }
        this.f25939z = z3;
    }

    public com.bytedance.adsdk.lottie.xv.w.c q() {
        return this.f25930q.l();
    }

    public s.w u() {
        return this.f25930q.n();
    }

    boolean w() {
        com.bytedance.adsdk.lottie.c.w.d dVar = this.f25931r;
        return (dVar == null || dVar.b().isEmpty()) ? false : true;
    }

    public String x() {
        return this.f25930q.f();
    }

    public BlurMaskFilter z(float f4) {
        if (this.B == f4) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f4 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f4;
        return blurMaskFilter;
    }
}
