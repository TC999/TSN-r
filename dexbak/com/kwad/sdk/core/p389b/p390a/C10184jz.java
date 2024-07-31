package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.jz */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10184jz implements InterfaceC10273d<SdkConfigData.TemplateConfigMap> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        m26720a(templateConfigMap, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        return m26719b(templateConfigMap, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26720a(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfigMap.couponOpenConfig = templateConfig;
        templateConfig.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        TemplateConfig templateConfig2 = new TemplateConfig();
        templateConfigMap.couponInfoConfig = templateConfig2;
        templateConfig2.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26719b(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.m23678a(jSONObject, "couponOpenConfig", templateConfigMap.couponOpenConfig);
        C11126t.m23678a(jSONObject, "couponInfoConfig", templateConfigMap.couponInfoConfig);
        return jSONObject;
    }
}
