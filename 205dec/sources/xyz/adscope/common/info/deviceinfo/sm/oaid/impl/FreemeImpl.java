package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;
import xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService;
import xyz.adscope.common.info.deviceinfo.sm.repeackage.com.android.creator.IdsSupplier;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FreemeImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64729a;

    public FreemeImpl(Context context) {
        this.f64729a = context;
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64729a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("android.service.action.msa");
        intent.setPackage("com.android.creator");
        OAIDService.bind(this.f64729a, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.info.deviceinfo.sm.oaid.impl.FreemeImpl.1
            @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                IdsSupplier asInterface = IdsSupplier.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    return asInterface.getOAID();
                }
                throw new OAIDException("IdsSupplier is null");
            }
        });
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.f64729a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.android.creator", 0) != null;
        } catch (Exception e4) {
            OAIDLog.print(e4);
            return false;
        }
    }
}
