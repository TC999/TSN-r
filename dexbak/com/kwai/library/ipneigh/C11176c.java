package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.stub.StubApp;

/* renamed from: com.kwai.library.ipneigh.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11176c {
    /* renamed from: b */
    private static C11177d m23476b(Context context, boolean z, boolean z2) {
        String str;
        try {
            if (!C11175b.isWifiConnected(context)) {
                return new C11177d("", false, "");
            }
            String m23479er = C11175b.m23479er(((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getDhcpInfo().gateway);
            if (z) {
                str = "";
            } else {
                str = C11171a.m23482hp("timeout 5 ip neigh show " + m23479er);
            }
            if (z || TextUtils.isEmpty(str)) {
                str = KwaiIpNeigh.m23485i(m23479er, false);
            }
            String m23477hr = C11175b.m23477hr(str);
            return new C11177d(m23477hr, !TextUtils.isEmpty(m23477hr), str);
        } catch (Throwable th) {
            return new C11177d("", false, th.getMessage());
        }
    }

    /* renamed from: dw */
    public static C11177d m23475dw(Context context) {
        return m23474y(context, false);
    }

    /* renamed from: y */
    private static C11177d m23474y(Context context, boolean z) {
        return m23476b(context, false, false);
    }
}
