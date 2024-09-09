package com.qq.e.dl.f;

import android.animation.Animator;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c implements Animator.AnimatorListener {

    /* renamed from: c  reason: collision with root package name */
    private final h f46827c;

    /* renamed from: d  reason: collision with root package name */
    private final int f46828d;

    /* renamed from: e  reason: collision with root package name */
    private b f46829e;

    /* renamed from: f  reason: collision with root package name */
    private int f46830f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f46831g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(h hVar) {
        this.f46827c = hVar;
        this.f46828d = hVar.f46842a.f46914g + 1;
    }

    public void a(b bVar) {
        this.f46829e = bVar;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f46830f = 0;
        this.f46831g = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        b bVar;
        int i4 = this.f46828d;
        if (i4 <= 0 || this.f46831g) {
            return;
        }
        int i5 = this.f46830f + 1;
        this.f46830f = i5;
        if (i5 != i4 || (bVar = this.f46829e) == null) {
            return;
        }
        bVar.a(this.f46827c.f46842a.f46909b);
        this.f46830f = 0;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.f46830f++;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f46831g = false;
    }
}
