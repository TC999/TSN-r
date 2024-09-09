package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper;
import xyz.adscope.common.info.deviceinfo.cn.oa.interfaces.LenovoIDInterface;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class LenovoDeviceIDHelper {

    /* renamed from: a  reason: collision with root package name */
    public Context f64679a;

    /* renamed from: b  reason: collision with root package name */
    public LenovoIDInterface f64680b;

    /* renamed from: c  reason: collision with root package name */
    public ServiceConnection f64681c = new ServiceConnection() { // from class: xyz.adscope.common.info.deviceinfo.cn.oa.helpers.LenovoDeviceIDHelper.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            LenovoDeviceIDHelper.this.f64680b = new LenovoIDInterface.len_up.len_down(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public LenovoDeviceIDHelper(Context context) {
        this.f64679a = context;
    }

    public void getIdRun(DevicesIDsHelper.AppIdsUpdater appIdsUpdater) {
        LenovoIDInterface lenovoIDInterface;
        this.f64679a.getPackageName();
        Intent intent = new Intent();
        intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
        if (!this.f64679a.bindService(intent, this.f64681c, 1) || (lenovoIDInterface = this.f64680b) == null) {
            return;
        }
        String a4 = lenovoIDInterface.a();
        if (appIdsUpdater != null) {
            appIdsUpdater.OnIdsValid(a4);
        }
    }
}
