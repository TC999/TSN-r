package com.kwad.components.core.p303m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.p317o.C8766a;
import com.kwad.components.core.request.C8910a;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.network.AbstractC10436l;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.m.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8694a extends AbstractC10436l<C8910a, AdResultData> {

    /* renamed from: Mv */
    private ImpInfo f28363Mv;

    public C8694a(ImpInfo impInfo) {
        this.f28363Mv = impInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.AbstractC10436l
    /* renamed from: k */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        m30008l(adResultData);
    }

    /* renamed from: l */
    private static void m30008l(AdResultData adResultData) {
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            if (C10483a.m25876bd(m25641dQ)) {
                if (C10483a.m25879ba(m25641dQ).size() == 0) {
                    C8766a.m29888qi().m29895f(adTemplate, 21005);
                }
            } else if (C10483a.m25872bh(m25641dQ) && TextUtils.isEmpty(C10483a.m25977K(m25641dQ))) {
                C8766a.m29888qi().m29895f(adTemplate, 21006);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.AbstractC10436l
    @NonNull
    /* renamed from: Z */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.f28363Mv.adScene);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.core.network.AbstractC10402a
    @NonNull
    /* renamed from: mO */
    public C8910a createRequest() {
        return new C8910a(this.f28363Mv);
    }
}
