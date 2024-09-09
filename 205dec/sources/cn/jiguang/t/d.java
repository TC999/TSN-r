package cn.jiguang.t;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import cn.jiguang.ag.e;
import cn.jiguang.ag.h;
import cn.jiguang.ag.i;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static List<cn.jiguang.u.c> f3800a = new ArrayList();

    private static String a(Context context) {
        String str;
        WifiManager wifiManager;
        try {
        } catch (Throwable unused) {
            str = "";
        }
        if (Build.VERSION.SDK_INT >= 29 && cn.jiguang.ar.a.a().a(1608) && (wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")) != null) {
            str = cn.jiguang.ag.a.a(context, false);
            try {
                int f4 = cn.jiguang.ag.a.f(context);
                for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
                    if (wifiConfiguration.networkId == f4) {
                        str = wifiConfiguration.SSID;
                    }
                }
            } catch (Throwable unused2) {
            }
            cn.jiguang.w.a.b("JLocationWifi", "ssid is " + str);
            return str.replace("\"", "");
        }
        return "";
    }

    public static List<cn.jiguang.u.c> a(Context context, int i4, boolean z3) {
        cn.jiguang.w.a.b("JLocationWifi", "getWifiInfoList local memory wifiInfoList=" + f3800a);
        boolean a4 = e.a("getWifiInfoList", 900000L, Integer.MAX_VALUE);
        cn.jiguang.w.a.b("JLocationWifi", "getWifiInfoList is freq=" + a4);
        if (z3 || !a4) {
            cn.jiguang.w.a.b("JLocationWifi", "getWifiInfoList no freq,start use api");
            a(context, z3);
        }
        List<cn.jiguang.u.c> list = f3800a;
        if (list == null || list.size() <= 0) {
            cn.jiguang.w.a.b("JLocationWifi", "getWifiInfoList  default data=" + f3800a);
            return f3800a;
        }
        if (i4 > f3800a.size()) {
            i4 = f3800a.size();
        }
        List<cn.jiguang.u.c> subList = f3800a.subList(0, i4);
        cn.jiguang.w.a.b("JLocationWifi", "getWifiInfoList return data=" + subList);
        return subList;
    }

    public static List<cn.jiguang.u.c> a(Context context, boolean z3) {
        String str;
        if (!cn.jiguang.ah.d.o(context)) {
            cn.jiguang.y.a.a(context, "loc_info", "wifi", -5);
            return null;
        }
        WifiManager wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi");
        if (wifiManager == null || !wifiManager.isWifiEnabled()) {
            cn.jiguang.y.a.a(context, "loc_info", "wifi", -6);
            cn.jiguang.w.a.f("JLocationWifi", "get wifiManager failed");
            return null;
        }
        f3800a.clear();
        cn.jiguang.u.c cVar = new cn.jiguang.u.c();
        cVar.f3817a = cn.jiguang.ah.d.i(context);
        if (cn.jiguang.ar.a.a().a(1608)) {
            String a4 = cn.jiguang.ag.a.a(context, z3);
            if (TextUtils.isEmpty(a4) || "<unknown ssid>".equals(a4)) {
                a4 = a(context);
            }
            cVar.f3818b = h.b(a4);
        }
        cn.jiguang.ah.c.s(context, cVar.f3818b);
        String a5 = i.a(context);
        if (!TextUtils.isEmpty(a5) && "WIFI".equalsIgnoreCase(a5)) {
            cVar.f3819c = "connect";
        }
        cVar.f3820d = cn.jiguang.ag.a.e(context);
        if (cn.jiguang.ar.a.a().a(1601)) {
            cVar.f3821e = cn.jiguang.ag.a.b(context, z3);
        }
        cn.jiguang.w.a.b("JLocationWifi", "connectingWifi:" + cVar.toString());
        f3800a.add(cVar);
        if (Build.VERSION.SDK_INT < 23 || cn.jiguang.ah.d.a(context, "android.permission.ACCESS_COARSE_LOCATION") || cn.jiguang.ah.d.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults != null && scanResults.size() != 0) {
                cn.jiguang.w.a.b("JLocationWifi", "scan wifi list success:" + scanResults);
                ArrayList<ScanResult> arrayList = new ArrayList(scanResults);
                for (ScanResult scanResult : arrayList) {
                    if ((TextUtils.isEmpty(cVar.f3818b) || !cVar.f3818b.equals(cn.jiguang.ah.d.c(scanResult.SSID)) || TextUtils.isEmpty(cVar.f3821e) || !cVar.f3821e.equals(scanResult.BSSID)) && scanResult.level >= -200) {
                        for (ScanResult scanResult2 : arrayList) {
                            if (scanResult2 != scanResult && scanResult.SSID.equals(scanResult2.SSID) && scanResult.BSSID.equals(scanResult2.BSSID)) {
                                scanResults.remove(scanResult);
                            }
                        }
                    } else {
                        scanResults.remove(scanResult);
                    }
                }
                arrayList.clear();
                Collections.sort(scanResults, new Comparator<ScanResult>() { // from class: cn.jiguang.t.d.1
                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(ScanResult scanResult3, ScanResult scanResult4) {
                        return scanResult4.level - scanResult3.level;
                    }
                });
                for (int i4 = 0; i4 < scanResults.size(); i4++) {
                    ScanResult scanResult3 = scanResults.get(i4);
                    String c4 = cn.jiguang.ah.d.c(scanResult3.SSID);
                    cn.jiguang.u.c cVar2 = new cn.jiguang.u.c();
                    cVar2.f3817a = cn.jiguang.ah.d.i(context);
                    cVar2.f3818b = c4;
                    cVar2.f3819c = null;
                    if (i4 == 0) {
                        cVar2.f3819c = "strongest";
                    }
                    cVar2.f3820d = scanResult3.level;
                    cVar2.f3821e = scanResult3.BSSID;
                    f3800a.add(cVar2);
                }
                return f3800a;
            }
            str = "scan wifi list failed";
        } else {
            str = "scan wifi list failed because has no Manifest.permission.LOCATION";
        }
        cn.jiguang.w.a.f("JLocationWifi", str);
        return f3800a;
    }
}
