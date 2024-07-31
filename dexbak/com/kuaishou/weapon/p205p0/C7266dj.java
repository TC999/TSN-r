package com.kuaishou.weapon.p205p0;

import org.json.JSONArray;

/* renamed from: com.kuaishou.weapon.p0.dj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7266dj {

    /* renamed from: a */
    private static final String f24916a = "bGlidmErKw==";

    /* renamed from: b */
    private static final String f24917b = "WnBvc2VkQnJpZGdlLmphcg==";

    /* renamed from: c */
    private static final String f24918c = "bGlienBvc2VkX2FydC5zbw==";

    /* renamed from: a */
    public static Integer m33958a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    String str = new String(C7212c.m34109a(f24917b.getBytes(), 2));
                    byte[] m34109a = C7212c.m34109a(f24918c.getBytes(), 2);
                    return (m34109a == null || !m33956a(jSONArray, str, new String(m34109a))) ? null : 1;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: b */
    public static Integer m33955b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    String str = new String(C7212c.m34109a(f24916a.getBytes(), 2));
                    return (str.length() <= 1 || !m33957a(jSONArray, str)) ? null : 1;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    private static boolean m33956a(JSONArray jSONArray, String str, String str2) {
        try {
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    String str3 = (String) jSONArray.get(i);
                    if (str3.contains(str) || str3.contains(str2)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m33957a(JSONArray jSONArray, String str) {
        try {
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (((String) jSONArray.get(i)).contains(str)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
