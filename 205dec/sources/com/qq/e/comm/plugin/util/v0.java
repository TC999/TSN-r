package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class v0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46636a = "v0";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f46637b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f46638c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile int f46639d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile String f46640e;

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f46641f;

    /* renamed from: g  reason: collision with root package name */
    private static volatile Pattern f46642g;

    /* renamed from: h  reason: collision with root package name */
    private static volatile Pattern f46643h;

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f46644i;

    /* renamed from: j  reason: collision with root package name */
    private static long f46645j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile com.qq.e.comm.plugin.d0.e.d f46646k;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a extends ConnectivityManager.NetworkCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ConnectivityManager f46647a;

        a(ConnectivityManager connectivityManager) {
            this.f46647a = connectivityManager;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            NetworkCapabilities networkCapabilities = this.f46647a.getNetworkCapabilities(network);
            if (networkCapabilities == null) {
                com.qq.e.comm.plugin.d0.e.d unused = v0.f46646k = com.qq.e.comm.plugin.d0.e.d.UNKNOWN;
            } else if (networkCapabilities.hasTransport(1)) {
                com.qq.e.comm.plugin.d0.e.d unused2 = v0.f46646k = com.qq.e.comm.plugin.d0.e.d.WIFI;
            } else if (networkCapabilities.hasTransport(0)) {
                com.qq.e.comm.plugin.d0.e.d unused3 = v0.f46646k = v0.b(this.f46647a);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
            if (networkCapabilities == null) {
                com.qq.e.comm.plugin.d0.e.d unused = v0.f46646k = com.qq.e.comm.plugin.d0.e.d.UNKNOWN;
            } else if (networkCapabilities.hasTransport(0)) {
                com.qq.e.comm.plugin.d0.e.d unused2 = v0.f46646k = v0.b(this.f46647a);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            com.qq.e.comm.plugin.d0.e.d unused = v0.f46646k = com.qq.e.comm.plugin.d0.e.d.UNKNOWN;
        }
    }

    static {
        f46637b = Build.VERSION.SDK_INT < 24;
        f46638c = false;
        f46639d = 2;
        f46640e = "";
        f46641f = "";
        f46642g = Pattern.compile(f46641f, 2);
        f46643h = Pattern.compile(f46640e, 2);
        f46644i = com.qq.e.comm.plugin.d0.a.d().f().a("gaape", 0) == 1;
        f46645j = 0L;
        f46646k = com.qq.e.comm.plugin.d0.e.d.UNKNOWN;
    }

    public static void a(HttpURLConnection httpURLConnection, URL url) {
        pro.getVresult(300, 1, httpURLConnection, url);
    }

    public static boolean a(int i4) {
        return i4 == 302 || i4 == 301 || i4 == 303;
    }

    private static boolean a(URL url) {
        return pro.getZresult(301, 1, url);
    }

    public static Pair<HttpURLConnection, Boolean> b(HttpURLConnection httpURLConnection, URL url) {
        return (Pair) pro.getobjresult(302, 1, httpURLConnection, url);
    }

    private static com.qq.e.comm.plugin.d0.e.d c() {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        try {
            connectivityManager = (ConnectivityManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("connectivity");
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
        }
        if (activeNetworkInfo == null) {
            return com.qq.e.comm.plugin.d0.e.d.UNKNOWN;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            if (type == 1) {
                return com.qq.e.comm.plugin.d0.e.d.WIFI;
            }
            return com.qq.e.comm.plugin.d0.e.d.UNKNOWN;
        }
        return b(connectivityManager);
    }

    private static int d() {
        if (Build.VERSION.SDK_INT >= 24) {
            return SubscriptionManager.getDefaultDataSubscriptionId();
        }
        return -1;
    }

    public static boolean e() {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("connectivity");
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void a(Context context) {
        if (f46637b) {
            return;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            connectivityManager.registerDefaultNetworkCallback(new a(connectivityManager));
            f46646k = c();
        } catch (Exception unused) {
            f46646k = com.qq.e.comm.plugin.d0.e.d.UNKNOWN;
        }
    }

    public static String a() {
        Context a4 = com.qq.e.comm.plugin.d0.a.d().a();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) a4.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                int i4 = 0;
                try {
                    i4 = ((TelephonyManager) a4.getSystemService("phone")).getNetworkType();
                } catch (Exception unused) {
                }
                if (i4 == 0) {
                    i4 = activeNetworkInfo.getSubtype();
                }
                if (i4 == 13 && Build.VERSION.SDK_INT >= 29 && com.qq.e.comm.plugin.d0.a.d().f().a("nsa5g", 1) == 1) {
                    return String.valueOf(a(a4, i4));
                }
                return "" + i4;
            }
        } catch (Exception unused2) {
        }
        return null;
    }

    public static com.qq.e.comm.plugin.d0.e.d b() {
        return f46637b ? c() : f46646k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.qq.e.comm.plugin.d0.e.d b(android.net.ConnectivityManager r2) {
        /*
            com.qq.e.comm.plugin.d0.a r0 = com.qq.e.comm.plugin.d0.a.d()
            com.qq.e.comm.plugin.d0.e.c r0 = r0.c()
            if (r0 == 0) goto L25
            boolean r0 = r0.t()
            if (r0 == 0) goto L25
            com.qq.e.comm.plugin.d0.a r0 = com.qq.e.comm.plugin.d0.a.d()
            android.content.Context r0 = r0.a()
            java.lang.String r1 = "phone"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            int r0 = r0.getNetworkType()     // Catch: java.lang.Exception -> L25
            goto L26
        L25:
            r0 = 0
        L26:
            if (r0 != 0) goto L34
            android.net.NetworkInfo r2 = r2.getActiveNetworkInfo()     // Catch: java.lang.Throwable -> L33
            if (r2 == 0) goto L34
            int r0 = r2.getSubtype()     // Catch: java.lang.Throwable -> L33
            goto L34
        L33:
        L34:
            switch(r0) {
                case 1: goto L40;
                case 2: goto L40;
                case 3: goto L3d;
                case 4: goto L3d;
                case 5: goto L3d;
                case 6: goto L3d;
                case 7: goto L3d;
                case 8: goto L3d;
                case 9: goto L3d;
                case 10: goto L3d;
                case 11: goto L3d;
                case 12: goto L3d;
                case 13: goto L3a;
                case 14: goto L3d;
                case 15: goto L3a;
                case 16: goto L40;
                case 17: goto L3d;
                case 18: goto L3a;
                case 19: goto L3a;
                case 20: goto L3a;
                default: goto L37;
            }
        L37:
            com.qq.e.comm.plugin.d0.e.d r2 = com.qq.e.comm.plugin.d0.e.d.UNKNOWN
            return r2
        L3a:
            com.qq.e.comm.plugin.d0.e.d r2 = com.qq.e.comm.plugin.d0.e.d.NET_4G
            return r2
        L3d:
            com.qq.e.comm.plugin.d0.e.d r2 = com.qq.e.comm.plugin.d0.e.d.NET_3G
            return r2
        L40:
            com.qq.e.comm.plugin.d0.e.d r2 = com.qq.e.comm.plugin.d0.e.d.NET_2G
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.util.v0.b(android.net.ConnectivityManager):com.qq.e.comm.plugin.d0.e.d");
    }

    public static HttpURLConnection a(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection == null) {
            return null;
        }
        int i4 = 0;
        int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("httpRedirectMax", 3);
        int connectTimeout = httpURLConnection.getConnectTimeout();
        int readTimeout = httpURLConnection.getReadTimeout();
        Map<String, List<String>> requestProperties = httpURLConnection.getRequestProperties();
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        while (i4 < a4) {
            httpURLConnection2.connect();
            try {
                if (!a(httpURLConnection2.getResponseCode())) {
                    break;
                }
                String headerField = httpURLConnection2.getHeaderField("location");
                httpURLConnection2.disconnect();
                httpURLConnection2 = (HttpURLConnection) new URL(com.qq.e.comm.plugin.i0.e.a(headerField, 4)).openConnection();
                httpURLConnection2.setConnectTimeout(connectTimeout);
                httpURLConnection2.setReadTimeout(readTimeout);
                if (requestProperties != null) {
                    for (Map.Entry<String, List<String>> entry : requestProperties.entrySet()) {
                        String key = entry.getKey();
                        List<String> value = entry.getValue();
                        if (value != null && !value.isEmpty()) {
                            for (String str : value) {
                                httpURLConnection2.addRequestProperty(key, str);
                            }
                        }
                    }
                }
                i4++;
            } catch (IndexOutOfBoundsException e4) {
                throw new IOException(e4.getMessage());
            }
        }
        if (i4 != a4) {
            if (i4 > 0) {
                com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
                dVar.a("http_from", httpURLConnection.getURL().toString());
                dVar.a("http_to", httpURLConnection2.getURL().toString());
                com.qq.e.comm.plugin.n0.v.a(100342, null, Integer.valueOf(i4), dVar);
            }
            return httpURLConnection2;
        }
        com.qq.e.comm.plugin.n0.v.a(100322, null, Integer.valueOf(a4));
        throw new IOException("HttpURLConnection exceed max redirect " + a4 + " " + httpURLConnection2.getURL());
    }

    private static int a(Context context, int i4) {
        ServiceState serviceState;
        if (com.qq.e.comm.plugin.d0.a.d().c().t()) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                int d4 = d();
                if (d4 == -1) {
                    serviceState = telephonyManager.getServiceState();
                } else {
                    Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    ServiceState serviceState2 = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(d4));
                    serviceState = serviceState2 == null ? telephonyManager.getServiceState() : serviceState2;
                }
                if (serviceState != null) {
                    if (a(serviceState.toString())) {
                        return 10013;
                    }
                    return i4;
                }
                return i4;
            } catch (Throwable th) {
                th.printStackTrace();
                return i4;
            }
        }
        return i4;
    }

    private static boolean a(String str) {
        return !TextUtils.isEmpty(str) && (str.contains("nrState=NOT_RESTRICTED") || str.contains("nrState=CONNECTED"));
    }
}
