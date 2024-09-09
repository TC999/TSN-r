package com.bytedance.sdk.openadsdk.core.component.reward.view.saas;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class BaseSaasEnvelope extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private View f32665c;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f32666w;
    private AnimatorSet xv;

    public BaseSaasEnvelope(Context context) {
        super(context);
    }

    private View w(Context context) {
        String gd = wv.gd(getContext());
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = xk.ux(context, 80.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 10.0f);
        textView.setGravity(17);
        textView.setText("\u5173\u8054\u540e" + gd + "\u5c06\u83b7\u53d6\u4f60\u7684\u6296\u97f3\u5934\u50cf\u548c\u6635\u79f0");
        textView.setTextColor(Color.parseColor("#AAFFFFFF"));
        return textView;
    }

    public abstract void c();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Context context, String str, RelativeLayout relativeLayout) {
        View c4 = c(context, str);
        this.f32665c = c4;
        relativeLayout.addView(c4);
        relativeLayout.addView(w(context));
        this.f32665c.setTag(TTAdConstant.KEY_CLICK_AREA, 2917);
        addView(c(context, relativeLayout));
        ImageView imageView = new ImageView(context);
        this.f32666w = imageView;
        imageView.setImageResource(i.sr(context, "tt_saas_close"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(3, relativeLayout.getId());
        layoutParams.topMargin = xk.ux(context, 25.0f);
        addView(this.f32666w, layoutParams);
    }

    public void setOnButtonClickListener(final View.OnClickListener onClickListener) {
        View view = this.f32665c;
        if (view == null || onClickListener == null) {
            return;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.saas.BaseSaasEnvelope.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                BaseSaasEnvelope.this.w();
                onClickListener.onClick(view2);
            }
        });
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f32666w;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void w() {
        AnimatorSet animatorSet = this.xv;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.xv = null;
        }
    }

    private View c(Context context, String str) {
        TextView textView = new TextView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(xk.ux(context, 166.0f), xk.ux(context, 40.0f));
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = xk.ux(context, 26.0f);
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, 16.0f);
        textView.setGravity(17);
        textView.setText(str);
        textView.setTextColor(Color.parseColor("#9D301A"));
        textView.setTypeface(null, 1);
        int ux = xk.ux(context, 40.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        float f4 = ux;
        gradientDrawable.setCornerRadii(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        gradientDrawable.setColors(new int[]{Color.parseColor("#F2AC5F"), Color.parseColor("#FFEECC")});
        textView.setBackground(gradientDrawable);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "scaleX", 1.0f, 1.05f, 1.0f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(2);
        ofFloat.setDuration(800L);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, "scaleY", 1.0f, 1.05f, 1.0f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setDuration(800L);
        AnimatorSet animatorSet = new AnimatorSet();
        this.xv = animatorSet;
        animatorSet.play(ofFloat).with(ofFloat2);
        this.xv.start();
        return textView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RelativeLayout c(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(xk.ux(getContext(), 301.0f), xk.ux(getContext(), 344.0f));
        layoutParams.addRule(13);
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setId(2114387457);
        return relativeLayout;
    }

    private View c(Context context, View view) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(i.sr(context, "tt_saas_reward_title"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(2, view.getId());
        layoutParams.setMargins(0, 0, 0, xk.ux(context, 20.0f));
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }
}
