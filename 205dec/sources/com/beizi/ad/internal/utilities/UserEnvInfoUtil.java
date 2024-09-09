package com.beizi.ad.internal.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.beizi.ad.c.e;
import com.beizi.ad.lance.a.b;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class UserEnvInfoUtil {
    public static e.d getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return e.d.NET_OTHER;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return e.d.NET_WIFI;
                }
                if (type == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return e.d.NET_2G;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                        case 17:
                            return e.d.NET_3G;
                        case 13:
                        case 18:
                            return e.d.NET_4G;
                        case 19:
                        default:
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return e.d.NET_OTHER;
                            }
                            return e.d.NET_3G;
                        case 20:
                            return e.d.NET_5G;
                    }
                }
            }
            return e.d.NET_OTHER;
        } catch (Throwable th) {
            th.printStackTrace();
            return e.d.NET_OTHER;
        }
    }

    private static e.d getNetworkClass(Context context) {
        return getNetWorkType(context);
    }

    private static int getSubId() {
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                return SubscriptionManager.getDefaultDataSubscriptionId();
            }
            return -1;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean isServiceStateFiveGAvailable(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }

    public static boolean isUsingWifi(Context context) {
        return ((ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    public static void refreshLocation(Context context) {
        UserEnvInfo.getInstance();
    }

    public static void retrieveUserEnvInfo(Context context) {
        if (context != null) {
            UserEnvInfo userEnvInfo = UserEnvInfo.getInstance();
            try {
                userEnvInfo.f14022net = getNetworkClass(context);
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                    String simOperator = telephonyManager.getSimOperator();
                    if (simOperator != null) {
                        if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                            if (simOperator.equals("46001")) {
                                userEnvInfo.isp = e.c.ISP_CN_UNICOM;
                            } else if (simOperator.equals("46003")) {
                                userEnvInfo.isp = e.c.ISP_CN_TEL;
                            }
                        }
                        userEnvInfo.isp = e.c.ISP_CN_MOBILE;
                    } else {
                        userEnvInfo.isp = e.c.ISP_UNKNOWN;
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            userEnvInfo.ip = b.a("MC4wLjAuMA==");
            refreshLocation(context);
        }
    }
}
