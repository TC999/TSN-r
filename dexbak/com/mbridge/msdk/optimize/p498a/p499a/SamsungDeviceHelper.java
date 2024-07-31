package com.mbridge.msdk.optimize.p498a.p499a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mbridge.msdk.optimize.p498a.OaidCallback;
import com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11539e;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.mbridge.msdk.optimize.a.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SamsungDeviceHelper {

    /* renamed from: a */
    public final LinkedBlockingQueue<IBinder> f31637a = new LinkedBlockingQueue<>(1);

    /* renamed from: b */
    ServiceConnection f31638b = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.g.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                SamsungDeviceHelper.this.f31637a.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c */
    private Context f31639c;

    public SamsungDeviceHelper(Context context) {
        this.f31639c = context;
    }

    /* renamed from: a */
    public final void m21355a(OaidCallback oaidCallback) {
        try {
            this.f31639c.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.f31639c.bindService(intent, this.f31638b, 1)) {
            try {
                String m21339a = new InterfaceC11539e.C11540a(this.f31637a.take()).m21339a();
                if (oaidCallback != null) {
                    oaidCallback.mo21350a(m21339a, false);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
