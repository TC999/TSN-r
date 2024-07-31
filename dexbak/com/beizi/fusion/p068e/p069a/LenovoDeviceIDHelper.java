package com.beizi.fusion.p068e.p069a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.p068e.p069a.DevicesIDsHelper;
import com.beizi.fusion.p068e.p070b.LenovoIDInterface;

/* renamed from: com.beizi.fusion.e.a.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LenovoDeviceIDHelper {

    /* renamed from: a */
    LenovoIDInterface f11179a;

    /* renamed from: b */
    ServiceConnection f11180b = new ServiceConnection() { // from class: com.beizi.fusion.e.a.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LenovoDeviceIDHelper.this.f11179a = new LenovoIDInterface.AbstractBinderC3103a.C3104a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c */
    private Context f11181c;

    public LenovoDeviceIDHelper(Context context) {
        this.f11181c = context;
    }

    /* renamed from: a */
    public void m48560a(DevicesIDsHelper.InterfaceC3094a interfaceC3094a) {
        LenovoIDInterface lenovoIDInterface;
        this.f11181c.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.f11181c.bindService(intent, this.f11180b, 1) || (lenovoIDInterface = this.f11179a) == null) {
            return;
        }
        String mo48542a = lenovoIDInterface.mo48542a();
        if (interfaceC3094a != null) {
            interfaceC3094a.mo48445a(mo48542a);
        }
    }
}
