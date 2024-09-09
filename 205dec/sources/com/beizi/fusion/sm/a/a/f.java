package com.beizi.fusion.sm.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.a.a.m;
import com.beizi.fusion.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* compiled from: GmsImpl.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class f implements com.beizi.fusion.sm.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15046a;

    public f(Context context) {
        this.f15046a = context;
    }

    @Override // com.beizi.fusion.sm.a.d
    public boolean a() {
        Context context = this.f15046a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.a.d
    public void a(com.beizi.fusion.sm.a.c cVar) {
        if (this.f15046a == null || cVar == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        m.a(this.f15046a, intent, cVar, new m.a() { // from class: com.beizi.fusion.sm.a.a.f.1
            @Override // com.beizi.fusion.sm.a.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.a.e, RemoteException {
                IAdvertisingIdService asInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
                if (asInterface.isLimitAdTrackingEnabled(true)) {
                    com.beizi.fusion.sm.a.f.a("User has disabled advertising identifier");
                }
                return asInterface.getId();
            }
        });
    }
}
