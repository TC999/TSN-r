package com.kwad.components.p208ad.fullscreen;

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
import com.kwad.components.p208ad.reward.monitor.C8031b;
import com.kwad.components.p208ad.reward.monitor.C8032c;
import com.kwad.components.p208ad.reward.monitor.C8033d;
import com.kwad.sdk.api.KsFullScreenVideoAd;
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
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11100i;
import com.kwad.sdk.utils.C11124s;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.fullscreen.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7652f {
    /* renamed from: a */
    public static void m32715a(KsScene ksScene, @NonNull final C7651e c7651e) {
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl covert = SceneImpl.covert(ksScene);
        C9829d.m27583b(covert);
        C8032c.m31771a(false, covert.getPosId());
        boolean m29540a = C8950m.m29533re().m29540a(covert, "loadFullScreenVideoAd");
        covert.setAdStyle(3);
        KsAdLoadManager.m33469M();
        KsAdLoadManager.m33468a(new C8927a.C8928a().m29585e(new ImpInfo(covert)).m29586aJ(m29540a).m29588a(new InterfaceC8924i() { // from class: com.kwad.components.ad.fullscreen.f.2
            @Override // com.kwad.components.core.request.InterfaceC8924i
            @WorkerThread
            /* renamed from: bK */
            public final void mo29596bK() {
                C8032c.m31759b(false, SceneImpl.this.posId);
            }
        }).m29589a(new C8915d() { // from class: com.kwad.components.ad.fullscreen.f.1
            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.AbstractC8914c
            /* renamed from: a */
            public final void mo29608a(@NonNull AdResultData adResultData, boolean z) {
                List list;
                String str;
                C8032c.m31754c(false, SceneImpl.this.posId);
                List<AdTemplate> m32713a = C7652f.m32713a(SceneImpl.this, adResultData.getAdTemplateList());
                String str2 = "onFullScreenVideoAdCacheFailed";
                if (m32713a.isEmpty()) {
                    onError(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg);
                    C11100i.m23787ap("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig obtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, C10251d.m26500yU());
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : m32713a) {
                    arrayList.add(new C7659g(C10485c.m25664a(adResultData, adTemplate)));
                    C8033d.m31745a(adTemplate, z, obtainVideoPreCacheConfig);
                }
                final AdTemplate adTemplate2 = (AdTemplate) m32713a.get(0);
                C8032c.m31769a(false, adTemplate2, m32713a.size(), elapsedRealtime);
                C9829d.m27586a(SceneImpl.this, m32713a.size());
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        try {
                            c7651e.m32717a(adTemplate2, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            C11124s.callMethod(c7651e, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (C9861c.m27501f(InterfaceC8696a.class) != null) {
                        C9861c.m27501f(InterfaceC8696a.class);
                        m32713a.get(0);
                        C10487e.m25641dQ((AdTemplate) m32713a.get(0));
                    }
                } catch (Exception unused) {
                }
                final ArrayList arrayList2 = new ArrayList();
                C8032c.m31752d(false, adTemplate2);
                final boolean m26556CF = C10251d.m26556CF();
                for (final KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    AdTemplate adTemplate3 = ((C7659g) ksFullScreenVideoAd).getAdTemplate();
                    AdInfo m25641dQ = C10487e.m25641dQ(adTemplate3);
                    if (!C10483a.m25876bd(m25641dQ) && !C10483a.m25842cL(m25641dQ)) {
                        list = m32713a;
                        str = str2;
                        C7352b.m33446a(adTemplate3, false, obtainVideoPreCacheConfig, new InterfaceC7351a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                            @Override // com.kwad.components.p208ad.p212c.InterfaceC7351a
                            /* renamed from: V */
                            public final void mo31980V() {
                                C10331c.m26254d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksFullScreenVideoAd);
                                C7652f.m32714a(adTemplate2, c7651e, arrayList2);
                            }

                            @Override // com.kwad.components.p208ad.p212c.InterfaceC7351a
                            /* renamed from: W */
                            public final void mo31979W() {
                                if (m26556CF) {
                                    C7652f.m32714a(adTemplate2, c7651e, arrayList);
                                }
                            }
                        });
                    } else {
                        list = m32713a;
                        str = str2;
                        arrayList2.add(ksFullScreenVideoAd);
                        C7652f.m32714a(adTemplate2, c7651e, arrayList2);
                    }
                    m32713a = list;
                    str2 = str;
                }
                List list2 = m32713a;
                String str3 = str2;
                C10331c.m26254d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
                if (!m26556CF && arrayList2.isEmpty()) {
                    C10419e c10419e = C10419e.avz;
                    onError(c10419e.errorCode, c10419e.msg);
                    C11100i.m23787ap("fullAd_", str3);
                    return;
                }
                C8032c.m31758b(false, (AdTemplate) list2.get(0), list2.size(), elapsedRealtime);
            }

            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
            public final void onError(final int i, final String str) {
                C8032c.m31772a(false, i, str, SceneImpl.this.getPosId());
                if (i != C10419e.avy.errorCode && i != C10419e.avt.errorCode) {
                    C8031b.m31779c(false, i);
                }
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C10331c.m26254d("KsAdFullScreenLoadManager", "onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        c7651e.onError(i, str);
                    }
                });
            }
        }).m29584qy());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m32714a(final AdTemplate adTemplate, final C7651e c7651e, final List<KsFullScreenVideoAd> list) {
        C11064bn.postOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.fullscreen.f.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C11100i.m23787ap("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.m33469M().m33466b(list);
                c7651e.m32716b(adTemplate, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    /* renamed from: a */
    public static List<AdTemplate> m32713a(SceneImpl sceneImpl, List<AdTemplate> list) {
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
                if (1 == C10483a.m25875be(m25641dQ) && !TextUtils.isEmpty(C10483a.m25977K(m25641dQ))) {
                    arrayList.add(adTemplate);
                } else if (C10483a.m25876bd(m25641dQ)) {
                    arrayList.add(adTemplate);
                } else if (C10483a.m25842cL(m25641dQ)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
