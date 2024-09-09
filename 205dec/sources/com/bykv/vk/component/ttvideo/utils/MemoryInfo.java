package com.bykv.vk.component.ttvideo.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class MemoryInfo {
    private static long[] mRomMemroy;
    private static long mTotalMemorySize;

    public static long getAvailMemory(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return memoryInfo.availMem / 1024;
    }

    public static long[] getRomMemroy() {
        if (mRomMemroy == null) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mRomMemroy = new long[]{getTotalInternalMemorySize(), statFs.getBlockSize() * statFs.getAvailableBlocks()};
        }
        return mRomMemroy;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x004d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x001b -> B:32:0x002d). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getTolalMemory() {
        /*
            java.lang.String r0 = "/proc/meminfo"
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            r0 = 8
            r2.<init>(r3, r0)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Exception -> L1f java.lang.Throwable -> L49
            if (r0 == 0) goto L16
            r1 = r0
        L16:
            r2.close()     // Catch: java.lang.Exception -> L1a
            goto L2d
        L1a:
            r0 = move-exception
            r0.printStackTrace()
            goto L2d
        L1f:
            r0 = move-exception
            goto L25
        L21:
            r0 = move-exception
            goto L4b
        L23:
            r0 = move-exception
            r2 = r1
        L25:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L2d
            r2.close()     // Catch: java.lang.Exception -> L1a
        L2d:
            r0 = 58
            int r0 = r1.indexOf(r0)
            r2 = 107(0x6b, float:1.5E-43)
            int r2 = r1.indexOf(r2)
            int r0 = r0 + 1
            java.lang.String r0 = r1.substring(r0, r2)
            java.lang.String r0 = r0.trim()
            int r0 = java.lang.Integer.parseInt(r0)
            long r0 = (long) r0
            return r0
        L49:
            r0 = move-exception
            r1 = r2
        L4b:
            if (r1 == 0) goto L55
            r1.close()     // Catch: java.lang.Exception -> L51
            goto L55
        L51:
            r1 = move-exception
            r1.printStackTrace()
        L55:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.utils.MemoryInfo.getTolalMemory():long");
    }

    public static long getTotalInternalMemorySize() {
        if (mTotalMemorySize == 0) {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            mTotalMemorySize = statFs.getBlockCount() * statFs.getBlockSize();
        }
        return mTotalMemorySize;
    }
}
