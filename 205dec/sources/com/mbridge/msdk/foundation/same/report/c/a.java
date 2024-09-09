package com.mbridge.msdk.foundation.same.report.c;

/* compiled from: LogFileController.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f39697a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static a f39698b;

    private a() {
    }

    public static a a() {
        if (f39698b == null) {
            synchronized (a.class) {
                if (f39698b == null) {
                    f39698b = new a();
                }
            }
        }
        return f39698b;
    }
}
