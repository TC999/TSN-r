package com.beizi.fusion.e.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.e.a.b;
import com.beizi.fusion.e.b.g;
import com.bun.miitmdid.content.StringValues;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ZTEDeviceIDHelper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    Context f14726a;

    /* renamed from: b  reason: collision with root package name */
    String f14727b = "com.mdid.msa";

    /* renamed from: c  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f14728c = new LinkedBlockingQueue<>(1);

    /* renamed from: d  reason: collision with root package name */
    ServiceConnection f14729d = new ServiceConnection() { // from class: com.beizi.fusion.e.a.l.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                l.this.f14728c.put(iBinder);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public l(Context context) {
        this.f14726a = context;
    }

    private int a() {
        try {
            this.f14726a.getPackageManager().getPackageInfo(this.f14727b, 0);
            return 1;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    private void a(String str) {
        a();
        Intent intent = new Intent();
        intent.setClassName(this.f14727b, "com.mdid.msa.service.MsaKlService");
        intent.setAction(StringValues.ACTION_START_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.f14726a.startService(intent);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(b.a aVar) {
        try {
            this.f14726a.getPackageManager().getPackageInfo(this.f14727b, 0);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        String packageName = this.f14726a.getPackageName();
        a(packageName);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, packageName);
        if (this.f14726a.bindService(intent, this.f14729d, 1)) {
            try {
                String a4 = new g.a.C0141a(this.f14728c.take()).a();
                if (aVar != null) {
                    aVar.a(a4);
                }
                this.f14726a.unbindService(this.f14729d);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}
