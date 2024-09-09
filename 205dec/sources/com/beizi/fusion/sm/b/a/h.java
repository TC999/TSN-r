package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.zui.deviceidservice.IDeviceidInterface;

/* compiled from: LenovoImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class h implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15088a;

    public h(Context context) {
        this.f15088a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f15088a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15088a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        m.a(this.f15088a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.h.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                IDeviceidInterface asInterface = IDeviceidInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupport()) {
                        return asInterface.getOAID();
                    }
                    throw new com.beizi.fusion.sm.b.d("IDeviceidInterface#isSupport return false");
                }
                throw new com.beizi.fusion.sm.b.d("IDeviceidInterface is null");
            }
        });
    }
}
