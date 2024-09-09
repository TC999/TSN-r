package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class CircleLongPressView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Context f29492c;

    /* renamed from: f  reason: collision with root package name */
    private AnimatorSet f29493f;
    private TextView sr;
    private RingProgressView ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f29494w;
    private ImageView xv;

    public CircleLongPressView(Context context) {
        super(context);
        this.f29493f = new AnimatorSet();
        this.f29492c = context;
        ux();
        f();
    }

    private void f() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xv, "scaleX", 1.0f, 0.9f);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.setRepeatMode(2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xv, "scaleY", 1.0f, 0.9f);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f29493f.setDuration(800L);
        this.f29493f.playTogether(ofFloat, ofFloat2);
    }

    private void ux() {
        FrameLayout frameLayout = new FrameLayout(this.f29492c);
        this.ux = new RingProgressView(this.f29492c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f.c(this.f29492c, 95.0f), (int) f.c(this.f29492c, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.ux, layoutParams);
        ImageView imageView = new ImageView(this.f29492c);
        this.f29494w = imageView;
        imageView.setImageResource(i.sr(this.f29492c, "tt_interact_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) f.c(this.f29492c, 75.0f), (int) f.c(this.f29492c, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.f29494w, layoutParams2);
        ImageView imageView2 = new ImageView(this.f29492c);
        this.xv = imageView2;
        imageView2.setImageResource(i.sr(this.f29492c, "tt_interact_oval"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) f.c(this.f29492c, 63.0f), (int) f.c(this.f29492c, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.xv, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.f29492c);
        this.sr = textView;
        textView.setTextColor(-1);
        this.sr.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.sr, layoutParams4);
    }

    public void c() {
        this.f29493f.start();
    }

    public void setGuideText(String str) {
        this.sr.setText(str);
    }

    public void sr() {
        this.ux.w();
        this.ux.xv();
    }

    public void w() {
        this.f29493f.cancel();
    }

    public void xv() {
        this.ux.c();
    }
}
