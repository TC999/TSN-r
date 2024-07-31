package com.p521ss.android.downloadlib.addownload.p532s;

import android.text.TextUtils;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12257p;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.C12159z;
import com.p521ss.android.downloadlib.addownload.p531ok.InterfaceC12111bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;

/* renamed from: com.ss.android.downloadlib.addownload.s.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12152n implements InterfaceC12147h {
    @Override // com.p521ss.android.downloadlib.addownload.p532s.InterfaceC12147h
    /* renamed from: ok */
    public boolean mo18888ok(C11998a c11998a, int i, InterfaceC12155p interfaceC12155p, InterfaceC12111bl interfaceC12111bl) {
        DownloadInfo m18578a;
        if (c11998a == null) {
            return false;
        }
        if (!TextUtils.isEmpty(c11998a.m19480ld())) {
            m18578a = C12257p.m18572ok(C12128r.getContext()).m18563ok(c11998a.m19480ld(), null, true);
        } else {
            m18578a = C12257p.m18572ok(C12128r.getContext()).m18578a(c11998a.mo19298ok());
        }
        return C12159z.m18874ok(c11998a, m18578a, i, interfaceC12155p, true, interfaceC12111bl);
    }
}
