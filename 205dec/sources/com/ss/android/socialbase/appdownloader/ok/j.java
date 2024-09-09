package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class j extends ok {
    public j(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str) {
        super(context, okVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        String bl = this.f49163a.bl("s");
        String ok = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("ag"), bl);
        String ok2 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("ah"), bl);
        String ok3 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("ai"), bl);
        String ok4 = com.ss.android.socialbase.appdownloader.kf.bl.ok(this.f49163a.bl("aj"), bl);
        Intent intent = new Intent();
        intent.putExtra(ok, this.bl);
        intent.putExtra(ok2, Headers.VALUE_ACCEPT_ALL);
        intent.putExtra(ok3, true);
        intent.setAction(ok4);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
