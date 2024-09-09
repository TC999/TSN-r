package com.bytedance.sdk.openadsdk.core.component.reward.layout;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends w {
    LinearLayout bk;
    private AnimationDrawable fp;

    /* renamed from: t  reason: collision with root package name */
    private ImageView f32446t;
    private ImageView ys;

    public gd(TTBaseVideoActivity tTBaseVideoActivity, me meVar, boolean z3) {
        super(tTBaseVideoActivity, meVar, z3);
    }

    private void sr() {
        this.fp = new AnimationDrawable();
        c(40, "tt_live_loading_0");
        c(40, "tt_live_loading_1");
        c(40, "tt_live_loading_2");
        c(40, "tt_live_loading_3");
        c(40, "tt_live_loading_4");
        c(40, "tt_live_loading_5");
        c(40, "tt_live_loading_6");
        c(40, "tt_live_loading_7");
        c(40, "tt_live_loading_8");
        c(40, "tt_live_loading_9");
        c(40, "tt_live_loading_10");
        c(40, "tt_live_loading_11");
        c(40, "tt_live_loading_12");
        c(40, "tt_live_loading_13");
        c(40, "tt_live_loading_14");
        c(40, "tt_live_loading_15");
        c(40, "tt_live_loading_16");
        c(40, "tt_live_loading_17");
        c(40, "tt_live_loading_18");
        c(40, "tt_live_loading_19");
        c(40, "tt_live_loading_20");
        c(40, "tt_live_loading_21");
        c(40, "tt_live_loading_22");
        c(40, "tt_live_loading_23");
        AnimationDrawable animationDrawable = this.fp;
        if (animationDrawable != null) {
            animationDrawable.setOneShot(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.reward.layout.w
    public void c() {
        super.c();
        this.f32446t = new ImageView(this.f32472w);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        this.f32446t.setAdjustViewBounds(true);
        this.f32446t.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f32446t.setLayoutParams(layoutParams);
        this.f32471r.addView(this.f32446t);
        View view = new View(this.f32472w);
        view.setBackgroundColor(Color.parseColor("#A6000000"));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f32471r.addView(view);
        LinearLayout linearLayout = new LinearLayout(this.f32472w);
        this.bk = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(this.f32472w);
        textView.setTextColor(-1);
        textView.setTextSize(14.0f);
        textView.setText(i.c(this.f32472w, "tt_reward_live_grant"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = 24;
        textView.setLayoutParams(layoutParams2);
        this.ys = new ImageView(this.f32472w);
        this.ys.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.ys.setImageDrawable(i.xv(this.f32472w, "tt_live_loading"));
        this.bk.addView(this.ys);
        this.bk.addView(textView);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        this.bk.setLayoutParams(layoutParams3);
        this.f32471r.addView(this.bk);
        this.bk.setVisibility(8);
        String w3 = ng.w(this.xv);
        if (TextUtils.isEmpty(w3)) {
            return;
        }
        com.bytedance.sdk.openadsdk.r.w.c(w3).c(this.f32471r.getWidth()).w(this.f32471r.getHeight()).c(this.f32446t);
    }

    public void w() {
        if (this.fp == null) {
            sr();
        }
        AnimationDrawable animationDrawable = this.fp;
        if (animationDrawable != null) {
            this.ys.setImageDrawable(animationDrawable);
            this.fp.start();
        }
        this.bk.setVisibility(0);
    }

    public void xv() {
        AnimationDrawable animationDrawable = this.fp;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.fp = null;
        }
    }

    private void c(int i4, String str) {
        AnimationDrawable animationDrawable = this.fp;
        if (animationDrawable != null) {
            animationDrawable.addFrame(i.xv(this.f32472w, str), i4);
        }
    }
}
