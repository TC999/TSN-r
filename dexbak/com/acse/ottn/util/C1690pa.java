package com.acse.ottn.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.util.pa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1690pa {
    /* renamed from: a */
    public static List<Map<String, String>> m55932a(String str) {
        Exception e;
        ArrayList arrayList;
        try {
            JSONArray jSONArray = new JSONArray(str);
            arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    arrayList.add(m55931b(jSONArray.getJSONObject(i).toString()));
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    return arrayList;
                }
            }
        } catch (Exception e3) {
            e = e3;
            arrayList = null;
        }
        return arrayList;
    }

    /* renamed from: b */
    public static Map<String, String> m55931b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, (String) jSONObject.get(next));
            }
            return hashMap;
        } catch (Exception e) {
            e.printStackTrace();
            C1694ra.m55915b("JsonMapUtil", "getShowAdActivityPackageName Exception e =" + e.getMessage());
            return null;
        }
    }
}
