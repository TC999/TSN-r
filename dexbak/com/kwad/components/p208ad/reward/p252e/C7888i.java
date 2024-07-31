package com.kwad.components.p208ad.reward.p252e;

import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.monitor.InterfaceC8030a;
import com.kwad.components.p208ad.reward.monitor.RewardInteractionCallbackType;
import com.kwad.components.p208ad.reward.monitor.RewardMonitorInfo;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.p434g.InterfaceC10761a;

/* renamed from: com.kwad.components.ad.reward.e.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7888i extends C7882c {
    private AdTemplate mAdTemplate;

    /* renamed from: rx */
    private String f26504rx;

    /* renamed from: gS */
    private KsRewardVideoAd.RewardAdInteractionListener m32086gS() {
        return C7885f.m32095G(getUniqueId());
    }

    private String getUniqueId() {
        return this.f26504rx;
    }

    /* renamed from: K */
    public final void m32089K(String str) {
        this.f26504rx = str;
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    /* renamed from: bJ */
    public void mo32088bJ() {
        super.mo32088bJ();
        KsRewardVideoAd.RewardAdInteractionListener m32086gS = m32086gS();
        if (m32086gS != null) {
            m32086gS.onAdClicked();
        }
        C8032c.m31770a(true, (InterfaceC8030a) RewardInteractionCallbackType.AD_CLICK, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    /* renamed from: gR */
    public final boolean m32087gR() {
        KsRewardVideoAd.RewardAdInteractionListener m32086gS = m32086gS();
        if (m32086gS != null) {
            m32086gS.onRewardVerify();
        }
        C8032c.m31770a(true, (InterfaceC8030a) RewardInteractionCallbackType.REWARD_VERIFY, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
        return m32086gS != null;
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    /* renamed from: h */
    public void mo32084h(boolean z) {
        super.mo32084h(z);
        KsRewardVideoAd.RewardAdInteractionListener m32086gS = m32086gS();
        if (m32086gS != null) {
            m32086gS.onPageDismiss();
        }
        C8032c.m31770a(true, (InterfaceC8030a) RewardInteractionCallbackType.PAGE_DISMISS, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    public void onRewardVerify() {
        super.onRewardVerify();
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    public final void onVideoPlayEnd() {
        super.onVideoPlayEnd();
        KsRewardVideoAd.RewardAdInteractionListener m32086gS = m32086gS();
        if (m32086gS != null) {
            m32086gS.onVideoPlayEnd();
        }
        C8032c.m31770a(true, (InterfaceC8030a) RewardInteractionCallbackType.VIDEO_PLAY_END, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    public final void onVideoPlayError(int i, int i2) {
        super.onVideoPlayError(i, i2);
        KsRewardVideoAd.RewardAdInteractionListener m32086gS = m32086gS();
        if (m32086gS != null) {
            m32086gS.onVideoPlayError(i, i2);
        }
        C8032c.m31770a(true, (InterfaceC8030a) RewardInteractionCallbackType.VIDEO_PLAY_ERROR, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    public final void onVideoPlayStart() {
        super.onVideoPlayStart();
        KsRewardVideoAd.RewardAdInteractionListener m32086gS = m32086gS();
        if (m32086gS != null) {
            m32086gS.onVideoPlayStart();
        }
        C8032c.m31770a(true, (InterfaceC8030a) RewardInteractionCallbackType.VIDEO_PLAY_START, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
    }

    @Override // com.kwad.components.p208ad.reward.p252e.C7882c, com.kwad.components.p208ad.reward.p252e.InterfaceC7881b
    public final void onVideoSkipToEnd(long j) {
        super.onVideoSkipToEnd(j);
        try {
            KsRewardVideoAd.RewardAdInteractionListener m32086gS = m32086gS();
            if (m32086gS != null) {
                m32086gS.onVideoSkipToEnd(j);
            }
            C8032c.m31770a(true, (InterfaceC8030a) RewardInteractionCallbackType.VIDEO_SKIP_TO_END, this.mAdTemplate, (InterfaceC10761a<RewardMonitorInfo>) null);
        } catch (Throwable unused) {
        }
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    /* renamed from: h */
    public final boolean m32085h(final int i, final int i2) {
        KsRewardVideoAd.RewardAdInteractionListener m32086gS = m32086gS();
        if (m32086gS != null) {
            m32086gS.onRewardStepVerify(i, i2);
        }
        C8032c.m31770a(true, (InterfaceC8030a) RewardInteractionCallbackType.REWARD_STEP_VERIFY, this.mAdTemplate, new InterfaceC10761a<RewardMonitorInfo>() { // from class: com.kwad.components.ad.reward.e.i.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10761a
            /* renamed from: a */
            public void accept(RewardMonitorInfo rewardMonitorInfo) {
                rewardMonitorInfo.setTaskType(i).setTaskStep(i2);
            }
        });
        return m32086gS != null;
    }
}
