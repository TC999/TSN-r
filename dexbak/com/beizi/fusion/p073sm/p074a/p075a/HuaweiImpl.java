package com.beizi.fusion.p073sm.p074a.p075a;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Settings;
import android.text.TextUtils;
import com.beizi.fusion.p073sm.p074a.IGetter;
import com.beizi.fusion.p073sm.p074a.IOAID;
import com.beizi.fusion.p073sm.p074a.OAIDException;
import com.beizi.fusion.p073sm.p074a.OAIDLog;
import com.beizi.fusion.p073sm.p074a.p075a.OAIDService;
import com.beizi.fusion.p073sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.beizi.fusion.sm.a.a.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HuaweiImpl implements IOAID {

    /* renamed from: a */
    private final Context f11498a;

    /* renamed from: b */
    private String f11499b;

    public HuaweiImpl(Context context) {
        this.f11498a = context;
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public boolean mo48132a() {
        Context context = this.f11498a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                this.f11499b = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
                this.f11499b = "com.huawei.hwid.tv";
            } else {
                this.f11499b = "com.huawei.hms";
                if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            OAIDLog.m48130a(e);
            return false;
        }
    }

    @Override // com.beizi.fusion.p073sm.p074a.IOAID
    /* renamed from: a */
    public void mo48131a(IGetter iGetter) {
        Context context = this.f11498a;
        if (context == null || iGetter == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    OAIDLog.m48130a("Get oaid from global settings: " + string);
                    iGetter.mo48133a(string);
                    return;
                }
            } catch (Exception e) {
                OAIDLog.m48130a(e);
            }
        }
        if (TextUtils.isEmpty(this.f11499b) && !mo48132a()) {
            iGetter.mo48134a(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f11499b);
        OAIDService.m48142a(this.f11498a, intent, iGetter, new OAIDService.InterfaceC3201a() { // from class: com.beizi.fusion.sm.a.a.g.1
            @Override // com.beizi.fusion.p073sm.p074a.p075a.OAIDService.InterfaceC3201a
            /* renamed from: a */
            public String mo48137a(IBinder iBinder) throws OAIDException, RemoteException {
                OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
                if (!asInterface.isOaidTrackLimited()) {
                    return asInterface.getOaid();
                }
                throw new OAIDException("User has disabled advertising identifier");
            }
        });
    }
}
