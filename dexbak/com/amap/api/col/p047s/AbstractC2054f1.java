package com.amap.api.col.p047s;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: IPV6Request.java */
/* renamed from: com.amap.api.col.s.f1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class AbstractC2054f1 extends AbstractC2044dz {
    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: a */
    public String mo52200a() {
        if (TextUtils.isEmpty(mo52180h())) {
            return mo52180h();
        }
        String mo52180h = mo52180h();
        Uri parse = Uri.parse(mo52180h);
        if (parse.getAuthority().startsWith("dualstack-")) {
            return mo52180h;
        }
        if (parse.getAuthority().startsWith("restsdk.amap.com")) {
            return parse.buildUpon().authority("dualstack-arestapi.amap.com").build().toString();
        }
        Uri.Builder buildUpon = parse.buildUpon();
        return buildUpon.authority("dualstack-" + parse.getAuthority()).build().toString();
    }
}
