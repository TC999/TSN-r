package cn.jiguang.cm;

import cn.jiguang.bk.f;
import cn.jiguang.bk.g;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, ExecutorService> f3468a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, String> f3469b;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f3469b = hashMap;
        hashMap.put("SDK_INIT", "ic");
        hashMap.put("SDK_SERVICE_INIT", "mn");
        hashMap.put("TCP_CONN_TASK", "tc");
        hashMap.put("UPLOAD_REPORT", "rp");
        hashMap.put("ONCE_TASK", "oc");
        hashMap.put("SCHEDULE_TASK", "sc");
        hashMap.put("MAJOR_TASK", "mj");
        hashMap.put("NORMAL_TASK", "nr");
        hashMap.put("FUTURE_TASK", "fr");
        hashMap.put("DELAY_TASK", "dl");
    }

    public static void a(String str) {
        try {
            a(c(str));
        } catch (Throwable th) {
            cn.jiguang.bq.d.l("SDKWorker_XExecutor", "shutdown executor " + str + "error: " + th);
        }
    }

    public static void a(String str, Runnable runnable) {
        a(str, runnable, 0, true);
    }

    public static void a(String str, Runnable runnable, int i4) {
        a(str, runnable, i4, true);
    }

    public static void a(String str, Runnable runnable, int i4, boolean z3) {
        if (z3) {
            try {
                if (f.a() || g.a()) {
                    return;
                }
            } catch (Throwable th) {
                cn.jiguang.bq.d.l("SDKWorker_XExecutor", "execute failed, try again e:" + th);
                return;
            }
        }
        ExecutorService c4 = c(str);
        if (c4 != null) {
            if (i4 <= 0 || !(c4 instanceof ScheduledExecutorService)) {
                c4.execute(runnable);
            } else {
                ((ScheduledExecutorService) c4).schedule(runnable, i4, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static void a(String str, Runnable runnable, boolean z3) {
        a(str, runnable, 0, z3);
    }

    private static void a(ExecutorService executorService) {
        if (executorService == null) {
            return;
        }
        try {
            executorService.shutdown();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            executorService.shutdownNow();
            if (executorService.awaitTermination(100L, timeUnit)) {
                return;
            }
            cn.jiguang.bq.d.a("SDKWorker_XExecutor", "executor did not terminate");
        } catch (InterruptedException unused) {
            executorService.shutdownNow();
            cn.jiguang.bq.d.a("SDKWorker_XExecutor", "current thread is interrupted by self");
            Thread.currentThread().interrupt();
        } catch (Throwable th) {
            cn.jiguang.bq.d.i("SDKWorker_XExecutor", "shutDown e:" + th);
        }
    }

    public static boolean b(String str) {
        try {
            ExecutorService c4 = c(str);
            if (c4 == null || c4.isShutdown()) {
                return false;
            }
            return !c4.isTerminated();
        } catch (Throwable th) {
            cn.jiguang.bq.d.l("SDKWorker_XExecutor", "check executor " + str + " isAlive error: " + th);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0034, code lost:
        if (r5 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.concurrent.ExecutorService c(java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.cm.d.c(java.lang.String):java.util.concurrent.ExecutorService");
    }
}
