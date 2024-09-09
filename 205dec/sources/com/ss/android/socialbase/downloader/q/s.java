package com.ss.android.socialbase.downloader.q;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {
    public static boolean a(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a("optimize_save_path") == 1;
    }

    public static boolean ok(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a("optimize_head_request") == 1;
    }
}
