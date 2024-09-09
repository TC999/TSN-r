package com.mbridge.msdk.widget.custom.baseview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* compiled from: CircularAnimatedDrawable.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class a extends Drawable implements Animatable {

    /* renamed from: a  reason: collision with root package name */
    private static final Interpolator f41246a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    private static final Interpolator f41247b = new DecelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    private ObjectAnimator f41249d;

    /* renamed from: e  reason: collision with root package name */
    private ObjectAnimator f41250e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f41251f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f41252g;

    /* renamed from: h  reason: collision with root package name */
    private float f41253h;

    /* renamed from: i  reason: collision with root package name */
    private float f41254i;

    /* renamed from: j  reason: collision with root package name */
    private float f41255j;

    /* renamed from: k  reason: collision with root package name */
    private float f41256k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f41257l;

    /* renamed from: c  reason: collision with root package name */
    private final RectF f41248c = new RectF();

    /* renamed from: m  reason: collision with root package name */
    private Property<a, Float> f41258m = new Property<a, Float>(Float.class, "angle") { // from class: com.mbridge.msdk.widget.custom.baseview.a.1
        @Override // android.util.Property
        public final /* synthetic */ Float get(a aVar) {
            return Float.valueOf(aVar.a());
        }

        @Override // android.util.Property
        public final /* synthetic */ void set(a aVar, Float f4) {
            aVar.a(f4.floatValue());
        }
    };

    /* renamed from: n  reason: collision with root package name */
    private Property<a, Float> f41259n = new Property<a, Float>(Float.class, "arc") { // from class: com.mbridge.msdk.widget.custom.baseview.a.2
        @Override // android.util.Property
        public final /* synthetic */ Float get(a aVar) {
            return Float.valueOf(aVar.b());
        }

        @Override // android.util.Property
        public final /* synthetic */ void set(a aVar, Float f4) {
            aVar.b(f4.floatValue());
        }
    };

    public a(int i4, float f4) {
        this.f41256k = f4;
        Paint paint = new Paint();
        this.f41252g = paint;
        paint.setAntiAlias(true);
        this.f41252g.setStyle(Paint.Style.STROKE);
        this.f41252g.setStrokeWidth(f4);
        this.f41252g.setColor(i4);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.f41258m, 360.0f);
        this.f41250e = ofFloat;
        ofFloat.setInterpolator(f41246a);
        this.f41250e.setDuration(2000L);
        this.f41250e.setRepeatMode(1);
        this.f41250e.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.f41259n, 300.0f);
        this.f41249d = ofFloat2;
        ofFloat2.setInterpolator(f41247b);
        this.f41249d.setDuration(600L);
        this.f41249d.setRepeatMode(1);
        this.f41249d.setRepeatCount(-1);
        this.f41249d.addListener(new Animator.AnimatorListener() { // from class: com.mbridge.msdk.widget.custom.baseview.a.3
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) {
                a.a(a.this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        });
    }

    public final void a(float f4) {
        this.f41254i = f4;
        invalidateSelf();
    }

    public final void b(float f4) {
        this.f41255j = f4;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f4;
        float f5 = this.f41254i - this.f41253h;
        float f6 = this.f41255j;
        if (this.f41251f) {
            f4 = f6 + 30.0f;
        } else {
            f5 += f6;
            f4 = (360.0f - f6) - 30.0f;
        }
        canvas.drawArc(this.f41248c, f5, f4, false, this.f41252g);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f41257l;
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        RectF rectF = this.f41248c;
        float f4 = this.f41256k;
        rectF.left = rect.left + (f4 / 2.0f) + 0.5f;
        rectF.right = (rect.right - (f4 / 2.0f)) - 0.5f;
        rectF.top = rect.top + (f4 / 2.0f) + 0.5f;
        rectF.bottom = (rect.bottom - (f4 / 2.0f)) - 0.5f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
        this.f41252g.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f41252g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        if (isRunning()) {
            return;
        }
        this.f41257l = true;
        this.f41250e.start();
        this.f41249d.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        if (isRunning()) {
            this.f41257l = false;
            this.f41250e.cancel();
            this.f41249d.cancel();
            invalidateSelf();
        }
    }

    public final float a() {
        return this.f41254i;
    }

    public final float b() {
        return this.f41255j;
    }

    static /* synthetic */ void a(a aVar) {
        boolean z3 = !aVar.f41251f;
        aVar.f41251f = z3;
        if (z3) {
            aVar.f41253h = (aVar.f41253h + 60.0f) % 360.0f;
        }
    }
}
