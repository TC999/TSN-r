package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.text.TextUtils;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import org.json.JSONArray;

/* renamed from: com.kuaishou.weapon.p0.am */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7169am {

    /* renamed from: a */
    private static final String f24520a = "tun";

    /* renamed from: b */
    private static final String f24521b = "ppp";

    /* renamed from: c */
    private static int f24522c;

    /* renamed from: a */
    public static boolean m34372a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                return networkCapabilities != null && networkCapabilities.hasTransport(4);
            }
            return connectivityManager.getNetworkInfo(17).isConnectedOrConnecting();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    public static String m34370b(Context context) {
        JSONArray m34373a;
        try {
            m34373a = m34373a();
        } catch (Throwable unused) {
        }
        if (m34373a != null) {
            return m34373a.toString();
        }
        return m34372a(context) ? "[\"con\"]" : "";
    }

    /* renamed from: c */
    public static int m34369c() {
        return f24522c;
    }

    /* renamed from: d */
    public static String m34368d() {
        StringBuilder sb = new StringBuilder();
        try {
            f24522c = 0;
            KeyStore keyStore = KeyStore.getInstance("AndroidCAStore");
            if (keyStore != null) {
                keyStore.load(null, null);
                Enumeration<String> aliases = keyStore.aliases();
                while (aliases.hasMoreElements()) {
                    f24522c++;
                    X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                    if (x509Certificate.getIssuerDN().getName().contains("2022") || x509Certificate.getIssuerDN().getName().contains("2023") || x509Certificate.getIssuerDN().getName().contains("HttpCanary") || x509Certificate.getIssuerDN().getName().contains("macbook") || x509Certificate.getIssuerDN().getName().contains("proxy") || x509Certificate.getIssuerDN().getName().contains("Proxy") || x509Certificate.getIssuerDN().getName().contains("local") || x509Certificate.getIssuerDN().getName().contains("github")) {
                        sb.append(x509Certificate.getIssuerDN().getName());
                        sb.append("|");
                    }
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    /* renamed from: b */
    public static String m34371b() {
        String property = System.getProperty("http.proxyHost");
        return TextUtils.isEmpty(property) ? "" : property;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
        if (r2 == null) goto L32;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONArray m34373a() {
        /*
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r1 = 0
            java.lang.Runtime r2 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L6b
            java.lang.String r3 = "cat /proc/net/route"
            java.lang.Process r2 = r2.exec(r3)     // Catch: java.lang.Throwable -> L6b
            java.io.DataInputStream r3 = new java.io.DataInputStream     // Catch: java.lang.Throwable -> L6b
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L6b
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L6b
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L68
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L68
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L68
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L68
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L69
            r1.<init>()     // Catch: java.lang.Throwable -> L69
        L28:
            java.lang.String r4 = r2.readLine()     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L4f
            java.lang.String r4 = com.kuaishou.weapon.p205p0.C7199bo.m34149a(r4)     // Catch: java.lang.Throwable -> L69
            java.lang.String r5 = "tun"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L69
            if (r5 != 0) goto L42
            java.lang.String r5 = "ppp"
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Throwable -> L69
            if (r5 == 0) goto L28
        L42:
            java.lang.String r5 = "\t"
            java.lang.String[] r4 = r4.split(r5)     // Catch: java.lang.Throwable -> L69
            r5 = 0
            r4 = r4[r5]     // Catch: java.lang.Throwable -> L69
            r1.add(r4)     // Catch: java.lang.Throwable -> L69
            goto L28
        L4f:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L69
        L53:
            boolean r4 = r1.hasNext()     // Catch: java.lang.Throwable -> L69
            if (r4 == 0) goto L61
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> L69
            r0.put(r4)     // Catch: java.lang.Throwable -> L69
            goto L53
        L61:
            r3.close()     // Catch: java.io.IOException -> L64
        L64:
            r2.close()     // Catch: java.io.IOException -> L76
            goto L76
        L68:
            r2 = r1
        L69:
            r1 = r3
            goto L6c
        L6b:
            r2 = r1
        L6c:
            if (r1 == 0) goto L73
            r1.close()     // Catch: java.io.IOException -> L72
            goto L73
        L72:
        L73:
            if (r2 == 0) goto L76
            goto L64
        L76:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p205p0.C7169am.m34373a():org.json.JSONArray");
    }
}
