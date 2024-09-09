package com.ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.ss.android.downloadlib.h.j;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f48936a;
    private ScheduledExecutorService bl;
    private ExecutorService ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {
        private static s ok = new s();
    }

    public static s ok() {
        return ok.ok;
    }

    public void a(Runnable runnable) {
        a(runnable, false);
    }

    public ExecutorService bl() {
        if (this.f48936a == null) {
            synchronized (s.class) {
                if (this.f48936a == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.f48936a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.p.ok(p.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.f48936a;
    }

    public void n() {
        ok(new Runnable() { // from class: com.ss.android.downloadlib.s.1
            @Override // java.lang.Runnable
            public void run() {
                k m4;
                synchronized (s.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i4 = 0; i4 < 13; i4++) {
                            SharedPreferences sharedPreferences = com.ss.android.downloadlib.addownload.r.getContext().getSharedPreferences(strArr[i4], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        m4 = com.ss.android.socialbase.downloader.downloader.bl.m();
                    } catch (Throwable unused) {
                    }
                    if (m4 instanceof com.ss.android.socialbase.downloader.impls.s) {
                        SparseArray<DownloadInfo> ok2 = ((com.ss.android.socialbase.downloader.impls.s) m4).ok().ok();
                        for (int size = ok2.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = ok2.get(ok2.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(com.ss.android.downloadlib.addownload.r.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    }
                }
            }
        });
    }

    public ScheduledExecutorService s() {
        if (this.bl == null) {
            synchronized (s.class) {
                if (this.bl == null) {
                    this.bl = new ScheduledThreadPoolExecutor(0, new com.ss.android.socialbase.downloader.p.ok(p.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.bl;
    }

    private s() {
    }

    public void a(Runnable runnable, boolean z3) {
        if (runnable == null) {
            return;
        }
        if (z3 && !j.a()) {
            runnable.run();
        } else {
            bl().execute(runnable);
        }
    }

    public void ok(Runnable runnable) {
        ok(runnable, false);
    }

    public void ok(Runnable runnable, boolean z3) {
        if (runnable == null) {
            return;
        }
        if (z3 && !j.a()) {
            runnable.run();
        } else {
            a().execute(runnable);
        }
    }

    public ExecutorService a() {
        if (this.ok == null) {
            synchronized (s.class) {
                if (this.ok == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.ok = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new com.ss.android.socialbase.downloader.p.ok(p.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.ok;
    }

    public void ok(Runnable runnable, long j4) {
        try {
            s().schedule(runnable, j4, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
