package com.qq.e.comm.plugin.i0;

import com.qq.e.comm.plugin.util.e1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static String f44235a = "User-Agent";

    /* renamed from: b  reason: collision with root package name */
    private static String f44236b = "GDTMobSDK" + e1.c();

    /* renamed from: c  reason: collision with root package name */
    private static String f44237c = "-[" + System.getProperty("http.agent") + "]";

    public static String a() {
        return f44236b + f44237c;
    }

    public static String b() {
        return f44235a;
    }

    public static String a(String str) {
        return f44236b + str + f44237c;
    }
}
