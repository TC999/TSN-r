package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.zz;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class x implements zz {
    private final long[] ok;

    public x(String str) {
        this.ok = ok(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.zz
    public long ok(int i4, int i5) {
        long[] jArr = this.ok;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int i6 = i4 - 1;
        if (i6 < 0) {
            i6 = 0;
        }
        if (i6 > jArr.length - 1) {
            i6 = jArr.length - 1;
        }
        return jArr[i6];
    }

    private long[] ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            for (int i4 = 0; i4 < split.length; i4++) {
                jArr[i4] = Long.parseLong(split[i4]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
