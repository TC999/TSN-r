package com.mbridge.msdk.foundation.tools;

import com.beizi.fusion.widget.ScrollClickView;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.tools.m */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class JsonUtils {
    /* renamed from: a */
    public static ArrayList<String> m21842a(JSONArray jSONArray) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(jSONArray.optString(i));
            }
            return arrayList;
        }
        return null;
    }

    /* renamed from: a */
    public static String m21843a(int i, int i2, int i3, int i4, int i5) {
        JSONObject jSONObject = new JSONObject();
        try {
            try {
                jSONObject.put("code", 0);
                jSONObject.put("message", "Sucess");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("rotateAngle", i);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(ScrollClickView.DIR_LEFT, i2);
                jSONObject3.put(ScrollClickView.DIR_RIGHT, i3);
                jSONObject3.put("top", i4);
                jSONObject3.put("bottom", i5);
                jSONObject2.put("cutoutInfo", jSONObject3);
                jSONObject.put("data", jSONObject2);
            } catch (Exception e) {
                SameLogTool.m21733d("JSONUtils", e.getMessage());
            }
        } catch (Throwable th) {
            SameLogTool.m21733d("JSONUtils", th.getMessage());
            try {
                jSONObject.put("code", 1);
                jSONObject.put("message", "Fail");
            } catch (JSONException e2) {
                SameLogTool.m21733d("JSONUtils", e2.getMessage());
            }
        }
        return jSONObject.toString();
    }
}
