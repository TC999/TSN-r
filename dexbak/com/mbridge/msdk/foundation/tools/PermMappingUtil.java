package com.mbridge.msdk.foundation.tools;

import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.mbridge.msdk.foundation.tools.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class PermMappingUtil {
    /* renamed from: a */
    public static JSONArray m21816a(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                jSONArray2.put(MappingFile.m21817a(jSONArray.getString(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONArray2;
    }
}
