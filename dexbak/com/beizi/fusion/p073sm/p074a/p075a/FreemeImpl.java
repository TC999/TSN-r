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
import com.beizi.fusion.p073sm.repeackage.com.android.creator.IdsSupplier;

/* renamed from: com.beizi.fusion.sm.a.a.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class FreemeImpl implements IOAID {

    /* renamed from: a */
    private final Context f11494a;

    public FreemeImpl(Context context) {
        this.f11494a = context;
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public boolean mo48132a() {
        Context context = this.f11494a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e) {
            OAIDLog.m48130a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        if (this.f11494a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        OAIDService.m48142a(this.f11494a, intent, iGetter, new OAIDService.InterfaceC3201a() { // from class: com.beizi.fusion.sm.a.a.e.1
            @Override // com.beizi.fusion.p073sm.p074a.p075a.OAIDService.InterfaceC3201a
            /* renamed from: a */
            public String mo48137a(IBinder iBinder) throws OAIDException, RemoteException {
                IdsSupplier asInterface = IdsSupplier.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("IdsSupplier is null");
            }
        });
    }
}
