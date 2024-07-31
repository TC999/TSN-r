package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.kh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10193kh implements InterfaceC10273d<AdInfo.UnDownloadConf> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdInfo.UnDownloadConf unDownloadConf, JSONObject jSONObject) {
        m26702a(unDownloadConf, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdInfo.UnDownloadConf unDownloadConf, JSONObject jSONObject) {
        return m26701b(unDownloadConf, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26702a(AdInfo.UnDownloadConf unDownloadConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        AdInfo.UnDownloadRegionConf unDownloadRegionConf = new AdInfo.UnDownloadRegionConf();
        unDownloadConf.unDownloadRegionConf = unDownloadRegionConf;
        unDownloadRegionConf.parseJson(jSONObject.optJSONObject("unDownloadRegionConf"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26701b(AdInfo.UnDownloadConf unDownloadConf, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.m23678a(jSONObject, "unDownloadRegionConf", unDownloadConf.unDownloadRegionConf);
        return jSONObject;
    }
}
