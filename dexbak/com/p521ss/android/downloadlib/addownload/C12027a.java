package com.p521ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.p521ss.android.downloadlib.C12184h;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* renamed from: com.ss.android.downloadlib.addownload.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12027a {

    /* renamed from: ok */
    private static volatile C12027a f34044ok;

    /* renamed from: a */
    private Handler f34045a = null;

    /* renamed from: ok */
    public static C12027a m19343ok() {
        if (f34044ok == null) {
            synchronized (C12027a.class) {
                if (f34044ok == null) {
                    f34044ok = new C12027a();
                }
            }
        }
        return f34044ok;
    }

    /* renamed from: a */
    public boolean m19344a() {
        return C12128r.m18946q().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    /* renamed from: ok */
    public void m19342ok(Context context, DownloadInfo downloadInfo) {
        if (m19344a() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (this.f34045a == null) {
                this.f34045a = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.f34045a.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.1
                @Override // java.lang.Runnable
                public void run() {
                    C12128r.m18968bl().mo19528ok(3, C12128r.getContext(), null, "下载失败，请重试！", null, 0);
                    C12095n m18826ok = C12184h.m18835ok().m18826ok(url);
                    if (m18826ok != null) {
                        m18826ok.m19097h();
                    }
                }
            });
        }
    }
}
