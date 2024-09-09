package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ClickSlideUpView2 extends SlideUpView {

    /* renamed from: c  reason: collision with root package name */
    private TextView f29508c;

    /* renamed from: f  reason: collision with root package name */
    private AnimatorSet f29509f;
    private ImageView sr;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f29510w;
    private ImageView xv;

    public ClickSlideUpView2(Context context) {
        super(context);
        this.f29509f = new AnimatorSet();
        w(context);
    }

    private void sr() {
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.setDuration(2000L);
        ofInt.setRepeatCount(-1);
        ofInt.start();
    }

    private void w(Context context) {
        addView(com.bytedance.sdk.component.adexpress.xv.c.w(context));
        this.f29510w = (ImageView) findViewById(2097610751);
        this.xv = (ImageView) findViewById(2097610750);
        this.sr = (ImageView) findViewById(2097610749);
        this.f29508c = (TextView) findViewById(2097610748);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void c() {
        sr();
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    protected void c(Context context) {
    }

    public float getAlphaColor() {
        return this.ux;
    }

    public void setAlphaColor(int i4) {
        if (i4 < 0 || i4 > 60) {
            return;
        }
        int i5 = i4 + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.sr.setColorFilter(Color.rgb(i5, i5, i5), PorterDuff.Mode.SRC_IN);
        int i6 = ((i4 + 20) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.xv.setColorFilter(Color.rgb(i6, i6, i6), PorterDuff.Mode.SRC_IN);
        int i7 = ((i4 + 40) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.f29510w.setColorFilter(Color.rgb(i7, i7, i7), PorterDuff.Mode.SRC_IN);
    }

    public void setButtonText(String str) {
        if (this.f29508c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f29508c.setText(str);
    }

    @Override // com.bytedance.sdk.component.adexpress.widget.SlideUpView
    public void w() {
        this.f29509f.cancel();
    }
}
