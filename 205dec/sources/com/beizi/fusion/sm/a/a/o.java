package com.beizi.fusion.sm.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.a.a.m;
import com.beizi.fusion.sm.repeackage.com.samsung.android.deviceidservice.IDeviceIdService;

/* compiled from: SamsungImpl.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class o implements com.beizi.fusion.sm.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15064a;

    public o(Context context) {
        this.f15064a = context;
    }

    @Override // com.beizi.fusion.sm.a.d
    public boolean a() {
        Context context = this.f15064a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.a.d
    public void a(com.beizi.fusion.sm.a.c cVar) {
        if (this.f15064a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        m.a(this.f15064a, intent, cVar, new m.a() { // from class: com.beizi.fusion.sm.a.a.o.1
            @Override // com.beizi.fusion.sm.a.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.a.e, RemoteException {
                IDeviceIdService asInterface = IDeviceIdService.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID();
                }
                throw new com.beizi.fusion.sm.a.e("IDeviceIdService is null");
            }
        });
    }
}
