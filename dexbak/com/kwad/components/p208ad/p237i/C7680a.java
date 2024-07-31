package com.kwad.components.p208ad.p237i;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.p208ad.widget.tailframe.appbar.C8525b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.ad.i.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7680a {

    /* renamed from: Hh */
    private View f26012Hh;

    /* renamed from: Hi */
    private Runnable f26013Hi;

    /* renamed from: Hj */
    private boolean f26014Hj = false;
    @Nullable

    /* renamed from: hG */
    private Animator f26015hG;

    /* renamed from: ya */
    private View f26016ya;

    /* renamed from: yb */
    private Button f26017yb;

    /* renamed from: yc */
    private Button f26018yc;

    public C7680a(View view) {
        this.f26012Hh = view;
        initView();
    }

    /* renamed from: d */
    private static Animator m32655d(View view, long j) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void initView() {
        this.f26017yb = (Button) this.f26012Hh.findViewById(C9659R.C9662id.ksad_reward_apk_info_install_action);
        this.f26018yc = (Button) this.f26012Hh.findViewById(C9659R.C9662id.ksad_reward_apk_info_install_start);
        this.f26016ya = this.f26012Hh.findViewById(C9659R.C9662id.ksad_reward_apk_info_install_container);
    }

    /* renamed from: hT */
    public final void m32654hT() {
        C10331c.m26254d("ApkInstallAnimHelper", "startAnimation");
        int height = this.f26016ya.getHeight();
        int width = this.f26016ya.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.f26015hG == null) {
            Animator m32659a = m32659a(this.f26018yc, this.f26017yb, width, height, 1600L, 200L);
            this.f26015hG = m32659a;
            m32659a.addListener(new C8525b() { // from class: com.kwad.components.ad.i.a.1
                @Override // com.kwad.components.p208ad.widget.tailframe.appbar.C8525b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(final Animator animator) {
                    if (C7680a.this.f26014Hj) {
                        return;
                    }
                    if (C7680a.this.f26013Hi == null) {
                        C7680a.this.f26013Hi = new Runnable() { // from class: com.kwad.components.ad.i.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    C11064bn.m23862a(C7680a.this.f26013Hi, null, 1600L);
                }
            });
        }
        C10331c.m26254d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.f26015hG.isStarted());
        if (!this.f26015hG.isStarted()) {
            C10331c.m26254d("ApkInstallAnimHelper", "mAnimator.start()");
            this.f26015hG.start();
        }
        this.f26014Hj = false;
    }

    /* renamed from: jP */
    public final void m32653jP() {
        m32652mb();
    }

    /* renamed from: mb */
    public final void m32652mb() {
        Animator animator = this.f26015hG;
        if (animator != null) {
            animator.cancel();
            this.f26015hG.removeAllListeners();
            this.f26014Hj = true;
        }
        Runnable runnable = this.f26013Hi;
        if (runnable != null) {
            C11064bn.m23858c(runnable);
            this.f26013Hi = null;
        }
    }

    /* renamed from: mc */
    public final void m32651mc() {
        this.f26014Hj = true;
    }

    /* renamed from: a */
    private static Animator m32659a(final View view, View view2, int i, int i2, long j, long j2) {
        Animator m32655d = m32655d(view, 200L);
        float f = i;
        float f2 = i2;
        Animator m32660a = m32660a(view2, f, f2, 200L);
        m32660a.addListener(new C8525b() { // from class: com.kwad.components.ad.i.a.2
            @Override // com.kwad.components.p208ad.widget.tailframe.appbar.C8525b, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setAlpha(1.0f);
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.width = 0;
                    layoutParams.height = 0;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view2, "scaleX", 1.0f, 1.0f);
        ofFloat.setDuration(1600L);
        Animator m32655d2 = m32655d(view2, 200L);
        Animator m32660a2 = m32660a(view, f, f2, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(m32655d, m32660a, ofFloat, m32655d2, m32660a2);
        return animatorSet;
    }

    /* renamed from: a */
    private static Animator m32660a(final View view, float f, final float f2, long j) {
        final float f3 = f / f2;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f2);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(C9659R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.i.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f4 = f3 * floatValue;
                float f5 = f2;
                if (f5 != 0.0f) {
                    float f6 = (floatValue / f5) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f6);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f4;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }
}
