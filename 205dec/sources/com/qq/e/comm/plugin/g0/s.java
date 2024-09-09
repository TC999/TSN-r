package com.qq.e.comm.plugin.g0;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class s {
    public static List<s> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(4);
        JSONArray optJSONArray = jSONObject.optJSONArray("element_structure_content");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                s sVar = new s();
                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i4);
                jSONObject2.optString("content");
                jSONObject2.optString(CampaignEx.JSON_KEY_ICON_URL);
                arrayList.add(sVar);
            }
        }
        return arrayList;
    }

    public static boolean a(e eVar) {
        return (eVar == null || eVar.V() == null || eVar.V().size() <= 0) ? false : true;
    }
}
