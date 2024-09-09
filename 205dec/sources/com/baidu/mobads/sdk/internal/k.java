package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.api.ArticleInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class k {
    public static JSONArray a(double[] dArr) {
        JSONArray jSONArray = null;
        if (dArr == null) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (double d4 : dArr) {
                try {
                    jSONArray2.put(d4);
                } catch (Exception e4) {
                    e = e4;
                    jSONArray = jSONArray2;
                    bv.a().a(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (Exception e5) {
            e = e5;
        }
    }

    public static JSONArray a(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i4 = 0; i4 < list.size(); i4++) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i5 = 0; i5 < list.get(i4).length; i5++) {
                    jSONArray2.put(list.get(i4)[i5]);
                }
                jSONArray.put(jSONArray2);
            } catch (Exception e4) {
                bv.a().a(e4);
            }
        }
        return jSONArray;
    }

    public static HashMap<String, String> a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
        } catch (Exception unused) {
            bv.a().a("json2HashMap error");
        }
        return hashMap;
    }

    public static JSONObject a(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(hashMap);
        } catch (Exception unused) {
            bv.a().a("hashMap2Json error");
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }

    public static Object a(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.opt(str) : "";
    }

    @TargetApi(8)
    public static Bitmap a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static HashMap<String, String> a(Map<String, String> map) {
        String[] strArr;
        int length;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    HashMap hashMap = new HashMap(map);
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    int i4 = 0;
                    for (String str : ArticleInfo.PREDEFINED_KEYS) {
                        if (hashMap.containsKey(str)) {
                            String str2 = (String) hashMap.remove(str);
                            if (!TextUtils.isEmpty(str2) && (length = str2.length() + i4) < 150) {
                                hashMap2.put(str, str2);
                                i4 = length;
                            }
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        Set<String> keySet = hashMap.keySet();
                        JSONArray jSONArray = new JSONArray();
                        for (String str3 : keySet) {
                            if (!TextUtils.isEmpty(str3)) {
                                String str4 = (String) hashMap.get(str3);
                                if (!TextUtils.isEmpty(str4)) {
                                    JSONObject jSONObject = new JSONObject();
                                    jSONObject.put("k", str3);
                                    jSONObject.put("v", str4);
                                    jSONArray.put(jSONObject);
                                }
                            }
                        }
                        if (jSONArray.length() > 0) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("ext", jSONArray.toString());
                            if (jSONObject2.toString().length() < 3000) {
                                hashMap2.put("ext", jSONObject2.toString());
                            }
                        }
                    }
                    return hashMap2;
                }
            } catch (Throwable unused) {
                return new HashMap<>();
            }
        }
        return new HashMap<>();
    }
}
