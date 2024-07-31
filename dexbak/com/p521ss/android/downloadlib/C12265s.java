package com.p521ss.android.downloadlib;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.p534h.C12197j;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k;
import com.p521ss.android.socialbase.downloader.impls.C12558s;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p555p.ThreadFactoryC12662ok;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.ss.android.downloadlib.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12265s {

    /* renamed from: a */
    private ExecutorService f34605a;

    /* renamed from: bl */
    private ScheduledExecutorService f34606bl;

    /* renamed from: ok */
    private ExecutorService f34607ok;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.s$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12267ok {

        /* renamed from: ok */
        private static C12265s f34609ok = new C12265s();
    }

    /* renamed from: ok */
    public static C12265s m18554ok() {
        return C12267ok.f34609ok;
    }

    /* renamed from: a */
    public void m18558a(Runnable runnable) {
        m18557a(runnable, false);
    }

    /* renamed from: bl */
    public ExecutorService m18556bl() {
        if (this.f34605a == null) {
            synchronized (C12265s.class) {
                if (this.f34605a == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.f34605a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new ThreadFactoryC12662ok(C12257p.class.getName() + "-IOThreadPool"));
                }
            }
        }
        return this.f34605a;
    }

    /* renamed from: n */
    public void m18555n() {
        m18553ok(new Runnable() { // from class: com.ss.android.downloadlib.s.1
            @Override // java.lang.Runnable
            public void run() {
                InterfaceC12501k m17806m;
                synchronized (C12265s.class) {
                    try {
                        String[] strArr = {"sp_ad_download_event", "sp_download_finish_cache", "sp_delay_operation_info", "sp_ttdownloader_md5", "sp_name_installed_app", "misc_config", "sp_ad_install_back_dialog", "sp_ttdownloader_clean", "sp_order_download", "sp_a_b_c", "sp_ah_config", "sp_download_info", "sp_appdownloader"};
                        for (int i = 0; i < 13; i++) {
                            SharedPreferences sharedPreferences = C12128r.getContext().getSharedPreferences(strArr[i], 0);
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().clear().apply();
                            }
                        }
                        m17806m = C12490bl.m17806m();
                    } catch (Throwable unused) {
                    }
                    if (m17806m instanceof C12558s) {
                        SparseArray<DownloadInfo> m17528ok = ((C12558s) m17806m).m17499ok().m17528ok();
                        for (int size = m17528ok.size() - 1; size >= 0; size--) {
                            DownloadInfo downloadInfo = m17528ok.get(m17528ok.keyAt(size));
                            if (downloadInfo != null) {
                                Downloader.getInstance(C12128r.getContext()).clearDownloadData(downloadInfo.getId());
                            }
                        }
                    }
                }
            }
        });
    }

    /* renamed from: s */
    public ScheduledExecutorService m18550s() {
        if (this.f34606bl == null) {
            synchronized (C12265s.class) {
                if (this.f34606bl == null) {
                    this.f34606bl = new ScheduledThreadPoolExecutor(0, new ThreadFactoryC12662ok(C12257p.class.getName() + "-ScheduledThreadPool"));
                }
            }
        }
        return this.f34606bl;
    }

    private C12265s() {
    }

    /* renamed from: a */
    public void m18557a(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !C12197j.m18809a()) {
            runnable.run();
        } else {
            m18556bl().execute(runnable);
        }
    }

    /* renamed from: ok */
    public void m18553ok(Runnable runnable) {
        m18551ok(runnable, false);
    }

    /* renamed from: ok */
    public void m18551ok(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !C12197j.m18809a()) {
            runnable.run();
        } else {
            m18559a().execute(runnable);
        }
    }

    /* renamed from: a */
    public ExecutorService m18559a() {
        if (this.f34607ok == null) {
            synchronized (C12265s.class) {
                if (this.f34607ok == null) {
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    SynchronousQueue synchronousQueue = new SynchronousQueue();
                    this.f34607ok = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30L, timeUnit, synchronousQueue, new ThreadFactoryC12662ok(C12257p.class.getName() + "-CPUThreadPool"));
                }
            }
        }
        return this.f34607ok;
    }

    /* renamed from: ok */
    public void m18552ok(Runnable runnable, long j) {
        try {
            m18550s().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
