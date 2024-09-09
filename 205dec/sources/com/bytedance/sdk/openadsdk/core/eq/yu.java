package com.bytedance.sdk.openadsdk.core.eq;

import android.text.TextUtils;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class yu {
    public static Map<String, String> c(String str) {
        String query;
        String[] split;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        URL xv = xv(str);
        if (xv == null) {
            return linkedHashMap;
        }
        try {
            query = xv.getQuery();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (query == null) {
            return linkedHashMap;
        }
        if (query.contains("url=")) {
            int indexOf = query.indexOf("url=");
            linkedHashMap.put("url", URLDecoder.decode(query.substring(indexOf + 4), "UTF-8"));
            query = query.substring(0, indexOf);
        }
        if (query.length() > 0) {
            for (String str2 : query.split("&")) {
                int indexOf2 = str2.indexOf("=");
                if (indexOf2 > 0 && indexOf2 < str2.length() - 1) {
                    String substring = str2.substring(0, indexOf2);
                    int i4 = indexOf2 + 1;
                    String substring2 = str2.substring(i4);
                    if (!"live_short_touch_params".equals(substring) && !"extra_pangle_scheme_params".equals(substring)) {
                        linkedHashMap.put(substring, substring2);
                    }
                    linkedHashMap.put(URLDecoder.decode(str2.substring(0, indexOf2), "UTF-8"), URLDecoder.decode(str2.substring(i4), "UTF-8"));
                }
            }
        }
        return linkedHashMap;
    }

    public static String w(String str) {
        return str.contains("?") ? str.substring(0, str.indexOf("?")) : str;
    }

    private static URL xv(String str) {
        if (str != null && str.length() != 0 && str.contains("://")) {
            try {
                return new URL("http" + str.substring(str.indexOf("://")));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return null;
    }

    public static String c(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str) || map == null || map.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(w(str));
        sb.append("?");
        try {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                String key = next.getKey();
                String value = next.getValue();
                if (it.hasNext()) {
                    if (!"live_short_touch_params".equals(key) && !"extra_pangle_scheme_params".equals(key)) {
                        sb.append(key + "=" + value + "&");
                    }
                    String encode = URLEncoder.encode(next.getKey(), "UTF-8");
                    String encode2 = URLEncoder.encode(next.getValue(), "UTF-8");
                    sb.append(encode + "=" + encode2 + "&");
                } else {
                    if (!"live_short_touch_params".equals(key) && !"extra_pangle_scheme_params".equals(key)) {
                        sb.append(key + "=" + value);
                    }
                    String encode3 = URLEncoder.encode(next.getKey(), "UTF-8");
                    String encode4 = URLEncoder.encode(next.getValue(), "UTF-8");
                    sb.append(encode3 + "=" + encode4);
                }
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }
}
