package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: ResourceUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class r {
    public static Resources a(Context context) {
        if (context != null) {
            try {
                return context.getResources();
            } catch (Exception e4) {
                x.d("ResourceUtil", "Resource error:" + e4.getMessage());
            }
        }
        return null;
    }

    public static int a(Context context, String str, String str2) {
        String str3;
        try {
            try {
                str3 = com.mbridge.msdk.foundation.controller.a.f().d();
            } catch (Exception unused) {
                x.d("ResourceUtil", "MBSDKContext.getInstance() is null resName:" + str);
            }
            if (ag.a(str3) && context != null) {
                str3 = context.getPackageName();
            }
            if (ag.a(str3) || context == null) {
                return -1;
            }
            return context.getResources().getIdentifier(str, str2, str3);
        } catch (Exception unused2) {
            x.d("ResourceUtil", "Resource not found resName:" + str);
            return -1;
        }
    }
}
