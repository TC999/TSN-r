package com.beizi.ad.alipay;

import com.beizi.ad.lance.a.l;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class RedPackageUtil {
    private static final String TAG = "RedPackageUtil";

    public static Map<String, String> convertJsonToMap(String str) throws JSONException {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.getString(next));
        }
        return hashMap;
    }

    public static String convertMapToJson(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    value = "";
                }
                jSONObject.put(key, value);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static Map<String, Object> jsonToMap(JSONObject jSONObject) {
        HashMap hashMap = null;
        try {
            HashMap hashMap2 = new HashMap();
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject.get(next);
                    if (obj instanceof JSONObject) {
                        obj = jsonToMap((JSONObject) obj);
                    }
                    hashMap2.put(next, obj);
                }
                return hashMap2;
            } catch (Exception e4) {
                e = e4;
                hashMap = hashMap2;
                l.c(TAG, "e : " + e);
                return hashMap;
            }
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static Map<String, Object> stringToMap(String str) {
        try {
            return jsonToMap(new JSONObject(str));
        } catch (JSONException e4) {
            l.b(TAG, "e : " + e4);
            return null;
        }
    }
}
