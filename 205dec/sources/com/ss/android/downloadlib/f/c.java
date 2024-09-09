package com.ss.android.downloadlib.f;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.w.f;
import com.ss.android.socialbase.appdownloader.xv.gd;
import com.ss.android.socialbase.appdownloader.xv.p;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c implements p {
    /* JADX INFO: Access modifiers changed from: private */
    public void w(DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.c cVar) {
        com.ss.android.downloadad.api.c.w c4 = f.c().c(downloadInfo);
        boolean c5 = com.ss.android.downloadlib.w.f.c(c4);
        boolean w3 = com.ss.android.downloadlib.w.f.w(c4);
        if (c5 && w3) {
            com.ss.android.downloadlib.w.xv.c(c4, new com.ss.android.downloadlib.guide.install.c() { // from class: com.ss.android.downloadlib.f.c.3
                @Override // com.ss.android.downloadlib.guide.install.c
                public void c() {
                    cVar.c();
                }
            });
        } else {
            cVar.c();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.xv.p
    public void c(DownloadInfo downloadInfo, final gd gdVar) {
        c(downloadInfo, new com.ss.android.downloadlib.guide.install.c() { // from class: com.ss.android.downloadlib.f.c.1
            @Override // com.ss.android.downloadlib.guide.install.c
            public void c() {
                gdVar.c();
            }
        });
    }

    public void c(final DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.c cVar) {
        com.ss.android.downloadad.api.c.w c4 = f.c().c(downloadInfo);
        if (c4 != null && com.ss.android.downloadlib.w.gd.c(c4)) {
            TTDelegateActivity.c(c4, new com.ss.android.downloadlib.guide.install.c() { // from class: com.ss.android.downloadlib.f.c.2
                @Override // com.ss.android.downloadlib.guide.install.c
                public void c() {
                    c.this.w(downloadInfo, cVar);
                }
            });
        } else {
            w(downloadInfo, cVar);
        }
    }
}
