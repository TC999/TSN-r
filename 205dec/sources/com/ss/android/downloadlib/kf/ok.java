package com.ss.android.downloadlib.kf;

import androidx.annotation.NonNull;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.a.kf;
import com.ss.android.socialbase.appdownloader.bl.k;
import com.ss.android.socialbase.appdownloader.bl.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok implements k {
    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.ok okVar) {
        com.ss.android.downloadad.api.ok.a ok = kf.ok().ok(downloadInfo);
        boolean ok2 = com.ss.android.downloadlib.a.kf.ok(ok);
        boolean a4 = com.ss.android.downloadlib.a.kf.a(ok);
        if (ok2 && a4) {
            com.ss.android.downloadlib.a.bl.ok(ok, new com.ss.android.downloadlib.guide.install.ok() { // from class: com.ss.android.downloadlib.kf.ok.3
                @Override // com.ss.android.downloadlib.guide.install.ok
                public void ok() {
                    okVar.ok();
                }
            });
        } else {
            okVar.ok();
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.bl.k
    public void ok(DownloadInfo downloadInfo, final q qVar) {
        ok(downloadInfo, new com.ss.android.downloadlib.guide.install.ok() { // from class: com.ss.android.downloadlib.kf.ok.1
            @Override // com.ss.android.downloadlib.guide.install.ok
            public void ok() {
                qVar.ok();
            }
        });
    }

    public void ok(final DownloadInfo downloadInfo, @NonNull final com.ss.android.downloadlib.guide.install.ok okVar) {
        com.ss.android.downloadad.api.ok.a ok = kf.ok().ok(downloadInfo);
        if (ok != null && com.ss.android.downloadlib.a.q.ok(ok)) {
            TTDelegateActivity.ok(ok, new com.ss.android.downloadlib.guide.install.ok() { // from class: com.ss.android.downloadlib.kf.ok.2
                @Override // com.ss.android.downloadlib.guide.install.ok
                public void ok() {
                    ok.this.a(downloadInfo, okVar);
                }
            });
        } else {
            a(downloadInfo, okVar);
        }
    }
}
