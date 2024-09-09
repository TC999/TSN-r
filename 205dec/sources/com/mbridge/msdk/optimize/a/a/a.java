package com.mbridge.msdk.optimize.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.mbridge.msdk.optimize.a.b.a;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ASUSDeviceHelper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f40387a = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    ServiceConnection f40388b = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.a.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.f40387a.put(iBinder);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f40389c;

    public a(Context context) {
        this.f40389c = context;
    }

    public final void a(com.mbridge.msdk.optimize.a.b bVar) {
        try {
            this.f40389c.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        try {
            if (this.f40389c.bindService(intent, this.f40388b, 1)) {
                try {
                    String a4 = new a.C0754a(this.f40387a.take()).a();
                    if (bVar != null) {
                        bVar.a(a4, false);
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
