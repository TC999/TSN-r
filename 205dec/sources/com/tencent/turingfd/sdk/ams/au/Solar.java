package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.Proxy;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Solar {
    public static boolean a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                Iterator it = Collections.list(networkInterfaces).iterator();
                while (it.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it.next();
                    if (networkInterface.isUp() && networkInterface.getInterfaceAddresses().size() != 0 && networkInterface.getName().matches("tun\\d+")) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean a(Context context) {
        List<WifiConfiguration> list;
        String str;
        Object obj;
        Object a4;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 14) {
            return (TextUtils.isEmpty(Proxy.getHost(context)) || Proxy.getPort(context) == -1) ? false : true;
        } else if (TextUtils.isEmpty(System.getProperty("http.proxyHost")) || TextUtils.equals(System.getProperty("http.proxyPort"), "-1")) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (Sagittarius.a(context, "android.permission.ACCESS_WIFI_STATE") != 0) {
                return false;
            }
            try {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null && connectionInfo.getNetworkId() != -1) {
                    Object obj2 = null;
                    try {
                        list = wifiManager.getConfiguredNetworks();
                    } catch (Throwable unused) {
                        list = null;
                    }
                    if (list != null) {
                        int networkId = connectionInfo.getNetworkId();
                        Iterator<WifiConfiguration> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            WifiConfiguration next = it.next();
                            if (next.networkId == networkId) {
                                if (i4 < 21) {
                                    obj = Triangulum.a(WifiConfiguration.class, "proxySettings", next);
                                    str = "android.net.wifi.WifiConfiguration$ProxySettings";
                                } else {
                                    HashMap<String, Class<?>> hashMap = Triangulum.f52176a;
                                    try {
                                        Method a5 = Triangulum.a((Class<?>) WifiConfiguration.class, "getProxySettings", (Class<?>[]) new Class[0]);
                                        if (a5 != null) {
                                            obj2 = a5.invoke(next, new Object[0]);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                    Object obj3 = obj2;
                                    str = "android.net.IpConfiguration$ProxySettings";
                                    obj = obj3;
                                }
                                Object a6 = Triangulum.a(str, "STATIC");
                                if (a6 == null || a6 != obj) {
                                    if (i4 < 19 || (a4 = Triangulum.a(str, "PAC")) == null || a4 != obj) {
                                        break;
                                    }
                                    return true;
                                }
                                return true;
                            }
                        }
                    } else {
                        return false;
                    }
                }
            } catch (Throwable unused2) {
            }
            return false;
        } else {
            return true;
        }
    }
}
