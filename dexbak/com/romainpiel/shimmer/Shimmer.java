package com.romainpiel.shimmer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.romainpiel.shimmer.ShimmerViewHelper;

/* renamed from: com.romainpiel.shimmer.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Shimmer {

    /* renamed from: g */
    public static final int f32971g = 0;

    /* renamed from: h */
    public static final int f32972h = 1;

    /* renamed from: i */
    private static final int f32973i = -1;

    /* renamed from: j */
    private static final long f32974j = 1000;

    /* renamed from: k */
    private static final long f32975k = 0;

    /* renamed from: l */
    private static final int f32976l = 0;

    /* renamed from: a */
    private int f32977a = -1;

    /* renamed from: b */
    private long f32978b = 1000;

    /* renamed from: c */
    private long f32979c = 0;

    /* renamed from: d */
    private int f32980d = 0;

    /* renamed from: e */
    private Animator.AnimatorListener f32981e;

    /* renamed from: f */
    private ObjectAnimator f32982f;

    /* compiled from: Shimmer.java */
    /* renamed from: com.romainpiel.shimmer.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class RunnableC11836a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ View f32983a;

        /* compiled from: Shimmer.java */
        /* renamed from: com.romainpiel.shimmer.b$a$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class C11837a implements Animator.AnimatorListener {
            C11837a() {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ((ShimmerViewBase) RunnableC11836a.this.f32983a).setShimmering(false);
                RunnableC11836a.this.f32983a.postInvalidateOnAnimation();
                Shimmer.this.f32982f = null;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        }

        RunnableC11836a(View view) {
            this.f32983a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((ShimmerViewBase) this.f32983a).setShimmering(true);
            float width = this.f32983a.getWidth();
            float f = 0.0f;
            if (Shimmer.this.f32980d == 1) {
                f = this.f32983a.getWidth();
                width = 0.0f;
            }
            Shimmer.this.f32982f = ObjectAnimator.ofFloat(this.f32983a, "gradientX", f, width);
            Shimmer.this.f32982f.setRepeatCount(Shimmer.this.f32977a);
            Shimmer.this.f32982f.setDuration(Shimmer.this.f32978b);
            Shimmer.this.f32982f.setStartDelay(Shimmer.this.f32979c);
            Shimmer.this.f32982f.addListener(new C11837a());
            if (Shimmer.this.f32981e != null) {
                Shimmer.this.f32982f.addListener(Shimmer.this.f32981e);
            }
            Shimmer.this.f32982f.start();
        }
    }

    /* compiled from: Shimmer.java */
    /* renamed from: com.romainpiel.shimmer.b$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11838b implements ShimmerViewHelper.InterfaceC11839a {

        /* renamed from: a */
        final /* synthetic */ Runnable f32986a;

        C11838b(Runnable runnable) {
            this.f32986a = runnable;
        }

        @Override // com.romainpiel.shimmer.ShimmerViewHelper.InterfaceC11839a
        /* renamed from: a */
        public void mo20263a(View view) {
            this.f32986a.run();
        }
    }

    /* renamed from: h */
    public void m20292h() {
        ObjectAnimator objectAnimator = this.f32982f;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    /* renamed from: i */
    public Animator.AnimatorListener m20291i() {
        return this.f32981e;
    }

    /* renamed from: j */
    public int m20290j() {
        return this.f32980d;
    }

    /* renamed from: k */
    public long m20289k() {
        return this.f32978b;
    }

    /* renamed from: l */
    public int m20288l() {
        return this.f32977a;
    }

    /* renamed from: m */
    public long m20287m() {
        return this.f32979c;
    }

    /* renamed from: n */
    public boolean m20286n() {
        ObjectAnimator objectAnimator = this.f32982f;
        return objectAnimator != null && objectAnimator.isRunning();
    }

    /* renamed from: o */
    public Shimmer m20285o(Animator.AnimatorListener animatorListener) {
        this.f32981e = animatorListener;
        return this;
    }

    /* renamed from: p */
    public Shimmer m20284p(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("The animation direction must be either ANIMATION_DIRECTION_LTR or ANIMATION_DIRECTION_RTL");
        }
        this.f32980d = i;
        return this;
    }

    /* renamed from: q */
    public Shimmer m20283q(long j) {
        this.f32978b = j;
        return this;
    }

    /* renamed from: r */
    public Shimmer m20282r(int i) {
        this.f32977a = i;
        return this;
    }

    /* renamed from: s */
    public Shimmer m20281s(long j) {
        this.f32979c = j;
        return this;
    }

    /* renamed from: t */
    public <V extends View & ShimmerViewBase> void m20280t(V v) {
        if (m20286n()) {
            return;
        }
        RunnableC11836a runnableC11836a = new RunnableC11836a(v);
        V v2 = v;
        if (!v2.mo20278b()) {
            v2.setAnimationSetupCallback(new C11838b(runnableC11836a));
        } else {
            runnableC11836a.run();
        }
    }
}
