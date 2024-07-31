package com.kwad.components.p208ad.reward.presenter;

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
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.AbstractC7880a;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7886g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7895o;
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
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.reward.presenter.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8307t extends C8094b implements View.OnClickListener, InterfaceC7895o, InterfaceC10376b {

    /* renamed from: eg */
    private C10380d f27419eg;

    /* renamed from: eh */
    private Vibrator f27420eh;

    /* renamed from: hA */
    private TextView f27421hA;

    /* renamed from: hB */
    private ImageView f27422hB;

    /* renamed from: hC */
    private FrameLayout f27423hC;

    /* renamed from: hD */
    private ImageView f27424hD;

    /* renamed from: hE */
    private FrameLayout f27425hE;

    /* renamed from: hF */
    private TextView f27426hF;
    @Nullable

    /* renamed from: hG */
    private Animator f27427hG;

    /* renamed from: hy */
    private ViewGroup f27428hy;

    /* renamed from: hz */
    private TextView f27429hz;
    private InterfaceC7886g mPlayEndPageListener = new AbstractC7880a() { // from class: com.kwad.components.ad.reward.presenter.t.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7886g
        /* renamed from: bL */
        public final void mo31009bL() {
            if (View$OnClickListenerC8307t.this.f27428hy != null) {
                View$OnClickListenerC8307t.this.f27428hy.setVisibility(8);
            }
            if (View$OnClickListenerC8307t.this.f27425hE != null) {
                View$OnClickListenerC8307t.this.f27425hE.setVisibility(8);
            }
            if (View$OnClickListenerC8307t.this.f27419eg != null) {
                View$OnClickListenerC8307t.this.f27419eg.m26194bj(View$OnClickListenerC8307t.this.getContext());
            }
            if (View$OnClickListenerC8307t.this.f27427hG != null) {
                View$OnClickListenerC8307t.this.f27427hG.cancel();
                View$OnClickListenerC8307t.this.f27427hG = null;
            }
        }
    };

    /* renamed from: cg */
    private void m31016cg() {
        final int dimensionPixelSize;
        int dimensionPixelSize2;
        final AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
        ViewGroup viewGroup = (ViewGroup) C10887l.m24563a(getContext(), C9659R.C9663layout.ksad_shake_center, adBaseFrameLayout, false);
        this.f27428hy = viewGroup;
        viewGroup.setVisibility(0);
        Resources resources = this.f27428hy.getResources();
        final int dimensionPixelSize3 = resources.getDimensionPixelSize(C9659R.dimen.ksad_reward_shake_tips_icon_marginLeft);
        if (this.f26957qo.mScreenOrientation == 1) {
            dimensionPixelSize = resources.getDimensionPixelSize(C9659R.dimen.ksad_reward_shake_tips_icon_marginBottom) + C10751a.m24924a(getContext(), 50.0f);
        } else {
            dimensionPixelSize = resources.getDimensionPixelSize(C9659R.dimen.ksad_reward_shake_tips_icon_marginBottom);
        }
        if (this.f26957qo.mScreenOrientation == 1) {
            dimensionPixelSize2 = resources.getDimensionPixelSize(C9659R.dimen.ksad_reward_shake_tips_title_marginBottom) + C10751a.m24924a(getContext(), 50.0f);
        } else {
            dimensionPixelSize2 = resources.getDimensionPixelSize(C9659R.dimen.ksad_reward_shake_tips_title_marginBottom);
        }
        int dimensionPixelSize4 = resources.getDimensionPixelSize(C9659R.dimen.ksad_reward_shake_tips_height);
        FrameLayout frameLayout = (FrameLayout) C10887l.m24563a(getContext(), C9659R.C9663layout.ksad_shake_tips_title, adBaseFrameLayout, false);
        this.f27425hE = frameLayout;
        this.f27426hF = (TextView) frameLayout.findViewById(C9659R.C9662id.ksad_shake_tips_label);
        this.f27425hE.setVisibility(4);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, dimensionPixelSize4);
        layoutParams.leftMargin = dimensionPixelSize3;
        layoutParams.bottomMargin = dimensionPixelSize2;
        layoutParams.gravity = 83;
        adBaseFrameLayout.addView(this.f27425hE, layoutParams);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        adBaseFrameLayout.addView(this.f27428hy, layoutParams2);
        C9908c.m27337b(this.f26957qo.mAdTemplate, (int) Opcodes.INVOKEINTERFACE, (JSONObject) null);
        this.f27428hy.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.t.6
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                int height = adBaseFrameLayout.getHeight();
                View$OnClickListenerC8307t view$OnClickListenerC8307t = View$OnClickListenerC8307t.this;
                view$OnClickListenerC8307t.f27427hG = view$OnClickListenerC8307t.m31025a(dimensionPixelSize3, height - dimensionPixelSize);
                if (View$OnClickListenerC8307t.this.f27427hG != null) {
                    View$OnClickListenerC8307t.this.f27427hG.start();
                }
            }
        });
    }

    private void initView() {
        this.f27429hz = (TextView) this.f27428hy.findViewById(C9659R.C9662id.ksad_shake_center_title);
        this.f27421hA = (TextView) this.f27428hy.findViewById(C9659R.C9662id.ksad_shake_center_sub_title);
        this.f27422hB = (ImageView) this.f27428hy.findViewById(C9659R.C9662id.ksad_shake_center_icon);
        this.f27423hC = (FrameLayout) this.f27428hy.findViewById(C9659R.C9662id.ksad_shake_center_circle_area);
        this.f27424hD = (ImageView) this.f27428hy.findViewById(C9659R.C9662id.ksad_shake_center_circle_area_bg);
        this.f27429hz.setOnClickListener(this);
        this.f27421hA.setOnClickListener(this);
        this.f27423hC.setOnClickListener(this);
        this.f27426hF.setOnClickListener(this);
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
        this.f26957qo.m32050a(this);
        this.f26957qo.m32034b(this.mPlayEndPageListener);
        m31016cg();
        initView();
        m31020a(m25641dQ);
        float m25731dJ = C10484b.m25731dJ(m25641dQ);
        C10380d c10380d = this.f27419eg;
        if (c10380d == null) {
            C10380d c10380d2 = new C10380d(m25731dJ);
            this.f27419eg = c10380d2;
            c10380d2.m26199a(this);
        } else {
            c10380d.m26192e(m25731dJ);
        }
        this.f27419eg.m26195bi(getContext());
        Context context = getContext();
        if (context != null) {
            this.f27420eh = (Vibrator) context.getSystemService("vibrator");
        }
    }

    @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7895o
    /* renamed from: cf */
    public final int mo31017cf() {
        return C10751a.m24908g(getContext(), C9659R.dimen.ksad_reward_shake_tips_title_marginBottom) + C10751a.m24908g(getContext(), C9659R.dimen.ksad_reward_shake_tips_height);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (C10484b.m25733dH(C10487e.m25641dQ(this.f26957qo.mAdTemplate))) {
            this.f26957qo.m32060a(1, getContext(), Opcodes.IFLE, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        ViewGroup viewGroup = this.f27428hy;
        if (viewGroup != null) {
            if (viewGroup.getParent() != null) {
                ((ViewGroup) this.f27428hy.getParent()).removeView(this.f27428hy);
            }
            this.f27428hy = null;
        }
        C11064bn.m23861b(getContext(), this.f27420eh);
        this.f27420eh = null;
        Animator animator = this.f27427hG;
        if (animator != null) {
            animator.cancel();
            this.f27427hG = null;
        }
        this.f26957qo.m32024c(this.mPlayEndPageListener);
    }

    /* renamed from: a */
    private void m31020a(AdInfo adInfo) {
        String m25729dL = C10484b.m25729dL(adInfo);
        TextView textView = this.f27429hz;
        if (textView != null) {
            textView.setText(m25729dL);
        }
        TextView textView2 = this.f27426hF;
        if (textView2 != null) {
            textView2.setText(m25729dL);
        }
        String m31024a = m31024a(this.f26957qo, adInfo);
        TextView textView3 = this.f27421hA;
        if (textView3 != null) {
            textView3.setText("或点击" + m31024a);
        }
    }

    /* renamed from: a */
    private static String m31024a(C7907g c7907g, AdInfo adInfo) {
        String m25727dN = C10484b.m25727dN(adInfo);
        C8619c c8619c = c7907g.mApkDownloadHelper;
        if (!C10483a.m25956aF(adInfo) || c8619c == null) {
            return m25727dN;
        }
        int m30141nW = c8619c.m30141nW();
        AdMatrixInfo.DownloadTexts m25725dP = C10484b.m25725dP(adInfo);
        if (m30141nW != 8) {
            if (m30141nW != 12) {
                return m25725dP.adActionDescription;
            }
            return m25725dP.openAppLabel;
        }
        return m25725dP.installAppLabel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    /* renamed from: a */
    public Animator m31025a(float f, float f2) {
        if (this.f27428hy == null) {
            return null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        Resources resources = this.f27428hy.getResources();
        Animator m29529a = C8951n.m29529a((View) this.f27422hB, (Interpolator) null, 100L, 16.0f);
        m29529a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                View$OnClickListenerC8307t.this.f27422hB.setPivotX(View$OnClickListenerC8307t.this.f27422hB.getWidth());
                View$OnClickListenerC8307t.this.f27422hB.setPivotY(View$OnClickListenerC8307t.this.f27422hB.getHeight());
            }
        });
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f27428hy, "translationX", f - (this.f27428hy.getLeft() + (this.f27428hy.getWidth() / 2.0f)));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f27428hy, "translationY", f2 - (this.f27428hy.getTop() + (this.f27428hy.getHeight() / 2.0f)));
        float dimension = resources.getDimension(C9659R.dimen.ksad_reward_shake_tips_height);
        final float dimension2 = resources.getDimension(C9659R.dimen.ksad_reward_shake_tips_icon_size);
        float width = this.f27423hC.getWidth();
        float width2 = this.f27422hB.getWidth();
        if (width == 0.0f || width2 == 0.0f) {
            return null;
        }
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(width, dimension);
        ofFloat3.addUpdateListener(new AbstractC8521a(this.f27424hD) { // from class: com.kwad.components.ad.reward.presenter.t.8
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
        ofFloat4.addUpdateListener(new AbstractC8521a(this.f27422hB) { // from class: com.kwad.components.ad.reward.presenter.t.9
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
        final int dimensionPixelSize = resources.getDimensionPixelSize(C9659R.dimen.ksad_reward_shake_tips_icon_stroke_size);
        ValueAnimator ofArgb = C11143a.ofArgb(color, color2);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.10
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    GradientDrawable gradientDrawable = (GradientDrawable) View$OnClickListenerC8307t.this.f27424hD.getBackground();
                    gradientDrawable.mutate();
                    gradientDrawable.setColor(intValue);
                    if (intValue == color2) {
                        gradientDrawable.setStroke(dimensionPixelSize, -1);
                    }
                    View$OnClickListenerC8307t.this.f27424hD.setBackground(gradientDrawable);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat5.setDuration(200L);
        ofFloat5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    View$OnClickListenerC8307t.this.f27429hz.setAlpha(floatValue);
                    View$OnClickListenerC8307t.this.f27421hA.setAlpha(floatValue);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                }
            }
        });
        ValueAnimator ofFloat6 = ValueAnimator.ofFloat(this.f27429hz.getHeight(), 0.0f);
        ofFloat6.addUpdateListener(new AbstractC8521a(this.f27429hz) { // from class: com.kwad.components.ad.reward.presenter.t.12
            @Override // com.kwad.components.p208ad.widget.AbstractC8521a
            /* renamed from: a */
            public final void mo30424a(ViewGroup.LayoutParams layoutParams, Object obj) {
                layoutParams.height = (int) ((Float) obj).floatValue();
            }
        });
        ValueAnimator ofFloat7 = ValueAnimator.ofFloat(this.f27421hA.getHeight(), 0.0f);
        ofFloat7.addUpdateListener(new AbstractC8521a(this.f27421hA) { // from class: com.kwad.components.ad.reward.presenter.t.13
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
        clone.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.t.2

            /* renamed from: hI */
            private boolean f27437hI = false;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationCancel(Animator animator) {
                super.onAnimationCancel(animator);
                this.f27437hI = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (this.f27437hI) {
                    return;
                }
                clone.start();
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                View$OnClickListenerC8307t.this.f27422hB.setPivotX(dimension2);
                View$OnClickListenerC8307t.this.f27422hB.setPivotY(dimension2);
            }
        });
        final ViewGroup.LayoutParams layoutParams = this.f27425hE.getLayoutParams();
        ValueAnimator duration = ValueAnimator.ofFloat(0.0f, resources.getDimension(C9659R.dimen.ksad_reward_shake_tips_width)).setDuration(500L);
        duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.t.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                try {
                    View$OnClickListenerC8307t.this.f27425hE.setVisibility(0);
                    layoutParams.width = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    View$OnClickListenerC8307t.this.f27425hE.setLayoutParams(layoutParams);
                } catch (Throwable th) {
                    C10331c.printStackTrace(th);
                }
            }
        });
        animatorSet3.playTogether(clone, duration, ObjectAnimator.ofFloat(this.f27426hF, "alpha", 0.0f, 1.0f).setDuration(500L));
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
            C7907g c7907g = this.f26957qo;
            if (c7907g != null && !c7907g.m32002fM()) {
                C9913b c9913b = new C9913b();
                c9913b.m27246l(d);
                this.f26957qo.m32058a(1, getContext(), 157, 1, 0L, false, c9913b);
            }
            C11064bn.m23862a(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.presenter.t.5
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C10331c.m26254d("RewardShakePresenter", "onShakeEvent openGate2");
                    View$OnClickListenerC8307t.this.f27419eg.m26202Fu();
                }
            }, null, 500L);
            C10487e.m25641dQ(this.f26957qo.mAdTemplate);
            if (this.f26957qo.m32002fM()) {
                return;
            }
            C11064bn.m23863a(getContext(), this.f27420eh);
            return;
        }
        C11064bn.m23862a(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.t.4
            @Override // java.lang.Runnable
            public final void run() {
                View$OnClickListenerC8307t.this.f27419eg.m26202Fu();
            }
        }, null, 500L);
    }
}
