package com.beizi.fusion.sm.a.a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.beizi.fusion.sm.a.a.m;
import com.beizi.fusion.sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* compiled from: HuaweiImpl.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
class g implements com.beizi.fusion.sm.a.d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15048a;

    /* renamed from: b  reason: collision with root package name */
    private String f15049b;

    public g(Context context) {
        this.f15048a = context;
    }

    @Override // com.beizi.fusion.sm.a.d
    public boolean a() {
        Context context = this.f15048a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f15049b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f15049b = "com.huawei.hwid.tv";
            } else {
                this.f15049b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e4) {
            com.beizi.fusion.sm.a.f.a(e4);
            return false;
        }
    }

    @Override // com.beizi.fusion.sm.a.d
    public void a(com.beizi.fusion.sm.a.c cVar) {
        Context context = this.f15048a;
        if (context == null || cVar == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    com.beizi.fusion.sm.a.f.a("Get oaid from global settings: " + string);
                    cVar.a(string);
                    return;
                }
            } catch (Exception e4) {
                com.beizi.fusion.sm.a.f.a(e4);
            }
        }
        if (TextUtils.isEmpty(this.f15049b) && !a()) {
            cVar.a(new com.beizi.fusion.sm.a.e("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f15049b);
        m.a(this.f15048a, intent, cVar, new m.a() { // from class: com.beizi.fusion.sm.a.a.g.1
            @Override // com.beizi.fusion.sm.a.a.m.a
            public String a(IBinder iBinder) throws com.beizi.fusion.sm.a.e, RemoteException {
                OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
                if (!asInterface.isOaidTrackLimited()) {
                    return asInterface.getOaid();
                }
                throw new com.beizi.fusion.sm.a.e("User has disabled advertising identifier");
            }
        });
    }
}
