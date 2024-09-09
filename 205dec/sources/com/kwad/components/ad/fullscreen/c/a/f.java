package com.kwad.components.ad.fullscreen.c.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.os.Vibrator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.e.o;
import com.kwad.components.core.s.n;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.n.l;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b implements o, com.kwad.sdk.core.g.b, com.kwad.sdk.widget.c {
    private com.kwad.sdk.core.g.d eg;
    private Vibrator eh;
    private TextView hA;
    private ImageView hB;
    private FrameLayout hC;
    private ImageView hD;
    private FrameLayout hE;
    private TextView hF;
    @Nullable
    private Animator hG;
    private ViewGroup hy;
    private TextView hz;
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.c.a.f.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void bL() {
            if (f.this.hy != null) {
                f.this.hy.setVisibility(8);
            }
            if (f.this.hE != null) {
                f.this.hE.setVisibility(8);
            }
            if (f.this.eg != null) {
                f.this.eg.bj(f.this.getContext());
            }
            if (f.this.hG != null) {
                f.this.hG.cancel();
                f.this.hG = null;
            }
        }
    };

    private void cg() {
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) l.a(getContext(), R.layout.ksad_shake_center, adBaseFrameLayout, false);
        this.hy = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.hy.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginLeft);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_marginBottom);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_title_marginBottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) l.a(getContext(), R.layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.hE = frameLayout;
        this.hF = (TextView) frameLayout.findViewById(R.id.ksad_shake_tips_label);
        this.hE.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize3;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.hE, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.hy, layoutParams2);
        com.kwad.sdk.core.adlog.c.b(this.qo.mAdTemplate, 185, (JSONObject) null);
        this.hy.post(new ay() { // from class: com.kwad.components.ad.fullscreen.c.a.f.6
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                int height = adBaseFrameLayout.getHeight();
                f fVar = f.this;
                fVar.hG = fVar.a(dimensionPixelSize, height - dimensionPixelSize2);
                if (f.this.hG != null) {
                    f.this.hG.start();
                }
            }
        });
    }

    private void initView() {
        this.hz = (TextView) this.hy.findViewById(R.id.ksad_shake_center_title);
        this.hA = (TextView) this.hy.findViewById(R.id.ksad_shake_center_sub_title);
        this.hB = (ImageView) this.hy.findViewById(R.id.ksad_shake_center_icon);
        this.hC = (FrameLayout) this.hy.findViewById(R.id.ksad_shake_center_circle_area);
        this.hD = (ImageView) this.hy.findViewById(R.id.ksad_shake_center_circle_area_bg);
        new com.kwad.sdk.widget.f(getContext(), this.hy, this);
    }

    @Override // com.kwad.sdk.core.g.b
    public final void aV() {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.qo.mAdTemplate);
        if (com.kwad.components.ad.fullscreen.b.a.a(getContext(), this.qo.mAdTemplate)) {
            this.qo.a(this);
            this.qo.b(this.mPlayEndPageListener);
            cg();
            initView();
            a(dQ);
            float dI = com.kwad.sdk.core.response.b.b.dI(dQ);
            com.kwad.sdk.core.g.d dVar = this.eg;
            if (dVar == null) {
                com.kwad.sdk.core.g.d dVar2 = new com.kwad.sdk.core.g.d(dI);
                this.eg = dVar2;
                dVar2.a(this);
            } else {
                dVar.e(dI);
            }
            this.eg.bi(getContext());
            Context context = getContext();
            if (context != null) {
                this.eh = (Vibrator) context.getSystemService("vibrator");
            }
            com.kwad.components.ad.fullscreen.b.a.F(getContext());
        }
    }

    @Override // com.kwad.components.ad.reward.e.o
    public final int cf() {
        return com.kwad.sdk.d.a.a.g(getContext(), R.dimen.ksad_fullscreen_shake_tips_title_marginBottom) + com.kwad.sdk.d.a.a.g(getContext(), R.dimen.ksad_fullscreen_shake_tips_height);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.hy;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.hy.getParent()).removeView(this.hy);
            }
            this.hy = null;
        }
        bn.b(getContext(), this.eh);
        this.eh = null;
        Animator animator = this.hG;
        if (animator != null) {
            animator.cancel();
            this.hG = null;
        }
        this.qo.c(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.widget.c
    public final void b(View view) {
        this.qo.a(1, getContext(), 158, 1);
    }

    private void a(AdInfo adInfo) {
        String dK = com.kwad.sdk.core.response.b.b.dK(adInfo);
        TextView textView = this.hz;
        if (textView != null) {
            textView.setText(dK);
        }
        TextView textView2 = this.hF;
        if (textView2 != null) {
            textView2.setText(dK);
        }
        String a4 = a(this.qo, adInfo);
        TextView textView3 = this.hA;
        if (textView3 != null) {
            textView3.setText("\u6216\u70b9\u51fb" + a4);
        }
    }

    private static String a(com.kwad.components.ad.reward.g gVar, AdInfo adInfo) {
        String dM = com.kwad.sdk.core.response.b.b.dM(adInfo);
        com.kwad.components.core.e.d.c cVar = gVar.mApkDownloadHelper;
        if (!com.kwad.sdk.core.response.b.a.aF(adInfo) || cVar == null) {
            return dM;
        }
        int nW = cVar.nW();
        AdMatrixInfo.DownloadTexts dO = com.kwad.sdk.core.response.b.b.dO(adInfo);
        if (nW != 8) {
            if (nW != 12) {
                return dO.adActionDescription;
            }
            return dO.openAppLabel;
        }
        return dO.installAppLabel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(float f4, float f5) {
        if (this.hy == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.hy.getResources();
        Animator a4 = n.a((View) this.hB, (Interpolator) null, 100L, 16.0f);
        a4.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.hB.setPivotX(f.this.hB.getWidth());
                f.this.hB.setPivotY(f.this.hB.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hy, "translationX", f4 - (this.hy.getLeft() + (this.hy.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hy, "translationY", f5 - (this.hy.getTop() + (this.hy.getHeight() / 2.0f)));
        float dimension = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_height);
        final float dimension2 = resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_icon_size);
        float width = this.hC.getWidth();
        float width2 = this.hB.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new com.kwad.components.ad.widget.a(this.hD) { // from class: com.kwad.components.ad.fullscreen.c.a.f.8
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i4 = (int) floatValue;
                    layoutParams.height = i4;
                    layoutParams.width = i4;
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(width2, dimension2);
        ofFloat4.addUpdateListener(new com.kwad.components.ad.widget.a(this.hB) { // from class: com.kwad.components.ad.fullscreen.c.a.f.9
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i4 = (int) floatValue;
                    layoutParams.height = i4;
                    layoutParams.width = i4;
                }
            }
        });
        int color = resources.getColor(R.color.ksad_shake_icon_bg_start_color);
        final int color2 = resources.getColor(R.color.ksad_reward_main_color);
        final int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.ksad_fullscreen_shake_tips_icon_stroke_size);
        ValueAnimator ofArgb = com.kwad.sdk.widget.a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) f.this.hD.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    f.this.hD.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.hz.setAlpha(floatValue);
                    f.this.hA.setAlpha(floatValue);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.hz.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new com.kwad.components.ad.widget.a(this.hz) { // from class: com.kwad.components.ad.fullscreen.c.a.f.12
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.hA.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new com.kwad.components.ad.widget.a(this.hA) { // from class: com.kwad.components.ad.fullscreen.c.a.f.13
            @Override // com.kwad.components.ad.widget.a
            public final void a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofArgb, ofFloat6, ofFloat7);
        AnimatorSet animatorSet3 = new AnimatorSet();
        final Animator clone = a4.clone();
        clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.2
            private boolean hI = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.hI = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.hI) {
                    return;
                }
                clone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                f.this.hB.setPivotX(dimension2);
                f.this.hB.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.hE.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(R.dimen.ksad_fullscreen_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    f.this.hE.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    f.this.hE.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    com.kwad.sdk.core.e.c.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(clone, duration, ObjectAnimator.ofFloat(this.hF, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(a4, a4.clone(), a4.clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    @Override // com.kwad.sdk.core.g.b
    public final void a(double d4) {
        com.kwad.sdk.core.c.b.DD();
        Activity currentActivity = com.kwad.sdk.core.c.b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z3 = activity != null && activity.equals(currentActivity);
        if (!com.kwad.components.core.e.c.b.nr() && z3) {
            if (this.qo != null) {
                com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                bVar.l(d4);
                this.qo.a(1, getContext(), MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME, 1, 0L, false, bVar);
            }
            bn.a(new ay() { // from class: com.kwad.components.ad.fullscreen.c.a.f.5
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    com.kwad.sdk.core.e.c.d("ShakePresenter", "onShakeEvent openGate2");
                    f.this.eg.Fu();
                }
            }, null, 500L);
            bn.a(getContext(), this.eh);
            return;
        }
        bn.a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.c.a.f.4
            @Override // java.lang.Runnable
            public final void run() {
                f.this.eg.Fu();
            }
        }, null, 500L);
    }

    @Override // com.kwad.sdk.widget.c
    public final void a(View view) {
        this.qo.a(1, getContext(), 158, 1);
    }
}
