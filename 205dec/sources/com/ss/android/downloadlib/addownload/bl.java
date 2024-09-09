package com.ss.android.downloadlib.addownload;

import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bl f48392a = null;
    private static String ok = "bl";
    private ConcurrentHashMap<Long, Runnable> bl;

    public bl() {
        this.bl = null;
        this.bl = new ConcurrentHashMap<>();
    }

    public static bl ok() {
        if (f48392a == null) {
            synchronized (bl.class) {
                if (f48392a == null) {
                    f48392a = new bl();
                }
            }
        }
        return f48392a;
    }

    public long a() {
        return r.q().optLong("quick_app_check_internal", 1200L);
    }

    public void ok(n nVar, boolean z3, int i4, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i4 == 4) {
            if (!z3) {
                ok(id, false, 2);
                nVar.a(false);
                return;
            }
            ok(id, true, 2);
        } else if (i4 == 5) {
            if (!z3) {
                ok(id, false, 1);
                nVar.bl(false);
                return;
            }
            ok(id, true, 1);
        } else if (i4 != 7) {
        } else {
            Runnable remove = this.bl.remove(Long.valueOf(id));
            if (z3) {
                com.ss.android.downloadlib.s.ok.ok().ok(id, 1);
                ok(id, true, 1);
                return;
            }
            if (remove != null) {
                com.ss.android.downloadlib.h.ok().a().post(remove);
            }
            ok(id, false, 1);
        }
    }

    private void ok(long j4, boolean z3, int i4) {
        com.ss.android.downloadlib.s.ok.ok().ok(j4, z3, i4);
        if (z3) {
            r.io().ok(null, null, null, null, null, 3);
        }
    }

    public void ok(final n nVar, final int i4, final DownloadModel downloadModel) {
        com.ss.android.downloadlib.a.n.ok().ok(new com.ss.android.downloadlib.a.s() { // from class: com.ss.android.downloadlib.addownload.bl.1
            @Override // com.ss.android.downloadlib.a.s
            public void ok(boolean z3) {
                bl.this.ok(nVar, z3, i4, downloadModel);
            }
        }, a());
    }

    public static boolean ok(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
