package com.p521ss.android.socialbase.downloader.p556q;

import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;

/* renamed from: com.ss.android.socialbase.downloader.q.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12720s {
    /* renamed from: a */
    public static boolean m16498a(DownloadInfo downloadInfo) {
        return downloadInfo != null && C12534ok.m17599ok(downloadInfo.getId()).m17607a("optimize_save_path") == 1;
    }

    /* renamed from: ok */
    public static boolean m16497ok(DownloadInfo downloadInfo) {
        return downloadInfo != null && C12534ok.m17599ok(downloadInfo.getId()).m17607a("optimize_head_request") == 1;
    }
}
