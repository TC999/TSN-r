package com.qq.e.comm.plugin.y;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qq.e.comm.plugin.f0.f;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c implements com.qq.e.comm.plugin.y.b {

    /* renamed from: c  reason: collision with root package name */
    private static int f46786c;

    /* renamed from: d  reason: collision with root package name */
    private static int f46787d;

    /* renamed from: e  reason: collision with root package name */
    private static int f46788e;

    /* renamed from: a  reason: collision with root package name */
    private View f46789a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f46790b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements View.OnAttachStateChangeListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AnimatorSet f46791c;

        a(c cVar, AnimatorSet animatorSet) {
            this.f46791c = animatorSet;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f46791c.start();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            this.f46791c.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, String str) {
        if (f46787d == 0) {
            f46787d = f1.a(context, 45);
        }
        if (f46786c == 0) {
            f46786c = f1.a(context, 50);
        }
        if (f46788e == 0) {
            f46788e = f1.a(context, 40);
        }
        this.f46790b = context;
        a(str);
    }

    private void a(String str) {
        LinearLayout a4 = f.a(this.f46790b, str, f46786c, 17, true);
        this.f46789a = a4;
        a4.setId(10);
    }

    @Override // com.qq.e.comm.plugin.y.b
    public void a(ViewGroup viewGroup, int i4, boolean z3) {
        if (viewGroup == null) {
            return;
        }
        int i5 = f46786c + (z3 ? com.qq.e.comm.plugin.y.a.f46785a : 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, f46786c);
        int i6 = f46787d;
        layoutParams.setMargins(i6, 0, i6, i5);
        layoutParams.gravity = 80;
        View view = new View(this.f46790b);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadius(f46786c >> 1);
        view.setBackgroundDrawable(gradientDrawable);
        view.setAlpha(0.0f);
        viewGroup.addView(view, layoutParams);
        viewGroup.addView(this.f46789a, layoutParams);
        ImageView imageView = new ImageView(this.f46790b);
        imageView.setImageBitmap(m1.a("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"));
        int i7 = f46788e;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i7, i7);
        layoutParams2.gravity = 81;
        layoutParams2.bottomMargin = f1.a(this.f46790b, 22) + (z3 ? com.qq.e.comm.plugin.y.a.f46785a : 0);
        viewGroup.addView(imageView, layoutParams2);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(a(this.f46789a, 0.95f), a(imageView, 0.9f));
        animatorSet.playSequentially(animatorSet2, a(view));
        animatorSet.addListener(new b(null));
        viewGroup.addOnAttachStateChangeListener(new a(this, animatorSet));
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b extends AnimatorListenerAdapter {

        /* renamed from: c  reason: collision with root package name */
        private boolean f46792c;

        private b() {
            this.f46792c = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f46792c = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f46792c) {
                animator.start();
            }
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    @Override // com.qq.e.comm.plugin.y.b
    public void a(View.OnClickListener onClickListener) {
        this.f46789a.setOnClickListener(onClickListener);
    }

    private Animator a(View view, float f4) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, f4, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, f4, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        animatorSet.setDuration(320L);
        return animatorSet;
    }

    private Animator a(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "scaleX", 1.0f, 1.5f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "scaleY", 1.0f, 2.8f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view, "alpha", a());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3);
        animatorSet.setDuration(1000L);
        return animatorSet;
    }

    private float[] a() {
        float[] fArr = new float[26];
        fArr[0] = 0.0f;
        fArr[1] = 0.2f;
        float f4 = 0.15f / 9;
        for (int i4 = 2; i4 <= 10; i4++) {
            fArr[i4] = fArr[i4 - 1] - f4;
        }
        float f5 = 0.05f / 15;
        for (int i5 = 11; i5 <= 25; i5++) {
            fArr[i5] = fArr[i5 - 1] - f5;
        }
        fArr[25] = 0.0f;
        return fArr;
    }
}
