package com.ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.ss.android.socialbase.downloader.downloader.DownloadService;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class p extends com.ss.android.socialbase.downloader.downloader.ok {

    /* renamed from: n  reason: collision with root package name */
    private static final String f49775n = "p";

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void bl() {
        if (com.ss.android.socialbase.downloader.q.ok.ok(262144)) {
            this.f49486a = true;
            this.f49489s = false;
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a(f49775n, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok, com.ss.android.socialbase.downloader.downloader.t
    public void ok(Intent intent, int i4, int i5) {
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(f49775n, "onStartCommand");
        }
        if (!com.ss.android.socialbase.downloader.q.ok.ok(262144)) {
            this.f49486a = true;
        }
        n();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ok
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, DownloadService.class));
        this.f49486a = false;
    }
}
