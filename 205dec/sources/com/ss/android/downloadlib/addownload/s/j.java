package com.ss.android.downloadlib.addownload.s;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j implements q {
    @Override // com.ss.android.downloadlib.addownload.s.q
    public boolean ok(com.ss.android.downloadad.api.ok.a aVar, int i4, p pVar) {
        DownloadInfo a4;
        if (aVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(aVar.ld())) {
            a4 = com.ss.android.downloadlib.p.ok((Context) null).ok(aVar.ld(), null, true);
        } else {
            a4 = com.ss.android.downloadlib.p.ok((Context) null).a(aVar.ok());
        }
        return z.ok(aVar, a4, i4, pVar, false, null);
    }
}
