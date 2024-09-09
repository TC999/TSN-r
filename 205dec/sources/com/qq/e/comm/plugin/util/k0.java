package com.qq.e.comm.plugin.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k0 {
    public static boolean a(JSONObject jSONObject) {
        return jSONObject == null || jSONObject.length() <= 0;
    }

    public static JSONArray b(JSONArray jSONArray, JSONArray jSONArray2) {
        int length;
        int length2;
        if (jSONArray == null || (length = jSONArray.length()) == 0) {
            return jSONArray2;
        }
        if (jSONArray2 == null || (length2 = jSONArray2.length()) == 0) {
            return jSONArray;
        }
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < length; i4++) {
            hashSet.add(jSONArray.opt(i4));
        }
        for (int i5 = 0; i5 < length2; i5++) {
            hashSet.add(jSONArray2.opt(i5));
        }
        return new JSONArray((Collection) hashSet);
    }

    public static boolean a(JSONArray jSONArray) {
        return jSONArray == null || jSONArray.length() <= 0;
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        return a(jSONObject, jSONObject2, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0063, code lost:
        if (r2.getClass().isInstance(r3) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0065, code lost:
        r5.put(r1, r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static org.json.JSONObject a(org.json.JSONObject r5, org.json.JSONObject r6, boolean r7) throws org.json.JSONException {
        /*
            boolean r0 = a(r5)
            if (r0 == 0) goto L7
            return r6
        L7:
            boolean r0 = a(r6)
            if (r0 != 0) goto L69
            java.util.Iterator r0 = r6.keys()
        L11:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L69
            java.lang.Object r1 = r0.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r2 = r5.opt(r1)
            java.lang.Object r3 = r6.opt(r1)
            if (r2 != 0) goto L2b
            r5.put(r1, r3)
            goto L11
        L2b:
            boolean r4 = r2 instanceof org.json.JSONObject
            if (r4 == 0) goto L3b
            boolean r4 = r3 instanceof org.json.JSONObject
            if (r4 == 0) goto L3b
            org.json.JSONObject r2 = (org.json.JSONObject) r2
            org.json.JSONObject r3 = (org.json.JSONObject) r3
            a(r2, r3, r7)
            goto L11
        L3b:
            boolean r4 = r2 instanceof org.json.JSONArray
            if (r4 == 0) goto L4b
            boolean r4 = r3 instanceof org.json.JSONArray
            if (r4 == 0) goto L4b
            org.json.JSONArray r2 = (org.json.JSONArray) r2
            org.json.JSONArray r3 = (org.json.JSONArray) r3
            a(r2, r3)
            goto L11
        L4b:
            if (r7 == 0) goto L59
            boolean r4 = r3 instanceof java.lang.Number
            if (r4 == 0) goto L59
            boolean r4 = r2 instanceof java.lang.Number
            if (r4 == 0) goto L59
            r5.put(r1, r3)
            goto L11
        L59:
            if (r7 == 0) goto L11
            java.lang.Class r2 = r2.getClass()
            boolean r2 = r2.isInstance(r3)
            if (r2 == 0) goto L11
            r5.put(r1, r3)
            goto L11
        L69:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.k0.a(org.json.JSONObject, org.json.JSONObject, boolean):org.json.JSONObject");
    }

    public static Map<String, Object> b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys != null && keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            if (opt != null) {
                if (opt instanceof JSONObject) {
                    hashMap.put(next, b((JSONObject) opt));
                } else if (opt instanceof JSONArray) {
                    hashMap.put(next, b((JSONArray) opt));
                } else {
                    hashMap.put(next, opt);
                }
            }
        }
        return hashMap;
    }

    public static JSONArray a(JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        if (a(jSONArray)) {
            return jSONArray2;
        }
        if (!a(jSONArray2)) {
            for (int i4 = 0; i4 < jSONArray2.length(); i4++) {
                jSONArray.put(jSONArray2.get(i4));
            }
        }
        return jSONArray;
    }

    public static List<Object> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            Object opt = jSONArray.opt(i4);
            if (opt != null) {
                if (opt instanceof JSONObject) {
                    arrayList.add(b((JSONObject) opt));
                } else if (opt instanceof JSONArray) {
                    arrayList.add(b((JSONArray) opt));
                } else {
                    arrayList.add(opt);
                }
            }
        }
        return arrayList;
    }
}
