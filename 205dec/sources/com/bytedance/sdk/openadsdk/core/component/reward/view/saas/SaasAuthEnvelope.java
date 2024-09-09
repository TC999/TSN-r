package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.content.Context;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SaasAuthEnvelope extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private AnimationSet f32670c;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f32671w;
    private ImageView xv;

    public SaasAuthEnvelope(@NonNull Context context) {
        super(context);
        c(context);
        setVisibility(8);
    }

    private void c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        linearLayout.setId(2114387463);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        addView(linearLayout);
        ImageView imageView = new ImageView(context);
        this.xv = imageView;
        try {
            imageView.setImageResource(i.sr(context, "tt_saas_red_envelope"));
        } catch (Error unused) {
        }
        linearLayout.addView(this.xv, new LinearLayout.LayoutParams(-2, -2));
        ImageView imageView2 = new ImageView(context);
        this.f32671w = imageView2;
        try {
            imageView2.setImageResource(i.sr(context, "tt_saas_close"));
        } catch (Error unused2) {
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = xk.ux(context, 25.0f);
        linearLayout.addView(this.f32671w, layoutParams2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f32671w;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void w() {
        AnimationSet animationSet = this.f32670c;
        if (animationSet != null) {
            animationSet.cancel();
            this.f32670c = null;
        }
        setVisibility(8);
    }

    public void c() {
        setVisibility(0);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration(800L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
        alphaAnimation.setDuration(800L);
        AnimationSet animationSet = new AnimationSet(true);
        this.f32670c = animationSet;
        animationSet.addAnimation(alphaAnimation);
        this.f32670c.addAnimation(scaleAnimation);
        startAnimation(this.f32670c);
    }
}
