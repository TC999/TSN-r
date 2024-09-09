package com.kwad.components.ad.reward.n;

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
import com.kwad.components.ad.widget.KsPriceView;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.core.widget.KsStyledTextButton;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.ai;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i extends d implements View.OnClickListener {
    @Nullable
    private TextView hz;
    @Nullable
    private KSCornerImageView lv;
    @Nullable
    private TextView lw;
    @Nullable
    private KsLogoView mLogoView;
    private com.kwad.components.ad.reward.g qo;
    private ViewGroup sz;
    private ViewGroup yG;
    @Nullable
    private KsPriceView yH;
    @Nullable
    private TextView yI;
    @Nullable
    private KsStyledTextButton yJ;
    @Nullable
    private TextView yK;
    @Nullable
    private TextView yL;
    @Nullable
    private View yM;
    @Nullable
    private ImageView yN;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private String kZ;

        /* renamed from: qa  reason: collision with root package name */
        private String f38646qa;
        private String qb;
        private String rR;
        private String rating;
        private String title;
        private String yX;
        @Nullable
        private String yY;
        private String yZ;
        private String za;

        private a() {
        }

        private void L(String str) {
            this.rR = str;
        }

        static a Q(AdTemplate adTemplate) {
            CouponInfo firstCouponList;
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
            AdProductInfo cP = com.kwad.sdk.core.response.b.a.cP(dQ);
            a aVar = new a();
            String name = cP.getName();
            aVar.title = name;
            if (TextUtils.isEmpty(name)) {
                aVar.title = com.kwad.sdk.core.response.b.a.ax(dQ);
            }
            aVar.yZ = com.kwad.sdk.core.response.b.a.aE(dQ);
            aVar.f38646qa = cP.getIcon();
            aVar.qb = com.kwad.sdk.core.response.b.a.au(dQ);
            aVar.yX = cP.getPrice();
            aVar.kZ = cP.getOriginPrice();
            aVar.za = cP.getVolume();
            aVar.rating = cP.getRating();
            if (!cP.isCouponListEmpty() && (firstCouponList = cP.getFirstCouponList()) != null) {
                aVar.yY = CouponInfo.jinniuFormatCoupon(firstCouponList);
                aVar.L(firstCouponList.getFormattedJinniuPrefix());
            }
            return aVar;
        }

        public final String dz() {
            return this.kZ;
        }

        public final String gX() {
            return this.rR;
        }

        public final String getRating() {
            return this.rating;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String gf() {
            return this.f38646qa;
        }

        public final String gg() {
            return this.qb;
        }

        public final String jV() {
            return this.yX;
        }

        public final String jW() {
            return this.yY;
        }

        public final String jX() {
            return this.yZ;
        }

        public final String jY() {
            return this.za;
        }
    }

    public i(com.kwad.components.ad.reward.g gVar, ViewGroup viewGroup, KsLogoView ksLogoView) {
        this.qo = gVar;
        this.mLogoView = ksLogoView;
        this.yG = viewGroup;
        initView();
    }

    static /* synthetic */ Animator a(i iVar, View view, float f4) {
        return a(view, f4);
    }

    private void initView() {
        this.sz = (ViewGroup) this.yG.findViewById(R.id.ksad_reward_jinniu_root);
        this.lv = (KSCornerImageView) this.yG.findViewById(R.id.ksad_reward_jinniu_icon);
        this.hz = (TextView) this.yG.findViewById(R.id.ksad_reward_jinniu_title);
        this.lw = (TextView) this.yG.findViewById(R.id.ksad_reward_jinniu_desc);
        this.yH = (KsPriceView) this.yG.findViewById(R.id.ksad_reward_jinniu_price);
        this.yI = (TextView) this.yG.findViewById(R.id.ksad_reward_jinniu_right_label);
        this.yJ = (KsStyledTextButton) this.yG.findViewById(R.id.ksad_reward_jinniu_btn_buy);
        this.yN = (ImageView) this.yG.findViewById(R.id.ksad_reward_jinniu_light_sweep);
        this.yM = this.yG.findViewById(R.id.ksad_reward_jinniu_coupon_layout);
        this.yK = (TextView) this.yG.findViewById(R.id.ksad_reward_jinniu_coupon);
        this.yL = (TextView) this.yG.findViewById(R.id.ksad_reward_jinniu_coupon_prefix);
        this.sz.setOnClickListener(this);
        KsStyledTextButton ksStyledTextButton = this.yJ;
        if (ksStyledTextButton != null) {
            ksStyledTextButton.setOnClickListener(this);
        }
        Context context = this.sz.getContext();
        if (ai.LZ()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.sz.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(R.dimen.ksad_reward_follow_card_width_horizontal);
            this.sz.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final ViewGroup gF() {
        return this.sz;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.sz)) {
            this.qo.a(1, view.getContext(), 118, 2);
        } else if (view.equals(this.yJ)) {
            this.qo.a(1, view.getContext(), 1, 1);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public final void a(r rVar) {
        super.a(rVar);
        if (rVar == null) {
            return;
        }
        a(rVar.getAdTemplate(), a.Q(rVar.getAdTemplate()));
        ViewGroup viewGroup = this.sz;
        if (viewGroup != null) {
            viewGroup.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.1
                @Override // java.lang.Runnable
                public final void run() {
                    i iVar = i.this;
                    Animator a4 = iVar.a(iVar.sz, i.this.yJ, i.this.mLogoView);
                    if (a4 != null) {
                        a4.start();
                    }
                }
            }, 3000L);
            this.sz.postDelayed(new Runnable() { // from class: com.kwad.components.ad.reward.n.i.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (i.this.yJ == null || i.this.yJ.getWidth() == 0) {
                        return;
                    }
                    i iVar = i.this;
                    final Animator a4 = i.a(iVar, iVar.yN, i.this.yJ.getWidth());
                    if (a4 != null) {
                        a4.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.n.i.2.1
                            private int yP = 1;

                            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                            public final void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                if (this.yP >= 3) {
                                    return;
                                }
                                a4.start();
                                this.yP++;
                            }
                        });
                        a4.start();
                    }
                }
            }, 5000L);
        }
    }

    private void a(AdTemplate adTemplate, a aVar) {
        if (aVar == null) {
            return;
        }
        KSImageLoader.loadAppIcon(this.lv, aVar.gf(), adTemplate, 4);
        TextView textView = this.hz;
        if (textView != null) {
            textView.setText(aVar.getTitle());
        }
        TextView textView2 = this.lw;
        if (textView2 != null) {
            textView2.setText(aVar.gg());
        }
        KsPriceView ksPriceView = this.yH;
        if (ksPriceView != null) {
            int dimensionPixelSize = ksPriceView.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_end_origin_text_size);
            this.yH.getConfig().ae(dimensionPixelSize).ag(dimensionPixelSize).af(this.yH.getResources().getColor(R.color.ksad_jinniu_end_origin_color));
            this.yH.d(aVar.jV(), aVar.dz(), true);
        }
        if (this.yI != null) {
            if (!TextUtils.isEmpty(aVar.jY())) {
                this.yI.setText(aVar.jY());
            } else if (!TextUtils.isEmpty(aVar.getRating())) {
                this.yI.setText(aVar.getRating());
            } else {
                this.yI.setVisibility(8);
            }
        }
        if (this.yK != null && !TextUtils.isEmpty(aVar.jW())) {
            this.yK.setText(aVar.jW());
        }
        if (this.yJ != null && !TextUtils.isEmpty(aVar.jX())) {
            this.yJ.setText(aVar.jX());
        }
        int i4 = TextUtils.isEmpty(aVar.jW()) ? 8 : 0;
        View view = this.yM;
        if (view != null) {
            view.setVisibility(i4);
        }
        if (this.yL == null || TextUtils.isEmpty(aVar.gX())) {
            return;
        }
        this.yL.setText(aVar.gX());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public Animator a(final View view, View view2, final View view3) {
        final int height = view.getHeight();
        if (height <= 0 || view.getLayoutParams() == null) {
            return null;
        }
        Interpolator create = PathInterpolatorCompat.create(0.51f, 0.0f, 0.67f, 1.0f);
        ValueAnimator duration = ValueAnimator.ofInt(height, view.getResources().getDimensionPixelSize(R.dimen.ksad_reward_jinniu_card_height_full)).setDuration(500L);
        duration.setInterpolator(create);
        view.getContext();
        if (ai.LZ() && view3 != null && (view3.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            final int i4 = marginLayoutParams.bottomMargin;
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.n.i.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = marginLayoutParams;
                    marginLayoutParams2.bottomMargin = i4 + (intValue - height);
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
    private static Animator a(View view, float f4) {
        if (view == null || view.getWidth() <= 0) {
            return null;
        }
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationX", view.getResources().getDimension(R.dimen.ksad_jinniu_light_sweep_width) + f4).setDuration(1000L);
        duration.setInterpolator(PathInterpolatorCompat.create(0.42f, 0.0f, 1.0f, 1.0f));
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(1000L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(duration, duration2);
        return animatorSet;
    }
}
