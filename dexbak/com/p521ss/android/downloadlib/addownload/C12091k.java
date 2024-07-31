package com.p521ss.android.downloadlib.addownload;

import com.p521ss.android.download.api.model.DownloadShortInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;

/* renamed from: com.ss.android.downloadlib.addownload.k */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12091k {
    /* renamed from: ok */
    public static int m19121ok(int i, int i2) {
        return (i2 <= 0 || i2 >= 100 || !m19122ok(i)) ? i2 : (int) (Math.sqrt(i2) * 10.0d);
    }

    /* renamed from: ok */
    public static long m19120ok(int i, long j, long j2) {
        if (m19122ok(i)) {
            if (j <= 0) {
                return 0L;
            }
            return j2 <= 0 ? j : (j2 * m19121ok(i, (int) ((j * 100) / j2))) / 100;
        }
        return j;
    }

    /* renamed from: ok */
    public static DownloadShortInfo m19119ok(DownloadShortInfo downloadShortInfo) {
        if (downloadShortInfo != null && m19122ok((int) downloadShortInfo.f33852id)) {
            downloadShortInfo.currentBytes = m19120ok((int) downloadShortInfo.f33852id, downloadShortInfo.currentBytes, downloadShortInfo.totalBytes);
        }
        return downloadShortInfo;
    }

    /* renamed from: ok */
    private static boolean m19122ok(int i) {
        return C12534ok.m17599ok(i).m17593ok("pause_optimise_pretend_download_percent_switch", 0) == 1 && C12534ok.m17599ok(i).m17593ok("pause_optimise_switch", 0) == 1;
    }
}
