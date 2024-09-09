package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.ASUSIDInterface;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class ASUSDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64672a;
    public final LinkedBlockingQueue<IBinder> linkedBlockingQueue = new LinkedBlockingQueue<>(1);

    /* renamed from: b  reason: collision with root package name */
    public ServiceConnection f64673b = new ServiceConnection() { // from class: xyz.adscope.common.info.deviceinfo.cn.oa.helpers.ASUSDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                ASUSDeviceIDHelper.this.linkedBlockingQueue.put(iBinder);
            } catch (Exception e4) {
                LogUtil.e(CommonConstants.TAG, "e : " + e4);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public ASUSDeviceIDHelper(Context context) {
        this.f64672a = context;
    }

    public void getID(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        try {
            this.f64672a.getPackageManager().getPackageInfo("com.asus.msa.SupplementaryDID", 0);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "e : " + e4);
        }
        Intent intent = new Intent();
        intent.setAction("com.asus.msa.action.ACCESS_DID");
        intent.setComponent(new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService"));
        if (this.f64672a.bindService(intent, this.f64673b, 1)) {
            try {
                String id = new ASUSIDInterface.ASUSID(this.linkedBlockingQueue.take()).getID();
                if (appIdsUpdater != null) {
                    appIdsUpdater.OnIdsValid(id);
                }
            } catch (Exception e5) {
                LogUtil.e(CommonConstants.TAG, "e : " + e5);
            }
        }
    }
}
