package com.kwad.components.p208ad.interstitial.aggregate;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p303m.C8694a;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.request.AbstractC8925j;
import com.kwad.components.core.request.C8910a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.components.ad.interstitial.aggregate.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7709c {

    /* renamed from: iI */
    private volatile boolean f26094iI;

    /* renamed from: iJ */
    private AbstractC10436l<C8910a, AdResultData> f26095iJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$1 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public final class C77101 extends AbstractC8925j {

        /* renamed from: em */
        final /* synthetic */ SceneImpl f26096em;

        /* renamed from: iK */
        final /* synthetic */ InterfaceC7716b f26097iK;

        /* renamed from: ij */
        final /* synthetic */ long f26099ij;

        C77101(SceneImpl sceneImpl, InterfaceC7716b interfaceC7716b, long j) {
            this.f26096em = sceneImpl;
            this.f26097iK = interfaceC7716b;
            this.f26099ij = j;
        }

        @Override // com.kwad.components.core.request.InterfaceC8926k
        /* renamed from: a */
        public final void mo29595a(@NonNull final AdResultData adResultData) {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    final ArrayList arrayList = new ArrayList();
                    for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = C77101.this.f26096em;
                            }
                            arrayList.add(C10485c.m25664a(adResultData, adTemplate));
                        }
                    }
                    C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.2.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            C77101.this.f26097iK.onInterstitialAdLoad(arrayList);
                            C77122 c77122 = C77122.this;
                            C77101 c77101 = C77101.this;
                            C7709c c7709c = C7709c.this;
                            C7709c.m32584a(adResultData, c77101.f26099ij);
                        }
                    });
                }
            });
        }

        @Override // com.kwad.components.core.request.InterfaceC8926k
        public final void onError(final int i, final String str) {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.interstitial.aggregate.c.1.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C10331c.m26250e("InterstitialAggregateDataFetcher", "loadAggregationAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7715a {

        /* renamed from: iQ */
        private static C7709c f26109iQ = new C7709c((byte) 0);
    }

    /* renamed from: com.kwad.components.ad.interstitial.aggregate.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7716b {
        void onInterstitialAdLoad(@Nullable List<AdResultData> list);
    }

    /* synthetic */ C7709c(byte b) {
        this();
    }

    /* renamed from: cx */
    public static C7709c m32583cx() {
        return C7715a.f26109iQ;
    }

    public final void release() {
        AbstractC10436l<C8910a, AdResultData> abstractC10436l = this.f26095iJ;
        if (abstractC10436l != null) {
            abstractC10436l.cancel();
        }
    }

    private C7709c() {
        this.f26094iI = false;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m32586a(C7709c c7709c, boolean z) {
        c7709c.f26094iI = false;
        return false;
    }

    /* renamed from: a */
    public final void m32588a(int i, int i2, @NonNull SceneImpl sceneImpl, InterfaceC7716b interfaceC7716b) {
        if (this.f26094iI) {
            return;
        }
        SceneImpl m60139clone = sceneImpl.m60139clone();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m60139clone.setAdStyle(16);
        m60139clone.setAdNum(i2);
        m32585a(new ImpInfo(m60139clone), new C77101(sceneImpl, interfaceC7716b, elapsedRealtime));
    }

    /* renamed from: a */
    private void m32585a(ImpInfo impInfo, @NonNull final AbstractC8925j abstractC8925j) {
        C8694a c8694a = new C8694a(impInfo);
        this.f26095iJ = c8694a;
        c8694a.request(new AbstractC10439o<C8910a, AdResultData>() { // from class: com.kwad.components.ad.interstitial.aggregate.c.2
            /* renamed from: c */
            private void m32582c(@NonNull AdResultData adResultData) {
                C7709c.m32586a(C7709c.this, false);
                if (adResultData.isAdResultDataEmpty()) {
                    abstractC8925j.onError(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg);
                } else {
                    abstractC8925j.mo29595a(adResultData);
                }
            }

            /* renamed from: h */
            private void m32581h(int i, String str) {
                C7709c.m32586a(C7709c.this, false);
                abstractC8925j.onError(i, str);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onError(@NonNull InterfaceC10420f interfaceC10420f, int i, String str) {
                m32581h(i, str);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m32582c((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m32584a(AdResultData adResultData, long j) {
        AdTemplate adTemplate;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (adResultData.getAdTemplateList().size() <= 0 || (adTemplate = adResultData.getAdTemplateList().get(0)) == null) {
            return;
        }
        C8766a.m29888qi().m29892g(adTemplate, elapsedRealtime - j);
    }
}
