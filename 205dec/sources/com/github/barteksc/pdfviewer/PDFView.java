package com.github.barteksc.pdfviewer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.RelativeLayout;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.SnapEdge;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import e1.i;
import e1.j;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class PDFView extends RelativeLayout {
    private static final String R = PDFView.class.getSimpleName();
    public static final float S = 3.0f;
    public static final float T = 1.75f;
    public static final float U = 1.0f;
    private boolean A;
    private boolean B;
    private boolean C;
    private PdfiumCore D;
    private com.github.barteksc.pdfviewer.scroll.a E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private PaintFlagsDrawFilter K;

    /* renamed from: L  reason: collision with root package name */
    private int f37132L;
    private boolean M;
    private boolean N;
    private List<Integer> O;
    private boolean P;
    private b Q;

    /* renamed from: a  reason: collision with root package name */
    private float f37133a;

    /* renamed from: b  reason: collision with root package name */
    private float f37134b;

    /* renamed from: c  reason: collision with root package name */
    private float f37135c;

    /* renamed from: d  reason: collision with root package name */
    private c f37136d;

    /* renamed from: e  reason: collision with root package name */
    com.github.barteksc.pdfviewer.c f37137e;

    /* renamed from: f  reason: collision with root package name */
    private com.github.barteksc.pdfviewer.a f37138f;

    /* renamed from: g  reason: collision with root package name */
    private e f37139g;

    /* renamed from: h  reason: collision with root package name */
    g f37140h;

    /* renamed from: i  reason: collision with root package name */
    private int f37141i;

    /* renamed from: j  reason: collision with root package name */
    private float f37142j;

    /* renamed from: k  reason: collision with root package name */
    private float f37143k;

    /* renamed from: l  reason: collision with root package name */
    private float f37144l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f37145m;

    /* renamed from: n  reason: collision with root package name */
    private d f37146n;

    /* renamed from: o  reason: collision with root package name */
    private com.github.barteksc.pdfviewer.d f37147o;

    /* renamed from: p  reason: collision with root package name */
    private HandlerThread f37148p;

    /* renamed from: q  reason: collision with root package name */
    h f37149q;

    /* renamed from: r  reason: collision with root package name */
    private f f37150r;

    /* renamed from: s  reason: collision with root package name */
    e1.a f37151s;

    /* renamed from: t  reason: collision with root package name */
    private Paint f37152t;

    /* renamed from: u  reason: collision with root package name */
    private Paint f37153u;

    /* renamed from: v  reason: collision with root package name */
    private FitPolicy f37154v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f37155w;

    /* renamed from: x  reason: collision with root package name */
    private int f37156x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f37157y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f37158z;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class b {
        private boolean A;
        private boolean B;

        /* renamed from: a  reason: collision with root package name */
        private final g1.c f37159a;

        /* renamed from: b  reason: collision with root package name */
        private int[] f37160b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f37161c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f37162d;

        /* renamed from: e  reason: collision with root package name */
        private e1.b f37163e;

        /* renamed from: f  reason: collision with root package name */
        private e1.b f37164f;

        /* renamed from: g  reason: collision with root package name */
        private e1.d f37165g;

        /* renamed from: h  reason: collision with root package name */
        private e1.c f37166h;

        /* renamed from: i  reason: collision with root package name */
        private e1.f f37167i;

        /* renamed from: j  reason: collision with root package name */
        private e1.h f37168j;

        /* renamed from: k  reason: collision with root package name */
        private i f37169k;

        /* renamed from: l  reason: collision with root package name */
        private j f37170l;

        /* renamed from: m  reason: collision with root package name */
        private e1.e f37171m;

        /* renamed from: n  reason: collision with root package name */
        private e1.g f37172n;

        /* renamed from: o  reason: collision with root package name */
        private d1.b f37173o;

        /* renamed from: p  reason: collision with root package name */
        private int f37174p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f37175q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f37176r;

        /* renamed from: s  reason: collision with root package name */
        private String f37177s;

        /* renamed from: t  reason: collision with root package name */
        private com.github.barteksc.pdfviewer.scroll.a f37178t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f37179u;

        /* renamed from: v  reason: collision with root package name */
        private int f37180v;

        /* renamed from: w  reason: collision with root package name */
        private boolean f37181w;

        /* renamed from: x  reason: collision with root package name */
        private FitPolicy f37182x;

        /* renamed from: y  reason: collision with root package name */
        private boolean f37183y;

        /* renamed from: z  reason: collision with root package name */
        private boolean f37184z;

        public b A(com.github.barteksc.pdfviewer.scroll.a aVar) {
            this.f37178t = aVar;
            return this;
        }

        public b B(int i4) {
            this.f37180v = i4;
            return this;
        }

        public b C(boolean z3) {
            this.f37175q = z3;
            return this;
        }

        public b a(boolean z3) {
            this.f37181w = z3;
            return this;
        }

        public b b(int i4) {
            this.f37174p = i4;
            return this;
        }

        public b c() {
            PDFView.this.f37139g.d();
            return this;
        }

        public b d(boolean z3) {
            this.f37176r = z3;
            return this;
        }

        public b e(boolean z3) {
            this.f37179u = z3;
            return this;
        }

        public b f(boolean z3) {
            this.f37162d = z3;
            return this;
        }

        public b g(boolean z3) {
            this.f37161c = z3;
            return this;
        }

        public b h(boolean z3) {
            this.f37183y = z3;
            return this;
        }

        public b i(d1.b bVar) {
            this.f37173o = bVar;
            return this;
        }

        public void j() {
            if (!PDFView.this.P) {
                PDFView.this.Q = this;
                return;
            }
            PDFView.this.h0();
            PDFView.this.f37151s.p(this.f37165g);
            PDFView.this.f37151s.o(this.f37166h);
            PDFView.this.f37151s.m(this.f37163e);
            PDFView.this.f37151s.n(this.f37164f);
            PDFView.this.f37151s.r(this.f37167i);
            PDFView.this.f37151s.t(this.f37168j);
            PDFView.this.f37151s.u(this.f37169k);
            PDFView.this.f37151s.v(this.f37170l);
            PDFView.this.f37151s.q(this.f37171m);
            PDFView.this.f37151s.s(this.f37172n);
            PDFView.this.f37151s.l(this.f37173o);
            PDFView.this.setSwipeEnabled(this.f37161c);
            PDFView.this.setNightMode(this.B);
            PDFView.this.s(this.f37162d);
            PDFView.this.setDefaultPage(this.f37174p);
            PDFView.this.setSwipeVertical(!this.f37175q);
            PDFView.this.q(this.f37176r);
            PDFView.this.setScrollHandle(this.f37178t);
            PDFView.this.r(this.f37179u);
            PDFView.this.setSpacing(this.f37180v);
            PDFView.this.setAutoSpacing(this.f37181w);
            PDFView.this.setPageFitPolicy(this.f37182x);
            PDFView.this.setFitEachPage(this.f37183y);
            PDFView.this.setPageSnap(this.A);
            PDFView.this.setPageFling(this.f37184z);
            int[] iArr = this.f37160b;
            if (iArr != null) {
                PDFView.this.V(this.f37159a, this.f37177s, iArr);
            } else {
                PDFView.this.U(this.f37159a, this.f37177s);
            }
        }

        public b k(boolean z3) {
            this.B = z3;
            return this;
        }

        public b l(e1.b bVar) {
            this.f37163e = bVar;
            return this;
        }

        public b m(e1.b bVar) {
            this.f37164f = bVar;
            return this;
        }

        public b n(e1.c cVar) {
            this.f37166h = cVar;
            return this;
        }

        public b o(e1.d dVar) {
            this.f37165g = dVar;
            return this;
        }

        public b p(e1.e eVar) {
            this.f37171m = eVar;
            return this;
        }

        public b q(e1.f fVar) {
            this.f37167i = fVar;
            return this;
        }

        public b r(e1.g gVar) {
            this.f37172n = gVar;
            return this;
        }

        public b s(e1.h hVar) {
            this.f37168j = hVar;
            return this;
        }

        public b t(i iVar) {
            this.f37169k = iVar;
            return this;
        }

        public b u(j jVar) {
            this.f37170l = jVar;
            return this;
        }

        public b v(FitPolicy fitPolicy) {
            this.f37182x = fitPolicy;
            return this;
        }

        public b w(boolean z3) {
            this.f37184z = z3;
            return this;
        }

        public b x(boolean z3) {
            this.A = z3;
            return this;
        }

        public b y(int... iArr) {
            this.f37160b = iArr;
            return this;
        }

        public b z(String str) {
            this.f37177s = str;
            return this;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [d1.a, d1.b] */
        private b(g1.c cVar) {
            this.f37160b = null;
            this.f37161c = true;
            this.f37162d = true;
            this.f37173o = new d1.a(PDFView.this);
            this.f37174p = 0;
            this.f37175q = false;
            this.f37176r = false;
            this.f37177s = null;
            this.f37178t = null;
            this.f37179u = true;
            this.f37180v = 0;
            this.f37181w = false;
            this.f37182x = FitPolicy.WIDTH;
            this.f37183y = false;
            this.f37184z = false;
            this.A = false;
            this.B = false;
            this.f37159a = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum c {
        NONE,
        START,
        END
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public enum d {
        DEFAULT,
        LOADED,
        SHOWN,
        ERROR
    }

    public PDFView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f37133a = 1.0f;
        this.f37134b = 1.75f;
        this.f37135c = 3.0f;
        this.f37136d = c.NONE;
        this.f37142j = 0.0f;
        this.f37143k = 0.0f;
        this.f37144l = 1.0f;
        this.f37145m = true;
        this.f37146n = d.DEFAULT;
        this.f37151s = new e1.a();
        this.f37154v = FitPolicy.WIDTH;
        this.f37155w = false;
        this.f37156x = 0;
        this.f37157y = true;
        this.f37158z = true;
        this.A = true;
        this.B = false;
        this.C = true;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.J = true;
        this.K = new PaintFlagsDrawFilter(0, 3);
        this.f37132L = 0;
        this.M = false;
        this.N = true;
        this.O = new ArrayList(10);
        this.P = false;
        this.f37148p = new HandlerThread("PDF renderer");
        if (isInEditMode()) {
            return;
        }
        this.f37137e = new com.github.barteksc.pdfviewer.c();
        com.github.barteksc.pdfviewer.a aVar = new com.github.barteksc.pdfviewer.a(this);
        this.f37138f = aVar;
        this.f37139g = new e(this, aVar);
        this.f37150r = new f(this);
        this.f37152t = new Paint();
        Paint paint = new Paint();
        this.f37153u = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.D = new PdfiumCore(context);
        setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(g1.c cVar, String str) {
        V(cVar, str, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(g1.c cVar, String str, int[] iArr) {
        if (this.f37145m) {
            this.f37145m = false;
            com.github.barteksc.pdfviewer.d dVar = new com.github.barteksc.pdfviewer.d(cVar, str, iArr, this, this.D);
            this.f37147o = dVar;
            dVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        throw new IllegalStateException("Don't call load on a PDF View without recycling it first.");
    }

    private void o(Canvas canvas, f1.b bVar) {
        float m4;
        float p02;
        RectF c4 = bVar.c();
        Bitmap d4 = bVar.d();
        if (d4.isRecycled()) {
            return;
        }
        SizeF n4 = this.f37140h.n(bVar.b());
        if (this.f37157y) {
            p02 = this.f37140h.m(bVar.b(), this.f37144l);
            m4 = p0(this.f37140h.h() - n4.b()) / 2.0f;
        } else {
            m4 = this.f37140h.m(bVar.b(), this.f37144l);
            p02 = p0(this.f37140h.f() - n4.a()) / 2.0f;
        }
        canvas.translate(m4, p02);
        Rect rect = new Rect(0, 0, d4.getWidth(), d4.getHeight());
        float p03 = p0(c4.left * n4.b());
        float p04 = p0(c4.top * n4.a());
        RectF rectF = new RectF((int) p03, (int) p04, (int) (p03 + p0(c4.width() * n4.b())), (int) (p04 + p0(c4.height() * n4.a())));
        float f4 = this.f37142j + m4;
        float f5 = this.f37143k + p02;
        if (rectF.left + f4 < getWidth() && f4 + rectF.right > 0.0f && rectF.top + f5 < getHeight() && f5 + rectF.bottom > 0.0f) {
            canvas.drawBitmap(d4, rect, rectF, this.f37152t);
            if (com.github.barteksc.pdfviewer.util.b.f37303a) {
                this.f37153u.setColor(bVar.b() % 2 == 0 ? -65536 : -16776961);
                canvas.drawRect(rectF, this.f37153u);
            }
            canvas.translate(-m4, -p02);
            return;
        }
        canvas.translate(-m4, -p02);
    }

    private void p(Canvas canvas, int i4, e1.b bVar) {
        float f4;
        if (bVar != null) {
            float f5 = 0.0f;
            if (this.f37157y) {
                f4 = this.f37140h.m(i4, this.f37144l);
            } else {
                f5 = this.f37140h.m(i4, this.f37144l);
                f4 = 0.0f;
            }
            canvas.translate(f5, f4);
            SizeF n4 = this.f37140h.n(i4);
            bVar.a(canvas, p0(n4.b()), p0(n4.a()), i4);
            canvas.translate(-f5, -f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAutoSpacing(boolean z3) {
        this.M = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultPage(int i4) {
        this.f37156x = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFitEachPage(boolean z3) {
        this.f37155w = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPageFitPolicy(FitPolicy fitPolicy) {
        this.f37154v = fitPolicy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollHandle(com.github.barteksc.pdfviewer.scroll.a aVar) {
        this.E = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSpacing(int i4) {
        this.f37132L = com.github.barteksc.pdfviewer.util.f.a(getContext(), i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSwipeVertical(boolean z3) {
        this.f37157y = z3;
    }

    public b A(g1.c cVar) {
        return new b(cVar);
    }

    public b B(InputStream inputStream) {
        return new b(new g1.e(inputStream));
    }

    public b C(Uri uri) {
        return new b(new g1.f(uri));
    }

    public List<PdfDocument.Link> D(int i4) {
        g gVar = this.f37140h;
        if (gVar == null) {
            return Collections.emptyList();
        }
        return gVar.l(i4);
    }

    public int E(float f4) {
        g gVar = this.f37140h;
        return gVar.j(gVar.e(this.f37144l) * f4, this.f37144l);
    }

    public SizeF F(int i4) {
        g gVar = this.f37140h;
        if (gVar == null) {
            return new SizeF(0.0f, 0.0f);
        }
        return gVar.n(i4);
    }

    public boolean G() {
        return this.H;
    }

    public boolean H() {
        return this.J;
    }

    public boolean I() {
        return this.M;
    }

    public boolean J() {
        return this.G;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean K() {
        return this.A;
    }

    public boolean L() {
        return this.f37155w;
    }

    public boolean M() {
        return this.N;
    }

    public boolean N() {
        return this.C;
    }

    public boolean O() {
        return this.f37145m;
    }

    public boolean P() {
        return this.f37158z;
    }

    public boolean Q() {
        return this.f37157y;
    }

    public boolean R() {
        return this.f37144l != this.f37133a;
    }

    public void S(int i4) {
        T(i4, false);
    }

    public void T(int i4, boolean z3) {
        g gVar = this.f37140h;
        if (gVar == null) {
            return;
        }
        int a4 = gVar.a(i4);
        float f4 = a4 == 0 ? 0.0f : -this.f37140h.m(a4, this.f37144l);
        if (this.f37157y) {
            if (z3) {
                this.f37138f.j(this.f37143k, f4);
            } else {
                b0(this.f37142j, f4);
            }
        } else if (z3) {
            this.f37138f.i(this.f37142j, f4);
        } else {
            b0(f4, this.f37143k);
        }
        m0(a4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W(g gVar) {
        this.f37146n = d.LOADED;
        this.f37140h = gVar;
        if (!this.f37148p.isAlive()) {
            this.f37148p.start();
        }
        h hVar = new h(this.f37148p.getLooper(), this);
        this.f37149q = hVar;
        hVar.e();
        com.github.barteksc.pdfviewer.scroll.a aVar = this.E;
        if (aVar != null) {
            aVar.setupLayout(this);
            this.F = true;
        }
        this.f37139g.e();
        this.f37151s.b(gVar.p());
        T(this.f37156x, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X(Throwable th) {
        this.f37146n = d.ERROR;
        e1.c k4 = this.f37151s.k();
        h0();
        invalidate();
        if (k4 != null) {
            k4.onError(th);
        } else {
            Log.e("PDFView", "load pdf error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y() {
        float f4;
        int width;
        if (this.f37140h.p() == 0) {
            return;
        }
        if (this.f37157y) {
            f4 = this.f37143k;
            width = getHeight();
        } else {
            f4 = this.f37142j;
            width = getWidth();
        }
        int j4 = this.f37140h.j(-(f4 - (width / 2.0f)), this.f37144l);
        if (j4 >= 0 && j4 <= this.f37140h.p() - 1 && j4 != getCurrentPage()) {
            m0(j4);
        } else {
            Z();
        }
    }

    public void Z() {
        h hVar;
        if (this.f37140h == null || (hVar = this.f37149q) == null) {
            return;
        }
        hVar.removeMessages(1);
        this.f37137e.i();
        this.f37150r.f();
        i0();
    }

    public void a0(float f4, float f5) {
        b0(this.f37142j + f4, this.f37143k + f5);
    }

    public void b0(float f4, float f5) {
        c0(f4, f5, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c0(float r6, float r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PDFView.c0(float, float, boolean):void");
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i4) {
        g gVar = this.f37140h;
        if (gVar == null) {
            return true;
        }
        if (this.f37157y) {
            if (i4 >= 0 || this.f37142j >= 0.0f) {
                return i4 > 0 && this.f37142j + p0(gVar.h()) > ((float) getWidth());
            }
            return true;
        } else if (i4 >= 0 || this.f37142j >= 0.0f) {
            return i4 > 0 && this.f37142j + gVar.e(this.f37144l) > ((float) getWidth());
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i4) {
        g gVar = this.f37140h;
        if (gVar == null) {
            return true;
        }
        if (this.f37157y) {
            if (i4 >= 0 || this.f37143k >= 0.0f) {
                return i4 > 0 && this.f37143k + gVar.e(this.f37144l) > ((float) getHeight());
            }
            return true;
        } else if (i4 >= 0 || this.f37143k >= 0.0f) {
            return i4 > 0 && this.f37143k + p0(gVar.f()) > ((float) getHeight());
        } else {
            return true;
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        if (isInEditMode()) {
            return;
        }
        this.f37138f.d();
    }

    public void d0(f1.b bVar) {
        if (this.f37146n == d.LOADED) {
            this.f37146n = d.SHOWN;
            this.f37151s.g(this.f37140h.p());
        }
        if (bVar.e()) {
            this.f37137e.c(bVar);
        } else {
            this.f37137e.b(bVar);
        }
        i0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e0(PageRenderingException pageRenderingException) {
        if (this.f37151s.e(pageRenderingException.getPage(), pageRenderingException.getCause())) {
            return;
        }
        String str = R;
        Log.e(str, "Cannot open page " + pageRenderingException.getPage(), pageRenderingException.getCause());
    }

    public boolean f0() {
        float f4 = -this.f37140h.m(this.f37141i, this.f37144l);
        float k4 = f4 - this.f37140h.k(this.f37141i, this.f37144l);
        if (Q()) {
            float f5 = this.f37143k;
            return f4 > f5 && k4 < f5 - ((float) getHeight());
        }
        float f6 = this.f37142j;
        return f4 > f6 && k4 < f6 - ((float) getWidth());
    }

    public void g0() {
        g gVar;
        int u3;
        SnapEdge v3;
        if (!this.C || (gVar = this.f37140h) == null || gVar.p() == 0 || (v3 = v((u3 = u(this.f37142j, this.f37143k)))) == SnapEdge.NONE) {
            return;
        }
        float n02 = n0(u3, v3);
        if (this.f37157y) {
            this.f37138f.j(this.f37143k, -n02);
        } else {
            this.f37138f.i(this.f37142j, -n02);
        }
    }

    public int getCurrentPage() {
        return this.f37141i;
    }

    public float getCurrentXOffset() {
        return this.f37142j;
    }

    public float getCurrentYOffset() {
        return this.f37143k;
    }

    public PdfDocument.Meta getDocumentMeta() {
        g gVar = this.f37140h;
        if (gVar == null) {
            return null;
        }
        return gVar.i();
    }

    public float getMaxZoom() {
        return this.f37135c;
    }

    public float getMidZoom() {
        return this.f37134b;
    }

    public float getMinZoom() {
        return this.f37133a;
    }

    public int getPageCount() {
        g gVar = this.f37140h;
        if (gVar == null) {
            return 0;
        }
        return gVar.p();
    }

    public FitPolicy getPageFitPolicy() {
        return this.f37154v;
    }

    public float getPositionOffset() {
        float f4;
        float e4;
        int width;
        if (this.f37157y) {
            f4 = -this.f37143k;
            e4 = this.f37140h.e(this.f37144l);
            width = getHeight();
        } else {
            f4 = -this.f37142j;
            e4 = this.f37140h.e(this.f37144l);
            width = getWidth();
        }
        return com.github.barteksc.pdfviewer.util.d.c(f4 / (e4 - width), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.github.barteksc.pdfviewer.scroll.a getScrollHandle() {
        return this.E;
    }

    public int getSpacingPx() {
        return this.f37132L;
    }

    public List<PdfDocument.Bookmark> getTableOfContents() {
        g gVar = this.f37140h;
        if (gVar == null) {
            return Collections.emptyList();
        }
        return gVar.d();
    }

    public float getZoom() {
        return this.f37144l;
    }

    public void h0() {
        this.Q = null;
        this.f37138f.l();
        this.f37139g.c();
        h hVar = this.f37149q;
        if (hVar != null) {
            hVar.f();
            this.f37149q.removeMessages(1);
        }
        com.github.barteksc.pdfviewer.d dVar = this.f37147o;
        if (dVar != null) {
            dVar.cancel(true);
        }
        this.f37137e.j();
        com.github.barteksc.pdfviewer.scroll.a aVar = this.E;
        if (aVar != null && this.F) {
            aVar.h();
        }
        g gVar = this.f37140h;
        if (gVar != null) {
            gVar.b();
            this.f37140h = null;
        }
        this.f37149q = null;
        this.E = null;
        this.F = false;
        this.f37143k = 0.0f;
        this.f37142j = 0.0f;
        this.f37144l = 1.0f;
        this.f37145m = true;
        this.f37151s = new e1.a();
        this.f37146n = d.DEFAULT;
    }

    void i0() {
        invalidate();
    }

    public void j0() {
        u0(this.f37133a);
    }

    public void k0() {
        v0(this.f37133a);
    }

    public void l0(float f4, boolean z3) {
        if (this.f37157y) {
            c0(this.f37142j, ((-this.f37140h.e(this.f37144l)) + getHeight()) * f4, z3);
        } else {
            c0(((-this.f37140h.e(this.f37144l)) + getWidth()) * f4, this.f37143k, z3);
        }
        Y();
    }

    public boolean m() {
        return this.I;
    }

    void m0(int i4) {
        if (this.f37145m) {
            return;
        }
        this.f37141i = this.f37140h.a(i4);
        Z();
        if (this.E != null && !n()) {
            this.E.setPageNum(this.f37141i + 1);
        }
        this.f37151s.d(this.f37141i, this.f37140h.p());
    }

    public boolean n() {
        float e4 = this.f37140h.e(1.0f);
        return this.f37157y ? e4 < ((float) getHeight()) : e4 < ((float) getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n0(int i4, SnapEdge snapEdge) {
        float f4;
        float m4 = this.f37140h.m(i4, this.f37144l);
        float height = this.f37157y ? getHeight() : getWidth();
        float k4 = this.f37140h.k(i4, this.f37144l);
        if (snapEdge == SnapEdge.CENTER) {
            f4 = m4 - (height / 2.0f);
            k4 /= 2.0f;
        } else if (snapEdge != SnapEdge.END) {
            return m4;
        } else {
            f4 = m4 - height;
        }
        return f4 + k4;
    }

    public void o0() {
        this.f37138f.m();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        h0();
        HandlerThread handlerThread = this.f37148p;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                handlerThread.quitSafely();
            } else {
                handlerThread.quit();
            }
            this.f37148p = null;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            return;
        }
        if (this.J) {
            canvas.setDrawFilter(this.K);
        }
        Drawable background = getBackground();
        if (background == null) {
            canvas.drawColor(this.B ? -16777216 : -1);
        } else {
            background.draw(canvas);
        }
        if (!this.f37145m && this.f37146n == d.SHOWN) {
            float f4 = this.f37142j;
            float f5 = this.f37143k;
            canvas.translate(f4, f5);
            for (f1.b bVar : this.f37137e.g()) {
                o(canvas, bVar);
            }
            for (f1.b bVar2 : this.f37137e.f()) {
                o(canvas, bVar2);
                if (this.f37151s.j() != null && !this.O.contains(Integer.valueOf(bVar2.b()))) {
                    this.O.add(Integer.valueOf(bVar2.b()));
                }
            }
            for (Integer num : this.O) {
                p(canvas, num.intValue(), this.f37151s.j());
            }
            this.O.clear();
            p(canvas, this.f37141i, this.f37151s.i());
            canvas.translate(-f4, -f5);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        float e4;
        float f4;
        this.P = true;
        b bVar = this.Q;
        if (bVar != null) {
            bVar.j();
        }
        if (isInEditMode() || this.f37146n != d.SHOWN) {
            return;
        }
        float f5 = (-this.f37142j) + (i6 * 0.5f);
        float f6 = (-this.f37143k) + (i7 * 0.5f);
        if (this.f37157y) {
            e4 = f5 / this.f37140h.h();
            f4 = this.f37140h.e(this.f37144l);
        } else {
            e4 = f5 / this.f37140h.e(this.f37144l);
            f4 = this.f37140h.f();
        }
        float f7 = f6 / f4;
        this.f37138f.l();
        this.f37140h.y(new Size(i4, i5));
        if (this.f37157y) {
            this.f37142j = ((-e4) * this.f37140h.h()) + (i4 * 0.5f);
            this.f37143k = ((-f7) * this.f37140h.e(this.f37144l)) + (i5 * 0.5f);
        } else {
            this.f37142j = ((-e4) * this.f37140h.e(this.f37144l)) + (i4 * 0.5f);
            this.f37143k = ((-f7) * this.f37140h.f()) + (i5 * 0.5f);
        }
        b0(this.f37142j, this.f37143k);
        Y();
    }

    public float p0(float f4) {
        return f4 * this.f37144l;
    }

    public void q(boolean z3) {
        this.H = z3;
    }

    public float q0(float f4) {
        return f4 / this.f37144l;
    }

    public void r(boolean z3) {
        this.J = z3;
    }

    public void r0(boolean z3) {
        this.G = z3;
    }

    void s(boolean z3) {
        this.A = z3;
    }

    public void s0(float f4, PointF pointF) {
        t0(this.f37144l * f4, pointF);
    }

    public void setMaxZoom(float f4) {
        this.f37135c = f4;
    }

    public void setMidZoom(float f4) {
        this.f37134b = f4;
    }

    public void setMinZoom(float f4) {
        this.f37133a = f4;
    }

    public void setNightMode(boolean z3) {
        this.B = z3;
        if (z3) {
            this.f37152t.setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[]{-1.0f, 0.0f, 0.0f, 0.0f, 255.0f, 0.0f, -1.0f, 0.0f, 0.0f, 255.0f, 0.0f, 0.0f, -1.0f, 0.0f, 255.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f})));
            return;
        }
        this.f37152t.setColorFilter(null);
    }

    public void setPageFling(boolean z3) {
        this.N = z3;
    }

    public void setPageSnap(boolean z3) {
        this.C = z3;
    }

    public void setPositionOffset(float f4) {
        l0(f4, true);
    }

    public void setSwipeEnabled(boolean z3) {
        this.f37158z = z3;
    }

    public void t(boolean z3) {
        this.I = z3;
    }

    public void t0(float f4, PointF pointF) {
        float f5 = f4 / this.f37144l;
        u0(f4);
        float f6 = pointF.x;
        float f7 = pointF.y;
        b0((this.f37142j * f5) + (f6 - (f6 * f5)), (this.f37143k * f5) + (f7 - (f5 * f7)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u(float f4, float f5) {
        boolean z3 = this.f37157y;
        if (z3) {
            f4 = f5;
        }
        float height = z3 ? getHeight() : getWidth();
        if (f4 > -1.0f) {
            return 0;
        }
        if (f4 < (-this.f37140h.e(this.f37144l)) + height + 1.0f) {
            return this.f37140h.p() - 1;
        }
        return this.f37140h.j(-(f4 - (height / 2.0f)), this.f37144l);
    }

    public void u0(float f4) {
        this.f37144l = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SnapEdge v(int i4) {
        if (this.C && i4 >= 0) {
            float f4 = this.f37157y ? this.f37143k : this.f37142j;
            float f5 = -this.f37140h.m(i4, this.f37144l);
            int height = this.f37157y ? getHeight() : getWidth();
            float k4 = this.f37140h.k(i4, this.f37144l);
            float f6 = height;
            if (f6 >= k4) {
                return SnapEdge.CENTER;
            }
            if (f4 >= f5) {
                return SnapEdge.START;
            }
            if (f5 - k4 > f4 - f6) {
                return SnapEdge.END;
            }
            return SnapEdge.NONE;
        }
        return SnapEdge.NONE;
    }

    public void v0(float f4) {
        this.f37138f.k(getWidth() / 2, getHeight() / 2, this.f37144l, f4);
    }

    public void w(int i4) {
        if (this.f37146n != d.SHOWN) {
            Log.e(R, "Cannot fit, document not rendered yet");
            return;
        }
        u0(getWidth() / this.f37140h.n(i4).b());
        S(i4);
    }

    public void w0(float f4, float f5, float f6) {
        this.f37138f.k(f4, f5, this.f37144l, f6);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [g1.c, g1.a] */
    public b x(String str) {
        return new b(new g1.a(str));
    }

    public b y(byte[] bArr) {
        return new b(new g1.b(bArr));
    }

    public b z(File file) {
        return new b(new g1.d(file));
    }
}
