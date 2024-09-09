package kotlinx.coroutines;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DefaultExecutor.kt */
@Metadata(bv = {}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0014\b\u00c0\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002\u00a2\u0006\u0004\b4\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u000f\u0010\u0012\u001a\u00020\bH\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nR\u0014\u0010\u0018\u001a\u00020\u00168\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b \u0010\u0013R\u0014\u0010$\u001a\u00020!8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020!8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0014\u0010(\u001a\u00020!8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b'\u0010#R\u0014\u0010*\u001a\u00020!8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010+\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010#R\u0014\u0010.\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00048TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00103\u001a\u00020\u00068@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u0010-\u00a8\u00065"}, d2 = {"Lkotlinx/coroutines/v0;", "Lkotlinx/coroutines/n1;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Thread;", "e0", "", "j0", "Lkotlin/f1;", "d0", "", "timeMillis", "block", "Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/i1;", "f", "run", "f0", "()V", "timeout", "k0", "", "Ljava/lang/String;", "THREAD_NAME", "g", "J", "DEFAULT_KEEP_ALIVE", "h", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "i", "I", "FRESH", "j", "ACTIVE", "k", "SHUTDOWN_REQ", "l", "SHUTDOWN_ACK", "debugStatus", "h0", "()Z", "isShutdownRequested", "K", "()Ljava/lang/Thread;", "thread", "i0", "isThreadPresent", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v0 extends n1 implements Runnable {
    private static volatile Thread _thread = null;
    private static volatile int debugStatus = 0;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public static final String f60746f = "kotlinx.coroutines.DefaultExecutor";

    /* renamed from: g  reason: collision with root package name */
    private static final long f60747g = 1000;

    /* renamed from: h  reason: collision with root package name */
    private static final long f60748h;

    /* renamed from: i  reason: collision with root package name */
    private static final int f60749i = 0;

    /* renamed from: j  reason: collision with root package name */
    private static final int f60750j = 1;

    /* renamed from: k  reason: collision with root package name */
    private static final int f60751k = 2;

    /* renamed from: l  reason: collision with root package name */
    private static final int f60752l = 3;

    /* renamed from: m  reason: collision with root package name */
    public static final v0 f60753m;

    static {
        Long l4;
        v0 v0Var = new v0();
        f60753m = v0Var;
        m1.D(v0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l4 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l4 = 1000L;
        }
        f60748h = timeUnit.toNanos(l4.longValue());
    }

    private v0() {
    }

    private final synchronized void d0() {
        if (h0()) {
            debugStatus = 3;
            X();
            notifyAll();
        }
    }

    private final synchronized Thread e0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private static /* synthetic */ void g0() {
    }

    private final boolean h0() {
        int i4 = debugStatus;
        return i4 == 2 || i4 == 3;
    }

    private final synchronized boolean j0() {
        if (h0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // kotlinx.coroutines.o1
    @NotNull
    protected Thread K() {
        Thread thread = _thread;
        return thread != null ? thread : e0();
    }

    @Override // kotlinx.coroutines.n1, kotlinx.coroutines.z0
    @NotNull
    public i1 f(long j4, @NotNull Runnable runnable, @NotNull kotlin.coroutines.f fVar) {
        return a0(j4, runnable);
    }

    public final synchronized void f0() {
        debugStatus = 0;
        e0();
        while (debugStatus == 0) {
            wait();
        }
    }

    public final boolean i0() {
        return _thread != null;
    }

    public final synchronized void k0(long j4) {
        long currentTimeMillis = System.currentTimeMillis() + j4;
        if (!h0()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            Thread thread = _thread;
            if (thread != null) {
                o3 b4 = p3.b();
                if (b4 != null) {
                    b4.c(thread);
                } else {
                    LockSupport.unpark(thread);
                }
            }
            if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            }
            wait(j4);
        }
        debugStatus = 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean E;
        k3.f60465b.d(this);
        o3 b4 = p3.b();
        if (b4 != null) {
            b4.h();
        }
        try {
            if (!j0()) {
                if (E) {
                    return;
                }
                return;
            }
            long j4 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long H = H();
                if (H == Long.MAX_VALUE) {
                    o3 b5 = p3.b();
                    long nanoTime = b5 != null ? b5.nanoTime() : System.nanoTime();
                    if (j4 == Long.MAX_VALUE) {
                        j4 = f60748h + nanoTime;
                    }
                    long j5 = j4 - nanoTime;
                    if (j5 <= 0) {
                        _thread = null;
                        d0();
                        o3 b6 = p3.b();
                        if (b6 != null) {
                            b6.e();
                        }
                        if (E()) {
                            return;
                        }
                        K();
                        return;
                    }
                    H = kotlin.ranges.q.v(H, j5);
                } else {
                    j4 = Long.MAX_VALUE;
                }
                if (H > 0) {
                    if (h0()) {
                        _thread = null;
                        d0();
                        o3 b7 = p3.b();
                        if (b7 != null) {
                            b7.e();
                        }
                        if (E()) {
                            return;
                        }
                        K();
                        return;
                    }
                    o3 b8 = p3.b();
                    if (b8 != null) {
                        b8.d(this, H);
                    } else {
                        LockSupport.parkNanos(this, H);
                    }
                }
            }
        } finally {
            _thread = null;
            d0();
            o3 b9 = p3.b();
            if (b9 != null) {
                b9.e();
            }
            if (!E()) {
                K();
            }
        }
    }
}
