package com.ss.android.downloadlib.addownload.s;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class r {
    private static r ok;

    /* renamed from: a  reason: collision with root package name */
    private List<q> f48631a;

    private r() {
        ArrayList arrayList = new ArrayList();
        this.f48631a = arrayList;
        arrayList.add(new k());
        this.f48631a.add(new j());
        this.f48631a.add(new kf());
        this.f48631a.add(new ok());
    }

    public static r ok() {
        if (ok == null) {
            synchronized (r.class) {
                if (ok == null) {
                    ok = new r();
                }
            }
        }
        return ok;
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar, int i4, p pVar) {
        DownloadInfo a4;
        List<q> list = this.f48631a;
        if (list != null && list.size() != 0 && aVar != null) {
            if (!TextUtils.isEmpty(aVar.ld())) {
                a4 = com.ss.android.downloadlib.p.ok((Context) null).ok(aVar.ld(), null, true);
            } else {
                a4 = com.ss.android.downloadlib.p.ok((Context) null).a(aVar.ok());
            }
            if (a4 != null && "application/vnd.android.package-archive".equals(a4.getMimeType())) {
                boolean z3 = com.ss.android.socialbase.downloader.h.ok.ok(aVar.zz()).ok("pause_optimise_switch", 0) == 1;
                for (q qVar : this.f48631a) {
                    if (z3 || (qVar instanceof j)) {
                        if (qVar.ok(aVar, i4, pVar)) {
                            return;
                        }
                    }
                }
                pVar.ok(aVar);
                return;
            }
            pVar.ok(aVar);
            return;
        }
        pVar.ok(aVar);
    }
}
