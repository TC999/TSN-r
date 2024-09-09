package com.qq.e.dl.f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class m extends AnimatorListenerAdapter {

    /* renamed from: c  reason: collision with root package name */
    private boolean f46870c = false;

    /* renamed from: d  reason: collision with root package name */
    private int f46871d = 0;

    /* renamed from: e  reason: collision with root package name */
    private b f46872e;

    /* renamed from: f  reason: collision with root package name */
    private final com.qq.e.dl.i.a f46873f;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        Animator f46874c;

        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Animator animator = this.f46874c;
            if (animator instanceof ValueAnimator) {
                ((ValueAnimator) animator).reverse();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(com.qq.e.dl.i.a aVar) {
        this.f46873f = aVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f46870c = true;
        this.f46871d = 0;
        b bVar = this.f46872e;
        if (bVar != null) {
            bVar.f46874c = null;
        }
        animator.setStartDelay(this.f46873f.f46911d);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        int i4 = this.f46873f.f46914g;
        if (!this.f46870c && (i4 < 0 || this.f46871d < i4)) {
            this.f46871d++;
            if (this.f46873f.c() && this.f46871d % 2 == 1) {
                if (this.f46872e == null) {
                    this.f46872e = new b();
                }
                this.f46872e.f46874c = animator;
                com.qq.e.dl.j.d.a().postDelayed(this.f46872e, this.f46873f.f46913f);
                return;
            }
            animator.setStartDelay(this.f46873f.f46913f);
            animator.start();
            return;
        }
        this.f46871d = 0;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f46870c = false;
    }
}
