package com.kwad.sdk.core.b.a;

import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ak implements com.kwad.sdk.core.d<AdProductInfo> {
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo adProductInfo, JSONObject jSONObject) {
        a2(adProductInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        return b2(adProductInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adProductInfo.icon = jSONObject.optString(RewardPlus.ICON);
        if (JSONObject.NULL.toString().equals(adProductInfo.icon)) {
            adProductInfo.icon = "";
        }
        adProductInfo.name = jSONObject.optString("name");
        if (JSONObject.NULL.toString().equals(adProductInfo.name)) {
            adProductInfo.name = "";
        }
        adProductInfo.price = jSONObject.optString(BidResponsed.KEY_PRICE);
        if (JSONObject.NULL.toString().equals(adProductInfo.price)) {
            adProductInfo.price = "";
        }
        adProductInfo.originPrice = jSONObject.optString("originPrice");
        if (JSONObject.NULL.toString().equals(adProductInfo.originPrice)) {
            adProductInfo.originPrice = "";
        }
        adProductInfo.couponList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("couponList");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                CouponInfo couponInfo = new CouponInfo();
                couponInfo.parseJson(optJSONArray.optJSONObject(i4));
                adProductInfo.couponList.add(couponInfo);
            }
        }
        adProductInfo.volume = jSONObject.optString("volume");
        if (JSONObject.NULL.toString().equals(adProductInfo.volume)) {
            adProductInfo.volume = "";
        }
        adProductInfo.rating = jSONObject.optString(CampaignEx.JSON_KEY_STAR);
        if (JSONObject.NULL.toString().equals(adProductInfo.rating)) {
            adProductInfo.rating = "";
        }
        AdProductInfo.SpikeInfo spikeInfo = new AdProductInfo.SpikeInfo();
        adProductInfo.seckillInfo = spikeInfo;
        spikeInfo.parseJson(jSONObject.optJSONObject("seckillInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adProductInfo.icon;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, RewardPlus.ICON, adProductInfo.icon);
        }
        String str2 = adProductInfo.name;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "name", adProductInfo.name);
        }
        String str3 = adProductInfo.price;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, BidResponsed.KEY_PRICE, adProductInfo.price);
        }
        String str4 = adProductInfo.originPrice;
        if (str4 != null && !str4.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "originPrice", adProductInfo.originPrice);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject, "couponList", adProductInfo.couponList);
        String str5 = adProductInfo.volume;
        if (str5 != null && !str5.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "volume", adProductInfo.volume);
        }
        String str6 = adProductInfo.rating;
        if (str6 != null && !str6.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, CampaignEx.JSON_KEY_STAR, adProductInfo.rating);
        }
        com.kwad.sdk.utils.t.a(jSONObject, "seckillInfo", adProductInfo.seckillInfo);
        return jSONObject;
    }
}
