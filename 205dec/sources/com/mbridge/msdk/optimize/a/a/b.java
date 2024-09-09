package com.mbridge.msdk.optimize.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mbridge.msdk.optimize.a.b.b;

/* compiled from: LenovoDeviceHelper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    com.mbridge.msdk.optimize.a.b.b f40392a;

    /* renamed from: b  reason: collision with root package name */
    ServiceConnection f40393b = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.b.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                b.this.f40392a = new b.a.C0755a(iBinder);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f40394c;

    public b(Context context) {
        this.f40394c = context;
    }

    public final void a(com.mbridge.msdk.optimize.a.b bVar) {
        com.mbridge.msdk.optimize.a.b.b bVar2;
        try {
            this.f40394c.getPackageName();
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f40394c.bindService(intent, this.f40393b, 1) || (bVar2 = this.f40392a) == null) {
                return;
            }
            String a4 = bVar2.a();
            if (bVar != null) {
                bVar.a(a4, false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
