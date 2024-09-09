package com.qq.e.comm.plugin.splash.s;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.b.k;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class h extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private final TextView f46223c;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Animator.AnimatorListener {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            h.this.setVisibility(0);
            h.this.setAlpha(0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, k.b bVar, int i4) {
        super(context);
        LinearLayout linearLayout = new LinearLayout(getContext());
        int i5 = d.f46195c;
        int i6 = d.f46197e;
        linearLayout.setPadding(i6, i5, i6, i5);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(50.0f);
        gradientDrawable.setAlpha(77);
        linearLayout.setBackgroundDrawable(gradientDrawable);
        linearLayout.setGravity(17);
        TextView textView = new TextView(getContext());
        textView.setText("\u8df3\u8fc7");
        textView.setTextSize(2, 13.0f);
        textView.setTextColor(-1);
        textView.setIncludeFontPadding(false);
        textView.setGravity(17);
        linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        TextView textView2 = new TextView(getContext());
        this.f46223c = textView2;
        textView2.setText(String.format("%d", Integer.valueOf(Math.round(i4 / 1000.0f))));
        this.f46223c.setTextSize(2, 13.0f);
        this.f46223c.setTextColor(-1);
        this.f46223c.setIncludeFontPadding(false);
        this.f46223c.setGravity(17);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = i5;
        linearLayout.addView(this.f46223c, layoutParams);
        setId(2);
        setPadding(bVar.f42016a, bVar.f42017b, bVar.f42018c, bVar.f42019d);
        addView(linearLayout);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        setVisibility(8);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, View.ALPHA, 0.0f, 1.0f);
        ofFloat.setDuration(500);
        ofFloat.setInterpolator(accelerateDecelerateInterpolator);
        ofFloat.setStartDelay(1000);
        ofFloat.addListener(new a());
        ofFloat.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j4) {
        this.f46223c.setText(String.format("%d", Integer.valueOf(Math.round(((float) j4) / 1000.0f))));
    }
}
