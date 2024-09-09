package com.beizi.fusion.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: DeviceUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class t {
    public static int a(Context context) {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (5 != telephonyManager.getSimState() || (simOperator = telephonyManager.getSimOperator()) == null) {
                return 0;
            }
            if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                if (simOperator.equals("46001")) {
                    return 2;
                }
                return simOperator.equals("46003") ? 3 : 0;
            }
            return 1;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static int b(Context context) {
        return c(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int c(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return 5;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null) {
                return 5;
            }
            int type = activeNetworkInfo.getType();
            if (1 == type) {
                return 4;
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
                        return 6;
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
                        break;
                    case 13:
                    case 18:
                        return 2;
                    case 19:
                    default:
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA")) {
                            if (!subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return 5;
                            }
                        }
                        break;
                    case 20:
                        return 3;
                }
                return 1;
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    public static String d(Context context) {
        try {
            if (((TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone")).getPhoneType() != 0) {
                return "1";
            }
        } catch (Throwable unused) {
            int i4 = context.getResources().getConfiguration().screenLayout & 15;
            if (i4 != 4 && i4 != 3) {
                return "1";
            }
        }
        return "2";
    }

    public static String b() {
        try {
            return Build.MODEL;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String a() {
        try {
            return Build.BRAND;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String c() {
        try {
            return Build.VERSION.SDK_INT + "(" + Build.VERSION.RELEASE + ")";
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
