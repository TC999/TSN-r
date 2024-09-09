package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.Signature;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import java.security.MessageDigest;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.OppoIDInterface;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class OppoDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64690a;

    /* renamed from: b  reason: collision with root package name */
    public String f64691b;

    /* renamed from: c  reason: collision with root package name */
    public OppoIDInterface f64692c;
    public String oaid = "OUID";

    /* renamed from: d  reason: collision with root package name */
    public ServiceConnection f64693d = new ServiceConnection() { // from class: xyz.adscope.common.info.deviceinfo.cn.oa.helpers.OppoDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            OppoDeviceIDHelper.this.f64692c = OppoIDInterface.up.genInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            OppoDeviceIDHelper.this.f64692c = null;
        }
    };

    public OppoDeviceIDHelper(Context context) {
        this.f64690a = context;
    }

    public final String a(String str) {
        Signature[] signatureArr;
        String packageName = this.f64690a.getPackageName();
        if (this.f64691b == null) {
            String str2 = null;
            try {
                signatureArr = this.f64690a.getPackageManager().getPackageInfo(packageName, 64).signatures;
            } catch (Exception e4) {
                LogUtil.e(CommonConstants.TAG, "e : " + e4);
                signatureArr = null;
            }
            if (signatureArr != null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b4 : digest) {
                            sb.append(Integer.toHexString((b4 & 255) | 256).substring(1, 3));
                        }
                        str2 = sb.toString();
                    }
                } catch (Exception e5) {
                    LogUtil.e(CommonConstants.TAG, "e : " + e5);
                }
            }
            this.f64691b = str2;
        }
        return ((OppoIDInterface.up.down) this.f64692c).getSerID(packageName, this.f64691b, str);
    }

    public String getID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            if (this.f64690a.bindService(intent, this.f64693d, 1)) {
                try {
                    SystemClock.sleep(3000L);
                } catch (Exception e4) {
                    LogUtil.e(CommonConstants.TAG, "e : " + e4);
                }
                if (this.f64692c != null) {
                    String a4 = a("OUID");
                    if (appIdsUpdater != null) {
                        appIdsUpdater.OnIdsValid(a4);
                        return a4;
                    }
                    return a4;
                }
            }
            return null;
        }
        throw new IllegalStateException("Cannot run on MainThread");
    }
}
