package com.bxkj.base.util;

import android.content.Context;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AppUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class b {
    public static int a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }
}
