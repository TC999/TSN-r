package com.kwad.components.p208ad.reward.p264n;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.widget.KsPriceView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.reward.n.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8052i extends AbstractC8041d implements View.OnClickListener {
    @Nullable

    /* renamed from: hz */
    private TextView f26816hz;
    @Nullable

    /* renamed from: lv */
    private KSCornerImageView f26817lv;
    @Nullable

    /* renamed from: lw */
    private TextView f26818lw;
    @Nullable
    private KsLogoView mLogoView;

    /* renamed from: qo */
    private C7907g f26819qo;

    /* renamed from: sz */
    private ViewGroup f26820sz;

    /* renamed from: yG */
    private ViewGroup f26821yG;
    @Nullable

    /* renamed from: yH */
    private KsPriceView f26822yH;
    @Nullable

    /* renamed from: yI */
    private TextView f26823yI;
    @Nullable

    /* renamed from: yJ */
    private KsStyledTextButton f26824yJ;
    @Nullable

    /* renamed from: yK */
    private TextView f26825yK;
    @Nullable

    /* renamed from: yL */
    private TextView f26826yL;
    @Nullable

    /* renamed from: yM */
    private View f26827yM;
    @Nullable

    /* renamed from: yN */
    private ImageView f26828yN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.reward.n.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8057a {

        /* renamed from: kZ */
        private String f26840kZ;

        /* renamed from: qa */
        private String f26841qa;

        /* renamed from: qb */
        private String f26842qb;

        /* renamed from: rR */
        private String f26843rR;
        private String rating;
        private String title;

        /* renamed from: yX */
        private String f26844yX;
        @Nullable

        /* renamed from: yY */
        private String f26845yY;

        /* renamed from: yZ */
        private String f26846yZ;

        /* renamed from: za */
        private String f26847za;

        private C8057a() {
        }

        /* renamed from: L */
        private void m31695L(String str) {
            this.f26843rR = str;
        }

        /* renamed from: Q */
        static C8057a m31694Q(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            AdProductInfo m25838cP = C10483a.m25838cP(m25641dQ);
            C8057a c8057a = new C8057a();
            String name = m25838cP.getName();
            c8057a.title = name;
            if (TextUtils.isEmpty(name)) {
                c8057a.title = C10483a.m25912ax(m25641dQ);
            }
            c8057a.f26846yZ = C10483a.m25957aE(m25641dQ);
            c8057a.f26841qa = m25838cP.getIcon();
            c8057a.f26842qb = C10483a.m25915au(m25641dQ);
            c8057a.f26844yX = m25838cP.getPrice();
            c8057a.f26840kZ = m25838cP.getOriginPrice();
            c8057a.f26847za = m25838cP.getVolume();
            c8057a.rating = m25838cP.getRating();
            if (!m25838cP.isCouponListEmpty() && (firstCouponList = m25838cP.getFirstCouponList()) != null) {
                c8057a.f26845yY = CouponInfo.jinniuFormatCoupon(firstCouponList);
                c8057a.m31695L(firstCouponList.getFormattedJinniuPrefix());
            }
            return c8057a;
        }

        /* renamed from: dz */
        public final String m31693dz() {
            return this.f26840kZ;
        }

        /* renamed from: gX */
        public final String m31692gX() {
            return this.f26843rR;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        /* renamed from: gf */
        public final String m31691gf() {
            return this.f26841qa;
        }

        /* renamed from: gg */
        public final String m31690gg() {
            return this.f26842qb;
        }

        /* renamed from: jV */
        public final String m31689jV() {
            return this.f26844yX;
        }

        /* renamed from: jW */
        public final String m31688jW() {
            return this.f26845yY;
        }

        /* renamed from: jX */
        public final String m31687jX() {
            return this.f26846yZ;
        }

        /* renamed from: jY */
        public final String m31686jY() {
            return this.f26847za;
        }
    }

    public View$OnClickListenerC8052i(C7907g c7907g, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.f26819qo = c7907g;
        this.mLogoView = ksLogoView;
        this.f26821yG = viewGroup;
        initView();
    }

    /* renamed from: a */
    static /* synthetic */ Animator m31701a(View$OnClickListenerC8052i view$OnClickListenerC8052i, View view, float f) {
        return m31704a(view, f);
    }

    private void initView() {
        this.f26820sz = (ViewGroup) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_root);
        this.f26817lv = (KSCornerImageView) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_icon);
        this.f26816hz = (TextView) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_title);
        this.f26818lw = (TextView) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_desc);
        this.f26822yH = (KsPriceView) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_price);
        this.f26823yI = (TextView) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_right_label);
        this.f26824yJ = (KsStyledTextButton) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_btn_buy);
        this.f26828yN = (ImageView) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_light_sweep);
        this.f26827yM = this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_coupon_layout);
        this.f26825yK = (TextView) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_coupon);
        this.f26826yL = (TextView) this.f26821yG.findViewById(C9659R.C9662id.ksad_reward_jinniu_coupon_prefix);
        this.f26820sz.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.f26824yJ;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.f26820sz.getContext();
        if (C11015ai.m24123LZ()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f26820sz.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_follow_card_width_horizontal);
            this.f26820sz.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: gF */
    public final ViewGroup mo31643gF() {
        return this.f26820sz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.f26820sz)) {
            this.f26819qo.m32060a(1, view.getContext(), 118, 2);
        } else if (view.equals(this.f26824yJ)) {
            this.f26819qo.m32060a(1, view.getContext(), 1, 1);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: a */
    public final void mo31651a(C8074r c8074r) {
        super.mo31651a(c8074r);
        if (c8074r == null) {
            return;
        }
        m31699a(c8074r.getAdTemplate(), C8057a.m31694Q(c8074r.getAdTemplate()));
        ViewGroup viewGroup = this.f26820sz;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    View$OnClickListenerC8052i view$OnClickListenerC8052i = View$OnClickListenerC8052i.this;
                    Animator m31703a = view$OnClickListenerC8052i.m31703a(view$OnClickListenerC8052i.f26820sz, View$OnClickListenerC8052i.this.f26824yJ, View$OnClickListenerC8052i.this.mLogoView);
                    if (m31703a != null) {
                        m31703a.start();
                    }
                }
            }, 3000L);
            this.f26820sz.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (View$OnClickListenerC8052i.this.f26824yJ == null || View$OnClickListenerC8052i.this.f26824yJ.getWidth() == 0) {
                        return;
                    }
                    View$OnClickListenerC8052i view$OnClickListenerC8052i = View$OnClickListenerC8052i.this;
                    final Animator m31701a = View$OnClickListenerC8052i.m31701a(view$OnClickListenerC8052i, view$OnClickListenerC8052i.f26828yN, View$OnClickListenerC8052i.this.f26824yJ.getWidth());
                    if (m31701a != null) {
                        m31701a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1

                            /* renamed from: yP */
                            private int f26831yP = 1;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.f26831yP >= 3) {
                                    return;
                                }
                                m31701a.start();
                                this.f26831yP++;
                            }
                        });
                        m31701a.start();
                    }
                }
            }, 5000L);
        }
    }

    /* renamed from: a */
    private void m31699a(AdTemplate adTemplate, C8057a c8057a) {
        if (c8057a == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.f26817lv, c8057a.m31691gf(), adTemplate, 4);
        TextView textView = this.f26816hz;
        if (textView != null) {
            textView.setText(c8057a.getTitle());
        }
        TextView textView2 = this.f26818lw;
        if (textView2 != null) {
            textView2.setText(c8057a.m31690gg());
        }
        KsPriceView ksPriceView = this.f26822yH;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.f26822yH.getConfig().m30438ae(dimensionPixelSize).m30436ag(dimensionPixelSize).m30437af(this.f26822yH.getResources().getColor(C9659R.C9660color.ksad_jinniu_end_origin_color));
            this.f26822yH.m30441d(c8057a.m31689jV(), c8057a.m31693dz(), true);
        }
        if (this.f26823yI != null) {
            if (!TextUtils.isEmpty(c8057a.m31686jY())) {
                this.f26823yI.setText(c8057a.m31686jY());
            } else if (!TextUtils.isEmpty(c8057a.getRating())) {
                this.f26823yI.setText(c8057a.getRating());
            } else {
                this.f26823yI.setVisibility(8);
            }
        }
        if (this.f26825yK != null && !TextUtils.isEmpty(c8057a.m31688jW())) {
            this.f26825yK.setText(c8057a.m31688jW());
        }
        if (this.f26824yJ != null && !TextUtils.isEmpty(c8057a.m31687jX())) {
            this.f26824yJ.setText(c8057a.m31687jX());
        }
        int i = TextUtils.isEmpty(c8057a.m31688jW()) ? 8 : 0;
        View view = this.f26827yM;
        if (view != null) {
            view.setVisibility(i);
        }
        if (this.f26826yL == null || TextUtils.isEmpty(c8057a.m31692gX())) {
            return;
        }
        this.f26826yL.setText(c8057a.m31692gX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    /* renamed from: a */
    public Animator m31703a(final View view, View view2, final View view3) {
        final int height = view.getHeight();
        if (height <= 0 || view.getLayoutParams() == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view.getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_jinniu_card_height_full)).setDuration(500L);
        duration.setInterpolator(create);
        view.getContext();
        if (C11015ai.m24123LZ() && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            final int i = marginLayoutParams.bottomMargin;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.n.i.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.bottomMargin = i + (intValue - height);
                    view3.setLayoutParams(marginLayoutParams2);
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = intValue;
                        view.setLayoutParams(layoutParams);
                    }
                }
            });
        }
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 0.0f).setDuration(200L);
        Interpolator create2 = PathInterpolatorCompat.create(0.86f, 0.0f, 0.83f, 1.0f);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f).setDuration(300L);
        duration3.setInterpolator(create2);
        animatorSet.playSequentially(duration2, duration3);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(duration, animatorSet);
        return animatorSet2;
    }

    @Nullable
    /* renamed from: a */
    private static Animator m31704a(View view, float f) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(C9659R.dimen.ksad_jinniu_light_sweep_width) + f).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }
}
