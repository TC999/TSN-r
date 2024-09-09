package com.bytedance.sdk.component.c;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
class gb {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f29662c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\"code\":");
        sb.append(th instanceof fz ? ((fz) th).f29661c : 0);
        sb.append("}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        String substring = f29662c ? str.substring(1, str.length() - 1) : "";
        String str2 = "{\"code\":1,\"__data\":" + str;
        if (!substring.isEmpty()) {
            return str2 + "," + substring + "}";
        }
        return str2 + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z3) {
        f29662c = z3;
    }
}
