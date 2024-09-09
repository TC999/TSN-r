package com.bytedance.adsdk.lottie;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.bytedance.adsdk.lottie.s;
import com.bytedance.component.sdk.annotation.FloatRange;
import com.bytedance.component.sdk.annotation.IntRange;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class d extends Drawable implements Animatable, Drawable.Callback {
    private final Matrix A;
    private Bitmap B;
    private Canvas C;
    private Rect D;
    private RectF E;
    private Paint F;
    private Rect G;
    private Rect H;
    private RectF I;
    private RectF J;
    private Matrix K;

    /* renamed from: L  reason: collision with root package name */
    private Matrix f25523L;
    private boolean M;

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.e f25524a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.f.f f25525b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25526c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f25527d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f25528e;

    /* renamed from: f  reason: collision with root package name */
    private o f25529f;

    /* renamed from: g  reason: collision with root package name */
    private final ArrayList<n> f25530g;

    /* renamed from: h  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f25531h;

    /* renamed from: i  reason: collision with root package name */
    private i0.b f25532i;

    /* renamed from: j  reason: collision with root package name */
    private String f25533j;

    /* renamed from: k  reason: collision with root package name */
    private p f25534k;

    /* renamed from: l  reason: collision with root package name */
    private i0.a f25535l;

    /* renamed from: m  reason: collision with root package name */
    private Map<String, Typeface> f25536m;

    /* renamed from: n  reason: collision with root package name */
    String f25537n;

    /* renamed from: o  reason: collision with root package name */
    u f25538o;

    /* renamed from: p  reason: collision with root package name */
    com.bytedance.adsdk.lottie.m f25539p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f25540q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f25541r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f25542s;

    /* renamed from: t  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.xv.xv.f f25543t;

    /* renamed from: u  reason: collision with root package name */
    private int f25544u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f25545v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f25546w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f25547x;

    /* renamed from: y  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.i f25548y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f25549z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class a implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f25550a;

        a(int i4) {
            this.f25550a = i4;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.k0(this.f25550a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class b implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f25552a;

        b(float f4) {
            this.f25552a = f4;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.j0(this.f25552a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class c implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f25554a;

        c(String str) {
            this.f25554a = str;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.m0(this.f25554a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.adsdk.lottie.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class C0351d implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f25556a;

        C0351d(String str) {
            this.f25556a = str;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.s0(this.f25556a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class e implements ValueAnimator.AnimatorUpdateListener {
        e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (d.this.f25543t != null) {
                d.this.f25543t.f(d.this.f25525b.p());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class f implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f25559a;

        f(String str) {
            this.f25559a = str;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.Z(this.f25559a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class g implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f25561a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f25562b;

        g(int i4, int i5) {
            this.f25561a = i4;
            this.f25562b = i5;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.i(this.f25561a, this.f25562b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class h implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f25564a;

        h(int i4) {
            this.f25564a = i4;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.r0(this.f25564a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class i implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f25566a;

        i(float f4) {
            this.f25566a = f4;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.X(this.f25566a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class j implements n {
        j() {
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class k implements n {
        k() {
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class l implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f25570a;

        l(int i4) {
            this.f25570a = i4;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.h(this.f25570a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public class m implements n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ float f25572a;

        m(float f4) {
            this.f25572a = f4;
        }

        @Override // com.bytedance.adsdk.lottie.d.n
        public void a(com.bytedance.adsdk.lottie.e eVar) {
            d.this.g(this.f25572a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface n {
        void a(com.bytedance.adsdk.lottie.e eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum o {
        NONE,
        PLAY,
        RESUME
    }

    public d() {
        com.bytedance.adsdk.lottie.f.f fVar = new com.bytedance.adsdk.lottie.f.f();
        this.f25525b = fVar;
        this.f25526c = true;
        this.f25527d = false;
        this.f25528e = false;
        this.f25529f = o.NONE;
        this.f25530g = new ArrayList<>();
        e eVar = new e();
        this.f25531h = eVar;
        this.f25541r = false;
        this.f25542s = true;
        this.f25544u = 255;
        this.f25548y = com.bytedance.adsdk.lottie.i.AUTOMATIC;
        this.f25549z = false;
        this.A = new Matrix();
        this.M = false;
        fVar.addUpdateListener(eVar);
    }

    private boolean P() {
        Drawable.Callback callback = getCallback();
        if (callback instanceof View) {
            ViewParent parent = ((View) callback).getParent();
            if (Build.VERSION.SDK_INT < 18 || !(parent instanceof ViewGroup)) {
                return false;
            }
            return !((ViewGroup) parent).getClipChildren();
        }
        return false;
    }

    private void Q() {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            return;
        }
        this.f25549z = this.f25548y.c(Build.VERSION.SDK_INT, eVar.i(), eVar.r());
    }

    private i0.b b() {
        i0.b bVar = this.f25532i;
        if (bVar != null && !bVar.d(getContext())) {
            this.f25532i = null;
        }
        if (this.f25532i == null) {
            this.f25532i = new i0.b(getCallback(), this.f25533j, this.f25534k, this.f25524a.a());
        }
        return this.f25532i;
    }

    private Context getContext() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private void j(Canvas canvas) {
        com.bytedance.adsdk.lottie.xv.xv.f fVar = this.f25543t;
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (fVar == null || eVar == null) {
            return;
        }
        this.A.reset();
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            this.A.preScale(bounds.width() / eVar.p().width(), bounds.height() / eVar.p().height());
            this.A.preTranslate(bounds.left, bounds.top);
        }
        fVar.a(canvas, this.A, this.f25544u);
    }

    private void k(Canvas canvas, com.bytedance.adsdk.lottie.xv.xv.f fVar) {
        if (this.f25524a == null || fVar == null) {
            return;
        }
        z();
        canvas.getMatrix(this.K);
        canvas.getClipBounds(this.D);
        l(this.D, this.E);
        this.K.mapRect(this.E);
        n(this.E, this.D);
        if (this.f25542s) {
            this.J.set(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight());
        } else {
            fVar.b(this.J, null, false);
        }
        this.K.mapRect(this.J);
        Rect bounds = getBounds();
        float width = bounds.width() / getIntrinsicWidth();
        float height = bounds.height() / getIntrinsicHeight();
        m(this.J, width, height);
        if (!P()) {
            RectF rectF = this.J;
            Rect rect = this.D;
            rectF.intersect(rect.left, rect.top, rect.right, rect.bottom);
        }
        int ceil = (int) Math.ceil(this.J.width());
        int ceil2 = (int) Math.ceil(this.J.height());
        if (ceil == 0 || ceil2 == 0) {
            return;
        }
        l0(ceil, ceil2);
        if (this.M) {
            this.A.set(this.K);
            this.A.preScale(width, height);
            Matrix matrix = this.A;
            RectF rectF2 = this.J;
            matrix.postTranslate(-rectF2.left, -rectF2.top);
            this.B.eraseColor(0);
            fVar.a(this.C, this.A, this.f25544u);
            this.K.invert(this.f25523L);
            this.f25523L.mapRect(this.I, this.J);
            n(this.I, this.H);
        }
        this.G.set(0, 0, ceil, ceil2);
        canvas.drawBitmap(this.B, this.G, this.H, this.F);
    }

    private void l(Rect rect, RectF rectF) {
        rectF.set(rect.left, rect.top, rect.right, rect.bottom);
    }

    private void l0(int i4, int i5) {
        Bitmap bitmap = this.B;
        if (bitmap != null && bitmap.getWidth() >= i4 && this.B.getHeight() >= i5) {
            if (this.B.getWidth() > i4 || this.B.getHeight() > i5) {
                Bitmap createBitmap = Bitmap.createBitmap(this.B, 0, 0, i4, i5);
                this.B = createBitmap;
                this.C.setBitmap(createBitmap);
                this.M = true;
                return;
            }
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        this.B = createBitmap2;
        this.C.setBitmap(createBitmap2);
        this.M = true;
    }

    private void m(RectF rectF, float f4, float f5) {
        rectF.set(rectF.left * f4, rectF.top * f5, rectF.right * f4, rectF.bottom * f5);
    }

    private void n(RectF rectF, Rect rect) {
        rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private i0.a u0() {
        if (getCallback() == null) {
            return null;
        }
        if (this.f25535l == null) {
            i0.a aVar = new i0.a(getCallback(), this.f25538o);
            this.f25535l = aVar;
            String str = this.f25537n;
            if (str != null) {
                aVar.d(str);
            }
        }
        return this.f25535l;
    }

    private boolean w0() {
        return this.f25526c || this.f25527d;
    }

    private void y() {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            return;
        }
        com.bytedance.adsdk.lottie.xv.xv.f fVar = new com.bytedance.adsdk.lottie.xv.xv.f(this, s.y.b(eVar), eVar.l(), eVar);
        this.f25543t = fVar;
        if (this.f25546w) {
            fVar.o(true);
        }
        this.f25543t.F(this.f25542s);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [android.graphics.Paint, h0.a] */
    private void z() {
        if (this.C != null) {
            return;
        }
        this.C = new Canvas();
        this.J = new RectF();
        this.K = new Matrix();
        this.f25523L = new Matrix();
        this.D = new Rect();
        this.E = new RectF();
        this.F = new h0.a();
        this.G = new Rect();
        this.H = new Rect();
        this.I = new RectF();
    }

    public void A() {
        if (this.f25525b.isRunning()) {
            this.f25525b.cancel();
            if (!isVisible()) {
                this.f25529f = o.NONE;
            }
        }
        this.f25524a = null;
        this.f25543t = null;
        this.f25532i = null;
        this.f25525b.o();
        invalidateSelf();
    }

    public void B(boolean z3) {
        this.f25527d = z3;
    }

    public com.bytedance.adsdk.lottie.h C(String str) {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            return null;
        }
        return eVar.a().get(str);
    }

    public r D() {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar != null) {
            return eVar.u();
        }
        return null;
    }

    public void E(boolean z3) {
        this.f25547x = z3;
    }

    @SuppressLint({"WrongConstant"})
    public int F() {
        return this.f25525b.getRepeatMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean G() {
        if (isVisible()) {
            return this.f25525b.isRunning();
        }
        o oVar = this.f25529f;
        return oVar == o.PLAY || oVar == o.RESUME;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float H() {
        return this.f25525b.p();
    }

    @MainThread
    public void I() {
        if (this.f25543t == null) {
            this.f25530g.add(new j());
            return;
        }
        Q();
        if (w0() || L() == 0) {
            if (isVisible()) {
                this.f25525b.v();
                this.f25529f = o.NONE;
            } else {
                this.f25529f = o.PLAY;
            }
        }
        if (w0()) {
            return;
        }
        r0((int) (c0() < 0.0f ? a() : c()));
        this.f25525b.i();
        if (isVisible()) {
            return;
        }
        this.f25529f = o.NONE;
    }

    public void J(boolean z3) {
        this.f25525b.F(z3);
    }

    public boolean K() {
        return this.f25536m == null && this.f25539p == null && this.f25524a.n().size() > 0;
    }

    public int L() {
        return this.f25525b.getRepeatCount();
    }

    public void M() {
        this.f25530g.clear();
        this.f25525b.cancel();
        if (isVisible()) {
            return;
        }
        this.f25529f = o.NONE;
    }

    @MainThread
    public void N() {
        if (this.f25543t == null) {
            this.f25530g.add(new k());
            return;
        }
        Q();
        if (w0() || L() == 0) {
            if (isVisible()) {
                this.f25525b.B();
                this.f25529f = o.NONE;
            } else {
                this.f25529f = o.RESUME;
            }
        }
        if (w0()) {
            return;
        }
        r0((int) (c0() < 0.0f ? a() : c()));
        this.f25525b.i();
        if (isVisible()) {
            return;
        }
        this.f25529f = o.NONE;
    }

    public void O() {
        this.f25530g.clear();
        this.f25525b.j();
        if (isVisible()) {
            return;
        }
        this.f25529f = o.NONE;
    }

    @MainThread
    public void R() {
        this.f25530g.clear();
        this.f25525b.i();
        if (isVisible()) {
            return;
        }
        this.f25529f = o.NONE;
    }

    public com.bytedance.adsdk.lottie.e S() {
        return this.f25524a;
    }

    public void T(String str) {
        this.f25537n = str;
        i0.a u02 = u0();
        if (u02 != null) {
            u02.d(str);
        }
    }

    public void U(boolean z3) {
        this.f25528e = z3;
    }

    public boolean V() {
        return this.f25547x;
    }

    public boolean W() {
        com.bytedance.adsdk.lottie.f.f fVar = this.f25525b;
        if (fVar == null) {
            return false;
        }
        return fVar.isRunning();
    }

    public void X(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.f25524a == null) {
            this.f25530g.add(new i(f4));
            return;
        }
        s.b("Drawable#setProgress");
        this.f25525b.k(this.f25524a.c(f4));
        s.d("Drawable#setProgress");
    }

    public void Y(int i4) {
        this.f25525b.setRepeatMode(i4);
    }

    public void Z(String str) {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            this.f25530g.add(new f(str));
            return;
        }
        com.bytedance.adsdk.lottie.xv.b v3 = eVar.v(str);
        if (v3 != null) {
            int i4 = (int) v3.f25755b;
            i(i4, ((int) v3.f25756c) + i4);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public float a() {
        return this.f25525b.G();
    }

    public void a0(boolean z3) {
        this.f25545v = z3;
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar != null) {
            eVar.t(z3);
        }
    }

    public boolean b0() {
        return this.f25541r;
    }

    public float c() {
        return this.f25525b.q();
    }

    public float c0() {
        return this.f25525b.x();
    }

    public Bitmap d(String str, Bitmap bitmap) {
        i0.b b4 = b();
        if (b4 == null) {
            com.bytedance.adsdk.lottie.f.e.c("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        Bitmap b5 = b4.b(str, bitmap);
        invalidateSelf();
        return b5;
    }

    public com.bytedance.adsdk.lottie.m d0() {
        return this.f25539p;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        s.b("Drawable#draw");
        if (this.f25528e) {
            try {
                if (this.f25549z) {
                    k(canvas, this.f25543t);
                } else {
                    j(canvas);
                }
            } catch (Throwable th) {
                com.bytedance.adsdk.lottie.f.e.d("Lottie crashed in draw!", th);
            }
        } else if (this.f25549z) {
            k(canvas, this.f25543t);
        } else {
            j(canvas);
        }
        this.M = false;
        s.d("Drawable#draw");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Typeface e(com.bytedance.adsdk.lottie.xv.f fVar) {
        Map<String, Typeface> map = this.f25536m;
        if (map != null) {
            String a4 = fVar.a();
            if (map.containsKey(a4)) {
                return map.get(a4);
            }
            String d4 = fVar.d();
            if (map.containsKey(d4)) {
                return map.get(d4);
            }
            String str = fVar.a() + "-" + fVar.e();
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        i0.a u02 = u0();
        if (u02 != null) {
            return u02.b(fVar);
        }
        return null;
    }

    public Bitmap e0(String str) {
        i0.b b4 = b();
        if (b4 != null) {
            return b4.a(str);
        }
        return null;
    }

    public com.bytedance.adsdk.lottie.i f0() {
        return this.f25549z ? com.bytedance.adsdk.lottie.i.SOFTWARE : com.bytedance.adsdk.lottie.i.HARDWARE;
    }

    public void g(float f4) {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            this.f25530g.add(new m(f4));
        } else {
            h((int) com.bytedance.adsdk.lottie.f.d.a(eVar.k(), this.f25524a.o(), f4));
        }
    }

    public void g0(int i4) {
        this.f25525b.setRepeatCount(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f25544u;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            return -1;
        }
        return eVar.p().height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            return -1;
        }
        return eVar.p().width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(int i4) {
        if (this.f25524a == null) {
            this.f25530g.add(new l(i4));
        } else {
            this.f25525b.m(i4);
        }
    }

    public void h0(boolean z3) {
        if (this.f25546w == z3) {
            return;
        }
        this.f25546w = z3;
        com.bytedance.adsdk.lottie.xv.xv.f fVar = this.f25543t;
        if (fVar != null) {
            fVar.o(z3);
        }
    }

    public void i(int i4, int i5) {
        if (this.f25524a == null) {
            this.f25530g.add(new g(i4, i5));
        } else {
            this.f25525b.l(i4, i5 + 0.99f);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.M) {
            return;
        }
        this.M = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return W();
    }

    public void j0(@FloatRange(from = 0.0d, to = 1.0d) float f4) {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            this.f25530g.add(new b(f4));
        } else {
            this.f25525b.D(com.bytedance.adsdk.lottie.f.d.a(eVar.k(), this.f25524a.o(), f4));
        }
    }

    public void k0(int i4) {
        if (this.f25524a == null) {
            this.f25530g.add(new a(i4));
        } else {
            this.f25525b.D(i4 + 0.99f);
        }
    }

    public void m0(String str) {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            this.f25530g.add(new c(str));
            return;
        }
        com.bytedance.adsdk.lottie.xv.b v3 = eVar.v(str);
        if (v3 != null) {
            h((int) v3.f25755b);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void n0(boolean z3) {
        if (z3 != this.f25542s) {
            this.f25542s = z3;
            com.bytedance.adsdk.lottie.xv.xv.f fVar = this.f25543t;
            if (fVar != null) {
                fVar.F(z3);
            }
            invalidateSelf();
        }
    }

    public void o(com.bytedance.adsdk.lottie.i iVar) {
        this.f25548y = iVar;
        Q();
    }

    public boolean o0() {
        return this.f25542s;
    }

    public void p(com.bytedance.adsdk.lottie.m mVar) {
        this.f25539p = mVar;
    }

    public String p0() {
        return this.f25533j;
    }

    public void q(p pVar) {
        this.f25534k = pVar;
        i0.b bVar = this.f25532i;
        if (bVar != null) {
            bVar.c(pVar);
        }
    }

    public void q0(float f4) {
        this.f25525b.E(f4);
    }

    public void r(u uVar) {
        this.f25538o = uVar;
        i0.a aVar = this.f25535l;
        if (aVar != null) {
            aVar.c(uVar);
        }
    }

    public void r0(int i4) {
        if (this.f25524a == null) {
            this.f25530g.add(new h(i4));
        } else {
            this.f25525b.k(i4);
        }
    }

    public void s(Boolean bool) {
        this.f25526c = bool.booleanValue();
    }

    public void s0(String str) {
        com.bytedance.adsdk.lottie.e eVar = this.f25524a;
        if (eVar == null) {
            this.f25530g.add(new C0351d(str));
            return;
        }
        com.bytedance.adsdk.lottie.xv.b v3 = eVar.v(str);
        if (v3 != null) {
            k0((int) (v3.f25755b + v3.f25756c));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i4) {
        this.f25544u = i4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        com.bytedance.adsdk.lottie.f.e.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z3, boolean z4) {
        boolean z5 = !isVisible();
        boolean visible = super.setVisible(z3, z4);
        if (z3) {
            o oVar = this.f25529f;
            if (oVar == o.PLAY) {
                I();
            } else if (oVar == o.RESUME) {
                N();
            }
        } else if (this.f25525b.isRunning()) {
            O();
            this.f25529f = o.RESUME;
        } else if (!z5) {
            this.f25529f = o.NONE;
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void start() {
        Drawable.Callback callback = getCallback();
        if ((callback instanceof View) && ((View) callback).isInEditMode()) {
            return;
        }
        I();
    }

    @Override // android.graphics.drawable.Animatable
    @MainThread
    public void stop() {
        R();
    }

    public void t(String str) {
        this.f25533j = str;
    }

    public void t0(boolean z3) {
        this.f25541r = z3;
    }

    public void u(Map<String, Typeface> map) {
        if (map == this.f25536m) {
            return;
        }
        this.f25536m = map;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public void v(boolean z3) {
        if (this.f25540q == z3) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            com.bytedance.adsdk.lottie.f.e.c("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.f25540q = z3;
        if (this.f25524a != null) {
            y();
        }
    }

    public int v0() {
        return (int) this.f25525b.y();
    }

    public boolean w() {
        return this.f25540q;
    }

    public boolean x(com.bytedance.adsdk.lottie.e eVar) {
        if (this.f25524a == eVar) {
            return false;
        }
        this.M = true;
        A();
        this.f25524a = eVar;
        y();
        this.f25525b.n(eVar);
        X(this.f25525b.getAnimatedFraction());
        Iterator it = new ArrayList(this.f25530g).iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (nVar != null) {
                nVar.a(eVar);
            }
            it.remove();
        }
        this.f25530g.clear();
        eVar.t(this.f25545v);
        Q();
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
        }
        return true;
    }
}
