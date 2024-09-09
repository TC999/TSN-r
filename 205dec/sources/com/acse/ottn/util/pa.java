package com.acse.ottn.util;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class pa {
    public static List<Map<String, String>> a(String str) {
        Exception e4;
        ArrayList arrayList;
        try {
            JSONArray jSONArray = new JSONArray(str);
            arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                try {
                    arrayList.add(b(jSONArray.getJSONObject(i4).toString()));
                } catch (Exception e5) {
                    e4 = e5;
                    e4.printStackTrace();
                    return arrayList;
                }
            }
        } catch (Exception e6) {
            e4 = e6;
            arrayList = null;
        }
        return arrayList;
    }

    public static Map<String, String> b(String str) {
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
        } catch (Exception e4) {
            e4.printStackTrace();
            ra.b("JsonMapUtil", "getShowAdActivityPackageName Exception e =" + e4.getMessage());
            return null;
        }
    }
}
