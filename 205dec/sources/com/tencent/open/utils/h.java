package com.tencent.open.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.tencent.open.log.SLog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f51828a;

    public static String a(Context context, String str, String str2) {
        if (context != null && str2 != null && str != null) {
            if ("com.tencent.mobileqq".equals(str2)) {
                return b(context, str, "com.tencent.mobileqq");
            }
            if ("com.tencent.tim".equals(str2)) {
                return b(context, str, "com.tencent.tim");
            }
        }
        return null;
    }

    private static String b(Context context, String str, String str2) {
        if (f51828a) {
            try {
                Cursor c4 = c(context, str, str2);
                if (c4 == null) {
                    SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion null");
                    return null;
                } else if (c4.getCount() <= 0) {
                    SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion empty");
                    return null;
                } else {
                    c4.moveToFirst();
                    String string = c4.getString(0);
                    c4.close();
                    SLog.i("openSDK_LOG.OpenApiProviderUtils", "AppVersion: " + string);
                    return a(string) ? string : "UNKNOWN";
                }
            } catch (Exception e4) {
                SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion exception: ", e4);
                return null;
            }
        }
        return null;
    }

    private static Cursor c(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return contentResolver.query(Uri.parse("content://" + str2 + ".openapi.provider" + TTPathConst.sSeparator + "query_app_version?appid=" + str + "&pkgName=" + context.getPackageName()), new String[0], null, null, null);
        } catch (Exception e4) {
            SLog.e("openSDK_LOG.OpenApiProviderUtils", "query exception: ", e4);
            return null;
        }
    }

    private static boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length < 3) {
            return false;
        }
        for (String str2 : split) {
            try {
                Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return true;
    }
}
