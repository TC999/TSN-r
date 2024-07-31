package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

/* renamed from: bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.n */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class NetworkUtils {
    /* renamed from: a */
    public static boolean m59170a(Context context) {
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

    /* renamed from: b */
    public static int m59169b(Context context) {
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

    /* renamed from: c */
    public static int m59168c(Context context) {
        int m59169b = m59169b(context);
        if (m59169b != 0) {
            int i = 1;
            if (m59169b != 1) {
                i = 2;
                if (m59169b != 2) {
                    i = 3;
                    if (m59169b != 3) {
                        i = 4;
                        if (m59169b != 4) {
                            return m59169b;
                        }
                    }
                }
            }
            return i;
        }
        return 0;
    }

    /* renamed from: d */
    public static String m59167d(Context context) {
        int m59169b = m59169b(context);
        return m59169b != 1 ? m59169b != 2 ? m59169b != 3 ? m59169b != 4 ? "mobile" : "4g" : "3g" : "2g" : "wifi";
    }

    /* renamed from: e */
    public static boolean m59166e(Context context) {
        return m59169b(context) == 2;
    }

    /* renamed from: f */
    public static boolean m59165f(Context context) {
        return m59169b(context) == 3;
    }
}
