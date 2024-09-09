package com.beizi.fusion.sm.a.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.a.a.m;
import com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface;
import com.bun.miitmdid.content.StringValues;

/* compiled from: MsaImpl.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class j implements com.beizi.fusion.sm.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15054a;

    public j(Context context) {
        this.f15054a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f15054a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f15054a.startService(intent);
            } else {
                this.f15054a.startForegroundService(intent);
            }
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
        }
    }

    @Override // com.beizi.fusion.sm.a.d
    public boolean a() {
        Context context = this.f15054a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.a.d
    public void a(com.beizi.fusion.sm.a.c cVar) {
        if (this.f15054a == null || cVar == null) {
            return;
        }
        b();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f15054a.getPackageName());
        m.a(this.f15054a, intent, cVar, new m.a() { // from class: com.beizi.fusion.sm.a.a.j.1
            @Override // com.beizi.fusion.sm.a.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.a.e, RemoteException {
                MsaIdInterface asInterface = MsaIdInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupported()) {
                        return asInterface.getOAID();
                    }
                    throw new com.beizi.fusion.sm.a.e("MsaIdInterface#isSupported return false");
                }
                throw new com.beizi.fusion.sm.a.e("MsaIdInterface is null");
            }
        });
    }
}
