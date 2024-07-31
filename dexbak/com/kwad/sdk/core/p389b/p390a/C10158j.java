package com.kwad.sdk.core.p389b.p390a;

import com.kwad.components.p208ad.adbit.AdBid;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10158j implements InterfaceC10273d<AdBid> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdBid adBid, JSONObject jSONObject) {
        m26772a(adBid, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdBid adBid, JSONObject jSONObject) {
        return m26771b(adBid, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26772a(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adBid.creativeId = jSONObject.optLong("creativeId");
        adBid.ecpm = jSONObject.optLong("ecpm");
        adBid.bidEcpm = jSONObject.optInt("bidEcpm");
        adBid.winNoticeUrl = jSONObject.optString("winNoticeUrl");
        if (JSONObject.NULL.toString().equals(adBid.winNoticeUrl)) {
            adBid.winNoticeUrl = "";
        }
        adBid.materialId = jSONObject.optString("materialId");
        if (JSONObject.NULL.toString().equals(adBid.materialId)) {
            adBid.materialId = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26771b(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j = adBid.creativeId;
        if (j != 0) {
            C11126t.putValue(jSONObject, "creativeId", j);
        }
        long j2 = adBid.ecpm;
        if (j2 != 0) {
            C11126t.putValue(jSONObject, "ecpm", j2);
        }
        int i = adBid.bidEcpm;
        if (i != 0) {
            C11126t.putValue(jSONObject, "bidEcpm", i);
        }
        String str = adBid.winNoticeUrl;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "winNoticeUrl", adBid.winNoticeUrl);
        }
        String str2 = adBid.materialId;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "materialId", adBid.materialId);
        }
        return jSONObject;
    }
}
