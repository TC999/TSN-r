package com.acse.ottn.animator.c;

import android.animation.Animator;
import com.acse.ottn.animator.a.AbstractC1361a;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class e implements Animator.AnimatorListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AbstractC1361a.InterfaceC0082a f5008a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ f f5009b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(f fVar, AbstractC1361a.InterfaceC0082a interfaceC0082a) {
        this.f5009b = fVar;
        this.f5008a = interfaceC0082a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f5008a.c(null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f5008a.a(null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.f5008a.b(null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f5008a.d(null);
    }
}
