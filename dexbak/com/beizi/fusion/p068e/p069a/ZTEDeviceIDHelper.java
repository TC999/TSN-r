package com.beizi.fusion.p068e.p069a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.beizi.fusion.p068e.p069a.DevicesIDsHelper;
import com.beizi.fusion.p068e.p070b.ZTEIDInterface;
import com.bun.miitmdid.content.StringValues;
import java.util.concurrent.LinkedBlockingQueue;

/* renamed from: com.beizi.fusion.e.a.l */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ZTEDeviceIDHelper {

    /* renamed from: a */
    Context f11208a;

    /* renamed from: b */
    String f11209b = "com.mdid.msa";

    /* renamed from: c */
    public final LinkedBlockingQueue<IBinder> f11210c = new LinkedBlockingQueue<>(1);

    /* renamed from: d */
    ServiceConnection f11211d = new ServiceConnection() { // from class: com.beizi.fusion.e.a.l.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ZTEDeviceIDHelper.this.f11210c.put(iBinder);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public ZTEDeviceIDHelper(Context context) {
        this.f11208a = context;
    }

    /* renamed from: a */
    private int m48548a() {
        try {
            this.f11208a.getPackageManager().getPackageInfo(this.f11209b, 0);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: a */
    private void m48546a(String str) {
        m48548a();
        Intent intent = new Intent();
        intent.setClassName(this.f11209b, "com.mdid.msa.service.MsaKlService");
        intent.setAction(StringValues.ACTION_START_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.f11208a.startService(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m48547a(DevicesIDsHelper.InterfaceC3094a interfaceC3094a) {
        try {
            this.f11208a.getPackageManager().getPackageInfo(this.f11209b, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String packageName = this.f11208a.getPackageName();
        m48546a(packageName);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, packageName);
        if (this.f11208a.bindService(intent, this.f11211d, 1)) {
            try {
                String mo48532a = new ZTEIDInterface.AbstractBinderC3110a.C3111a(this.f11210c.take()).mo48532a();
                if (interfaceC3094a != null) {
                    interfaceC3094a.mo48445a(mo48532a);
                }
                this.f11208a.unbindService(this.f11211d);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
