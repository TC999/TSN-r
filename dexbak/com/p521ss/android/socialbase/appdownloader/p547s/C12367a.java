package com.p521ss.android.socialbase.appdownloader.p547s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12298h;
import com.p521ss.android.socialbase.appdownloader.p545n.C12335ok;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12500j;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.notification.AbstractC12645ok;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.List;

/* renamed from: com.ss.android.socialbase.appdownloader.s.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12367a implements InterfaceC12500j {

    /* renamed from: a */
    private BroadcastReceiver f34860a;

    /* renamed from: ok */
    private List<Integer> f34861ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m18031a(List<DownloadInfo> list, int i) {
        if (list == null || list.isEmpty()) {
            return;
        }
        InterfaceC12298h m18042rh = C12361s.m18068k().m18042rh();
        if (m18042rh != null) {
            m18042rh.mo18402ok(list);
        }
        Context m17807l = C12490bl.m17807l();
        if (m17807l == null) {
            return;
        }
        boolean m16620a = C12713kf.m16620a(m17807l);
        for (DownloadInfo downloadInfo : list) {
            m18030ok(m17807l, downloadInfo, m16620a, i);
        }
        List<Integer> list2 = this.f34861ok;
        if (list2 == null || list2.isEmpty() || this.f34860a != null) {
            return;
        }
        this.f34860a = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.s.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (C12713kf.m16620a(applicationContext)) {
                    C12409ok.m17904a("LaunchResume", "onReceive : wifi connected !!!");
                    C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.s.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (C12367a.this.f34861ok != null && !C12367a.this.f34861ok.isEmpty()) {
                                    int size = C12367a.this.f34861ok.size();
                                    Integer[] numArr = new Integer[size];
                                    C12367a.this.f34861ok.toArray(numArr);
                                    C12367a.this.f34861ok.clear();
                                    for (int i2 = 0; i2 < size; i2++) {
                                        DownloadInfo downloadInfo2 = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i2].intValue());
                                        if (downloadInfo2 != null && (downloadInfo2.getRealStatus() == -5 || (downloadInfo2.getRealStatus() == -2 && downloadInfo2.isPauseReserveOnWifi()))) {
                                            C12367a.this.m18030ok(applicationContext, downloadInfo2, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(C12367a.this.f34860a);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    C12367a.this.f34860a = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            m17807l.registerReceiver(this.f34860a, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.f34860a = null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12500j
    /* renamed from: ok */
    public List<String> mo17737ok() {
        return C12293bl.m18437bl();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12500j
    /* renamed from: ok */
    public void mo17736ok(final List<DownloadInfo> list, final int i) {
        if (C12713kf.m16522s()) {
            C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.s.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C12367a.this.m18031a(list, i);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } else {
            m18031a(list, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bf  */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m18030ok(android.content.Context r21, com.p521ss.android.socialbase.downloader.model.DownloadInfo r22, boolean r23, int r24) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.appdownloader.p547s.C12367a.m18030ok(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, int):void");
    }

    /* renamed from: ok */
    private void m18024ok(DownloadInfo downloadInfo, Context context) {
        C12534ok m17599ok = C12534ok.m17599ok(downloadInfo.getId());
        int m17593ok = m17599ok.m17593ok("paused_resume_max_count", 0);
        double m17594ok = m17599ok.m17594ok("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < m17593ok && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < m17594ok * 3600000.0d) {
            AbstractC12645ok m16877n = C12644a.m16876ok().m16877n(downloadInfo.getId());
            if (m16877n == null) {
                m16877n = new C12335ok(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                C12644a.m16876ok().m16872ok(m16877n);
            } else {
                m16877n.mo16857ok(downloadInfo);
            }
            m16877n.m16869a(downloadInfo.getTotalBytes());
            m16877n.m16861ok(downloadInfo.getCurBytes());
            m16877n.m16862ok(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    /* renamed from: ok */
    private boolean m18025ok(DownloadInfo downloadInfo) {
        if (C12534ok.m17599ok(downloadInfo.getId()).m17606a("uninstall_can_not_resume_for_force_task", false)) {
            return C12713kf.m16558ok(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
