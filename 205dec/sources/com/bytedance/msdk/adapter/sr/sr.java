package com.bytedance.msdk.adapter.sr;

import java.util.IllegalFormatException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr {
    public static void c(Object obj) {
        c(obj, true, "Object can not be null.", "");
    }

    private static boolean c(Object obj, boolean z3, String str, Object... objArr) {
        if (obj != null) {
            return true;
        }
        String c4 = c(str, objArr);
        if (!z3) {
            xv.sr("TTMediationSDK_ADAPTER", c4);
            return false;
        }
        throw new NullPointerException(c4);
    }

    private static String c(String str, Object... objArr) {
        String valueOf = String.valueOf(str);
        try {
            return String.format(valueOf, objArr);
        } catch (IllegalFormatException e4) {
            xv.sr("TTMediationSDK_ADAPTER", "MoPub preconditions had a format exception: " + e4.getMessage());
            return valueOf;
        }
    }
}
