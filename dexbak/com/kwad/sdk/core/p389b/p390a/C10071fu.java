package com.kwad.sdk.core.p389b.p390a;

import com.github.mikephil.charting.utils.Utils;
import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.kgeo.KGeoInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.fu */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10071fu implements InterfaceC10273d<KGeoInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        m26946a(kGeoInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        return m26945b(kGeoInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26946a(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kGeoInfo.latitude = jSONObject.optDouble("latitude");
        kGeoInfo.longitude = jSONObject.optDouble("longitude");
        kGeoInfo.range = jSONObject.optInt("range");
        kGeoInfo.rate = jSONObject.optInt("rate");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26945b(KGeoInfo kGeoInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        double d = kGeoInfo.latitude;
        if (d != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "latitude", d);
        }
        double d2 = kGeoInfo.longitude;
        if (d2 != Utils.DOUBLE_EPSILON) {
            C11126t.putValue(jSONObject, "longitude", d2);
        }
        int i = kGeoInfo.range;
        if (i != 0) {
            C11126t.putValue(jSONObject, "range", i);
        }
        int i2 = kGeoInfo.rate;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "rate", i2);
        }
        return jSONObject;
    }
}
