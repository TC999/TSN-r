package com.mbridge.msdk.optimize.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mbridge.msdk.optimize.a.b.e;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: SamsungDeviceHelper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f40410a = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    ServiceConnection f40411b = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                g.this.f40410a.put(iBinder);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f40412c;

    public g(Context context) {
        this.f40412c = context;
    }

    public final void a(com.mbridge.msdk.optimize.a.b bVar) {
        try {
            this.f40412c.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.f40412c.bindService(intent, this.f40411b, 1)) {
            try {
                String a4 = new e.a(this.f40410a.take()).a();
                if (bVar != null) {
                    bVar.a(a4, false);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
