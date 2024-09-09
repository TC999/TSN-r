package com.bytedance.sdk.openadsdk.core.dislike.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTDislikeToast extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Handler f33133c;

    /* renamed from: w  reason: collision with root package name */
    private TextView f33134w;

    public TTDislikeToast(Context context) {
        this(context, null);
    }

    public void w() {
        try {
            c(i.c(getContext(), "tt_dislike_feedback_repeat"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void xv() {
        setVisibility(8);
        this.f33133c.removeCallbacksAndMessages(null);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c(Context context) {
        TextView textView = new TextView(context);
        this.f33134w = textView;
        textView.setClickable(false);
        this.f33134w.setFocusable(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        int c4 = com.bytedance.sdk.openadsdk.core.dislike.c.c.w().c(getContext(), 20.0f);
        int c5 = com.bytedance.sdk.openadsdk.core.dislike.c.c.w().c(getContext(), 12.0f);
        this.f33134w.setPadding(c4, c5, c4, c5);
        this.f33134w.setLayoutParams(layoutParams);
        this.f33134w.setTextColor(-1);
        this.f33134w.setTextSize(16.0f);
        this.f33134w.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#CC000000"));
        gradientDrawable.setCornerRadius(com.bytedance.sdk.openadsdk.core.dislike.c.c.w().c(getContext(), 6.0f));
        this.f33134w.setBackgroundDrawable(gradientDrawable);
        addView(this.f33134w);
    }

    public TTDislikeToast(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f33133c = new Handler(Looper.getMainLooper());
        setVisibility(8);
        setClickable(false);
        setFocusable(false);
        c(context);
    }

    public void c(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f33133c.removeCallbacksAndMessages(null);
        this.f33133c.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.1
            @Override // java.lang.Runnable
            public void run() {
                if (TTDislikeToast.this.f33134w != null) {
                    TTDislikeToast.this.f33134w.setText(String.valueOf(str));
                }
                TTDislikeToast.this.setVisibility(0);
            }
        });
        this.f33133c.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.dislike.ui.TTDislikeToast.2
            @Override // java.lang.Runnable
            public void run() {
                TTDislikeToast.this.setVisibility(8);
            }
        }, 2000L);
    }

    public void c() {
        c(i.c(getContext(), "tt_dislike_feedback_success"));
    }
}
