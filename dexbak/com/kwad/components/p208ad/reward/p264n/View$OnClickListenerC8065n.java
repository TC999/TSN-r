package com.kwad.components.p208ad.reward.p264n;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.kwad.components.core.p330s.C8946i;
import com.kwad.components.core.widget.C9374e;
import com.kwad.components.core.widget.KSCornerImageView;
import com.kwad.components.p208ad.p213d.C7355b;
import com.kwad.components.p208ad.reward.widget.KSCouponLabelTextView;
import com.kwad.components.p208ad.widget.KsPriceView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p445n.C10887l;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.utils.C11053bg;

/* renamed from: com.kwad.components.ad.reward.n.n */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8065n extends AbstractC8041d implements View.OnClickListener {

    /* renamed from: gS */
    private ViewGroup f26896gS;

    /* renamed from: yA */
    private TextView f26897yA;

    /* renamed from: zA */
    private LinearLayout f26898zA;

    /* renamed from: zB */
    private KsPriceView f26899zB;

    /* renamed from: zC */
    private TextView f26900zC;

    /* renamed from: zD */
    private View f26901zD;

    /* renamed from: zE */
    private KSCornerImageView f26902zE;

    /* renamed from: zF */
    private InterfaceC8036b f26903zF;

    /* renamed from: zG */
    private InterfaceC8068a f26904zG;

    /* renamed from: zt */
    private ViewGroup f26905zt;

    /* renamed from: zz */
    private KSCornerImageView f26906zz;

    /* renamed from: com.kwad.components.ad.reward.n.n$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC8068a {
        /* renamed from: ht */
        void mo31488ht();
    }

    public View$OnClickListenerC8065n(ViewGroup viewGroup, InterfaceC8036b interfaceC8036b) {
        this.f26896gS = viewGroup;
        this.f26903zF = interfaceC8036b;
        initView();
    }

    /* renamed from: a */
    static /* synthetic */ View m31664a(View$OnClickListenerC8065n view$OnClickListenerC8065n, Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        return m31667a(context, couponInfo, viewGroup);
    }

    private void initView() {
        this.f26905zt = (ViewGroup) this.f26896gS.findViewById(C9659R.C9662id.ksad_reward_order_root);
        this.f26906zz = (KSCornerImageView) this.f26896gS.findViewById(C9659R.C9662id.ksad_reward_order_icon);
        this.f26897yA = (TextView) this.f26896gS.findViewById(C9659R.C9662id.ksad_reward_order_title);
        this.f26898zA = (LinearLayout) this.f26896gS.findViewById(C9659R.C9662id.ksad_reward_order_coupon_list);
        this.f26899zB = (KsPriceView) this.f26896gS.findViewById(C9659R.C9662id.ksad_reward_order_price);
        this.f26900zC = (TextView) this.f26896gS.findViewById(C9659R.C9662id.ksad_reward_order_btn_buy);
        this.f26901zD = this.f26896gS.findViewById(C9659R.C9662id.ksad_reward_order_text_area);
        this.f26902zE = (KSCornerImageView) this.f26896gS.findViewById(C9659R.C9662id.ksad_reward_order_kwai_logo);
        this.f26900zC.setText(C7355b.m33443Y());
        this.f26900zC.setOnClickListener(this);
        this.f26906zz.setOnClickListener(this);
        this.f26901zD.setOnClickListener(this);
        Context context = this.f26896gS.getContext();
        if (C11015ai.m24123LZ()) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.f26896gS.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = context.getResources().getDimensionPixelSize(C9659R.dimen.ksad_reward_follow_card_width_horizontal);
            this.f26896gS.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: gF */
    public final ViewGroup mo31643gF() {
        return this.f26905zt;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f26903zF == null) {
            return;
        }
        if (view.equals(this.f26900zC)) {
            this.f26903zF.mo31139gJ();
        } else if (view.equals(this.f26906zz)) {
            this.f26903zF.mo31133ih();
        } else if (view.equals(this.f26901zD)) {
            this.f26903zF.mo31132ii();
        }
    }

    /* renamed from: a */
    public final void m31666a(InterfaceC8068a interfaceC8068a) {
        this.f26904zG = interfaceC8068a;
    }

    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: a */
    public final void mo31651a(C8074r c8074r) {
        super.mo31651a(c8074r);
        m31663a(C10483a.m25838cP(C10487e.m25641dQ(c8074r.getAdTemplate())), c8074r.getAdTemplate());
    }

    /* renamed from: a */
    private void m31663a(final AdProductInfo adProductInfo, AdTemplate adTemplate) {
        KSImageLoader.loadImage(this.f26906zz, adProductInfo.getIcon(), adTemplate);
        this.f26897yA.setText(adProductInfo.getName());
        if (adProductInfo.isCouponListEmpty()) {
            this.f26898zA.setVisibility(8);
            this.f26904zG.mo31488ht();
        } else {
            this.f26898zA.setVisibility(0);
            this.f26898zA.post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.n.n.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    for (CouponInfo couponInfo : adProductInfo.getCouponList()) {
                        View$OnClickListenerC8065n view$OnClickListenerC8065n = View$OnClickListenerC8065n.this;
                        View m31664a = View$OnClickListenerC8065n.m31664a(view$OnClickListenerC8065n, view$OnClickListenerC8065n.f26898zA.getContext(), couponInfo, View$OnClickListenerC8065n.this.f26898zA);
                        ViewGroup.LayoutParams layoutParams = m31664a.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = new ViewGroup.LayoutParams(-2, -1);
                        } else {
                            layoutParams.width = -2;
                            layoutParams.height = -1;
                        }
                        View$OnClickListenerC8065n.this.f26898zA.addView(m31664a, layoutParams);
                        C8946i.m29551a(new C9374e(), View$OnClickListenerC8065n.this.f26898zA);
                    }
                    if (View$OnClickListenerC8065n.this.f26904zG != null) {
                        if (View$OnClickListenerC8065n.this.f26898zA.getChildCount() > 0) {
                            View$OnClickListenerC8065n.this.f26898zA.getChildAt(0).post(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.n.n.1.1
                                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                                public final void doTask() {
                                    View$OnClickListenerC8065n.this.f26904zG.mo31488ht();
                                }
                            });
                        } else {
                            View$OnClickListenerC8065n.this.f26904zG.mo31488ht();
                        }
                    }
                }
            });
        }
        this.f26899zB.m30440h(adProductInfo.getPrice(), adProductInfo.getOriginPrice());
        String m33442Z = C7355b.m33442Z();
        if (C11053bg.isNullString(m33442Z)) {
            return;
        }
        KSImageLoader.loadImage(this.f26902zE, m33442Z, adTemplate);
    }

    /* renamed from: a */
    private static View m31667a(Context context, CouponInfo couponInfo, ViewGroup viewGroup) {
        KSCouponLabelTextView kSCouponLabelTextView = (KSCouponLabelTextView) C10887l.m24563a(context, C9659R.C9663layout.ksad_reward_order_card_coupon, viewGroup, false);
        kSCouponLabelTextView.setText(couponInfo.getDisplayName());
        return kSCouponLabelTextView;
    }
}
