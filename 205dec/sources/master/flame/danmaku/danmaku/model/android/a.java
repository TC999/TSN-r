package master.flame.danmaku.danmaku.model.android;

import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AndroidDisplayer.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a extends master.flame.danmaku.danmaku.model.b<Canvas, Typeface> {

    /* renamed from: j  reason: collision with root package name */
    public Canvas f61036j;

    /* renamed from: k  reason: collision with root package name */
    private int f61037k;

    /* renamed from: l  reason: collision with root package name */
    private int f61038l;

    /* renamed from: m  reason: collision with root package name */
    private float f61039m;

    /* renamed from: f  reason: collision with root package name */
    private Camera f61032f = new Camera();

    /* renamed from: g  reason: collision with root package name */
    private Matrix f61033g = new Matrix();

    /* renamed from: h  reason: collision with root package name */
    private final C1239a f61034h = new C1239a();

    /* renamed from: i  reason: collision with root package name */
    private b f61035i = new i();

    /* renamed from: n  reason: collision with root package name */
    private float f61040n = 1.0f;

    /* renamed from: o  reason: collision with root package name */
    private int f61041o = 160;

    /* renamed from: p  reason: collision with root package name */
    private float f61042p = 1.0f;

    /* renamed from: q  reason: collision with root package name */
    private int f61043q = 0;

    /* renamed from: r  reason: collision with root package name */
    private boolean f61044r = true;

    /* renamed from: s  reason: collision with root package name */
    private int f61045s = 2048;

    /* renamed from: t  reason: collision with root package name */
    private int f61046t = 2048;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: AndroidDisplayer.java */
    /* renamed from: master.flame.danmaku.danmaku.model.android.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class C1239a {
        public static final int B = 4;

        /* renamed from: a  reason: collision with root package name */
        private float f61047a;

        /* renamed from: c  reason: collision with root package name */
        public final TextPaint f61049c;

        /* renamed from: d  reason: collision with root package name */
        public final TextPaint f61050d;

        /* renamed from: e  reason: collision with root package name */
        private Paint f61051e;

        /* renamed from: f  reason: collision with root package name */
        private Paint f61052f;

        /* renamed from: g  reason: collision with root package name */
        private Paint f61053g;

        /* renamed from: v  reason: collision with root package name */
        private boolean f61068v;

        /* renamed from: b  reason: collision with root package name */
        private final Map<Float, Float> f61048b = new HashMap(10);

        /* renamed from: h  reason: collision with root package name */
        public int f61054h = 4;

        /* renamed from: i  reason: collision with root package name */
        private float f61055i = 4.0f;

        /* renamed from: j  reason: collision with root package name */
        private float f61056j = 3.5f;

        /* renamed from: k  reason: collision with root package name */
        public float f61057k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f61058l = 1.0f;

        /* renamed from: m  reason: collision with root package name */
        private int f61059m = 204;

        /* renamed from: n  reason: collision with root package name */
        public boolean f61060n = false;

        /* renamed from: o  reason: collision with root package name */
        private boolean f61061o = false;

        /* renamed from: p  reason: collision with root package name */
        public boolean f61062p = true;

        /* renamed from: q  reason: collision with root package name */
        private boolean f61063q = true;

        /* renamed from: r  reason: collision with root package name */
        public boolean f61064r = false;

        /* renamed from: s  reason: collision with root package name */
        public boolean f61065s = false;

        /* renamed from: t  reason: collision with root package name */
        public boolean f61066t = true;

        /* renamed from: u  reason: collision with root package name */
        private boolean f61067u = true;

        /* renamed from: w  reason: collision with root package name */
        private int f61069w = master.flame.danmaku.danmaku.model.c.f61143a;

        /* renamed from: x  reason: collision with root package name */
        private float f61070x = 1.0f;

        /* renamed from: y  reason: collision with root package name */
        private boolean f61071y = false;

        /* renamed from: z  reason: collision with root package name */
        private int f61072z = 0;
        private int A = 0;

        public C1239a() {
            TextPaint textPaint = new TextPaint();
            this.f61049c = textPaint;
            textPaint.setStrokeWidth(this.f61056j);
            this.f61050d = new TextPaint(textPaint);
            this.f61051e = new Paint();
            Paint paint = new Paint();
            this.f61052f = paint;
            paint.setStrokeWidth(this.f61054h);
            this.f61052f.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f61053g = paint2;
            paint2.setStyle(Paint.Style.STROKE);
            this.f61053g.setStrokeWidth(4.0f);
        }

        private void h(master.flame.danmaku.danmaku.model.d dVar, Paint paint) {
            if (this.f61071y) {
                Float f4 = this.f61048b.get(Float.valueOf(dVar.f61157l));
                if (f4 == null || this.f61047a != this.f61070x) {
                    float f5 = this.f61070x;
                    this.f61047a = f5;
                    f4 = Float.valueOf(dVar.f61157l * f5);
                    this.f61048b.put(Float.valueOf(dVar.f61157l), f4);
                }
                paint.setTextSize(f4.floatValue());
            }
        }

        public void g(master.flame.danmaku.danmaku.model.d dVar, Paint paint, boolean z3) {
            if (this.f61068v) {
                if (z3) {
                    paint.setStyle(this.f61065s ? Paint.Style.FILL : Paint.Style.STROKE);
                    paint.setColor(dVar.f61155j & 16777215);
                    paint.setAlpha(this.f61065s ? (int) (this.f61059m * (this.f61069w / master.flame.danmaku.danmaku.model.c.f61143a)) : this.f61069w);
                } else {
                    paint.setStyle(Paint.Style.FILL);
                    paint.setColor(dVar.f61152g & 16777215);
                    paint.setAlpha(this.f61069w);
                }
            } else if (z3) {
                paint.setStyle(this.f61065s ? Paint.Style.FILL : Paint.Style.STROKE);
                paint.setColor(dVar.f61155j & 16777215);
                paint.setAlpha(this.f61065s ? this.f61059m : master.flame.danmaku.danmaku.model.c.f61143a);
            } else {
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(dVar.f61152g & 16777215);
                paint.setAlpha(master.flame.danmaku.danmaku.model.c.f61143a);
            }
            if (dVar.getType() == 7) {
                paint.setAlpha(dVar.c());
            }
        }

        public void i() {
            this.f61048b.clear();
        }

        public void j(boolean z3) {
            this.f61063q = this.f61062p;
            this.f61061o = this.f61060n;
            this.f61065s = this.f61064r;
            this.f61067u = z3 && this.f61066t;
        }

        public Paint k(master.flame.danmaku.danmaku.model.d dVar) {
            this.f61053g.setColor(dVar.f61158m);
            return this.f61053g;
        }

        public TextPaint l(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
            TextPaint textPaint;
            int i4;
            if (z3) {
                textPaint = this.f61049c;
            } else {
                textPaint = this.f61050d;
                textPaint.set(this.f61049c);
            }
            textPaint.setTextSize(dVar.f61157l);
            h(dVar, textPaint);
            if (this.f61061o) {
                float f4 = this.f61055i;
                if (f4 > 0.0f && (i4 = dVar.f61155j) != 0) {
                    textPaint.setShadowLayer(f4, 0.0f, 0.0f, i4);
                    textPaint.setAntiAlias(this.f61067u);
                    return textPaint;
                }
            }
            textPaint.clearShadowLayer();
            textPaint.setAntiAlias(this.f61067u);
            return textPaint;
        }

        public float m() {
            boolean z3 = this.f61061o;
            if (z3 && this.f61063q) {
                return Math.max(this.f61055i, this.f61056j);
            }
            if (z3) {
                return this.f61055i;
            }
            if (this.f61063q) {
                return this.f61056j;
            }
            return 0.0f;
        }

        public Paint n(master.flame.danmaku.danmaku.model.d dVar) {
            this.f61052f.setColor(dVar.f61156k);
            return this.f61052f;
        }

        public boolean o(master.flame.danmaku.danmaku.model.d dVar) {
            return (this.f61063q || this.f61065s) && this.f61056j > 0.0f && dVar.f61155j != 0;
        }

        public void p(boolean z3) {
            this.f61049c.setFakeBoldText(z3);
        }

        public void q(float f4, float f5, int i4) {
            if (this.f61057k == f4 && this.f61058l == f5 && this.f61059m == i4) {
                return;
            }
            if (f4 <= 1.0f) {
                f4 = 1.0f;
            }
            this.f61057k = f4;
            if (f5 <= 1.0f) {
                f5 = 1.0f;
            }
            this.f61058l = f5;
            if (i4 < 0) {
                i4 = 0;
            } else if (i4 > 255) {
                i4 = 255;
            }
            this.f61059m = i4;
        }

        public void r(float f4) {
            this.f61071y = f4 != 1.0f;
            this.f61070x = f4;
        }

        public void s(float f4) {
            this.f61055i = f4;
        }

        public void t(float f4) {
            this.f61049c.setStrokeWidth(f4);
            this.f61056j = f4;
        }

        public void u(int i4) {
            this.f61068v = i4 != master.flame.danmaku.danmaku.model.c.f61143a;
            this.f61069w = i4;
        }

        public void v(Typeface typeface) {
            this.f61049c.setTypeface(typeface);
        }
    }

    private void E(master.flame.danmaku.danmaku.model.d dVar, TextPaint textPaint, boolean z3) {
        this.f61035i.e(dVar, textPaint, z3);
        N(dVar, dVar.f61161p, dVar.f61162q);
    }

    @SuppressLint({"NewApi"})
    private static final int H(Canvas canvas) {
        return canvas.getMaximumBitmapHeight();
    }

    @SuppressLint({"NewApi"})
    private static final int I(Canvas canvas) {
        return canvas.getMaximumBitmapWidth();
    }

    private synchronized TextPaint J(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        return this.f61034h.l(dVar, z3);
    }

    private void K(Paint paint) {
        int alpha = paint.getAlpha();
        int i4 = master.flame.danmaku.danmaku.model.c.f61143a;
        if (alpha != i4) {
            paint.setAlpha(i4);
        }
    }

    private void L(Canvas canvas) {
        canvas.restore();
    }

    private int M(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f4, float f5) {
        this.f61032f.save();
        float f6 = this.f61039m;
        if (f6 != 0.0f) {
            this.f61032f.setLocation(0.0f, 0.0f, f6);
        }
        this.f61032f.rotateY(-dVar.f61154i);
        this.f61032f.rotateZ(-dVar.f61153h);
        this.f61032f.getMatrix(this.f61033g);
        this.f61033g.preTranslate(-f4, -f5);
        this.f61033g.postTranslate(f4, f5);
        this.f61032f.restore();
        int save = canvas.save();
        canvas.concat(this.f61033g);
        return save;
    }

    private void N(master.flame.danmaku.danmaku.model.d dVar, float f4, float f5) {
        int i4 = dVar.f61159n;
        float f6 = f4 + (i4 * 2);
        float f7 = f5 + (i4 * 2);
        if (dVar.f61158m != 0) {
            float f8 = 8;
            f6 += f8;
            f7 += f8;
        }
        dVar.f61161p = f6 + t();
        dVar.f61162q = f7;
    }

    private void update(Canvas canvas) {
        this.f61036j = canvas;
        if (canvas != null) {
            this.f61037k = canvas.getWidth();
            this.f61038l = canvas.getHeight();
            if (this.f61044r) {
                this.f61045s = I(canvas);
                this.f61046t = H(canvas);
            }
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void A(boolean z3) {
        this.f61034h.p(z3);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void B(float f4) {
        this.f61034h.r(f4);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void C(int i4) {
        this.f61034h.u(i4);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: F */
    public synchronized void v(master.flame.danmaku.danmaku.model.d dVar, Canvas canvas, float f4, float f5, boolean z3) {
        b bVar = this.f61035i;
        if (bVar != null) {
            bVar.d(dVar, canvas, f4, f5, z3, this.f61034h);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: G */
    public Canvas x() {
        return this.f61036j;
    }

    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: O */
    public void z(Canvas canvas) {
        update(canvas);
    }

    public void P(float f4) {
        this.f61034h.t(f4);
    }

    public void Q(float f4, float f5, int i4) {
        this.f61034h.q(f4, f5, i4);
    }

    public void R(float f4) {
        this.f61034h.s(f4);
    }

    @Override // master.flame.danmaku.danmaku.model.b
    /* renamed from: S */
    public void D(Typeface typeface) {
        this.f61034h.v(typeface);
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void a(float f4) {
        float max = Math.max(f4, getWidth() / 682.0f) * 25.0f;
        this.f61043q = (int) max;
        if (f4 > 1.0f) {
            this.f61043q = (int) (max * f4);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int b() {
        return this.f61043q;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void c(int i4, float[] fArr) {
        if (i4 != -1) {
            if (i4 == 0) {
                C1239a c1239a = this.f61034h;
                c1239a.f61060n = false;
                c1239a.f61062p = false;
                c1239a.f61064r = false;
                return;
            } else if (i4 == 1) {
                C1239a c1239a2 = this.f61034h;
                c1239a2.f61060n = true;
                c1239a2.f61062p = false;
                c1239a2.f61064r = false;
                R(fArr[0]);
                return;
            } else if (i4 != 2) {
                if (i4 != 3) {
                    return;
                }
                C1239a c1239a3 = this.f61034h;
                c1239a3.f61060n = false;
                c1239a3.f61062p = false;
                c1239a3.f61064r = true;
                Q(fArr[0], fArr[1], (int) fArr[2]);
                return;
            }
        }
        C1239a c1239a4 = this.f61034h;
        c1239a4.f61060n = false;
        c1239a4.f61062p = true;
        c1239a4.f61064r = false;
        P(fArr[0]);
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void d(float f4, int i4, float f5) {
        this.f61040n = f4;
        this.f61041o = i4;
        this.f61042p = f5;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int e() {
        return this.f61041o;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public float f() {
        return this.f61042p;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int g() {
        return this.f61045s;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int getHeight() {
        return this.f61038l;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int getWidth() {
        return this.f61037k;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void h(int i4, int i5) {
        this.f61037k = i4;
        this.f61038l = i5;
        double d4 = i4 / 2.0f;
        double tan = Math.tan(0.4799655442984406d);
        Double.isNaN(d4);
        this.f61039m = (float) (d4 / tan);
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public float i() {
        return this.f61040n;
    }

    @Override // master.flame.danmaku.danmaku.model.b, master.flame.danmaku.danmaku.model.n
    public boolean isHardwareAccelerated() {
        return this.f61044r;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void j(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        TextPaint J = J(dVar, z3);
        if (this.f61034h.f61063q) {
            this.f61034h.g(dVar, J, true);
        }
        E(dVar, J, z3);
        if (this.f61034h.f61063q) {
            this.f61034h.g(dVar, J, false);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void k(int i4) {
        this.f61034h.f61072z = i4;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int l(master.flame.danmaku.danmaku.model.d dVar) {
        Paint paint;
        boolean z3;
        boolean z4;
        float l4 = dVar.l();
        float g4 = dVar.g();
        if (this.f61036j != null) {
            Paint paint2 = null;
            int i4 = 1;
            if (dVar.getType() != 7) {
                paint = null;
                z3 = false;
            } else if (dVar.c() == master.flame.danmaku.danmaku.model.c.f61144b) {
                return 0;
            } else {
                if (dVar.f61153h == 0.0f && dVar.f61154i == 0.0f) {
                    z4 = false;
                } else {
                    M(dVar, this.f61036j, g4, l4);
                    z4 = true;
                }
                if (dVar.c() != master.flame.danmaku.danmaku.model.c.f61143a) {
                    paint2 = this.f61034h.f61051e;
                    paint2.setAlpha(dVar.c());
                }
                paint = paint2;
                z3 = z4;
            }
            if (paint == null || paint.getAlpha() != master.flame.danmaku.danmaku.model.c.f61144b) {
                if (!this.f61035i.c(dVar, this.f61036j, g4, l4, paint, this.f61034h.f61049c)) {
                    if (paint != null) {
                        this.f61034h.f61049c.setAlpha(paint.getAlpha());
                        this.f61034h.f61050d.setAlpha(paint.getAlpha());
                    } else {
                        K(this.f61034h.f61049c);
                    }
                    v(dVar, this.f61036j, g4, l4, false);
                    i4 = 2;
                }
                if (z3) {
                    L(this.f61036j);
                }
                return i4;
            }
            return 0;
        }
        return 0;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void m(int i4) {
        this.f61034h.A = i4;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void n(master.flame.danmaku.danmaku.model.d dVar) {
        b bVar = this.f61035i;
        if (bVar != null) {
            bVar.g(dVar);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int o() {
        return this.f61034h.f61072z;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int p() {
        return this.f61046t;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void q(boolean z3) {
        this.f61044r = z3;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public int r() {
        return this.f61034h.A;
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public void s(master.flame.danmaku.danmaku.model.d dVar, boolean z3) {
        b bVar = this.f61035i;
        if (bVar != null) {
            bVar.f(dVar, z3);
        }
    }

    @Override // master.flame.danmaku.danmaku.model.n
    public float t() {
        return this.f61034h.m();
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void u() {
        this.f61035i.b();
        this.f61034h.i();
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public b w() {
        return this.f61035i;
    }

    @Override // master.flame.danmaku.danmaku.model.b
    public void y(b bVar) {
        if (bVar != this.f61035i) {
            this.f61035i = bVar;
        }
    }
}
