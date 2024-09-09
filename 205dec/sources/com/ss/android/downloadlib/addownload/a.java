package com.ss.android.downloadlib.addownload;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    private static volatile a ok;

    /* renamed from: a  reason: collision with root package name */
    private Handler f48353a = null;

    public static a ok() {
        if (ok == null) {
            synchronized (a.class) {
                if (ok == null) {
                    ok = new a();
                }
            }
        }
        return ok;
    }

    public boolean a() {
        return r.q().optInt("forbid_invalidte_download_file_install", 0) == 1;
    }

    public void ok(Context context, DownloadInfo downloadInfo) {
        if (a() && downloadInfo != null) {
            try {
                File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
                if (file.isFile() && file.exists()) {
                    file.delete();
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (this.f48353a == null) {
                this.f48353a = new Handler(Looper.getMainLooper());
            }
            final String url = downloadInfo.getUrl();
            Downloader.getInstance(context).clearDownloadData(downloadInfo.getId());
            this.f48353a.post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.1
                @Override // java.lang.Runnable
                public void run() {
                    r.bl().ok(3, r.getContext(), null, "\u4e0b\u8f7d\u5931\u8d25\uff0c\u8bf7\u91cd\u8bd5\uff01", null, 0);
                    n ok2 = com.ss.android.downloadlib.h.ok().ok(url);
                    if (ok2 != null) {
                        ok2.h();
                    }
                }
            });
        }
    }
}
