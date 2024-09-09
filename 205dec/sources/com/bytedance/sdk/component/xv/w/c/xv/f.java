package com.bytedance.sdk.component.xv.w.c.xv;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class f {
    public static boolean c(String str) {
        return str.equals("POST") || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean sr(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean ux(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean w(String str) {
        return str.equals("POST") || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    public static boolean xv(String str) {
        return w(str) || str.equals("OPTIONS") || str.equals("DELETE") || str.equals("PROPFIND") || str.equals("MKCOL") || str.equals("LOCK");
    }
}
