package com.beizi.fusion.p073sm.p074a.p075a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.p073sm.p074a.IGetter;
import com.beizi.fusion.p073sm.p074a.OAIDException;
import com.beizi.fusion.p073sm.p074a.OAIDLog;
import com.stub.StubApp;

/* renamed from: com.beizi.fusion.sm.a.a.m */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class OAIDService implements ServiceConnection {

    /* renamed from: a */
    private final Context f11508a;

    /* renamed from: b */
    private final IGetter f11509b;

    /* renamed from: c */
    private final InterfaceC3201a f11510c;

    /* compiled from: OAIDService.java */
    @FunctionalInterface
    /* renamed from: com.beizi.fusion.sm.a.a.m$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface InterfaceC3201a {
        /* renamed from: a */
        String mo48137a(IBinder iBinder) throws OAIDException, RemoteException;
    }

    private OAIDService(Context context, IGetter iGetter, InterfaceC3201a interfaceC3201a) {
        if (context instanceof Application) {
            this.f11508a = context;
        } else {
            this.f11508a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        this.f11509b = iGetter;
        this.f11510c = interfaceC3201a;
    }

    /* renamed from: a */
    public static void m48142a(Context context, Intent intent, IGetter iGetter, InterfaceC3201a interfaceC3201a) {
        new OAIDService(context, iGetter, interfaceC3201a).m48141a(intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        OAIDLog.m48130a("Service has been connected: " + componentName.getClassName());
        try {
            try {
                try {
                    String mo48137a = this.f11510c.mo48137a(iBinder);
                    if (mo48137a != null && mo48137a.length() != 0) {
                        OAIDLog.m48130a("OAID acquire success: " + mo48137a);
                        this.f11509b.mo48133a(mo48137a);
                        this.f11508a.unbindService(this);
                        OAIDLog.m48130a("Service has been unbound: " + componentName.getClassName());
                        return;
                    }
                    throw new OAIDException("OAID acquire failed");
                } catch (Exception e) {
                    OAIDLog.m48130a(e);
                    this.f11509b.mo48134a(e);
                    this.f11508a.unbindService(this);
                    OAIDLog.m48130a("Service has been unbound: " + componentName.getClassName());
                }
            } catch (Exception e2) {
                OAIDLog.m48130a(e2);
            }
        } catch (Throwable th) {
            try {
                this.f11508a.unbindService(this);
                OAIDLog.m48130a("Service has been unbound: " + componentName.getClassName());
            } catch (Exception e3) {
                OAIDLog.m48130a(e3);
            }
            throw th;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        OAIDLog.m48130a("Service has been disconnected: " + componentName.getClassName());
    }

    /* renamed from: a */
    private void m48141a(Intent intent) {
        try {
            if (this.f11508a.bindService(intent, this, 1)) {
                OAIDLog.m48130a("Service has been bound: " + intent);
                return;
            }
            throw new OAIDException("Service binding failed");
        } catch (Exception e) {
            this.f11509b.mo48134a(e);
        }
    }
}
