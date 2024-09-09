package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.SamsungIDInterface;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class SamsungDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64695a;
    public final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    public ServiceConnection f64696b = new ServiceConnection() { // from class: xyz.adscope.common.info.deviceinfo.cn.oa.helpers.SamsungDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                SamsungDeviceIDHelper.this.linkedBlockingQueue.put(iBinder);
            } catch (Exception e4) {
                LogUtil.e(CommonConstants.TAG, "e : " + e4);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public SamsungDeviceIDHelper(Context context) {
        this.f64695a = context;
    }

    public void getSumsungID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        try {
            this.f64695a.getPackageManager().getPackageInfo("com.samsung.android.deviceidservice", 0);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.f64695a.bindService(intent, this.f64696b, 1)) {
            try {
                String id = new SamsungIDInterface.Proxy(this.linkedBlockingQueue.take()).getID();
                if (appIdsUpdater != null) {
                    appIdsUpdater.OnIdsValid(id);
                }
            } catch (Exception e5) {
                LogUtil.e(CommonConstants.TAG, "e : " + e5);
            }
        }
    }
}
