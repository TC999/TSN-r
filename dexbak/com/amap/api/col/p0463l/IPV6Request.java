package com.amap.api.col.p0463l;

import android.net.Uri;
import android.text.TextUtils;

/* renamed from: com.amap.api.col.3l.k4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public abstract class IPV6Request extends AbstractC1840if {
    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public String getIPV6URL() {
        if (TextUtils.isEmpty(getURL())) {
            return getURL();
        }
        String url = getURL();
        Uri parse = Uri.parse(url);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return url;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        Uri.Builder buildUpon = parse.buildUpon();
        return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
    }

    @Override // com.amap.api.col.p0463l.AbstractC1840if
    public boolean isSupportIPV6() {
        return true;
    }
}
