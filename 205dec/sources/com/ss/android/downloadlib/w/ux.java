package com.ss.android.downloadlib.w;

import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.c.c;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux implements c.InterfaceC0974c {

    /* renamed from: c  reason: collision with root package name */
    private long f48978c;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private static ux f48981c = new ux();
    }

    @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
    public void w() {
        this.f48978c = System.currentTimeMillis();
    }

    @Override // com.ss.android.socialbase.downloader.c.c.InterfaceC0974c
    public void xv() {
    }

    private ux() {
        this.f48978c = 0L;
        com.ss.android.socialbase.downloader.c.c.c().c(this);
    }

    public static ux c() {
        return c.f48981c;
    }

    public void w(sr srVar) {
        if (srVar == null) {
            return;
        }
        int optInt = k.gd().optInt("check_an_result_delay", 1200);
        c(srVar, optInt > 0 ? optInt : 1200);
    }

    public void c(final sr srVar, final long j4) {
        if (srVar == null) {
            return;
        }
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.w.ux.1
            @Override // java.lang.Runnable
            public void run() {
                if (com.ss.android.socialbase.downloader.c.c.c().xv() && System.currentTimeMillis() - ux.this.f48978c > j4) {
                    srVar.c(false);
                } else {
                    srVar.c(true);
                }
            }
        }, j4);
    }

    public void c(sr srVar) {
        c(srVar, 5000L);
    }
}
