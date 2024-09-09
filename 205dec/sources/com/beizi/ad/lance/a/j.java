package com.beizi.ad.lance.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: JumpTool.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class j {
    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return a(context, a(str));
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static Intent a(String str) {
        return a(str, (String) null);
    }

    public static Intent a(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (!TextUtils.isEmpty(str2)) {
            intent.setPackage(str2);
        }
        intent.setFlags(268435456);
        return intent;
    }

    public static boolean a(Context context, Intent intent) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }
}
