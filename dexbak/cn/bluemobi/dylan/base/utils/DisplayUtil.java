package cn.bluemobi.dylan.base.utils;

import android.content.Context;

/* renamed from: cn.bluemobi.dylan.base.utils.d */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class DisplayUtil {
    /* renamed from: a */
    public static int m57760a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static int m57759b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: c */
    public static int m57758c(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    /* renamed from: d */
    public static int m57757d(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
