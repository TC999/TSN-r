package com.acse.ottn.animator.c.a;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public final class a extends Animation {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f4958a;

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<View, a> f4959b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<View> f4960c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4962e;

    /* renamed from: g  reason: collision with root package name */
    private float f4964g;

    /* renamed from: h  reason: collision with root package name */
    private float f4965h;

    /* renamed from: i  reason: collision with root package name */
    private float f4966i;

    /* renamed from: j  reason: collision with root package name */
    private float f4967j;

    /* renamed from: k  reason: collision with root package name */
    private float f4968k;

    /* renamed from: n  reason: collision with root package name */
    private float f4971n;

    /* renamed from: o  reason: collision with root package name */
    private float f4972o;

    /* renamed from: d  reason: collision with root package name */
    private final Camera f4961d = new Camera();

    /* renamed from: f  reason: collision with root package name */
    private float f4963f = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f4969l = 1.0f;

    /* renamed from: m  reason: collision with root package name */
    private float f4970m = 1.0f;

    /* renamed from: p  reason: collision with root package name */
    private final RectF f4973p = new RectF();

    /* renamed from: q  reason: collision with root package name */
    private final RectF f4974q = new RectF();

    /* renamed from: r  reason: collision with root package name */
    private final Matrix f4975r = new Matrix();

    static {
        f4958a = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f4959b = new WeakHashMap<>();
    }

    private a(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f4960c = new WeakReference<>(view);
    }

    public static a a(View view) {
        WeakHashMap<View, a> weakHashMap = f4959b;
        a aVar = weakHashMap.get(view);
        if (aVar == null || aVar != view.getAnimation()) {
            a aVar2 = new a(view);
            weakHashMap.put(view, aVar2);
            return aVar2;
        }
        return aVar;
    }

    private void a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z3 = this.f4962e;
        float f4 = z3 ? this.f4964g : width / 2.0f;
        float f5 = z3 ? this.f4965h : height / 2.0f;
        float f6 = this.f4966i;
        float f7 = this.f4967j;
        float f8 = this.f4968k;
        if (f6 != 0.0f || f7 != 0.0f || f8 != 0.0f) {
            Camera camera = this.f4961d;
            camera.save();
            camera.rotateX(f6);
            camera.rotateY(f7);
            camera.rotateZ(-f8);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f4, -f5);
            matrix.postTranslate(f4, f5);
        }
        float f9 = this.f4969l;
        float f10 = this.f4970m;
        if (f9 != 1.0f || f10 != 1.0f) {
            matrix.postScale(f9, f10);
            matrix.postTranslate((-(f4 / width)) * ((f9 * width) - width), (-(f5 / height)) * ((f10 * height) - height));
        }
        matrix.postTranslate(this.f4971n, this.f4972o);
    }

    private void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f4975r;
        matrix.reset();
        a(matrix, view);
        this.f4975r.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        float f4 = rectF.right;
        float f5 = rectF.left;
        if (f4 < f5) {
            rectF.right = f5;
            rectF.left = f4;
        }
        float f6 = rectF.bottom;
        float f7 = rectF.top;
        if (f6 < f7) {
            rectF.top = f6;
            rectF.bottom = f7;
        }
    }

    private void o() {
        View view = this.f4960c.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f4974q;
        a(rectF, view);
        rectF.union(this.f4973p);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    private void p() {
        View view = this.f4960c.get();
        if (view != null) {
            a(this.f4973p, view);
        }
    }

    public float a() {
        return this.f4963f;
    }

    public void a(float f4) {
        if (this.f4963f != f4) {
            this.f4963f = f4;
            View view = this.f4960c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void a(int i4) {
        View view = this.f4960c.get();
        if (view != null) {
            view.scrollTo(i4, view.getScrollY());
        }
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f4, Transformation transformation) {
        View view = this.f4960c.get();
        if (view != null) {
            transformation.setAlpha(this.f4963f);
            a(transformation.getMatrix(), view);
        }
    }

    public float b() {
        return this.f4964g;
    }

    public void b(float f4) {
        if (this.f4962e && this.f4964g == f4) {
            return;
        }
        p();
        this.f4962e = true;
        this.f4964g = f4;
        o();
    }

    public void b(int i4) {
        View view = this.f4960c.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i4);
        }
    }

    public float c() {
        return this.f4965h;
    }

    public void c(float f4) {
        if (this.f4962e && this.f4965h == f4) {
            return;
        }
        p();
        this.f4962e = true;
        this.f4965h = f4;
        o();
    }

    public float d() {
        return this.f4968k;
    }

    public void d(float f4) {
        if (this.f4968k != f4) {
            p();
            this.f4968k = f4;
            o();
        }
    }

    public float e() {
        return this.f4966i;
    }

    public void e(float f4) {
        if (this.f4966i != f4) {
            p();
            this.f4966i = f4;
            o();
        }
    }

    public float f() {
        return this.f4967j;
    }

    public void f(float f4) {
        if (this.f4967j != f4) {
            p();
            this.f4967j = f4;
            o();
        }
    }

    public float g() {
        return this.f4969l;
    }

    public void g(float f4) {
        if (this.f4969l != f4) {
            p();
            this.f4969l = f4;
            o();
        }
    }

    public float h() {
        return this.f4970m;
    }

    public void h(float f4) {
        if (this.f4970m != f4) {
            p();
            this.f4970m = f4;
            o();
        }
    }

    public int i() {
        View view = this.f4960c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public void i(float f4) {
        if (this.f4971n != f4) {
            p();
            this.f4971n = f4;
            o();
        }
    }

    public int j() {
        View view = this.f4960c.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public void j(float f4) {
        if (this.f4972o != f4) {
            p();
            this.f4972o = f4;
            o();
        }
    }

    public float k() {
        return this.f4971n;
    }

    public void k(float f4) {
        View view = this.f4960c.get();
        if (view != null) {
            i(f4 - view.getLeft());
        }
    }

    public float l() {
        return this.f4972o;
    }

    public void l(float f4) {
        View view = this.f4960c.get();
        if (view != null) {
            j(f4 - view.getTop());
        }
    }

    public float m() {
        View view = this.f4960c.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getLeft() + this.f4971n;
    }

    public float n() {
        View view = this.f4960c.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getTop() + this.f4972o;
    }
}
