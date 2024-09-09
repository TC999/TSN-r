package com.ss.android.socialbase.appdownloader.sr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ss.android.socialbase.appdownloader.sr;
import com.ss.android.socialbase.appdownloader.xv.r;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.a;
import com.ss.android.socialbase.downloader.downloader.xv;
import com.ss.android.socialbase.downloader.gd.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w implements a {

    /* renamed from: c  reason: collision with root package name */
    private List<Integer> f49217c;

    /* renamed from: w  reason: collision with root package name */
    private BroadcastReceiver f49218w;

    /* JADX INFO: Access modifiers changed from: private */
    public void w(List<DownloadInfo> list, int i4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        r t3 = sr.p().t();
        if (t3 != null) {
            t3.c(list);
        }
        Context gw = xv.gw();
        if (gw == null) {
            return;
        }
        boolean w3 = f.w(gw);
        for (DownloadInfo downloadInfo : list) {
            c(gw, downloadInfo, w3, i4);
        }
        List<Integer> list2 = this.f49217c;
        if (list2 == null || list2.isEmpty() || this.f49218w != null) {
            return;
        }
        this.f49218w = new BroadcastReceiver() { // from class: com.ss.android.socialbase.appdownloader.sr.w.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                final Context applicationContext = context.getApplicationContext();
                if (f.w(applicationContext)) {
                    com.ss.android.socialbase.downloader.xv.c.w("LaunchResume", "onReceive : wifi connected !!!");
                    xv.a().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.sr.w.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                if (w.this.f49217c != null && !w.this.f49217c.isEmpty()) {
                                    int size = w.this.f49217c.size();
                                    Integer[] numArr = new Integer[size];
                                    w.this.f49217c.toArray(numArr);
                                    w.this.f49217c.clear();
                                    for (int i5 = 0; i5 < size; i5++) {
                                        DownloadInfo downloadInfo2 = Downloader.getInstance(applicationContext).getDownloadInfo(numArr[i5].intValue());
                                        if (downloadInfo2 != null && (downloadInfo2.getRealStatus() == -5 || (downloadInfo2.getRealStatus() == -2 && downloadInfo2.isPauseReserveOnWifi()))) {
                                            w.this.c(applicationContext, downloadInfo2, true, 2);
                                        }
                                    }
                                }
                            } catch (Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                    });
                    try {
                        applicationContext.unregisterReceiver(w.this.f49218w);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    w.this.f49218w = null;
                }
            }
        };
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            gw.registerReceiver(this.f49218w, intentFilter);
        } catch (Throwable th) {
            th.printStackTrace();
            this.f49218w = null;
        }
    }

    public List<String> c() {
        return com.ss.android.socialbase.appdownloader.xv.xv();
    }

    public void c(final List<DownloadInfo> list, final int i4) {
        if (f.sr()) {
            xv.a().execute(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.sr.w.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        w.this.w(list, i4);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
            });
        } else {
            w(list, i4);
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
    public void c(android.content.Context r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, boolean r23, int r24) {
        /*
            Method dump skipped, instructions count: 641
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.sr.w.c(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, boolean, int):void");
    }

    private void c(DownloadInfo downloadInfo, Context context) {
        com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId());
        int c5 = c4.c("paused_resume_max_count", 0);
        double c6 = c4.c("paused_resume_max_hours", 72.0d);
        int pausedResumeCount = downloadInfo.getPausedResumeCount();
        if (pausedResumeCount < c5 && ((double) (System.currentTimeMillis() - downloadInfo.getLastDownloadTime())) < c6 * 3600000.0d) {
            com.ss.android.socialbase.downloader.notification.c ux = com.ss.android.socialbase.downloader.notification.w.c().ux(downloadInfo.getId());
            if (ux == null) {
                ux = new com.ss.android.socialbase.appdownloader.ux.c(context, downloadInfo.getId(), downloadInfo.getTitle(), downloadInfo.getSavePath(), downloadInfo.getName(), downloadInfo.getExtra());
                com.ss.android.socialbase.downloader.notification.w.c().c(ux);
            } else {
                ux.c(downloadInfo);
            }
            ux.w(downloadInfo.getTotalBytes());
            ux.c(downloadInfo.getCurBytes());
            ux.c(downloadInfo.getStatus(), null, false, false);
            downloadInfo.setPausedResumeCount(pausedResumeCount + 1);
            downloadInfo.updateSpData();
        }
    }

    private boolean c(DownloadInfo downloadInfo) {
        if (com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).w("uninstall_can_not_resume_for_force_task", false)) {
            return f.c(downloadInfo, false, downloadInfo.getMd5());
        }
        return downloadInfo.isDownloaded();
    }
}
