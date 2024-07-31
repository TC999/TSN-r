package com.p521ss.android.downloadlib.addownload;

import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadlib.C12184h;
import com.p521ss.android.downloadlib.p527a.C12015n;
import com.p521ss.android.downloadlib.p527a.InterfaceC12024s;
import com.p521ss.android.downloadlib.p539s.C12270ok;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.ss.android.downloadlib.addownload.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12045bl {

    /* renamed from: a */
    private static volatile C12045bl f34104a = null;

    /* renamed from: ok */
    private static String f34105ok = "bl";

    /* renamed from: bl */
    private ConcurrentHashMap<Long, Runnable> f34106bl;

    public C12045bl() {
        this.f34106bl = null;
        this.f34106bl = new ConcurrentHashMap<>();
    }

    /* renamed from: ok */
    public static C12045bl m19263ok() {
        if (f34104a == null) {
            synchronized (C12045bl.class) {
                if (f34104a == null) {
                    f34104a = new C12045bl();
                }
            }
        }
        return f34104a;
    }

    /* renamed from: a */
    public long m19264a() {
        return C12128r.m18946q().optLong("quick_app_check_internal", 1200L);
    }

    /* renamed from: ok */
    public void m19260ok(C12095n c12095n, boolean z, int i, DownloadModel downloadModel) {
        if (downloadModel instanceof AdDownloadModel) {
            ((AdDownloadModel) downloadModel).setFunnelType(3);
        }
        long id = downloadModel.getId();
        if (i == 4) {
            if (!z) {
                m19262ok(id, false, 2);
                c12095n.m19102a(false);
                return;
            }
            m19262ok(id, true, 2);
        } else if (i == 5) {
            if (!z) {
                m19262ok(id, false, 1);
                c12095n.m19098bl(false);
                return;
            }
            m19262ok(id, true, 1);
        } else if (i != 7) {
        } else {
            Runnable remove = this.f34106bl.remove(Long.valueOf(id));
            if (z) {
                C12270ok.m18539ok().m18537ok(id, 1);
                m19262ok(id, true, 1);
                return;
            }
            if (remove != null) {
                C12184h.m18835ok().m18841a().post(remove);
            }
            m19262ok(id, false, 1);
        }
    }

    /* renamed from: ok */
    private void m19262ok(long j, boolean z, int i) {
        C12270ok.m18539ok().m18534ok(j, z, i);
        if (z) {
            C12128r.m18965io().mo18932ok(null, null, null, null, null, 3);
        }
    }

    /* renamed from: ok */
    public void m19261ok(final C12095n c12095n, final int i, final DownloadModel downloadModel) {
        C12015n.m19390ok().m19387ok(new InterfaceC12024s() { // from class: com.ss.android.downloadlib.addownload.bl.1
            @Override // com.p521ss.android.downloadlib.p527a.InterfaceC12024s
            /* renamed from: ok */
            public void mo18606ok(boolean z) {
                C12045bl.this.m19260ok(c12095n, z, i, downloadModel);
            }
        }, m19264a());
    }

    /* renamed from: ok */
    public static boolean m19259ok(DownloadInfo downloadInfo) {
        return downloadInfo == null || downloadInfo.getStatus() == 0 || downloadInfo.getStatus() == -4;
    }
}
