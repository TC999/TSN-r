package com.ss.android.socialbase.downloader.gd;

import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {
    public static boolean c(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).w("optimize_head_request") == 1;
    }

    public static boolean w(DownloadInfo downloadInfo) {
        return downloadInfo != null && com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).w("optimize_save_path") == 1;
    }
}
