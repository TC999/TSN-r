package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m implements c {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.c.m$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    final class AnonymousClass1 extends j {
        final /* synthetic */ com.kwad.components.core.request.model.a bB;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(com.kwad.components.core.request.model.a aVar, com.kwad.components.core.request.model.a aVar2) {
            super(aVar);
            this.bB = aVar2;
        }

        @Override // com.kwad.components.core.c.j
        protected final boolean a(final com.kwad.components.core.request.model.a aVar, final AdResultData adResultData) {
            AdResultData d4;
            final SceneImpl adScene = adResultData.getAdScene(aVar.getPosId());
            final int adNum = adScene.getAdNum();
            if (adResultData.isAdResultDataEmpty()) {
                GlobalThreadPools.FH().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        AnonymousClass1.this.a(adScene, adResultData, adNum, new k() { // from class: com.kwad.components.core.c.m.1.1.1
                            @Override // com.kwad.components.core.c.k
                            public final void mN() {
                                RunnableC06231 runnableC06231 = RunnableC06231.this;
                                com.kwad.components.core.request.model.a.a(aVar, adResultData, false);
                            }
                        });
                    }
                });
                return true;
            }
            if (adResultData.isBidding() && (d4 = l.d(aVar)) != null && !d4.isAdResultDataEmpty()) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(d4.getProceedTemplateList());
                arrayList.addAll(adResultData.getProceedTemplateList());
                List<AdTemplate> l4 = m.l(arrayList);
                List<AdTemplate> subList = l4.subList(0, Math.min(adNum, l4.size()));
                if (subList != null && subList.size() > 0) {
                    com.kwad.components.core.request.model.a.a(aVar, new AdResultData(adResultData, adScene, subList), true);
                    return true;
                }
            }
            return false;
        }

        @Override // com.kwad.components.core.c.j, com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
        /* renamed from: a */
        public final void onError(@NonNull final com.kwad.components.core.request.a aVar, final int i4, final String str) {
            GlobalThreadPools.FH().submit(new Runnable() { // from class: com.kwad.components.core.c.m.1.2
                @Override // java.lang.Runnable
                public final void run() {
                    AnonymousClass1.this.a(aVar.getScene(), null, aVar.getAdNum(), new k() { // from class: com.kwad.components.core.c.m.1.2.1
                        @Override // com.kwad.components.core.c.k
                        public final void mN() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            com.kwad.components.core.request.model.a.a(AnonymousClass1.this.bB, i4, str, false);
                        }
                    });
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void a(SceneImpl sceneImpl, @Nullable AdResultData adResultData, int i4, k kVar) {
            AdResultData d4 = l.d(this.bB);
            if (d4 == null || d4.isAdResultDataEmpty()) {
                if (kVar != null) {
                    kVar.mN();
                    return;
                }
                return;
            }
            List<AdTemplate> l4 = m.l(d4.getProceedTemplateList());
            List<AdTemplate> subList = l4.subList(0, Math.min(i4, l4.size()));
            if (subList.size() > 0) {
                if (adResultData == null) {
                    adResultData = new AdResultData(sceneImpl);
                }
                com.kwad.components.core.request.model.a.a(this.bB, new AdResultData(adResultData, sceneImpl, subList), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements Comparator<AdTemplate> {
        private a() {
        }

        private static int a(AdTemplate adTemplate, AdTemplate adTemplate2) {
            int ee = com.kwad.sdk.core.response.b.e.ee(adTemplate2) - com.kwad.sdk.core.response.b.e.ee(adTemplate);
            if (ee != 0) {
                return ee;
            }
            boolean z3 = adTemplate.fromCache;
            if (z3 && adTemplate2.fromCache) {
                return 0;
            }
            return z3 ? 1 : -1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(AdTemplate adTemplate, AdTemplate adTemplate2) {
            return a(adTemplate, adTemplate2);
        }

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    public static List<AdTemplate> l(List<AdTemplate> list) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new a((byte) 0));
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (AdTemplate adTemplate : list) {
            long ea = com.kwad.sdk.core.response.b.e.ea(adTemplate);
            if (!hashSet.contains(Long.valueOf(ea))) {
                hashSet.add(Long.valueOf(ea));
                arrayList.add(adTemplate);
            }
        }
        return arrayList;
    }

    @Override // com.kwad.components.core.c.c
    public final void c(com.kwad.components.core.request.model.a aVar) {
        n.a(aVar, new AnonymousClass1(aVar, aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkFirst";
    }
}
