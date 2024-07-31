package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.PageInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.hh */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10112hh implements InterfaceC10273d<PageInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(PageInfo pageInfo, JSONObject jSONObject) {
        m26864a(pageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(PageInfo pageInfo, JSONObject jSONObject) {
        return m26863b(pageInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26864a(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt("pageType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26863b(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = pageInfo.pageType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "pageType", i);
        }
        return jSONObject;
    }
}
