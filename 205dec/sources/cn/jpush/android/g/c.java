package cn.jpush.android.g;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class c {
    public static boolean a(Context context, String str) {
        ServiceInfo[] serviceInfoArr;
        try {
            serviceInfoArr = context.getPackageManager().getPackageInfo(str, 4).services;
        } catch (PackageManager.NameNotFoundException unused) {
            serviceInfoArr = null;
        }
        if (serviceInfoArr == null) {
            cn.jpush.android.i.b.a("ConnectionFactory", "not found service by:" + str);
            return false;
        }
        for (int i4 = 0; i4 < serviceInfoArr.length; i4++) {
            cn.jpush.android.i.b.a("ConnectionFactory", "serviceInfos:" + serviceInfoArr[i4].name);
            if ("cn.jpush.android.service.PushManagerService".equalsIgnoreCase(serviceInfoArr[i4].name)) {
                return true;
            }
        }
        return false;
    }
}
