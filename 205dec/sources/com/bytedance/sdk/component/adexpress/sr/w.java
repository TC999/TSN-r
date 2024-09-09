package com.bytedance.sdk.component.adexpress.sr;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return (TextUtils.getLayoutDirectionFromLocale(context.getResources().getConfiguration().locale) == 1) && (context.getApplicationInfo().flags & 4194304) == 4194304;
    }
}
