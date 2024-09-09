package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class gd implements com.ss.android.socialbase.downloader.downloader.k {
    public int c(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String ux = com.ss.android.socialbase.downloader.gd.f.ux(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(ux)) {
            return 0;
        }
        return ux.hashCode();
    }
}
