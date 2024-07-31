package com.kwad.components.p208ad.p221f;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clj.fastble.BleManager;
import com.kwad.components.core.p304n.p305a.p307b.InterfaceC8696a;
import com.kwad.components.core.p330s.C8950m;
import com.kwad.components.core.request.C8915d;
import com.kwad.components.core.request.model.C8927a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.p208ad.KsAdLoadManager;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.p375d.C9829d;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.ad.f.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7451c {
    public static void loadNativeAd(KsScene ksScene, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        final SceneImpl covert = SceneImpl.covert(ksScene);
        C9829d.m27583b(covert);
        boolean m29540a = C8950m.m29533re().m29540a(covert, "loadNativeAd");
        covert.setAdStyle(BleManager.f22896l);
        KsAdLoadManager.m33469M();
        KsAdLoadManager.m33468a(new C8927a.C8928a().m29585e(new ImpInfo(covert)).m29586aJ(m29540a).m29589a(new C8915d() { // from class: com.kwad.components.ad.f.c.1
            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
            /* renamed from: a */
            public final void mo29595a(@NonNull AdResultData adResultData) {
                final ArrayList arrayList = new ArrayList();
                List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                C9829d.m27586a(covert, adTemplateList.size());
                for (AdTemplate adTemplate : adTemplateList) {
                    if (adTemplate != null) {
                        adTemplate.mAdScene = covert;
                        arrayList.add(new DialogInterface$OnDismissListenerC7465d(adTemplate));
                    }
                }
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.f.c.1.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        KsAdLoadManager.m33469M().m33466b(arrayList);
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
                try {
                    for (AdTemplate adTemplate2 : adResultData.getAdTemplateList()) {
                        if (adTemplate2 != null) {
                            C10487e.m25641dQ(adTemplate2);
                            try {
                                if (C9861c.m27501f(InterfaceC8696a.class) != null) {
                                    C9861c.m27501f(InterfaceC8696a.class);
                                }
                            } catch (Exception unused) {
                            }
                        }
                    }
                } catch (Exception unused2) {
                }
            }

            @Override // com.kwad.components.core.request.C8915d, com.kwad.components.core.request.InterfaceC8926k
            public final void onError(final int i, final String str) {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.f.c.1.1
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C10331c.m26254d("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        KsLoadManager.NativeAdListener.this.onError(i, str);
                    }
                });
            }
        }).m29584qy());
    }

    public static void loadNativeAd(String str, @NonNull final KsLoadManager.NativeAdListener nativeAdListener) {
        if (C8950m.m29533re().m29540a((SceneImpl) null, "loadNativeAdByJson") && C8950m.m29533re().m29532rf() == 1) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.f.c.2
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    C10331c.m26250e("KsAdNativeLoadManager", "method parseJson params jsonResult is empty");
                    KsLoadManager.NativeAdListener nativeAdListener2 = KsLoadManager.NativeAdListener.this;
                    C10419e c10419e = C10419e.avy;
                    nativeAdListener2.onError(c10419e.errorCode, c10419e.msg);
                }
            });
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            final AdResultData adResultData = new AdResultData();
            adResultData.parseJson(jSONObject);
            if (adResultData.result != 1) {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.f.c.3
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        C10331c.m26250e("KsAdNativeLoadManager", "loadNativeAd onError:" + String.format("%s__%s", Integer.valueOf(AdResultData.this.result), AdResultData.this.errorMsg));
                        KsLoadManager.NativeAdListener nativeAdListener2 = nativeAdListener;
                        AdResultData adResultData2 = AdResultData.this;
                        nativeAdListener2.onError(adResultData2.result, adResultData2.errorMsg);
                    }
                });
            } else if (adResultData.isAdResultDataEmpty()) {
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.f.c.4
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        KsLoadManager.NativeAdListener.this.onError(C10419e.avy.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg);
                    }
                });
            } else {
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        arrayList.add(new DialogInterface$OnDismissListenerC7465d(adTemplate));
                    }
                }
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.ad.f.c.5
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        KsLoadManager.NativeAdListener.this.onNativeAdLoad(arrayList);
                    }
                });
            }
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
            C10419e c10419e = C10419e.avx;
            nativeAdListener.onError(c10419e.errorCode, c10419e.msg);
        }
    }
}
