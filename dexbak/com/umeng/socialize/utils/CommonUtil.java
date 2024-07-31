package com.umeng.socialize.utils;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.List;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class CommonUtil {
    public static boolean checkAndroidManifest(Context context, String str) {
        try {
            context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), str), 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkIntentFilterData(Context context, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setData(Uri.parse(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT + str + ":"));
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 64);
        if (queryIntentActivities.size() > 0) {
            for (ResolveInfo resolveInfo : queryIntentActivities) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && activityInfo.packageName.equals(context.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String checkKeyHash(Context context) {
        return "";
    }

    public static String checkMD5Sign(Context context) {
        return "";
    }

    public static boolean checkMetaData(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                if (applicationInfo.metaData.get(str) != null) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean checkPath(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static boolean checkPermission(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean checkResource(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName()) > 0;
    }

    public static String checkSHA1(Context context) {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0029 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean isSilentMode(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            r4 = 0
            java.lang.String r1 = "com.umeng.commonsdk.UMConfigure"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.ClassNotFoundException -> Lc
            goto L11
        Lc:
            r1 = move-exception
            r1.printStackTrace()
            r1 = r4
        L11:
            if (r1 == 0) goto L43
            java.lang.String r2 = "isSilentMode"
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch: java.lang.NoSuchMethodException -> L22
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r3)     // Catch: java.lang.NoSuchMethodException -> L22
            r2 = 1
            r1.setAccessible(r2)     // Catch: java.lang.NoSuchMethodException -> L20
            goto L27
        L20:
            r2 = move-exception
            goto L24
        L22:
            r2 = move-exception
            r1 = r4
        L24:
            r2.printStackTrace()
        L27:
            if (r1 == 0) goto L43
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalAccessException -> L3e
            java.lang.Object r4 = r1.invoke(r4, r2)     // Catch: java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalAccessException -> L3e
            if (r4 == 0) goto L43
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch: java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalAccessException -> L3e
            boolean r4 = r4.booleanValue()     // Catch: java.lang.reflect.InvocationTargetException -> L39 java.lang.IllegalAccessException -> L3e
            r0 = r4
            goto L43
        L39:
            r4 = move-exception
            r4.printStackTrace()
            goto L43
        L3e:
            r4 = move-exception
            r4.printStackTrace()
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.CommonUtil.isSilentMode(android.content.Context):boolean");
    }
}
