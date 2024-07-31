package com.bxkj.base.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.bxkj.base.util.a0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class URLEncodeUtils {
    /* renamed from: a */
    public static String m44136a(String str) {
        String str2 = "";
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (m44135b(charAt)) {
                String str3 = null;
                try {
                    str3 = URLEncoder.encode(charAt + "", "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                str2 = str2 + str3;
            } else {
                str2 = str2 + charAt;
            }
        }
        return str2;
    }

    /* renamed from: b */
    private static boolean m44135b(char c) {
        return String.valueOf(c).matches("[一-龥]");
    }
}
