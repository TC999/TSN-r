package com.p521ss.android.socialbase.downloader.impls;

import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12523zz;

/* renamed from: com.ss.android.socialbase.downloader.impls.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12543k implements InterfaceC12523zz {
    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12523zz
    /* renamed from: ok */
    public long mo16651ok(int i, int i2) {
        if (i == 1) {
            return 3000L;
        }
        if (i == 2) {
            return 15000L;
        }
        if (i == 3) {
            return 30000L;
        }
        return i > 3 ? 300000L : 0L;
    }
}
