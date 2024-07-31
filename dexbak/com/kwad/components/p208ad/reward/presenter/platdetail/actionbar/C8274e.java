package com.kwad.components.p208ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.p330s.C8946i;
import com.kwad.components.core.widget.C9374e;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.p208ad.reward.p264n.C8035a;
import com.kwad.components.p208ad.reward.p264n.C8074r;
import com.kwad.components.p208ad.reward.p264n.View$OnClickListenerC8065n;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8274e extends C8094b implements RewardActionBarControl.InterfaceC8257c {

    /* renamed from: gS */
    private ViewGroup f27303gS;

    /* renamed from: sr */
    private KsLogoView f27304sr;

    /* renamed from: uV */
    private View$OnClickListenerC8065n f27305uV;

    /* renamed from: uW */
    private int f27306uW;

    /* renamed from: uX */
    private FrameLayout.LayoutParams f27307uX;

    /* renamed from: uY */
    private View$OnClickListenerC8065n.InterfaceC8068a f27308uY;

    public C8274e(ViewGroup viewGroup, View$OnClickListenerC8065n.InterfaceC8068a interfaceC8068a) {
        this.f27303gS = viewGroup;
        this.f27308uY = interfaceC8068a;
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f26957qo.f26532oM.m31201a(this);
        AdInfo m25641dQ = C10487e.m25641dQ(this.f26957qo.mAdTemplate);
        this.f27306uW = this.f27304sr.getVisibility();
        this.f27307uX = C8273d.m31141a(getContext(), m25641dQ, this.f27304sr, C9659R.dimen.ksad_reward_order_logo_margin_bottom, !this.f26957qo.f26529oJ.m31821jM());
        View$OnClickListenerC8065n view$OnClickListenerC8065n = new View$OnClickListenerC8065n(this.f27303gS, new C8035a(getContext(), this.f26957qo) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.p208ad.reward.p264n.C8035a, com.kwad.components.p208ad.reward.p264n.InterfaceC8036b
            /* renamed from: ih */
            public final void mo31133ih() {
                C8274e.this.f26957qo.m32060a(1, C8274e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.p208ad.reward.p264n.C8035a, com.kwad.components.p208ad.reward.p264n.InterfaceC8036b
            /* renamed from: ii */
            public final void mo31132ii() {
                C8274e.this.f26957qo.m32060a(1, C8274e.this.getContext(), 10, 2);
            }
        });
        this.f27305uV = view$OnClickListenerC8065n;
        view$OnClickListenerC8065n.m31666a(this.f27308uY);
        this.f27305uV.m31726b(C8074r.m31647R(this.f26957qo.mAdTemplate));
        C8946i.m29551a(new C9374e(), this.f27305uV.mo31643gF());
    }

    @Override // com.kwad.components.p208ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.InterfaceC8257c
    /* renamed from: e */
    public final void mo31134e(InterfaceC8259a interfaceC8259a) {
        this.f27303gS.setVisibility(0);
        RewardActionBarControl.m31196a(interfaceC8259a, this.f27303gS, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f27304sr = (KsLogoView) findViewById(C9659R.C9662id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f27304sr.setVisibility(this.f27306uW);
        FrameLayout.LayoutParams layoutParams = this.f27307uX;
        if (layoutParams != null) {
            this.f27304sr.setLayoutParams(layoutParams);
        }
    }
}
