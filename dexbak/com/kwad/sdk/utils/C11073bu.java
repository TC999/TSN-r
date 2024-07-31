package com.kwad.sdk.utils;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p205p0.C7282g;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10970h;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.utils.bu */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11073bu {
    private static boolean aRg;
    private static final List<C11074a> aRh = new ArrayList();

    /* renamed from: com.kwad.sdk.utils.bu$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C11074a implements InterfaceC9914b {
        public String aRi;
        public String aRj;
        public int level;

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "level", this.level);
            C11126t.putValue(jSONObject, "ssid", this.aRi);
            C11126t.putValue(jSONObject, "bssid", this.aRj);
            return jSONObject;
        }
    }

    /* renamed from: dj */
    public static boolean m23844dj(Context context) {
        return (context.getApplicationInfo().targetSdkVersion < 29 || Build.VERSION.SDK_INT < 29) ? Build.VERSION.SDK_INT >= 23 && ContextCompat.checkSelfPermission(context, C7282g.f24949g) == -1 && ContextCompat.checkSelfPermission(context, C7282g.f24950h) == -1 : ContextCompat.checkSelfPermission(context, C7282g.f24949g) == -1;
    }

    /* renamed from: n */
    public static List<C11074a> m23843n(Context context, int i) {
        WifiManager wifiManager;
        if (C11028au.m24066Mq()) {
            return new ArrayList();
        }
        if (!aRg && ServiceProvider.m24362KP().canReadNearbyWifiList()) {
            List<C11074a> list = aRh;
            if (list.isEmpty() && context != null) {
                if (((InterfaceC10970h) ServiceProvider.get(InterfaceC10970h.class)).mo24327X(32L)) {
                    return list;
                }
                try {
                } catch (Exception e) {
                    aRg = true;
                    C10331c.printStackTraceOnly(e);
                }
                if (m23844dj(context) || (wifiManager = (WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")) == null) {
                    return list;
                }
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                List<ScanResult> scanResults = wifiManager.getScanResults();
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        C11074a c11074a = new C11074a();
                        c11074a.aRi = scanResult.SSID;
                        c11074a.aRj = scanResult.BSSID;
                        c11074a.level = scanResult.level;
                        if (connectionInfo.getBSSID() != null && scanResult.BSSID != null && TextUtils.equals(connectionInfo.getBSSID().replace("\"", ""), scanResult.BSSID.replace("\"", "")) && connectionInfo.getSSID() != null && scanResult.SSID != null && TextUtils.equals(connectionInfo.getSSID().replace("\"", ""), scanResult.SSID.replace("\"", ""))) {
                            aRh.add(0, c11074a);
                        } else {
                            aRh.add(c11074a);
                        }
                        List<C11074a> list2 = aRh;
                        if (list2.size() >= i) {
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
