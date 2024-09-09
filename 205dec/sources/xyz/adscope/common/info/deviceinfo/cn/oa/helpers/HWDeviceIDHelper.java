package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.HWIDInterface;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class HWDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64676a;
    public final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    public ServiceConnection f64677b = new ServiceConnection() { // from class: xyz.adscope.common.info.deviceinfo.cn.oa.helpers.HWDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                HWDeviceIDHelper.this.linkedBlockingQueue.put(iBinder);
            } catch (Exception e4) {
                LogUtil.e(CommonConstants.TAG, "e : " + e4);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public HWDeviceIDHelper(Context context) {
        this.f64676a = context;
    }

    public void getHWID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        try {
            this.f64676a.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        if (this.f64676a.bindService(intent, this.f64677b, 1)) {
            try {
                try {
                    HWIDInterface.HWID hwid = new HWIDInterface.HWID(this.linkedBlockingQueue.take());
                    String iDs = hwid.getIDs();
                    hwid.getBoos();
                    if (appIdsUpdater != null) {
                        appIdsUpdater.OnIdsValid(iDs);
                    }
                } catch (Exception e5) {
                    LogUtil.e(CommonConstants.TAG, "e : " + e5);
                }
            } finally {
                this.f64676a.unbindService(this.f64677b);
            }
        }
    }
}
