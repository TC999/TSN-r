package com.acse.ottn.util;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.stub.StubApp;
import com.umeng.socialize.common.SocializeConstants;
import java.io.ObjectStreamException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;

/* renamed from: com.acse.ottn.util.wa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1706wa {

    /* renamed from: a */
    private static C1706wa f3384a;

    private C1706wa() {
    }

    /* renamed from: a */
    public static int m55893a(Context context) {
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

    /* renamed from: a */
    public static C1706wa m55895a() {
        if (f3384a == null) {
            synchronized (C1706wa.class) {
                if (f3384a == null) {
                    f3384a = new C1706wa();
                }
            }
        }
        return f3384a;
    }

    /* renamed from: a */
    private String m55894a(int i) {
        return (i & 255) + "." + ((i >> 8) & 255) + "." + ((i >> 16) & 255) + "." + ((i >> 24) & 255);
    }

    /* renamed from: b */
    public static int m55891b(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    /* renamed from: b */
    private String m55892b() {
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
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: c */
    private Object m55890c() throws ObjectStreamException {
        return f3384a;
    }

    /* renamed from: d */
    public static boolean m55888d(Context context) {
        return ((LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION)).isProviderEnabled(GeocodeSearch.GPS);
    }

    /* renamed from: e */
    public static boolean m55887e(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    /* renamed from: f */
    public static boolean m55886f(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    /* renamed from: g */
    private String m55885g(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return m55894a(((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: c */
    public String m55889c(Context context) {
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
            C1694ra.m55915b("getIpAddress", "getIpAddress is null");
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            if (networkInfo2 != null && networkInfo2.isConnected()) {
                return m55885g(context);
            }
            return "";
        }
        return m55892b();
    }
}
