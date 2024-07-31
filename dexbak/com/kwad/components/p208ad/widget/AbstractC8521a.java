package com.kwad.components.p208ad.widget;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* renamed from: com.kwad.components.ad.widget.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8521a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: HR */
    private WeakReference<View> f28028HR;

    public AbstractC8521a(View view) {
        this.f28028HR = new WeakReference<>(view);
    }

    /* renamed from: a */
    public abstract void mo30424a(ViewGroup.LayoutParams layoutParams, Object obj);

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        WeakReference<View> weakReference = this.f28028HR;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = this.f28028HR.get();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        mo30424a(layoutParams, valueAnimator.getAnimatedValue());
        view.setLayoutParams(layoutParams);
    }
}
