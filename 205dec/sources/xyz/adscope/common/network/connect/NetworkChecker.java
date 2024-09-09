package xyz.adscope.common.network.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class NetworkChecker {

    /* renamed from: a  reason: collision with root package name */
    public ConnectivityManager f64866a;

    /* renamed from: xyz.adscope.common.network.connect.NetworkChecker$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f64867a;

        static {
            int[] iArr = new int[NetType.values().length];
            f64867a = iArr;
            try {
                iArr[NetType.Wifi.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64867a[NetType.Wired.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f64867a[NetType.Mobile.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f64867a[NetType.Mobile2G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f64867a[NetType.Mobile3G.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f64867a[NetType.Mobile4G.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public enum NetType {
        Wifi,
        Wired,
        Mobile,
        Mobile2G,
        Mobile3G,
        Mobile4G
    }

    public NetworkChecker(Context context) {
        this.f64866a = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static boolean a(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public static boolean a(NetType netType, NetworkInfo networkInfo) {
        NetType netType2;
        if (networkInfo == null) {
            return false;
        }
        switch (AnonymousClass1.f64867a[netType.ordinal()]) {
            case 1:
                return a(networkInfo) && networkInfo.getType() == 1;
            case 2:
                return a(networkInfo) && networkInfo.getType() == 9;
            case 3:
                return a(networkInfo) && networkInfo.getType() == 0;
            case 4:
                if (a(NetType.Mobile, networkInfo)) {
                    netType2 = NetType.Mobile2G;
                    break;
                } else {
                    return false;
                }
            case 5:
                if (a(NetType.Mobile, networkInfo)) {
                    netType2 = NetType.Mobile3G;
                    break;
                } else {
                    return false;
                }
            case 6:
                if (a(NetType.Mobile, networkInfo)) {
                    netType2 = NetType.Mobile4G;
                    break;
                } else {
                    return false;
                }
            default:
                return false;
        }
        return b(netType2, networkInfo);
    }

    public static boolean b(NetType netType, NetworkInfo networkInfo) {
        switch (networkInfo.getType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return netType == NetType.Mobile2G;
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
                return netType == NetType.Mobile3G;
            case 13:
            case 18:
                return netType == NetType.Mobile4G;
            default:
                String subtypeName = networkInfo.getSubtypeName();
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) && netType == NetType.Mobile3G;
        }
    }

    public boolean isAvailable() {
        return isWifiConnected() || isWiredConnected() || isMobileConnected();
    }

    public final boolean isAvailable(NetType netType) {
        return a(netType, this.f64866a.getActiveNetworkInfo());
    }

    public final boolean isMobile2GConnected() {
        return isAvailable(NetType.Mobile2G);
    }

    public final boolean isMobile3GConnected() {
        return isAvailable(NetType.Mobile3G);
    }

    public final boolean isMobile4GConnected() {
        return isAvailable(NetType.Mobile4G);
    }

    public final boolean isMobileConnected() {
        return isAvailable(NetType.Mobile);
    }

    public final boolean isWifiConnected() {
        return isAvailable(NetType.Wifi);
    }

    public final boolean isWiredConnected() {
        return isAvailable(NetType.Wired);
    }
}
