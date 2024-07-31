package com.kwad.components.p208ad.p221f.p223b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.C9002l;
import com.kwad.components.core.video.InterfaceC9001k;
import com.kwad.components.p208ad.p221f.p222a.C7416a;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11013ag;
import com.kwad.sdk.utils.C11062bl;

/* renamed from: com.kwad.components.ad.f.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class View$OnClickListenerC7424a extends C7416a implements View.OnClickListener {

    /* renamed from: dU */
    private KsAdVideoPlayConfig f25429dU;

    /* renamed from: mR */
    private ViewGroup f25430mR;

    /* renamed from: mS */
    private ImageView f25431mS;

    /* renamed from: mT */
    private TextView f25432mT;

    public View$OnClickListenerC7424a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.f25429dU = ksAdVideoPlayConfig;
    }

    /* renamed from: e */
    private boolean m33298e(AdInfo adInfo) {
        if (C11013ag.isNetworkConnected(getContext())) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.f25429dU;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                    return true;
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                    return C11013ag.isWifiConnected(getContext());
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                    return false;
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    return C11013ag.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && C11013ag.isMobileConnected(getContext()));
                }
            }
            if (C10483a.m25887bU(adInfo)) {
                return true;
            }
            return C10483a.m25886bV(adInfo) && C11013ag.isWifiConnected(getContext());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ev */
    public void m33296ev() {
        if (this.f25430mR.getVisibility() != 0) {
            return;
        }
        this.f25430mR.setVisibility(8);
    }

    @Override // com.kwad.components.p208ad.p221f.p222a.C7416a, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        AdInfo m25641dQ = C10487e.m25641dQ(this.f25416mN.mAdTemplate);
        if (!m33298e(m25641dQ)) {
            this.f25432mT.setText(C11062bl.m23867ab(C10483a.m25976L(m25641dQ) * 1000));
            this.f25431mS.setOnClickListener(this);
            this.f25416mN.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.f25430mR.setVisibility(0);
        } else {
            this.f25430mR.setVisibility(8);
        }
        C9002l c9002l = new C9002l() { // from class: com.kwad.components.ad.f.b.a.1
            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                View$OnClickListenerC7424a.this.m33296ev();
            }

            @Override // com.kwad.components.core.video.C9002l, com.kwad.components.core.video.InterfaceC8997h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                View$OnClickListenerC7424a.this.m33296ev();
            }
        };
        this.mVideoPlayStateListener = c9002l;
        this.f25416mN.f25418mO.mo31843b((InterfaceC9001k) c9002l);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.f25431mS) {
            this.f25416mN.f25418mO.m33238eD();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.f25430mR = (ViewGroup) findViewById(C9659R.C9662id.ksad_data_flow_container);
        this.f25431mS = (ImageView) findViewById(C9659R.C9662id.ksad_data_flow_play_btn);
        this.f25432mT = (TextView) findViewById(C9659R.C9662id.ksad_data_flow_play_tip);
    }
}
