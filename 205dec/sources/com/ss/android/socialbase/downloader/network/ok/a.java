package com.ss.android.socialbase.downloader.network.ok;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.k;
import com.ss.android.socialbase.downloader.q.kf;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    static long f50036a;
    private static final HandlerThread bl;
    static long ok;

    /* renamed from: s  reason: collision with root package name */
    private static final Handler f50037s;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        bl = handlerThread;
        a();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        f50037s = handler;
        handler.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.ok.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    Process.setThreadPriority(10);
                } catch (Throwable unused) {
                }
            }
        });
    }

    private static void a() {
        ok = com.ss.android.socialbase.downloader.h.ok.bl().ok("preconnect_connection_outdate_time", 300000L);
        f50036a = com.ss.android.socialbase.downloader.h.ok.bl().ok("preconnect_head_info_outdate_time", 300000L);
        ok.ok().ok(com.ss.android.socialbase.downloader.h.ok.bl().ok("preconnect_max_cache_size", 3));
    }

    public static Looper ok() {
        return bl.getLooper();
    }

    public static void ok(final String str, final k kVar) {
        f50037s.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.ok.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        try {
                            List<com.ss.android.socialbase.downloader.model.bl> a4 = a.a(0L, null, null);
                            r1 = ok.ok().ok(str) ? ok.ok().ok(str, a4) : null;
                            if (r1 == null) {
                                bl blVar = new bl(str, a4, 0L);
                                try {
                                    blVar.ok();
                                    if (blVar.n()) {
                                        ok.ok().ok(str, blVar);
                                    }
                                    r1 = blVar;
                                } catch (Exception e4) {
                                    e = e4;
                                    r1 = blVar;
                                    e.printStackTrace();
                                    r1.bl();
                                } catch (Throwable th) {
                                    th = th;
                                    r1 = blVar;
                                    try {
                                        r1.bl();
                                    } catch (Throwable unused) {
                                    }
                                    throw th;
                                }
                            }
                            Map<String, String> q3 = r1.q();
                            k kVar2 = kVar;
                            if (kVar2 != null) {
                                kVar2.ok(q3);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e5) {
                        e = e5;
                    }
                    try {
                        r1.bl();
                    } catch (Throwable unused2) {
                    }
                } else {
                    k kVar3 = kVar;
                    if (kVar3 != null) {
                        kVar3.ok(null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<com.ss.android.socialbase.downloader.model.bl> a(long j4, DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.model.bl> list) {
        return kf.ok(list, downloadInfo == null ? null : downloadInfo.geteTag(), j4, 0L);
    }
}
