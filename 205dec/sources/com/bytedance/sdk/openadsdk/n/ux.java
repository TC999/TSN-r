package com.bytedance.sdk.openadsdk.n;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.fp;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class ux implements fp {
    private static boolean w(Context context, TelephonyManager telephonyManager) {
        ServiceState serviceState;
        if (context != null && Build.VERSION.SDK_INT >= 29 && context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
            try {
                int c4 = c();
                if (c4 == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(c4));
                }
                return c(serviceState);
            } catch (Exception unused) {
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.utils.fp
    public boolean c(Context context, TelephonyManager telephonyManager) {
        return w(context, telephonyManager);
    }

    private static int c() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    private static boolean c(ServiceState serviceState) {
        try {
            Method method = serviceState.getClass().getMethod("getNrState", new Class[0]);
            if (method != null) {
                method.setAccessible(true);
                int intValue = ((Integer) method.invoke(serviceState, new Object[0])).intValue();
                return intValue == 3 || intValue == 2;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
