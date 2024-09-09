package com.kwad.sdk.core.b.a;

import com.kwad.sdk.kgeo.KGeoInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class fu implements com.kwad.sdk.core.d<KGeoInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        a2(kGeoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        return b2(kGeoInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kGeoInfo.latitude = jSONObject.optDouble("latitude");
        kGeoInfo.longitude = jSONObject.optDouble("longitude");
        kGeoInfo.range = jSONObject.optInt("range");
        kGeoInfo.rate = jSONObject.optInt("rate");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d4 = kGeoInfo.latitude;
        if (d4 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "latitude", d4);
        }
        double d5 = kGeoInfo.longitude;
        if (d5 != 0.0d) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "longitude", d5);
        }
        int i4 = kGeoInfo.range;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "range", i4);
        }
        int i5 = kGeoInfo.rate;
        if (i5 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "rate", i5);
        }
        return jSONObject;
    }
}
