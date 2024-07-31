package com.kwad.components.p208ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.C8910a;
import com.kwad.components.core.request.C8915d;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.p208ad.p209a.C7330a;
import com.kwad.components.p208ad.p209a.C7331b;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.p375d.C9829d;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.p434g.InterfaceC10763c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.adbit.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7334c {
    /* renamed from: a */
    private static <T extends C8910a> T m33461a(InterfaceC10763c<T> interfaceC10763c) {
        return interfaceC10763c.get();
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        final C8927a m29584qy = new C8927a.C8928a().m29585e(new ImpInfo(SceneImpl.covert(ksScene))).m29589a(new C8915d()).m29584qy();
        C7330a c7330a = (C7330a) m33461a(new InterfaceC10763c<C7330a>() { // from class: com.kwad.components.ad.adbit.c.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10763c
            /* renamed from: P */
            public C7330a get() {
                return new C7330a(C8927a.this);
            }
        });
        return new C7332a(c7330a.getBody(), c7330a.getHeader()).m33465N();
    }

    /* renamed from: a */
    public static String m33460a(SceneImpl sceneImpl) {
        SceneImpl.covert(sceneImpl);
        final C8927a m29584qy = new C8927a.C8928a().m29585e(new ImpInfo(sceneImpl)).m29589a(new C8915d()).m29584qy();
        C7333b c7333b = (C7333b) m33461a(new InterfaceC10763c<C7333b>() { // from class: com.kwad.components.ad.adbit.c.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.p434g.InterfaceC10763c
            /* renamed from: O */
            public C7333b get() {
                return new C7333b(C8927a.this);
            }
        });
        return new C7332a(c7333b.getBody(), c7333b.getHeader()).m33465N();
    }

    /* renamed from: b */
    public static boolean m33455b(@NonNull final C8927a c8927a) {
        String bidResponseV2 = c8927a.f28803Mv.adScene.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            m33459a(bidResponseV2, c8927a);
            return true;
        }
        C9861c.m27501f(DevelopMangerComponents.class);
        final String bidResponse = c8927a.f28803Mv.adScene.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        GlobalThreadPools.m25601FH().submit(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.adbit.c.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                try {
                    C8927a.this.m29592ax("server_bid_one");
                    C8927a c8927a2 = C8927a.this;
                    C9829d.m27582b(c8927a2.f28803Mv.adScene, c8927a2.m29590qx());
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(C8927a.this.f28803Mv.adScene);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(C7334c.m33457b(adBitResultData));
                    adBitResultData.setAdSource("server_bid_one");
                    if (adBitResultData.isAdResultDataEmpty()) {
                        C8927a.m29593a(C8927a.this, adBitResultData, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = C8927a.this.f28803Mv.adScene.getAdStyle();
                    if (adStyle != 10000 && adStyle != C10487e.m25647dK(adTemplate)) {
                        C8927a c8927a3 = C8927a.this;
                        C10419e c10419e = C10419e.avC;
                        C8927a.m29594a(c8927a3, c10419e.errorCode, c10419e.msg, true);
                        return;
                    }
                    C8927a.m29593a(C8927a.this, adBitResultData, true);
                } catch (Exception e) {
                    C8927a c8927a4 = C8927a.this;
                    C10419e c10419e2 = C10419e.avx;
                    C8927a.m29594a(c8927a4, c10419e2.errorCode, c10419e2.msg, true);
                    C10331c.printStackTraceOnly(e);
                }
            }
        });
        return true;
    }

    /* renamed from: a */
    private static void m33459a(String str, @NonNull C8927a c8927a) {
        try {
            c8927a.m29592ax("server_bid_two");
            C9829d.m27582b(c8927a.f28803Mv.adScene, c8927a.m29590qx());
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(c8927a.f28803Mv.adScene);
            adBitResultData.parseJson(jSONObject);
            List<String> m33464a = m33464a(adBitResultData);
            if (m33464a.isEmpty()) {
                C8927a.m29594a(c8927a, C10419e.avy.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? C10419e.avy.msg : adBitResultData.testErrorMsg, false);
            } else {
                m33458a(m33464a, adBitResultData, c8927a);
            }
        } catch (Exception e) {
            C10419e c10419e = C10419e.avx;
            C8927a.m29594a(c8927a, c10419e.errorCode, c10419e.msg, false);
            C10331c.printStackTraceOnly(e);
        }
    }

    /* renamed from: b */
    public static List<AdTemplate> m33457b(AdBitResultData adBitResultData) {
        AdTemplate m33463a;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j = adBid.creativeId;
                if (j > 0 && (m33463a = m33463a(adBitResultData, j)) != null) {
                    m33463a.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(m33463a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m33458a(final List<String> list, final AdBitResultData adBitResultData, final C8927a c8927a) {
        new AbstractC10436l<C7331b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: Q */
            public C7331b createRequest() {
                return new C7331b(adBitResultData.adxId, list);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            /* renamed from: n */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(C8927a.this.f28803Mv.adScene);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new AbstractC10439o<C7331b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.c.5
            /* renamed from: b */
            private void m33450b(int i, String str) {
                C8927a.m29594a(c8927a, i, str, false);
            }

            /* renamed from: c */
            private void m33449c(@NonNull AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(C7334c.m33462a(AdBitResultData.this, adBitResultData2));
                adBitResultData2.setAdSource("server_bid_two");
                if (adBitResultData2.isAdResultDataEmpty()) {
                    C8927a.m29593a(c8927a, adBitResultData2, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i = c8927a.f28803Mv.adScene.adStyle;
                if (i != 10000 && i != C10487e.m25647dK(adTemplate)) {
                    C8927a c8927a2 = c8927a;
                    C10419e c10419e = C10419e.avC;
                    C8927a.m29594a(c8927a2, c10419e.errorCode, c10419e.msg, false);
                    return;
                }
                C8927a.m29593a(c8927a, adBitResultData2, false);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onError(@NonNull InterfaceC10420f interfaceC10420f, int i, String str) {
                m33450b(i, str);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m33449c((AdBitResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static List<AdTemplate> m33462a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate m33463a;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j = adBid.creativeId;
                if (j > 0 && (m33463a = m33463a(adBitResultData2, j)) != null) {
                    m33463a.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(m33463a);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private static List<String> m33464a(AdBitResultData adBitResultData) {
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                arrayList.add(adBid.materialId);
            }
        }
        return arrayList;
    }

    @Nullable
    /* renamed from: a */
    private static AdTemplate m33463a(AdBitResultData adBitResultData, long j) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j == C10487e.m25631ea(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }
}
