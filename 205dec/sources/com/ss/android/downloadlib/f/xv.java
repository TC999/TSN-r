package com.ss.android.downloadlib.f;

import com.ss.android.socialbase.appdownloader.xv.gd;
import com.ss.android.socialbase.appdownloader.xv.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements p {

    /* renamed from: c  reason: collision with root package name */
    private static volatile xv f48819c;

    /* renamed from: w  reason: collision with root package name */
    private List<p> f48820w;

    private xv() {
        ArrayList arrayList = new ArrayList();
        this.f48820w = arrayList;
        arrayList.add(new w());
        this.f48820w.add(new c());
    }

    public static xv c() {
        if (f48819c == null) {
            synchronized (xv.class) {
                if (f48819c == null) {
                    f48819c = new xv();
                }
            }
        }
        return f48819c;
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.p
    public void c(DownloadInfo downloadInfo, gd gdVar) {
        if (downloadInfo != null && this.f48820w.size() != 0) {
            c(downloadInfo, 0, gdVar);
        } else if (gdVar != null) {
            gdVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final DownloadInfo downloadInfo, final int i4, final gd gdVar) {
        if (i4 != this.f48820w.size() && i4 >= 0) {
            this.f48820w.get(i4).c(downloadInfo, new gd() { // from class: com.ss.android.downloadlib.f.xv.1
                @Override // com.ss.android.socialbase.appdownloader.xv.gd
                public void c() {
                    xv.this.c(downloadInfo, i4 + 1, gdVar);
                }
            });
        } else {
            gdVar.c();
        }
    }
}
