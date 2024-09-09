package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* compiled from: NetworkUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class n {
    public static boolean a(Context context) {
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

    public static int b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 0 : 1;
                }
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
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
                    case 4:
                    case 7:
                    case 11:
                    default:
                        return 0;
                    case 13:
                        return 4;
                }
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static int c(Context context) {
        int b4 = b(context);
        if (b4 != 0) {
            int i4 = 1;
            if (b4 != 1) {
                i4 = 2;
                if (b4 != 2) {
                    i4 = 3;
                    if (b4 != 3) {
                        i4 = 4;
                        if (b4 != 4) {
                            return b4;
                        }
                    }
                }
            }
            return i4;
        }
        return 0;
    }

    public static String d(Context context) {
        int b4 = b(context);
        return b4 != 1 ? b4 != 2 ? b4 != 3 ? b4 != 4 ? "mobile" : "4g" : "3g" : "2g" : "wifi";
    }

    public static boolean e(Context context) {
        return b(context) == 2;
    }

    public static boolean f(Context context) {
        return b(context) == 3;
    }
}
