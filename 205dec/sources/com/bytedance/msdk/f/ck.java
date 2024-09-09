package com.bytedance.msdk.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ck {
    public static int c(int i4) {
        if (i4 != 0) {
            int i5 = 1;
            if (i4 != 1) {
                i5 = 2;
                if (i4 != 2) {
                    i5 = 3;
                    if (i4 != 3) {
                        i5 = 4;
                        if (i4 != 4) {
                            i5 = 5;
                            if (i4 != 5) {
                                return i4;
                            }
                        }
                    }
                }
            }
            return i5;
        }
        return 0;
    }

    public static boolean c(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean sr(Context context) {
        return xv(context) == 3;
    }

    public static boolean ux(Context context) {
        return xv(context) == 2;
    }

    public static int w(Context context) {
        return c(xv(context));
    }

    public static String w(int i4) {
        return i4 != 0 ? i4 != 1 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? i4 != 5 ? "mobile" : "5g" : "4g" : "3g" : "2g" : "wifi" : "unknown";
    }

    public static int xv(Context context) {
        TelephonyManager c4;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 0 : 1;
                } else if (com.bytedance.msdk.core.w.k().y().w() && (c4 = y.c()) != null) {
                    int networkType = c4.getNetworkType();
                    if (networkType != 20) {
                        switch (networkType) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                            case 16:
                                return 2;
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
                                return 3;
                            case 13:
                                return 4;
                            default:
                                return 0;
                        }
                    }
                    return 5;
                } else {
                    return 0;
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
