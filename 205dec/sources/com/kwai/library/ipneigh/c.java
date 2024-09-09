package com.kwai.library.ipneigh;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private static d b(Context context, boolean z3, boolean z4) {
        String str;
        try {
            if (!b.isWifiConnected(context)) {
                return new d("", false, "");
            }
            String er = b.er(((WifiManager) StubApp.getOrigApplicationContext(context.getApplicationContext()).getSystemService("wifi")).getDhcpInfo().gateway);
            if (z3) {
                str = "";
            } else {
                str = a.hp("timeout 5 ip neigh show " + er);
            }
            if (z3 || TextUtils.isEmpty(str)) {
                str = KwaiIpNeigh.i(er, false);
            }
            String hr = b.hr(str);
            return new d(hr, !TextUtils.isEmpty(hr), str);
        } catch (Throwable th) {
            return new d("", false, th.getMessage());
        }
    }

    public static d dw(Context context) {
        return y(context, false);
    }

    private static d y(Context context, boolean z3) {
        return b(context, false, false);
    }
}
