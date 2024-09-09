package com.beizi.fusion.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.e.a.b;
import com.beizi.fusion.e.b.a;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ASUSDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f14686a = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    ServiceConnection f14687b = new ServiceConnection() { // from class: com.beizi.fusion.e.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a.this.f14686a.put(iBinder);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f14688c;

    public a(Context context) {
        this.f14688c = context;
    }

    public void a(b.a aVar) {
        try {
            this.f14688c.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (this.f14688c.bindService(intent, this.f14687b, 1)) {
            try {
                String a4 = new a.C0137a(this.f14686a.take()).a();
                if (aVar != null) {
                    aVar.a(a4);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
