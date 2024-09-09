package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;
import xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService;
import xyz.adscope.common.info.deviceinfo.sm.repeackage.com.uodis.opendevice.aidl.OpenDeviceIdentifierService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class HuaweiImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64733a;

    /* renamed from: b  reason: collision with root package name */
    public String f64734b;

    public HuaweiImpl(Context context) {
        this.f64733a = context;
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        Context context = this.f64733a;
        if (context == null || iGetter == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                if (!TextUtils.isEmpty(string)) {
                    OAIDLog.print("Get oaid from global settings: " + string);
                    iGetter.onOAIDGetComplete(string);
                    return;
                }
            } catch (Exception e4) {
                OAIDLog.print(e4);
            }
        }
        if (TextUtils.isEmpty(this.f64734b) && !supported()) {
            iGetter.onOAIDGetError(new OAIDException("Huawei Advertising ID not available"));
            return;
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage(this.f64734b);
        OAIDService.bind(this.f64733a, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.info.deviceinfo.sm.oaid.impl.HuaweiImpl.1
            @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                OpenDeviceIdentifierService asInterface = OpenDeviceIdentifierService.Stub.asInterface(iBinder);
                if (asInterface.isOaidTrackLimited()) {
                    throw new OAIDException("User has disabled advertising identifier");
                }
                return asInterface.getOaid();
            }
        });
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        String str = "com.huawei.hwid";
        Context context = this.f64733a;
        if (context == null) {
            return false;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) == null) {
                if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                    this.f64734b = "com.huawei.hms";
                    if (packageManager.getPackageInfo("com.huawei.hms", 0) == null) {
                        return false;
                    }
                    return true;
                }
                str = "com.huawei.hwid.tv";
            }
            this.f64734b = str;
            return true;
        } catch (Exception e4) {
            OAIDLog.print(e4);
            return false;
        }
    }
}
