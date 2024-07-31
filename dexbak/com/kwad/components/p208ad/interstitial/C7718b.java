package com.kwad.components.p208ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.internal.api.C8679c;
import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.components.core.internal.api.InterfaceC8678b;
import com.kwad.components.p208ad.interstitial.p240c.C7724b;
import com.kwad.components.p208ad.interstitial.report.C7802a;
import com.kwad.components.p208ad.interstitial.report.C7806c;
import com.kwad.components.p208ad.interstitial.report.realtime.C7810a;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.commercial.p375d.C9828c;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.p391c.C10232b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p364a.p365a.C9679c;
import com.kwad.sdk.p439j.C10819a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.components.ad.interstitial.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7718b implements InterfaceC8677a, KsInterstitialAd {

    /* renamed from: bZ */
    private C8679c f26111bZ = new C8679c();

    /* renamed from: hU */
    private KsScene f26112hU;

    /* renamed from: hV */
    private C7722c f26113hV;

    /* renamed from: hW */
    private AlertDialogC7725d f26114hW;
    @NonNull
    private final AdResultData mAdResultData;
    @NonNull
    private final AdTemplate mAdTemplate;

    public C7718b(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.f26112hU = ksScene;
        this.mAdResultData = adResultData;
        this.mAdTemplate = C10485c.m25661n(adResultData);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: ag */
    public final boolean mo30033ag() {
        return true;
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getECPM() {
        return C10483a.m25944aR(C10487e.m25641dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getInteractionType() {
        return C10483a.m25945aQ(C10487e.m25641dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final int getMaterialType() {
        return C10483a.m25875be(C10487e.m25641dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap hashMap = new HashMap();
        if (C10251d.m26570BX()) {
            hashMap.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return hashMap;
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final boolean isVideo() {
        return C10483a.m25877bc(C10487e.m25641dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        C9908c.m27351a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(@NonNull KsInterstitialAd.AdInteractionListener adInteractionListener) {
        if (this.f26113hV == null) {
            this.f26113hV = new C7722c() { // from class: com.kwad.components.ad.interstitial.b.1
                @Override // com.kwad.components.p208ad.interstitial.C7722c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public final void onAdShow() {
                    super.onAdShow();
                    C7802a.m32299dM().m32297m(C7718b.this.mAdTemplate);
                    C7718b.this.f26111bZ.m30027h(C7718b.this);
                }

                @Override // com.kwad.components.p208ad.interstitial.C7722c, com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                public final void onPageDismiss() {
                    super.onPageDismiss();
                    C7802a.m32299dM().m32296n(C7718b.this.mAdTemplate);
                    C7718b.this.f26111bZ.m30026i(C7718b.this);
                }
            };
        }
        this.f26113hV.m32567a(adInteractionListener);
        AlertDialogC7725d alertDialogC7725d = this.f26114hW;
        if (alertDialogC7725d != null) {
            alertDialogC7725d.setAdInteractionListener(this.f26113hV);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, @Nullable KsVideoPlayConfig ksVideoPlayConfig) {
        C7806c.m32283dQ().m32281p(this.mAdTemplate);
        if (C10251d.m26592BB() && (activity == null || activity.isFinishing())) {
            C10232b.m26625DD();
            activity = C10232b.getCurrentActivity();
        }
        if (activity != null && !activity.isFinishing()) {
            if (!C10829k.m24699zd().m24700ys()) {
                C7806c m32283dQ = C7806c.m32283dQ();
                AdTemplate adTemplate = this.mAdTemplate;
                C10419e c10419e = C10419e.avF;
                m32283dQ.m32287a(adTemplate, c10419e.errorCode, c10419e.msg);
                C10331c.m26250e("StayAdHelper", "showInterstitialAd please init sdk first");
                return;
            }
            if (ksVideoPlayConfig == null) {
                ksVideoPlayConfig = new KsVideoPlayConfig.Builder().build();
            }
            C10819a.m24739ak(MediationConstant.RIT_TYPE_INTERSTITIAL, TTLogUtil.TAG_EVENT_SHOW);
            C9828c.m27589by(this.mAdTemplate);
            this.mAdTemplate.adShowStartTimeStamp = SystemClock.elapsedRealtime();
            if (ksVideoPlayConfig.isVideoSoundEnable()) {
                this.mAdTemplate.mInitVoiceStatus = 2;
            } else {
                this.mAdTemplate.mInitVoiceStatus = 1;
            }
            C9679c.m28040zM().m28044bj(true);
            if (this.f26114hW == null) {
                try {
                    AlertDialogC7725d alertDialogC7725d = new AlertDialogC7725d(activity, this.mAdResultData, ksVideoPlayConfig, this.f26113hV);
                    this.f26114hW = alertDialogC7725d;
                    alertDialogC7725d.show();
                    C7724b.m32563H(activity);
                } catch (Throwable th) {
                    C7810a.m32265dU();
                    C7810a.m32267a(th.getMessage(), this.mAdTemplate);
                }
                C7806c.m32283dQ().m32280q(this.mAdTemplate);
                return;
            }
            return;
        }
        C10331c.m26250e("StayAdHelper", "showInterstitialAd activity must not be null");
        C7810a.m32265dU();
        C7810a.m32263x(this.mAdTemplate);
        C7806c m32283dQ2 = C7806c.m32283dQ();
        AdTemplate adTemplate2 = this.mAdTemplate;
        C10419e c10419e2 = C10419e.avE;
        m32283dQ2.m32287a(adTemplate2, c10419e2.errorCode, c10419e2.msg);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: a */
    public final void mo30034a(InterfaceC8678b interfaceC8678b) {
        this.f26111bZ.m30029a(interfaceC8678b);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: b */
    public final void mo30032b(InterfaceC8678b interfaceC8678b) {
        this.f26111bZ.m30028b(interfaceC8678b);
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        C9908c.m27292l(adTemplate, j);
    }
}
