package com.qq.e.comm.plugin.i;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class w {
    public static boolean a(Context context) {
        String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("qafl", "hap://app/");
        Intent intent = new Intent("android.intent.action.VIEW");
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        try {
            intent.setData(Uri.parse(b4));
        } catch (Exception unused) {
        }
        return a(context, intent) != null;
    }

    public static ResolveInfo a(Context context, Intent intent) {
        PackageManager packageManager;
        if (context == null || intent == null || (packageManager = context.getPackageManager()) == null) {
            return null;
        }
        return packageManager.resolveActivity(intent, 65536);
    }
}
