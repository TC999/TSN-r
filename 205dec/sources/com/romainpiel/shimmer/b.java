package com.romainpiel.shimmer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.romainpiel.shimmer.d;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Shimmer.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    public static final int f47430g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static final int f47431h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static final int f47432i = -1;

    /* renamed from: j  reason: collision with root package name */
    private static final long f47433j = 1000;

    /* renamed from: k  reason: collision with root package name */
    private static final long f47434k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f47435l = 0;

    /* renamed from: a  reason: collision with root package name */
    private int f47436a = -1;

    /* renamed from: b  reason: collision with root package name */
    private long f47437b = 1000;

    /* renamed from: c  reason: collision with root package name */
    private long f47438c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f47439d = 0;

    /* renamed from: e  reason: collision with root package name */
    private Animator.AnimatorListener f47440e;

    /* renamed from: f  reason: collision with root package name */
    private ObjectAnimator f47441f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Shimmer.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f47442a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
        /* compiled from: Shimmer.java */
        /* renamed from: com.romainpiel.shimmer.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        class C0927a implements Animator.AnimatorListener {
            C0927a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ((c) a.this.f47442a).setShimmering(false);
                a.this.f47442a.postInvalidateOnAnimation();
                b.this.f47441f = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        a(View view) {
            this.f47442a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((c) this.f47442a).setShimmering(true);
            float width = this.f47442a.getWidth();
            float f4 = 0.0f;
            if (b.this.f47439d == 1) {
                f4 = this.f47442a.getWidth();
                width = 0.0f;
            }
            b.this.f47441f = ObjectAnimator.ofFloat(this.f47442a, "gradientX", f4, width);
            b.this.f47441f.setRepeatCount(b.this.f47436a);
            b.this.f47441f.setDuration(b.this.f47437b);
            b.this.f47441f.setStartDelay(b.this.f47438c);
            b.this.f47441f.addListener(new C0927a());
            if (b.this.f47440e != null) {
                b.this.f47441f.addListener(b.this.f47440e);
            }
            b.this.f47441f.start();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Shimmer.java */
    /* renamed from: com.romainpiel.shimmer.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class C0928b implements d.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Runnable f47445a;

        C0928b(Runnable runnable) {
            this.f47445a = runnable;
        }

        @Override // com.romainpiel.shimmer.d.a
        public void a(View view) {
            this.f47445a.run();
        }
    }

    public void h() {
        ObjectAnimator objectAnimator = this.f47441f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public Animator.AnimatorListener i() {
        return this.f47440e;
    }

    public int j() {
        return this.f47439d;
    }

    public long k() {
        return this.f47437b;
    }

    public int l() {
        return this.f47436a;
    }

    public long m() {
        return this.f47438c;
    }

    public boolean n() {
        ObjectAnimator objectAnimator = this.f47441f;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    public b o(Animator.AnimatorListener animatorListener) {
        this.f47440e = animatorListener;
        return this;
    }

    public b p(int i4) {
        if (i4 != 0 && i4 != 1) {
            throw new IllegalArgumentException("The animation direction must be either ANIMATION_DIRECTION_LTR or ANIMATION_DIRECTION_RTL");
        }
        this.f47439d = i4;
        return this;
    }

    public b q(long j4) {
        this.f47437b = j4;
        return this;
    }

    public b r(int i4) {
        this.f47436a = i4;
        return this;
    }

    public b s(long j4) {
        this.f47438c = j4;
        return this;
    }

    public <V extends View & c> void t(V v3) {
        if (n()) {
            return;
        }
        a aVar = new a(v3);
        V v4 = v3;
        if (!v4.b()) {
            v4.setAnimationSetupCallback(new C0928b(aVar));
        } else {
            aVar.run();
        }
    }
}
