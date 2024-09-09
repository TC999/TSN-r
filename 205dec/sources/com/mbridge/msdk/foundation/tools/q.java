package com.mbridge.msdk.foundation.tools;

import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: PermMappingUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class q {
    public static JSONArray a(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            try {
                jSONArray2.put(p.a(jSONArray.getString(i4)));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return jSONArray2;
    }
}
