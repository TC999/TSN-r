package com.qq.e.comm.plugin.p;

import com.bytedance.sdk.openadsdk.TTAdConstant;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e {
    public static boolean a(int i4) {
        return (i4 & 64) > 0;
    }

    public static boolean b(int i4) {
        return (i4 & 65024) > 0;
    }

    public static boolean c(int i4) {
        return (i4 & TTAdConstant.KEY_CLICK_AREA) > 0;
    }

    public static boolean d(int i4) {
        return (i4 & 2147418112) > 0;
    }

    public static boolean e(int i4) {
        return (i4 & 128) > 0;
    }

    public static boolean f(int i4) {
        return (i4 & 16) > 0;
    }

    public static boolean g(int i4) {
        return (i4 & 1048576) > 0;
    }
}
