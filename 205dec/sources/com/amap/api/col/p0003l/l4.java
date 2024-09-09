package com.amap.api.col.p0003l;

import android.net.Uri;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: IPV6Request.java */
/* renamed from: com.amap.api.col.3l.l4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class l4 extends Cif {
    @Override // com.amap.api.col.p0003l.Cif
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

    @Override // com.amap.api.col.p0003l.Cif
    public boolean isSupportIPV6() {
        return true;
    }
}
