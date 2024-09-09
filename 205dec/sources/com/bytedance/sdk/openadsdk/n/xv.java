package com.bytedance.sdk.openadsdk.n;

import android.os.Environment;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv {
    public static String c() {
        try {
            return Environment.getExternalStorageState();
        } catch (Throwable unused) {
            return "";
        }
    }
}
