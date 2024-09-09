package com.bytedance.msdk.adapter.sr;

import android.content.Context;
import android.util.DisplayMetrics;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static float f27213c = -1.0f;
    private static int sr = -1;
    private static int ux = -1;

    /* renamed from: w  reason: collision with root package name */
    private static int f27214w = -1;
    private static float xv = -1.0f;

    static {
        c(com.bytedance.msdk.core.c.getContext());
    }

    public static void c(Context context) {
        Context context2 = context == null ? com.bytedance.msdk.core.c.getContext() : context;
        if (context2 == null) {
            return;
        }
        DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
        f27213c = displayMetrics.density;
        f27214w = displayMetrics.densityDpi;
        xv = displayMetrics.scaledDensity;
        sr = displayMetrics.widthPixels;
        ux = displayMetrics.heightPixels;
        if (context == null || context.getResources() == null || context.getResources().getConfiguration() == null) {
            return;
        }
        if (context.getResources().getConfiguration().orientation == 1) {
            int i4 = sr;
            int i5 = ux;
            if (i4 > i5) {
                sr = i5;
                ux = i4;
                return;
            }
            return;
        }
        int i6 = sr;
        int i7 = ux;
        if (i6 < i7) {
            sr = i7;
            ux = i6;
        }
    }

    public static float sr(Context context) {
        c(context);
        return f27213c;
    }

    public static int ux(Context context) {
        c(context);
        return f27214w;
    }

    public static int w(Context context) {
        c(context);
        return sr;
    }

    public static int xv(Context context) {
        c(context);
        return ux;
    }

    public static int w(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context, float f4) {
        c(context);
        float sr2 = sr(context);
        if (sr2 <= 0.0f) {
            sr2 = 1.0f;
        }
        return (int) ((f4 / sr2) + 0.5f);
    }
}
