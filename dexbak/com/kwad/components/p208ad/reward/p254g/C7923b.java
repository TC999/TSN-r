package com.kwad.components.p208ad.reward.p254g;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.p304n.p305a.p307b.InterfaceC8696a;
import com.kwad.components.core.p330s.C8950m;
import com.kwad.components.core.request.C8915d;
import com.kwad.components.core.request.InterfaceC8924i;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.p208ad.KsAdLoadManager;
import com.kwad.components.p208ad.p212c.C7352b;
import com.kwad.components.p208ad.p212c.InterfaceC7351a;
import com.kwad.components.p208ad.reward.KsRewardVideoAdControl;
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.monitor.C8033d;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.p375d.C9829d;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.config.C10251d;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11100i;
import com.kwad.sdk.utils.C11124s;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.reward.g.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7923b {
    /* renamed from: a */
    public static void m31985a(KsScene ksScene, @NonNull final C7930c c7930c) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        C9829d.m27583b(covert);
        C8032c.m31771a(true, covert.getPosId());
        boolean m29540a = C8950m.m29533re().m29540a(covert, "loadRewardVideoAd");
        covert.setAdStyle(2);
        KsAdLoadManager.m33469M();
        KsAdLoadManager.m33468a(new C8927a.C8928a().m29585e(new ImpInfo(covert)).m29586aJ(m29540a).m29588a(new InterfaceC8924i() { // from class: com.kwad.components.ad.reward.g.b.2
            @Override // com.kwad.components.core.request.InterfaceC8924i
            @WorkerThread
            /* renamed from: bK */
            public final void mo29596bK() {
                C8032c.m31759b(true, SceneImpl.this.posId);
            }
        }).m29589a(new C8915d() { // from class: com.kwad.components.ad.reward.g.b.1
            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.AbstractC8914c
            /* renamed from: a */
            public final void mo29608a(@NonNull AdResultData adResultData, boolean z) {
                List list;
                ArrayList arrayList;
                C8032c.m31754c(true, SceneImpl.this.posId);
                List m31983a = C7923b.m31983a(SceneImpl.this, adResultData.getProceedTemplateList());
                if (m31983a.isEmpty()) {
                    onError(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg);
                    C11100i.m23787ap("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, C10251d.m26500yU());
                final ArrayList<KsRewardVideoAd> arrayList2 = new ArrayList();
                final AdTemplate adTemplate = (AdTemplate) m31983a.get(0);
                arrayList2.add(new KsRewardVideoAdControl(adResultData));
                C8033d.m31745a(adTemplate, z, obtainVideoPreCacheConfig);
                C8032c.m31769a(true, (AdTemplate) m31983a.get(0), m31983a.size(), elapsedRealtime);
                C9829d.m27586a(SceneImpl.this, m31983a.size());
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.g.b.1.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        try {
                            KsAdLoadManager.m33469M().m33466b(arrayList2);
                            c7930c.m31978c(adTemplate, arrayList2);
                        } catch (Throwable unused) {
                        }
                        try {
                            C11124s.callMethod(c7930c, "onRequestResult", Integer.valueOf(arrayList2.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (C9861c.m27501f(InterfaceC8696a.class) != null) {
                        C9861c.m27501f(InterfaceC8696a.class);
                        m31983a.get(0);
                        C10487e.m25641dQ((AdTemplate) m31983a.get(0));
                    }
                } catch (Exception unused) {
                }
                ArrayList arrayList3 = new ArrayList();
                C8032c.m31752d(true, adTemplate);
                final boolean m26556CF = C10251d.m26556CF();
                boolean z2 = false;
                for (final KsRewardVideoAd ksRewardVideoAd : arrayList2) {
                    AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd).getAdTemplate();
                    AdInfo m25641dQ = C10487e.m25641dQ(adTemplate2);
                    if (adTemplate2.isNativeRewardPreview || C10483a.m25842cL(m25641dQ)) {
                        list = m31983a;
                        arrayList = arrayList3;
                    } else if (C10483a.m25876bd(m25641dQ)) {
                        arrayList = arrayList3;
                        list = m31983a;
                    } else {
                        final ArrayList arrayList4 = arrayList3;
                        C7352b.m33446a(adTemplate2, true, obtainVideoPreCacheConfig, new InterfaceC7351a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                            @Override // com.kwad.components.p208ad.p212c.InterfaceC7351a
                            /* renamed from: V */
                            public final void mo31980V() {
                                C10331c.m26254d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList4.add(ksRewardVideoAd);
                                C7923b.m31984a(adTemplate, c7930c, arrayList4);
                            }

                            @Override // com.kwad.components.p208ad.p212c.InterfaceC7351a
                            /* renamed from: W */
                            public final void mo31979W() {
                                if (m26556CF) {
                                    C7923b.m31984a(adTemplate, c7930c, arrayList2);
                                }
                            }
                        });
                        m31983a = m31983a;
                        arrayList3 = arrayList3;
                    }
                    arrayList.add(ksRewardVideoAd);
                    C7923b.m31984a(adTemplate, c7930c, arrayList);
                    arrayList3 = arrayList;
                    m31983a = list;
                    z2 = true;
                }
                ArrayList arrayList5 = arrayList3;
                List list2 = m31983a;
                C10331c.m26254d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
                if (!m26556CF && !z2 && arrayList5.isEmpty()) {
                    C10419e c10419e = C10419e.avz;
                    onError(c10419e.errorCode, c10419e.msg);
                    C11100i.m23787ap("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                C8032c.m31758b(true, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
            }

            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
            public final void onError(final int i, final String str) {
                C8032c.m31772a(true, i, str, SceneImpl.this.getPosId());
                if (i != C10419e.avy.errorCode && i != C10419e.avt.errorCode) {
                    C8031b.m31779c(true, i);
                }
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.g.b.1.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C10331c.m26254d("KsAdRewardLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        c7930c.onError(i, str);
                    }
                });
            }
        }).m29584qy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m31984a(final AdTemplate adTemplate, final C7930c c7930c, final List<KsRewardVideoAd> list) {
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.reward.g.b.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C11100i.m23787ap("rewardAd_", "onRewardVideoAdCacheSuccess");
                C7930c.this.m31977d(adTemplate, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: a */
    public static List<AdTemplate> m31983a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null) {
                    adTemplate.mAdScene = sceneImpl;
                }
                AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
                int m25875be = C10483a.m25875be(m25641dQ);
                if (adTemplate.isNativeRewardPreview) {
                    arrayList.add(adTemplate);
                } else if (C10483a.m25842cL(m25641dQ)) {
                    arrayList.add(adTemplate);
                } else if (1 == m25875be && !TextUtils.isEmpty(C10483a.m25977K(m25641dQ))) {
                    arrayList.add(adTemplate);
                } else if (C10483a.m25876bd(m25641dQ)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
