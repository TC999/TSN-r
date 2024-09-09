package com.bytedance.sdk.component.r.w.w;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.r.c.f;
import com.bytedance.sdk.component.r.c.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static long c(int i4, Context context, ux uxVar) {
        return w(i4, context, uxVar);
    }

    public static boolean f(ux uxVar) {
        f w3 = uxVar.w();
        return (w3 == null || TextUtils.isEmpty(w3.f())) ? false : true;
    }

    public static boolean sr(ux uxVar) {
        f w3 = uxVar.w();
        return (w3 == null || TextUtils.isEmpty(w3.ux())) ? false : true;
    }

    public static boolean ux(ux uxVar) {
        f w3 = uxVar.w();
        return (w3 == null || TextUtils.isEmpty(w3.xv())) ? false : true;
    }

    private static long w(int i4, Context context, ux uxVar) {
        if (context == null) {
            return i4;
        }
        Runtime runtime = Runtime.getRuntime();
        long freeMemory = runtime.freeMemory() / 1048576;
        long maxMemory = (runtime.maxMemory() / 1048576) - (runtime.totalMemory() / 1048576);
        if (maxMemory <= 0) {
            if (freeMemory <= 2) {
                return 1L;
            }
            if (freeMemory <= 10) {
                return Math.min(i4, 10);
            }
            return Math.min((freeMemory / 2) * 10, i4);
        }
        long j4 = ((freeMemory + maxMemory) - 10) / 2;
        if (j4 <= 2) {
            return 1L;
        }
        if (j4 <= 10) {
            return Math.min(i4, 10);
        }
        return Math.min(j4 * 10, i4);
    }

    public static boolean xv(ux uxVar) {
        f w3 = uxVar.w();
        return (w3 == null || TextUtils.isEmpty(w3.sr())) ? false : true;
    }

    public static boolean c(ux uxVar) {
        f w3 = uxVar.w();
        return (w3 == null || TextUtils.isEmpty(w3.c())) ? false : true;
    }

    public static boolean w(ux uxVar) {
        f w3 = uxVar.w();
        return (w3 == null || TextUtils.isEmpty(w3.w())) ? false : true;
    }
}
