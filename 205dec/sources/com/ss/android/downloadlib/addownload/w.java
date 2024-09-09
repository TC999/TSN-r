package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static volatile w f48698c;

    /* renamed from: w  reason: collision with root package name */
    private Handler f48699w = null;

    public static w c() {
        if (f48698c == null) {
            synchronized (w.class) {
                if (f48698c == null) {
                    f48698c = new w();
                }
            }
        }
        return f48698c;
    }

    public boolean w() {
        return k.gd().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void c(Context context, DownloadInfo downloadInfo) {
        if (w() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (this.f48699w == null) {
                this.f48699w = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.f48699w.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.w.1
                @Override // java.lang.Runnable
                public void run() {
                    k.xv().c(3, k.getContext(), null, "\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\uff01", null, 0);
                    ux c4 = com.ss.android.downloadlib.r.c().c(url);
                    if (c4 != null) {
                        c4.r();
                    }
                }
            });
        }
    }
}
