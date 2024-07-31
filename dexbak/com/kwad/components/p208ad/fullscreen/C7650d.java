package com.kwad.components.p208ad.fullscreen;

import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.monitor.InterfaceC8030a;
import com.kwad.components.p208ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.p208ad.reward.monitor.RewardMonitorInfo;
import com.kwad.components.p208ad.reward.p252e.C7882c;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p434g.InterfaceC10761a;

/* renamed from: com.kwad.components.ad.fullscreen.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7650d extends C7882c {
    private AdTemplate mAdTemplate;
    private KsFullScreenVideoAd.FullScreenVideoAdInteractionListener mInteractionListener;

    /* renamed from: b */
    public final void m32718b(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        this.mInteractionListener = fullScreenVideoAdInteractionListener;
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    /* renamed from: bJ */
    public final void mo32088bJ() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onAdClicked();
        }
        C8032c.m31770a(false, (InterfaceC8030a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    /* renamed from: h */
    public void mo32084h(boolean z) {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onPageDismiss();
        }
        C8032c.m31770a(false, (InterfaceC8030a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    public final void onVideoPlayEnd() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoPlayEnd();
        }
        C8032c.m31770a(false, (InterfaceC8030a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    public final void onVideoPlayError(int i, int i2) {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoPlayError(i, i2);
        }
        C8032c.m31770a(false, (InterfaceC8030a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    public final void onVideoPlayStart() {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onVideoPlayStart();
        }
        C8032c.m31770a(false, (InterfaceC8030a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    public final void onVideoSkipToEnd(long j) {
        KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener = this.mInteractionListener;
        if (fullScreenVideoAdInteractionListener != null) {
            fullScreenVideoAdInteractionListener.onSkippedVideo();
        }
        C8032c.m31770a(false, (InterfaceC8030a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
