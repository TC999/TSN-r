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
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.core.p397e.C10331c;
import com.stub.StubApp;
import java.net.InetAddress;

/* renamed from: com.kwad.sdk.utils.ag */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11013ag {
    private static int aPt;
    private static boolean aPu;

    @Nullable
    @SuppressLint({"MissingPermission"})
    /* renamed from: cj */
    public static NetworkInfo m24133cj(Context context) {
        ConnectivityManager connectivityManager;
        if (SystemUtil.m24270b(context, C7282g.f24944b) && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    /* renamed from: ck */
    public static int m24132ck(Context context) {
        if (context != null && SystemUtil.m24270b(context, C7282g.f24944b) && SystemUtil.m24270b(context, C7282g.f24945c)) {
            try {
                NetworkInfo m24133cj = m24133cj(context);
                if (!(m24133cj != null && m24133cj.isConnected())) {
                    return 0;
                }
                if (1 == m24133cj.getType()) {
                    return 100;
                }
                TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone");
                if (telephonyManager != null) {
                    int m24128m = m24128m(context, telephonyManager.getNetworkType());
                    if (m24128m != 20) {
                        switch (m24128m) {
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

    /* renamed from: d */
    public static int m24131d(Context context, String str, boolean z) {
        if (context != null && aPt <= 0 && !aPu) {
            try {
                if (!z) {
                    TelephonyManager telephonyManager = (TelephonyManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("phone");
                    if (Build.VERSION.SDK_INT >= 22) {
                        String simOperator = telephonyManager.getSimOperator();
                        char c = 65535;
                        int hashCode = simOperator.hashCode();
                        if (hashCode != 49679502) {
                            switch (hashCode) {
                                case 49679470:
                                    if (simOperator.equals("46000")) {
                                        c = 0;
                                        break;
                                    }
                                    break;
                                case 49679471:
                                    if (simOperator.equals("46001")) {
                                        c = 4;
                                        break;
                                    }
                                    break;
                                case 49679472:
                                    if (simOperator.equals("46002")) {
                                        c = 1;
                                        break;
                                    }
                                    break;
                                case 49679473:
                                    if (simOperator.equals("46003")) {
                                        c = 7;
                                        break;
                                    }
                                    break;
                                default:
                                    switch (hashCode) {
                                        case 49679475:
                                            if (simOperator.equals("46005")) {
                                                c = '\b';
                                                break;
                                            }
                                            break;
                                        case 49679476:
                                            if (simOperator.equals("46006")) {
                                                c = 5;
                                                break;
                                            }
                                            break;
                                        case 49679477:
                                            if (simOperator.equals("46007")) {
                                                c = 2;
                                                break;
                                            }
                                            break;
                                        case 49679478:
                                            if (simOperator.equals("46008")) {
                                                c = 3;
                                                break;
                                            }
                                            break;
                                        case 49679479:
                                            if (simOperator.equals("46009")) {
                                                c = 6;
                                                break;
                                            }
                                            break;
                                    }
                            }
                        } else if (simOperator.equals("46011")) {
                            c = '\t';
                        }
                        switch (c) {
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
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
            int i = aPt;
            aPu = i == 0;
            return i;
        }
        return aPt;
    }

    /* renamed from: gC */
    private static boolean m24130gC(@NonNull String str) {
        return str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED");
    }

    @WorkerThread
    /* renamed from: gD */
    public static boolean m24129gD(String str) {
        return m24127t(str, 3000);
    }

    public static int getActiveNetworkType(Context context) {
        try {
            NetworkInfo m24133cj = m24133cj(context);
            if (m24133cj == null) {
                return -1;
            }
            return m24133cj.getType();
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
            NetworkInfo m24133cj = m24133cj(context);
            if (m24133cj != null && m24133cj.isConnected()) {
                if (m24133cj.getType() == 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        try {
            NetworkInfo m24133cj = m24133cj(context);
            if (m24133cj != null) {
                if (m24133cj.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        try {
            NetworkInfo m24133cj = m24133cj(context);
            if (m24133cj != null && m24133cj.isConnected()) {
                return 1 == m24133cj.getType();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @SuppressLint({"MissingPermission"})
    /* renamed from: m */
    private static int m24128m(Context context, int i) {
        ServiceState serviceState;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 26 || !SystemUtil.m24270b(context, C7282g.f24944b)) {
            return i;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return i;
            }
            int subId = getSubId();
            if (subId == -1) {
                serviceState = telephonyManager.getServiceState();
            } else {
                serviceState = (context.getApplicationInfo().targetSdkVersion < 29 || i2 < 29) ? (ServiceState) C11124s.callMethod(telephonyManager, "getServiceStateForSubscriber", Integer.valueOf(subId)) : telephonyManager.getServiceState();
            }
            if (serviceState == null) {
                return i;
            }
            if (C11027at.m24080Md()) {
                Integer num = (Integer) C11124s.m23705a("com.huawei.android.telephony.ServiceStateEx", "getConfigRadioTechnology", serviceState);
                return num != null ? num.intValue() : i;
            } else if (m24130gC(serviceState.toString())) {
                return 20;
            } else {
                return i;
            }
        } catch (Exception unused) {
            return i;
        }
    }

    @WorkerThread
    /* renamed from: t */
    private static boolean m24127t(String str, int i) {
        try {
            return InetAddress.getByName(str).isReachable(3000);
        } catch (Throwable unused) {
            return false;
        }
    }
}
