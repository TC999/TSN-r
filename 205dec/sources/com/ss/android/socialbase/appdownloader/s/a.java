package com.ss.android.socialbase.appdownloader.s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.bl.h;
import com.ss.android.socialbase.appdownloader.s;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.j;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.q.kf;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements j {

    /* renamed from: a  reason: collision with root package name */
    private BroadcastReceiver f49195a;
    private List<Integer> ok;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<DownloadInfo> list, int i4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        h rh = s.k().rh();
        if (rh != null) {
            rh.ok(list);
        }
        Context l4 = bl.l();
        if (l4 == null) {
            return;
        }
        boolean a4 = kf.a(l4);
        for (DownloadInfo downloadInfo : list) {
            ok(l4, downloadInfo, a4, i4);
        }
        List<Integer> list2 = this.ok;
        if (list2 == null || list2.isEmpty() || this.f49195a != null) {
            return;
        }
        this.f49195a = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.s.a.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (kf.a(applicationContext)) {
                    com.ss.android.socialbase.downloader.bl.ok.a("LaunchResume", "onReceive : wifi connected !!!");
                    bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.s.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (a.this.ok != null && !a.this.ok.isEmpty()) {
                                    int size = a.this.ok.size();
                                    Integer[] numArr = new Integer[size];
                                    a.this.ok.toArray(numArr);
                                    a.this.ok.clear();
                                    for (int i5 = 0; i5 < size; i5++) {
                                        DownloadInfo downloadInfo2 = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i5].intValue());
                                        if (downloadInfo2 != null && (downloadInfo2.getRealStatus() == -5 || (downloadInfo2.getRealStatus() == -2 && downloadInfo2.isPauseReserveOnWifi()))) {
                                            a.this.ok(applicationContext, downloadInfo2, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(a.this.f49195a);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    a.this.f49195a = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            l4.registerReceiver(this.f49195a, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.f49195a = null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public List<String> ok() {
        return com.ss.android.socialbase.appdownloader.bl.bl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.j
    public void ok(final List<DownloadInfo> list, final int i4) {
        if (kf.s()) {
            bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.s.a.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.a(list, i4);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } else {
            a(list, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ok(android.content.Context r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, boolean r23, int r24) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.s.a.ok(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, int):void");
    }

    private void ok(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.h.ok ok = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
        int ok2 = ok.ok("paused_resume_max_count", 0);
        double ok3 = ok.ok("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < ok2 && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < ok3 * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.ok n4 = com.ss.android.socialbase.downloader.notification.a.ok().n(downloadInfo.getId());
            if (n4 == null) {
                n4 = new com.ss.android.socialbase.appdownloader.n.ok(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.a.ok().ok(n4);
            } else {
                n4.ok(downloadInfo);
            }
            n4.a(downloadInfo.getTotalBytes());
            n4.ok(downloadInfo.getCurBytes());
            n4.ok(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean ok(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a("uninstall_can_not_resume_for_force_task", false)) {
            return kf.ok(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
