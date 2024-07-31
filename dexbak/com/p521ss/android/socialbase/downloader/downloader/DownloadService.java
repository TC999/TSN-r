package com.p521ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;

/* renamed from: com.ss.android.socialbase.downloader.downloader.DownloadService */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DownloadService extends Service {

    /* renamed from: a */
    private static final String f35053a;

    /* renamed from: ok */
    protected InterfaceC12517t f35054ok;

    static {
        StubApp.interface11(23085);
        f35053a = DownloadService.class.getSimpleName();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str = f35053a;
        StringBuilder sb = new StringBuilder();
        sb.append("onBind downloadServiceHandler != null:");
        sb.append(this.f35054ok != null);
        C12409ok.m17904a(str, sb.toString());
        InterfaceC12517t interfaceC12517t = this.f35054ok;
        if (interfaceC12517t != null) {
            return interfaceC12517t.mo17523ok(intent);
        }
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C12490bl.m17799ok(this);
        InterfaceC12517t m17822ep = C12490bl.m17822ep();
        this.f35054ok = m17822ep;
        m17822ep.mo17630ok(new WeakReference(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (C12409ok.m17899ok()) {
            C12409ok.m17904a(f35053a, "Service onDestroy");
        }
        InterfaceC12517t interfaceC12517t = this.f35054ok;
        if (interfaceC12517t != null) {
            interfaceC12517t.mo17628s();
            this.f35054ok = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(final Intent intent, final int i, final int i2) {
        if (C12409ok.m17899ok()) {
            C12409ok.m17904a(f35053a, "DownloadService onStartCommand");
        }
        this.f35054ok.mo17532bl();
        ExecutorService m17812j = C12490bl.m17812j();
        if (m17812j != null) {
            m17812j.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.DownloadService.1
                @Override // java.lang.Runnable
                public void run() {
                    InterfaceC12517t interfaceC12517t = DownloadService.this.f35054ok;
                    if (interfaceC12517t != null) {
                        interfaceC12517t.mo17531ok(intent, i, i2);
                    }
                }
            });
        }
        return C12490bl.m17811k() ? 2 : 3;
    }
}
