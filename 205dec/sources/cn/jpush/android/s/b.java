package cn.jpush.android.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import cn.jpush.android.helper.Logger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int f4321a;

    /* renamed from: b  reason: collision with root package name */
    private int f4322b;

    /* renamed from: c  reason: collision with root package name */
    private int f4323c;

    /* renamed from: d  reason: collision with root package name */
    private long f4324d;

    /* renamed from: e  reason: collision with root package name */
    private View f4325e;

    /* renamed from: f  reason: collision with root package name */
    private a f4326f;

    /* renamed from: g  reason: collision with root package name */
    private int f4327g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f4328h = 1;

    /* renamed from: i  reason: collision with root package name */
    private float f4329i;

    /* renamed from: j  reason: collision with root package name */
    private float f4330j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4331k;

    /* renamed from: l  reason: collision with root package name */
    private int f4332l;

    /* renamed from: m  reason: collision with root package name */
    private Object f4333m;

    /* renamed from: n  reason: collision with root package name */
    private VelocityTracker f4334n;

    /* renamed from: o  reason: collision with root package name */
    private float f4335o;

    /* renamed from: p  reason: collision with root package name */
    private float f4336p;

    /* renamed from: q  reason: collision with root package name */
    private int f4337q;

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface a {
        void a(View view, Object obj);

        boolean a(Object obj);
    }

    public b(cn.jpush.android.u.b bVar, Object obj, int i4, a aVar) {
        View e4 = bVar.e();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(e4.getContext());
        this.f4321a = viewConfiguration.getScaledTouchSlop();
        this.f4322b = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        this.f4323c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f4324d = 500L;
        this.f4325e = e4;
        this.f4337q = i4;
        this.f4333m = obj;
        this.f4326f = aVar;
    }

    private void a(float f4, float f5, AnimatorListenerAdapter animatorListenerAdapter) {
        try {
            final float a4 = a();
            final float f6 = f4 - a4;
            final float alpha = this.f4325e.getAlpha();
            final float f7 = f5 - alpha;
            Logger.i("InAppSWTouchListener", "animateTo, beginTranslation: " + a4 + ", translationDiff: " + f6 + ", beginAlpha: , alphaDiff: " + f7);
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            if (ofFloat != null) {
                ofFloat.setDuration(this.f4324d);
                ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.s.b.2
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        float animatedFraction = a4 + (valueAnimator.getAnimatedFraction() * f6);
                        float animatedFraction2 = alpha + (valueAnimator.getAnimatedFraction() * f7);
                        b.this.a(animatedFraction);
                        b.this.b(animatedFraction2);
                    }
                });
                if (animatorListenerAdapter != null) {
                    ofFloat.addListener(animatorListenerAdapter);
                }
                ofFloat.start();
            }
        } catch (Throwable th) {
            Logger.w("InAppSWTouchListener", "[animateTo] failed" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            View view = this.f4325e;
            if (view != null) {
                final ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                this.f4325e.getHeight();
                final int width = this.f4325e.getWidth();
                ValueAnimator duration = ValueAnimator.ofInt(width, 1).setDuration(this.f4324d);
                duration.addListener(new AnimatorListenerAdapter() { // from class: cn.jpush.android.s.b.3
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        Logger.d("InAppSWTouchListener", "[onAnimationEnd] ...");
                        if (b.this.f4326f != null) {
                            b.this.f4326f.a(b.this.f4325e, b.this.f4333m);
                        }
                        b.this.f4325e.setAlpha(1.0f);
                        b.this.f4325e.setTranslationY(0.0f);
                        layoutParams.width = width;
                        b.this.f4325e.setLayoutParams(layoutParams);
                    }
                });
                duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: cn.jpush.android.s.b.4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        b.this.f4325e.setLayoutParams(layoutParams);
                    }
                });
                duration.start();
            }
        } catch (Throwable th) {
            Logger.w("InAppSWTouchListener", "[performDismiss] failed." + th.getMessage());
        }
    }

    protected float a() {
        return this.f4325e.getTranslationY();
    }

    protected void a(float f4) {
        this.f4325e.setTranslationY(f4);
    }

    protected void a(boolean z3) {
        int i4 = this.f4328h;
        if (z3) {
            i4 = -i4;
        }
        Logger.d("InAppSWTouchListener", "[startDismissAnimationY] dismissTop: " + z3 + ", viewHeight: " + this.f4328h);
        a((float) i4, 0.0f, new AnimatorListenerAdapter() { // from class: cn.jpush.android.s.b.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.c();
            }
        });
    }

    protected void b() {
        a(0.0f, 1.0f, null);
    }

    protected void b(float f4) {
        this.f4325e.setAlpha(f4);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int actionMasked;
        boolean z3;
        VelocityTracker velocityTracker;
        try {
            motionEvent.offsetLocation(0.0f, this.f4336p);
            if (this.f4328h < 2) {
                this.f4328h = this.f4325e.getHeight();
            }
            actionMasked = motionEvent.getActionMasked();
        } catch (Throwable th) {
            Logger.w("InAppSWTouchListener", "onTouch error." + th.getMessage());
        }
        if (actionMasked == 0) {
            this.f4329i = motionEvent.getRawX();
            this.f4330j = motionEvent.getRawY();
            a aVar = this.f4326f;
            if (aVar != null && aVar.a(this.f4333m)) {
                VelocityTracker obtain = VelocityTracker.obtain();
                this.f4334n = obtain;
                obtain.addMovement(motionEvent);
            }
            return false;
        }
        boolean z4 = true;
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                VelocityTracker velocityTracker2 = this.f4334n;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                    float rawX = motionEvent.getRawX() - this.f4329i;
                    float rawY = motionEvent.getRawY() - this.f4330j;
                    if (Math.abs(rawY) > this.f4321a && Math.abs(rawX) < Math.abs(rawY) / 2.0f) {
                        int i4 = this.f4337q;
                        if (i4 == 0) {
                            if (rawY > 0.0f) {
                            }
                        } else if (i4 == 1 && rawY < 0.0f) {
                        }
                        this.f4331k = true;
                        this.f4332l = rawY > 0.0f ? this.f4321a : -this.f4321a;
                        this.f4325e.getParent().requestDisallowInterceptTouchEvent(true);
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f4325e.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.f4331k) {
                        this.f4336p = rawY;
                        a(rawY - this.f4332l);
                        b(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawY) * 2.0f) / this.f4328h))));
                        return true;
                    }
                }
            } else if (actionMasked == 3 && (velocityTracker = this.f4334n) != null) {
                velocityTracker.recycle();
                this.f4334n = null;
                this.f4335o = 0.0f;
                this.f4336p = 0.0f;
                this.f4329i = 0.0f;
                this.f4330j = 0.0f;
            }
            return false;
        } else if (this.f4334n == null) {
            return false;
        } else {
            float rawY2 = motionEvent.getRawY() - this.f4329i;
            this.f4334n.addMovement(motionEvent);
            this.f4334n.computeCurrentVelocity(1000);
            if (Math.abs(rawY2) <= this.f4328h / 2 || !this.f4331k) {
                z3 = false;
                z4 = false;
            } else {
                z3 = rawY2 < 0.0f;
            }
            if (z4) {
                a(z3);
            } else if (this.f4331k) {
                b();
            }
            VelocityTracker velocityTracker3 = this.f4334n;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
            }
            this.f4334n = null;
            this.f4335o = 0.0f;
            this.f4336p = 0.0f;
            this.f4329i = 0.0f;
            this.f4330j = 0.0f;
        }
        this.f4331k = false;
        return false;
    }
}
