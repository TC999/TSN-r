package xyz.adscope.common.info.deviceinfo.sm.oaid.impl;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.stub.StubApp;
import java.security.MessageDigest;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IGetter;
import xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDException;
import xyz.adscope.common.info.deviceinfo.sm.oaid.OAIDLog;
import xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService;
import xyz.adscope.common.info.deviceinfo.sm.repeackage.com.heytap.openid.IOpenID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class OppoImpl implements IOAID {

    /* renamed from: a  reason: collision with root package name */
    public final Context f64747a;

    /* renamed from: b  reason: collision with root package name */
    public String f64748b;

    public OppoImpl(Context context) {
        this.f64747a = context instanceof Application ? context : StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    public final String a(IBinder iBinder) {
        String packageName = this.f64747a.getPackageName();
        String str = this.f64748b;
        if (str == null) {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(this.f64747a.getPackageManager().getPackageInfo(packageName, 64).signatures[0].toByteArray());
            StringBuilder sb = new StringBuilder();
            for (byte b4 : digest) {
                sb.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
            }
            String sb2 = sb.toString();
            this.f64748b = sb2;
            return a(iBinder, packageName, sb2);
        }
        return a(iBinder, packageName, str);
    }

    public final String a(IBinder iBinder, String str, String str2) {
        IOpenID asInterface = IOpenID.Stub.asInterface(iBinder);
        if (asInterface != null) {
            return asInterface.getSerID(str, str2, "OUID");
        }
        throw new OAIDException("IOpenID is null");
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public void doGet(IGetter iGetter) {
        if (this.f64747a == null || iGetter == null) {
            return;
        }
        Intent intent = new Intent("action.com.heytap.openid.OPEN_ID_SERVICE");
        intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
        OAIDService.bind(this.f64747a, intent, iGetter, new OAIDService.RemoteCaller() { // from class: xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OppoImpl.1
            @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.impl.OAIDService.RemoteCaller
            public String callRemoteInterface(IBinder iBinder) {
                try {
                    return OppoImpl.this.a(iBinder);
                } catch (RemoteException e4) {
                    throw e4;
                } catch (OAIDException e5) {
                    throw e5;
                } catch (Exception e6) {
                    throw new OAIDException(e6);
                }
            }
        });
    }

    @Override // xyz.adscope.common.info.deviceinfo.sm.oaid.IOAID
    public boolean supported() {
        Context context = this.f64747a;
        if (context == null) {
            return false;
        }
        try {
            return context.getPackageManager().getPackageInfo("com.heytap.openid", 0) != null;
        } catch (Exception e4) {
            OAIDLog.print(e4);
            return false;
        }
    }
}
