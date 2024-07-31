package com.p521ss.android.downloadlib.p534h;

import java.io.File;

/* renamed from: com.ss.android.downloadlib.h.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12196h {
    /* renamed from: ok */
    public static long m18811ok(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return m18810ok(file, file.lastModified(), 0);
    }

    /* renamed from: ok */
    private static long m18810ok(File file, long j, int i) {
        File[] listFiles;
        if (file != null && file.exists()) {
            j = Math.max(j, file.lastModified());
            int i2 = i + 1;
            if (i2 >= 50) {
                return j;
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    j = Math.max(j, m18810ok(file2, j, i2));
                }
            }
        }
        return j;
    }
}
