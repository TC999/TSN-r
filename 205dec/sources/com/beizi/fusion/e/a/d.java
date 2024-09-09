package com.beizi.fusion.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.e.a.b;
import com.beizi.fusion.e.b.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: LenovoDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    com.beizi.fusion.e.b.c f14697a;

    /* renamed from: b  reason: collision with root package name */
    ServiceConnection f14698b = new ServiceConnection() { // from class: com.beizi.fusion.e.a.d.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            d.this.f14697a = new c.a.C0138a(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private Context f14699c;

    public d(Context context) {
        this.f14699c = context;
    }

    public void a(b.a aVar) {
        com.beizi.fusion.e.b.c cVar;
        this.f14699c.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.f14699c.bindService(intent, this.f14698b, 1) || (cVar = this.f14697a) == null) {
            return;
        }
        String a4 = cVar.a();
        if (aVar != null) {
            aVar.a(a4);
        }
    }
}
