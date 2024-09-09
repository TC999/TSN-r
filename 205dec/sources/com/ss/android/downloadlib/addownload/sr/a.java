package com.ss.android.downloadlib.addownload.sr;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.downloadlib.addownload.bk;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a implements gd {
    @Override // com.ss.android.downloadlib.addownload.sr.gd
    public boolean c(com.ss.android.downloadad.api.c.w wVar, int i4, ev evVar) {
        DownloadInfo w3;
        if (wVar == null) {
            return false;
        }
        if (!TextUtils.isEmpty(wVar.te())) {
            w3 = com.ss.android.downloadlib.ev.c((Context) null).c(wVar.te(), null, true);
        } else {
            w3 = com.ss.android.downloadlib.ev.c((Context) null).w(wVar.c());
        }
        return bk.c(wVar, w3, i4, evVar, false, null);
    }
}
