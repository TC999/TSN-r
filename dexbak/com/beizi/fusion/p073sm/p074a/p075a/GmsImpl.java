package com.beizi.fusion.p073sm.p074a.p075a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.p073sm.p074a.IGetter;
import com.beizi.fusion.p073sm.p074a.IOAID;
import com.beizi.fusion.p073sm.p074a.OAIDException;
import com.beizi.fusion.p073sm.p074a.OAIDLog;
import com.beizi.fusion.p073sm.p074a.p075a.OAIDService;
import com.beizi.fusion.p073sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.fusion.sm.a.a.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class GmsImpl implements IOAID {

    /* renamed from: a */
    private final Context f11496a;

    public GmsImpl(Context context) {
        this.f11496a = context;
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public boolean mo48132a() {
        Context context = this.f11496a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e) {
            OAIDLog.m48130a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        if (this.f11496a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        OAIDService.m48142a(this.f11496a, intent, iGetter, new OAIDService.InterfaceC3201a() { // from class: com.beizi.fusion.sm.a.a.f.1
            @Override // com.beizi.fusion.p073sm.p074a.p075a.OAIDService.InterfaceC3201a
            /* renamed from: a */
            public String mo48137a(IBinder iBinder) throws OAIDException, RemoteException {
                IAdvertisingIdService asInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
                if (asInterface.isLimitAdTrackingEnabled(true)) {
                    OAIDLog.m48130a("User has disabled advertising identifier");
                }
                return asInterface.getId();
            }
        });
    }
}
