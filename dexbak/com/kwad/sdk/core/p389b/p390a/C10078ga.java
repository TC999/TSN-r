package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.utils.C11126t;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ga */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10078ga implements InterfaceC10273d<AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        m26932a(liveReservationPlayEndInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        return m26931b(liveReservationPlayEndInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26932a(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        liveReservationPlayEndInfo.detailBtnTitle = jSONObject.optString("detailBtnTitle", new String("查看详情"));
        liveReservationPlayEndInfo.reservationBtnTitle = jSONObject.optString("reservationBtnTitle", new String("立即预约"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26931b(AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        C11126t.putValue(jSONObject, "detailBtnTitle", liveReservationPlayEndInfo.detailBtnTitle);
        C11126t.putValue(jSONObject, "reservationBtnTitle", liveReservationPlayEndInfo.reservationBtnTitle);
        return jSONObject;
    }
}
