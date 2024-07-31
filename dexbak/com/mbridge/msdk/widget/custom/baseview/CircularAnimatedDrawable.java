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

/* renamed from: com.mbridge.msdk.widget.custom.baseview.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class CircularAnimatedDrawable extends Drawable implements Animatable {

    /* renamed from: a */
    private static final Interpolator f32559a = new LinearInterpolator();

    /* renamed from: b */
    private static final Interpolator f32560b = new DecelerateInterpolator();

    /* renamed from: d */
    private ObjectAnimator f32562d;

    /* renamed from: e */
    private ObjectAnimator f32563e;

    /* renamed from: f */
    private boolean f32564f;

    /* renamed from: g */
    private Paint f32565g;

    /* renamed from: h */
    private float f32566h;

    /* renamed from: i */
    private float f32567i;

    /* renamed from: j */
    private float f32568j;

    /* renamed from: k */
    private float f32569k;

    /* renamed from: l */
    private boolean f32570l;

    /* renamed from: c */
    private final RectF f32561c = new RectF();

    /* renamed from: m */
    private Property<CircularAnimatedDrawable, Float> f32571m = new Property<CircularAnimatedDrawable, Float>(Float.class, "angle") { // from class: com.mbridge.msdk.widget.custom.baseview.a.1
        @Override // android.util.Property
        public final /* synthetic */ Float get(CircularAnimatedDrawable circularAnimatedDrawable) {
            return Float.valueOf(circularAnimatedDrawable.m20540a());
        }

        @Override // android.util.Property
        public final /* synthetic */ void set(CircularAnimatedDrawable circularAnimatedDrawable, Float f) {
            circularAnimatedDrawable.m20539a(f.floatValue());
        }
    };

    /* renamed from: n */
    private Property<CircularAnimatedDrawable, Float> f32572n = new Property<CircularAnimatedDrawable, Float>(Float.class, "arc") { // from class: com.mbridge.msdk.widget.custom.baseview.a.2
        @Override // android.util.Property
        public final /* synthetic */ Float get(CircularAnimatedDrawable circularAnimatedDrawable) {
            return Float.valueOf(circularAnimatedDrawable.m20537b());
        }

        @Override // android.util.Property
        public final /* synthetic */ void set(CircularAnimatedDrawable circularAnimatedDrawable, Float f) {
            circularAnimatedDrawable.m20536b(f.floatValue());
        }
    };

    public CircularAnimatedDrawable(int i, float f) {
        this.f32569k = f;
        Paint paint = new Paint();
        this.f32565g = paint;
        paint.setAntiAlias(true);
        this.f32565g.setStyle(Paint.Style.STROKE);
        this.f32565g.setStrokeWidth(f);
        this.f32565g.setColor(i);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, this.f32571m, 360.0f);
        this.f32563e = ofFloat;
        ofFloat.setInterpolator(f32559a);
        this.f32563e.setDuration(2000L);
        this.f32563e.setRepeatMode(1);
        this.f32563e.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, this.f32572n, 300.0f);
        this.f32562d = ofFloat2;
        ofFloat2.setInterpolator(f32560b);
        this.f32562d.setDuration(600L);
        this.f32562d.setRepeatMode(1);
        this.f32562d.setRepeatCount(-1);
        this.f32562d.addListener(new Animator.AnimatorListener() { // from class: com.mbridge.msdk.widget.custom.baseview.a.3
            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationRepeat(Animator animator) {
                CircularAnimatedDrawable.m20538a(CircularAnimatedDrawable.this);
            }

            @Override // android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
            }
        });
    }

    /* renamed from: a */
    public final void m20539a(float f) {
        this.f32567i = f;
        invalidateSelf();
    }

    /* renamed from: b */
    public final void m20536b(float f) {
        this.f32568j = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        float f;
        float f2 = this.f32567i - this.f32566h;
        float f3 = this.f32568j;
        if (this.f32564f) {
            f = f3 + 30.0f;
        } else {
            f2 += f3;
            f = (360.0f - f3) - 30.0f;
        }
        canvas.drawArc(this.f32561c, f2, f, false, this.f32565g);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public final boolean isRunning() {
        return this.f32570l;
    }

    @Override // android.graphics.drawable.Drawable
    protected final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        RectF rectF = this.f32561c;
        float f = this.f32569k;
        rectF.left = rect.left + (f / 2.0f) + 0.5f;
        rectF.right = (rect.right - (f / 2.0f)) - 0.5f;
        rectF.top = rect.top + (f / 2.0f) + 0.5f;
        rectF.bottom = (rect.bottom - (f / 2.0f)) - 0.5f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f32565g.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.f32565g.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Animatable
    public final void start() {
        if (isRunning()) {
            return;
        }
        this.f32570l = true;
        this.f32563e.start();
        this.f32562d.start();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public final void stop() {
        if (isRunning()) {
            this.f32570l = false;
            this.f32563e.cancel();
            this.f32562d.cancel();
            invalidateSelf();
        }
    }

    /* renamed from: a */
    public final float m20540a() {
        return this.f32567i;
    }

    /* renamed from: b */
    public final float m20537b() {
        return this.f32568j;
    }

    /* renamed from: a */
    static /* synthetic */ void m20538a(CircularAnimatedDrawable circularAnimatedDrawable) {
        boolean z = !circularAnimatedDrawable.f32564f;
        circularAnimatedDrawable.f32564f = z;
        if (z) {
            circularAnimatedDrawable.f32566h = (circularAnimatedDrawable.f32566h + 60.0f) % 360.0f;
        }
    }
}
