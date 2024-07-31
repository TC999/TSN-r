package com.snail.antifake.jni;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PropertiesGet {
    static {
        System.loadLibrary("property_get");
    }

    /* renamed from: a */
    public static String m19666a(String str) {
        return native_get(str);
    }

    /* renamed from: b */
    public static String m19665b(String str, String str2) {
        return native_get(str, str2);
    }

    private static native String native_get(String str);

    private static native String native_get(String str, String str2);
}
