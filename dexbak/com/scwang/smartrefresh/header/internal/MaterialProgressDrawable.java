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
import androidx.core.view.ViewCompat;
import com.github.mikephil.charting.utils.Utils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable {

    /* renamed from: A */
    private static final int f33334A = 1332;

    /* renamed from: B */
    private static final float f33335B = 5.0f;

    /* renamed from: C */
    private static final int f33336C = 10;

    /* renamed from: D */
    private static final int f33337D = 5;

    /* renamed from: E */
    private static final float f33338E = 5.0f;

    /* renamed from: F */
    private static final int f33339F = 12;

    /* renamed from: G */
    private static final int f33340G = 6;

    /* renamed from: H */
    private static final float f33341H = 0.8f;

    /* renamed from: n */
    private static final float f33344n = 1080.0f;

    /* renamed from: o */
    public static final int f33345o = 0;

    /* renamed from: p */
    public static final int f33346p = 1;

    /* renamed from: q */
    private static final int f33347q = 40;

    /* renamed from: r */
    private static final float f33348r = 8.75f;

    /* renamed from: s */
    private static final float f33349s = 2.5f;

    /* renamed from: t */
    private static final int f33350t = 56;

    /* renamed from: u */
    private static final float f33351u = 12.5f;

    /* renamed from: v */
    private static final float f33352v = 3.0f;

    /* renamed from: x */
    private static final float f33354x = 0.75f;

    /* renamed from: y */
    private static final float f33355y = 0.5f;

    /* renamed from: z */
    private static final float f33356z = 0.5f;

    /* renamed from: a */
    private final ArrayList<Animation> f33357a = new ArrayList<>();

    /* renamed from: b */
    private final C11874d f33358b;

    /* renamed from: c */
    private float f33359c;

    /* renamed from: d */
    private Resources f33360d;

    /* renamed from: e */
    private View f33361e;

    /* renamed from: f */
    private Animation f33362f;

    /* renamed from: g */
    float f33363g;

    /* renamed from: h */
    private double f33364h;

    /* renamed from: i */
    private double f33365i;

    /* renamed from: j */
    boolean f33366j;

    /* renamed from: k */
    private final Drawable.Callback f33367k;

    /* renamed from: l */
    private static final Interpolator f33342l = new LinearInterpolator();

    /* renamed from: m */
    static final Interpolator f33343m = new FastOutSlowInInterpolator();

    /* renamed from: w */
    private static final int[] f33353w = {ViewCompat.MEASURED_STATE_MASK};

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.internal.MaterialProgressDrawable$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11871a extends Animation {

        /* renamed from: a */
        final /* synthetic */ C11874d f33368a;

        C11871a(C11874d c11874d) {
            this.f33368a = c11874d;
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f, Transformation transformation) {
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (materialProgressDrawable.f33366j) {
                materialProgressDrawable.m20084a(f, this.f33368a);
                return;
            }
            float m20082c = materialProgressDrawable.m20082c(this.f33368a);
            float m20050l = this.f33368a.m20050l();
            float m20048n = this.f33368a.m20048n();
            float m20049m = this.f33368a.m20049m();
            MaterialProgressDrawable.this.m20071n(f, this.f33368a);
            if (f <= 0.5f) {
                float f2 = MaterialProgressDrawable.f33341H - m20082c;
                Interpolator interpolator = MaterialProgressDrawable.f33343m;
                this.f33368a.m20064F(m20048n + (f2 * interpolator.getInterpolation(f / 0.5f)));
            }
            if (f > 0.5f) {
                float f3 = MaterialProgressDrawable.f33341H - m20082c;
                Interpolator interpolator2 = MaterialProgressDrawable.f33343m;
                this.f33368a.m20068B(m20050l + (f3 * interpolator2.getInterpolation((f - 0.5f) / 0.5f)));
            }
            this.f33368a.m20066D(m20049m + (0.25f * f));
            MaterialProgressDrawable materialProgressDrawable2 = MaterialProgressDrawable.this;
            materialProgressDrawable2.m20076i((f * 216.0f) + ((materialProgressDrawable2.f33363g / 5.0f) * MaterialProgressDrawable.f33344n));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.internal.MaterialProgressDrawable$b  reason: invalid class name */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class animationAnimation$AnimationListenerC11872b implements Animation.AnimationListener {

        /* renamed from: a */
        final /* synthetic */ C11874d f33370a;

        animationAnimation$AnimationListenerC11872b(C11874d c11874d) {
            this.f33370a = c11874d;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            this.f33370a.m20062H();
            this.f33370a.m20046p();
            C11874d c11874d = this.f33370a;
            c11874d.m20064F(c11874d.m20057e());
            MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
            if (materialProgressDrawable.f33366j) {
                materialProgressDrawable.f33366j = false;
                animation.setDuration(1332L);
                this.f33370a.m20065E(false);
                return;
            }
            materialProgressDrawable.f33363g = (materialProgressDrawable.f33363g + 1.0f) % 5.0f;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            MaterialProgressDrawable.this.f33363g = 0.0f;
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.internal.MaterialProgressDrawable$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11873c implements Drawable.Callback {
        C11873c() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            MaterialProgressDrawable.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            MaterialProgressDrawable.this.scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            MaterialProgressDrawable.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.scwang.smartrefresh.header.internal.MaterialProgressDrawable$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C11874d {

        /* renamed from: a */
        private final RectF f33373a = new RectF();

        /* renamed from: b */
        private final Paint f33374b;

        /* renamed from: c */
        private final Paint f33375c;

        /* renamed from: d */
        private final Drawable.Callback f33376d;

        /* renamed from: e */
        private float f33377e;

        /* renamed from: f */
        private float f33378f;

        /* renamed from: g */
        private float f33379g;

        /* renamed from: h */
        private float f33380h;

        /* renamed from: i */
        private float f33381i;

        /* renamed from: j */
        private int[] f33382j;

        /* renamed from: k */
        private int f33383k;

        /* renamed from: l */
        private float f33384l;

        /* renamed from: m */
        private float f33385m;

        /* renamed from: n */
        private float f33386n;

        /* renamed from: o */
        private boolean f33387o;

        /* renamed from: p */
        private Path f33388p;

        /* renamed from: q */
        private float f33389q;

        /* renamed from: r */
        private double f33390r;

        /* renamed from: s */
        private int f33391s;

        /* renamed from: t */
        private int f33392t;

        /* renamed from: u */
        private int f33393u;

        /* renamed from: v */
        private final Paint f33394v;

        /* renamed from: w */
        private int f33395w;

        /* renamed from: x */
        private int f33396x;

        C11874d(Drawable.Callback callback) {
            Paint paint = new Paint();
            this.f33374b = paint;
            Paint paint2 = new Paint();
            this.f33375c = paint2;
            this.f33377e = 0.0f;
            this.f33378f = 0.0f;
            this.f33379g = 0.0f;
            this.f33380h = 5.0f;
            this.f33381i = MaterialProgressDrawable.f33349s;
            this.f33394v = new Paint(1);
            this.f33376d = callback;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        /* renamed from: b */
        private void m20060b(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f33387o) {
                Path path = this.f33388p;
                if (path == null) {
                    Path path2 = new Path();
                    this.f33388p = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = (((int) this.f33381i) / 2) * this.f33389q;
                double cos = this.f33390r * Math.cos(Utils.DOUBLE_EPSILON);
                double exactCenterX = rect.exactCenterX();
                Double.isNaN(exactCenterX);
                double sin = this.f33390r * Math.sin(Utils.DOUBLE_EPSILON);
                double exactCenterY = rect.exactCenterY();
                Double.isNaN(exactCenterY);
                float f4 = (float) (sin + exactCenterY);
                this.f33388p.moveTo(0.0f, 0.0f);
                this.f33388p.lineTo(this.f33391s * this.f33389q, 0.0f);
                Path path3 = this.f33388p;
                float f5 = this.f33389q;
                path3.lineTo((this.f33391s * f5) / 2.0f, this.f33392t * f5);
                this.f33388p.offset(((float) (cos + exactCenterX)) - f3, f4);
                this.f33388p.close();
                this.f33375c.setColor(this.f33396x);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f33388p, this.f33375c);
            }
        }

        /* renamed from: h */
        private int m20054h() {
            return (this.f33383k + 1) % this.f33382j.length;
        }

        /* renamed from: q */
        private void m20045q() {
            this.f33376d.invalidateDrawable(null);
        }

        /* renamed from: A */
        public void m20069A(@NonNull int[] iArr) {
            this.f33382j = iArr;
            m20036z(0);
        }

        /* renamed from: B */
        public void m20068B(float f) {
            this.f33378f = f;
            m20045q();
        }

        /* renamed from: C */
        public void m20067C(int i, int i2) {
            double ceil;
            float min = Math.min(i, i2);
            double d = this.f33390r;
            if (d > Utils.DOUBLE_EPSILON && min >= 0.0f) {
                double d2 = min / 2.0f;
                Double.isNaN(d2);
                ceil = d2 - d;
            } else {
                ceil = Math.ceil(this.f33380h / 2.0f);
            }
            this.f33381i = (float) ceil;
        }

        /* renamed from: D */
        public void m20066D(float f) {
            this.f33379g = f;
            m20045q();
        }

        /* renamed from: E */
        public void m20065E(boolean z) {
            if (this.f33387o != z) {
                this.f33387o = z;
                m20045q();
            }
        }

        /* renamed from: F */
        public void m20064F(float f) {
            this.f33377e = f;
            m20045q();
        }

        /* renamed from: G */
        public void m20063G(float f) {
            this.f33380h = f;
            this.f33374b.setStrokeWidth(f);
            m20045q();
        }

        /* renamed from: H */
        public void m20062H() {
            this.f33384l = this.f33377e;
            this.f33385m = this.f33378f;
            this.f33386n = this.f33379g;
        }

        /* renamed from: a */
        public void m20061a(Canvas canvas, Rect rect) {
            RectF rectF = this.f33373a;
            rectF.set(rect);
            float f = this.f33381i;
            rectF.inset(f, f);
            float f2 = this.f33377e;
            float f3 = this.f33379g;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.f33378f + f3) * 360.0f) - f4;
            if (f5 != 0.0f) {
                this.f33374b.setColor(this.f33396x);
                canvas.drawArc(rectF, f4, f5, false, this.f33374b);
            }
            m20060b(canvas, f4, f5, rect);
            if (this.f33393u < 255) {
                this.f33394v.setColor(this.f33395w);
                this.f33394v.setAlpha(255 - this.f33393u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.f33394v);
            }
        }

        /* renamed from: c */
        public int m20059c() {
            return this.f33393u;
        }

        /* renamed from: d */
        public double m20058d() {
            return this.f33390r;
        }

        /* renamed from: e */
        public float m20057e() {
            return this.f33378f;
        }

        /* renamed from: f */
        public float m20056f() {
            return this.f33381i;
        }

        /* renamed from: g */
        public int m20055g() {
            return this.f33382j[m20054h()];
        }

        /* renamed from: i */
        public float m20053i() {
            return this.f33379g;
        }

        /* renamed from: j */
        public float m20052j() {
            return this.f33377e;
        }

        /* renamed from: k */
        public int m20051k() {
            return this.f33382j[this.f33383k];
        }

        /* renamed from: l */
        public float m20050l() {
            return this.f33385m;
        }

        /* renamed from: m */
        public float m20049m() {
            return this.f33386n;
        }

        /* renamed from: n */
        public float m20048n() {
            return this.f33384l;
        }

        /* renamed from: o */
        public float m20047o() {
            return this.f33380h;
        }

        /* renamed from: p */
        public void m20046p() {
            m20036z(m20054h());
        }

        /* renamed from: r */
        public void m20044r() {
            this.f33384l = 0.0f;
            this.f33385m = 0.0f;
            this.f33386n = 0.0f;
            m20064F(0.0f);
            m20068B(0.0f);
            m20066D(0.0f);
        }

        /* renamed from: s */
        public void m20043s(int i) {
            this.f33393u = i;
        }

        /* renamed from: t */
        public void m20042t(float f, float f2) {
            this.f33391s = (int) f;
            this.f33392t = (int) f2;
        }

        /* renamed from: u */
        public void m20041u(float f) {
            if (f != this.f33389q) {
                this.f33389q = f;
                m20045q();
            }
        }

        /* renamed from: v */
        public void m20040v(@ColorInt int i) {
            this.f33395w = i;
        }

        /* renamed from: w */
        public void m20039w(double d) {
            this.f33390r = d;
        }

        /* renamed from: x */
        public void m20038x(int i) {
            this.f33396x = i;
        }

        /* renamed from: y */
        public void m20037y(ColorFilter colorFilter) {
            this.f33374b.setColorFilter(colorFilter);
            m20045q();
        }

        /* renamed from: z */
        public void m20036z(int i) {
            this.f33383k = i;
            this.f33396x = this.f33382j[i];
        }
    }

    public MaterialProgressDrawable(Context context, View view) {
        C11873c c11873c = new C11873c();
        this.f33367k = c11873c;
        this.f33361e = view;
        this.f33360d = context.getResources();
        C11874d c11874d = new C11874d(c11873c);
        this.f33358b = c11874d;
        c11874d.m20069A(f33353w);
        m20070o(1);
        m20073l();
    }

    /* renamed from: b */
    private int m20083b(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        int i6 = intValue & 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return ((i3 + ((int) ((((intValue2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((intValue2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((intValue2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((intValue2 & 255) - i6))));
    }

    /* renamed from: d */
    private float m20081d() {
        return this.f33359c;
    }

    /* renamed from: j */
    private void m20075j(double d, double d2, double d3, double d4, float f, float f2) {
        C11874d c11874d = this.f33358b;
        float f3 = this.f33360d.getDisplayMetrics().density;
        double d5 = f3;
        Double.isNaN(d5);
        this.f33364h = d * d5;
        Double.isNaN(d5);
        this.f33365i = d2 * d5;
        c11874d.m20063G(((float) d4) * f3);
        Double.isNaN(d5);
        c11874d.m20039w(d3 * d5);
        c11874d.m20036z(0);
        c11874d.m20042t(f * f3, f2 * f3);
        c11874d.m20067C((int) this.f33364h, (int) this.f33365i);
    }

    /* renamed from: l */
    private void m20073l() {
        C11874d c11874d = this.f33358b;
        C11871a c11871a = new C11871a(c11874d);
        c11871a.setRepeatCount(-1);
        c11871a.setRepeatMode(1);
        c11871a.setInterpolator(f33342l);
        c11871a.setAnimationListener(new animationAnimation$AnimationListenerC11872b(c11874d));
        this.f33362f = c11871a;
    }

    /* renamed from: a */
    void m20084a(float f, C11874d c11874d) {
        m20071n(f, c11874d);
        c11874d.m20064F(c11874d.m20048n() + (((c11874d.m20050l() - m20082c(c11874d)) - c11874d.m20048n()) * f));
        c11874d.m20068B(c11874d.m20050l());
        c11874d.m20066D(c11874d.m20049m() + ((((float) (Math.floor(c11874d.m20049m() / f33341H) + 1.0d)) - c11874d.m20049m()) * f));
    }

    /* renamed from: c */
    float m20082c(C11874d c11874d) {
        double m20047o = c11874d.m20047o();
        Double.isNaN(m20047o);
        return (float) Math.toRadians(m20047o / (c11874d.m20058d() * 6.283185307179586d));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f33359c, bounds.exactCenterX(), bounds.exactCenterY());
        this.f33358b.m20061a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    /* renamed from: e */
    public void m20080e(float f) {
        this.f33358b.m20041u(f);
    }

    /* renamed from: f */
    public void m20079f(@ColorInt int i) {
        this.f33358b.m20040v(i);
    }

    /* renamed from: g */
    public void m20078g(int... iArr) {
        this.f33358b.m20069A(iArr);
        this.f33358b.m20036z(0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f33358b.m20059c();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f33365i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.f33364h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* renamed from: h */
    public void m20077h(float f) {
        this.f33358b.m20066D(f);
    }

    /* renamed from: i */
    void m20076i(float f) {
        this.f33359c = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.f33357a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public void m20074k(float f, float f2) {
        this.f33358b.m20064F(f);
        this.f33358b.m20068B(f2);
    }

    /* renamed from: m */
    public void m20072m(boolean z) {
        this.f33358b.m20065E(z);
    }

    /* renamed from: n */
    void m20071n(float f, C11874d c11874d) {
        if (f > 0.75f) {
            c11874d.m20038x(m20083b((f - 0.75f) / 0.25f, c11874d.m20051k(), c11874d.m20055g()));
        }
    }

    /* renamed from: o */
    public void m20070o(int i) {
        if (i == 0) {
            m20075j(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m20075j(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f33358b.m20043s(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f33358b.m20037y(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f33362f.reset();
        this.f33358b.m20062H();
        if (this.f33358b.m20057e() != this.f33358b.m20052j()) {
            this.f33366j = true;
            this.f33362f.setDuration(666L);
            this.f33361e.startAnimation(this.f33362f);
            return;
        }
        this.f33358b.m20036z(0);
        this.f33358b.m20044r();
        this.f33362f.setDuration(1332L);
        this.f33361e.startAnimation(this.f33362f);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f33361e.clearAnimation();
        m20076i(0.0f);
        this.f33358b.m20065E(false);
        this.f33358b.m20036z(0);
        this.f33358b.m20044r();
    }
}
