package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.kuaishou.weapon.p205p0.C7282g;
import com.stub.StubApp;

/* renamed from: com.baidu.mobads.sdk.internal.co */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2663co {

    /* renamed from: a */
    private static volatile C2663co f8863a;

    private C2663co() {
    }

    /* renamed from: a */
    public static C2663co m50615a() {
        if (f8863a == null) {
            synchronized (C2663co.class) {
                if (f8863a == null) {
                    f8863a = new C2663co();
                }
            }
        }
        return f8863a;
    }

    /* renamed from: c */
    private NetworkCapabilities m50612c(Context context) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext.checkCallingOrSelfPermission(C7282g.f24944b) == 0) {
                ConnectivityManager connectivityManager = (ConnectivityManager) origApplicationContext.getSystemService("connectivity");
                return connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: b */
    public NetworkInfo m50613b(Context context) {
        try {
            Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
            if (origApplicationContext.checkCallingOrSelfPermission(C7282g.f24944b) == 0) {
                return ((ConnectivityManager) origApplicationContext.getSystemService("connectivity")).getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: a */
    public Boolean m50614a(Context context) {
        try {
            boolean z = false;
            if (C2624bk.m50799a(context).m50800a() < 29) {
                NetworkInfo m50613b = m50613b(context);
                if (m50613b != null && m50613b.isConnected() && m50613b.getType() == 1) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }
            NetworkCapabilities m50612c = m50612c(context);
            if (m50612c != null && m50612c.hasCapability(12) && m50612c.hasCapability(16) && m50612c.hasTransport(1)) {
                z = true;
            }
            return Boolean.valueOf(z);
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }
}
