package com.p521ss.android.socialbase.downloader.network.p553ok;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12622k;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.List;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.network.ok.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12626a {

    /* renamed from: a */
    static long f35577a;

    /* renamed from: bl */
    private static final HandlerThread f35578bl;

    /* renamed from: ok */
    static long f35579ok;

    /* renamed from: s */
    private static final Handler f35580s;

    static {
        HandlerThread handlerThread = new HandlerThread("Downloader-preconnecter");
        f35578bl = handlerThread;
        m16939a();
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        f35580s = handler;
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

    /* renamed from: a */
    private static void m16939a() {
        f35579ok = C12534ok.m17605bl().m17592ok("preconnect_connection_outdate_time", 300000L);
        f35577a = C12534ok.m17605bl().m17592ok("preconnect_head_info_outdate_time", 300000L);
        C12630ok.m16924ok().m16923ok(C12534ok.m17605bl().m17593ok("preconnect_max_cache_size", 3));
    }

    /* renamed from: ok */
    public static Looper m16937ok() {
        return f35578bl.getLooper();
    }

    /* renamed from: ok */
    public static void m16935ok(final String str, final InterfaceC12622k interfaceC12622k) {
        f35580s.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.network.ok.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        try {
                            List<C12601bl> m16938a = C12626a.m16938a(0L, null, null);
                            r1 = C12630ok.m16924ok().m16922ok(str) ? C12630ok.m16924ok().m16920ok(str, m16938a) : null;
                            if (r1 == null) {
                                C12629bl c12629bl = new C12629bl(str, m16938a, 0L);
                                try {
                                    c12629bl.m16931ok();
                                    if (c12629bl.m16932n()) {
                                        C12630ok.m16924ok().m16921ok(str, c12629bl);
                                    }
                                    r1 = c12629bl;
                                } catch (Exception e) {
                                    e = e;
                                    r1 = c12629bl;
                                    e.printStackTrace();
                                    r1.mo16917bl();
                                } catch (Throwable th) {
                                    th = th;
                                    r1 = c12629bl;
                                    try {
                                        r1.mo16917bl();
                                    } catch (Throwable unused) {
                                    }
                                    throw th;
                                }
                            }
                            Map<String, String> m16927q = r1.m16927q();
                            InterfaceC12622k interfaceC12622k2 = interfaceC12622k;
                            if (interfaceC12622k2 != null) {
                                interfaceC12622k2.mo16946ok(m16927q);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                    try {
                        r1.mo16917bl();
                    } catch (Throwable unused2) {
                    }
                } else {
                    InterfaceC12622k interfaceC12622k3 = interfaceC12622k;
                    if (interfaceC12622k3 != null) {
                        interfaceC12622k3.mo16946ok(null);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static List<C12601bl> m16938a(long j, DownloadInfo downloadInfo, List<C12601bl> list) {
        return C12713kf.m16537ok(list, downloadInfo == null ? null : downloadInfo.geteTag(), j, 0L);
    }
}
