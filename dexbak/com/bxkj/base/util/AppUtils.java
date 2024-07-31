package com.bxkj.base.util;

import android.content.Context;

/* renamed from: com.bxkj.base.util.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AppUtils {
    /* renamed from: a */
    public static int m44134a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
