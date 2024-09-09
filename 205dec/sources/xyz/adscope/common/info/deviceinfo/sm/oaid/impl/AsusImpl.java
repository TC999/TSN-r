package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;
import xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService;
import xyz.adscope.common.info.deviceinfo.sm.repeackage.com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AsusImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64723a;

    public AsusImpl(Context context) {
        this.f64723a = context;
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64723a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        OAIDService.bind(this.f64723a, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.info.deviceinfo.sm.oaid.impl.AsusImpl.1
            @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IDidAidlInterface asInterface = IDidAidlInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupport()) {
                        return asInterface.getOAID();
                    }
                    throw new OAIDException("IDidAidlInterface#isSupport return false");
                }
                throw new OAIDException("IDidAidlInterface is null");
            }
        });
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.f64723a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0) != null;
        } catch (Exception e4) {
            OAIDLog.print(e4);
            return false;
        }
    }
}
