package com.kwad.components.p208ad.reward.presenter.p273g;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.p208ad.reward.C7845b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p252e.InterfaceC7892l;
import com.kwad.components.p208ad.reward.p260l.C8014d;
import com.kwad.components.p208ad.reward.p260l.p261a.C8005a;
import com.kwad.components.p208ad.reward.p264n.C8037c;
import com.kwad.components.p208ad.reward.p264n.C8042e;
import com.kwad.components.p208ad.reward.p264n.C8073q;
import com.kwad.components.p208ad.reward.presenter.C8094b;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p409b.C10486d;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.utils.C11015ai;
import com.kwad.sdk.widget.GestureDetector$OnGestureListenerC11148f;
import com.kwad.sdk.widget.InterfaceC11145c;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.reward.presenter.g.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8194a extends C8094b implements C8037c.InterfaceC8039a, InterfaceC10635a, InterfaceC11145c {
    private final InterfaceC7892l mRewardVerifyListener = new InterfaceC7892l() { // from class: com.kwad.components.ad.reward.presenter.g.a.1
        @Override // com.kwad.components.p208ad.reward.p252e.InterfaceC7892l
        public final void onRewardVerify() {
            if (C8194a.this.f27131wM != null) {
                C8194a.this.f27131wM.m31735jQ();
            }
            if (C8194a.this.f27132wN != null) {
                C8194a.this.f27132wN.m31735jQ();
            }
        }
    };

    /* renamed from: pr */
    private C8005a f27126pr;
    @Nullable

    /* renamed from: wI */
    private ViewGroup f27127wI;
    @Nullable

    /* renamed from: wJ */
    private C8073q f27128wJ;

    /* renamed from: wK */
    private ViewGroup f27129wK;

    /* renamed from: wL */
    private C8042e f27130wL;

    /* renamed from: wM */
    private C8037c f27131wM;
    @Nullable

    /* renamed from: wN */
    private C8037c f27132wN;

    /* renamed from: c */
    private void m31302c(View view, boolean z) {
        int id = view.getId();
        if (id == C9659R.C9662id.ksad_reward_apk_info_card_native_container || id == C9659R.C9662id.ksad_activity_apk_info_area_native) {
            m31301e(z, 2);
        }
    }

    /* renamed from: e */
    private void m31301e(boolean z, int i) {
        this.f26957qo.m32060a(1, getContext(), z ? 1 : 153, i);
    }

    @Override // com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a
    /* renamed from: a */
    public final void mo25245a(@Nullable C10640a c10640a) {
    }

    @Override // com.kwad.components.p208ad.reward.presenter.C8094b, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C10331c.m26254d("LandPageOpenTaskPresenter", "onBind");
        if (C7907g.m32063F(this.f26957qo.mAdTemplate)) {
            C8005a m31865jz = C8014d.m31865jz();
            this.f27126pr = m31865jz;
            this.f26957qo.f26569pr = m31865jz;
            C7845b.m32173fb().m32175a(this.mRewardVerifyListener);
            AdBaseFrameLayout adBaseFrameLayout = (AdBaseFrameLayout) findViewById(C9659R.C9662id.ksad_root_container);
            ViewGroup viewGroup = (ViewGroup) findViewById(C9659R.C9662id.ksad_activity_apk_info_area_native);
            this.f27127wI = viewGroup;
            if (viewGroup != null) {
                viewGroup.setClickable(true);
                this.f27127wI.setVisibility(8);
                new GestureDetector$OnGestureListenerC11148f(this.f27127wI, this);
                C8037c c8037c = new C8037c(this.f27127wI);
                this.f27132wN = c8037c;
                c8037c.m31743a(this);
                this.f27132wN.m31737c(this.f26957qo.mAdTemplate, false);
                ((KSFrameLayout) findViewById(C9659R.C9662id.ksad_right_area_webview_container)).setWidthBasedRatio(false);
                C8073q c8073q = new C8073q((KsAdWebView) findViewById(C9659R.C9662id.ksad_right_area_webview), this.f27127wI, null, this);
                this.f27128wJ = c8073q;
                c8073q.m31721a(this.f26957qo.mAdTemplate, adBaseFrameLayout);
            }
            m31304a(adBaseFrameLayout);
        }
    }

    @Override // com.kwad.components.p208ad.reward.p264n.C8037c.InterfaceC8039a
    /* renamed from: d */
    public final void mo31291d(boolean z, int i) {
        m31301e(z, 1);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C10331c.m26254d("LandPageOpenTaskPresenter", "onUnbind");
        C8042e c8042e = this.f27130wL;
        if (c8042e != null) {
            c8042e.m31716jS();
            this.f27130wL = null;
        }
        C8037c c8037c = this.f27132wN;
        if (c8037c != null) {
            c8037c.m31736jP();
        }
        C7845b.m32173fb().m32174b(this.mRewardVerifyListener);
        this.f26957qo.f26569pr = null;
    }

    /* renamed from: a */
    private void m31304a(AdBaseFrameLayout adBaseFrameLayout) {
        getContext();
        if (!C11015ai.m24123LZ()) {
            C10331c.m26254d("LandPageOpenTaskPresenter", "initBottomActionBar screen is horizontal");
            return;
        }
        ((ViewStub) findViewById(C9659R.C9662id.ksad_reward_apk_info_stub)).inflate();
        KSFrameLayout kSFrameLayout = (KSFrameLayout) findViewById(C9659R.C9662id.ksad_reward_apk_info_card_root);
        kSFrameLayout.setRadius(getContext().getResources().getDimension(C9659R.dimen.ksad_reward_apk_info_card_step_icon_radius));
        if (C10486d.m25655dH(this.f26957qo.mAdTemplate).size() == 0) {
            kSFrameLayout.setRatio(0.0f);
            C10751a.m24907m(kSFrameLayout, C10751a.m24924a(getContext(), 136.0f));
        } else {
            kSFrameLayout.setRatio(0.0f);
            C10751a.m24907m(kSFrameLayout, C10751a.m24924a(getContext(), 155.0f));
        }
        ViewGroup viewGroup = (ViewGroup) findViewById(C9659R.C9662id.ksad_reward_apk_info_card_native_container);
        this.f27129wK = viewGroup;
        viewGroup.setClickable(true);
        new GestureDetector$OnGestureListenerC11148f(this.f27129wK, this);
        C8037c c8037c = new C8037c(this.f27129wK);
        this.f27131wM = c8037c;
        c8037c.m31743a(this);
        this.f27131wM.m31737c(this.f26957qo.mAdTemplate, true);
        C8042e c8042e = new C8042e((KsAdWebView) findViewById(C9659R.C9662id.ksad_reward_apk_info_card_h5), this.f27129wK, null, this);
        this.f27130wL = c8042e;
        c8042e.m31721a(this.f26957qo.mAdTemplate, adBaseFrameLayout);
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: b */
    public final void mo23545b(View view) {
        if (C10486d.m25657dF(this.f26957qo.mAdTemplate)) {
            m31302c(view, false);
        }
    }

    @Override // com.kwad.sdk.widget.InterfaceC11145c
    /* renamed from: a */
    public final void mo23546a(View view) {
        m31302c(view, true);
    }
}
