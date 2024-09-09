package com.acse.ottn.util;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.stub.StubApp;
import java.io.ObjectStreamException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class wa {

    /* renamed from: a  reason: collision with root package name */
    private static wa f6894a;

    private wa() {
    }

    public static int a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 1;
        }
        if (type == 0) {
            int subtype = activeNetworkInfo.getSubtype();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (subtype != 13 || telephonyManager.isNetworkRoaming()) {
                if (subtype == 3 || subtype == 8 || (subtype == 5 && !telephonyManager.isNetworkRoaming())) {
                    return 3;
                }
                if (subtype != 1 && subtype != 2 && subtype == 4) {
                    telephonyManager.isNetworkRoaming();
                }
                return 2;
            }
            return 4;
        }
        return 0;
    }

    public static wa a() {
        if (f6894a == null) {
            synchronized (wa.class) {
                if (f6894a == null) {
                    f6894a = new wa();
                }
            }
        }
        return f6894a;
    }

    private String a(int i4) {
        return (i4 & 255) + "." + ((i4 >> 8) & 255) + "." + ((i4 >> 16) & 255) + "." + ((i4 >> 24) & 255);
    }

    public static int b(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private String b() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return "";
        } catch (SocketException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    private Object c() throws ObjectStreamException {
        return f6894a;
    }

    public static boolean d(Context context) {
        return ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    private String g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return a(((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (Exception unused) {
            return "";
        }
    }

    public String c(Context context) {
        NetworkInfo networkInfo;
        NetworkInfo networkInfo2;
        if (context == null) {
            return "";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            networkInfo = connectivityManager.getNetworkInfo(0);
            networkInfo2 = connectivityManager.getNetworkInfo(1);
        } catch (Exception unused) {
            ra.b("getIpAddress", "getIpAddress is null");
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            if (networkInfo2 != null && networkInfo2.isConnected()) {
                return g(context);
            }
            return "";
        }
        return b();
    }
}
