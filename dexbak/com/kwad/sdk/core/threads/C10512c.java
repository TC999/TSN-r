package com.kwad.sdk.core.threads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.core.threads.p410a.C10508a;
import com.kwad.sdk.core.threads.p410a.C10509b;
import com.kwad.sdk.core.threads.p410a.InterfaceC10510c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.threads.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10512c {
    public static final String TAG = "c";
    private static int aAM;
    private static int aAN;
    private static int aAO;
    private static final ConcurrentHashMap<ThreadPoolExecutor, Long> aAP = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ThreadPoolExecutor, String> aAQ = new ConcurrentHashMap<>();
    private static long interval;
    private static long startTime;

    /* renamed from: FS */
    static /* synthetic */ int m25581FS() {
        int i = aAM;
        aAM = i + 1;
        return i;
    }

    /* renamed from: a */
    public static void m25576a(ThreadPoolExecutor threadPoolExecutor, String str) {
        aAP.put(threadPoolExecutor, Long.valueOf(threadPoolExecutor.getCompletedTaskCount()));
        aAQ.put(threadPoolExecutor, str);
    }

    /* renamed from: cH */
    public static void m25573cH(final String str) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.threads.c.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C10515d m25571eu;
                int i;
                if (TextUtils.isEmpty(str) || (m25571eu = C10512c.m25571eu(str)) == null || (i = m25571eu.aAN) == 0) {
                    return;
                }
                int unused = C10512c.aAN = i;
                double random = Math.random();
                double d = C10512c.aAN;
                Double.isNaN(d);
                if (random * d >= 1.0d) {
                    return;
                }
                C10512c.m25577a(m25571eu);
            }
        });
    }

    /* renamed from: eu */
    public static C10515d m25571eu(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            C10515d c10515d = new C10515d();
            c10515d.parseJson(jSONObject);
            return c10515d;
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static C10511b m25574b(ThreadPoolExecutor threadPoolExecutor, String str) {
        if (threadPoolExecutor == null) {
            return null;
        }
        C10511b c10511b = new C10511b();
        c10511b.aAC = str;
        c10511b.aAD = threadPoolExecutor.getCorePoolSize();
        c10511b.aAE = threadPoolExecutor.getMaximumPoolSize();
        c10511b.aAF = threadPoolExecutor.getPoolSize();
        c10511b.aAG = threadPoolExecutor.getActiveCount();
        c10511b.aAJ = threadPoolExecutor.getQueue() == null ? 0 : threadPoolExecutor.getQueue().size();
        ConcurrentHashMap<ThreadPoolExecutor, Long> concurrentHashMap = aAP;
        long longValue = (!concurrentHashMap.containsKey(threadPoolExecutor) || concurrentHashMap.get(threadPoolExecutor) == null) ? 0L : concurrentHashMap.get(threadPoolExecutor).longValue();
        long completedTaskCount = threadPoolExecutor.getCompletedTaskCount();
        c10511b.aAI = completedTaskCount - longValue;
        concurrentHashMap.put(threadPoolExecutor, Long.valueOf(completedTaskCount));
        if (threadPoolExecutor instanceof InterfaceC10510c) {
            c10511b.aAH = ((InterfaceC10510c) threadPoolExecutor).mo25584FW();
        } else {
            c10511b.aAH = 0L;
        }
        c10511b.aAK = SystemClock.elapsedRealtime() - startTime;
        c10511b.interval = interval;
        c10511b.aAL = aAN;
        return c10511b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static void m25577a(C10515d c10515d) {
        C10509b.aAU = true;
        C10508a.aAU = true;
        interval = c10515d.interval;
        aAO = c10515d.aAT;
        HandlerThread handlerThread = new HandlerThread("pollingHT");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        startTime = SystemClock.elapsedRealtime();
        handler.post(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.core.threads.c.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                ExecutorService m25590et;
                for (String str : GlobalThreadPools.m25596FM()) {
                    if (str != null && !C10512c.aAQ.containsValue(str) && (m25590et = GlobalThreadPools.m25590et(str)) != null && (m25590et instanceof ThreadPoolExecutor) && !C10512c.aAP.containsKey(m25590et)) {
                        C10512c.m25576a((ThreadPoolExecutor) m25590et, str);
                    }
                }
                int i = 0;
                for (ThreadPoolExecutor threadPoolExecutor : C10512c.aAQ.keySet()) {
                    i += threadPoolExecutor.getPoolSize();
                    C10511b m25574b = C10512c.m25574b(threadPoolExecutor, (String) C10512c.aAQ.get(threadPoolExecutor));
                    if (m25574b != null) {
                        C9815b.m27651r(m25574b);
                    }
                }
                C10511b c10511b = new C10511b();
                c10511b.aAC = "total";
                c10511b.aAF = i;
                C9815b.m27651r(c10511b);
                C10512c.m25581FS();
                if (C10512c.aAM < C10512c.aAO) {
                    handler.postDelayed(this, C10512c.interval);
                }
            }
        });
    }
}
