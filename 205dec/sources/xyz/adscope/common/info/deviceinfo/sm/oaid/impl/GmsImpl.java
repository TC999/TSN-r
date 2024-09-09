package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;
import xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService;
import xyz.adscope.common.info.deviceinfo.sm.repeackage.com.google.android.gms.ads.identifier.internal.IAdvertisingIdService;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class GmsImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64731a;

    public GmsImpl(Context context) {
        this.f64731a = context;
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64731a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        OAIDService.bind(this.f64731a, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.info.deviceinfo.sm.oaid.impl.GmsImpl.1
            @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IAdvertisingIdService asInterface = IAdvertisingIdService.Stub.asInterface(iBinder);
                if (asInterface.isLimitAdTrackingEnabled(true)) {
                    OAIDLog.print("User has disabled advertising identifier");
                }
                return asInterface.getId();
            }
        });
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.f64731a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.vending", 0) != null;
        } catch (Exception e4) {
            OAIDLog.print(e4);
            return false;
        }
    }
}
