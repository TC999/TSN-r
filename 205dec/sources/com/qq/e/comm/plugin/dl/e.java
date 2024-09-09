package com.qq.e.comm.plugin.dl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class e implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    private final View f42397c;

    /* renamed from: d  reason: collision with root package name */
    private final d f42398d;

    /* renamed from: e  reason: collision with root package name */
    private final View$OnTouchListenerC0803e f42399e;

    /* renamed from: j  reason: collision with root package name */
    private int f42404j;

    /* renamed from: k  reason: collision with root package name */
    private int f42405k;

    /* renamed from: l  reason: collision with root package name */
    private f f42406l;

    /* renamed from: m  reason: collision with root package name */
    private int f42407m;

    /* renamed from: f  reason: collision with root package name */
    private Point f42400f = new Point(0, 0);

    /* renamed from: n  reason: collision with root package name */
    private int f42408n = com.qq.e.dl.j.f.a(6.0d);

    /* renamed from: h  reason: collision with root package name */
    private int f42402h = 300;

    /* renamed from: i  reason: collision with root package name */
    private int f42403i = 300;

    /* renamed from: g  reason: collision with root package name */
    private Point f42401g = new Point(0, 0);

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f42400f = new Point((int) e.this.f42397c.getX(), (int) e.this.f42397c.getY());
            e eVar = e.this;
            eVar.f42404j = eVar.f42397c.getWidth();
            e eVar2 = e.this;
            eVar2.f42405k = eVar2.f42397c.getHeight();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                e.this.f42407m = 2;
                e.this.f42399e.a(true);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                e.this.f42407m = 1;
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = e.this.f42397c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(e.this.f42408n, e.this.f42408n, e.this.f42408n, e.this.f42408n);
            }
            e.this.f42397c.setLayoutParams(layoutParams);
            e.this.f42398d.a(e.this.f42401g.x, e.this.f42401g.y, e.this.f42402h, e.this.f42403i, 300L, new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a extends AnimatorListenerAdapter {
            a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                e.this.f42407m = 0;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                e.this.f42407m = 3;
            }
        }

        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = e.this.f42397c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams).setMargins(0, 0, 0, 0);
            }
            e.this.f42399e.a(false);
            e.this.f42397c.setLayoutParams(layoutParams);
            e.this.f42398d.a(e.this.f42400f.x, e.this.f42400f.y, e.this.f42404j, e.this.f42405k, 300L, new a());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private final View f42414a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final ViewGroup.MarginLayoutParams f42415a;

            a() {
                this.f42415a = (ViewGroup.MarginLayoutParams) d.this.f42414a.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f42415a.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                d.this.f42414a.setLayoutParams(this.f42415a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class b implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final ViewGroup.MarginLayoutParams f42417a;

            b() {
                this.f42417a = (ViewGroup.MarginLayoutParams) d.this.f42414a.getLayoutParams();
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f42417a.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                d.this.f42414a.setLayoutParams(this.f42417a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class c extends AnimatorListenerAdapter {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Animator.AnimatorListener f42419c;

            c(d dVar, Animator.AnimatorListener animatorListener) {
                this.f42419c = animatorListener;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                Animator.AnimatorListener animatorListener = this.f42419c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                Animator.AnimatorListener animatorListener = this.f42419c;
                if (animatorListener != null) {
                    animatorListener.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                Animator.AnimatorListener animatorListener = this.f42419c;
                if (animatorListener != null) {
                    animatorListener.onAnimationStart(animator);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.dl.e$d$d  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class C0802d extends AnimatorListenerAdapter {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ f f42420c;

            C0802d(d dVar, f fVar) {
                this.f42420c = fVar;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f fVar = this.f42420c;
                if (fVar != null) {
                    fVar.a();
                }
            }
        }

        public d(View view) {
            this.f42414a = view;
        }

        public void a(int i4, int i5, int i6, int i7, long j4, Animator.AnimatorListener animatorListener) {
            ViewPropertyAnimator listener = this.f42414a.animate().x(i4).y(i5).setListener(null);
            int i8 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
            if (i8 >= 0) {
                listener.setDuration(j4);
            }
            listener.start();
            ValueAnimator ofInt = ValueAnimator.ofInt(this.f42414a.getWidth(), i6);
            ofInt.addUpdateListener(new a());
            if (i8 >= 0) {
                ofInt.setDuration(j4);
            }
            ofInt.start();
            ValueAnimator ofInt2 = ValueAnimator.ofInt(this.f42414a.getHeight(), i7);
            ofInt2.addUpdateListener(new b());
            if (i8 >= 0) {
                ofInt2.setDuration(j4);
            }
            ofInt2.addListener(new c(this, animatorListener));
            ofInt2.start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i4, long j4, f fVar) {
            ViewPropertyAnimator x3 = this.f42414a.animate().x(i4);
            x3.setDuration(j4);
            x3.setListener(new C0802d(this, fVar));
            x3.start();
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.dl.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class View$OnTouchListenerC0803e implements View.OnTouchListener {

        /* renamed from: c  reason: collision with root package name */
        private boolean f42421c;

        /* renamed from: d  reason: collision with root package name */
        private final int f42422d;

        /* renamed from: e  reason: collision with root package name */
        private float f42423e;

        /* renamed from: f  reason: collision with root package name */
        private float f42424f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f42425g;

        /* renamed from: h  reason: collision with root package name */
        private final View f42426h;

        /* renamed from: i  reason: collision with root package name */
        protected boolean f42427i;

        public View$OnTouchListenerC0803e(View view) {
            this.f42426h = view;
            this.f42422d = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f42426h.setOnTouchListener(this);
        }

        public void a(boolean z3) {
            this.f42421c = z3;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
            if (r1 != 3) goto L47;
         */
        @Override // android.view.View.OnTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
            /*
                Method dump skipped, instructions count: 308
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dl.e.View$OnTouchListenerC0803e.onTouch(android.view.View, android.view.MotionEvent):boolean");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface f {
        void a();

        void b();
    }

    public e(View view) {
        this.f42397c = view;
        this.f42398d = new d(this.f42397c);
        this.f42399e = new View$OnTouchListenerC0803e(this.f42397c);
        view.post(new a());
        this.f42397c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        f();
    }

    private void f() {
        if (d()) {
            return;
        }
        f fVar = this.f42406l;
        if (fVar != null) {
            fVar.b();
        }
        this.f42397c.post(new c());
    }

    public boolean d() {
        return b() == 0 || b() == 3;
    }

    public void e() {
        if (c()) {
            return;
        }
        this.f42397c.post(new b());
    }

    public int b() {
        return this.f42407m;
    }

    public boolean c() {
        return b() == 2 || b() == 1;
    }

    public e a(Point point) {
        this.f42401g = point;
        return this;
    }

    public e a(int i4, int i5) {
        this.f42402h = i4;
        this.f42403i = i5;
        return this;
    }

    public void a(f fVar) {
        this.f42406l = fVar;
    }

    public void a() {
        this.f42399e.f42427i = true;
        int i4 = -this.f42402h;
        ViewParent parent = this.f42397c.getParent();
        if (parent != null) {
            View view = (View) parent;
            if (this.f42397c.getX() + ((this.f42402h * 1.0f) / 2.0f) > (view.getWidth() * 1.0f) / 2.0f) {
                i4 = view.getWidth();
            }
        }
        this.f42398d.a(i4, b() == 2 ? 300 : 0, this.f42406l);
    }
}
