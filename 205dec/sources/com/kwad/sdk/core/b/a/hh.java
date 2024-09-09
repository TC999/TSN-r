package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.PageInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class hh implements com.kwad.sdk.core.d<PageInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PageInfo pageInfo, JSONObject jSONObject) {
        a2(pageInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        return b2(pageInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt("pageType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i4 = pageInfo.pageType;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "pageType", i4);
        }
        return jSONObject;
    }
}
