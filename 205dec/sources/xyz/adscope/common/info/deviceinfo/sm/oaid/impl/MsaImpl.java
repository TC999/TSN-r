package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;
import xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService;
import xyz.adscope.common.info.deviceinfo.sm.repeackage.com.bun.lib.MsaIdInterface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class MsaImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64739a;

    public MsaImpl(Context context) {
        this.f64739a = context;
    }

    public final void a() {
        try {
            Intent intent = new Intent(StringValues.ACTION_START_MSASERVICE);
            intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaKlService");
            intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f64739a.getPackageName());
            if (Build.VERSION.SDK_INT < 26) {
                this.f64739a.startService(intent);
            } else {
                this.f64739a.startForegroundService(intent);
            }
        } catch (Exception e4) {
            OAIDLog.print(e4);
        }
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64739a == null || iGetter == null) {
            return;
        }
        a();
        Intent intent = new Intent(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, this.f64739a.getPackageName());
        OAIDService.bind(this.f64739a, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.info.deviceinfo.sm.oaid.impl.MsaImpl.1
            @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                MsaIdInterface asInterface = MsaIdInterface.Stub.asInterface(iBinder);
                if (asInterface != null) {
                    if (asInterface.isSupported()) {
                        return asInterface.getOAID();
                    }
                    throw new OAIDException("MsaIdInterface#isSupported return false");
                }
                throw new OAIDException("MsaIdInterface is null");
            }
        });
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.f64739a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.mdid.msa", 0) != null;
        } catch (Exception e4) {
            OAIDLog.print(e4);
            return false;
        }
    }
}
