package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.addownload.k;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f48938c;

    /* renamed from: w  reason: collision with root package name */
    private ExecutorService f48939w;
    private ScheduledExecutorService xv;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private static sr f48941c = new sr();
    }

    public static sr c() {
        return c.f48941c;
    }

    public ScheduledExecutorService sr() {
        if (this.xv == null) {
            synchronized (sr.class) {
                if (this.xv == null) {
                    this.xv = new com.bytedance.sdk.component.gd.sr.ux(0, new com.ss.android.socialbase.downloader.ev.c(ev.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.xv;
    }

    public void ux() {
        c(new Runnable() { // from class: com.ss.android.downloadlib.sr.1
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.downloader.p gb;
                synchronized (sr.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i4 = 0; i4 < 13; i4++) {
                            SharedPreferences sharedPreferences = k.getContext().getSharedPreferences(strArr[i4], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        gb = com.ss.android.socialbase.downloader.downloader.xv.gb();
                    } catch (Throwable unused) {
                    }
                    if (gb instanceof com.ss.android.socialbase.downloader.impls.sr) {
                        SparseArray c4 = ((com.ss.android.socialbase.downloader.impls.sr) gb).c().c();
                        for (int size = c4.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = (DownloadInfo) c4.get(c4.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(k.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    }
                }
            }
        });
    }

    public void w(Runnable runnable) {
        w(runnable, false);
    }

    public ExecutorService xv() {
        if (this.f48939w == null) {
            synchronized (sr.class) {
                if (this.f48939w == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.f48939w = new com.bytedance.sdk.component.gd.sr.sr(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.ev.c(ev.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.f48939w;
    }

    private sr() {
    }

    public void c(Runnable runnable) {
        c(runnable, false);
    }

    public void w(Runnable runnable, boolean z3) {
        if (runnable == null) {
            return;
        }
        if (z3 && !com.ss.android.downloadlib.r.a.w()) {
            runnable.run();
        } else {
            xv().execute(runnable);
        }
    }

    public void c(Runnable runnable, boolean z3) {
        if (runnable == null) {
            return;
        }
        if (z3 && !com.ss.android.downloadlib.r.a.w()) {
            runnable.run();
        } else {
            w().execute(runnable);
        }
    }

    public ExecutorService w() {
        if (this.f48938c == null) {
            synchronized (sr.class) {
                if (this.f48938c == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.f48938c = new com.bytedance.sdk.component.gd.sr.sr(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.ev.c(ev.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.f48938c;
    }

    public void c(Runnable runnable, long j4) {
        try {
            sr().schedule(runnable, j4, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
