package com.bytedance.sdk.openadsdk.core.live.sr;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ys;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {
    public static boolean c(Context context, me meVar) {
        if (meVar == null) {
            return false;
        }
        return c(context, meVar.qu());
    }

    public static boolean c(Context context, ys ysVar) {
        if (ysVar == null) {
            return false;
        }
        String c4 = ysVar.c();
        if (TextUtils.isEmpty(c4)) {
            return false;
        }
        return c4.startsWith("snssdk2329") || c4.startsWith("snssdk1128");
    }
}
