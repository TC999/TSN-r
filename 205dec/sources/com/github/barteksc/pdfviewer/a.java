package com.github.barteksc.pdfviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: AnimationManager.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private PDFView f37194a;

    /* renamed from: b  reason: collision with root package name */
    private ValueAnimator f37195b;

    /* renamed from: c  reason: collision with root package name */
    private OverScroller f37196c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f37197d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f37198e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: AnimationManager.java */
    /* renamed from: com.github.barteksc.pdfviewer.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class C0544a extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        C0544a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a.this.f37194a.Z();
            a.this.f37198e = false;
            a.this.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f37194a.Z();
            a.this.f37198e = false;
            a.this.e();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f37194a.b0(((Float) valueAnimator.getAnimatedValue()).floatValue(), a.this.f37194a.getCurrentYOffset());
            a.this.f37194a.Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: AnimationManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class b extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a.this.f37194a.Z();
            a.this.f37198e = false;
            a.this.e();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f37194a.Z();
            a.this.f37198e = false;
            a.this.e();
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f37194a.b0(a.this.f37194a.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
            a.this.f37194a.Y();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* compiled from: AnimationManager.java */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private final float f37201a;

        /* renamed from: b  reason: collision with root package name */
        private final float f37202b;

        public c(float f4, float f5) {
            this.f37201a = f4;
            this.f37202b = f5;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            a.this.f37194a.Z();
            a.this.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a.this.f37194a.Z();
            a.this.f37194a.g0();
            a.this.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.f37194a.t0(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(this.f37201a, this.f37202b));
        }
    }

    public a(PDFView pDFView) {
        this.f37194a = pDFView;
        this.f37196c = new OverScroller(pDFView.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f37194a.getScrollHandle() != null) {
            this.f37194a.getScrollHandle().g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (this.f37196c.computeScrollOffset()) {
            this.f37194a.b0(this.f37196c.getCurrX(), this.f37196c.getCurrY());
            this.f37194a.Y();
        } else if (this.f37197d) {
            this.f37197d = false;
            this.f37194a.Z();
            e();
            this.f37194a.g0();
        }
    }

    public boolean f() {
        return this.f37197d || this.f37198e;
    }

    public void g(int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
        l();
        this.f37197d = true;
        this.f37196c.fling(i4, i5, i6, i7, i8, i9, i10, i11);
    }

    public void h(float f4) {
        if (this.f37194a.Q()) {
            j(this.f37194a.getCurrentYOffset(), f4);
        } else {
            i(this.f37194a.getCurrentXOffset(), f4);
        }
        this.f37198e = true;
    }

    public void i(float f4, float f5) {
        l();
        this.f37195b = ValueAnimator.ofFloat(f4, f5);
        C0544a c0544a = new C0544a();
        this.f37195b.setInterpolator(new DecelerateInterpolator());
        this.f37195b.addUpdateListener(c0544a);
        this.f37195b.addListener(c0544a);
        this.f37195b.setDuration(400L);
        this.f37195b.start();
    }

    public void j(float f4, float f5) {
        l();
        this.f37195b = ValueAnimator.ofFloat(f4, f5);
        b bVar = new b();
        this.f37195b.setInterpolator(new DecelerateInterpolator());
        this.f37195b.addUpdateListener(bVar);
        this.f37195b.addListener(bVar);
        this.f37195b.setDuration(400L);
        this.f37195b.start();
    }

    public void k(float f4, float f5, float f6, float f7) {
        l();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f6, f7);
        this.f37195b = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        c cVar = new c(f4, f5);
        this.f37195b.addUpdateListener(cVar);
        this.f37195b.addListener(cVar);
        this.f37195b.setDuration(400L);
        this.f37195b.start();
    }

    public void l() {
        ValueAnimator valueAnimator = this.f37195b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f37195b = null;
        }
        m();
    }

    public void m() {
        this.f37197d = false;
        this.f37196c.forceFinished(true);
    }
}
