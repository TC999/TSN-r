package com.kwad.components.p208ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.splashscreen.widget.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8513b extends KSFrameLayout {

    /* renamed from: FQ */
    private Animator f27970FQ;

    /* renamed from: FR */
    private boolean f27971FR;

    public AbstractC8513b(@NonNull Context context) {
        this(context, null, 0);
    }

    /* renamed from: a */
    protected void mo30459a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        Animator animator = this.f27970FQ;
        if (animator != null) {
            animator.cancel();
        }
    }

    protected abstract int getAnimationDelayTime();

    protected abstract View getInteractionView();

    /* renamed from: lR */
    protected abstract void mo30456lR();

    /* renamed from: lS */
    protected abstract Animator mo30455lS();

    /* renamed from: lT */
    protected abstract void mo30454lT();

    /* renamed from: lU */
    public final void m30453lU() {
        this.f27971FR = true;
        Animator animator = this.f27970FQ;
        if (animator != null) {
            animator.cancel();
        }
    }

    @MainThread
    /* renamed from: lo */
    public final void m30452lo() {
        Animator animator = this.f27970FQ;
        if (animator != null) {
            animator.cancel();
            this.f27970FQ = null;
        }
        Animator mo30455lS = mo30455lS();
        this.f27970FQ = mo30455lS;
        if (mo30455lS != null) {
            mo30455lS.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.b.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    AbstractC8513b.this.mo30454lT();
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (AbstractC8513b.this.f27971FR) {
                        return;
                    }
                    AbstractC8513b.this.getInteractionView().postDelayed(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.splashscreen.widget.b.1.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            if (AbstractC8513b.this.f27970FQ != null) {
                                AbstractC8513b.this.f27970FQ.start();
                            }
                        }
                    }, AbstractC8513b.this.getAnimationDelayTime());
                }
            });
            this.f27970FQ.start();
        }
    }

    public AbstractC8513b(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractC8513b(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27971FR = false;
        mo30459a(context, attributeSet, i);
        mo30456lR();
    }
}
