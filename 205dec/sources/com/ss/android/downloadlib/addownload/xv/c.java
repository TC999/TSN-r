package com.ss.android.downloadlib.addownload.xv;

import com.ss.android.downloadlib.r.a;
import com.ss.android.downloadlib.r.k;
import com.ss.android.socialbase.downloader.depend.ia;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c implements s {

    /* renamed from: c  reason: collision with root package name */
    private int f48736c;

    private long w(com.ss.android.socialbase.downloader.r.c cVar) {
        long c4 = cVar.c("clear_space_sleep_time", 0L);
        if (c4 <= 0) {
            return 0L;
        }
        if (c4 > 5000) {
            c4 = 5000;
        }
        k.w("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + c4, null);
        try {
            Thread.sleep(c4);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        k.w("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return c4;
    }

    public void c(int i4) {
        this.f48736c = i4;
    }

    public boolean c(long j4, long j5, ia iaVar) {
        long j6;
        com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(this.f48736c);
        if (c(c4)) {
            long currentTimeMillis = System.currentTimeMillis();
            sr.c().xv();
            long w3 = a.w(0L);
            c();
            long w4 = a.w(0L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (w4 < j5) {
                long w5 = w(c4);
                if (w5 > 0) {
                    w4 = a.w(0L);
                }
                j6 = w5;
            } else {
                j6 = 0;
            }
            k.w("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j5 + ", byteAvailableAfter = " + w4 + ", cleaned = " + (w4 - w3), null);
            c(w3, w4, j5, currentTimeMillis2, j6);
            if (w4 < j5) {
                return false;
            }
            if (iaVar != null) {
                iaVar.c();
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean c(com.ss.android.socialbase.downloader.r.c cVar) {
        if (cVar.c("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - sr.c().w() >= cVar.c("clear_space_min_time_interval", 600000L);
    }

    private void c() {
        com.ss.android.download.api.config.ux fp = com.ss.android.downloadlib.addownload.k.fp();
        if (fp != null) {
            fp.c();
        }
        xv.c();
        xv.w();
    }

    private void c(long j4, long j5, long j6, long j7, long j8) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.k.getContext()).getDownloadInfo(this.f48736c);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.c.c().c(downloadInfo, j4, j5, j6, j7, j8, j5 > j6);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
