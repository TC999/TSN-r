package com.ss.android.socialbase.appdownloader.c;

import android.content.Context;
import android.util.Log;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class c implements ux {

    /* renamed from: c  reason: collision with root package name */
    protected final Context f49037c;

    /* renamed from: w  reason: collision with root package name */
    protected final com.ss.android.socialbase.downloader.r.c f49038w;
    protected final String xv;

    public c(Context context, com.ss.android.socialbase.downloader.r.c cVar, String str) {
        this.f49037c = context;
        this.f49038w = cVar;
        this.xv = str;
    }

    public boolean c() {
        if (this.f49037c == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (com.ss.android.socialbase.downloader.xv.c.c()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return w().resolveActivity(this.f49037c.getPackageManager()) != null;
    }
}
