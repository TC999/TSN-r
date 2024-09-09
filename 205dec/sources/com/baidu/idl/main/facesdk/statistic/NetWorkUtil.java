package com.baidu.idl.main.facesdk.statistic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class NetWorkUtil {
    public static Integer getNetworkState(Context context) {
        NetworkInfo activeNetworkInfo;
        int i4 = 0;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            i4 = 1;
        } else if (type == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (subtype == 13 && !telephonyManager.isNetworkRoaming()) {
                i4 = 4;
            } else if (subtype == 3 || subtype == 5 || subtype == 6 || subtype == 8 || subtype == 9 || subtype == 10 || subtype == 12 || subtype == 14 || (subtype == 15 && !telephonyManager.isNetworkRoaming())) {
                i4 = 3;
            } else if (subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || (subtype == 11 && !telephonyManager.isNetworkRoaming())) {
                i4 = 2;
            }
        } else if (type == 9) {
            i4 = 5;
        }
        return Integer.valueOf(i4);
    }
}
