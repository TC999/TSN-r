package com.tencent.open.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13062h {

    /* renamed from: a */
    private static boolean f37428a;

    /* renamed from: a */
    public static String m15020a(Context context, String str, String str2) {
        if (context != null && str2 != null && str != null) {
            if ("com.tencent.mobileqq".equals(str2)) {
                return m15018b(context, str, "com.tencent.mobileqq");
            }
            if (Constants.PACKAGE_TIM.equals(str2)) {
                return m15018b(context, str, Constants.PACKAGE_TIM);
            }
        }
        return null;
    }

    /* renamed from: b */
    private static String m15018b(Context context, String str, String str2) {
        if (f37428a) {
            try {
                Cursor m15017c = m15017c(context, str, str2);
                if (m15017c == null) {
                    SLog.m15129e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion null");
                    return null;
                } else if (m15017c.getCount() <= 0) {
                    SLog.m15129e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion empty");
                    return null;
                } else {
                    m15017c.moveToFirst();
                    String string = m15017c.getString(0);
                    m15017c.close();
                    SLog.m15127i("openSDK_LOG.OpenApiProviderUtils", "AppVersion: " + string);
                    return m15019a(string) ? string : Constants.APP_VERSION_UNKNOWN;
                }
            } catch (Exception e) {
                SLog.m15128e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion exception: ", e);
                return null;
            }
        }
        return null;
    }

    /* renamed from: c */
    private static Cursor m15017c(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return contentResolver.query(Uri.parse("content://" + str2 + ".openapi.provider/query_app_version?appid=" + str + "&pkgName=" + context.getPackageName()), new String[0], null, null, null);
        } catch (Exception e) {
            SLog.m15128e("openSDK_LOG.OpenApiProviderUtils", "query exception: ", e);
            return null;
        }
    }

    /* renamed from: a */
    private static boolean m15019a(String str) {
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
