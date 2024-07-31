package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;
import com.mbridge.msdk.foundation.controller.MBSDKContext;

/* renamed from: com.mbridge.msdk.foundation.tools.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ResourceUtil {
    /* renamed from: a */
    public static Resources m21815a(Context context) {
        if (context != null) {
            try {
                return context.getResources();
            } catch (Exception e) {
                SameLogTool.m21733d("ResourceUtil", "Resource error:" + e.getMessage());
            }
        }
        return null;
    }

    /* renamed from: a */
    public static int m21814a(Context context, String str, String str2) {
        String str3;
        try {
            try {
                str3 = MBSDKContext.m22865f().m22869d();
            } catch (Exception unused) {
                SameLogTool.m21733d("ResourceUtil", "MBSDKContext.getInstance() is null resName:" + str);
            }
            if (StringUtils.m21957a(str3) && context != null) {
                str3 = context.getPackageName();
            }
            if (StringUtils.m21957a(str3) || context == null) {
                return -1;
            }
            return context.getResources().getIdentifier(str, str2, str3);
        } catch (Exception unused2) {
            SameLogTool.m21733d("ResourceUtil", "Resource not found resName:" + str);
            return -1;
        }
    }
}
