package com.beizi.ad.internal.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class JsonUtil {
    public static JSONArray getJSONArray(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray.length() > 0) {
                return jSONArray;
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean getJSONBoolean(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public static double getJSONDouble(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return -1.0d;
        }
        try {
            return jSONObject.getDouble(str);
        } catch (JSONException unused) {
            return -1.0d;
        }
    }

    public static int getJSONInt(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return -1;
        }
        try {
            return jSONObject.getInt(str);
        } catch (JSONException unused) {
            return -1;
        }
    }

    public static JSONObject getJSONObject(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return jSONObject.getJSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static JSONObject getJSONObjectFromArray(JSONArray jSONArray, int i4) {
        if (jSONArray == null) {
            return null;
        }
        try {
            return jSONArray.getJSONObject(i4);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String getJSONString(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return "";
        }
        try {
            return jSONObject.getString(str);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static ArrayList<String> getStringArrayList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() > 0) {
                int length = jSONArray.length();
                ArrayList<String> arrayList = new ArrayList<>(length);
                for (int i4 = 0; i4 < length; i4++) {
                    arrayList.add((String) jSONArray.get(i4));
                }
                return arrayList;
            }
        } catch (ClassCastException | JSONException unused) {
        }
        return null;
    }

    public static String getStringFromArray(JSONArray jSONArray, int i4) {
        if (jSONArray == null) {
            return "";
        }
        try {
            return jSONArray.getString(i4);
        } catch (JSONException unused) {
            return "";
        }
    }

    public static HashMap<String, Object> getStringObjectHashMap(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            Iterator<String> keys = jSONObject.keys();
            HashMap<String, Object> hashMap = new HashMap<>();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            return hashMap;
        } catch (JSONException unused) {
            return null;
        }
    }
}
