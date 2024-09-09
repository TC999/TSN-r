package com.bytedance.msdk.f;

import android.content.Context;
import android.telephony.TelephonyManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class y {
    public static TelephonyManager c() {
        if (com.bytedance.msdk.core.c.getContext() != null && com.bytedance.msdk.core.w.k().y().w() && c(com.bytedance.msdk.core.c.getContext())) {
            return (TelephonyManager) com.bytedance.msdk.core.c.getContext().getSystemService("phone");
        }
        return null;
    }

    private static boolean c(Context context) {
        return com.bytedance.msdk.core.t.xv.c(context, "android.permission.READ_PHONE_STATE") == 0;
    }
}
