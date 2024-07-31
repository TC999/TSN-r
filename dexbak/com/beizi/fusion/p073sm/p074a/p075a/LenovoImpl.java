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
import com.beizi.fusion.p073sm.repeackage.com.zui.deviceidservice.IDeviceidInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.fusion.sm.a.a.h */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class LenovoImpl implements IOAID {

    /* renamed from: a */
    private final Context f11501a;

    public LenovoImpl(Context context) {
        this.f11501a = context;
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public boolean mo48132a() {
        Context context = this.f11501a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.zui.deviceidservice", 0) != null;
        } catch (Exception e) {
            OAIDLog.m48130a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        if (this.f11501a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        OAIDService.m48142a(this.f11501a, intent, iGetter, new OAIDService.InterfaceC3201a() { // from class: com.beizi.fusion.sm.a.a.h.1
            @Override // com.beizi.fusion.p073sm.p074a.p075a.OAIDService.InterfaceC3201a
            /* renamed from: a */
            public String mo48137a(IBinder iBinder) throws OAIDException, RemoteException {
                IDeviceidInterface asInterface = IDeviceidInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupport()) {
                        return asInterface.getOAID();
                    }
                    throw new OAIDException("IDeviceidInterface#isSupport return false");
                }
                throw new OAIDException("IDeviceidInterface is null");
            }
        });
    }
}
