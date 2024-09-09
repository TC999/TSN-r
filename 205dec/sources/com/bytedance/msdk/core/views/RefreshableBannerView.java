package com.bytedance.msdk.core.views;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.UiThread;
import com.bytedance.msdk.adapter.sr.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RefreshableBannerView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private boolean f28253c;

    /* renamed from: f  reason: collision with root package name */
    private c f28254f;
    private final Rect sr;
    private final ViewTreeObserver.OnScrollChangedListener ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f28255w;
    private boolean xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(boolean z3);
    }

    public RefreshableBannerView(Context context) {
        super(context);
        this.f28253c = true;
        this.f28255w = true;
        this.xv = true;
        this.sr = new Rect();
        this.ux = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.1
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public void onScrollChanged() {
                RefreshableBannerView refreshableBannerView = RefreshableBannerView.this;
                refreshableBannerView.f28255w = refreshableBannerView.getGlobalVisibleRect(refreshableBannerView.sr);
                RefreshableBannerView refreshableBannerView2 = RefreshableBannerView.this;
                refreshableBannerView2.c(refreshableBannerView2.f28255w);
            }
        };
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnScrollChangedListener(this.ux);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnScrollChangedListener(this.ux);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i4) {
        super.onWindowVisibilityChanged(i4);
        boolean z3 = i4 == 0;
        this.f28253c = z3;
        c(z3);
    }

    public void setVisibilityChangeListener(c cVar) {
        this.f28254f = cVar;
    }

    @UiThread
    public void c(View view) {
        view.setTranslationX(getWidth());
        addView(view);
        ObjectAnimator.ofFloat(view, "translationX", 0.0f).setDuration(250L).start();
        if (getChildCount() > 1) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(getChildAt(0), "translationX", -getWidth()).setDuration(250L);
            duration.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.msdk.core.views.RefreshableBannerView.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (RefreshableBannerView.this.getChildCount() > 1) {
                        RefreshableBannerView.this.removeViewAt(0);
                        xv.c("TMe", "--==-- after remove, view count: " + RefreshableBannerView.this.getChildCount());
                    }
                }
            });
            duration.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z3) {
        boolean z4 = this.f28253c && this.f28255w;
        if (z3) {
            if (!z4 || this.xv) {
                return;
            }
            this.xv = true;
            c cVar = this.f28254f;
            if (cVar != null) {
                cVar.c(true);
            }
        } else if (z4 || !this.xv) {
        } else {
            this.xv = false;
            c cVar2 = this.f28254f;
            if (cVar2 != null) {
                cVar2.c(false);
            }
        }
    }
}
