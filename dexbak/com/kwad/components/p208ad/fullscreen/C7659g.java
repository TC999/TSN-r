package com.kwad.components.p208ad.fullscreen;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.kwad.components.core.internal.api.C8679c;
import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.components.core.internal.api.InterfaceC8678b;
import com.kwad.components.core.video.C9000j;
import com.kwad.components.p208ad.p236h.C7668b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p439j.C10819a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.components.ad.fullscreen.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7659g implements InterfaceC8677a, KsFullScreenVideoAd {

    /* renamed from: bZ */
    private C8679c f25961bZ = new C8679c();

    /* renamed from: gG */
    private C7610c f25962gG;
    private AdInfo mAdInfo;
    @NonNull
    private final AdResultData mAdResultData;
    @NonNull
    private AdTemplate mAdTemplate;

    public C7659g(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate m25661n = C10485c.m25661n(adResultData);
        this.mAdTemplate = m25661n;
        this.mAdInfo = C10487e.m25641dQ(m25661n);
        C7668b.m32688eI().m32692a(this);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: ag */
    public final boolean mo30033ag() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: b */
    public final void mo30032b(InterfaceC8678b interfaceC8678b) {
        this.f25961bZ.m30028b(interfaceC8678b);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getECPM() {
        return C10483a.m25944aR(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getInteractionType() {
        return C10483a.m25945aQ(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final int getMaterialType() {
        return C10483a.m25875be(this.mAdInfo);
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (C10251d.m26570BX()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final boolean isAdEnable() {
        if (C10487e.m25625eg(this.mAdTemplate) >= 0) {
            return true;
        }
        return C9000j.m29408ax(this.mAdTemplate);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        C9908c.m27351a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setFullScreenVideoAdInteractionListener(KsFullScreenVideoAd.FullScreenVideoAdInteractionListener fullScreenVideoAdInteractionListener) {
        if (this.f25962gG == null) {
            this.f25962gG = new C7610c() { // from class: com.kwad.components.ad.fullscreen.g.1
                @Override // com.kwad.components.p208ad.fullscreen.C7610c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    C7659g.this.f25961bZ.m30026i(C7659g.this);
                }

                @Override // com.kwad.components.p208ad.fullscreen.C7610c, com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
                public final void onVideoPlayStart() {
                    super.onVideoPlayStart();
                    C7659g.this.f25961bZ.m30027h(C7659g.this);
                }
            };
        }
        this.f25962gG.m32786a(fullScreenVideoAdInteractionListener);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void showFullScreenVideoAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (activity != null && !activity.isFinishing()) {
            C10819a.m24739ak("fullscreen", TTLogUtil.TAG_EVENT_SHOW);
            C8032c.m31748h(false, this.mAdTemplate);
            C9828c.m27589by(this.mAdTemplate);
            if (!C10251d.m26556CF() && !isAdEnable()) {
                C10331c.m26248i("KsFullScreenVideoAdControl", "isAdEnable is false");
                C10819a.m24738al("fullscreen", TTLogUtil.TAG_EVENT_SHOW);
                C8032c.m31756b(false, this.mAdTemplate, "cache_not_ready");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            KsFullScreenVideoActivityProxy.launch(activity, this.mAdResultData, ksVideoPlayConfig, this.f25962gG);
            return;
        }
        C10331c.m26250e("KsFullScreenVideoAdControl", "showFullScreenVideoAd error, activity is null or finished");
        C8032c.m31756b(false, this.mAdTemplate, "illegal_activity");
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: a */
    public final void mo30034a(InterfaceC8678b interfaceC8678b) {
        this.f25961bZ.m30029a(interfaceC8678b);
    }

    @Override // com.kwad.sdk.api.KsFullScreenVideoAd
    public final void setBidEcpm(long j, long j2) {
        C9908c.m27292l(this.mAdTemplate, j2);
    }
}
