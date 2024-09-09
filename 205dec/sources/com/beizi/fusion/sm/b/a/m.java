package com.beizi.fusion.sm.b.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;

/* compiled from: OAIDService.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class m implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15095a;

    /* renamed from: b  reason: collision with root package name */
    private final com.beizi.fusion.sm.b.b f15096b;

    /* renamed from: c  reason: collision with root package name */
    private final a f15097c;

    /* compiled from: OAIDService.java */
    @FunctionalInterface
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface a {
        String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException;
    }

    private m(Context context, com.beizi.fusion.sm.b.b bVar, a aVar) {
        if (context instanceof Application) {
            this.f15095a = context;
        } else {
            this.f15095a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f15096b = bVar;
        this.f15097c = aVar;
    }

    public static void a(Context context, Intent intent, com.beizi.fusion.sm.b.b bVar, a aVar) {
        new m(context, bVar, aVar).a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.beizi.fusion.sm.b.e.a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String a4 = this.f15097c.a(iBinder);
                    if (a4 != null && a4.length() != 0) {
                        com.beizi.fusion.sm.b.e.a("OAID acquire success: " + a4);
                        this.f15096b.a(a4);
                        this.f15095a.unbindService(this);
                        com.beizi.fusion.sm.b.e.a("Service has been unbound: " + componentName.getClassName());
                        return;
                    }
                    throw new com.beizi.fusion.sm.b.d("OAID acquire failed");
                } catch (Exception e4) {
                    com.beizi.fusion.sm.b.e.a(e4);
                    this.f15096b.a(e4);
                    this.f15095a.unbindService(this);
                    com.beizi.fusion.sm.b.e.a("Service has been unbound: " + componentName.getClassName());
                }
            } catch (Exception e5) {
                com.beizi.fusion.sm.b.e.a(e5);
            }
        } catch (Throwable th) {
            try {
                this.f15095a.unbindService(this);
                com.beizi.fusion.sm.b.e.a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e6) {
                com.beizi.fusion.sm.b.e.a(e6);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.beizi.fusion.sm.b.e.a("Service has been disconnected: " + componentName.getClassName());
    }

    private void a(Intent intent) {
        try {
            if (this.f15095a.bindService(intent, this, 1)) {
                com.beizi.fusion.sm.b.e.a("Service has been bound: " + intent);
                return;
            }
            throw new com.beizi.fusion.sm.b.d("Service binding failed");
        } catch (Exception e4) {
            this.f15096b.a(e4);
        }
    }
}
