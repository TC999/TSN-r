package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

/* renamed from: com.baidu.mobads.sdk.internal.bt */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2635bt {

    /* renamed from: a */
    public static final String f8740a = "PackageUtils";

    /* renamed from: a */
    public static boolean m50723a(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return str.equals(applicationInfo.packageName);
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m50722b(Context context, String str) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                return packageManager.queryIntentActivities(intent, 65536).size() > 0;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }
}
