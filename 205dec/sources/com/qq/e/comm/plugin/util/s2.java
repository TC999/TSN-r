package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class s2 {

    /* renamed from: a  reason: collision with root package name */
    private static volatile List<String> f46603a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b implements Comparator {
        private b() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((ScanResult) obj2).level - ((ScanResult) obj).level;
        }
    }

    public static String a(Context context) {
        return (String) pro.getobjresult(263, 1, context);
    }

    public static List<String> a(Context context, int i4) {
        List<ScanResult> scanResults;
        if (context == null || y.b("bssid") || context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") != 0 || !o0.a(context)) {
            return null;
        }
        if (f46603a != null) {
            return f46603a;
        }
        synchronized (s2.class) {
            if (f46603a != null) {
                return f46603a;
            }
            ArrayList arrayList = new ArrayList();
            try {
                scanResults = ((WifiManager) context.getSystemService("wifi")).getScanResults();
            } catch (Exception e4) {
                d1.a("Get wifi scan result encounter exception: " + e4.getMessage(), new Object[0]);
            }
            if (scanResults != null && scanResults.size() != 0) {
                Collections.sort(scanResults, new b());
                int i5 = 0;
                for (ScanResult scanResult : scanResults) {
                    d1.a(scanResult.SSID + "|" + scanResult.BSSID + "|" + scanResult.level, new Object[0]);
                    String upperCase = scanResult.BSSID.replace(":", "").toUpperCase();
                    StringBuilder sb = new StringBuilder();
                    sb.append(upperCase);
                    sb.append("|");
                    sb.append(scanResult.level);
                    arrayList.add(sb.toString());
                    i5++;
                    if (i5 == i4) {
                        break;
                    }
                }
                f46603a = new ArrayList(arrayList);
                return f46603a;
            }
            return null;
        }
    }
}
