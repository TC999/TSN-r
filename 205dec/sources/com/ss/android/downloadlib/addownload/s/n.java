package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n implements h {
    @Override // com.ss.android.downloadlib.addownload.s.h
    public boolean ok(com.ss.android.downloadad.api.ok.a aVar, int i4, p pVar, com.ss.android.downloadlib.addownload.ok.bl blVar) {
        DownloadInfo a4;
        if (aVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(aVar.ld())) {
            a4 = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).ok(aVar.ld(), null, true);
        } else {
            a4 = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).a(aVar.ok());
        }
        return z.ok(aVar, a4, i4, pVar, true, blVar);
    }
}
