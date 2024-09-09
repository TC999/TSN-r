package com.bytedance.sdk.component.utils;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class bk {
    public static long c(String str) {
        StringBuilder sb;
        long j4 = 0;
        try {
            if (!TextUtils.isEmpty(str)) {
                StatFs statFs = new StatFs(str);
                j4 = statFs.getAvailableBlocks() * statFs.getBlockSize();
            }
            sb = new StringBuilder();
        } catch (Throwable unused) {
            sb = new StringBuilder();
        }
        sb.append("getAvailableSize=");
        sb.append(j4);
        sb.append(", ");
        sb.append(String.valueOf(str));
        a.w("MemorySize", sb.toString());
        return j4;
    }

    public static long c() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getAvailableBlocks() * statFs.getBlockSize();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
