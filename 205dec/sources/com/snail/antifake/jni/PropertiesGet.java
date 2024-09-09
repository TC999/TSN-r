package com.snail.antifake.jni;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class PropertiesGet {
    static {
        System.loadLibrary("property_get");
    }

    public static String a(String str) {
        return native_get(str);
    }

    public static String b(String str, String str2) {
        return native_get(str, str2);
    }

    private static native String native_get(String str);

    private static native String native_get(String str, String str2);
}
