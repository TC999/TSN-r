package com.bytedance.sdk.component.adexpress.dynamic.sr;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {
    public static void c(String str, JSONObject jSONObject) {
        JSONObject eu = com.bytedance.sdk.component.adexpress.w.eu(str);
        if (eu == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = eu.optJSONObject("values");
        if (optJSONObject == null) {
            return;
        }
        c(optJSONObject, jSONObject);
    }

    public static String w(String str, String str2) {
        if (com.bytedance.sdk.component.adexpress.sr.c()) {
            if (str.indexOf(46) < 0) {
                str = str + ".png";
            }
            return str2 + "static/images/" + str;
        }
        return c.c(str);
    }

    public static JSONObject c(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject eu = com.bytedance.sdk.component.adexpress.w.eu(str);
        if (eu == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return c(jSONObject2, eu.optJSONObject("themeValues"), jSONObject);
    }

    private static void c(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public static JSONObject c(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String c(String str) {
        JSONObject optJSONObject;
        JSONObject eu = com.bytedance.sdk.component.adexpress.w.eu(str);
        if (eu == null || (optJSONObject = eu.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString("data");
    }

    public static String c(String str, String str2) {
        JSONObject optJSONObject;
        JSONObject eu = com.bytedance.sdk.component.adexpress.w.eu(str);
        if (eu == null || (optJSONObject = eu.optJSONObject("values")) == null) {
            return null;
        }
        return optJSONObject.optString(str2);
    }

    public static JSONObject c(JSONArray jSONArray) {
        JSONObject optJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (optJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return optJSONObject.optJSONObject("values");
    }
}
