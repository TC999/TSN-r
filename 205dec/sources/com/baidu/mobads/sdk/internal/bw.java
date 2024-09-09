package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bw {

    /* renamed from: a  reason: collision with root package name */
    public static final String f12560a = "PackageUtils";

    public static boolean a(Context context, String str) {
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

    public static boolean b(Context context, String str) {
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
