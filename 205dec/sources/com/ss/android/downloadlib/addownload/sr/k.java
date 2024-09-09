package com.ss.android.downloadlib.addownload.sr;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class k {

    /* renamed from: c  reason: collision with root package name */
    private static k f48653c;

    /* renamed from: w  reason: collision with root package name */
    private List<gd> f48654w;

    private k() {
        ArrayList arrayList = new ArrayList();
        this.f48654w = arrayList;
        arrayList.add(new p());
        this.f48654w.add(new a());
        this.f48654w.add(new f());
        this.f48654w.add(new c());
    }

    public static k c() {
        if (f48653c == null) {
            synchronized (k.class) {
                if (f48653c == null) {
                    f48653c = new k();
                }
            }
        }
        return f48653c;
    }

    public void c(com.ss.android.downloadad.api.c.w wVar, int i4, ev evVar) {
        DownloadInfo w3;
        List<gd> list = this.f48654w;
        if (list != null && list.size() != 0 && wVar != null) {
            if (!TextUtils.isEmpty(wVar.te())) {
                w3 = com.ss.android.downloadlib.ev.c((Context) null).c(wVar.te(), null, true);
            } else {
                w3 = com.ss.android.downloadlib.ev.c((Context) null).w(wVar.c());
            }
            if (w3 != null && "application/vnd.android.package-archive".equals(w3.getMimeType())) {
                boolean z3 = com.ss.android.socialbase.downloader.r.c.c(wVar.fz()).c("pause_optimise_switch", 0) == 1;
                for (gd gdVar : this.f48654w) {
                    if (z3 || (gdVar instanceof a)) {
                        if (gdVar.c(wVar, i4, evVar)) {
                            return;
                        }
                    }
                }
                evVar.c(wVar);
                return;
            }
            evVar.c(wVar);
            return;
        }
        evVar.c(wVar);
    }
}
