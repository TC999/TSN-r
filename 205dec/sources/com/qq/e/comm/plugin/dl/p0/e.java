package com.qq.e.comm.plugin.dl.p0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends View implements d {
    private final RectF A;
    private final RectF B;
    private final RectF C;
    private final RectF D;
    private final RectF E;
    private final RectF F;
    private final RectF G;
    private final RectF H;
    private final RectF I;
    private final RectF J;
    private float K;

    /* renamed from: L  reason: collision with root package name */
    private float f42536L;
    private float M;
    private AnimatorSet N;
    private boolean O;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f42537c;

    /* renamed from: d  reason: collision with root package name */
    private final Camera f42538d;

    /* renamed from: e  reason: collision with root package name */
    private final float f42539e;

    /* renamed from: f  reason: collision with root package name */
    private float f42540f;

    /* renamed from: g  reason: collision with root package name */
    private final float f42541g;

    /* renamed from: h  reason: collision with root package name */
    private final float f42542h;

    /* renamed from: i  reason: collision with root package name */
    private final float f42543i;

    /* renamed from: j  reason: collision with root package name */
    private final float f42544j;

    /* renamed from: k  reason: collision with root package name */
    private final float f42545k;

    /* renamed from: l  reason: collision with root package name */
    private final float f42546l;

    /* renamed from: m  reason: collision with root package name */
    private final float f42547m;

    /* renamed from: n  reason: collision with root package name */
    private final float f42548n;

    /* renamed from: o  reason: collision with root package name */
    private final float f42549o;

    /* renamed from: p  reason: collision with root package name */
    private final float f42550p;

    /* renamed from: q  reason: collision with root package name */
    private final float f42551q;

    /* renamed from: r  reason: collision with root package name */
    private final float f42552r;

    /* renamed from: s  reason: collision with root package name */
    private final float f42553s;

    /* renamed from: t  reason: collision with root package name */
    private final float f42554t;

    /* renamed from: u  reason: collision with root package name */
    private final float f42555u;

    /* renamed from: v  reason: collision with root package name */
    private final float f42556v;

    /* renamed from: w  reason: collision with root package name */
    private final float f42557w;

    /* renamed from: x  reason: collision with root package name */
    private final float f42558x;

    /* renamed from: y  reason: collision with root package name */
    private final float f42559y;

    /* renamed from: z  reason: collision with root package name */
    private final float f42560z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.b();
        }
    }

    public e(Context context, int i4) {
        super(context);
        this.O = true;
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f42537c = paint;
        paint.setAntiAlias(true);
        this.f42537c.setDither(true);
        this.f42538d = new Camera();
        float f4 = i4;
        this.f42539e = f4;
        this.f42541g = (-f4) / 72.0f;
        this.f42542h = 0.009803922f * f4;
        this.f42543i = 0.014705882f * f4;
        this.f42544j = 0.029411765f * f4;
        this.f42545k = 0.039215688f * f4;
        this.f42546l = 0.20588236f * f4;
        this.f42547m = 0.32352942f * f4;
        this.f42548n = 0.4117647f * f4;
        this.f42549o = 0.46078432f * f4;
        this.f42550p = 0.47058824f * f4;
        this.f42551q = 0.4852941f * f4;
        this.f42552r = 0.5f * f4;
        this.f42553s = 0.5392157f * f4;
        this.f42554t = 0.5882353f * f4;
        this.f42555u = 0.64705884f * f4;
        this.f42556v = 0.6764706f * f4;
        this.f42557w = 0.6960784f * f4;
        this.f42558x = 0.7941176f * f4;
        this.f42559y = 0.9705882f * f4;
        this.f42560z = f4 * 0.9852941f;
        float f5 = this.f42543i;
        float f6 = this.f42560z;
        this.A = new RectF(f5, f5, f6, f6);
        float f7 = this.f42552r;
        float f8 = this.f42548n;
        float f9 = this.f42544j;
        float f10 = (f8 - f9) / 2.0f;
        float f11 = (this.f42555u - f9) / 2.0f;
        this.B = new RectF(f7 - f10, f7 - f11, f10 + f7, f7 + f11);
        this.C = new RectF(this.f42547m, this.f42546l, this.f42556v, this.f42558x);
        float f12 = this.f42544j;
        float f13 = this.f42552r;
        float f14 = this.f42559y;
        this.D = new RectF(f12, f13, f14, f14);
        float f15 = this.f42552r;
        float f16 = this.f42544j;
        float f17 = this.f42559y;
        this.E = new RectF(f15, f16, f17, f17);
        float f18 = this.f42544j;
        this.F = new RectF(f18, f18, this.f42559y, this.f42552r);
        float f19 = this.f42544j;
        this.G = new RectF(f19, f19, this.f42552r, this.f42559y);
        this.H = new RectF();
        this.I = new RectF();
        this.J = new RectF();
        post(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "px", 0.0f, -0.7f);
        ofFloat.setDuration(400L);
        ofFloat.setStartDelay(600L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "px", -0.7f, 0.0f);
        ofFloat2.setDuration(400L);
        ofFloat2.setStartDelay(200L);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, "py", 0.0f, -0.7f);
        ofFloat3.setDuration(400L);
        ofFloat3.setStartDelay(600L);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, "py", -0.7f, 0.0f);
        ofFloat4.setDuration(400L);
        ofFloat4.setStartDelay(200L);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this, "pz", 0.0f, 0.7f);
        ofFloat5.setDuration(400L);
        ofFloat5.setStartDelay(600L);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this, "pz", 0.7f, 0.0f);
        ofFloat6.setDuration(400L);
        ofFloat6.setStartDelay(200L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.N = animatorSet;
        animatorSet.playSequentially(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6);
        this.N.addListener(new b(null));
        this.N.start();
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void c() {
        this.f42540f = 0.0f;
        this.K = 0.0f;
        this.f42536L = 0.0f;
        this.M = 0.0f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float sin = this.f42552r * ((float) Math.sin(Math.toRadians(this.K)));
        float sin2 = this.f42552r * ((float) Math.sin(Math.toRadians(this.f42536L)));
        canvas.save();
        this.f42537c.setColor(-4933701);
        this.f42537c.setStyle(Paint.Style.STROKE);
        this.f42537c.setStrokeWidth(this.f42544j);
        float f4 = this.f42552r;
        canvas.drawCircle(f4, f4, this.f42551q, this.f42537c);
        if (!this.O) {
            this.f42537c.setColor(-1);
            this.f42537c.setStyle(Paint.Style.STROKE);
            this.f42537c.setStrokeCap(Paint.Cap.ROUND);
            this.f42537c.setStrokeWidth(this.f42544j);
            RectF rectF = this.A;
            float f5 = this.f42540f * 180.0f;
            canvas.drawArc(rectF, (-90.0f) - f5, f5 * 2.0f, false, this.f42537c);
        }
        this.f42537c.setColor(1090519039);
        this.f42537c.setStyle(Paint.Style.FILL);
        float f6 = this.f42552r;
        canvas.drawCircle(f6, f6, this.f42550p, this.f42537c);
        canvas.restore();
        this.f42537c.setColor(Integer.MAX_VALUE);
        this.f42537c.setStyle(Paint.Style.STROKE);
        this.f42537c.setStrokeWidth(this.f42542h);
        RectF rectF2 = this.H;
        float f7 = this.f42544j;
        rectF2.left = f7;
        float f8 = this.f42552r;
        rectF2.top = f8 - sin;
        rectF2.right = this.f42559y;
        rectF2.bottom = f8 + sin;
        RectF rectF3 = this.I;
        rectF3.left = f8 - sin2;
        rectF3.top = f7;
        rectF3.right = f8 + sin2;
        rectF3.bottom = f8 + this.f42550p;
        if (Build.VERSION.SDK_INT >= 26) {
            if (Math.abs(sin) >= this.f42542h) {
                canvas.save();
                float f9 = this.f42552r;
                canvas.rotate(-this.M, f9, f9);
                canvas.clipRect(sin > 0.0f ? this.F : this.D);
                canvas.drawOval(this.H, this.f42537c);
                canvas.restore();
            }
            if (Math.abs(sin2) >= this.f42542h) {
                canvas.save();
                float f10 = this.f42552r;
                canvas.rotate(-this.M, f10, f10);
                canvas.clipRect(sin2 > 0.0f ? this.G : this.E);
                canvas.drawOval(this.I, this.f42537c);
                canvas.restore();
            }
        }
        canvas.save();
        float f11 = this.f42552r;
        canvas.translate(f11, f11);
        this.f42538d.save();
        this.f42538d.rotateX(-this.K);
        this.f42538d.rotateY(this.f42536L);
        this.f42538d.rotateZ(this.M);
        this.f42538d.setLocation(0.0f, 0.0f, this.f42541g);
        this.f42538d.applyToCanvas(canvas);
        this.f42538d.restore();
        float f12 = -this.f42552r;
        canvas.translate(f12, f12);
        this.f42537c.setColor(-1);
        this.f42537c.setStyle(Paint.Style.STROKE);
        this.f42537c.setStrokeWidth(this.f42544j);
        RectF rectF4 = this.B;
        float f13 = this.f42544j + this.f42543i;
        canvas.drawRoundRect(rectF4, f13, f13, this.f42537c);
        this.f42537c.setColor(-4933701);
        this.f42537c.setStyle(Paint.Style.FILL);
        RectF rectF5 = this.C;
        float f14 = this.f42544j;
        canvas.drawRoundRect(rectF5, f14, f14, this.f42537c);
        this.f42537c.setColor(Integer.MAX_VALUE);
        this.f42537c.setStyle(Paint.Style.FILL);
        RectF rectF6 = this.J;
        rectF6.left = this.f42547m;
        float f15 = this.f42558x;
        rectF6.top = f15 - (this.f42540f * this.f42554t);
        rectF6.right = this.f42556v;
        rectF6.bottom = f15;
        canvas.drawRoundRect(rectF6, 0.0f, 0.0f, this.f42537c);
        this.f42537c.setColor(-1);
        this.f42537c.setStyle(Paint.Style.STROKE);
        this.f42537c.setStrokeCap(Paint.Cap.ROUND);
        this.f42537c.setStrokeWidth(this.f42545k);
        float f16 = this.f42549o;
        float f17 = this.f42557w;
        canvas.drawLine(f16, f17, this.f42553s, f17, this.f42537c);
        canvas.restore();
        this.f42537c.setColor(Integer.MAX_VALUE);
        this.f42537c.setStyle(Paint.Style.STROKE);
        this.f42537c.setStrokeWidth(this.f42542h);
        if (Math.abs(sin) >= this.f42542h) {
            canvas.save();
            float f18 = this.f42552r;
            canvas.rotate(-this.M, f18, f18);
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipRect(sin > 0.0f ? this.D : this.F);
            }
            canvas.drawOval(this.H, this.f42537c);
            canvas.restore();
        }
        if (Math.abs(sin2) >= this.f42542h) {
            canvas.save();
            float f19 = this.f42552r;
            canvas.rotate(-this.M, f19, f19);
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipRect(sin2 > 0.0f ? this.E : this.G);
            }
            canvas.drawOval(this.I, this.f42537c);
            canvas.restore();
        }
        canvas.save();
        float f20 = this.f42552r;
        canvas.rotate(-this.M, f20, f20);
        this.f42537c.setColor(Integer.MAX_VALUE);
        this.f42537c.setStyle(Paint.Style.STROKE);
        this.f42537c.setStrokeWidth(this.f42542h);
        if (Math.abs(sin2) < this.f42542h) {
            float f21 = this.f42552r;
            canvas.drawLine(f21, this.f42544j, f21, this.f42559y, this.f42537c);
        }
        if (Math.abs(sin) < this.f42542h) {
            float f22 = this.f42544j;
            float f23 = this.f42552r;
            canvas.drawLine(f22, f23, this.f42559y, f23, this.f42537c);
        }
        canvas.restore();
    }

    public void setPx(float f4) {
        this.f42540f = Math.abs(f4);
        this.K = f4 * 45.0f;
        invalidate();
    }

    public void setPy(float f4) {
        this.f42540f = Math.abs(f4);
        this.f42536L = f4 * 45.0f;
        invalidate();
    }

    public void setPz(float f4) {
        this.f42540f = Math.abs(f4);
        this.M = f4 * 45.0f;
        invalidate();
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a(int i4, int i5, int i6, int i7, float f4) {
        AnimatorSet animatorSet;
        if (this.O && (animatorSet = this.N) != null && f4 > 0.1f) {
            this.O = false;
            animatorSet.cancel();
        }
        if (this.O) {
            return;
        }
        float f5 = i7;
        this.K = Math.min(i4 / f5, 1.0f) * 45.0f;
        this.f42536L = Math.min(i5 / f5, 1.0f) * 45.0f;
        this.M = Math.min(i6 / f5, 1.0f) * 45.0f;
        if (Math.abs(this.f42540f - f4) > 0.01f) {
            this.f42540f = f4;
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b extends AnimatorListenerAdapter {

        /* renamed from: c  reason: collision with root package name */
        private boolean f42562c;

        private b() {
            this.f42562c = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f42562c = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f42562c) {
                animator.start();
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a(int i4, int i5, int i6, int i7, long j4) {
        this.f42540f = 1.0f;
        float f4 = i7;
        this.K = Math.min(i4 / f4, 1.0f) * 45.0f;
        this.f42536L = Math.min(i5 / f4, 1.0f) * 45.0f;
        this.M = Math.min(i6 / f4, 1.0f) * 45.0f;
        invalidate();
    }
}
