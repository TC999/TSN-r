package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import java.net.InetAddress;
import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Octans {
    public static byte a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    if (activeNetworkInfo.getType() == 1) {
                        return (byte) 0;
                    }
                    if (activeNetworkInfo.getType() == 0) {
                        if (Proxy.getDefaultHost() == null) {
                            return Proxy.getHost(context) != null ? (byte) 2 : (byte) 1;
                        }
                        return (byte) 2;
                    }
                    return (byte) 3;
                }
                return (byte) -1;
            }
            return (byte) -1;
        } catch (Throwable th) {
            String message = th.getMessage();
            return (message == null || !message.contains("ACCESS_NETWORK_STATE")) ? (byte) -3 : (byte) -2;
        }
    }

    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                if (activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            String message = th.getMessage();
            return message != null && message.contains("ACCESS_NETWORK_STATE");
        }
    }

    public static String a() {
        Context context;
        Context context2;
        String sb;
        int i4 = Build.VERSION.SDK_INT;
        if (i4 < 23) {
            return null;
        }
        synchronized (Ctry.class) {
            context = Ctry.f52366a;
        }
        Network activeNetwork = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetwork();
        if (activeNetwork != null && i4 >= 21) {
            try {
                synchronized (Ctry.class) {
                    context2 = Ctry.f52366a;
                }
                ConnectivityManager connectivityManager = (ConnectivityManager) context2.getSystemService("connectivity");
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(Taurus.a(networkCapabilities.getClass(), "mTransportTypes", networkCapabilities));
                    sb2.append(",");
                    sb2.append(Taurus.a(networkCapabilities.getClass(), "mNetworkCapabilities", networkCapabilities));
                    LinkProperties linkProperties = connectivityManager.getLinkProperties(activeNetwork);
                    if (linkProperties == null) {
                        sb = sb2.toString();
                    } else {
                        String interfaceName = linkProperties.getInterfaceName();
                        int i5 = Cherry.f51967a;
                        if (interfaceName == null) {
                            interfaceName = "";
                        }
                        String replace = interfaceName.replace(",", "").replace(";", "");
                        sb2.append(",");
                        sb2.append(replace);
                        sb2.append(",");
                        List<LinkAddress> linkAddresses = linkProperties.getLinkAddresses();
                        if (!Cwhile.a(linkAddresses)) {
                            for (int i6 = 0; i6 < linkAddresses.size(); i6++) {
                                sb2.append(linkAddresses.get(i6).getAddress().getHostAddress());
                                if (i6 != linkAddresses.size() - 1) {
                                    sb2.append(";");
                                }
                            }
                        }
                        sb2.append(",");
                        List<InetAddress> dnsServers = linkProperties.getDnsServers();
                        if (!Cwhile.a(dnsServers)) {
                            for (int i7 = 0; i7 < dnsServers.size(); i7++) {
                                sb2.append(dnsServers.get(i7).getHostAddress());
                                if (i7 != dnsServers.size() - 1) {
                                    sb2.append(";");
                                }
                            }
                        }
                        sb = sb2.toString();
                    }
                    return sb;
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }
}
