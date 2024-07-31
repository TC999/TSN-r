package com.mbridge.msdk.optimize.p498a.p499a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;
import com.mbridge.msdk.optimize.p498a.OaidCallback;
import com.mbridge.msdk.optimize.p498a.p500b.InterfaceC11541f;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.mbridge.msdk.optimize.a.a.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ZTEDeviceHelper {

    /* renamed from: a */
    Context f31644a;

    /* renamed from: b */
    String f31645b = "com.mdid.msa";

    /* renamed from: c */
    public final LinkedBlockingQueue<IBinder> f31646c = new LinkedBlockingQueue<>(1);

    /* renamed from: d */
    ServiceConnection f31647d = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.i.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ZTEDeviceHelper.this.f31646c.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public ZTEDeviceHelper(Context context) {
        this.f31644a = context;
    }

    /* renamed from: a */
    private int m21353a() {
        try {
            this.f31644a.getPackageManager().getPackageInfo(this.f31645b, 0);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    public final void m21352a(OaidCallback oaidCallback) {
        try {
            this.f31644a.getPackageManager().getPackageInfo(this.f31645b, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String packageName = this.f31644a.getPackageName();
        m21353a();
        Intent intent = new Intent();
        intent.setClassName(this.f31645b, "com.mdid.msa.service.MsaKlService");
        intent.setAction(StringValues.ACTION_START_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, packageName);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.f31644a.startService(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        Intent intent2 = new Intent();
        intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent2.setAction(StringValues.ACTION_BINDTO_MSASERVICE);
        intent2.putExtra(StringValues.PARAM_BIND_PKGNAME, packageName);
        try {
            if (this.f31644a.bindService(intent2, this.f31647d, 1)) {
                try {
                    String mo21338a = new InterfaceC11541f.AbstractBinderC11542a.C11543a(this.f31646c.take()).mo21338a();
                    if (oaidCallback != null) {
                        oaidCallback.mo21350a(mo21338a, false);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        } finally {
            this.f31644a.unbindService(this.f31647d);
        }
    }
}
