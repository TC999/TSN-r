package com.bytedance.sdk.openadsdk.core.component.splash;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.mt;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RockView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f32791c;

    /* renamed from: w  reason: collision with root package name */
    private TextView f32792w;
    private TextView xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class c implements Interpolator {
        private c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return f4 <= 0.25f ? (f4 * (-2.0f)) + 0.5f : f4 <= 0.5f ? (f4 * 4.0f) - 1.0f : f4 <= 0.75f ? (f4 * (-4.0f)) + 3.0f : (f4 * 2.0f) - 1.5f;
        }
    }

    public RockView(Context context) {
        super(context);
        w(context);
    }

    private void w(Context context) {
        if (context == null) {
            context = ls.getContext();
        }
        View c4 = c(context);
        if (c4 == null) {
            return;
        }
        addView(c4);
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 110.0f, resources.getDisplayMetrics()));
        layoutParams2.gravity = 17;
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        OvalShape ovalShape = new OvalShape();
        int ux = xk.ux(context, 120.0f);
        shapeDrawable.setShape(ovalShape);
        shapeDrawable.setIntrinsicHeight(ux);
        shapeDrawable.setIntrinsicWidth(ux);
        shapeDrawable.getPaint().setColor(Color.parseColor("#57000000"));
        linearLayout2.setBackground(shapeDrawable);
        linearLayout2.setGravity(17);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(layoutParams2);
        linearLayout.addView(linearLayout2);
        ImageView imageView = new ImageView(context);
        this.f32791c = imageView;
        imageView.setId(2114387565);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        this.f32791c.setImageDrawable(i.xv(context, "tt_splash_rock"));
        this.f32791c.setLayoutParams(layoutParams3);
        linearLayout2.addView(this.f32791c);
        TextView textView = new TextView(context);
        this.f32792w = textView;
        textView.setId(2114387563);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        this.f32792w.setSingleLine();
        this.f32792w.setText(i.c(context, "tt_splash_rock_top"));
        this.f32792w.setTextColor(-1);
        this.f32792w.setTextSize(14.0f);
        this.f32792w.setLayoutParams(layoutParams4);
        linearLayout2.addView(this.f32792w);
        TextView textView2 = new TextView(context);
        this.xv = textView2;
        textView2.setId(2114387562);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.gravity = 17;
        layoutParams5.topMargin = xk.ux(context, 12.0f);
        this.xv.setLayoutParams(layoutParams5);
        this.xv.setText(i.c(context, "tt_splash_rock_desc"));
        this.xv.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#99000000"));
        this.xv.setTextColor(-1);
        linearLayout.addView(this.xv);
        return linearLayout;
    }

    public void c(mt mtVar) {
        setVisibility(0);
        setAlpha(0.0f);
        TextView textView = this.f32792w;
        if (textView != null) {
            textView.setText(mtVar.k());
            this.f32792w.setTextSize(2, mtVar.bk().w());
        }
        TextView textView2 = this.xv;
        if (textView2 != null) {
            textView2.setText(mtVar.w());
            this.xv.setTextSize(2, mtVar.a().w());
            this.xv.setTypeface(Typeface.defaultFromStyle(0));
        }
    }

    public void c() {
        if (this.f32791c != null) {
            final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
            rotateAnimation.setInterpolator(new c());
            rotateAnimation.setDuration(1000L);
            rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    RockView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.RockView.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            RockView.this.f32791c.startAnimation(rotateAnimation);
                        }
                    }, 250L);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }
            });
            this.f32791c.startAnimation(rotateAnimation);
        }
    }
}
