package com.beizi.fusion.p072g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.stub.StubApp;

/* renamed from: com.beizi.fusion.g.t */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class DeviceUtil {
    /* renamed from: a */
    public static int m48218a(Context context) {
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

    /* renamed from: b */
    public static int m48216b(Context context) {
        return m48214c(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: c */
    public static int m48214c(Context context) {
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

    /* renamed from: d */
    public static String m48213d(Context context) {
        try {
            if (((TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone")).getPhoneType() != 0) {
                return "1";
            }
        } catch (Throwable unused) {
            int i = context.getResources().getConfiguration().screenLayout & 15;
            if (i != 4 && i != 3) {
                return "1";
            }
        }
        return "2";
    }

    /* renamed from: b */
    public static String m48217b() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static String m48219a() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    public static String m48215c() {
        try {
            return Build.VERSION.SDK_INT + "(" + Build.VERSION.RELEASE + ")";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
