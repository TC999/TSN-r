package com.mbridge.msdk.widget.custom.p517b;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.mbridge.msdk.widget.custom.b.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DensityUtil {
    /* renamed from: a */
    public static int m20579a(Context context, float f) {
        return (int) ((f * m20580a(context).density) + 0.5f);
    }

    /* renamed from: b */
    public static int m20577b(Context context, float f) {
        return (int) ((f / m20580a(context).density) + 0.5f);
    }

    /* renamed from: a */
    public static DisplayMetrics m20580a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return displayMetrics;
    }

    /* renamed from: a */
    public static int m20578a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }
}
