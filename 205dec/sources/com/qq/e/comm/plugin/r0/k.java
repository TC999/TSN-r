package com.qq.e.comm.plugin.r0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.HashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k extends View {
    private GradientDrawable A;
    private GradientDrawable B;
    private GradientDrawable C;
    private GradientDrawable D;
    private GradientDrawable E;
    private GradientDrawable F;
    private GradientDrawable G;
    private GradientDrawable H;
    private GradientDrawable I;
    private Bitmap J;
    private Bitmap K;

    /* renamed from: L  reason: collision with root package name */
    private Bitmap f45745L;
    private boolean M;
    private boolean N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private final HashMap<Integer, Integer> S;
    private Paint T;
    private float U;
    private float V;
    private InterfaceC0885k W;

    /* renamed from: a0  reason: collision with root package name */
    private String f45746a0;

    /* renamed from: b0  reason: collision with root package name */
    private boolean f45747b0;

    /* renamed from: c  reason: collision with root package name */
    private i f45748c;

    /* renamed from: c0  reason: collision with root package name */
    private int f45749c0;

    /* renamed from: d  reason: collision with root package name */
    private Paint f45750d;

    /* renamed from: d0  reason: collision with root package name */
    private int f45751d0;

    /* renamed from: e  reason: collision with root package name */
    private final Paint f45752e;

    /* renamed from: e0  reason: collision with root package name */
    private int f45753e0;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f45754f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f45755g;

    /* renamed from: h  reason: collision with root package name */
    private Path f45756h;

    /* renamed from: i  reason: collision with root package name */
    private Path f45757i;

    /* renamed from: j  reason: collision with root package name */
    private j f45758j;

    /* renamed from: k  reason: collision with root package name */
    private j f45759k;

    /* renamed from: l  reason: collision with root package name */
    private j f45760l;

    /* renamed from: m  reason: collision with root package name */
    private j f45761m;

    /* renamed from: n  reason: collision with root package name */
    private j f45762n;

    /* renamed from: o  reason: collision with root package name */
    private j f45763o;

    /* renamed from: p  reason: collision with root package name */
    private j f45764p;

    /* renamed from: q  reason: collision with root package name */
    private j f45765q;

    /* renamed from: r  reason: collision with root package name */
    private j f45766r;

    /* renamed from: s  reason: collision with root package name */
    private j f45767s;

    /* renamed from: t  reason: collision with root package name */
    private j f45768t;

    /* renamed from: u  reason: collision with root package name */
    private float f45769u;

    /* renamed from: v  reason: collision with root package name */
    private float f45770v;

    /* renamed from: w  reason: collision with root package name */
    private int f45771w;

    /* renamed from: x  reason: collision with root package name */
    private int f45772x;

    /* renamed from: y  reason: collision with root package name */
    private final float[] f45773y;

    /* renamed from: z  reason: collision with root package name */
    private Matrix f45774z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            k.this.b(pointF.x, pointF.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            k.this.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            PointF pointF = (PointF) valueAnimator.getAnimatedValue();
            k.this.b(pointF.x, pointF.y);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class e extends AnimatorListenerAdapter {
        e() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            k.this.m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class f implements TypeEvaluator<PointF> {
        f() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public PointF evaluate(float f4, PointF pointF, PointF pointF2) {
            float f5 = pointF.x;
            float f6 = pointF.y;
            float f7 = pointF2.x;
            float f8 = pointF2.y;
            float f9 = f5 + ((f7 - f5) * f4);
            if (f9 > f7 - (f7 / 4.0f)) {
                f8 = ((f8 - f6) * f4) + f6;
            }
            return new PointF(f9, f8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class g implements TypeEvaluator<PointF> {
        g() {
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a */
        public PointF evaluate(float f4, PointF pointF, PointF pointF2) {
            float f5 = pointF.x;
            float f6 = pointF.y;
            return new PointF(f5 + ((pointF2.x - f5) * f4), f6 + ((pointF2.y - f6) * f4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f45782a;

        static {
            int[] iArr = new int[i.values().length];
            f45782a = iArr;
            try {
                iArr[i.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45782a[i.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45782a[i.TOP_RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45782a[i.CENTER_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45782a[i.BOTTOM_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public enum i {
        LEFT,
        RIGHT,
        TOP_RIGHT,
        CENTER_RIGHT,
        BOTTOM_RIGHT,
        NONE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class j {

        /* renamed from: a  reason: collision with root package name */
        float f45790a;

        /* renamed from: b  reason: collision with root package name */
        float f45791b;

        j() {
        }

        j(float f4, float f5) {
            this.f45790a = f4;
            this.f45791b = f5;
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.r0.k$k  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface InterfaceC0885k {
        void a();

        void a(float f4);

        void b();

        void first();

        void last();
    }

    public k(Context context) {
        super(context);
        this.f45748c = i.NONE;
        this.f45752e = new Paint();
        this.f45754f = new Paint();
        this.f45755g = new Paint();
        this.f45769u = 0.0f;
        this.f45770v = 0.0f;
        this.f45773y = new float[9];
        this.M = true;
        this.N = true;
        this.O = 0;
        this.P = 0;
        this.R = 0;
        this.S = new HashMap<>();
        this.f45746a0 = "";
        this.f45747b0 = true;
        this.f45749c0 = 2;
        this.f45751d0 = 400;
        this.f45753e0 = 5;
        j();
    }

    private Path h() {
        Path path = this.f45756h;
        if (path == null) {
            this.f45756h = new Path();
        } else {
            path.reset();
        }
        this.f45756h.lineTo(0.0f, this.f45772x);
        this.f45756h.lineTo(this.f45771w, this.f45772x);
        this.f45756h.lineTo(this.f45771w, 0.0f);
        this.f45756h.close();
        return this.f45756h;
    }

    private TypeEvaluator<PointF> i() {
        return new f();
    }

    private void j() {
        Paint paint = new Paint();
        this.T = paint;
        paint.setAntiAlias(true);
        this.T.setColor(-16777216);
        this.U = 14.0f;
        this.V = 10.0f;
        this.f45758j = new j();
        this.f45759k = new j();
        this.f45760l = new j();
        this.f45761m = new j();
        this.f45762n = new j();
        this.f45763o = new j();
        this.f45764p = new j();
        this.f45765q = new j();
        this.f45766r = new j();
        this.f45767s = new j();
        this.f45768t = new j();
        Paint paint2 = new Paint();
        this.f45750d = paint2;
        paint2.setColor(-16777216);
        this.f45750d.setAntiAlias(true);
        this.f45754f.setColor(-16777216);
        this.f45755g.setColor(-1);
        this.f45774z = new Matrix();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.P = this.Q;
        this.W.a();
        this.R++;
        j jVar = this.f45758j;
        jVar.f45790a = -1.0f;
        jVar.f45791b = -1.0f;
        q();
    }

    private boolean l() {
        if (this.P == 0) {
            this.W.first();
            return false;
        }
        int i4 = this.R - 1;
        this.R = i4;
        if (this.S.containsKey(Integer.valueOf(i4))) {
            this.P = this.S.get(Integer.valueOf(this.R)).intValue();
        } else {
            r();
        }
        this.W.b();
        q();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        j jVar = this.f45758j;
        jVar.f45790a = -1.0f;
        jVar.f45791b = -1.0f;
        invalidate();
    }

    private void n() {
        ValueAnimator ofObject;
        int i4 = h.f45782a[this.f45748c.ordinal()];
        if (i4 == 3) {
            TypeEvaluator<PointF> d4 = d();
            j jVar = this.f45758j;
            ofObject = ValueAnimator.ofObject(d4, new PointF(jVar.f45790a, jVar.f45791b), new PointF(this.f45771w, 0.0f));
        } else if (i4 == 4 || i4 == 5) {
            TypeEvaluator<PointF> d5 = d();
            j jVar2 = this.f45758j;
            ofObject = ValueAnimator.ofObject(d5, new PointF(jVar2.f45790a, jVar2.f45791b), new PointF(this.f45771w, this.f45772x));
        } else {
            ofObject = null;
        }
        if (ofObject == null) {
            return;
        }
        ofObject.setDuration(300L);
        ofObject.setInterpolator(new LinearInterpolator());
        ofObject.addUpdateListener(new d());
        ofObject.addListener(new e());
        ofObject.start();
    }

    private void o() {
        if (l()) {
            int i4 = this.f45771w;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i4 / 5.0f, i4 - 1);
            ofFloat.setDuration(300L);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.addUpdateListener(new c());
            ofFloat.start();
        }
    }

    private void p() {
        ValueAnimator ofObject;
        int i4 = h.f45782a[this.f45748c.ordinal()];
        if (i4 == 3) {
            TypeEvaluator<PointF> i5 = i();
            j jVar = this.f45758j;
            ofObject = ValueAnimator.ofObject(i5, new PointF(jVar.f45790a, jVar.f45791b), new PointF((-this.f45771w) / 2.0f, 0.0f));
        } else if (i4 == 4 || i4 == 5) {
            TypeEvaluator<PointF> i6 = i();
            j jVar2 = this.f45758j;
            ofObject = ValueAnimator.ofObject(i6, new PointF(jVar2.f45790a, jVar2.f45791b), new PointF((-this.f45771w) / 2.0f, this.f45772x));
        } else {
            ofObject = null;
        }
        if (ofObject == null) {
            return;
        }
        ofObject.setDuration(300L);
        ofObject.setInterpolator(new AccelerateDecelerateInterpolator());
        ofObject.addUpdateListener(new a());
        ofObject.addListener(new b());
        ofObject.start();
    }

    private void r() {
        int i4;
        int i5;
        int i6 = this.P - 1;
        float width = getWidth();
        float height = getHeight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        if (Build.VERSION.SDK_INT >= 17) {
            i4 = getPaddingStart();
            i5 = getPaddingEnd();
        } else {
            i4 = 0;
            i5 = 0;
        }
        float f4 = height - paddingBottom;
        this.T.setTextSize(this.U);
        while (f4 >= this.U + paddingTop && i6 >= 0) {
            float f5 = 0.0f;
            int i7 = i6;
            int i8 = 0;
            while (true) {
                if (i7 >= 0) {
                    String substring = this.f45746a0.substring(i7, i7 + 1);
                    if (substring.equals("\n")) {
                        i8++;
                        break;
                    }
                    f5 += a(this.T, substring);
                    if (f5 >= (width - i4) - i5) {
                        break;
                    }
                    i8++;
                    i7--;
                }
            }
            i6 -= i8;
            f4 -= this.U + this.V;
        }
        this.P = Math.max(i6 - 1, 0);
    }

    public void c(float f4) {
        this.U = f4;
    }

    public void d(int i4) {
        if (i4 <= 0 || i4 >= 50) {
            this.f45747b0 = false;
        }
        this.f45749c0 = i4;
    }

    public void e(int i4) {
        if (i4 <= 0) {
            this.f45747b0 = false;
        }
        this.f45751d0 = i4;
    }

    public void f(int i4) {
        if (i4 <= 0) {
            this.f45747b0 = false;
        }
        this.f45753e0 = i4;
    }

    public void g(int i4) {
        this.T.setColor(i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f45746a0.length() == 0) {
            return;
        }
        j jVar = this.f45758j;
        if (jVar.f45790a == -1.0f && jVar.f45791b == -1.0f) {
            a(canvas, h());
            return;
        }
        j jVar2 = this.f45759k;
        if (jVar2.f45790a == this.f45771w && jVar2.f45791b == 0.0f) {
            a(canvas, f());
            f(canvas, f());
            e(canvas, f());
            return;
        }
        j jVar3 = this.f45759k;
        if (jVar3.f45790a == this.f45771w && jVar3.f45791b == this.f45772x) {
            a(canvas, e());
            f(canvas, e());
            e(canvas, e());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        this.f45771w = getWidth();
        this.f45772x = getHeight();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        j jVar = this.f45758j;
        jVar.f45790a = -1.0f;
        jVar.f45791b = -1.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.M) {
            a(motionEvent);
            return true;
        }
        b(motionEvent);
        return true;
    }

    public void q() {
        if (this.J == null) {
            this.J = Bitmap.createBitmap(this.f45771w, this.f45772x, Bitmap.Config.RGB_565);
            this.K = Bitmap.createBitmap(this.f45771w, this.f45772x, Bitmap.Config.RGB_565);
            this.f45745L = Bitmap.createBitmap(this.f45771w, this.f45772x, Bitmap.Config.RGB_565);
        }
        c();
        invalidate();
    }

    private Path g() {
        Path path = this.f45757i;
        if (path == null) {
            this.f45757i = new Path();
        } else {
            path.reset();
        }
        Path path2 = this.f45757i;
        j jVar = this.f45768t;
        path2.moveTo(jVar.f45790a, jVar.f45791b);
        Path path3 = this.f45757i;
        j jVar2 = this.f45767s;
        path3.lineTo(jVar2.f45790a, jVar2.f45791b);
        Path path4 = this.f45757i;
        j jVar3 = this.f45765q;
        path4.lineTo(jVar3.f45790a, jVar3.f45791b);
        Path path5 = this.f45757i;
        j jVar4 = this.f45758j;
        path5.lineTo(jVar4.f45790a, jVar4.f45791b);
        Path path6 = this.f45757i;
        j jVar5 = this.f45766r;
        path6.lineTo(jVar5.f45790a, jVar5.f45791b);
        this.f45757i.close();
        return this.f45757i;
    }

    public void b(float f4) {
        this.V = f4;
    }

    public void c(int i4) {
        this.f45752e.setColor(i4);
    }

    private void c() {
        Canvas canvas = new Canvas(this.J);
        canvas.drawPath(h(), this.f45752e);
        a(canvas, this.T);
        boolean z3 = this.Q < this.f45746a0.length();
        this.M = z3;
        if (z3) {
            Canvas canvas2 = new Canvas(this.K);
            canvas2.drawPath(h(), this.f45752e);
            b(canvas2, this.T);
            Canvas canvas3 = new Canvas(this.f45745L);
            canvas3.drawPath(h(), this.f45755g);
            a(canvas3, this.f45754f);
        }
    }

    public void b(int i4) {
        this.f45754f.setColor(i4);
    }

    private void b() {
        int[] iArr = {36909875, 1077097267};
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr);
        this.A = gradientDrawable;
        gradientDrawable.setGradientType(0);
        GradientDrawable gradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, iArr);
        this.B = gradientDrawable2;
        gradientDrawable2.setGradientType(0);
        int[] iArr2 = {1077097267, 36909875, 36909875};
        GradientDrawable gradientDrawable3 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, iArr2);
        this.C = gradientDrawable3;
        gradientDrawable3.setGradientType(0);
        GradientDrawable gradientDrawable4 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, iArr2);
        this.D = gradientDrawable4;
        gradientDrawable4.setGradientType(0);
        GradientDrawable gradientDrawable5 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{36909875, 1077097267});
        this.E = gradientDrawable5;
        gradientDrawable5.setGradientType(0);
        int[] iArr3 = {-1726934767, 1118481};
        GradientDrawable gradientDrawable6 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr3);
        this.F = gradientDrawable6;
        gradientDrawable6.setGradientType(0);
        GradientDrawable gradientDrawable7 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, iArr3);
        this.G = gradientDrawable7;
        gradientDrawable7.setGradientType(0);
        int[] iArr4 = {1118481, -1726934767};
        GradientDrawable gradientDrawable8 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, iArr4);
        this.H = gradientDrawable8;
        gradientDrawable8.setGradientType(0);
        GradientDrawable gradientDrawable9 = new GradientDrawable(GradientDrawable.Orientation.RIGHT_LEFT, iArr4);
        this.I = gradientDrawable9;
        gradientDrawable9.setGradientType(0);
    }

    private TypeEvaluator<PointF> d() {
        return new g();
    }

    private Path e() {
        Path path = this.f45756h;
        if (path == null) {
            this.f45756h = new Path();
        } else {
            path.reset();
        }
        Path path2 = new Path();
        path2.lineTo(0.0f, this.f45772x);
        j jVar = this.f45763o;
        path2.lineTo(jVar.f45790a, jVar.f45791b);
        j jVar2 = this.f45761m;
        float f4 = jVar2.f45790a;
        float f5 = jVar2.f45791b;
        j jVar3 = this.f45765q;
        path2.quadTo(f4, f5, jVar3.f45790a, jVar3.f45791b);
        j jVar4 = this.f45758j;
        path2.lineTo(jVar4.f45790a, jVar4.f45791b);
        j jVar5 = this.f45766r;
        path2.lineTo(jVar5.f45790a, jVar5.f45791b);
        j jVar6 = this.f45762n;
        float f6 = jVar6.f45790a;
        float f7 = jVar6.f45791b;
        j jVar7 = this.f45764p;
        path2.quadTo(f6, f7, jVar7.f45790a, jVar7.f45791b);
        path2.lineTo(this.f45771w, 0.0f);
        path2.close();
        return path2;
    }

    private Path f() {
        Path path = this.f45756h;
        if (path == null) {
            this.f45756h = new Path();
        } else {
            path.reset();
        }
        Path path2 = this.f45756h;
        j jVar = this.f45763o;
        path2.lineTo(jVar.f45790a, jVar.f45791b);
        Path path3 = this.f45756h;
        j jVar2 = this.f45761m;
        float f4 = jVar2.f45790a;
        float f5 = jVar2.f45791b;
        j jVar3 = this.f45765q;
        path3.quadTo(f4, f5, jVar3.f45790a, jVar3.f45791b);
        Path path4 = this.f45756h;
        j jVar4 = this.f45758j;
        path4.lineTo(jVar4.f45790a, jVar4.f45791b);
        Path path5 = this.f45756h;
        j jVar5 = this.f45766r;
        path5.lineTo(jVar5.f45790a, jVar5.f45791b);
        Path path6 = this.f45756h;
        j jVar6 = this.f45762n;
        float f6 = jVar6.f45790a;
        float f7 = jVar6.f45791b;
        j jVar7 = this.f45764p;
        path6.quadTo(f6, f7, jVar7.f45790a, jVar7.f45791b);
        this.f45756h.lineTo(this.f45771w, this.f45772x);
        this.f45756h.lineTo(0.0f, this.f45772x);
        this.f45756h.close();
        return this.f45756h;
    }

    public void a(InterfaceC0885k interfaceC0885k) {
        this.W = interfaceC0885k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(float f4) {
        j jVar = this.f45758j;
        jVar.f45790a = f4;
        int i4 = this.f45772x;
        jVar.f45791b = i4 - 1;
        j jVar2 = this.f45759k;
        jVar2.f45790a = this.f45771w;
        jVar2.f45791b = i4;
        b(jVar, jVar2);
        invalidate();
    }

    public void a(String str) {
        this.f45746a0 = str;
        this.P = 0;
        this.R = 0;
        this.S.clear();
    }

    public void a(int i4) {
        this.f45755g.setColor(i4);
        this.f45750d.setColor(i4);
    }

    private void a(Canvas canvas, Paint paint) {
        paint.setTextSize(this.U);
        this.Q = a(canvas, paint, this.U + getPaddingTop(), this.f45746a0, this.P);
        this.S.put(Integer.valueOf(this.R), Integer.valueOf(this.P));
    }

    private void d(Canvas canvas, Path path) {
        GradientDrawable gradientDrawable;
        int i4;
        float f4;
        j jVar = this.f45758j;
        if (jVar.f45790a == -1.0f || jVar.f45791b == -1.0f) {
            return;
        }
        float f5 = this.f45762n.f45790a;
        int i5 = (int) f5;
        int hypot = (int) (f5 + (((float) Math.hypot(this.f45771w, this.f45772x)) * 10.0f));
        if (this.f45748c.equals(i.TOP_RIGHT)) {
            gradientDrawable = this.C;
            f4 = this.f45762n.f45791b;
            i4 = (int) (f4 - (this.f45770v / 2.0f));
        } else {
            gradientDrawable = this.D;
            float f6 = this.f45762n.f45791b;
            i4 = (int) f6;
            f4 = f6 + (this.f45770v / 2.0f);
        }
        gradientDrawable.setBounds(i5, i4, hypot, (int) f4);
        canvas.restore();
        canvas.save();
        Path path2 = new Path();
        path2.moveTo(this.f45758j.f45790a - (Math.max(this.f45770v, this.f45769u) / 2.0f), this.f45758j.f45791b);
        j jVar2 = this.f45762n;
        path2.lineTo(jVar2.f45790a, jVar2.f45791b);
        j jVar3 = this.f45758j;
        path2.lineTo(jVar3.f45790a, jVar3.f45791b);
        path2.close();
        canvas.clipPath(path);
        canvas.clipPath(path2, Region.Op.INTERSECT);
        j jVar4 = this.f45758j;
        float f7 = jVar4.f45791b;
        j jVar5 = this.f45762n;
        j jVar6 = this.f45762n;
        canvas.rotate((float) Math.toDegrees(Math.atan2(f7 - jVar5.f45791b, jVar4.f45790a - jVar5.f45790a)), jVar6.f45790a, jVar6.f45791b);
        gradientDrawable.draw(canvas);
    }

    private int a(Canvas canvas, Paint paint, float f4, String str, int i4) {
        int i5;
        int i6;
        float f5;
        boolean z3;
        float a4;
        String str2 = str;
        float width = getWidth();
        float height = getHeight();
        int paddingBottom = getPaddingBottom();
        if (Build.VERSION.SDK_INT >= 17) {
            i5 = getPaddingStart();
            i6 = getPaddingEnd();
        } else {
            i5 = 0;
            i6 = 0;
        }
        float f6 = i5;
        float f7 = f4;
        int i7 = i4;
        int i8 = 0;
        while (f7 < height - paddingBottom && i7 < str.length()) {
            int i9 = i7;
            float f8 = 0.0f;
            int i10 = 0;
            while (true) {
                f5 = height;
                if (i9 >= str.length()) {
                    break;
                }
                int i11 = i9 + 1;
                String substring = str2.substring(i9, i11);
                if (substring.equals("\n")) {
                    i10++;
                    break;
                }
                float a5 = a(paint, substring) + f8;
                if (a5 >= (width - f6) - i6) {
                    z3 = true;
                    break;
                }
                i10++;
                f8 = a5;
                height = f5;
                i9 = i11;
            }
            z3 = false;
            float f9 = i10 <= 1 ? 0.0f : (((width - f6) - i6) - f8) / (i10 - 1);
            float f10 = f6;
            int i12 = 0;
            while (i12 < i10) {
                float f11 = width;
                int i13 = i7 + 1;
                String substring2 = str2.substring(i7, i13);
                if (!substring2.equals("\n")) {
                    canvas.drawText(substring2, f10, f7, paint);
                    if (z3) {
                        a4 = a(paint, substring2) + f9;
                    } else {
                        a4 = a(paint, substring2);
                    }
                    f10 += a4;
                }
                i12++;
                str2 = str;
                i7 = i13;
                width = f11;
            }
            float f12 = width;
            i8++;
            f7 += this.U + this.V;
            if (i8 == this.f45749c0) {
                f7 = a(f7);
            }
            str2 = str;
            height = f5;
            width = f12;
        }
        return i7;
    }

    private void c(Canvas canvas, Path path) {
        GradientDrawable gradientDrawable;
        int i4;
        float f4;
        j jVar = this.f45758j;
        if (jVar.f45790a == -1.0f || jVar.f45791b == -1.0f) {
            return;
        }
        float f5 = this.f45761m.f45791b;
        int i5 = (int) f5;
        int i6 = (int) (f5 + this.f45772x);
        if (this.f45748c.equals(i.TOP_RIGHT)) {
            gradientDrawable = this.A;
            f4 = this.f45761m.f45790a;
            i4 = (int) (f4 - (this.f45769u / 2.0f));
        } else {
            gradientDrawable = this.B;
            float f6 = this.f45761m.f45790a;
            i4 = (int) f6;
            f4 = f6 + (this.f45769u / 2.0f);
        }
        canvas.restore();
        canvas.save();
        Path path2 = new Path();
        path2.moveTo(this.f45758j.f45790a - (Math.max(this.f45770v, this.f45769u) / 2.0f), this.f45758j.f45791b);
        j jVar2 = this.f45767s;
        path2.lineTo(jVar2.f45790a, jVar2.f45791b);
        j jVar3 = this.f45761m;
        path2.lineTo(jVar3.f45790a, jVar3.f45791b);
        j jVar4 = this.f45758j;
        path2.lineTo(jVar4.f45790a, jVar4.f45791b);
        path2.close();
        canvas.clipPath(path);
        canvas.clipPath(path2, Region.Op.INTERSECT);
        j jVar5 = this.f45761m;
        float f7 = jVar5.f45790a;
        j jVar6 = this.f45758j;
        j jVar7 = this.f45761m;
        canvas.rotate((float) Math.toDegrees(Math.atan2(f7 - jVar6.f45790a, jVar6.f45791b - jVar5.f45791b)), jVar7.f45790a, jVar7.f45791b);
        gradientDrawable.setBounds(i4, i5, (int) f4, i6);
        gradientDrawable.draw(canvas);
    }

    private void e(Canvas canvas, Path path) {
        canvas.save();
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.clipPath(g(), Region.Op.DIFFERENCE);
        canvas.drawBitmap(this.K, 0.0f, 0.0f, (Paint) null);
        a(canvas);
        canvas.restore();
    }

    private void f(Canvas canvas, Path path) {
        canvas.save();
        canvas.clipPath(path, Region.Op.DIFFERENCE);
        canvas.clipPath(g());
        canvas.drawPath(g(), this.f45750d);
        j jVar = this.f45759k;
        float hypot = (float) Math.hypot(jVar.f45790a - this.f45761m.f45790a, this.f45762n.f45791b - jVar.f45791b);
        j jVar2 = this.f45759k;
        float f4 = (jVar2.f45790a - this.f45761m.f45790a) / hypot;
        float f5 = (this.f45762n.f45791b - jVar2.f45791b) / hypot;
        float[] fArr = this.f45773y;
        float f6 = 2.0f * f4;
        float f7 = 1.0f - (f4 * f6);
        fArr[0] = -f7;
        float f8 = f6 * f5;
        fArr[1] = f8;
        fArr[3] = f8;
        fArr[4] = f7;
        fArr[8] = 1.0f;
        this.f45774z.reset();
        this.f45774z.setValues(this.f45773y);
        Matrix matrix = this.f45774z;
        j jVar3 = this.f45761m;
        matrix.preTranslate(-jVar3.f45790a, -jVar3.f45791b);
        Matrix matrix2 = this.f45774z;
        j jVar4 = this.f45761m;
        matrix2.postTranslate(jVar4.f45790a, jVar4.f45791b);
        canvas.drawBitmap(this.f45745L, this.f45774z, null);
        b(canvas);
        canvas.restore();
    }

    private void b(Canvas canvas, Paint paint) {
        paint.setTextSize(this.U);
        a(canvas, paint, this.U + getPaddingTop(), this.f45746a0, this.Q);
    }

    private void b(j jVar, j jVar2) {
        j jVar3 = this.f45760l;
        float f4 = (jVar.f45790a + jVar2.f45790a) / 2.0f;
        jVar3.f45790a = f4;
        float f5 = (jVar.f45791b + jVar2.f45791b) / 2.0f;
        jVar3.f45791b = f5;
        j jVar4 = this.f45761m;
        float f6 = jVar2.f45791b;
        float f7 = f6 - f5;
        jVar4.f45790a = f4 - ((f7 * f7) / (jVar2.f45790a - f4));
        jVar4.f45791b = f6;
        j jVar5 = this.f45762n;
        jVar5.f45790a = jVar2.f45790a;
        float f8 = jVar3.f45791b;
        float f9 = jVar2.f45790a;
        float f10 = f9 - jVar3.f45790a;
        jVar5.f45791b = f8 - ((f10 * f10) / (jVar2.f45791b - f8));
        j jVar6 = this.f45763o;
        float f11 = jVar4.f45790a;
        jVar6.f45790a = f11 - ((f9 - f11) / 2.0f);
        jVar6.f45791b = jVar2.f45791b;
        j jVar7 = this.f45764p;
        jVar7.f45790a = jVar2.f45790a;
        float f12 = jVar5.f45791b;
        jVar7.f45791b = f12 - ((jVar2.f45791b - f12) / 2.0f);
        this.f45765q = a(jVar, jVar4, jVar6, jVar7);
        j a4 = a(jVar, this.f45762n, this.f45763o, this.f45764p);
        this.f45766r = a4;
        j jVar8 = this.f45767s;
        j jVar9 = this.f45763o;
        float f13 = jVar9.f45790a;
        j jVar10 = this.f45761m;
        float f14 = f13 + (jVar10.f45790a * 2.0f);
        j jVar11 = this.f45765q;
        jVar8.f45790a = (f14 + jVar11.f45790a) / 4.0f;
        jVar8.f45791b = (((jVar10.f45791b * 2.0f) + jVar9.f45791b) + jVar11.f45791b) / 4.0f;
        j jVar12 = this.f45768t;
        j jVar13 = this.f45764p;
        float f15 = jVar13.f45790a;
        j jVar14 = this.f45762n;
        jVar12.f45790a = ((f15 + (jVar14.f45790a * 2.0f)) + a4.f45790a) / 4.0f;
        jVar12.f45791b = (((jVar14.f45791b * 2.0f) + jVar13.f45791b) + a4.f45791b) / 4.0f;
        float f16 = jVar.f45791b;
        float f17 = jVar10.f45791b;
        float f18 = f16 - f17;
        float f19 = jVar10.f45790a;
        float f20 = jVar.f45790a;
        float f21 = f19 - f20;
        this.f45769u = Math.abs((((jVar8.f45790a * f18) + (jVar8.f45791b * f21)) + ((f20 * f17) - (f19 * f16))) / ((float) Math.hypot(f18, f21)));
        float f22 = jVar.f45791b;
        j jVar15 = this.f45762n;
        float f23 = jVar15.f45791b;
        float f24 = f22 - f23;
        float f25 = jVar15.f45790a;
        float f26 = jVar.f45790a;
        float f27 = f25 - f26;
        float f28 = (f26 * f23) - (f25 * f22);
        j jVar16 = this.f45768t;
        this.f45770v = Math.abs((((jVar16.f45790a * f24) + (jVar16.f45791b * f27)) + f28) / ((float) Math.hypot(f24, f27)));
    }

    private void b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (motionEvent.getX() < this.f45771w / 2) {
                this.f45748c = i.LEFT;
            } else {
                this.f45748c = i.RIGHT;
            }
        } else if (action != 1) {
            if (action != 3) {
                return;
            }
            m();
        } else {
            int i4 = h.f45782a[this.f45748c.ordinal()];
            if (i4 == 1) {
                o();
            } else if (i4 != 2) {
            } else {
                this.W.last();
            }
        }
    }

    private float a(Paint paint, String str) {
        float f4 = 0.0f;
        if (str != null && str.length() > 0) {
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            for (int i4 = 0; i4 < length; i4++) {
                f4 += fArr[i4];
            }
        }
        return f4;
    }

    private float a(float f4) {
        if (this.f45747b0) {
            int i4 = this.R;
            if (i4 > 0 && i4 % this.f45753e0 == 0) {
                this.W.a(f4 - this.V);
                return f4 + this.f45751d0 + this.V;
            }
            this.W.a(-1.0f);
            return f4;
        }
        return f4;
    }

    private j a(j jVar, j jVar2, j jVar3, j jVar4) {
        float f4 = jVar.f45790a;
        float f5 = jVar.f45791b;
        float f6 = jVar2.f45790a;
        float f7 = jVar2.f45791b;
        float f8 = jVar3.f45790a;
        float f9 = jVar3.f45791b;
        float f10 = jVar4.f45790a;
        float f11 = jVar4.f45791b;
        float f12 = f4 - f6;
        float f13 = (f8 * f11) - (f10 * f9);
        float f14 = f8 - f10;
        float f15 = (f4 * f7) - (f6 * f5);
        float f16 = f5 - f7;
        float f17 = f9 - f11;
        float f18 = (f14 * f16) - (f12 * f17);
        return new j(((f12 * f13) - (f14 * f15)) / f18, ((f16 * f13) - (f15 * f17)) / f18);
    }

    private void a(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                if (this.f45748c == i.LEFT) {
                    o();
                    return;
                } else if (this.N) {
                    p();
                    return;
                } else {
                    n();
                    return;
                }
            } else if (action != 2) {
                if (action != 3) {
                    return;
                }
                m();
                return;
            } else {
                if (this.f45748c != i.LEFT) {
                    a(motionEvent.getX(), motionEvent.getY());
                }
                if (Math.abs(motionEvent.getX() - this.O) >= 5.0f) {
                    this.N = motionEvent.getX() < ((float) this.O);
                }
                this.O = (int) motionEvent.getX();
                return;
            }
        }
        this.O = (int) motionEvent.getX();
        this.N = true;
        float x3 = motionEvent.getX();
        int i4 = this.f45771w;
        if (x3 > i4 - (i4 / 2) && motionEvent.getY() < this.f45772x / 3) {
            this.f45748c = i.TOP_RIGHT;
            a(motionEvent.getX(), motionEvent.getY());
            return;
        }
        float x4 = motionEvent.getX();
        int i5 = this.f45771w;
        if (x4 > i5 - (i5 / 2)) {
            float y3 = motionEvent.getY();
            int i6 = this.f45772x;
            if (y3 >= i6 - (i6 / 3)) {
                this.f45748c = i.BOTTOM_RIGHT;
                a(motionEvent.getX(), motionEvent.getY());
                return;
            }
        }
        float x5 = motionEvent.getX();
        int i7 = this.f45771w;
        if (x5 > i7 - (i7 / 2)) {
            this.f45748c = i.CENTER_RIGHT;
            a(motionEvent.getX(), motionEvent.getY());
            return;
        }
        this.f45748c = i.LEFT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(float f4, float f5) {
        j jVar = this.f45758j;
        jVar.f45790a = f4;
        jVar.f45791b = f5;
        int i4 = h.f45782a[this.f45748c.ordinal()];
        if (i4 == 3) {
            j jVar2 = this.f45759k;
            jVar2.f45790a = this.f45771w;
            jVar2.f45791b = 0.0f;
            b(this.f45758j, jVar2);
        } else if (i4 == 4 || i4 == 5) {
            j jVar3 = this.f45759k;
            jVar3.f45790a = this.f45771w;
            jVar3.f45791b = this.f45772x;
            b(this.f45758j, jVar3);
        }
        invalidate();
    }

    private void b(Canvas canvas, Path path) {
        j jVar = this.f45758j;
        float f4 = jVar.f45790a;
        if (f4 == -1.0f || jVar.f45791b == -1.0f) {
            return;
        }
        int i4 = this.f45772x;
        GradientDrawable gradientDrawable = this.E;
        gradientDrawable.setBounds((int) (f4 - Math.min(30, this.f45770v / 2.0f)), 0, (int) this.f45758j.f45790a, i4);
        canvas.restore();
        canvas.save();
        canvas.clipPath(path, Region.Op.INTERSECT);
        j jVar2 = this.f45759k;
        float degrees = (float) Math.toDegrees(Math.atan2(jVar2.f45790a - this.f45758j.f45790a, jVar2.f45791b - this.f45762n.f45791b));
        j jVar3 = this.f45758j;
        canvas.rotate(degrees, jVar3.f45790a, jVar3.f45791b);
        gradientDrawable.draw(canvas);
    }

    private void b(Canvas canvas) {
        GradientDrawable gradientDrawable;
        int i4;
        int i5;
        j jVar = this.f45758j;
        float f4 = jVar.f45790a;
        j jVar2 = this.f45759k;
        int hypot = (int) (((float) Math.hypot(f4 - jVar2.f45790a, jVar.f45791b - jVar2.f45791b)) / 4.0f);
        float f5 = this.f45763o.f45791b;
        int i6 = (int) f5;
        int hypot2 = (int) (((float) Math.hypot(this.f45771w, this.f45772x)) + f5);
        if (this.f45748c.equals(i.TOP_RIGHT)) {
            gradientDrawable = this.H;
            float f6 = this.f45763o.f45790a;
            i4 = (int) (f6 - 0);
            i5 = (int) (f6 + hypot);
        } else {
            gradientDrawable = this.I;
            float f7 = this.f45763o.f45790a;
            i4 = (int) (f7 - hypot);
            i5 = (int) (f7 + 0);
        }
        gradientDrawable.setBounds(i4, i6, i5, hypot2);
        float f8 = this.f45761m.f45790a;
        j jVar3 = this.f45759k;
        j jVar4 = this.f45763o;
        canvas.rotate((float) Math.toDegrees(Math.atan2(f8 - jVar3.f45790a, this.f45762n.f45791b - jVar3.f45791b)), jVar4.f45790a, jVar4.f45791b);
        gradientDrawable.draw(canvas);
    }

    private void a(float f4, float f5) {
        j jVar = this.f45758j;
        jVar.f45790a = f4;
        jVar.f45791b = f5;
        int i4 = h.f45782a[this.f45748c.ordinal()];
        if (i4 == 3) {
            j jVar2 = this.f45759k;
            jVar2.f45790a = this.f45771w;
            jVar2.f45791b = 0.0f;
            b(this.f45758j, jVar2);
            if (a(new j(f4, f5), this.f45759k) < 0.0f) {
                a();
                b(this.f45758j, this.f45759k);
            }
            invalidate();
        } else if (i4 == 4) {
            j jVar3 = this.f45758j;
            int i5 = this.f45772x;
            jVar3.f45791b = i5 - 1;
            j jVar4 = this.f45759k;
            jVar4.f45790a = this.f45771w;
            jVar4.f45791b = i5;
            b(jVar3, jVar4);
            invalidate();
        } else if (i4 != 5) {
        } else {
            j jVar5 = this.f45759k;
            jVar5.f45790a = this.f45771w;
            jVar5.f45791b = this.f45772x;
            b(this.f45758j, jVar5);
            if (a(new j(f4, f5), this.f45759k) < 0.0f) {
                a();
                b(this.f45758j, this.f45759k);
            }
            invalidate();
        }
    }

    private float a(j jVar, j jVar2) {
        j jVar3 = new j();
        j jVar4 = new j();
        float f4 = (jVar.f45790a + jVar2.f45790a) / 2.0f;
        jVar3.f45790a = f4;
        float f5 = (jVar.f45791b + jVar2.f45791b) / 2.0f;
        jVar3.f45791b = f5;
        float f6 = jVar2.f45791b;
        float f7 = f6 - f5;
        float f8 = f4 - ((f7 * f7) / (jVar2.f45790a - f4));
        jVar4.f45790a = f8;
        jVar4.f45791b = f6;
        return f8 - ((jVar2.f45790a - f8) / 2.0f);
    }

    private void a() {
        float f4 = this.f45771w - this.f45763o.f45790a;
        float abs = Math.abs(this.f45759k.f45790a - this.f45758j.f45790a);
        float f5 = (this.f45771w * abs) / f4;
        this.f45758j.f45790a = Math.abs(this.f45759k.f45790a - f5);
        float abs2 = (f5 * Math.abs(this.f45759k.f45791b - this.f45758j.f45791b)) / abs;
        this.f45758j.f45791b = Math.abs(this.f45759k.f45791b - abs2);
    }

    private void a(Canvas canvas, Path path) {
        canvas.save();
        canvas.clipPath(path, Region.Op.INTERSECT);
        canvas.drawBitmap(this.J, 0.0f, 0.0f, (Paint) null);
        if (this.f45748c.equals(i.CENTER_RIGHT)) {
            b(canvas, path);
        } else {
            c(canvas, path);
            d(canvas, path);
        }
        canvas.restore();
    }

    private void a(Canvas canvas) {
        GradientDrawable gradientDrawable;
        int i4;
        int i5;
        j jVar = this.f45758j;
        float f4 = jVar.f45790a;
        j jVar2 = this.f45759k;
        int hypot = (int) (((float) Math.hypot(f4 - jVar2.f45790a, jVar.f45791b - jVar2.f45791b)) / 4.0f);
        float f5 = this.f45763o.f45791b;
        int i6 = (int) f5;
        int hypot2 = (int) (((float) Math.hypot(this.f45771w, this.f45772x)) + f5);
        if (this.f45748c.equals(i.TOP_RIGHT)) {
            gradientDrawable = this.F;
            float f6 = this.f45763o.f45790a;
            i4 = (int) (f6 - 0);
            i5 = (int) (f6 + hypot);
        } else {
            gradientDrawable = this.G;
            float f7 = this.f45763o.f45790a;
            i4 = (int) (f7 - hypot);
            i5 = (int) (f7 + 0);
        }
        gradientDrawable.setBounds(i4, i6, i5, hypot2);
        float f8 = this.f45761m.f45790a;
        j jVar3 = this.f45759k;
        j jVar4 = this.f45763o;
        canvas.rotate((float) Math.toDegrees(Math.atan2(f8 - jVar3.f45790a, this.f45762n.f45791b - jVar3.f45791b)), jVar4.f45790a, jVar4.f45791b);
        gradientDrawable.draw(canvas);
    }
}
