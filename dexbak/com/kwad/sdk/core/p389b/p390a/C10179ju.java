package com.kwad.sdk.core.p389b.p390a;

import com.kwad.sdk.core.InterfaceC10273d;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.b.a.ju */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10179ju implements InterfaceC10273d<TKAdLiveShopItemInfo> {
    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo26477a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        m26730a(tKAdLiveShopItemInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.InterfaceC10273d
    /* renamed from: b */
    public final /* bridge */ /* synthetic */ JSONObject mo26476b(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        return m26729b(tKAdLiveShopItemInfo, jSONObject);
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void m26730a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKAdLiveShopItemInfo.itemId = jSONObject.optString("itemId");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.itemId)) {
            tKAdLiveShopItemInfo.itemId = "";
        }
        tKAdLiveShopItemInfo.imageUrl = jSONObject.optString("imageUrl");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.imageUrl)) {
            tKAdLiveShopItemInfo.imageUrl = "";
        }
        tKAdLiveShopItemInfo.title = jSONObject.optString("title");
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.title)) {
            tKAdLiveShopItemInfo.title = "";
        }
        tKAdLiveShopItemInfo.price = jSONObject.optString(BidResponsed.KEY_PRICE);
        if (JSONObject.NULL.toString().equals(tKAdLiveShopItemInfo.price)) {
            tKAdLiveShopItemInfo.price = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject m26729b(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = tKAdLiveShopItemInfo.itemId;
        if (str != null && !str.equals("")) {
            C11126t.putValue(jSONObject, "itemId", tKAdLiveShopItemInfo.itemId);
        }
        String str2 = tKAdLiveShopItemInfo.imageUrl;
        if (str2 != null && !str2.equals("")) {
            C11126t.putValue(jSONObject, "imageUrl", tKAdLiveShopItemInfo.imageUrl);
        }
        String str3 = tKAdLiveShopItemInfo.title;
        if (str3 != null && !str3.equals("")) {
            C11126t.putValue(jSONObject, "title", tKAdLiveShopItemInfo.title);
        }
        String str4 = tKAdLiveShopItemInfo.price;
        if (str4 != null && !str4.equals("")) {
            C11126t.putValue(jSONObject, BidResponsed.KEY_PRICE, tKAdLiveShopItemInfo.price);
        }
        return jSONObject;
    }
}
