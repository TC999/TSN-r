package com.kwad.sdk.core.network.a;

import android.text.TextUtils;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String fK = com.kwad.sdk.ip.direct.a.fK(str);
        if (!TextUtils.isEmpty(fK)) {
            List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(fK));
            if (asList != null && !asList.isEmpty()) {
                com.kwad.sdk.core.e.c.d("IpDirect_OkHttpDns", "inetAddresses:" + asList);
                return asList;
            }
            return SYSTEM.lookup(str);
        }
        com.kwad.sdk.core.e.c.d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        return SYSTEM.lookup(str);
    }
}
