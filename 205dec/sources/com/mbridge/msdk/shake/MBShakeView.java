package com.mbridge.msdk.shake;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mbridge.msdk.foundation.tools.ac;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class MBShakeView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f40458a;

    /* renamed from: b  reason: collision with root package name */
    private Animation f40459b;

    public MBShakeView(Context context) {
        super(context);
    }

    public void initView(String str) {
        initView(str, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        RotateAnimation rotateAnimation = new RotateAnimation(-10.0f, 10.0f, 1, 0.5f, 1, 0.5f);
        this.f40459b = rotateAnimation;
        rotateAnimation.setDuration(100L);
        this.f40459b.setRepeatMode(2);
        this.f40459b.setRepeatCount(-1);
        this.f40458a.startAnimation(this.f40459b);
    }

    public MBShakeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void initView(String str, boolean z3) {
        setOrientation(1);
        setGravity(1);
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new LinearLayout.LayoutParams(ac.b(getContext(), z3 ? 60.0f : 80.0f), ac.b(getContext(), z3 ? 60.0f : 80.0f)));
        int parseColor = Color.parseColor("#80000000");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(parseColor);
        gradientDrawable.setCornerRadius(200);
        imageView.setBackground(gradientDrawable);
        this.f40458a = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ac.b(getContext(), z3 ? 20.0f : 40.0f), ac.b(getContext(), z3 ? 20.0f : 40.0f));
        layoutParams.gravity = 17;
        this.f40458a.setLayoutParams(layoutParams);
        this.f40458a.setImageResource(getResources().getIdentifier("mbridge_splash_btn_shake", "drawable", com.mbridge.msdk.foundation.controller.a.f().d()));
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        frameLayout.addView(imageView);
        frameLayout.addView(this.f40458a);
        TextView textView = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ac.b(getContext(), 10.0f);
        textView.setLayoutParams(layoutParams2);
        textView.setGravity(17);
        if (getContext().getResources().getConfiguration().locale.getLanguage().contains("en")) {
            textView.setText("Shake your phone");
        } else {
            textView.setText("\u6447\u52a8\u624b\u673a \u6216 \u70b9\u51fb\u56fe\u6807");
        }
        textView.setTextSize(z3 ? 16.0f : 20.0f);
        textView.setTextColor(-1);
        textView.setShadowLayer(8.0f, 3.0f, 3.0f, -16777216);
        if (TextUtils.isEmpty(str)) {
            str = getContext().getResources().getConfiguration().locale.getLanguage().contains("en") ? "Redirect to third party application" : "\u6d4f\u89c8\u7b2c\u4e09\u65b9\u5e94\u7528";
        }
        TextView textView2 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = ac.b(getContext(), 5.0f);
        textView2.setLayoutParams(layoutParams3);
        textView2.setGravity(17);
        textView2.setText(str);
        textView2.setTextSize(z3 ? 12.0f : 16.0f);
        textView2.setTextColor(-1);
        textView2.setShadowLayer(8.0f, 3.0f, 3.0f, -16777216);
        addView(frameLayout);
        addView(textView);
        addView(textView2);
    }

    public MBShakeView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
    }

    public MBShakeView(Context context, AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
    }
}
