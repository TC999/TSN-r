package com.kwad.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.sdk.utils.aj */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11016aj {
    public static String[] requestedPermissions = new String[0];

    @RequiresApi(api = 26)
    /* renamed from: cp */
    public static boolean m24117cp(Context context) {
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable th) {
            C10331c.printStackTraceOnly(th);
            return false;
        }
    }

    @Nullable
    /* renamed from: cq */
    public static String[] m24116cq(Context context) {
        String[] strArr = requestedPermissions;
        if (strArr == null || strArr.length <= 0) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                if (packageInfo != null) {
                    String[] strArr2 = packageInfo.requestedPermissions;
                    requestedPermissions = strArr2;
                    return strArr2;
                }
                return null;
            } catch (Throwable th) {
                C10331c.printStackTraceOnly(th);
                return null;
            }
        }
        return strArr;
    }
}
