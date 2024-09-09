package com.beizi.fusion.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.e.a.b;
import com.beizi.fusion.e.b.f;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SamsungDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f14715a = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    ServiceConnection f14716b = new ServiceConnection() { // from class: com.beizi.fusion.e.a.i.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                i.this.f14715a.put(iBinder);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f14717c;

    public i(Context context) {
        this.f14717c = context;
    }

    public void a(b.a aVar) {
        try {
            this.f14717c.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.f14717c.bindService(intent, this.f14716b, 1)) {
            try {
                String a4 = new f.a(this.f14715a.take()).a();
                if (aVar != null) {
                    aVar.a(a4);
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
