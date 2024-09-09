package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.bun.lib.MsaIdInterface;
import com.bun.miitmdid.content.StringValues;

/* compiled from: MsaImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class j implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15091a;

    public j(Context context) {
        this.f15091a = context;
    }

    private void b() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f15091a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f15091a.startService(intent);
            } else {
                this.f15091a.startForegroundService(intent);
            }
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f15091a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15091a == null || bVar == null) {
            return;
        }
        b();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f15091a.getPackageName());
        m.a(this.f15091a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.j.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                MsaIdInterface asInterface = MsaIdInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupported()) {
                        return asInterface.getOAID();
                    }
                    throw new com.beizi.fusion.sm.b.d("MsaIdInterface#isSupported return false");
                }
                throw new com.beizi.fusion.sm.b.d("MsaIdInterface is null");
            }
        });
    }
}
