package com.beizi.fusion.sm.b.a;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;
import com.stub.StubApp;

/* compiled from: CoolpadImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15077a;

    public b(Context context) {
        if (context instanceof Application) {
            this.f15077a = context;
        } else {
            this.f15077a = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f15077a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15077a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        m.a(this.f15077a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.b.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                IDeviceIdManager asInterface = IDeviceIdManager.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID(b.this.f15077a.getPackageName());
                }
                throw new com.beizi.fusion.sm.b.d("IDeviceIdManager is null");
            }
        });
    }
}
