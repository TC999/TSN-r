package com.p521ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12523zz;

/* renamed from: com.ss.android.socialbase.downloader.impls.x */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12572x implements InterfaceC12523zz {

    /* renamed from: ok */
    private final long[] f35304ok;

    public C12572x(String str) {
        this.f35304ok = m17375ok(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12523zz
    /* renamed from: ok */
    public long mo16651ok(int i, int i2) {
        long[] jArr = this.f35304ok;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int i3 = i - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        if (i3 > jArr.length - 1) {
            i3 = jArr.length - 1;
        }
        return jArr[i3];
    }

    /* renamed from: ok */
    private long[] m17375ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            for (int i = 0; i < split.length; i++) {
                jArr[i] = Long.parseLong(split[i]);
            }
            return jArr;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
