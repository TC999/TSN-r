package com.p521ss.android.downloadlib.addownload.p529bl;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.p521ss.android.download.api.config.InterfaceC11961n;
import com.p521ss.android.downloadlib.C12238ok;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.downloadlib.p534h.C12216r;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12475td;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12482x;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;

/* renamed from: com.ss.android.downloadlib.addownload.bl.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12051ok implements InterfaceC12475td {

    /* renamed from: ok */
    private int f34114ok;

    /* renamed from: a */
    private long m19253a(C12534ok c12534ok) {
        long m17592ok = c12534ok.m17592ok("clear_space_sleep_time", 0L);
        if (m17592ok <= 0) {
            return 0L;
        }
        if (m17592ok > 5000) {
            m17592ok = 5000;
        }
        C12216r.m18677a("AppDownloadDiskSpaceHandler", "waiting for space clear, sleepTime = " + m17592ok, null);
        try {
            Thread.sleep(m17592ok);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        C12216r.m18677a("AppDownloadDiskSpaceHandler", "waiting end!", null);
        return m17592ok;
    }

    /* renamed from: ok */
    public void m19251ok(int i) {
        this.f34114ok = i;
    }

    @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12475td
    /* renamed from: ok */
    public boolean mo16654ok(long j, long j2, InterfaceC12482x interfaceC12482x) {
        long j3;
        C12534ok m17599ok = C12534ok.m17599ok(this.f34114ok);
        if (m19249ok(m17599ok)) {
            long currentTimeMillis = System.currentTimeMillis();
            C12052s.m19245ok().m19246bl();
            long m18808a = C12197j.m18808a(0L);
            m19252ok();
            long m18808a2 = C12197j.m18808a(0L);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (m18808a2 < j2) {
                long m19253a = m19253a(m17599ok);
                if (m19253a > 0) {
                    m18808a2 = C12197j.m18808a(0L);
                }
                j3 = m19253a;
            } else {
                j3 = 0;
            }
            C12216r.m18677a("AppDownloadDiskSpaceHandler", "cleanUpDisk, byteRequired = " + j2 + ", byteAvailableAfter = " + m18808a2 + ", cleaned = " + (m18808a2 - m18808a), null);
            m19250ok(m18808a, m18808a2, j2, currentTimeMillis2, j3);
            if (m18808a2 < j2) {
                return false;
            }
            if (interfaceC12482x != null) {
                interfaceC12482x.mo16653ok();
                return true;
            }
            return true;
        }
        return false;
    }

    /* renamed from: ok */
    private boolean m19249ok(C12534ok c12534ok) {
        if (c12534ok.m17593ok("clear_space_use_disk_handler", 0) != 1) {
            return false;
        }
        return System.currentTimeMillis() - C12052s.m19245ok().m19248a() >= c12534ok.m17592ok("clear_space_min_time_interval", TTAdConstant.AD_MAX_EVENT_TIME);
    }

    /* renamed from: ok */
    private void m19252ok() {
        InterfaceC11961n m18966i = C12128r.m18966i();
        if (m18966i != null) {
            m18966i.m19649ok();
        }
        C12049bl.m19257ok();
        C12049bl.m19258a();
    }

    /* renamed from: ok */
    private void m19250ok(long j, long j2, long j3, long j4, long j5) {
        DownloadInfo downloadInfo = Downloader.getInstance(C12128r.getContext()).getDownloadInfo(this.f34114ok);
        if (downloadInfo == null) {
            return;
        }
        try {
            C12238ok.m18626ok().m18617ok(downloadInfo, j, j2, j3, j4, j5, j2 > j3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
