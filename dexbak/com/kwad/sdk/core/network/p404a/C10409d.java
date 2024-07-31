package com.kwad.sdk.core.network.p404a;

import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.p438ip.direct.C10808a;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.List;
import okhttp3.Dns;

/* renamed from: com.kwad.sdk.core.network.a.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10409d implements Dns {
    private static final Dns SYSTEM = Dns.SYSTEM;

    @Override // okhttp3.Dns
    public final List<InetAddress> lookup(String str) {
        String m24770fK = C10808a.m24770fK(str);
        if (!TextUtils.isEmpty(m24770fK)) {
            List<InetAddress> asList = Arrays.asList(InetAddress.getAllByName(m24770fK));
            if (asList != null && !asList.isEmpty()) {
                C10331c.m26254d("IpDirect_OkHttpDns", "inetAddresses:" + asList);
                return asList;
            }
            return SYSTEM.lookup(str);
        }
        C10331c.m26254d("IpDirect_OkHttpDns", "Dns.SYSTEM.lookup(hostname):" + Dns.SYSTEM.lookup(str));
        return SYSTEM.lookup(str);
    }
}
