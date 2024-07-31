package com.kwad.components.p208ad.draw;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.components.core.internal.api.C8679c;
import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.components.core.internal.api.InterfaceC8678b;
import com.kwad.components.core.p288d.C8571a;
import com.kwad.components.p208ad.p236h.C7668b;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.api.core.AbstractKsDrawAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.adlog.C9908c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.p403h.AbstractC10384b;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.p439j.C10819a;
import com.kwad.sdk.p445n.C10887l;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.kwad.components.ad.draw.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7396c extends AbstractKsDrawAd implements InterfaceC8677a {
    @Nullable

    /* renamed from: bN */
    private KsDrawAd.AdInteractionListener f25356bN;

    /* renamed from: bY */
    private C7359b f25358bY;
    @NonNull
    private AdTemplate mAdTemplate;

    /* renamed from: bZ */
    private C8679c f25359bZ = new C8679c();

    /* renamed from: bT */
    private final AbstractC10384b f25357bT = new AbstractC10384b() { // from class: com.kwad.components.ad.draw.c.1
        @Override // com.kwad.sdk.core.p403h.AbstractC10384b
        /* renamed from: ah */
        public final void mo26184ah() {
            C7396c.this.f25359bZ.m30027h(C7396c.this);
        }

        @Override // com.kwad.sdk.core.p403h.AbstractC10384b
        /* renamed from: ai */
        public final void mo26183ai() {
            C7396c.this.f25359bZ.m30026i(C7396c.this);
        }
    };

    /* renamed from: ca */
    private final KsDrawAd.AdInteractionListener f25360ca = new KsDrawAd.AdInteractionListener() { // from class: com.kwad.components.ad.draw.c.2
        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdClicked() {
            if (C7396c.this.f25356bN != null) {
                C7396c.this.f25356bN.onAdClicked();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onAdShow() {
            if (C7396c.this.f25356bN != null) {
                C7396c.this.f25356bN.onAdShow();
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayEnd() {
            if (C7396c.this.f25356bN != null) {
                try {
                    C7396c.this.f25356bN.onVideoPlayEnd();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayError() {
            if (C7396c.this.f25356bN != null) {
                try {
                    C7396c.this.f25356bN.onVideoPlayError();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayPause() {
            if (C7396c.this.f25356bN != null) {
                try {
                    C7396c.this.f25356bN.onVideoPlayPause();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayResume() {
            if (C7396c.this.f25356bN != null) {
                try {
                    C7396c.this.f25356bN.onVideoPlayResume();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }

        @Override // com.kwad.sdk.api.KsDrawAd.AdInteractionListener
        public final void onVideoPlayStart() {
            if (C7396c.this.f25356bN != null) {
                try {
                    C7396c.this.f25356bN.onVideoPlayStart();
                } catch (Throwable th) {
                    C10331c.printStackTraceOnly(th);
                }
            }
        }
    };

    public C7396c(@NonNull AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        KSImageLoader.preloadImage(C10483a.m25862br(C10487e.m25641dQ(adTemplate)).getUrl(), this.mAdTemplate);
        C7668b.m32688eI().m32692a(this);
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

    @Override // com.kwad.sdk.api.core.AbstractKsDrawAd
    @Nullable
    public final View getDrawView2(Context context) {
        if (context == null || !C10829k.m24699zd().m24700ys()) {
            return null;
        }
        try {
            context = C10887l.wrapContextIfNeed(context);
            C10819a.m24739ak(MediationConstant.RIT_TYPE_DRAW, TTLogUtil.TAG_EVENT_SHOW);
            if (this.f25358bY == null) {
                C7359b c7359b = new C7359b(context);
                this.f25358bY = c7359b;
                c7359b.setPageExitListener(this.f25357bT);
                this.f25358bY.setAdInteractionListener(this.f25356bN);
                this.f25358bY.m33439a(this.mAdTemplate);
            } else {
                C10331c.m26248i("KSDrawAdControl", "mDrawVideoView is not null");
            }
            C10819a.m24738al(MediationConstant.RIT_TYPE_DRAW, TTLogUtil.TAG_EVENT_SHOW);
        } catch (Throwable th) {
            if (C10829k.m24699zd().m24703yp()) {
                C8571a.reportSdkCaughtException(new RuntimeException("context:" + context.getClass().getName() + "--classloader:" + context.getClass().getClassLoader()));
            } else {
                throw th;
            }
        }
        return this.f25358bY;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getECPM() {
        return C10483a.m25944aR(C10487e.m25641dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final int getInteractionType() {
        return C10483a.m25945aQ(C10487e.m25641dQ(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsDrawAd
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

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        C9908c.m27351a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.f25356bN = adInteractionListener;
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: a */
    public final void mo30034a(InterfaceC8678b interfaceC8678b) {
        this.f25359bZ.m30029a(interfaceC8678b);
    }

    @Override // com.kwad.components.core.internal.api.InterfaceC8677a
    /* renamed from: b */
    public final void mo30032b(InterfaceC8678b interfaceC8678b) {
        this.f25359bZ.m30028b(interfaceC8678b);
    }

    @Override // com.kwad.sdk.api.KsDrawAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        C9908c.m27292l(adTemplate, j2);
    }
}
