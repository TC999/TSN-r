package com.mbridge.msdk.optimize.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;
import com.mbridge.msdk.optimize.a.b.f;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: ZTEDeviceHelper.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    Context f40417a;

    /* renamed from: b  reason: collision with root package name */
    String f40418b = "com.mdid.msa";

    /* renamed from: c  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f40419c = new LinkedBlockingQueue<>(1);

    /* renamed from: d  reason: collision with root package name */
    ServiceConnection f40420d = new ServiceConnection() { // from class: com.mbridge.msdk.optimize.a.a.i.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                i.this.f40419c.put(iBinder);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public i(Context context) {
        this.f40417a = context;
    }

    private int a() {
        try {
            this.f40417a.getPackageManager().getPackageInfo(this.f40418b, 0);
            return 1;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public final void a(com.mbridge.msdk.optimize.a.b bVar) {
        try {
            this.f40417a.getPackageManager().getPackageInfo(this.f40418b, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        String packageName = this.f40417a.getPackageName();
        a();
        Intent intent = new Intent();
        intent.setClassName(this.f40418b, "com.mdid.msa.service.MsaKlService");
        intent.setAction(StringValues.ACTION_START_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, packageName);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.f40417a.startService(intent);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        Intent intent2 = new Intent();
        intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent2.setAction(StringValues.ACTION_BINDTO_MSASERVICE);
        intent2.putExtra(StringValues.PARAM_BIND_PKGNAME, packageName);
        try {
            if (this.f40417a.bindService(intent2, this.f40420d, 1)) {
                try {
                    String a4 = new f.a.C0758a(this.f40419c.take()).a();
                    if (bVar != null) {
                        bVar.a(a4, false);
                    }
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        } finally {
            this.f40417a.unbindService(this.f40420d);
        }
    }
}
