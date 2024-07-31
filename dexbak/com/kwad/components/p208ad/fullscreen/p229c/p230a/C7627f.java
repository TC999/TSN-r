package com.kwad.components.p208ad.fullscreen.p229c.p230a;

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
import com.alibaba.fastjson.asm.Opcodes;
import com.kwad.components.core.p289e.p292c.AlertDialogC8602b;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.components.p208ad.fullscreen.p228b.C7608a;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7895o;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.widget.AbstractC8521a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.adlog.p388c.C9913b;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p402g.C10380d;
import com.kwad.sdk.core.p402g.InterfaceC10376b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.widget.C11143a;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.fullscreen.c.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7627f extends C8094b implements InterfaceC7895o, InterfaceC10376b, InterfaceC11145c {

    /* renamed from: eg */
    private C10380d f25890eg;

    /* renamed from: eh */
    private Vibrator f25891eh;

    /* renamed from: hA */
    private TextView f25892hA;

    /* renamed from: hB */
    private ImageView f25893hB;

    /* renamed from: hC */
    private FrameLayout f25894hC;

    /* renamed from: hD */
    private ImageView f25895hD;

    /* renamed from: hE */
    private FrameLayout f25896hE;

    /* renamed from: hF */
    private TextView f25897hF;
    @Nullable

    /* renamed from: hG */
    private Animator f25898hG;

    /* renamed from: hy */
    private ViewGroup f25899hy;

    /* renamed from: hz */
    private TextView f25900hz;
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.fullscreen.c.a.f.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            if (C7627f.this.f25899hy != null) {
                C7627f.this.f25899hy.setVisibility(8);
            }
            if (C7627f.this.f25896hE != null) {
                C7627f.this.f25896hE.setVisibility(8);
            }
            if (C7627f.this.f25890eg != null) {
                C7627f.this.f25890eg.m26194bj(C7627f.this.getContext());
            }
            if (C7627f.this.f25898hG != null) {
                C7627f.this.f25898hG.cancel();
                C7627f.this.f25898hG = null;
            }
        }
    };

    /* renamed from: cg */
    private void m32747cg() {
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) C10887l.m24563a(getContext(), C9659R.C9663layout.ksad_shake_center, adBaseFrameLayout, false);
        this.f25899hy = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.f25899hy.getResources();
        final int dimensionPixelSize = resources.getDimensionPixelSize(C9659R.dimen.ksad_fullscreen_shake_tips_icon_marginLeft);
        final int dimensionPixelSize2 = resources.getDimensionPixelSize(C9659R.dimen.ksad_fullscreen_shake_tips_icon_marginBottom);
        int dimensionPixelSize3 = resources.getDimensionPixelSize(C9659R.dimen.ksad_fullscreen_shake_tips_title_marginBottom);
        int dimensionPixelSize4 = resources.getDimensionPixelSize(C9659R.dimen.ksad_fullscreen_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) C10887l.m24563a(getContext(), C9659R.C9663layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.f25896hE = frameLayout;
        this.f25897hF = (TextView) frameLayout.findViewById(C9659R.C9662id.ksad_shake_tips_label);
        this.f25896hE.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize;
        layoutParams.bottomMargin = dimensionPixelSize3;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.f25896hE, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.f25899hy, layoutParams2);
        C9908c.m27337b(this.f26957qo.mAdTemplate, (int) Opcodes.INVOKEINTERFACE, (JSONObject) null);
        this.f25899hy.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.fullscreen.c.a.f.6
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                int height = adBaseFrameLayout.getHeight();
                C7627f c7627f = C7627f.this;
                c7627f.f25898hG = c7627f.m32755a(dimensionPixelSize, height - dimensionPixelSize2);
                if (C7627f.this.f25898hG != null) {
                    C7627f.this.f25898hG.start();
                }
            }
        });
    }

    private void initView() {
        this.f25900hz = (TextView) this.f25899hy.findViewById(C9659R.C9662id.ksad_shake_center_title);
        this.f25892hA = (TextView) this.f25899hy.findViewById(C9659R.C9662id.ksad_shake_center_sub_title);
        this.f25893hB = (ImageView) this.f25899hy.findViewById(C9659R.C9662id.ksad_shake_center_icon);
        this.f25894hC = (FrameLayout) this.f25899hy.findViewById(C9659R.C9662id.ksad_shake_center_circle_area);
        this.f25895hD = (ImageView) this.f25899hy.findViewById(C9659R.C9662id.ksad_shake_center_circle_area_bg);
        new GestureDetector$OnGestureListenerC11148f(getContext(), this.f25899hy, this);
    }

    @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
    /* renamed from: aV */
    public final void mo26219aV() {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdInfo m25641dQ = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
        if (C7608a.m32789a(getContext(), this.f26957qo.mAdTemplate)) {
            this.f26957qo.m32050a(this);
            this.f26957qo.m32034b(this.mPlayEndPageListener);
            m32747cg();
            initView();
            m32750a(m25641dQ);
            float m25732dI = C10484b.m25732dI(m25641dQ);
            C10380d c10380d = this.f25890eg;
            if (c10380d == null) {
                C10380d c10380d2 = new C10380d(m25732dI);
                this.f25890eg = c10380d2;
                c10380d2.m26199a(this);
            } else {
                c10380d.m26192e(m25732dI);
            }
            this.f25890eg.m26195bi(getContext());
            Context context = getContext();
            if (context != null) {
                this.f25891eh = (Vibrator) context.getSystemService("vibrator");
            }
            C7608a.m32792F(getContext());
        }
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7895o
    /* renamed from: cf */
    public final int mo31017cf() {
        return C10751a.m24908g(getContext(), C9659R.dimen.ksad_fullscreen_shake_tips_title_marginBottom) + C10751a.m24908g(getContext(), C9659R.dimen.ksad_fullscreen_shake_tips_height);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.f25899hy;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.f25899hy.getParent()).removeView(this.f25899hy);
            }
            this.f25899hy = null;
        }
        C11064bn.m23861b(getContext(), this.f25891eh);
        this.f25891eh = null;
        Animator animator = this.f25898hG;
        if (animator != null) {
            animator.cancel();
            this.f25898hG = null;
        }
        this.f26957qo.m32024c(this.mPlayEndPageListener);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        this.f26957qo.m32060a(1, getContext(), Opcodes.IFLE, 1);
    }

    /* renamed from: a */
    private void m32750a(AdInfo adInfo) {
        String m25730dK = C10484b.m25730dK(adInfo);
        TextView textView = this.f25900hz;
        if (textView != null) {
            textView.setText(m25730dK);
        }
        TextView textView2 = this.f25897hF;
        if (textView2 != null) {
            textView2.setText(m25730dK);
        }
        String m32751a = m32751a(this.f26957qo, adInfo);
        TextView textView3 = this.f25892hA;
        if (textView3 != null) {
            textView3.setText("或点击" + m32751a);
        }
    }

    /* renamed from: a */
    private static String m32751a(C7907g c7907g, AdInfo adInfo) {
        String m25728dM = C10484b.m25728dM(adInfo);
        C8619c c8619c = c7907g.mApkDownloadHelper;
        if (!C10483a.m25956aF(adInfo) || c8619c == null) {
            return m25728dM;
        }
        int m30141nW = c8619c.m30141nW();
        AdMatrixInfo.DownloadTexts m25726dO = C10484b.m25726dO(adInfo);
        if (m30141nW != 8) {
            if (m30141nW != 12) {
                return m25726dO.adActionDescription;
            }
            return m25726dO.openAppLabel;
        }
        return m25726dO.installAppLabel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    /* renamed from: a */
    public Animator m32755a(float f, float f2) {
        if (this.f25899hy == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.f25899hy.getResources();
        Animator m29529a = C8951n.m29529a((View) this.f25893hB, (Interpolator) null, 100L, 16.0f);
        m29529a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                C7627f.this.f25893hB.setPivotX(C7627f.this.f25893hB.getWidth());
                C7627f.this.f25893hB.setPivotY(C7627f.this.f25893hB.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f25899hy, "translationX", f - (this.f25899hy.getLeft() + (this.f25899hy.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f25899hy, "translationY", f2 - (this.f25899hy.getTop() + (this.f25899hy.getHeight() / 2.0f)));
        float dimension = resources.getDimension(C9659R.dimen.ksad_fullscreen_shake_tips_height);
        final float dimension2 = resources.getDimension(C9659R.dimen.ksad_fullscreen_shake_tips_icon_size);
        float width = this.f25894hC.getWidth();
        float width2 = this.f25893hB.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new AbstractC8521a(this.f25895hD) { // from class: com.kwad.components.ad.fullscreen.c.a.f.8
            @Override // com.kwad.components.p208ad.widget.AbstractC8521a
            /* renamed from: a */
            public final void mo30424a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(width2, dimension2);
        ofFloat4.addUpdateListener(new AbstractC8521a(this.f25893hB) { // from class: com.kwad.components.ad.fullscreen.c.a.f.9
            @Override // com.kwad.components.p208ad.widget.AbstractC8521a
            /* renamed from: a */
            public final void mo30424a(ViewGroup.LayoutParams layoutParams, Object obj) {
                float floatValue = ((Float) obj).floatValue();
                if (layoutParams != null) {
                    int i = (int) floatValue;
                    layoutParams.height = i;
                    layoutParams.width = i;
                }
            }
        });
        int color = resources.getColor(C9659R.C9660color.ksad_shake_icon_bg_start_color);
        final int color2 = resources.getColor(C9659R.C9660color.ksad_reward_main_color);
        final int dimensionPixelSize = resources.getDimensionPixelSize(C9659R.dimen.ksad_fullscreen_shake_tips_icon_stroke_size);
        ValueAnimator ofArgb = C11143a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) C7627f.this.f25895hD.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    C7627f.this.f25895hD.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
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
                    C7627f.this.f25900hz.setAlpha(floatValue);
                    C7627f.this.f25892hA.setAlpha(floatValue);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.f25900hz.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new AbstractC8521a(this.f25900hz) { // from class: com.kwad.components.ad.fullscreen.c.a.f.12
            @Override // com.kwad.components.p208ad.widget.AbstractC8521a
            /* renamed from: a */
            public final void mo30424a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.f25892hA.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new AbstractC8521a(this.f25892hA) { // from class: com.kwad.components.ad.fullscreen.c.a.f.13
            @Override // com.kwad.components.p208ad.widget.AbstractC8521a
            /* renamed from: a */
            public final void mo30424a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.setDuration(500L);
        animatorSet2.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4, ofArgb, ofFloat6, ofFloat7);
        AnimatorSet animatorSet3 = new AnimatorSet();
        final Animator clone = m29529a.clone();
        clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.fullscreen.c.a.f.2

            /* renamed from: hI */
            private boolean f25909hI = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.f25909hI = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.f25909hI) {
                    return;
                }
                clone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                C7627f.this.f25893hB.setPivotX(dimension2);
                C7627f.this.f25893hB.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.f25896hE.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(C9659R.dimen.ksad_fullscreen_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.fullscreen.c.a.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    C7627f.this.f25896hE.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    C7627f.this.f25896hE.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(clone, duration, ObjectAnimator.ofFloat(this.f25897hF, "alpha", 0.0f, 1.0f).setDuration(500L));
        animatorSet.playSequentially(m29529a, m29529a.clone(), m29529a.clone(), ofFloat5, animatorSet2, animatorSet3);
        return animatorSet;
    }

    @Override // com.kwad.sdk.core.p402g.InterfaceC10376b
    /* renamed from: a */
    public final void mo26220a(double d) {
        C10232b.m26625DD();
        Activity currentActivity = C10232b.getCurrentActivity();
        Activity activity = getActivity();
        boolean z = activity != null && activity.equals(currentActivity);
        if (!AlertDialogC8602b.m30267nr() && z) {
            if (this.f26957qo != null) {
                C9913b c9913b = new C9913b();
                c9913b.m27246l(d);
                this.f26957qo.m32058a(1, getContext(), 157, 1, 0L, false, c9913b);
            }
            C11064bn.m23862a(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.fullscreen.c.a.f.5
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C10331c.m26254d("ShakePresenter", "onShakeEvent openGate2");
                    C7627f.this.f25890eg.m26202Fu();
                }
            }, null, 500L);
            C11064bn.m23863a(getContext(), this.f25891eh);
            return;
        }
        C11064bn.m23862a(new Runnable() { // from class: com.kwad.components.ad.fullscreen.c.a.f.4
            @Override // java.lang.Runnable
            public final void run() {
                C7627f.this.f25890eg.m26202Fu();
            }
        }, null, 500L);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        this.f26957qo.m32060a(1, getContext(), Opcodes.IFLE, 1);
    }
}
