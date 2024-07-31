package com.beizi.fusion.p068e.p069a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.p068e.p069a.DevicesIDsHelper;
import com.beizi.fusion.p068e.p070b.ASUSIDInterface;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.beizi.fusion.e.a.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ASUSDeviceIDHelper {

    /* renamed from: a */
    public final LinkedBlockingQueue<IBinder> f11168a = new LinkedBlockingQueue<>(1);

    /* renamed from: b */
    ServiceConnection f11169b = new ServiceConnection() { // from class: com.beizi.fusion.e.a.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ASUSDeviceIDHelper.this.f11168a.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c */
    private Context f11170c;

    public ASUSDeviceIDHelper(Context context) {
        this.f11170c = context;
    }

    /* renamed from: a */
    public void m48573a(DevicesIDsHelper.InterfaceC3094a interfaceC3094a) {
        try {
            this.f11170c.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (this.f11170c.bindService(intent, this.f11169b, 1)) {
            try {
                String m48545a = new ASUSIDInterface.C3101a(this.f11168a.take()).m48545a();
                if (interfaceC3094a != null) {
                    interfaceC3094a.mo48445a(m48545a);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
