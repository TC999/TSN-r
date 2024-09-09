package com.amap.api.col.s;

import android.net.Uri;
import android.text.TextUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: IPV6Request.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public abstract class f1 extends dz {
    @Override // com.amap.api.col.s.dz
    public String a() {
        if (TextUtils.isEmpty(h())) {
            return h();
        }
        String h4 = h();
        Uri parse = Uri.parse(h4);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return h4;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        Uri.Builder buildUpon = parse.buildUpon();
        return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
    }
}
