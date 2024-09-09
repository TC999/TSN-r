package com.kuaishou.weapon.p0;

import org.json.JSONArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class dj {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38312a = "bGlidmErKw==";

    /* renamed from: b  reason: collision with root package name */
    private static final String f38313b = "WnBvc2VkQnJpZGdlLmphcg==";

    /* renamed from: c  reason: collision with root package name */
    private static final String f38314c = "bGlienBvc2VkX2FydC5zbw==";

    public static Integer a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    String str = new String(c.a("WnBvc2VkQnJpZGdlLmphcg==".getBytes(), 2));
                    byte[] a4 = c.a("bGlienBvc2VkX2FydC5zbw==".getBytes(), 2);
                    return (a4 == null || !a(jSONArray, str, new String(a4))) ? null : 1;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static Integer b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    String str = new String(c.a("bGlidmErKw==".getBytes(), 2));
                    return (str.length() <= 1 || !a(jSONArray, str)) ? null : 1;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    private static boolean a(JSONArray jSONArray, String str, String str2) {
        try {
            if (jSONArray.length() > 0) {
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    String str3 = (String) jSONArray.get(i4);
                    if (str3.contains(str) || str3.contains(str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private static boolean a(JSONArray jSONArray, String str) {
        try {
            if (jSONArray.length() > 0) {
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    if (((String) jSONArray.get(i4)).contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
