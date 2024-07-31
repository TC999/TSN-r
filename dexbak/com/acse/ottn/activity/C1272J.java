package com.acse.ottn.activity;

import android.animation.ValueAnimator;
import android.widget.TextView;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.activity.J */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1272J implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    final /* synthetic */ SeedingLoadingActivity f2116a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1272J(SeedingLoadingActivity seedingLoadingActivity) {
        this.f2116a = seedingLoadingActivity;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        TextView textView;
        String[] strArr;
        String[] strArr2;
        int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        textView = this.f2116a.f2151m;
        strArr = this.f2116a.f2145g;
        strArr2 = this.f2116a.f2145g;
        textView.setText(strArr[intValue % strArr2.length]);
    }
}
