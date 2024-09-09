package com.qq.e.comm.plugin.util;

import android.content.Context;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class o0 {
    public static boolean a(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }
}
