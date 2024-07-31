package com.acse.ottn.animator.p033c.p034a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: com.acse.ottn.animator.c.a.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class C1378a extends Animation {

    /* renamed from: a */
    public static final boolean f2416a;

    /* renamed from: b */
    private static final WeakHashMap<View, C1378a> f2417b;

    /* renamed from: c */
    private final WeakReference<View> f2418c;

    /* renamed from: e */
    private boolean f2420e;

    /* renamed from: g */
    private float f2422g;

    /* renamed from: h */
    private float f2423h;

    /* renamed from: i */
    private float f2424i;

    /* renamed from: j */
    private float f2425j;

    /* renamed from: k */
    private float f2426k;

    /* renamed from: n */
    private float f2429n;

    /* renamed from: o */
    private float f2430o;

    /* renamed from: d */
    private final Camera f2419d = new Camera();

    /* renamed from: f */
    private float f2421f = 1.0f;

    /* renamed from: l */
    private float f2427l = 1.0f;

    /* renamed from: m */
    private float f2428m = 1.0f;

    /* renamed from: p */
    private final RectF f2431p = new RectF();

    /* renamed from: q */
    private final RectF f2432q = new RectF();

    /* renamed from: r */
    private final Matrix f2433r = new Matrix();

    static {
        f2416a = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f2417b = new WeakHashMap<>();
    }

    private C1378a(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f2418c = new WeakReference<>(view);
    }

    /* renamed from: a */
    public static C1378a m56966a(View view) {
        WeakHashMap<View, C1378a> weakHashMap = f2417b;
        C1378a c1378a = weakHashMap.get(view);
        if (c1378a == null || c1378a != view.getAnimation()) {
            C1378a c1378a2 = new C1378a(view);
            weakHashMap.put(view, c1378a2);
            return c1378a2;
        }
        return c1378a;
    }

    /* renamed from: a */
    private void m56969a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.f2420e;
        float f = z ? this.f2422g : width / 2.0f;
        float f2 = z ? this.f2423h : height / 2.0f;
        float f3 = this.f2424i;
        float f4 = this.f2425j;
        float f5 = this.f2426k;
        if (f3 != 0.0f || f4 != 0.0f || f5 != 0.0f) {
            Camera camera = this.f2419d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.f2427l;
        float f7 = this.f2428m;
        if (f6 != 1.0f || f7 != 1.0f) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.f2429n, this.f2430o);
    }

    /* renamed from: a */
    private void m56968a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f2433r;
        matrix.reset();
        m56969a(matrix, view);
        this.f2433r.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f = rectF.right;
        float f2 = rectF.left;
        if (f < f2) {
            rectF.right = f2;
            rectF.left = f;
        }
        float f3 = rectF.bottom;
        float f4 = rectF.top;
        if (f3 < f4) {
            rectF.top = f3;
            rectF.bottom = f4;
        }
    }

    /* renamed from: o */
    private void m56913o() {
        View view = this.f2418c.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f2432q;
        m56968a(rectF, view);
        rectF.union(this.f2431p);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    /* renamed from: p */
    private void m56912p() {
        View view = this.f2418c.get();
        if (view != null) {
            m56968a(this.f2431p, view);
        }
    }

    /* renamed from: a */
    public float m56972a() {
        return this.f2421f;
    }

    /* renamed from: a */
    public void m56971a(float f) {
        if (this.f2421f != f) {
            this.f2421f = f;
            View view = this.f2418c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* renamed from: a */
    public void m56970a(int i) {
        View view = this.f2418c.get();
        if (view != null) {
            view.scrollTo(i, view.getScrollY());
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        View view = this.f2418c.get();
        if (view != null) {
            transformation.setAlpha(this.f2421f);
            m56969a(transformation.getMatrix(), view);
        }
    }

    /* renamed from: b */
    public float m56963b() {
        return this.f2422g;
    }

    /* renamed from: b */
    public void m56962b(float f) {
        if (this.f2420e && this.f2422g == f) {
            return;
        }
        m56912p();
        this.f2420e = true;
        this.f2422g = f;
        m56913o();
    }

    /* renamed from: b */
    public void m56961b(int i) {
        View view = this.f2418c.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i);
        }
    }

    /* renamed from: c */
    public float m56957c() {
        return this.f2423h;
    }

    /* renamed from: c */
    public void m56956c(float f) {
        if (this.f2420e && this.f2423h == f) {
            return;
        }
        m56912p();
        this.f2420e = true;
        this.f2423h = f;
        m56913o();
    }

    /* renamed from: d */
    public float m56953d() {
        return this.f2426k;
    }

    /* renamed from: d */
    public void m56952d(float f) {
        if (this.f2426k != f) {
            m56912p();
            this.f2426k = f;
            m56913o();
        }
    }

    /* renamed from: e */
    public float m56949e() {
        return this.f2424i;
    }

    /* renamed from: e */
    public void m56948e(float f) {
        if (this.f2424i != f) {
            m56912p();
            this.f2424i = f;
            m56913o();
        }
    }

    /* renamed from: f */
    public float m56945f() {
        return this.f2425j;
    }

    /* renamed from: f */
    public void m56944f(float f) {
        if (this.f2425j != f) {
            m56912p();
            this.f2425j = f;
            m56913o();
        }
    }

    /* renamed from: g */
    public float m56941g() {
        return this.f2427l;
    }

    /* renamed from: g */
    public void m56940g(float f) {
        if (this.f2427l != f) {
            m56912p();
            this.f2427l = f;
            m56913o();
        }
    }

    /* renamed from: h */
    public float m56937h() {
        return this.f2428m;
    }

    /* renamed from: h */
    public void m56936h(float f) {
        if (this.f2428m != f) {
            m56912p();
            this.f2428m = f;
            m56913o();
        }
    }

    /* renamed from: i */
    public int m56933i() {
        View view = this.f2418c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    /* renamed from: i */
    public void m56932i(float f) {
        if (this.f2429n != f) {
            m56912p();
            this.f2429n = f;
            m56913o();
        }
    }

    /* renamed from: j */
    public int m56929j() {
        View view = this.f2418c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    /* renamed from: j */
    public void m56928j(float f) {
        if (this.f2430o != f) {
            m56912p();
            this.f2430o = f;
            m56913o();
        }
    }

    /* renamed from: k */
    public float m56925k() {
        return this.f2429n;
    }

    /* renamed from: k */
    public void m56924k(float f) {
        View view = this.f2418c.get();
        if (view != null) {
            m56932i(f - view.getLeft());
        }
    }

    /* renamed from: l */
    public float m56921l() {
        return this.f2430o;
    }

    /* renamed from: l */
    public void m56920l(float f) {
        View view = this.f2418c.get();
        if (view != null) {
            m56928j(f - view.getTop());
        }
    }

    /* renamed from: m */
    public float m56917m() {
        View view = this.f2418c.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getLeft() + this.f2429n;
    }

    /* renamed from: n */
    public float m56915n() {
        View view = this.f2418c.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getTop() + this.f2430o;
    }
}
