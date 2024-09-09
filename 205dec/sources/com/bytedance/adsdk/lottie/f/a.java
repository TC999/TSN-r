package com.bytedance.adsdk.lottie.f;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class a extends ValueAnimator {

    /* renamed from: a  reason: collision with root package name */
    private final Set<ValueAnimator.AnimatorUpdateListener> f25601a = new CopyOnWriteArraySet();

    /* renamed from: b  reason: collision with root package name */
    private final Set<Animator.AnimatorListener> f25602b = new CopyOnWriteArraySet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<Animator.AnimatorPauseListener> f25603c = new CopyOnWriteArraySet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        for (Animator.AnimatorListener animatorListener : this.f25602b) {
            animatorListener.onAnimationRepeat(this);
        }
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.f25602b.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f25603c.add(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f25601a.add(animatorUpdateListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(boolean z3) {
        for (Animator.AnimatorListener animatorListener : this.f25602b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z3);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        if (Build.VERSION.SDK_INT >= 19) {
            for (Animator.AnimatorPauseListener animatorPauseListener : this.f25603c) {
                animatorPauseListener.onAnimationPause(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (Build.VERSION.SDK_INT >= 19) {
            for (Animator.AnimatorPauseListener animatorPauseListener : this.f25603c) {
                animatorPauseListener.onAnimationResume(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z3) {
        for (Animator.AnimatorListener animatorListener : this.f25602b) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z3);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        for (ValueAnimator.AnimatorUpdateListener animatorUpdateListener : this.f25601a) {
            animatorUpdateListener.onAnimationUpdate(this);
        }
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.f25602b.clear();
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.f25601a.clear();
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.f25602b.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.f25603c.remove(animatorPauseListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f25601a.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j4) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        for (Animator.AnimatorListener animatorListener : this.f25602b) {
            animatorListener.onAnimationCancel(this);
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j4) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }
}
