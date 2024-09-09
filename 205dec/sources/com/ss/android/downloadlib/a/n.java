package com.ss.android.downloadlib.a;

import com.ss.android.downloadlib.addownload.r;
import com.ss.android.socialbase.downloader.ok.ok;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n implements ok.InterfaceC1022ok {
    private long ok;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class ok {
        private static n ok = new n();
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
    public void a() {
        this.ok = System.currentTimeMillis();
    }

    @Override // com.ss.android.socialbase.downloader.ok.ok.InterfaceC1022ok
    public void bl() {
    }

    private n() {
        this.ok = 0L;
        com.ss.android.socialbase.downloader.ok.ok.ok().ok(this);
    }

    public static n ok() {
        return ok.ok;
    }

    public void a(s sVar) {
        if (sVar == null) {
            return;
        }
        int optInt = r.q().optInt("check_an_result_delay", 1200);
        ok(sVar, optInt > 0 ? optInt : 1200);
    }

    public void ok(final s sVar, final long j4) {
        if (sVar == null) {
            return;
        }
        com.ss.android.downloadlib.s.ok().ok(new Runnable() { // from class: com.ss.android.downloadlib.a.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.ss.android.socialbase.downloader.ok.ok.ok().bl() && System.currentTimeMillis() - n.this.ok > j4) {
                    sVar.ok(false);
                } else {
                    sVar.ok(true);
                }
            }
        }, j4);
    }

    public void ok(s sVar) {
        ok(sVar, 5000L);
    }
}
