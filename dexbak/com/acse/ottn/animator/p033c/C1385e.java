package com.acse.ottn.animator.p033c;

import android.animation.Animator;
import com.acse.ottn.animator.p031a.AbstractC1334a;

/* renamed from: com.acse.ottn.animator.c.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class C1385e implements Animator.AnimatorListener {

    /* renamed from: a */
    final /* synthetic */ AbstractC1334a.InterfaceC1335a f2466a;

    /* renamed from: b */
    final /* synthetic */ C1386f f2467b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1385e(C1386f c1386f, AbstractC1334a.InterfaceC1335a interfaceC1335a) {
        this.f2467b = c1386f;
        this.f2466a = interfaceC1335a;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.f2466a.mo56855c(null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f2466a.mo56852a(null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        this.f2466a.mo56856b(null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f2466a.mo56854d(null);
    }
}
