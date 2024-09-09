package com.bytedance.sdk.component.panglearmor.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.bytedance.sdk.component.panglearmor.f;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f29986c;
    private volatile int sr = -1;
    private TelephonyManager ux;

    /* renamed from: w  reason: collision with root package name */
    private volatile int f29987w;
    private ConnectivityManager xv;

    public c() {
        this.xv = null;
        this.ux = null;
        Context ux = f.ux();
        if (ux != null) {
            this.xv = (ConnectivityManager) ux.getSystemService("connectivity");
            this.ux = (TelephonyManager) ux.getSystemService("phone");
        }
        c((int) (((ux.c().xv() / 1000) / 60) / 60));
    }

    public static c c() {
        if (f29986c == null) {
            synchronized (c.class) {
                if (f29986c == null) {
                    f29986c = new c();
                }
            }
        }
        return f29986c;
    }

    private int f() {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = this.xv;
            NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    Network activeNetwork = this.xv.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = this.xv.getNetworkCapabilities(activeNetwork)) != null) {
                        boolean hasTransport = networkCapabilities.hasTransport(0);
                        boolean hasTransport2 = networkCapabilities.hasTransport(1);
                        if (c(this.xv) && hasTransport2) {
                            return 3;
                        }
                        if (hasTransport2) {
                            return 1;
                        }
                        return hasTransport ? 2 : 0;
                    }
                } else {
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        return c(this.xv) ? 3 : 1;
                    } else if (type == 0) {
                        return 2;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public int sr() {
        this.sr = f();
        return this.sr;
    }

    public int ux() {
        TelephonyManager telephonyManager = this.ux;
        if (telephonyManager != null) {
            return telephonyManager.getSimState();
        }
        return -1;
    }

    @NonNull
    public int[] w() {
        int[] iArr = new int[this.f29987w];
        LinkedList<JSONObject> c4 = w.c().c("sp_net");
        if (c4 != null && c4.size() > 0) {
            int optLong = (int) (((c4.getLast().optLong("t", 0L) / 1000) / 60) / 60);
            Iterator<JSONObject> it = c4.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long optLong2 = next.optLong("t", 0L);
                int optInt = next.optInt("val", 0);
                int i4 = optLong - ((int) (((optLong2 / 1000) / 60) / 60));
                if (i4 >= 0 && i4 < this.f29987w) {
                    iArr[i4] = optInt;
                }
            }
        }
        return iArr;
    }

    @NonNull
    public int[] xv() {
        int[] iArr = new int[this.f29987w];
        LinkedList<JSONObject> c4 = w.c().c("sp_screen");
        if (c4 != null && c4.size() > 0) {
            int currentTimeMillis = (int) (((System.currentTimeMillis() / 1000) / 60) / 60);
            Iterator<JSONObject> it = c4.iterator();
            while (it.hasNext()) {
                JSONObject next = it.next();
                long optLong = next.optLong("t", 0L);
                int optInt = next.optInt("val", 0);
                int i4 = currentTimeMillis - ((int) (((optLong / 1000) / 60) / 60));
                if (i4 >= 0 && i4 < this.f29987w) {
                    iArr[i4] = optInt;
                }
            }
        }
        return iArr;
    }

    public void c(int i4) {
        if (i4 < 1) {
            this.f29987w = 1;
        } else if (i4 > 168) {
            this.f29987w = 168;
        } else {
            this.f29987w = i4;
        }
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
}
