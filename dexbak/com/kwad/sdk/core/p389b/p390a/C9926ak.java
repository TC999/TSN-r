package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.CouponInfo;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ak */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9926ak implements InterfaceC10273d<AdProductInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(AdProductInfo adProductInfo, JSONObject jSONObject) {
        m27222a(adProductInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        return m27221b(adProductInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m27222a(AdProductInfo adProductInfo, JSONObject jSONObject) {
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
            for (int i = 0; i < optJSONArray.length(); i++) {
                CouponInfo couponInfo = new CouponInfo();
                couponInfo.parseJson(optJSONArray.optJSONObject(i));
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
    private static JSONObject m27221b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = adProductInfo.icon;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, RewardPlus.ICON, adProductInfo.icon);
        }
        String str2 = adProductInfo.name;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "name", adProductInfo.name);
        }
        String str3 = adProductInfo.price;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, BidResponsed.KEY_PRICE, adProductInfo.price);
        }
        String str4 = adProductInfo.originPrice;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, "originPrice", adProductInfo.originPrice);
        }
        C11126t.putValue(jSONObject, "couponList", adProductInfo.couponList);
        String str5 = adProductInfo.volume;
        if (str5 != null && !str5.equals("")) {
            C11126t.putValue(jSONObject, "volume", adProductInfo.volume);
        }
        String str6 = adProductInfo.rating;
        if (str6 != null && !str6.equals("")) {
            C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_STAR, adProductInfo.rating);
        }
        C11126t.m23678a(jSONObject, "seckillInfo", adProductInfo.seckillInfo);
        return jSONObject;
    }
}
