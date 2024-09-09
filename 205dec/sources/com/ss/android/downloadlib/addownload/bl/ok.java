package com.ss.android.downloadlib.addownload.bl;

import com.ss.android.downloadlib.h.j;
import com.ss.android.downloadlib.h.r;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok implements td {
    private int ok;

    private long a(com.ss.android.socialbase.downloader.h.ok okVar) {
        long ok = okVar.ok("clear_space_sleep_time", 0L);
        if (ok <= 0) {
            return 0L;
        }
        if (ok > 5000) {
            ok = 5000;
        }
        r.a("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + ok, null);
        try {
            Thread.sleep(ok);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        r.a("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return ok;
    }

    public void ok(int i4) {
        this.ok = i4;
    }

    @Override // com.ss.android.socialbase.downloader.depend.td
    public boolean ok(long j4, long j5, x xVar) {
        long j6;
        com.ss.android.socialbase.downloader.h.ok ok = com.ss.android.socialbase.downloader.h.ok.ok(this.ok);
        if (ok(ok)) {
            long currentTimeMillis = System.currentTimeMillis();
            s.ok().bl();
            long a4 = j.a(0L);
            ok();
            long a5 = j.a(0L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (a5 < j5) {
                long a6 = a(ok);
                if (a6 > 0) {
                    a5 = j.a(0L);
                }
                j6 = a6;
            } else {
                j6 = 0;
            }
            r.a("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j5 + ", byteAvailableAfter = " + a5 + ", cleaned = " + (a5 - a4), null);
            ok(a4, a5, j5, currentTimeMillis2, j6);
            if (a5 < j5) {
                return false;
            }
            if (xVar != null) {
                xVar.ok();
                return true;
            }
            return true;
        }
        return false;
    }

    private boolean ok(com.ss.android.socialbase.downloader.h.ok okVar) {
        if (okVar.ok("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - s.ok().a() >= okVar.ok("clear_space_min_time_interval", 600000L);
    }

    private void ok() {
        com.ss.android.download.api.config.n i4 = com.ss.android.downloadlib.addownload.r.i();
        if (i4 != null) {
            i4.ok();
        }
        bl.ok();
        bl.a();
    }

    private void ok(long j4, long j5, long j6, long j7, long j8) {
        DownloadInfo downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).getDownloadInfo(this.ok);
        if (downloadInfo == null) {
            return;
        }
        try {
            com.ss.android.downloadlib.ok.ok().ok(downloadInfo, j4, j5, j6, j7, j8, j5 > j6);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
