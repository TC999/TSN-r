package com.amap.api.col.p0463l;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.stub.StubApp;

/* renamed from: com.amap.api.col.3l.u3 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ApsServiceCore {

    /* renamed from: a */
    ApsManager f5435a;

    /* renamed from: b */
    Context f5436b;

    /* renamed from: c */
    Messenger f5437c = null;

    public ApsServiceCore(Context context) {
        this.f5435a = null;
        this.f5436b = null;
        this.f5436b = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f5435a = new ApsManager(this.f5436b);
    }

    /* renamed from: a */
    public final IBinder m53804a(Intent intent) {
        this.f5435a.m55303w(intent);
        this.f5435a.m55322d(intent);
        Messenger messenger = new Messenger(this.f5435a.m55307s());
        this.f5437c = messenger;
        return messenger.getBinder();
    }

    /* renamed from: b */
    public final void m53803b() {
        try {
            ApsManager.m55328E();
            this.f5435a.f3855q = C2432j.m51186b();
            this.f5435a.f3856r = C2432j.m51211a();
            this.f5435a.m55323c();
        } catch (Throwable th) {
            C2428b.m51299a(th, "ApsServiceCore", "onCreate");
        }
    }

    /* renamed from: c */
    public final int m53802c() {
        ApsManager apsManager = this.f5435a;
        return (apsManager == null || apsManager.f3864z.isSelfStartServiceEnable()) ? 3 : 2;
    }

    /* renamed from: d */
    public final void m53801d() {
        try {
            ApsManager apsManager = this.f5435a;
            if (apsManager != null) {
                apsManager.m55307s().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "ApsServiceCore", "onDestroy");
        }
    }
}
