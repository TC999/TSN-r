package com.bytedance.sdk.openadsdk.core.dislike.c;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f33129c;

    /* renamed from: w  reason: collision with root package name */
    private static xv f33130w;
    private static sr xv;

    public static void c(xv xvVar, sr srVar) {
        if (f33129c) {
            return;
        }
        f33129c = true;
        f33130w = xvVar;
        xv = srVar;
    }

    public static sr w() {
        return xv;
    }

    public static xv c() {
        return f33130w;
    }
}
