package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bun.miitmdid.content.StringValues;
import java.util.concurrent.LinkedBlockingQueue;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.ZTEIDInterface;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ZTEDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64708a;

    /* renamed from: b  reason: collision with root package name */
    public String f64709b = "com.mdid.msa";
    public final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f64710c = new ServiceConnection() { // from class: xyz.adscope.common.info.deviceinfo.cn.oa.helpers.ZTEDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ZTEDeviceIDHelper.this.linkedBlockingQueue.put(iBinder);
            } catch (Exception e4) {
                LogUtil.e(CommonConstants.TAG, "e : " + e4);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public ZTEDeviceIDHelper(Context context) {
        this.f64708a = context;
    }

    public final int a() {
        try {
            this.f64708a.getPackageManager().getPackageInfo(this.f64709b, 0);
            return 1;
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
            return 0;
        }
    }

    public final void a(String str) {
        a();
        Intent intent = new Intent();
        intent.setClassName(this.f64709b, "com.mdid.msa.service.MsaKlService");
        intent.setAction(StringValues.ACTION_START_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, str);
        try {
            intent.putExtra("com.bun.msa.param.runinset", true);
            this.f64708a.startService(intent);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
    }

    public void getID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        try {
            this.f64708a.getPackageManager().getPackageInfo(this.f64709b, 0);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
        String packageName = this.f64708a.getPackageName();
        a(packageName);
        Intent intent = new Intent();
        intent.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
        intent.setAction(StringValues.ACTION_BINDTO_MSASERVICE);
        intent.putExtra(StringValues.PARAM_BIND_PKGNAME, packageName);
        if (this.f64708a.bindService(intent, this.f64710c, 1)) {
            try {
                String oaid = new ZTEIDInterface.up.down(this.linkedBlockingQueue.take()).getOAID();
                if (appIdsUpdater != null) {
                    appIdsUpdater.OnIdsValid(oaid);
                }
                this.f64708a.unbindService(this.f64710c);
            } catch (Exception e5) {
                LogUtil.e(CommonConstants.TAG, "e : " + e5);
            }
        }
    }
}
