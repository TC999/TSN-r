package com.bytedance.sdk.openadsdk.core.eq;

import com.bytedance.sdk.openadsdk.core.u.gw;
import com.bytedance.sdk.openadsdk.core.u.pr;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class u {
    public static String c(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return "";
        }
        int k4 = k(meVar);
        if (k4 != 1) {
            if (k4 != 2) {
                if (k4 != 3) {
                    return k4 != 4 ? "" : gw.ux(meVar);
                }
                return com.bytedance.sdk.openadsdk.core.u.fp.f(meVar);
            }
            return com.bytedance.sdk.openadsdk.core.u.k.w(meVar);
        }
        return com.bytedance.sdk.openadsdk.core.u.wx.xv(meVar);
    }

    public static int ev(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return -1;
        }
        if (k(meVar) != 3) {
            return com.bytedance.sdk.openadsdk.core.u.wx.s(meVar);
        }
        return com.bytedance.sdk.openadsdk.core.u.fp.p(meVar);
    }

    public static boolean f(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return false;
        }
        int k4 = k(meVar);
        if (k4 != 1) {
            if (k4 != 2) {
                return k4 == 4;
            }
            return com.bytedance.sdk.openadsdk.core.u.k.sr(meVar);
        }
        return com.bytedance.sdk.openadsdk.core.u.wx.fp(meVar);
    }

    public static boolean gd(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        return k(meVar) == 3;
    }

    private static int k(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (com.bytedance.sdk.openadsdk.core.u.k.c(meVar)) {
            return 2;
        }
        if (com.bytedance.sdk.openadsdk.core.u.wx.c(meVar)) {
            return 1;
        }
        if (com.bytedance.sdk.openadsdk.core.u.fp.c(meVar)) {
            return 3;
        }
        return gw.c(meVar) ? 4 : 0;
    }

    public static int p(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.core.u.wx.fz(meVar);
    }

    public static int r(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return 0;
        }
        if (k(meVar) != 3) {
            return com.bytedance.sdk.openadsdk.core.u.wx.ia(meVar);
        }
        return com.bytedance.sdk.openadsdk.core.u.fp.gd(meVar);
    }

    public static boolean sr(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        int k4;
        return (meVar == null || (k4 = k(meVar)) == 0 || k4 == 3) ? false : true;
    }

    public static boolean ux(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null || pr.c(meVar)) {
            return false;
        }
        int k4 = k(meVar);
        if (k4 != 1) {
            if (k4 != 2) {
                if (k4 != 3) {
                    return false;
                }
                return com.bytedance.sdk.openadsdk.core.u.fp.c(meVar);
            }
            return com.bytedance.sdk.openadsdk.core.u.k.xv(meVar);
        }
        return com.bytedance.sdk.openadsdk.core.u.wx.ys(meVar);
    }

    public static String w(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        if (meVar == null) {
            return "";
        }
        int k4 = k(meVar);
        if (k4 != 1) {
            return k4 != 2 ? "" : com.bytedance.sdk.openadsdk.core.u.k.w(meVar);
        }
        return com.bytedance.sdk.openadsdk.core.u.wx.xv(meVar);
    }

    public static boolean xv(com.bytedance.sdk.openadsdk.core.u.me meVar) {
        return (meVar == null || k(meVar) == 0) ? false : true;
    }
}
