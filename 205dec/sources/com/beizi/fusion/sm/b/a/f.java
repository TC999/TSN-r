package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* compiled from: GmsImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class f implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15083a;

    public f(Context context) {
        this.f15083a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f15083a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15083a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        m.a(this.f15083a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.f.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                IAdvertisingIdService asInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
                if (asInterface.isLimitAdTrackingEnabled(true)) {
                    com.beizi.fusion.sm.b.e.a("User has disabled advertising identifier");
                }
                return asInterface.getId();
            }
        });
    }
}
