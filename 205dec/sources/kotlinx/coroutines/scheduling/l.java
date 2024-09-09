package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.ranges.q;
import kotlinx.coroutines.internal.l0;
import kotlinx.coroutines.internal.n0;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Tasks.kt */
@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0005\u001a\u00020\u00008\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0014\u0010\t\u001a\u00020\u00068\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0014\u0010\r\u001a\u00020\n8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\u000f\u001a\u00020\n8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\"\u0014\u0010\u0011\u001a\u00020\n8\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\f\"\u0014\u0010\u0013\u001a\u00020\u00068\u0000X\u0081\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\b\"\u0016\u0010\u0017\u001a\u00020\u00148\u0000@\u0000X\u0081\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0019\u001a\u00020\n8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\f\"\u0014\u0010\u001b\u001a\u00020\n8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\f\"\u0019\u0010\u001f\u001a\u00020\u001d*\u00020\u001c8\u00c0\u0002X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0001\u0010\u001e\u00a8\u0006 "}, d2 = {"", "a", "Ljava/lang/String;", "DEFAULT_DISPATCHER_NAME", "b", "DEFAULT_SCHEDULER_NAME", "", "c", "J", "WORK_STEALING_TIME_RESOLUTION_NS", "", "d", "I", "BLOCKING_DEFAULT_PARALLELISM", "e", "CORE_POOL_SIZE", "f", "MAX_POOL_SIZE", "g", "IDLE_WORKER_KEEP_ALIVE_NS", "Lkotlinx/coroutines/scheduling/m;", "h", "Lkotlinx/coroutines/scheduling/m;", "schedulerTimeSource", "i", "TASK_NON_BLOCKING", "j", "TASK_PROBABLY_BLOCKING", "Lkotlinx/coroutines/scheduling/i;", "", "(Lkotlinx/coroutines/scheduling/i;)Z", "isBlocking", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f60611a = "Dispatchers.Default";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public static final String f60612b = "DefaultDispatcher";
    @JvmField

    /* renamed from: c  reason: collision with root package name */
    public static final long f60613c;
    @JvmField

    /* renamed from: d  reason: collision with root package name */
    public static final int f60614d;
    @JvmField

    /* renamed from: e  reason: collision with root package name */
    public static final int f60615e;
    @JvmField

    /* renamed from: f  reason: collision with root package name */
    public static final int f60616f;
    @JvmField

    /* renamed from: g  reason: collision with root package name */
    public static final long f60617g;
    @JvmField
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public static m f60618h = null;

    /* renamed from: i  reason: collision with root package name */
    public static final int f60619i = 0;

    /* renamed from: j  reason: collision with root package name */
    public static final int f60620j = 1;

    static {
        long e4;
        int d4;
        int n4;
        int d5;
        int B;
        int d6;
        long e5;
        e4 = n0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f60613c = e4;
        d4 = n0.d("kotlinx.coroutines.scheduler.blocking.parallelism", 16, 0, 0, 12, null);
        f60614d = d4;
        n4 = q.n(l0.a(), 2);
        d5 = n0.d("kotlinx.coroutines.scheduler.core.pool.size", n4, 1, 0, 8, null);
        f60615e = d5;
        B = q.B(l0.a() * 128, d5, 2097150);
        d6 = n0.d("kotlinx.coroutines.scheduler.max.pool.size", B, 0, 2097150, 4, null);
        f60616f = d6;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e5 = n0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f60617g = timeUnit.toNanos(e5);
        f60618h = g.f60605a;
    }

    public static final boolean a(@NotNull i iVar) {
        return iVar.f60609b.n() == 1;
    }
}
