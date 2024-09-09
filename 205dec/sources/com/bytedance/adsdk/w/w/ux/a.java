package com.bytedance.adsdk.w.w.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a {
    public static boolean a(char c4) {
        return c4 == ' ';
    }

    public static boolean b(char c4) {
        return '+' == c4 || '-' == c4 || '*' == c4 || '/' == c4 || '%' == c4 || '=' == c4 || '>' == c4 || '<' == c4 || '!' == c4 || '&' == c4 || '|' == c4 || '?' == c4 || ':' == c4;
    }

    public static boolean c(char c4) {
        return (c4 >= 'A' && c4 <= 'Z') || (c4 >= 'a' && c4 <= 'z');
    }

    public static boolean d(char c4) {
        return c4 >= '0' && c4 <= '9';
    }
}
