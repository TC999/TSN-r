package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.adbit.AdBid;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j implements com.kwad.sdk.core.d<AdBid> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdBid adBid, JSONObject jSONObject) {
        a2(adBid, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdBid adBid, JSONObject jSONObject) {
        return b2(adBid, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdBid adBid, JSONObject jSONObject) {
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
    private static JSONObject b2(AdBid adBid, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        long j4 = adBid.creativeId;
        if (j4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creativeId", j4);
        }
        long j5 = adBid.ecpm;
        if (j5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "ecpm", j5);
        }
        int i4 = adBid.bidEcpm;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bidEcpm", i4);
        }
        String str = adBid.winNoticeUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "winNoticeUrl", adBid.winNoticeUrl);
        }
        String str2 = adBid.materialId;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "materialId", adBid.materialId);
        }
        return jSONObject;
    }
}
