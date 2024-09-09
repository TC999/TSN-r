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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class ScrollAwareFABBehavior extends FloatingActionButton.Behavior {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f18334a;

        a(View view) {
            this.f18334a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f18334a.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f18336a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f18337b;

        b(View view) {
            this.f18337b = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f18336a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f18336a) {
                return;
            }
            this.f18337b.setVisibility(4);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f18337b.setVisibility(0);
            this.f18336a = false;
        }
    }

    public ScrollAwareFABBehavior(Context context, AttributeSet attributeSet) {
    }

    private void hide(View view) {
        view.animate().cancel();
        view.animate().scaleX(0.0f).scaleY(0.0f).alpha(0.0f).setDuration(200L).setInterpolator(new FastOutLinearInInterpolator()).setListener(new b(view));
    }

    private void show(View view) {
        view.animate().cancel();
        view.setAlpha(0.0f);
        view.setScaleY(0.0f);
        view.setScaleX(0.0f);
        view.animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(200L).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new a(view));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, int i4, int i5, int i6, int i7) {
        super.onNestedScroll(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view, i4, i5, i6, i7);
        if (i5 > 10 && floatingActionButton.getVisibility() == 0) {
            hide(floatingActionButton);
        } else if (i5 >= -10 || floatingActionButton.getVisibility() == 0) {
        } else {
            show(floatingActionButton);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view, View view2, int i4) {
        return i4 == 2 || super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) floatingActionButton, view, view2, i4);
    }
}
