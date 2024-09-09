package com.beizi.fusion.sm.b.a;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.beizi.fusion.sm.b.a.m;
import com.beizi.fusion.sm.repeackage.com.android.creator.IdsSupplier;

/* compiled from: FreemeImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class e implements com.beizi.fusion.sm.b.c {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15081a;

    public e(Context context) {
        this.f15081a = context;
    }

    @Override // com.beizi.fusion.sm.b.c
    public boolean a() {
        Context context = this.f15081a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e4) {
            com.beizi.fusion.sm.b.e.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.b.c
    public void a(com.beizi.fusion.sm.b.b bVar) {
        if (this.f15081a == null || bVar == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        m.a(this.f15081a, intent, bVar, new m.a() { // from class: com.beizi.fusion.sm.b.a.e.1
            @Override // com.beizi.fusion.sm.b.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.b.d, RemoteException {
                IdsSupplier asInterface = IdsSupplier.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID();
                }
                throw new com.beizi.fusion.sm.b.d("IdsSupplier is null");
            }
        });
    }
}
