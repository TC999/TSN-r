package com.ss.android.socialbase.downloader.downloader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SqlDownloadCacheService extends Service {
    private static final String ok;

    static {
        StubApp.interface11(23089);
        ok = SqlDownloadCacheService.class.getSimpleName();
    }

    public static void ok(Context context, ServiceConnection serviceConnection) {
        if (context != null) {
            try {
                Intent intent = new Intent(context, SqlDownloadCacheService.class);
                if (serviceConnection != null) {
                    context.bindService(intent, serviceConnection, 1);
                }
                context.startService(intent);
            } catch (Throwable th) {
                Log.w(ok, "startServiceAndBind fail", th);
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        u uVar;
        k m4 = bl.m();
        if (m4 instanceof com.ss.android.socialbase.downloader.impls.s) {
            uVar = ((com.ss.android.socialbase.downloader.impls.s) m4).kf();
        } else {
            uVar = m4 instanceof u ? (u) m4 : null;
        }
        if (uVar instanceof IBinder) {
            return (IBinder) uVar;
        }
        return new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        bl.ok(StubApp.getOrigApplicationContext(getApplicationContext()));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        int onStartCommand = super.onStartCommand(intent, i4, i5);
        if (bl.k()) {
            return 2;
        }
        return onStartCommand;
    }
}
