package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.sr;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SlideUp3DView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Context f29617c;
    private TextView sr;
    private AnimationDrawable ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f29618w;
    private TextView xv;

    public SlideUp3DView(Context context) {
        super(context);
        this.f29617c = context;
        c();
    }

    private void sr() {
        this.ux = new AnimationDrawable();
        c(100, "tt_slide_up_1");
        c(100, "tt_slide_up_2");
        c(100, "tt_slide_up_3");
        c(100, "tt_slide_up_4");
        c(100, "tt_slide_up_5");
        c(100, "tt_slide_up_6");
        c(100, "tt_slide_up_7");
        c(100, "tt_slide_up_8");
        c(100, "tt_slide_up_9");
        c(100, "tt_slide_up_10");
        c(120, "tt_slide_up_11");
        c(120, "tt_slide_up_12");
        c(120, "tt_slide_up_13");
        c(120, "tt_slide_up_14");
        c(120, "tt_slide_up_15");
        this.ux.setOneShot(false);
    }

    public void c() {
        this.f29618w = new ImageView(this.f29617c);
        this.sr = new TextView(this.f29617c);
        this.xv = new TextView(this.f29617c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f.c(this.f29617c, 200.0f), (int) f.c(this.f29617c, 200.0f));
        layoutParams.gravity = 49;
        layoutParams.bottomMargin = (int) f.c(this.f29617c, 70.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = (int) f.c(this.f29617c, 25.0f);
        this.sr.setText(i.w(this.f29617c, "tt_slide_up_3d"));
        this.sr.setTextColor(-1);
        this.sr.setTextSize(24.0f);
        this.sr.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#59000000"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        this.xv.setShadowLayer(4.0f, 3.0f, 3.0f, Color.parseColor("#59000000"));
        this.xv.setTextColor(-1);
        this.xv.setTextSize(14.0f);
        addView(this.f29618w, layoutParams);
        if (!sr.c()) {
            addView(this.sr, layoutParams2);
        }
        addView(this.xv, layoutParams3);
    }

    public void setGuideText(String str) {
        this.xv.setText(str);
    }

    public void w() {
        if (this.ux == null) {
            sr();
        }
        this.f29618w.setImageDrawable(this.ux);
        this.ux.start();
    }

    public void xv() {
        AnimationDrawable animationDrawable = this.ux;
        if (animationDrawable != null) {
            animationDrawable.stop();
            this.ux = null;
        }
    }

    private void c(int i4, String str) {
        this.ux.addFrame(i.xv(this.f29617c, str), i4);
    }
}
