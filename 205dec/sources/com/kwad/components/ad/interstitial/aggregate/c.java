package com.kwad.components.ad.interstitial.aggregate;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private volatile boolean iI;
    private l<com.kwad.components.core.request.a, AdResultData> iJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public final class AnonymousClass1 extends j {
        final /* synthetic */ SceneImpl em;
        final /* synthetic */ b iK;
        final /* synthetic */ long ij;

        AnonymousClass1(SceneImpl sceneImpl, b bVar, long j4) {
            this.em = sceneImpl;
            this.iK = bVar;
            this.ij = j4;
        }

        @Override // com.kwad.components.core.request.k
        public final void a(@NonNull final AdResultData adResultData) {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    final ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = AnonymousClass1.this.em;
                            }
                            arrayList.add(com.kwad.sdk.core.response.b.c.a(adResultData, adTemplate));
                        }
                    }
                    bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                        @Override // com.kwad.sdk.utils.ay
                        public final void doTask() {
                            AnonymousClass1.this.iK.onInterstitialAdLoad(arrayList);
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            c cVar = c.this;
                            c.a(adResultData, anonymousClass1.ij);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.request.k
        public final void onError(final int i4, final String str) {
            bn.runOnUiThread(new ay() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    com.kwad.sdk.core.e.c.e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i4), str));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private static c iQ = new c((byte) 0);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface b {
        void onInterstitialAdLoad(@Nullable List<AdResultData> list);
    }

    /* synthetic */ c(byte b4) {
        this();
    }

    public static c cx() {
        return a.iQ;
    }

    public final void release() {
        l<com.kwad.components.core.request.a, AdResultData> lVar = this.iJ;
        if (lVar != null) {
            lVar.cancel();
        }
    }

    private c() {
        this.iI = false;
    }

    static /* synthetic */ boolean a(c cVar, boolean z3) {
        cVar.iI = false;
        return false;
    }

    public final void a(int i4, int i5, @NonNull SceneImpl sceneImpl, b bVar) {
        if (this.iI) {
            return;
        }
        SceneImpl m96clone = sceneImpl.m96clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m96clone.setAdStyle(16);
        m96clone.setAdNum(i5);
        a(new ImpInfo(m96clone), new AnonymousClass1(sceneImpl, bVar, elapsedRealtime));
    }

    private void a(ImpInfo impInfo, @NonNull final j jVar) {
        com.kwad.components.core.m.a aVar = new com.kwad.components.core.m.a(impInfo);
        this.iJ = aVar;
        aVar.request(new o<com.kwad.components.core.request.a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.aggregate.c.2
            private void c(@NonNull AdResultData adResultData) {
                c.a(c.this, false);
                if (adResultData.isAdResultDataEmpty()) {
                    jVar.onError(e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? e.avy.msg : adResultData.testErrorMsg);
                } else {
                    jVar.a(adResultData);
                }
            }

            private void h(int i4, String str) {
                c.a(c.this, false);
                jVar.onError(i4, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i4, String str) {
                h(i4, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(AdResultData adResultData, long j4) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        com.kwad.components.core.o.a.qi().g(adTemplate, elapsedRealtime - j4);
    }
}
