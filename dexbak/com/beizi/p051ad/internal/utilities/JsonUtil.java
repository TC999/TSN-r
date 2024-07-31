package com.beizi.p051ad.internal.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.beizi.ad.internal.utilities.JsonUtil */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    public static JSONObject getJSONObjectFromArray(JSONArray jSONArray, int i) {
        if (jSONArray == null) {
            return null;
        }
        try {
            return jSONArray.getJSONObject(i);
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
                for (int i = 0; i < length; i++) {
                    arrayList.add((String) jSONArray.get(i));
                }
                return arrayList;
            }
        } catch (ClassCastException | JSONException unused) {
        }
        return null;
    }

    public static String getStringFromArray(JSONArray jSONArray, int i) {
        if (jSONArray == null) {
            return "";
        }
        try {
            return jSONArray.getString(i);
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
