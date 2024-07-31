package com.kwad.components.p208ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.p304n.p305a.p307b.InterfaceC8696a;
import com.kwad.components.core.p330s.C8950m;
import com.kwad.components.core.request.C8915d;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.p208ad.KsAdLoadManager;
import com.kwad.components.p208ad.interstitial.p238a.C7687a;
import com.kwad.components.p208ad.interstitial.report.C7806c;
import com.kwad.components.p208ad.interstitial.report.realtime.C7810a;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.p375d.C9829d;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11100i;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.interstitial.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7729e {
    public static void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        if (!C10829k.m24699zd().m24700ys()) {
            C10331c.m26250e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    KsLoadManager.InterstitialAdListener interstitialAdListener2 = KsLoadManager.InterstitialAdListener.this;
                    int i = C10419e.avy.errorCode;
                    interstitialAdListener2.onError(i, C10419e.avy.msg + "sdk not init");
                }
            });
            return;
        }
        final SceneImpl covert = SceneImpl.covert(ksScene);
        C9829d.m27583b(covert);
        boolean m29540a = C8950m.m29533re().m29540a(covert, "loadInterstitialAd");
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        covert.setAdStyle(13);
        C7806c.m32283dQ().m32282i(covert.getPosId());
        KsAdLoadManager.m33469M();
        KsAdLoadManager.m33468a(new C8927a.C8928a().m29585e(new ImpInfo(covert)).m29586aJ(m29540a).m29589a(new C8915d() { // from class: com.kwad.components.ad.interstitial.e.2
            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.AbstractC8914c
            /* renamed from: a */
            public final void mo29608a(@NonNull AdResultData adResultData, boolean z) {
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    onError(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg);
                    C11100i.m23787ap("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.2.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            C10331c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (C9861c.m27501f(InterfaceC8696a.class) != null) {
                        C9861c.m27501f(InterfaceC8696a.class);
                        adTemplateList.get(0);
                        C10487e.m25641dQ(adTemplateList.get(0));
                    }
                } catch (Exception unused) {
                }
                C7806c.m32283dQ().m32286a(adTemplateList.get(0), z);
                C9829d.m27586a(SceneImpl.this, adTemplateList.size());
                SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        if (adTemplate.mAdScene == null) {
                            adTemplate.mAdScene = SceneImpl.this;
                        }
                        String m25977K = C10483a.m25977K(C10487e.m25641dQ(adTemplate));
                        if (!C10484b.m25773cS(adTemplate)) {
                            C7810a.m32265dU();
                            C7810a.m32264w(adTemplate);
                        }
                        AdResultData m25664a = C10485c.m25664a(adResultData, adTemplate);
                        if (!TextUtils.isEmpty(m25977K)) {
                            boolean m32649j = C7687a.m32649j(adTemplate);
                            if (C10251d.m26593BA() || m32649j) {
                                arrayList.add(new C7718b(SceneImpl.this, m25664a));
                            }
                        } else {
                            arrayList.add(new C7718b(SceneImpl.this, m25664a));
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    onError(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg);
                    C7810a.m32265dU();
                    C7810a.m32268a(C10419e.avy);
                    C11100i.m23787ap("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                C7806c.m32283dQ().m32284b(adTemplateList.get(0), z);
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.2.3
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        KsAdLoadManager.m33469M().m33466b(arrayList);
                        C11100i.m23787ap("insertAd_", "onInterstitialAdCacheSuccess");
                        interstitialAdListener.onInterstitialAdLoad(arrayList);
                    }
                });
            }

            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
            public final void onError(final int i, final String str) {
                C7806c.m32283dQ().m32289a(i, str, SceneImpl.this.getPosId());
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.e.2.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C10331c.m26246w("KsAdInterstitialLoadManager", "loadInterstitialAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        interstitialAdListener.onError(i, str);
                    }
                });
            }
        }).m29584qy());
    }
}
