package com.kwad.components.p208ad.reward;

import android.app.Activity;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kwad.components.core.internal.api.C8679c;
import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.components.core.internal.api.InterfaceC8678b;
import com.kwad.components.core.p298i.C8675d;
import com.kwad.components.core.video.C9000j;
import com.kwad.components.p208ad.p236h.C7668b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.p250c.C7865c;
import com.kwad.components.p208ad.reward.p252e.C7887h;
import com.kwad.components.p208ad.reward.page.AdRewardPreviewActivityProxy;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10250c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p439j.C10819a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.kwad.components.ad.reward.KsRewardVideoAdControl */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsRewardVideoAdControl implements InterfaceC8677a, KsRewardVideoAd {
    private final AdInfo mAdInfo;
    @NonNull
    private final AdResultData mAdResultData;
    @NonNull
    private final AdTemplate mAdTemplate;

    /* renamed from: ow */
    private final AdGlobalConfigInfo f26412ow;

    /* renamed from: ox */
    private C7887h f26413ox;

    /* renamed from: oy */
    private C8675d f26414oy;

    /* renamed from: bZ */
    private C8679c f26411bZ = new C8679c();
    public int rewardType = 1;

    public KsRewardVideoAdControl(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        this.mAdTemplate = m25661n;
        this.mAdInfo = C10487e.m25641dQ(m25661n);
        this.f26412ow = adResultData.adGlobalConfigInfo;
        m32209fh();
    }

    /* renamed from: fh */
    private void m32209fh() {
        C7668b.m32688eI().m32692a(this);
        AdGlobalConfigInfo adGlobalConfigInfo = this.f26412ow;
        boolean z = true;
        boolean z2 = adGlobalConfigInfo != null && adGlobalConfigInfo.isNeoScan();
        this.mAdTemplate.isNativeRewardPreview = (!C10483a.m25884bX(this.mAdInfo) || z2) ? false : false;
    }

    /* renamed from: fi */
    private void m32208fi() {
        AdInfo adInfo;
        if (C7865c.m32127a(this.f26413ox) || (adInfo = this.mAdInfo) == null) {
            return;
        }
        adInfo.adBaseInfo.extraClickReward = false;
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: ag */
    public final boolean mo30033ag() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: b */
    public final void mo30032b(InterfaceC8678b interfaceC8678b) {
        this.f26411bZ.m30028b(interfaceC8678b);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getECPM() {
        return C10483a.m25944aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getInteractionType() {
        return C10483a.m25945aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public List<KSAdInfoData> getKSAdInfoDatas() {
        AdResultData adResultData;
        ArrayList arrayList = new ArrayList();
        if (C10251d.m26527a(C10250c.asX) && (adResultData = this.mAdResultData) != null && adResultData.getAdTemplateList().size() > 0) {
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                arrayList.add(C10483a.m25798db(C10487e.m25641dQ(adTemplate)));
            }
        }
        return arrayList;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public int getMaterialType() {
        return C10483a.m25875be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (C10251d.m26570BX()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public boolean isAdEnable() {
        if (C10487e.m25625eg(this.mAdTemplate) >= 0) {
            return true;
        }
        return C9000j.m29408ax(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        C9908c.m27351a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setInnerAdInteractionListener(KsInnerAd.KsInnerAdInteractionListener ksInnerAdInteractionListener) {
        this.f26414oy = new C8675d(ksInnerAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setRewardAdInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        if (this.f26413ox == null) {
            this.f26413ox = new C7887h() { // from class: com.kwad.components.ad.reward.KsRewardVideoAdControl.1
                @Override // com.kwad.components.p208ad.reward.p252e.C7887h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    KsRewardVideoAdControl.this.f26411bZ.m30026i(KsRewardVideoAdControl.this);
                }

                @Override // com.kwad.components.p208ad.reward.p252e.C7887h, com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    KsRewardVideoAdControl.this.f26411bZ.m30027h(KsRewardVideoAdControl.this);
                }
            };
        }
        this.f26413ox.m32090b(rewardAdInteractionListener);
    }

    @Keep
    public void setRewardPlayAgainInteractionListener(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void showRewardVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity != null && !activity.isFinishing()) {
            C10819a.m24739ak("reward", TTLogUtil.TAG_EVENT_SHOW);
            C8032c.m31748h(true, this.mAdTemplate);
            C9828c.m27589by(this.mAdTemplate);
            if (!C10251d.m26556CF() && !isAdEnable()) {
                C10331c.m26248i("KsRewardVideoAdControl", "isAdEnable is false");
                C10819a.m24738al("reward", TTLogUtil.TAG_EVENT_SHOW);
                C8032c.m31756b(true, this.mAdTemplate, "cache_not_ready");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            m32211a(activity, ksVideoPlayConfig);
            return;
        }
        C10331c.m26250e("KsRewardVideoAdControl", "showRewardVideoAd error, activity is null or finished");
        C8032c.m31756b(true, this.mAdTemplate, "illegal_activity");
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: a */
    public final void mo30034a(InterfaceC8678b interfaceC8678b) {
        this.f26411bZ.m30029a(interfaceC8678b);
    }

    @Override // com.kwad.sdk.api.KsRewardVideoAd
    public void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        C9908c.m27292l(adTemplate, j2);
    }

    /* renamed from: a */
    private void m32211a(Activity activity, @NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        m32208fi();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate.isNativeRewardPreview) {
            AdRewardPreviewActivityProxy.launch(activity, this.mAdResultData, adTemplate, C10483a.m25943aS(this.mAdInfo), this.f26413ox);
        } else {
            KSRewardVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.f26413ox, this.f26414oy, this.rewardType);
        }
    }
}
