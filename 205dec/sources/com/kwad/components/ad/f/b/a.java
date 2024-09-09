package com.kwad.components.ad.f.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.video.l;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.bl;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a extends com.kwad.components.ad.f.a.a implements View.OnClickListener {
    private KsAdVideoPlayConfig dU;
    private ViewGroup mR;
    private ImageView mS;
    private TextView mT;

    public a(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.dU = ksAdVideoPlayConfig;
    }

    private boolean e(AdInfo adInfo) {
        if (ag.isNetworkConnected(getContext())) {
            KsAdVideoPlayConfig ksAdVideoPlayConfig = this.dU;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
                KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig;
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 1) {
                    return true;
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 2) {
                    return ag.isWifiConnected(getContext());
                }
                if (kSAdVideoPlayConfigImpl.getVideoAutoPlayType() == 3) {
                    return false;
                }
                if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
                    return ag.isWifiConnected(getContext()) || (kSAdVideoPlayConfigImpl.isDataFlowAutoStart() && ag.isMobileConnected(getContext()));
                }
            }
            if (com.kwad.sdk.core.response.b.a.bU(adInfo)) {
                return true;
            }
            return com.kwad.sdk.core.response.b.a.bV(adInfo) && ag.isWifiConnected(getContext());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ev() {
        if (this.mR.getVisibility() != 0) {
            return;
        }
        this.mR.setVisibility(8);
    }

    @Override // com.kwad.components.ad.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void aj() {
        super.aj();
        AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(this.mN.mAdTemplate);
        if (!e(dQ)) {
            this.mT.setText(bl.ab(com.kwad.sdk.core.response.b.a.L(dQ) * 1000));
            this.mS.setOnClickListener(this);
            this.mN.mAdTemplate.mVideoPlayerStatus.mVideoPlayerBehavior = 2;
            this.mR.setVisibility(0);
        } else {
            this.mR.setVisibility(8);
        }
        l lVar = new l() { // from class: com.kwad.components.ad.f.b.a.1
            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlayStart() {
                super.onMediaPlayStart();
                a.this.ev();
            }

            @Override // com.kwad.components.core.video.l, com.kwad.components.core.video.h
            public final void onMediaPlaying() {
                super.onMediaPlaying();
                a.this.ev();
            }
        };
        this.mVideoPlayStateListener = lVar;
        this.mN.mO.b((com.kwad.components.core.video.k) lVar);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.mS) {
            this.mN.mO.eD();
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.mR = (ViewGroup) findViewById(R.id.ksad_data_flow_container);
        this.mS = (ImageView) findViewById(R.id.ksad_data_flow_play_btn);
        this.mT = (TextView) findViewById(R.id.ksad_data_flow_play_tip);
    }
}
