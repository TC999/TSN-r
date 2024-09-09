package com.acse.ottn;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.stub.StubApp;
import java.io.ObjectStreamException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class l2 {

    /* renamed from: a  reason: collision with root package name */
    public static l2 f5897a;

    public static l2 a() {
        if (f5897a == null) {
            synchronized (l2.class) {
                if (f5897a == null) {
                    f5897a = new l2();
                }
            }
        }
        return f5897a;
    }

    public static int b(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static boolean e(Context context) {
        return ((LocationManager) context.getSystemService("location")).isProviderEnabled("gps");
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public final Object c() throws ObjectStreamException {
        return f5897a;
    }

    public final String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return a(((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (Exception e4) {
            Log.d("WifiManager", e4.getMessage());
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
            Log.d("getIpAddress", "getIpAddress is null");
        }
        if (networkInfo != null && networkInfo.isConnected()) {
            return b();
        }
        if (networkInfo2 != null && networkInfo2.isConnected()) {
            return d(context);
        }
        return "";
    }

    public final String b() {
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

    public final String a(int i4) {
        return (i4 & 255) + "." + ((i4 >> 8) & 255) + "." + ((i4 >> 16) & 255) + "." + ((i4 >> 24) & 255);
    }
}
