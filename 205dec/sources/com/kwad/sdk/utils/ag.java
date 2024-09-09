package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.stub.StubApp;
import java.net.InetAddress;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ag {
    private static int aPt;
    private static boolean aPu;

    @Nullable
    @SuppressLint({"MissingPermission"})
    public static NetworkInfo cj(Context context) {
        ConnectivityManager connectivityManager;
        if (SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static int ck(Context context) {
        if (context != null && SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE") && SystemUtil.b(context, "android.permission.READ_PHONE_STATE")) {
            try {
                NetworkInfo cj = cj(context);
                if (!(cj != null && cj.isConnected())) {
                    return 0;
                }
                if (1 == cj.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone");
                if (telephonyManager != null) {
                    int m4 = m(context, telephonyManager.getNetworkType());
                    if (m4 != 20) {
                        switch (m4) {
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
                                return 3;
                            case 13:
                                return 4;
                            default:
                                return 0;
                        }
                    }
                    return 5;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public static int d(Context context, String str, boolean z3) {
        if (context != null && aPt <= 0 && !aPu) {
            try {
                if (!z3) {
                    TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone");
                    if (Build.VERSION.SDK_INT >= 22) {
                        String simOperator = telephonyManager.getSimOperator();
                        char c4 = '\uffff';
                        int hashCode = simOperator.hashCode();
                        if (hashCode != 49679502) {
                            switch (hashCode) {
                                case 49679470:
                                    if (simOperator.equals("46000")) {
                                        c4 = 0;
                                        break;
                                    }
                                    break;
                                case 49679471:
                                    if (simOperator.equals("46001")) {
                                        c4 = 4;
                                        break;
                                    }
                                    break;
                                case 49679472:
                                    if (simOperator.equals("46002")) {
                                        c4 = 1;
                                        break;
                                    }
                                    break;
                                case 49679473:
                                    if (simOperator.equals("46003")) {
                                        c4 = 7;
                                        break;
                                    }
                                    break;
                                default:
                                    switch (hashCode) {
                                        case 49679475:
                                            if (simOperator.equals("46005")) {
                                                c4 = '\b';
                                                break;
                                            }
                                            break;
                                        case 49679476:
                                            if (simOperator.equals("46006")) {
                                                c4 = 5;
                                                break;
                                            }
                                            break;
                                        case 49679477:
                                            if (simOperator.equals("46007")) {
                                                c4 = 2;
                                                break;
                                            }
                                            break;
                                        case 49679478:
                                            if (simOperator.equals("46008")) {
                                                c4 = 3;
                                                break;
                                            }
                                            break;
                                        case 49679479:
                                            if (simOperator.equals("46009")) {
                                                c4 = 6;
                                                break;
                                            }
                                            break;
                                    }
                            }
                        } else if (simOperator.equals("46011")) {
                            c4 = '\t';
                        }
                        switch (c4) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                aPt = 1;
                                break;
                            case 4:
                            case 5:
                            case 6:
                                aPt = 3;
                                break;
                            case 7:
                            case '\b':
                            case '\t':
                                aPt = 2;
                                break;
                            default:
                                aPt = 0;
                                break;
                        }
                    }
                } else {
                    aPt = 0;
                }
                if (aPt == 0 && !TextUtils.isEmpty(str)) {
                    if (!str.startsWith("46000") && !str.startsWith("46002")) {
                        if (str.startsWith("46001")) {
                            aPt = 3;
                        } else if (str.startsWith("46003")) {
                            aPt = 2;
                        }
                    }
                    aPt = 1;
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            }
            int i4 = aPt;
            aPu = i4 == 0;
            return i4;
        }
        return aPt;
    }

    private static boolean gC(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    public static boolean gD(String str) {
        return t(str, 3000);
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj == null) {
                return -1;
            }
            return cj.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    private static int getSubId() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static boolean isMobileConnected(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj != null && cj.isConnected()) {
                if (cj.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj != null) {
                if (cj.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo cj = cj(context);
            if (cj != null && cj.isConnected()) {
                return 1 == cj.getType();
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    private static int m(Context context, int i4) {
        ServiceState serviceState;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 26 || !SystemUtil.b(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return i4;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i4;
            }
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else {
                serviceState = (context.getApplicationInfo().targetSdkVersion < 29 || i5 < 29) ? (ServiceState) s.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId)) : telephonyManager.getServiceState();
            }
            if (serviceState == null) {
                return i4;
            }
            if (at.Md()) {
                Integer num = (Integer) s.a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i4;
            } else if (gC(serviceState.toString())) {
                return 20;
            } else {
                return i4;
            }
        } catch (Exception unused) {
            return i4;
        }
    }

    @WorkerThread
    private static boolean t(String str, int i4) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
