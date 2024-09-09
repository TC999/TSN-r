package com.kwad.components.ad.i;

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
import com.kwad.sdk.R;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private View Hh;
    private Runnable Hi;
    private boolean Hj = false;
    @Nullable
    private Animator hG;
    private View ya;
    private Button yb;
    private Button yc;

    public a(View view) {
        this.Hh = view;
        initView();
    }

    private static Animator d(View view, long j4) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 0.0f);
        ofFloat.setDuration(j4);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        return ofFloat;
    }

    private void initView() {
        this.yb = (Button) this.Hh.findViewById(R.id.ksad_reward_apk_info_install_action);
        this.yc = (Button) this.Hh.findViewById(R.id.ksad_reward_apk_info_install_start);
        this.ya = this.Hh.findViewById(R.id.ksad_reward_apk_info_install_container);
    }

    public final void hT() {
        com.kwad.sdk.core.e.c.d("ApkInstallAnimHelper", "startAnimation");
        int height = this.ya.getHeight();
        int width = this.ya.getWidth();
        if (height == 0 || width == 0) {
            return;
        }
        if (this.hG == null) {
            Animator a4 = a(this.yc, this.yb, width, height, 1600L, 200L);
            this.hG = a4;
            a4.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.i.a.1
                @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(final Animator animator) {
                    if (a.this.Hj) {
                        return;
                    }
                    if (a.this.Hi == null) {
                        a.this.Hi = new Runnable() { // from class: com.kwad.components.ad.i.a.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                animator.start();
                            }
                        };
                    }
                    bn.a(a.this.Hi, null, 1600L);
                }
            });
        }
        com.kwad.sdk.core.e.c.d("ApkInstallAnimHelper", "mAnimator isStarted: " + this.hG.isStarted());
        if (!this.hG.isStarted()) {
            com.kwad.sdk.core.e.c.d("ApkInstallAnimHelper", "mAnimator.start()");
            this.hG.start();
        }
        this.Hj = false;
    }

    public final void jP() {
        mb();
    }

    public final void mb() {
        Animator animator = this.hG;
        if (animator != null) {
            animator.cancel();
            this.hG.removeAllListeners();
            this.Hj = true;
        }
        Runnable runnable = this.Hi;
        if (runnable != null) {
            bn.c(runnable);
            this.Hi = null;
        }
    }

    public final void mc() {
        this.Hj = true;
    }

    private static Animator a(final View view, View view2, int i4, int i5, long j4, long j5) {
        Animator d4 = d(view, 200L);
        float f4 = i4;
        float f5 = i5;
        Animator a4 = a(view2, f4, f5, 200L);
        a4.addListener(new com.kwad.components.ad.widget.tailframe.appbar.b() { // from class: com.kwad.components.ad.i.a.2
            @Override // com.kwad.components.ad.widget.tailframe.appbar.b, android.animation.Animator.AnimatorListener
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
        Animator d5 = d(view2, 200L);
        Animator a5 = a(view, f4, f5, 200L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(d4, a4, ofFloat, d5, a5);
        return animatorSet;
    }

    private static Animator a(final View view, float f4, final float f5, long j4) {
        final float f6 = f4 / f5;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, f5);
        ofFloat.setDuration(j4);
        ofFloat.setInterpolator(PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f));
        final float dimension = view.getResources().getDimension(R.dimen.ksad_reward_apk_info_card_actionbar_text_size);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.i.a.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                float f7 = f6 * floatValue;
                float f8 = f5;
                if (f8 != 0.0f) {
                    float f9 = (floatValue / f8) * dimension;
                    View view2 = view;
                    if (view2 instanceof TextView) {
                        ((TextView) view2).setTextSize(0, f9);
                    }
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = (int) floatValue;
                    layoutParams.width = (int) f7;
                    view.setLayoutParams(layoutParams);
                }
            }
        });
        return ofFloat;
    }
}
