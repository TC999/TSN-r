package com.bxkj.base.util;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.util.ScrollAwareFABBehavior$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3888a extends AnimatorListenerAdapter {

        /* renamed from: a */
        final /* synthetic */ View f14850a;

        C3888a(View view) {
            this.f14850a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f14850a.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.base.util.ScrollAwareFABBehavior$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class C3889b extends AnimatorListenerAdapter {

        /* renamed from: a */
        private boolean f14852a;

        /* renamed from: b */
        final /* synthetic */ View f14853b;

        C3889b(View view) {
            this.f14853b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f14852a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f14852a) {
                return;
            }
            this.f14853b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f14853b.setVisibility(0);
            this.f14852a = false;
        }
    }

    public ScrollAwareFABBehavior(Context context, AttributeSet attributeSet) {
    }

    private void hide(View view) {
        view.animate().cancel();
        view.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(new FastOutLinearInInterpolator()).setListener(new C3889b(view));
    }

    private void show(View view) {
        view.animate().cancel();
        view.setAlpha(0.0f);
        view.setScaleY(0.0f);
        view.setScaleX(0.0f);
        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new C3888a(view));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, int i, int i2, int i3, int i4) {
        super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view, i, i2, i3, i4);
        if (i2 > 10 && floatingActionButton.getVisibility() == 0) {
            hide(floatingActionButton);
        } else if (i2 >= -10 || floatingActionButton.getVisibility() == 0) {
        } else {
            show(floatingActionButton);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, View view2, int i) {
        return i == 2 || super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view, view2, i);
    }
}
