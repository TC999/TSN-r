package com.p521ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.p521ss.android.socialbase.downloader.impls.C12558s;
import com.stub.StubApp;

/* renamed from: com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class SqlDownloadCacheService extends Service {

    /* renamed from: ok */
    private static final String f35059ok;

    static {
        StubApp.interface11(23089);
        f35059ok = SqlDownloadCacheService.class.getSimpleName();
    }

    /* renamed from: ok */
    public static void m17842ok(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Log.w(f35059ok, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterfaceC12519u interfaceC12519u;
        InterfaceC12501k m17806m = C12490bl.m17806m();
        if (m17806m instanceof C12558s) {
            interfaceC12519u = ((C12558s) m17806m).m17503kf();
        } else {
            interfaceC12519u = m17806m instanceof InterfaceC12519u ? (InterfaceC12519u) m17806m : null;
        }
        if (interfaceC12519u instanceof IBinder) {
            return (IBinder) interfaceC12519u;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        C12490bl.m17799ok(StubApp.getOrigApplicationContext(getApplicationContext()));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        int onStartCommand = super.onStartCommand(intent, i, i2);
        if (C12490bl.m17811k()) {
            return 2;
        }
        return onStartCommand;
    }
}
