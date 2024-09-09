package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DownloadService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private static final String f49409a;
    protected t ok;

    static {
        StubApp.interface11(23085);
        f49409a = DownloadService.class.getSimpleName();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = f49409a;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.ok != null);
        com.ss.android.socialbase.downloader.bl.ok.a(str, sb.toString());
        t tVar = this.ok;
        if (tVar != null) {
            return tVar.ok(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        bl.ok(this);
        t ep = bl.ep();
        this.ok = ep;
        ep.ok(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(f49409a, "Service onDestroy");
        }
        t tVar = this.ok;
        if (tVar != null) {
            tVar.s();
            this.ok = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i4, final int i5) {
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(f49409a, "DownloadService onStartCommand");
        }
        this.ok.bl();
        ExecutorService j4 = bl.j();
        if (j4 != null) {
            j4.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    t tVar = DownloadService.this.ok;
                    if (tVar != null) {
                        tVar.ok(intent, i4, i5);
                    }
                }
            });
        }
        return bl.k() ? 2 : 3;
    }
}
