package com.baidu.mobads.sdk.internal;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.sdk.api.ArticleInfo;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.baidu.mobads.sdk.internal.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2714k {
    /* renamed from: a */
    public static JSONArray m50361a(double[] dArr) {
        JSONArray jSONArray = null;
        if (dArr == null) {
            return null;
        }
        try {
            JSONArray jSONArray2 = new JSONArray();
            for (double d : dArr) {
                try {
                    jSONArray2.put(d);
                } catch (Exception e) {
                    e = e;
                    jSONArray = jSONArray2;
                    C2634bs.m50744a().m50738a(e);
                    return jSONArray;
                }
            }
            return jSONArray2;
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* renamed from: a */
    public static JSONArray m50366a(List<String[]> list) {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            try {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < list.get(i).length; i2++) {
                    jSONArray2.put(list.get(i)[i2]);
                }
                jSONArray.put(jSONArray2);
            } catch (Exception e) {
                C2634bs.m50744a().m50738a(e);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public static HashMap<String, String> m50364a(JSONObject jSONObject) {
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
            C2634bs.m50744a().m50742a("json2HashMap error");
        }
        return hashMap;
    }

    /* renamed from: a */
    public static JSONObject m50367a(HashMap<String, Object> hashMap) {
        if (hashMap == null || hashMap.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(hashMap);
        } catch (Exception unused) {
            C2634bs.m50744a().m50742a("hashMap2Json error");
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m50362a(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 != null && jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, jSONObject2.opt(next));
            }
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static Object m50363a(JSONObject jSONObject, String str) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.opt(str) : "";
    }

    @TargetApi(8)
    /* renamed from: a */
    public static Bitmap m50368a(String str) {
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static HashMap<String, String> m50365a(Map<String, String> map) {
        String[] strArr;
        int length;
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    HashMap hashMap = new HashMap(map);
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    int i = 0;
                    for (String str : ArticleInfo.PREDEFINED_KEYS) {
                        if (hashMap.containsKey(str)) {
                            String str2 = (String) hashMap.remove(str);
                            if (!TextUtils.isEmpty(str2) && (length = str2.length() + i) < 150) {
                                hashMap2.put(str, str2);
                                i = length;
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
                            jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, jSONArray.toString());
                            if (jSONObject2.toString().length() < 3000) {
                                hashMap2.put(SocializeProtocolConstants.PROTOCOL_KEY_EXTEND, jSONObject2.toString());
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
