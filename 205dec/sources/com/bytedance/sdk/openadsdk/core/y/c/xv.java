package com.bytedance.sdk.openadsdk.core.y.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import java.lang.reflect.Method;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f35656c;
    private ConnectivityManager.NetworkCallback sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private ConnectivityManager f35657w;
    private Network xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Network network);
    }

    private xv(Context context) {
        try {
            this.f35657w = (ConnectivityManager) context.getSystemService("connectivity");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public synchronized void w() {
        ConnectivityManager.NetworkCallback networkCallback;
        ConnectivityManager connectivityManager = this.f35657w;
        if (connectivityManager == null) {
            return;
        }
        try {
            networkCallback = this.sr;
        } catch (Exception unused) {
        }
        if (networkCallback == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(networkCallback);
        this.sr = null;
        this.xv = null;
    }

    public static xv c(Context context) {
        if (f35656c == null) {
            synchronized (xv.class) {
                if (f35656c == null) {
                    f35656c = new xv(context);
                }
            }
        }
        return f35656c;
    }

    private static boolean c(ConnectivityManager connectivityManager) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public int c() {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.f35657w;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Network activeNetwork = this.f35657w.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = this.f35657w.getNetworkCapabilities(activeNetwork)) != null) {
                        boolean hasTransport = networkCapabilities.hasTransport(4);
                        boolean hasTransport2 = networkCapabilities.hasTransport(0);
                        boolean hasTransport3 = networkCapabilities.hasTransport(1);
                        if (hasTransport) {
                            return 4;
                        }
                        if (c(this.f35657w) && hasTransport3) {
                            return 3;
                        }
                        if (hasTransport3) {
                            return 1;
                        }
                        return hasTransport2 ? 2 : 5;
                    }
                } else {
                    int type = activeNetworkInfo.getType();
                    return type == 1 ? c(this.f35657w) ? 3 : 1 : type == 0 ? 2 : 5;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public void c(final c cVar) {
        NetworkInfo networkInfo;
        ConnectivityManager connectivityManager = this.f35657w;
        if (connectivityManager == null) {
            cVar.c(null);
            return;
        }
        Network network = this.xv;
        if (network != null && !this.ux && (networkInfo = connectivityManager.getNetworkInfo(network)) != null && networkInfo.isAvailable()) {
            cVar.c(this.xv);
            return;
        }
        ConnectivityManager.NetworkCallback networkCallback = this.sr;
        if (networkCallback != null) {
            try {
                this.f35657w.unregisterNetworkCallback(networkCallback);
            } catch (Exception unused) {
                this.sr = null;
            }
        }
        NetworkRequest build = new NetworkRequest.Builder().addCapability(12).addTransportType(0).build();
        ConnectivityManager.NetworkCallback networkCallback2 = new ConnectivityManager.NetworkCallback() { // from class: com.bytedance.sdk.openadsdk.core.y.c.xv.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network2) {
                try {
                    xv.this.xv = network2;
                    cVar.c(network2);
                    xv.this.ux = false;
                } catch (Exception unused2) {
                    xv.this.xv = null;
                    cVar.c(null);
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network2) {
                xv.this.ux = true;
            }
        };
        this.sr = networkCallback2;
        try {
            this.f35657w.requestNetwork(build, networkCallback2);
        } catch (Exception unused2) {
            cVar.c(null);
        }
    }
}
