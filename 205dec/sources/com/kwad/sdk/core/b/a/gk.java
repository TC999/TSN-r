package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class gk implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        a2(merchantLiveReservationInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        return b2(merchantLiveReservationInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        merchantLiveReservationInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(merchantLiveReservationInfo.title)) {
            merchantLiveReservationInfo.title = "";
        }
        merchantLiveReservationInfo.userHeadUrl = jSONObject.optString("userHeadUrl");
        if (JSONObject.NULL.toString().equals(merchantLiveReservationInfo.userHeadUrl)) {
            merchantLiveReservationInfo.userHeadUrl = "";
        }
        merchantLiveReservationInfo.bookUserCount = jSONObject.optInt("bookUserCount");
        merchantLiveReservationInfo.liveStartTime = jSONObject.optString("liveStartTime");
        if (JSONObject.NULL.toString().equals(merchantLiveReservationInfo.liveStartTime)) {
            merchantLiveReservationInfo.liveStartTime = "";
        }
        merchantLiveReservationInfo.displayWeakCard = jSONObject.optBoolean("displayWeakCard");
        merchantLiveReservationInfo.bookUserUrlList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("bookUserUrlList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                merchantLiveReservationInfo.bookUserUrlList.add((String) optJSONArray.opt(i4));
            }
        }
        merchantLiveReservationInfo.displayBookCount = jSONObject.optBoolean("displayBookCount");
        AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo liveReservationPlayEndInfo = new AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo();
        merchantLiveReservationInfo.playEndCard = liveReservationPlayEndInfo;
        liveReservationPlayEndInfo.parseJson(jSONObject.optJSONObject("playEndCard"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = merchantLiveReservationInfo.title;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "title", merchantLiveReservationInfo.title);
        }
        String str2 = merchantLiveReservationInfo.userHeadUrl;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "userHeadUrl", merchantLiveReservationInfo.userHeadUrl);
        }
        int i4 = merchantLiveReservationInfo.bookUserCount;
        if (i4 != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "bookUserCount", i4);
        }
        String str3 = merchantLiveReservationInfo.liveStartTime;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "liveStartTime", merchantLiveReservationInfo.liveStartTime);
        }
        boolean z3 = merchantLiveReservationInfo.displayWeakCard;
        if (z3) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayWeakCard", z3);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "bookUserUrlList", merchantLiveReservationInfo.bookUserUrlList);
        boolean z4 = merchantLiveReservationInfo.displayBookCount;
        if (z4) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "displayBookCount", z4);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "playEndCard", merchantLiveReservationInfo.playEndCard);
        return jSONObject;
    }
}
