package com.p521ss.android.downloadlib.addownload.p532s;

import android.content.Context;
import android.text.TextUtils;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.downloadlib.addownload.C12159z;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.downloadlib.addownload.s.j */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12148j implements InterfaceC12156q {
    @Override // com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12156q
    /* renamed from: ok */
    public boolean mo18882ok(C11998a c11998a, int i, InterfaceC12155p interfaceC12155p) {
        DownloadInfo m18578a;
        if (c11998a == null) {
            return false;
        }
        if (!TextUtils.isEmpty(c11998a.m19480ld())) {
            m18578a = C12257p.m18572ok((Context) null).m18563ok(c11998a.m19480ld(), null, true);
        } else {
            m18578a = C12257p.m18572ok((Context) null).m18578a(c11998a.mo19298ok());
        }
        return C12159z.m18874ok(c11998a, m18578a, i, interfaceC12155p, false, null);
    }
}
