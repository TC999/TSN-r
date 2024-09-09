package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f1 {
    public static int a(Context context, int i4) {
        return (int) TypedValue.applyDimension(1, i4, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int b(Context context, int i4) {
        return (int) ((i4 / context.getApplicationContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int b(Context context) {
        try {
            return (context.getApplicationContext().getResources().getConfiguration().screenLayout & 15) >= 3 ? 2 : 1;
        } catch (Exception e4) {
            d1.a("Get device type encounter exception: " + e4.getMessage(), new Object[0]);
            return 0;
        }
    }

    public static float a(Context context, float f4) {
        return TypedValue.applyDimension(1, f4, context.getApplicationContext().getResources().getDisplayMetrics());
    }

    public static int a(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }
}
