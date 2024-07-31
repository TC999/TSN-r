package com.kwad.components.p208ad.reward.p264n;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.kwad.components.core.widget.C9374e;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.widget.KsAuthorIconView;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11015ai;

/* renamed from: com.kwad.components.ad.reward.n.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC8069o extends AbstractC8075s implements View.OnClickListener {

    /* renamed from: lw */
    private TextView f26910lw;

    /* renamed from: qo */
    private C7907g f26911qo;

    /* renamed from: zK */
    private KsLogoView f26912zK;

    /* renamed from: zL */
    private KsLogoView f26913zL;

    /* renamed from: zM */
    private KsAuthorIconView f26914zM;

    /* renamed from: zN */
    private RelativeLayout f26915zN;

    /* renamed from: zP */
    private String f26917zP;

    /* renamed from: zk */
    private TextView f26919zk;

    /* renamed from: zl */
    private TextView f26920zl;

    /* renamed from: zO */
    private boolean f26916zO = false;

    /* renamed from: zQ */
    private Runnable f26918zQ = new Runnable() { // from class: com.kwad.components.ad.reward.n.o.2
        @Override // java.lang.Runnable
        public final void run() {
            try {
                C10751a.m24921a(View$OnClickListenerC8069o.this.f26910lw, View$OnClickListenerC8069o.this.f26917zP, KsLogoView.m28913a(View$OnClickListenerC8069o.this.f26912zK));
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
                View$OnClickListenerC8069o.this.f26910lw.setText(View$OnClickListenerC8069o.this.f26917zP);
                View$OnClickListenerC8069o.this.f26910lw.setVisibility(0);
            }
        }
    };

    public View$OnClickListenerC8069o(C7907g c7907g) {
        this.f26911qo = c7907g;
    }

    /* renamed from: h */
    private static void m31654h(View view, int i) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = 85;
            layoutParams2.bottomMargin = C10751a.m24924a(view.getContext(), 20.0f);
            view.requestLayout();
        }
    }

    private void initView() {
        ViewGroup viewGroup = this.f26932sz;
        if (viewGroup == null) {
            return;
        }
        this.f26914zM = (KsAuthorIconView) viewGroup.findViewById(C9659R.C9662id.ksad_live_author_icon);
        this.f26919zk = (TextView) this.f26932sz.findViewById(C9659R.C9662id.kwad_actionbar_title);
        this.f26910lw = (TextView) this.f26932sz.findViewById(C9659R.C9662id.kwad_actionbar_des_text);
        this.f26920zl = (TextView) this.f26932sz.findViewById(C9659R.C9662id.ksad_live_actionbar_btn);
        this.f26913zL = (KsLogoView) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_live_kwai_logo);
        if (!this.f26916zO) {
            this.f26915zN = (RelativeLayout) this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_origin_live_relative);
        }
        this.f26932sz.setOnClickListener(this);
        this.f26920zl.setOnClickListener(this);
        this.f26914zM.setOnClickListener(this);
        this.f26910lw.setOnClickListener(this);
        this.f26919zk.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: ab */
    public final void mo31659ab(boolean z) {
        super.mo31659ab(z);
        Context context = this.f26932sz.getContext();
        if (C11015ai.m24123LZ()) {
            return;
        }
        if (!this.f26916zO) {
            this.f26932sz.findViewById(C9659R.C9662id.ksad_reward_origin_live_base1).setVisibility(0);
            ViewGroup.LayoutParams layoutParams = this.f26915zN.getLayoutParams();
            Resources resources = context.getResources();
            int i = C9659R.dimen.ksad_live_subscribe_card_width_horizontal;
            layoutParams.width = resources.getDimensionPixelSize(i);
            this.f26915zN.setLayoutParams(layoutParams);
            ViewGroup.LayoutParams layoutParams2 = this.f26920zl.getLayoutParams();
            layoutParams2.width = context.getResources().getDimensionPixelSize(i);
            this.f26920zl.setLayoutParams(layoutParams2);
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = this.f26932sz.getLayoutParams();
        layoutParams3.width = context.getResources().getDimensionPixelSize(C9659R.dimen.ksad_live_subscribe_card_width_horizontal);
        this.f26932sz.setLayoutParams(layoutParams3);
        m31654h(this.f26932sz, 85);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view.equals(this.f26920zl)) {
            this.f26911qo.m32060a(1, view.getContext(), 29, 1);
        } else if (view.equals(this.f26914zM)) {
            this.f26911qo.m32060a(1, view.getContext(), 30, 1);
        } else if (view.equals(this.f26910lw)) {
            this.f26911qo.m32060a(1, view.getContext(), 32, 1);
        } else if (view.equals(this.f26919zk)) {
            this.f26911qo.m32060a(1, view.getContext(), 31, 1);
        } else if (view.equals(this.f26932sz)) {
            this.f26911qo.m32060a(1, view.getContext(), 53, 2);
        }
    }

    /* renamed from: b */
    private void m31657b(AdTemplate adTemplate) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        this.f26919zk.setText(C10483a.m25823cc(m25641dQ));
        C9374e c9374e = new C9374e();
        this.f26914zM.setVisibility(0);
        this.f26914zM.m30986b(adTemplate);
        this.f26914zM.m30988a(c9374e);
        this.f26920zl.setText(C10483a.m25957aE(m25641dQ));
        if (C10483a.m25874bf(m25641dQ) == 8) {
            this.f26913zL.setVisibility(0);
            this.f26913zL.m28912aD(adTemplate);
            this.f26910lw.setText(C10483a.m25915au(m25641dQ));
            return;
        }
        this.f26917zP = C10483a.m25915au(m25641dQ);
        KsLogoView ksLogoView = new KsLogoView(this.f26932sz.getContext(), false);
        this.f26912zK = ksLogoView;
        ksLogoView.setLogoLoadFinishListener(new KsLogoView.InterfaceC9361a() { // from class: com.kwad.components.ad.reward.n.o.1
            @Override // com.kwad.components.core.widget.KsLogoView.InterfaceC9361a
            /* renamed from: kc */
            public final void mo28908kc() {
                View$OnClickListenerC8069o.this.f26910lw.post(View$OnClickListenerC8069o.this.f26918zQ);
            }
        });
        this.f26912zK.m28912aD(adTemplate);
        this.f26913zL.setVisibility(8);
    }

    /* renamed from: a */
    public final void m31661a(ViewGroup viewGroup, int i) {
        if (i == 8) {
            super.m31644a(viewGroup, C9659R.C9662id.ksad_reward_origin_live_shop_stub, C9659R.C9662id.ksad_reward_origin_live_root);
            this.f26916zO = true;
        } else {
            super.m31644a(viewGroup, C9659R.C9662id.ksad_reward_origin_live_base_stub, C9659R.C9662id.ksad_reward_origin_live_root);
            this.f26916zO = false;
        }
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.components.p208ad.reward.p264n.AbstractC8041d
    /* renamed from: a */
    public final void mo31651a(C8074r c8074r) {
        super.mo31651a(c8074r);
        m31657b(c8074r.getAdTemplate());
    }
}
