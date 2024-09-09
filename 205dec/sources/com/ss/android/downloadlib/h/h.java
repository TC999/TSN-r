package com.ss.android.downloadlib.h;

import java.io.File;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {
    public static long ok(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return ok(file, file.lastModified(), 0);
    }

    private static long ok(File file, long j4, int i4) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j4 = Math.max(j4, file.lastModified());
            int i5 = i4 + 1;
            if (i5 >= 50) {
                return j4;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j4 = Math.max(j4, ok(file2, j4, i5));
                }
            }
        }
        return j4;
    }
}
