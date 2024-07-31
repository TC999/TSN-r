package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.ranges._Ranges;
import kotlinx.coroutines.internal.C15082l0;
import kotlinx.coroutines.internal.C15084n0;
import org.jetbrains.annotations.NotNull;

/* compiled from: Tasks.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0005\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0014\u0010\t\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\r\u001a\u00020\n8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\u000f\u001a\u00020\n8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\f\"\u0014\u0010\u0011\u001a\u00020\n8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\f\"\u0014\u0010\u0013\u001a\u00020\u00068\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\b\"\u0016\u0010\u0017\u001a\u00020\u00148\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0019\u001a\u00020\n8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0018\u0010\f\"\u0014\u0010\u001b\u001a\u00020\n8\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u001a\u0010\f\"\u0019\u0010\u001f\u001a\u00020\u001d*\u00020\u001c8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0001\u0010\u001e¨\u0006 "}, m12616d2 = {"", "a", "Ljava/lang/String;", "DEFAULT_DISPATCHER_NAME", "b", "DEFAULT_SCHEDULER_NAME", "", "c", "J", "WORK_STEALING_TIME_RESOLUTION_NS", "", "d", "I", "BLOCKING_DEFAULT_PARALLELISM", "e", "CORE_POOL_SIZE", "f", "MAX_POOL_SIZE", "g", "IDLE_WORKER_KEEP_ALIVE_NS", "Lkotlinx/coroutines/scheduling/m;", "h", "Lkotlinx/coroutines/scheduling/m;", "schedulerTimeSource", "i", "TASK_NON_BLOCKING", "j", "TASK_PROBABLY_BLOCKING", "Lkotlinx/coroutines/scheduling/i;", "", "(Lkotlinx/coroutines/scheduling/i;)Z", "isBlocking", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.scheduling.l */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15184l {
    @NotNull

    /* renamed from: a */
    public static final String f43294a = "Dispatchers.Default";
    @NotNull

    /* renamed from: b */
    public static final String f43295b = "DefaultDispatcher";
    @JvmPlatformAnnotations

    /* renamed from: c */
    public static final long f43296c;
    @JvmPlatformAnnotations

    /* renamed from: d */
    public static final int f43297d;
    @JvmPlatformAnnotations

    /* renamed from: e */
    public static final int f43298e;
    @JvmPlatformAnnotations

    /* renamed from: f */
    public static final int f43299f;
    @JvmPlatformAnnotations

    /* renamed from: g */
    public static final long f43300g;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: h */
    public static AbstractC15185m f43301h = null;

    /* renamed from: i */
    public static final int f43302i = 0;

    /* renamed from: j */
    public static final int f43303j = 1;

    static {
        long m4257e;
        int m4258d;
        int m7481n;
        int m4258d2;
        int m7565B;
        int m4258d3;
        long m4257e2;
        m4257e = C15084n0.m4257e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f43296c = m4257e;
        m4258d = C15084n0.m4258d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        f43297d = m4258d;
        m7481n = _Ranges.m7481n(C15082l0.m4281a(), 2);
        m4258d2 = C15084n0.m4258d("kotlinx.coroutines.scheduler.core.pool.size", m7481n, 1, 0, 8, null);
        f43298e = m4258d2;
        m7565B = _Ranges.m7565B(C15082l0.m4281a() * 128, m4258d2, CoroutineScheduler.f43254u);
        m4258d3 = C15084n0.m4258d("kotlinx.coroutines.scheduler.max.pool.size", m7565B, 0, CoroutineScheduler.f43254u, 4, null);
        f43299f = m4258d3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        m4257e2 = C15084n0.m4257e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f43300g = timeUnit.toNanos(m4257e2);
        f43301h = C15179g.f43288a;
    }

    /* renamed from: a */
    public static final boolean m3737a(@NotNull AbstractRunnableC15181i abstractRunnableC15181i) {
        return abstractRunnableC15181i.f43292b.mo3738h() == 1;
    }
}
