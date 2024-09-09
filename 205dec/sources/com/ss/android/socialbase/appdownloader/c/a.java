package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.content.Intent;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class a extends c {
    public a(Context context, com.ss.android.socialbase.downloader.r.c cVar, String str) {
        super(context, cVar, str);
    }

    @Override // com.ss.android.socialbase.appdownloader.c.ux
    public Intent w() {
        String xv = this.f49038w.xv("s");
        String c4 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("ag"), xv);
        String c5 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("ah"), xv);
        String c6 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("ai"), xv);
        String c7 = com.ss.android.socialbase.appdownloader.f.xv.c(this.f49038w.xv("aj"), xv);
        Intent intent = new Intent();
        intent.putExtra(c4, this.xv);
        intent.putExtra(c5, Headers.VALUE_ACCEPT_ALL);
        intent.putExtra(c6, true);
        intent.setAction(c7);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        return intent;
    }
}
