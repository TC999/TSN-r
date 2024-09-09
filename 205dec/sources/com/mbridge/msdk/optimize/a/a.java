package com.mbridge.msdk.optimize.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.mbridge.msdk.optimize.a.c;

/* compiled from: OaidAidlUtil.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f40383a;

    /* renamed from: b  reason: collision with root package name */
    private ServiceConnection f40384b;

    /* renamed from: c  reason: collision with root package name */
    private c f40385c;

    /* renamed from: d  reason: collision with root package name */
    private b f40386d;

    /* compiled from: OaidAidlUtil.java */
    /* renamed from: com.mbridge.msdk.optimize.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private final class ServiceConnectionC0753a implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f40385c = c.a.a(iBinder);
            try {
                if (a.this.f40385c != null) {
                    try {
                        if (a.this.f40386d != null) {
                            a.this.f40386d.a(a.this.f40385c.a(), a.this.f40385c.b());
                        }
                    } catch (RemoteException e4) {
                        if (a.this.f40386d != null) {
                            a.this.f40386d.a(e4.getMessage());
                        }
                    } catch (Exception e5) {
                        if (a.this.f40386d != null) {
                            a.this.f40386d.a(e5.getMessage());
                        }
                    }
                }
            } finally {
                a.c(a.this);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            a.this.f40385c = null;
        }

        private ServiceConnectionC0753a() {
        }
    }

    public a(Context context) {
        this.f40383a = context;
    }

    static /* synthetic */ void c(a aVar) {
        ServiceConnection serviceConnection;
        Context context = aVar.f40383a;
        if (context == null || (serviceConnection = aVar.f40384b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
        aVar.f40385c = null;
        aVar.f40383a = null;
        aVar.f40386d = null;
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        try {
            this.f40386d = bVar;
            if (this.f40383a == null) {
                return;
            }
            this.f40384b = new ServiceConnectionC0753a();
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.f40383a.bindService(intent, this.f40384b, 1);
        } catch (Throwable unused) {
        }
    }
}
