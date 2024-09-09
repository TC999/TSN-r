package com.mbridge.msdk.foundation.tools;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JsonUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class m {
    public static ArrayList<String> a(JSONArray jSONArray) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i4 = 0; i4 < length; i4++) {
                arrayList.add(jSONArray.optString(i4));
            }
            return arrayList;
        }
        return null;
    }

    public static String a(int i4, int i5, int i6, int i7, int i8) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Sucess");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rotateAngle", i4);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("left", i5);
                jSONObject3.put("right", i6);
                jSONObject3.put("top", i7);
                jSONObject3.put("bottom", i8);
                jSONObject2.put("cutoutInfo", jSONObject3);
                jSONObject.put("data", jSONObject2);
            } catch (Exception e4) {
                x.d("JSONUtils", e4.getMessage());
            }
        } catch (Throwable th) {
            x.d("JSONUtils", th.getMessage());
            try {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Fail");
            } catch (JSONException e5) {
                x.d("JSONUtils", e5.getMessage());
            }
        }
        return jSONObject.toString();
    }
}
