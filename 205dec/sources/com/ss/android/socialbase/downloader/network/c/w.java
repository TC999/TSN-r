package com.ss.android.socialbase.downloader.network.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.gd.f;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.p;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    static long f50021c;
    private static final Handler sr;

    /* renamed from: w  reason: collision with root package name */
    static long f50022w;
    private static final HandlerThread xv;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        xv = handlerThread;
        w();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        sr = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.c.w.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void w() {
        f50021c = com.ss.android.socialbase.downloader.r.c.xv().c("preconnect_connection_outdate_time", 300000L);
        f50022w = com.ss.android.socialbase.downloader.r.c.xv().c("preconnect_head_info_outdate_time", 300000L);
        c.c().c(com.ss.android.socialbase.downloader.r.c.xv().c("preconnect_max_cache_size", 3));
    }

    public static Looper c() {
        return xv.getLooper();
    }

    public static void c(final String str, final p pVar) {
        sr.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.c.w.2
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        try {
                            List<com.ss.android.socialbase.downloader.model.xv> w3 = w.w(0L, null, null);
                            r1 = c.c().c(str) ? c.c().c(str, w3) : null;
                            if (r1 == null) {
                                xv xvVar = new xv(str, w3, 0L);
                                try {
                                    xvVar.c();
                                    if (xvVar.ux()) {
                                        c.c().c(str, xvVar);
                                    }
                                    r1 = xvVar;
                                } catch (Exception e4) {
                                    e = e4;
                                    r1 = xvVar;
                                    e.printStackTrace();
                                    r1.xv();
                                } catch (Throwable th) {
                                    th = th;
                                    r1 = xvVar;
                                    try {
                                        r1.xv();
                                    } catch (Throwable unused) {
                                    }
                                    throw th;
                                }
                            }
                            Map<String, String> gd = r1.gd();
                            p pVar2 = pVar;
                            if (pVar2 != null) {
                                pVar2.c(gd);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                    try {
                        r1.xv();
                    } catch (Throwable unused2) {
                    }
                } else {
                    p pVar3 = pVar;
                    if (pVar3 != null) {
                        pVar3.c(null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.ss.android.socialbase.downloader.model.xv> w(long j4, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.xv> list) {
        return f.c(list, downloadInfo == null ? null : downloadInfo.geteTag(), j4, 0L);
    }
}
