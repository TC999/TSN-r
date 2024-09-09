package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class q implements com.ss.android.socialbase.downloader.downloader.r {
    @Override // com.ss.android.socialbase.downloader.downloader.r
    public int ok(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String n4 = com.ss.android.socialbase.downloader.q.kf.n(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(n4)) {
            return 0;
        }
        return n4.hashCode();
    }
}
