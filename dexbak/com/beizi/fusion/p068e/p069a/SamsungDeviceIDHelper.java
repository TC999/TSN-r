package com.beizi.fusion.p068e.p069a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.p068e.p069a.DevicesIDsHelper;
import com.beizi.fusion.p068e.p070b.SamsungIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.beizi.fusion.e.a.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SamsungDeviceIDHelper {

    /* renamed from: a */
    public final LinkedBlockingQueue<IBinder> f11197a = new LinkedBlockingQueue<>(1);

    /* renamed from: b */
    ServiceConnection f11198b = new ServiceConnection() { // from class: com.beizi.fusion.e.a.i.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                SamsungDeviceIDHelper.this.f11197a.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c */
    private Context f11199c;

    public SamsungDeviceIDHelper(Context context) {
        this.f11199c = context;
    }

    /* renamed from: a */
    public void m48552a(DevicesIDsHelper.InterfaceC3094a interfaceC3094a) {
        try {
            this.f11199c.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.f11199c.bindService(intent, this.f11198b, 1)) {
            try {
                String m48533a = new SamsungIDInterface.C3109a(this.f11197a.take()).m48533a();
                if (interfaceC3094a != null) {
                    interfaceC3094a.mo48445a(m48533a);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
