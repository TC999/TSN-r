package com.beizi.fusion.p068e.p069a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.p068e.p069a.DevicesIDsHelper;
import com.beizi.fusion.p068e.p070b.HWIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.beizi.fusion.e.a.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HWDeviceIDHelper {

    /* renamed from: a */
    public final LinkedBlockingQueue<IBinder> f11175a = new LinkedBlockingQueue<>(1);

    /* renamed from: b */
    ServiceConnection f11176b = new ServiceConnection() { // from class: com.beizi.fusion.e.a.c.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                HWDeviceIDHelper.this.f11175a.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c */
    private Context f11177c;

    public HWDeviceIDHelper(Context context) {
        this.f11177c = context;
    }

    /* renamed from: a */
    public void m48561a(DevicesIDsHelper.InterfaceC3094a interfaceC3094a) {
        try {
            this.f11177c.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            if (this.f11177c.bindService(intent, this.f11176b, 1)) {
                try {
                    HWIDInterface.C3102a c3102a = new HWIDInterface.C3102a(this.f11175a.take());
                    String m48544a = c3102a.m48544a();
                    c3102a.m48543b();
                    if (interfaceC3094a != null) {
                        interfaceC3094a.mo48445a(m48544a);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        } finally {
            this.f11177c.unbindService(this.f11176b);
        }
    }
}
