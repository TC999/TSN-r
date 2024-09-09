package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.stub.StubApp;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;
import xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService;
import xyz.adscope.common.info.deviceinfo.sm.repeackage.com.coolpad.deviceidsupport.IDeviceIdManager;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CoolpadImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64725a;

    public CoolpadImpl(Context context) {
        this.f64725a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64725a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.coolpad.deviceidsupport", "com.coolpad.deviceidsupport.DeviceIdService"));
        OAIDService.bind(this.f64725a, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.info.deviceinfo.sm.oaid.impl.CoolpadImpl.1
            @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IDeviceIdManager asInterface = IDeviceIdManager.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID(CoolpadImpl.this.f64725a.getPackageName());
                }
                throw new OAIDException("IDeviceIdManager is null");
            }
        });
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.f64725a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.coolpad.deviceidsupport", 0) != null;
        } catch (Exception e4) {
            OAIDLog.print(e4);
            return false;
        }
    }
}
