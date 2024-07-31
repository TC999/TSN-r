package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ct */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9989ct implements InterfaceC10273d<AdMatrixInfo.CycleAggregateInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        m27104a(cycleAggregateInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        return m27103b(cycleAggregateInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27104a(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        cycleAggregateInfo.cutIconUrl = jSONObject.optString("cutIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.cutIconUrl)) {
            cycleAggregateInfo.cutIconUrl = "";
        }
        cycleAggregateInfo.refreshIconUrl = jSONObject.optString("refreshIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.refreshIconUrl)) {
            cycleAggregateInfo.refreshIconUrl = "";
        }
        cycleAggregateInfo.convertIconUrl = jSONObject.optString("convertIconUrl");
        if (JSONObject.NULL.toString().equals(cycleAggregateInfo.convertIconUrl)) {
            cycleAggregateInfo.convertIconUrl = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m27103b(AdMatrixInfo.CycleAggregateInfo cycleAggregateInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = cycleAggregateInfo.cutIconUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "cutIconUrl", cycleAggregateInfo.cutIconUrl);
        }
        String str2 = cycleAggregateInfo.refreshIconUrl;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "refreshIconUrl", cycleAggregateInfo.refreshIconUrl);
        }
        String str3 = cycleAggregateInfo.convertIconUrl;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "convertIconUrl", cycleAggregateInfo.convertIconUrl);
        }
        return jSONObject;
    }
}
