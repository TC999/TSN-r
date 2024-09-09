package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ga implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        a2(liveReservationPlayEndInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        return b2(liveReservationPlayEndInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveReservationPlayEndInfo.detailBtnTitle = jSONObject.optString("detailBtnTitle", new String("\u67e5\u770b\u8be6\u60c5"));
        liveReservationPlayEndInfo.reservationBtnTitle = jSONObject.optString("reservationBtnTitle", new String("\u7acb\u5373\u9884\u7ea6"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "detailBtnTitle", liveReservationPlayEndInfo.detailBtnTitle);
        com.kwad.sdk.utils.t.putValue(jSONObject, "reservationBtnTitle", liveReservationPlayEndInfo.reservationBtnTitle);
        return jSONObject;
    }
}
