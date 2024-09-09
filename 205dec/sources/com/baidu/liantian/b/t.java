package com.baidu.liantian.b;

import android.content.Context;

/* compiled from: VersionUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable unused) {
            e.a();
            return null;
        }
    }
}
