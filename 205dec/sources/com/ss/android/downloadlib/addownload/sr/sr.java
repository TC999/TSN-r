package com.ss.android.downloadlib.addownload.sr;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static sr f48655c;

    /* renamed from: w  reason: collision with root package name */
    private List<r> f48656w;

    private sr() {
        ArrayList arrayList = new ArrayList();
        this.f48656w = arrayList;
        arrayList.add(new ux());
        this.f48656w.add(new w());
        this.f48656w.add(new xv());
    }

    public static sr c() {
        if (f48655c == null) {
            synchronized (k.class) {
                if (f48655c == null) {
                    f48655c = new sr();
                }
            }
        }
        return f48655c;
    }

    public void c(com.ss.android.downloadad.api.c.w wVar, int i4, ev evVar, com.ss.android.downloadlib.addownload.c.xv xvVar) {
        DownloadInfo w3;
        List<r> list = this.f48656w;
        if (list == null || list.size() == 0 || wVar == null) {
            evVar.c(wVar);
        }
        if (!TextUtils.isEmpty(wVar.te())) {
            w3 = com.ss.android.downloadlib.ev.c(com.ss.android.downloadlib.addownload.k.getContext()).c(wVar.te(), null, true);
        } else {
            w3 = com.ss.android.downloadlib.ev.c(com.ss.android.downloadlib.addownload.k.getContext()).w(wVar.c());
        }
        if (w3 == null) {
            w3 = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.getContext()).getDownloadInfo(wVar.fz());
        }
        if (w3 != null && "application/vnd.android.package-archive".equals(w3.getMimeType())) {
            if (new p().c(wVar, i4, evVar)) {
                return;
            }
            for (r rVar : this.f48656w) {
                if (rVar.c(wVar, i4, evVar, xvVar)) {
                    return;
                }
            }
            evVar.c(wVar);
            return;
        }
        evVar.c(wVar);
    }
}
