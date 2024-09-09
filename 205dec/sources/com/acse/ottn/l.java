package com.acse.ottn;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class l extends Animation {

    /* renamed from: q  reason: collision with root package name */
    public static final boolean f5841q;

    /* renamed from: r  reason: collision with root package name */
    public static final WeakHashMap<View, l> f5842r;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<View> f5843a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5845c;

    /* renamed from: e  reason: collision with root package name */
    public float f5847e;

    /* renamed from: f  reason: collision with root package name */
    public float f5848f;

    /* renamed from: g  reason: collision with root package name */
    public float f5849g;

    /* renamed from: h  reason: collision with root package name */
    public float f5850h;

    /* renamed from: i  reason: collision with root package name */
    public float f5851i;

    /* renamed from: l  reason: collision with root package name */
    public float f5854l;

    /* renamed from: m  reason: collision with root package name */
    public float f5855m;

    /* renamed from: b  reason: collision with root package name */
    public final Camera f5844b = new Camera();

    /* renamed from: d  reason: collision with root package name */
    public float f5846d = 1.0f;

    /* renamed from: j  reason: collision with root package name */
    public float f5852j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    public float f5853k = 1.0f;

    /* renamed from: n  reason: collision with root package name */
    public final RectF f5856n = new RectF();

    /* renamed from: o  reason: collision with root package name */
    public final RectF f5857o = new RectF();

    /* renamed from: p  reason: collision with root package name */
    public final Matrix f5858p = new Matrix();

    static {
        f5841q = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f5842r = new WeakHashMap<>();
    }

    public l(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f5843a = new WeakReference<>(view);
    }

    public static l a(View view) {
        WeakHashMap<View, l> weakHashMap = f5842r;
        l lVar = weakHashMap.get(view);
        if (lVar == null || lVar != view.getAnimation()) {
            l lVar2 = new l(view);
            weakHashMap.put(view, lVar2);
            return lVar2;
        }
        return lVar;
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f4, Transformation transformation) {
        View view = this.f5843a.get();
        if (view != null) {
            transformation.setAlpha(this.f5846d);
            a(transformation.getMatrix(), view);
        }
    }

    public float b() {
        return this.f5847e;
    }

    public float c() {
        return this.f5848f;
    }

    public float d() {
        return this.f5851i;
    }

    public float e() {
        return this.f5849g;
    }

    public float f() {
        return this.f5850h;
    }

    public float g() {
        return this.f5852j;
    }

    public float h() {
        return this.f5853k;
    }

    public int i() {
        View view = this.f5843a.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollX();
    }

    public int j() {
        View view = this.f5843a.get();
        if (view == null) {
            return 0;
        }
        return view.getScrollY();
    }

    public float k() {
        return this.f5854l;
    }

    public float l() {
        return this.f5855m;
    }

    public float m() {
        View view = this.f5843a.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getLeft() + this.f5854l;
    }

    public float n() {
        View view = this.f5843a.get();
        if (view == null) {
            return 0.0f;
        }
        return view.getTop() + this.f5855m;
    }

    public final void o() {
        View view = this.f5843a.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f5857o;
        a(rectF, view);
        rectF.union(this.f5856n);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    public final void p() {
        View view = this.f5843a.get();
        if (view != null) {
            a(this.f5856n, view);
        }
    }

    public void b(float f4) {
        if (this.f5845c && this.f5847e == f4) {
            return;
        }
        p();
        this.f5845c = true;
        this.f5847e = f4;
        o();
    }

    public void c(float f4) {
        if (this.f5845c && this.f5848f == f4) {
            return;
        }
        p();
        this.f5845c = true;
        this.f5848f = f4;
        o();
    }

    public void d(float f4) {
        if (this.f5851i != f4) {
            p();
            this.f5851i = f4;
            o();
        }
    }

    public void e(float f4) {
        if (this.f5849g != f4) {
            p();
            this.f5849g = f4;
            o();
        }
    }

    public void f(float f4) {
        if (this.f5850h != f4) {
            p();
            this.f5850h = f4;
            o();
        }
    }

    public void g(float f4) {
        if (this.f5852j != f4) {
            p();
            this.f5852j = f4;
            o();
        }
    }

    public void h(float f4) {
        if (this.f5853k != f4) {
            p();
            this.f5853k = f4;
            o();
        }
    }

    public void k(float f4) {
        View view = this.f5843a.get();
        if (view != null) {
            i(f4 - view.getLeft());
        }
    }

    public void l(float f4) {
        View view = this.f5843a.get();
        if (view != null) {
            j(f4 - view.getTop());
        }
    }

    public void i(float f4) {
        if (this.f5854l != f4) {
            p();
            this.f5854l = f4;
            o();
        }
    }

    public void j(float f4) {
        if (this.f5855m != f4) {
            p();
            this.f5855m = f4;
            o();
        }
    }

    public float a() {
        return this.f5846d;
    }

    public void a(float f4) {
        if (this.f5846d != f4) {
            this.f5846d = f4;
            View view = this.f5843a.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    public void b(int i4) {
        View view = this.f5843a.get();
        if (view != null) {
            view.scrollTo(view.getScrollX(), i4);
        }
    }

    public void a(int i4) {
        View view = this.f5843a.get();
        if (view != null) {
            view.scrollTo(i4, view.getScrollY());
        }
    }

    public final void a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f5858p;
        matrix.reset();
        a(matrix, view);
        this.f5858p.mapRect(rectF);
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

    public final void a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z3 = this.f5845c;
        float f4 = z3 ? this.f5847e : width / 2.0f;
        float f5 = z3 ? this.f5848f : height / 2.0f;
        float f6 = this.f5849g;
        float f7 = this.f5850h;
        float f8 = this.f5851i;
        if (f6 != 0.0f || f7 != 0.0f || f8 != 0.0f) {
            Camera camera = this.f5844b;
            camera.save();
            camera.rotateX(f6);
            camera.rotateY(f7);
            camera.rotateZ(-f8);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f4, -f5);
            matrix.postTranslate(f4, f5);
        }
        float f9 = this.f5852j;
        float f10 = this.f5853k;
        if (f9 != 1.0f || f10 != 1.0f) {
            matrix.postScale(f9, f10);
            matrix.postTranslate((-(f4 / width)) * ((f9 * width) - width), (-(f5 / height)) * ((f10 * height) - height));
        }
        matrix.postTranslate(this.f5854l, this.f5855m);
    }
}
