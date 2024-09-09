package xyz.adscope.common.tool.security;

import android.util.Base64;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class Base64Util {
    public static String decode(String str) {
        try {
            return new String(Base64.decode(str, 0));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String encode(String str) {
        try {
            return Base64.encodeToString(str.getBytes(), 2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
