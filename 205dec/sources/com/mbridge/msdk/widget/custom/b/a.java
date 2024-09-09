package com.mbridge.msdk.widget.custom.b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: DensityUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class a {
    public static int a(Context context, float f4) {
        return (int) ((f4 * a(context).density) + 0.5f);
    }

    public static int b(Context context, float f4) {
        return (int) ((f4 / a(context).density) + 0.5f);
    }

    public static DisplayMetrics a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static int a(Context context, int i4) {
        return (int) TypedValue.applyDimension(1, i4, context.getResources().getDisplayMetrics());
    }
}
