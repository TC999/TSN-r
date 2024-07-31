package com.kwad.components.offline.api.core.adlive.model;

import com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse;
import com.kwad.components.offline.api.core.utils.JsonHelper;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KSAdLiveShopInfo extends BaseOfflineCompoJsonParse<KSAdLiveShopInfo> implements Serializable {
    private static final long serialVersionUID = -7139399767269744574L;
    public int changeType;
    public KSAdLiveRoomItemInfo itemInfo;
    public int shopCardType;

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public void parseJson(KSAdLiveShopInfo kSAdLiveShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        kSAdLiveShopInfo.shopCardType = jSONObject.optInt("shopCardType");
        kSAdLiveShopInfo.changeType = jSONObject.optInt("changeType");
        KSAdLiveRoomItemInfo kSAdLiveRoomItemInfo = new KSAdLiveRoomItemInfo();
        kSAdLiveShopInfo.itemInfo = kSAdLiveRoomItemInfo;
        kSAdLiveRoomItemInfo.parseJson(jSONObject.optJSONObject("itemInfo"));
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveShopInfo kSAdLiveShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JsonHelper.putValue(jSONObject, "itemInfo", kSAdLiveShopInfo.itemInfo);
        int i = kSAdLiveShopInfo.shopCardType;
        if (i != 0) {
            C11126t.putValue(jSONObject, "shopCardType", i);
        }
        int i2 = kSAdLiveShopInfo.changeType;
        if (i2 != 0) {
            C11126t.putValue(jSONObject, "changeType", i2);
        }
        return jSONObject;
    }

    @Override // com.kwad.components.offline.api.core.model.BaseOfflineCompoJsonParse
    public JSONObject toJson(KSAdLiveShopInfo kSAdLiveShopInfo) {
        return toJson(kSAdLiveShopInfo, (JSONObject) null);
    }
}
