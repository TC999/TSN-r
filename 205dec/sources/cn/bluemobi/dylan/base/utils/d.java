package cn.bluemobi.dylan.base.utils;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: DisplayUtil.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {
    public static int a(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int c(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int d(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
