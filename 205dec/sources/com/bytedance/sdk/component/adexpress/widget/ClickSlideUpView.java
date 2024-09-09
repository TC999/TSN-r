package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.sr.f;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ClickSlideUpView extends SlideUpView {

    /* renamed from: c  reason: collision with root package name */
    private TextView f29506c;

    /* renamed from: w  reason: collision with root package name */
    private View f29507w;
    private AnimatorSet xv;

    public ClickSlideUpView(Context context) {
        super(context);
        this.xv = new AnimatorSet();
        w(context);
    }

    private void sr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29507w, "translationY", 0.0f, f.c(getContext(), -3.0f));
        ofFloat.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f29507w, "alpha", 1.0f, 0.8f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setInterpolator(new CycleInterpolator(1.0f));
        ofFloat2.setRepeatCount(-1);
        this.xv.playTogether(ofFloat, ofFloat2);
        this.xv.setDuration(1000L);
        this.xv.start();
    }

    private void w(Context context) {
        View c4 = com.bytedance.sdk.component.adexpress.xv.c.c(context);
        this.f29507w = c4;
        addView(c4);
        setClipChildren(false);
        this.f29506c = (TextView) findViewById(2097610748);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void c() {
        sr();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void c(Context context) {
    }

    public void setButtonText(String str) {
        if (this.f29506c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f29506c.setText(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void w() {
        this.xv.cancel();
    }
}
