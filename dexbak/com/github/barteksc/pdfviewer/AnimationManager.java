package com.github.barteksc.pdfviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.github.barteksc.pdfviewer.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class AnimationManager {

    /* renamed from: a */
    private PDFView f23625a;

    /* renamed from: b */
    private ValueAnimator f23626b;

    /* renamed from: c */
    private OverScroller f23627c;

    /* renamed from: d */
    private boolean f23628d = false;

    /* renamed from: e */
    private boolean f23629e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimationManager.java */
    /* renamed from: com.github.barteksc.pdfviewer.a$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6650a extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        C6650a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimationManager.this.f23625a.m35477Z();
            AnimationManager.this.f23629e = false;
            AnimationManager.this.m35394e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.f23625a.m35477Z();
            AnimationManager.this.f23629e = false;
            AnimationManager.this.m35394e();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.f23625a.m35473b0(((Float) valueAnimator.getAnimatedValue()).floatValue(), AnimationManager.this.f23625a.getCurrentYOffset());
            AnimationManager.this.f23625a.m35478Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnimationManager.java */
    /* renamed from: com.github.barteksc.pdfviewer.a$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C6651b extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        C6651b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimationManager.this.f23625a.m35477Z();
            AnimationManager.this.f23629e = false;
            AnimationManager.this.m35394e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.f23625a.m35477Z();
            AnimationManager.this.f23629e = false;
            AnimationManager.this.m35394e();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.f23625a.m35473b0(AnimationManager.this.f23625a.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
            AnimationManager.this.f23625a.m35478Y();
        }
    }

    /* compiled from: AnimationManager.java */
    /* renamed from: com.github.barteksc.pdfviewer.a$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C6652c implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

        /* renamed from: a */
        private final float f23632a;

        /* renamed from: b */
        private final float f23633b;

        public C6652c(float f, float f2) {
            this.f23632a = f;
            this.f23633b = f2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimationManager.this.f23625a.m35477Z();
            AnimationManager.this.m35394e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.f23625a.m35477Z();
            AnimationManager.this.f23625a.m35463g0();
            AnimationManager.this.m35394e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.f23625a.m35437t0(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(this.f23632a, this.f23633b));
        }
    }

    public AnimationManager(PDFView pDFView) {
        this.f23625a = pDFView;
        this.f23627c = new OverScroller(pDFView.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m35394e() {
        if (this.f23625a.getScrollHandle() != null) {
            this.f23625a.getScrollHandle().mo35317g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m35395d() {
        if (this.f23627c.computeScrollOffset()) {
            this.f23625a.m35473b0(this.f23627c.getCurrX(), this.f23627c.getCurrY());
            this.f23625a.m35478Y();
        } else if (this.f23628d) {
            this.f23628d = false;
            this.f23625a.m35477Z();
            m35394e();
            this.f23625a.m35463g0();
        }
    }

    /* renamed from: f */
    public boolean m35393f() {
        return this.f23628d || this.f23629e;
    }

    /* renamed from: g */
    public void m35392g(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        m35387l();
        this.f23628d = true;
        this.f23627c.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    /* renamed from: h */
    public void m35391h(float f) {
        if (this.f23625a.m35486Q()) {
            m35389j(this.f23625a.getCurrentYOffset(), f);
        } else {
            m35390i(this.f23625a.getCurrentXOffset(), f);
        }
        this.f23629e = true;
    }

    /* renamed from: i */
    public void m35390i(float f, float f2) {
        m35387l();
        this.f23626b = ValueAnimator.ofFloat(f, f2);
        C6650a c6650a = new C6650a();
        this.f23626b.setInterpolator(new DecelerateInterpolator());
        this.f23626b.addUpdateListener(c6650a);
        this.f23626b.addListener(c6650a);
        this.f23626b.setDuration(400L);
        this.f23626b.start();
    }

    /* renamed from: j */
    public void m35389j(float f, float f2) {
        m35387l();
        this.f23626b = ValueAnimator.ofFloat(f, f2);
        C6651b c6651b = new C6651b();
        this.f23626b.setInterpolator(new DecelerateInterpolator());
        this.f23626b.addUpdateListener(c6651b);
        this.f23626b.addListener(c6651b);
        this.f23626b.setDuration(400L);
        this.f23626b.start();
    }

    /* renamed from: k */
    public void m35388k(float f, float f2, float f3, float f4) {
        m35387l();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f3, f4);
        this.f23626b = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        C6652c c6652c = new C6652c(f, f2);
        this.f23626b.addUpdateListener(c6652c);
        this.f23626b.addListener(c6652c);
        this.f23626b.setDuration(400L);
        this.f23626b.start();
    }

    /* renamed from: l */
    public void m35387l() {
        ValueAnimator valueAnimator = this.f23626b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f23626b = null;
        }
        m35386m();
    }

    /* renamed from: m */
    public void m35386m() {
        this.f23628d = false;
        this.f23627c.forceFinished(true);
    }
}
