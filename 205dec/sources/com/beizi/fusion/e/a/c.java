package com.beizi.fusion.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.e.a.b;
import com.beizi.fusion.e.b.b;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HWDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f14693a = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    ServiceConnection f14694b = new ServiceConnection() { // from class: com.beizi.fusion.e.a.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                c.this.f14693a.put(iBinder);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f14695c;

    public c(Context context) {
        this.f14695c = context;
    }

    public void a(b.a aVar) {
        try {
            this.f14695c.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            if (this.f14695c.bindService(intent, this.f14694b, 1)) {
                try {
                    b.a aVar2 = new b.a(this.f14693a.take());
                    String a4 = aVar2.a();
                    aVar2.b();
                    if (aVar != null) {
                        aVar.a(a4);
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        } finally {
            this.f14695c.unbindService(this.f14694b);
        }
    }
}
