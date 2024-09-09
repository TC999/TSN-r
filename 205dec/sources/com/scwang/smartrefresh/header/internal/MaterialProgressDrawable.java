package com.scwang.smartrefresh.header.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final int A = 1332;
    private static final float B = 5.0f;
    private static final int C = 10;
    private static final int D = 5;
    private static final float E = 5.0f;
    private static final int F = 12;
    private static final int G = 6;
    private static final float H = 0.8f;

    /* renamed from: n  reason: collision with root package name */
    private static final float f47729n = 1080.0f;

    /* renamed from: o  reason: collision with root package name */
    public static final int f47730o = 0;

    /* renamed from: p  reason: collision with root package name */
    public static final int f47731p = 1;

    /* renamed from: q  reason: collision with root package name */
    private static final int f47732q = 40;

    /* renamed from: r  reason: collision with root package name */
    private static final float f47733r = 8.75f;

    /* renamed from: s  reason: collision with root package name */
    private static final float f47734s = 2.5f;

    /* renamed from: t  reason: collision with root package name */
    private static final int f47735t = 56;

    /* renamed from: u  reason: collision with root package name */
    private static final float f47736u = 12.5f;

    /* renamed from: v  reason: collision with root package name */
    private static final float f47737v = 3.0f;

    /* renamed from: x  reason: collision with root package name */
    private static final float f47739x = 0.75f;

    /* renamed from: y  reason: collision with root package name */
    private static final float f47740y = 0.5f;

    /* renamed from: z  reason: collision with root package name */
    private static final float f47741z = 0.5f;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Animation> f47742a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final d f47743b;

    /* renamed from: c  reason: collision with root package name */
    private float f47744c;

    /* renamed from: d  reason: collision with root package name */
    private Resources f47745d;

    /* renamed from: e  reason: collision with root package name */
    private View f47746e;

    /* renamed from: f  reason: collision with root package name */
    private Animation f47747f;

    /* renamed from: g  reason: collision with root package name */
    float f47748g;

    /* renamed from: h  reason: collision with root package name */
    private double f47749h;

    /* renamed from: i  reason: collision with root package name */
    private double f47750i;

    /* renamed from: j  reason: collision with root package name */
    boolean f47751j;

    /* renamed from: k  reason: collision with root package name */
    private final Drawable.Callback f47752k;

    /* renamed from: l  reason: collision with root package name */
    private static final Interpolator f47727l = new LinearInterpolator();

    /* renamed from: m  reason: collision with root package name */
    static final Interpolator f47728m = new com.scwang.smartrefresh.header.internal.a();

    /* renamed from: w  reason: collision with root package name */
    private static final int[] f47738w = {-16777216};

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class a extends Animation {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f47753a;

        a(d dVar) {
            this.f47753a = dVar;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f4, Transformation transformation) {
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (materialProgressDrawable.f47751j) {
                materialProgressDrawable.a(f4, this.f47753a);
                return;
            }
            float c4 = materialProgressDrawable.c(this.f47753a);
            float l4 = this.f47753a.l();
            float n4 = this.f47753a.n();
            float m4 = this.f47753a.m();
            MaterialProgressDrawable.this.n(f4, this.f47753a);
            if (f4 <= 0.5f) {
                Interpolator interpolator = MaterialProgressDrawable.f47728m;
                this.f47753a.F(n4 + ((0.8f - c4) * interpolator.getInterpolation(f4 / 0.5f)));
            }
            if (f4 > 0.5f) {
                Interpolator interpolator2 = MaterialProgressDrawable.f47728m;
                this.f47753a.B(l4 + ((0.8f - c4) * interpolator2.getInterpolation((f4 - 0.5f) / 0.5f)));
            }
            this.f47753a.D(m4 + (0.25f * f4));
            MaterialProgressDrawable materialProgressDrawable2 = MaterialProgressDrawable.this;
            materialProgressDrawable2.i((f4 * 216.0f) + ((materialProgressDrawable2.f47748g / 5.0f) * 1080.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f47755a;

        b(d dVar) {
            this.f47755a = dVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.f47755a.H();
            this.f47755a.p();
            d dVar = this.f47755a;
            dVar.F(dVar.e());
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (materialProgressDrawable.f47751j) {
                materialProgressDrawable.f47751j = false;
                animation.setDuration(1332L);
                this.f47755a.E(false);
                return;
            }
            materialProgressDrawable.f47748g = (materialProgressDrawable.f47748g + 1.0f) % 5.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MaterialProgressDrawable.this.f47748g = 0.0f;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class c implements Drawable.Callback {
        c() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            MaterialProgressDrawable.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j4) {
            MaterialProgressDrawable.this.scheduleSelf(runnable, j4);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            MaterialProgressDrawable.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private final RectF f47758a = new RectF();

        /* renamed from: b  reason: collision with root package name */
        private final Paint f47759b;

        /* renamed from: c  reason: collision with root package name */
        private final Paint f47760c;

        /* renamed from: d  reason: collision with root package name */
        private final Drawable.Callback f47761d;

        /* renamed from: e  reason: collision with root package name */
        private float f47762e;

        /* renamed from: f  reason: collision with root package name */
        private float f47763f;

        /* renamed from: g  reason: collision with root package name */
        private float f47764g;

        /* renamed from: h  reason: collision with root package name */
        private float f47765h;

        /* renamed from: i  reason: collision with root package name */
        private float f47766i;

        /* renamed from: j  reason: collision with root package name */
        private int[] f47767j;

        /* renamed from: k  reason: collision with root package name */
        private int f47768k;

        /* renamed from: l  reason: collision with root package name */
        private float f47769l;

        /* renamed from: m  reason: collision with root package name */
        private float f47770m;

        /* renamed from: n  reason: collision with root package name */
        private float f47771n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f47772o;

        /* renamed from: p  reason: collision with root package name */
        private Path f47773p;

        /* renamed from: q  reason: collision with root package name */
        private float f47774q;

        /* renamed from: r  reason: collision with root package name */
        private double f47775r;

        /* renamed from: s  reason: collision with root package name */
        private int f47776s;

        /* renamed from: t  reason: collision with root package name */
        private int f47777t;

        /* renamed from: u  reason: collision with root package name */
        private int f47778u;

        /* renamed from: v  reason: collision with root package name */
        private final Paint f47779v;

        /* renamed from: w  reason: collision with root package name */
        private int f47780w;

        /* renamed from: x  reason: collision with root package name */
        private int f47781x;

        d(Drawable.Callback callback) {
            Paint paint = new Paint();
            this.f47759b = paint;
            Paint paint2 = new Paint();
            this.f47760c = paint2;
            this.f47762e = 0.0f;
            this.f47763f = 0.0f;
            this.f47764g = 0.0f;
            this.f47765h = 5.0f;
            this.f47766i = 2.5f;
            this.f47779v = new Paint(1);
            this.f47761d = callback;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        private void b(Canvas canvas, float f4, float f5, Rect rect) {
            if (this.f47772o) {
                Path path = this.f47773p;
                if (path == null) {
                    Path path2 = new Path();
                    this.f47773p = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f6 = (((int) this.f47766i) / 2) * this.f47774q;
                double cos = this.f47775r * Math.cos(0.0d);
                double exactCenterX = rect.exactCenterX();
                Double.isNaN(exactCenterX);
                double sin = this.f47775r * Math.sin(0.0d);
                double exactCenterY = rect.exactCenterY();
                Double.isNaN(exactCenterY);
                float f7 = (float) (sin + exactCenterY);
                this.f47773p.moveTo(0.0f, 0.0f);
                this.f47773p.lineTo(this.f47776s * this.f47774q, 0.0f);
                Path path3 = this.f47773p;
                float f8 = this.f47774q;
                path3.lineTo((this.f47776s * f8) / 2.0f, this.f47777t * f8);
                this.f47773p.offset(((float) (cos + exactCenterX)) - f6, f7);
                this.f47773p.close();
                this.f47760c.setColor(this.f47781x);
                canvas.rotate((f4 + f5) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f47773p, this.f47760c);
            }
        }

        private int h() {
            return (this.f47768k + 1) % this.f47767j.length;
        }

        private void q() {
            this.f47761d.invalidateDrawable(null);
        }

        public void A(@NonNull int[] iArr) {
            this.f47767j = iArr;
            z(0);
        }

        public void B(float f4) {
            this.f47763f = f4;
            q();
        }

        public void C(int i4, int i5) {
            double ceil;
            float min = Math.min(i4, i5);
            double d4 = this.f47775r;
            if (d4 > 0.0d && min >= 0.0f) {
                double d5 = min / 2.0f;
                Double.isNaN(d5);
                ceil = d5 - d4;
            } else {
                ceil = Math.ceil(this.f47765h / 2.0f);
            }
            this.f47766i = (float) ceil;
        }

        public void D(float f4) {
            this.f47764g = f4;
            q();
        }

        public void E(boolean z3) {
            if (this.f47772o != z3) {
                this.f47772o = z3;
                q();
            }
        }

        public void F(float f4) {
            this.f47762e = f4;
            q();
        }

        public void G(float f4) {
            this.f47765h = f4;
            this.f47759b.setStrokeWidth(f4);
            q();
        }

        public void H() {
            this.f47769l = this.f47762e;
            this.f47770m = this.f47763f;
            this.f47771n = this.f47764g;
        }

        public void a(Canvas canvas, Rect rect) {
            RectF rectF = this.f47758a;
            rectF.set(rect);
            float f4 = this.f47766i;
            rectF.inset(f4, f4);
            float f5 = this.f47762e;
            float f6 = this.f47764g;
            float f7 = (f5 + f6) * 360.0f;
            float f8 = ((this.f47763f + f6) * 360.0f) - f7;
            if (f8 != 0.0f) {
                this.f47759b.setColor(this.f47781x);
                canvas.drawArc(rectF, f7, f8, false, this.f47759b);
            }
            b(canvas, f7, f8, rect);
            if (this.f47778u < 255) {
                this.f47779v.setColor(this.f47780w);
                this.f47779v.setAlpha(255 - this.f47778u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.f47779v);
            }
        }

        public int c() {
            return this.f47778u;
        }

        public double d() {
            return this.f47775r;
        }

        public float e() {
            return this.f47763f;
        }

        public float f() {
            return this.f47766i;
        }

        public int g() {
            return this.f47767j[h()];
        }

        public float i() {
            return this.f47764g;
        }

        public float j() {
            return this.f47762e;
        }

        public int k() {
            return this.f47767j[this.f47768k];
        }

        public float l() {
            return this.f47770m;
        }

        public float m() {
            return this.f47771n;
        }

        public float n() {
            return this.f47769l;
        }

        public float o() {
            return this.f47765h;
        }

        public void p() {
            z(h());
        }

        public void r() {
            this.f47769l = 0.0f;
            this.f47770m = 0.0f;
            this.f47771n = 0.0f;
            F(0.0f);
            B(0.0f);
            D(0.0f);
        }

        public void s(int i4) {
            this.f47778u = i4;
        }

        public void t(float f4, float f5) {
            this.f47776s = (int) f4;
            this.f47777t = (int) f5;
        }

        public void u(float f4) {
            if (f4 != this.f47774q) {
                this.f47774q = f4;
                q();
            }
        }

        public void v(@ColorInt int i4) {
            this.f47780w = i4;
        }

        public void w(double d4) {
            this.f47775r = d4;
        }

        public void x(int i4) {
            this.f47781x = i4;
        }

        public void y(ColorFilter colorFilter) {
            this.f47759b.setColorFilter(colorFilter);
            q();
        }

        public void z(int i4) {
            this.f47768k = i4;
            this.f47781x = this.f47767j[i4];
        }
    }

    public MaterialProgressDrawable(Context context, View view) {
        c cVar = new c();
        this.f47752k = cVar;
        this.f47746e = view;
        this.f47745d = context.getResources();
        d dVar = new d(cVar);
        this.f47743b = dVar;
        dVar.A(f47738w);
        o(1);
        l();
    }

    private int b(float f4, int i4, int i5) {
        int intValue = Integer.valueOf(i4).intValue();
        int i6 = (intValue >> 24) & 255;
        int i7 = (intValue >> 16) & 255;
        int i8 = (intValue >> 8) & 255;
        int i9 = intValue & 255;
        int intValue2 = Integer.valueOf(i5).intValue();
        return ((i6 + ((int) ((((intValue2 >> 24) & 255) - i6) * f4))) << 24) | ((i7 + ((int) ((((intValue2 >> 16) & 255) - i7) * f4))) << 16) | ((i8 + ((int) ((((intValue2 >> 8) & 255) - i8) * f4))) << 8) | (i9 + ((int) (f4 * ((intValue2 & 255) - i9))));
    }

    private float d() {
        return this.f47744c;
    }

    private void j(double d4, double d5, double d6, double d7, float f4, float f5) {
        d dVar = this.f47743b;
        float f6 = this.f47745d.getDisplayMetrics().density;
        double d8 = f6;
        Double.isNaN(d8);
        this.f47749h = d4 * d8;
        Double.isNaN(d8);
        this.f47750i = d5 * d8;
        dVar.G(((float) d7) * f6);
        Double.isNaN(d8);
        dVar.w(d6 * d8);
        dVar.z(0);
        dVar.t(f4 * f6, f5 * f6);
        dVar.C((int) this.f47749h, (int) this.f47750i);
    }

    private void l() {
        d dVar = this.f47743b;
        a aVar = new a(dVar);
        aVar.setRepeatCount(-1);
        aVar.setRepeatMode(1);
        aVar.setInterpolator(f47727l);
        aVar.setAnimationListener(new b(dVar));
        this.f47747f = aVar;
    }

    void a(float f4, d dVar) {
        n(f4, dVar);
        dVar.F(dVar.n() + (((dVar.l() - c(dVar)) - dVar.n()) * f4));
        dVar.B(dVar.l());
        dVar.D(dVar.m() + ((((float) (Math.floor(dVar.m() / 0.8f) + 1.0d)) - dVar.m()) * f4));
    }

    float c(d dVar) {
        double o4 = dVar.o();
        Double.isNaN(o4);
        return (float) Math.toRadians(o4 / (dVar.d() * 6.283185307179586d));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f47744c, bounds.exactCenterX(), bounds.exactCenterY());
        this.f47743b.a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void e(float f4) {
        this.f47743b.u(f4);
    }

    public void f(@ColorInt int i4) {
        this.f47743b.v(i4);
    }

    public void g(int... iArr) {
        this.f47743b.A(iArr);
        this.f47743b.z(0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f47743b.c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f47750i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f47749h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h(float f4) {
        this.f47743b.D(f4);
    }

    void i(float f4) {
        this.f47744c = f4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f47742a;
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            Animation animation = arrayList.get(i4);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void k(float f4, float f5) {
        this.f47743b.F(f4);
        this.f47743b.B(f5);
    }

    public void m(boolean z3) {
        this.f47743b.E(z3);
    }

    void n(float f4, d dVar) {
        if (f4 > 0.75f) {
            dVar.x(b((f4 - 0.75f) / 0.25f, dVar.k(), dVar.g()));
        }
    }

    public void o(int i4) {
        if (i4 == 0) {
            j(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            j(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f47743b.s(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f47743b.y(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f47747f.reset();
        this.f47743b.H();
        if (this.f47743b.e() != this.f47743b.j()) {
            this.f47751j = true;
            this.f47747f.setDuration(666L);
            this.f47746e.startAnimation(this.f47747f);
            return;
        }
        this.f47743b.z(0);
        this.f47743b.r();
        this.f47747f.setDuration(1332L);
        this.f47746e.startAnimation(this.f47747f);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f47746e.clearAnimation();
        i(0.0f);
        this.f47743b.E(false);
        this.f47743b.z(0);
        this.f47743b.r();
    }
}
