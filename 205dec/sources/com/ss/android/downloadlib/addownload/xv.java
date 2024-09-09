package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {

    /* renamed from: c  reason: collision with root package name */
    private static String f48732c = "xv";

    /* renamed from: w  reason: collision with root package name */
    private static volatile xv f48733w;
    private ConcurrentHashMap<Long, Runnable> xv;

    public xv() {
        this.xv = null;
        this.xv = new ConcurrentHashMap<>();
    }

    public static xv c() {
        if (f48733w == null) {
            synchronized (xv.class) {
                if (f48733w == null) {
                    f48733w = new xv();
                }
            }
        }
        return f48733w;
    }

    public long w() {
        return k.gd().optLong("quick_app_check_internal", 1200L);
    }

    public void c(ux uxVar, boolean z3, int i4, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i4 == 4) {
            if (!z3) {
                c(id, false, 2);
                uxVar.w(false);
                return;
            }
            c(id, true, 2);
        } else if (i4 == 5) {
            if (!z3) {
                c(id, false, 1);
                uxVar.xv(false);
                return;
            }
            c(id, true, 1);
        } else if (i4 != 7) {
        } else {
            Runnable remove = this.xv.remove(Long.valueOf(id));
            if (z3) {
                com.ss.android.downloadlib.sr.c.c().c(id, 1);
                c(id, true, 1);
                return;
            }
            if (remove != null) {
                com.ss.android.downloadlib.r.c().w().post(remove);
            }
            c(id, false, 1);
        }
    }

    private void c(long j4, boolean z3, int i4) {
        com.ss.android.downloadlib.sr.c.c().c(j4, z3, i4);
        if (z3) {
            k.i().c(null, null, null, null, null, 3);
        }
    }

    public void c(final ux uxVar, final int i4, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.w.ux.c().c(new com.ss.android.downloadlib.w.sr() { // from class: com.ss.android.downloadlib.addownload.xv.1
            @Override // com.ss.android.downloadlib.w.sr
            public void c(boolean z3) {
                xv.this.c(uxVar, z3, i4, downloadModel);
            }
        }, w());
    }

    public static boolean c(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
