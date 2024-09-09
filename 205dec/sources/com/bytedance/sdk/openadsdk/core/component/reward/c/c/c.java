package com.bytedance.sdk.openadsdk.core.component.reward.c.c;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.component.ux.fp;
import com.bytedance.sdk.component.ux.k;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import com.bytedance.sdk.openadsdk.core.component.reward.activity.TTBaseVideoActivity;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.gd;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.w.w;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private final TTBaseVideoActivity f32230c;
    private ObjectAnimator ev;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f32231f;
    private ObjectAnimator gd;

    /* renamed from: p  reason: collision with root package name */
    private final w f32232p;

    /* renamed from: r  reason: collision with root package name */
    private TextView f32233r;
    private ViewGroup sr;
    private View ux;

    /* renamed from: w  reason: collision with root package name */
    private final me f32234w;
    private ImageView xv;

    public c(TTBaseVideoActivity tTBaseVideoActivity, me meVar, w wVar) {
        this.f32230c = tTBaseVideoActivity;
        this.f32234w = meVar;
        this.f32232p = wVar;
    }

    private int ux() {
        int identifier = this.f32230c.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.f32230c.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void c(ViewGroup viewGroup, View view) {
        this.sr = viewGroup;
        this.ux = view;
        this.xv = new ImageView(this.f32230c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, xk.ux(this.f32230c, 76.0f));
        layoutParams.gravity = 80;
        this.xv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.sr.addView(this.xv, layoutParams);
    }

    public void sr() {
        ObjectAnimator objectAnimator = this.ev;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.ev.cancel();
            this.ev = null;
        }
        ObjectAnimator objectAnimator2 = this.gd;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.gd.cancel();
            this.gd = null;
        }
        LinearLayout linearLayout = this.f32231f;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.ux;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ImageView imageView = this.xv;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.f32232p.ev();
    }

    public int w() {
        int identifier = this.f32230c.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return this.f32230c.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void xv() {
        sr();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.ux, "alpha", 1.0f, 0.3f);
        ofFloat.setDuration(1000L);
        ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.c.c.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.ux.setAlpha(1.0f);
                c.this.f32232p.gd();
            }
        });
        ofFloat.start();
    }

    public void c() {
        int ux;
        LinearLayout linearLayout = new LinearLayout(this.f32230c);
        this.f32231f = linearLayout;
        linearLayout.setGravity(1);
        this.f32231f.setPadding(0, xk.ux(this.f32230c, 16.0f), 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, xk.ux(this.f32230c, 76.0f));
        TextView textView = new TextView(this.f32230c);
        this.f32233r = textView;
        textView.setTextSize(12.0f);
        this.f32233r.setTextColor(-1);
        this.f32233r.setSingleLine();
        this.f32233r.setEllipsize(TextUtils.TruncateAt.START);
        this.f32233r.setGravity(5);
        this.f32233r.setMaxWidth(xk.ux(this.f32230c, 260.0f));
        this.f32231f.addView(this.f32233r);
        TextView textView2 = new TextView(this.f32230c);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        textView2.setSingleLine();
        textView2.setText("\u53d6\u6d88");
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.c.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.sr();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = xk.ux(this.f32230c, 10.0f);
        this.f32231f.addView(textView2, layoutParams2);
        c(25, ng.w(this.f32234w));
        int ux2 = xk.ux(this.f32230c, 76.0f);
        this.sr.addView(this.f32231f, layoutParams);
        try {
            int w3 = f.w(this.f32230c);
            if (xk.xv((Activity) this.f32230c)) {
                ux = (f.xv(this.f32230c) - w3) - w();
            } else {
                ux = ux();
            }
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f32231f, "translationY", w3, (w3 - ux2) + ux);
            this.ev = ofFloat;
            ofFloat.setDuration(300L);
            this.ev.start();
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.ux, "translationY", 0.0f, -ux2);
            this.gd = ofFloat2;
            ofFloat2.setDuration(300L);
            this.gd.start();
        } catch (Throwable th) {
            a.f("layout", "" + th.getMessage());
        }
    }

    public void c(final int i4, String str) {
        com.bytedance.sdk.openadsdk.r.w.c(str).xv(2).c(Bitmap.Config.ARGB_8888).c(new fp<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.c.c.c.2
            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(2)
            public void c(int i5, String str2, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.ux.fp
            @ATSMethod(1)
            public void c(k<Bitmap> kVar) {
                try {
                    Bitmap xv = kVar.xv();
                    if (xv == null) {
                        return;
                    }
                    if (xv.getConfig() == Bitmap.Config.RGB_565) {
                        xv = xv.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    Bitmap c4 = com.bytedance.sdk.component.adexpress.sr.c.c(c.this.f32230c, xv, i4);
                    if (c4 == null) {
                        return;
                    }
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(c.this.f32230c.getResources(), c4);
                    c.this.f32231f.setBackgroundColor(Color.parseColor("#66000000"));
                    c.this.xv.setImageDrawable(bitmapDrawable);
                } catch (Throwable th) {
                    a.f("layout", th.getMessage());
                }
            }
        });
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar) {
        gd gdVar = new gd();
        gdVar.w(true);
        if (wVar != null) {
            wVar.c(gdVar);
            wVar.c(null, gdVar);
        }
    }

    public void c(long j4) {
        TextView textView = this.f32233r;
        if (textView != null) {
            textView.setText("\u5df2\u4e3a\u60a8\u52a0\u8f7d\u66f4\u591a\u8be6\u60c5\uff0c" + j4 + "\u79d2\u540e\u62c9\u8d77\u5c55\u793a");
        }
    }
}
