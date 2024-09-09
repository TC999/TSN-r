package com.bytedance.sdk.component.adexpress.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ClickInteractView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f29503c;

    /* renamed from: w  reason: collision with root package name */
    private AnimatorSet f29504w;

    public ClickInteractView(Context context) {
        super(context);
        xv();
        sr();
    }

    private void sr() {
        this.f29504w = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29503c, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat.setDuration(2000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f29503c, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        ofFloat2.setDuration(2000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.f29504w.playTogether(ofFloat, ofFloat2);
    }

    private void xv() {
        ImageView imageView = new ImageView(getContext());
        this.f29503c = imageView;
        imageView.setImageResource(i.sr(getContext(), "tt_white_hand"));
        int c4 = (int) f.c(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c4, c4);
        layoutParams.gravity = 17;
        addView(this.f29503c, layoutParams);
    }

    public void c() {
        AnimatorSet animatorSet = this.f29504w;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void w() {
        AnimatorSet animatorSet = this.f29504w;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
