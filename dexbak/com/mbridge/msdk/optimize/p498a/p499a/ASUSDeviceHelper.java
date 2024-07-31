package com.mbridge.msdk.optimize.p498a.p499a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mbridge.msdk.optimize.p498a.OaidCallback;
import com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11528a;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.mbridge.msdk.optimize.a.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ASUSDeviceHelper {

    /* renamed from: a */
    public final LinkedBlockingQueue<IBinder> f31615a = new LinkedBlockingQueue<>(1);

    /* renamed from: b */
    ServiceConnection f31616b = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.a.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ASUSDeviceHelper.this.f31615a.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c */
    private Context f31617c;

    public ASUSDeviceHelper(Context context) {
        this.f31617c = context;
    }

    /* renamed from: a */
    public final void m21363a(OaidCallback oaidCallback) {
        try {
            this.f31617c.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        try {
            if (this.f31617c.bindService(intent, this.f31616b, 1)) {
                try {
                    String m21349a = new InterfaceC11528a.C11529a(this.f31615a.take()).m21349a();
                    if (oaidCallback != null) {
                        oaidCallback.mo21350a(m21349a, false);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
