package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ev extends com.ss.android.socialbase.downloader.downloader.c {
    private static final String ux = "ev";

    @Override // com.ss.android.socialbase.downloader.downloader.c, com.ss.android.socialbase.downloader.downloader.ys
    public void c(Intent intent, int i4, int i5) {
        if (com.ss.android.socialbase.downloader.xv.c.c()) {
            com.ss.android.socialbase.downloader.xv.c.w(ux, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.gd.c.c(262144)) {
            this.f49438w = true;
        }
        ux();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.c
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.c
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, DownloadService.class));
        this.f49438w = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.c, com.ss.android.socialbase.downloader.downloader.ys
    public void xv() {
        if (com.ss.android.socialbase.downloader.gd.c.c(262144)) {
            this.f49438w = true;
            this.sr = false;
            if (com.ss.android.socialbase.downloader.xv.c.c()) {
                com.ss.android.socialbase.downloader.xv.c.w(ux, "onStartCommandOnMainThread");
            }
        }
    }
}
