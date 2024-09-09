package com.bxkj.base.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: URLEncodeUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a0 {
    public static String a(String str) {
        String str2 = "";
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (b(charAt)) {
                String str3 = null;
                try {
                    str3 = URLEncoder.encode(charAt + "", "UTF-8");
                } catch (UnsupportedEncodingException e4) {
                    e4.printStackTrace();
                }
                str2 = str2 + str3;
            } else {
                str2 = str2 + charAt;
            }
        }
        return str2;
    }

    private static boolean b(char c4) {
        return String.valueOf(c4).matches("[\u4e00-\u9fa5]");
    }
}
