package com.p521ss.android.socialbase.downloader.impls;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok;
import com.p521ss.android.socialbase.downloader.downloader.DownloadService;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;

/* renamed from: com.ss.android.socialbase.downloader.impls.p */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12554p extends AbstractC12507ok {

    /* renamed from: n */
    private static final String f35251n = "p";

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok, com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: bl */
    public void mo17532bl() {
        if (C12717ok.m16510ok(262144)) {
            this.f35165a = true;
            this.f35171s = false;
            if (C12409ok.m17899ok()) {
                C12409ok.m17904a(f35251n, "onStartCommandOnMainThread");
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok, com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public void mo17531ok(Intent intent, int i, int i2) {
        if (C12409ok.m17899ok()) {
            C12409ok.m17904a(f35251n, "onStartCommand");
        }
        if (!C12717ok.m16510ok(262144)) {
            this.f35165a = true;
        }
        m17687n();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok
    public void startService(Context context, ServiceConnection serviceConnection) {
        try {
            context.startService(new Intent(context, DownloadService.class));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.AbstractC12507ok
    public void stopService(Context context, ServiceConnection serviceConnection) {
        context.stopService(new Intent(context, DownloadService.class));
        this.f35165a = false;
    }
}
