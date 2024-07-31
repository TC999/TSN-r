package com.kwad.components.core.webview.jshandler;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.C8910a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.network.AbstractC10439o;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.network.InterfaceC10420f;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.utils.C11126t;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.ad */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9046ad implements InterfaceC10625a {

    /* renamed from: WL */
    private final boolean f29097WL = false;

    /* renamed from: Wf */
    private final C10605b f29098Wf;

    /* renamed from: iJ */
    private AbstractC10436l<C8910a, AdResultData> f29099iJ;

    /* renamed from: com.kwad.components.core.webview.jshandler.ad$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9052a implements InterfaceC9914b {
        AdResultData mAdResultData;

        public C9052a(AdResultData adResultData) {
            this.mAdResultData = adResultData;
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject json;
            AdResultData adResultData = this.mAdResultData;
            if (adResultData == null || (json = adResultData.toJson()) == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            for (AdTemplate adTemplate : this.mAdResultData.getAdTemplateList()) {
                if (!TextUtils.isEmpty(adTemplate.mOriginJString)) {
                    try {
                        jSONArray.put(new JSONObject(adTemplate.mOriginJString));
                    } catch (JSONException e) {
                        C10331c.printStackTrace(e);
                        jSONArray.put(adTemplate.toJson());
                    }
                } else {
                    jSONArray.put(adTemplate.toJson());
                }
            }
            C11126t.putValue(json, "impAdInfo", jSONArray);
            return json;
        }
    }

    public C9046ad(C10605b c10605b) {
        this.f29098Wf = c10605b;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getKsAdData";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        AbstractC10436l<C8910a, AdResultData> abstractC10436l = this.f29099iJ;
        if (abstractC10436l != null) {
            abstractC10436l.cancel();
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f29097WL) {
            AdTemplate adTemplate = this.f29098Wf.getAdTemplate();
            ImpInfo impInfo = new ImpInfo(adTemplate.mAdScene);
            SceneImpl sceneImpl = adTemplate.mAdScene;
            if (sceneImpl != null) {
                impInfo.pageScene = sceneImpl.getPageScene();
            }
            impInfo.subPageScene = 106L;
            impInfo.adScene.setAdNum(12);
            impInfo.sdkExtraData = C10487e.m25632dZ(adTemplate);
            m29329a(impInfo, interfaceC10627c);
        } else if (this.f29098Wf.m25325GN()) {
            interfaceC10627c.onError(-1, "native adTemplate is null");
        } else {
            interfaceC10627c.mo25251a(new C9052a(this.f29098Wf.m25322hk()));
        }
    }

    /* renamed from: a */
    private void m29329a(final ImpInfo impInfo, final InterfaceC10627c interfaceC10627c) {
        AbstractC10436l<C8910a, AdResultData> abstractC10436l = this.f29099iJ;
        if (abstractC10436l != null) {
            abstractC10436l.cancel();
        }
        AbstractC10436l<C8910a, AdResultData> abstractC10436l2 = new AbstractC10436l<C8910a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ad.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10436l
            @NonNull
            /* renamed from: Z */
            public AdResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdResultData adResultData = new AdResultData(impInfo.adScene);
                adResultData.parseJson(jSONObject);
                return adResultData;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.AbstractC10402a
            @NonNull
            /* renamed from: mO */
            public C8910a createRequest() {
                return new C8910a(impInfo);
            }
        };
        this.f29099iJ = abstractC10436l2;
        abstractC10436l2.request(new AbstractC10439o<C8910a, AdResultData>() { // from class: com.kwad.components.core.webview.jshandler.ad.2
            /* renamed from: c */
            private void m29324c(@NonNull final AdResultData adResultData) {
                if (adResultData.isAdResultDataEmpty()) {
                    StringBuilder sb = new StringBuilder("onError:");
                    Object[] objArr = new Object[2];
                    objArr[0] = Integer.valueOf(C10419e.avy.errorCode);
                    objArr[1] = TextUtils.isEmpty(adResultData.testErrorMsg) ? C10419e.avy.msg : adResultData.testErrorMsg;
                    sb.append(String.format("code:%s__msg:%s", objArr));
                    C10331c.m26254d("WebCardGetKsAdDataHandler", sb.toString());
                    C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.ad.2.1
                        @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                        public final void doTask() {
                            interfaceC10627c.mo25251a(adResultData);
                        }
                    });
                    return;
                }
                C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.ad.2.2
                    @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                    public final void doTask() {
                        interfaceC10627c.mo25251a(adResultData);
                    }
                });
            }

            /* renamed from: h */
            private void m29323h(int i, String str) {
                C10331c.m26254d("WebCardGetKsAdDataHandler", "requestAggregateAd onError code:" + i + " msg: " + str);
                C9046ad.this.m29327a(interfaceC10627c);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onError(@NonNull InterfaceC10420f interfaceC10420f, int i, String str) {
                m29323h(i, str);
            }

            @Override // com.kwad.sdk.core.network.AbstractC10439o, com.kwad.sdk.core.network.InterfaceC10421g
            public final /* synthetic */ void onSuccess(@NonNull InterfaceC10420f interfaceC10420f, @NonNull BaseResultData baseResultData) {
                m29324c((AdResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m29327a(final InterfaceC10627c interfaceC10627c) {
        C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.ad.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                AdResultData adResultData = new AdResultData();
                adResultData.setAdTemplateList(new ArrayList());
                interfaceC10627c.mo25251a(adResultData);
            }
        });
    }
}
