package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ok implements n {

    /* renamed from: a  reason: collision with root package name */
    protected final com.ss.android.socialbase.downloader.h.ok f49163a;
    protected final String bl;
    protected final Context ok;

    public ok(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str) {
        this.ok = context;
        this.f49163a = okVar;
        this.bl = str;
    }

    public boolean ok() {
        if (this.ok == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return a().resolveActivity(this.ok.getPackageManager()) != null;
    }
}
