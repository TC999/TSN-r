package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bu {
    private static boolean aRg;
    private static final List<a> aRh = new ArrayList();

    /* renamed from: com.kwad.sdk.utils.bu$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ WebView aSk;
        final /* synthetic */ String aSl;
        final /* synthetic */ ValueCallback aSm;

        AnonymousClass1(WebView webView, String str, ValueCallback valueCallback) {
            this.aSk = webView;
            this.aSl = str;
            this.aSm = valueCallback;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.aSk.evaluateJavascript(this.aSl, this.aSm);
            } catch (Exception unused) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a implements com.kwad.sdk.core.b {
        public String aRi;
        public String aRj;
        public int level;

        @Override // com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            t.putValue(jSONObject, "level", this.level);
            t.putValue(jSONObject, "ssid", this.aRi);
            t.putValue(jSONObject, "bssid", this.aRj);
            return jSONObject;
        }
    }

    public static boolean dj(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == -1 : ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == -1;
    }

    public static List<a> n(Context context, int i4) {
        WifiManager wifiManager;
        if (au.Mq()) {
            return new ArrayList();
        }
        if (!aRg && ServiceProvider.KP().canReadNearbyWifiList()) {
            List<a> list = aRh;
            if (list.isEmpty() && context != null) {
                if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).X(32L)) {
                    return list;
                }
                try {
                } catch (Exception e4) {
                    aRg = true;
                    com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                }
                if (dj(context) || (wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")) == null) {
                    return list;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        a aVar = new a();
                        aVar.aRi = scanResult.SSID;
                        aVar.aRj = scanResult.BSSID;
                        aVar.level = scanResult.level;
                        if (connectionInfo.getBSSID() != null && scanResult.BSSID != null && TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) && connectionInfo.getSSID() != null && scanResult.SSID != null && TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            aRh.add(0, aVar);
                        } else {
                            aRh.add(aVar);
                        }
                        List<a> list2 = aRh;
                        if (list2.size() >= i4) {
                            return list2;
                        }
                    }
                }
                return aRh;
            }
        }
        return aRh;
    }
}
