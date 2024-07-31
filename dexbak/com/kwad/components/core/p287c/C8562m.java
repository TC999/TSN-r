package com.kwad.components.core.p287c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.components.core.request.C8910a;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.kwad.components.core.c.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8562m implements InterfaceC8547c {

    /* renamed from: com.kwad.components.core.c.m$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    final class C85631 extends C8557j {

        /* renamed from: bB */
        final /* synthetic */ C8927a f28115bB;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C85631(C8927a c8927a, C8927a c8927a2) {
            super(c8927a);
            this.f28115bB = c8927a2;
        }

        @Override // com.kwad.components.core.p287c.C8557j
        /* renamed from: a */
        protected final boolean mo30350a(final C8927a c8927a, final AdResultData adResultData) {
            AdResultData m30355d;
            final SceneImpl adScene = adResultData.getAdScene(c8927a.getPosId());
            final int adNum = adScene.getAdNum();
            if (adResultData.isAdResultDataEmpty()) {
                GlobalThreadPools.m25601FH().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        C85631.this.m30349a(adScene, adResultData, adNum, new InterfaceC8559k() { // from class: com.kwad.components.core.c.m.1.1.1
                            @Override // com.kwad.components.core.p287c.InterfaceC8559k
                            /* renamed from: mN */
                            public final void mo30348mN() {
                                RunnableC85641 runnableC85641 = RunnableC85641.this;
                                C8927a.m29593a(c8927a, adResultData, false);
                            }
                        });
                    }
                });
                return true;
            }
            if (adResultData.isBidding() && (m30355d = C8560l.m30355d(c8927a)) != null && !m30355d.isAdResultDataEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(m30355d.getProceedTemplateList());
                arrayList.addAll(adResultData.getProceedTemplateList());
                List<AdTemplate> m30353l = C8562m.m30353l(arrayList);
                List<AdTemplate> subList = m30353l.subList(0, Math.min(adNum, m30353l.size()));
                if (subList != null && subList.size() > 0) {
                    C8927a.m29593a(c8927a, new AdResultData(adResultData, adScene, subList), true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.kwad.components.core.p287c.C8557j, com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
        /* renamed from: a */
        public final void onError(@NonNull final C8910a c8910a, final int i, final String str) {
            GlobalThreadPools.m25601FH().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    C85631.this.m30349a(c8910a.getScene(), null, c8910a.getAdNum(), new InterfaceC8559k() { // from class: com.kwad.components.core.c.m.1.2.1
                        @Override // com.kwad.components.core.p287c.InterfaceC8559k
                        /* renamed from: mN */
                        public final void mo30348mN() {
                            RunnableC85662 runnableC85662 = RunnableC85662.this;
                            C8927a.m29594a(C85631.this.f28115bB, i, str, false);
                        }
                    });
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        /* renamed from: a */
        public void m30349a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i, InterfaceC8559k interfaceC8559k) {
            AdResultData m30355d = C8560l.m30355d(this.f28115bB);
            if (m30355d == null || m30355d.isAdResultDataEmpty()) {
                if (interfaceC8559k != null) {
                    interfaceC8559k.mo30348mN();
                    return;
                }
                return;
            }
            List<AdTemplate> m30353l = C8562m.m30353l(m30355d.getProceedTemplateList());
            List<AdTemplate> subList = m30353l.subList(0, Math.min(i, m30353l.size()));
            if (subList.size() > 0) {
                if (adResultData == null) {
                    adResultData = new AdResultData(sceneImpl);
                }
                C8927a.m29593a(this.f28115bB, new AdResultData(adResultData, sceneImpl, subList), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.c.m$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8568a implements Comparator<AdTemplate> {
        private C8568a() {
        }

        /* renamed from: a */
        private static int m30347a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int m25627ee = C10487e.m25627ee(adTemplate2) - C10487e.m25627ee(adTemplate);
            if (m25627ee != 0) {
                return m25627ee;
            }
            boolean z = adTemplate.fromCache;
            if (z && adTemplate2.fromCache) {
                return 0;
            }
            return z ? 1 : -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return m30347a(adTemplate, adTemplate2);
        }

        /* synthetic */ C8568a(byte b) {
            this();
        }
    }

    /* renamed from: l */
    public static List<AdTemplate> m30353l(List<AdTemplate> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new C8568a((byte) 0));
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : list) {
            long m25631ea = C10487e.m25631ea(adTemplate);
            if (!hashSet.contains(Long.valueOf(m25631ea))) {
                hashSet.add(Long.valueOf(m25631ea));
                arrayList.add(adTemplate);
            }
        }
        return arrayList;
    }

    @Override // com.kwad.components.core.p287c.InterfaceC8547c
    /* renamed from: c */
    public final void mo30345c(C8927a c8927a) {
        C8569n.m30346a(c8927a, new C85631(c8927a, c8927a));
    }

    @Override // com.kwad.components.core.p287c.InterfaceC8547c
    public final String getName() {
        return "StrategyNetworkFirst";
    }
}
