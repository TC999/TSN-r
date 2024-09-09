package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cr {

    /* renamed from: a  reason: collision with root package name */
    private static volatile cr f12711a;

    private cr() {
    }

    public static cr a() {
        if (f12711a == null) {
            synchronized (cr.class) {
                if (f12711a == null) {
                    f12711a = new cr();
                }
            }
        }
        return f12711a;
    }

    private NetworkCapabilities c(Context context) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                ConnectivityManager connectivityManager = (ConnectivityManager) origApplicationContext.getSystemService("connectivity");
                return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public NetworkInfo b(Context context) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
                return ((ConnectivityManager) origApplicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Boolean a(Context context) {
        try {
            boolean z3 = false;
            if (bn.a(context).a() < 29) {
                NetworkInfo b4 = b(context);
                if (b4 != null && b4.isConnected() && b4.getType() == 1) {
                    z3 = true;
                }
                return Boolean.valueOf(z3);
            }
            NetworkCapabilities c4 = c(context);
            if (c4 != null && c4.hasCapability(12) && c4.hasCapability(16) && c4.hasTransport(1)) {
                z3 = true;
            }
            return Boolean.valueOf(z3);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
