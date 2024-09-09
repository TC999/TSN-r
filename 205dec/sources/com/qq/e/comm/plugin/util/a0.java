package com.qq.e.comm.plugin.util;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a0 {
    public static com.qq.e.comm.plugin.g0.p a(JSONObject jSONObject) {
        com.qq.e.comm.plugin.g0.p pVar = new com.qq.e.comm.plugin.g0.p();
        pVar.f43724b = jSONObject.optString("float_card_title");
        pVar.f43723a = jSONObject.optString("float_card_img");
        if (TextUtils.isEmpty(pVar.f43724b) || TextUtils.isEmpty(pVar.f43723a)) {
            return null;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("float_card_tags");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            pVar.f43725c = new String[optJSONArray.length()];
            int length = optJSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                pVar.f43725c[i4] = optJSONArray.optString(i4);
            }
        }
        pVar.f43726d = jSONObject.optString("float_card_discount");
        pVar.f43727e = jSONObject.optString("float_card_price");
        String optString = jSONObject.optString("float_card_button_txt");
        pVar.f43728f = optString;
        if (TextUtils.isEmpty(optString)) {
            if (e.d(jSONObject)) {
                pVar.f43728f = "\u7acb\u5373\u4e0b\u8f7d";
            } else {
                pVar.f43728f = "\u67e5\u770b\u8be6\u60c5";
            }
        }
        d1.a("DpaUtil", "parseDpaData : " + pVar.toString());
        return pVar;
    }

    public static boolean a(com.qq.e.comm.plugin.g0.e eVar) {
        return (eVar == null || eVar.I() == null || TextUtils.isEmpty(eVar.I().f43724b) || TextUtils.isEmpty(eVar.I().f43723a)) ? false : true;
    }
}
