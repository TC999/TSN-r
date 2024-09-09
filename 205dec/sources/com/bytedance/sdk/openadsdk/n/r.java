package com.bytedance.sdk.openadsdk.n;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class r {

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        public String f36250c;

        /* renamed from: w  reason: collision with root package name */
        public Map<String, String> f36251w;
    }

    public static c c(String str) {
        c cVar = new c();
        if (str == null) {
            return cVar;
        }
        String trim = str.trim();
        if (trim.equals("")) {
            return cVar;
        }
        String[] split = trim.split("\\?");
        cVar.f36250c = split[0];
        if (split.length == 1) {
            return cVar;
        }
        String[] split2 = split[1].split("&");
        cVar.f36251w = new HashMap();
        for (String str2 : split2) {
            String[] split3 = str2.split("=");
            if (split3.length >= 2) {
                cVar.f36251w.put(split3[0], split3[1]);
            }
        }
        return cVar;
    }

    public static String w(String str) {
        c c4 = c(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Map<String, String> map = c4.f36251w;
        if (map != null) {
            if (map.containsKey("v")) {
                linkedHashMap.put("v", c4.f36251w.get("v"));
                c4.f36251w.remove("v");
            }
            for (Map.Entry<String, String> entry : c4.f36251w.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return c(c4.f36250c, linkedHashMap);
    }

    private static String c(String str, LinkedHashMap<String, String> linkedHashMap) {
        StringBuilder sb = new StringBuilder();
        if (str == null) {
            return sb.toString();
        }
        sb.append(str);
        boolean z3 = false;
        z3 = (str.contains("?") || str.contains("&")) ? true : true;
        if (linkedHashMap != null && linkedHashMap.size() > 0) {
            for (String str2 : linkedHashMap.keySet()) {
                if (!z3) {
                    sb.append("?");
                    z3 = true;
                } else {
                    sb.append("&");
                }
                sb.append(str2);
                sb.append("=");
                sb.append(linkedHashMap.get(str2));
            }
        }
        return sb.toString();
    }
}
