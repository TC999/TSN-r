package com.ss.android.downloadlib.addownload.s;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {
    private static s ok;

    /* renamed from: a  reason: collision with root package name */
    private List<h> f48632a;

    private s() {
        ArrayList arrayList = new ArrayList();
        this.f48632a = arrayList;
        arrayList.add(new n());
        this.f48632a.add(new a());
        this.f48632a.add(new bl());
    }

    public static s ok() {
        if (ok == null) {
            synchronized (r.class) {
                if (ok == null) {
                    ok = new s();
                }
            }
        }
        return ok;
    }

    public void ok(com.ss.android.downloadad.api.ok.a aVar, int i4, p pVar, com.ss.android.downloadlib.addownload.ok.bl blVar) {
        DownloadInfo a4;
        List<h> list = this.f48632a;
        if (list == null || list.size() == 0 || aVar == null) {
            pVar.ok(aVar);
        }
        if (!TextUtils.isEmpty(aVar.ld())) {
            a4 = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).ok(aVar.ld(), null, true);
        } else {
            a4 = com.ss.android.downloadlib.p.ok(com.ss.android.downloadlib.addownload.r.getContext()).a(aVar.ok());
        }
        if (a4 == null) {
            a4 = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(aVar.zz());
        }
        if (a4 != null && "application/vnd.android.package-archive".equals(a4.getMimeType())) {
            if (new k().ok(aVar, i4, pVar)) {
                return;
            }
            for (h hVar : this.f48632a) {
                if (hVar.ok(aVar, i4, pVar, blVar)) {
                    return;
                }
            }
            pVar.ok(aVar);
            return;
        }
        pVar.ok(aVar);
    }
}
