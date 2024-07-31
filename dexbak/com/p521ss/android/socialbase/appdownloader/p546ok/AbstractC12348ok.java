package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.util.Log;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractC12348ok implements InterfaceC12347n {

    /* renamed from: a */
    protected final C12534ok f34808a;

    /* renamed from: bl */
    protected final String f34809bl;

    /* renamed from: ok */
    protected final Context f34810ok;

    public AbstractC12348ok(Context context, C12534ok c12534ok, String str) {
        this.f34810ok = context;
        this.f34808a = c12534ok;
        this.f34809bl = str;
    }

    /* renamed from: ok */
    public boolean m18109ok() {
        if (this.f34810ok == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            if (C12409ok.m17899ok()) {
                Log.e("AbsDevicePlan", "check is valid failed!", th);
            }
        }
        return mo18106a().resolveActivity(this.f34810ok.getPackageManager()) != null;
    }
}
