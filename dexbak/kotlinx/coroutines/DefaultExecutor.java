package kotlinx.coroutines;

import com.kuaishou.weapon.p205p0.C7304t;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.ranges._Ranges;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0014\bÀ\u0002\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003B\t\b\u0002¢\u0006\u0004\b5\u0010\u0013J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J$\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\n2\n\u0010\f\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0016J\u000f\u0010\u0012\u001a\u00020\bH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\nR\u0014\u0010\u0019\u001a\u00020\u00168\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b\u001f\u0010 \u0012\u0004\b!\u0010\u0013R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010)\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010$R\u0014\u0010+\u001a\u00020\"8\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010$R\u0016\u0010,\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010$R\u0014\u0010/\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0014\u00102\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00104\u001a\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b3\u0010.¨\u00066"}, m12616d2 = {"Lkotlinx/coroutines/v0;", "Lkotlinx/coroutines/n1;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Thread;", "g0", "", "l0", "Lkotlin/f1;", "f0", "", "timeMillis", "block", "Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/i1;", "e", "run", "h0", "()V", "timeout", "m0", "", "f", "Ljava/lang/String;", "THREAD_NAME", "g", "J", "DEFAULT_KEEP_ALIVE", "h", "KEEP_ALIVE_NANOS", "_thread", "Ljava/lang/Thread;", "get_thread$annotations", "", "i", "I", "FRESH", "j", "ACTIVE", "k", "SHUTDOWN_REQ", C7304t.f25048d, "SHUTDOWN_ACK", "debugStatus", "j0", "()Z", "isShutdownRequested", "M", "()Ljava/lang/Thread;", "thread", "k0", "isThreadPresent", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.v0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class DefaultExecutor extends AbstractC15139n1 implements Runnable {
    private static volatile Thread _thread = null;
    private static volatile int debugStatus = 0;
    @NotNull

    /* renamed from: f */
    public static final String f43429f = "kotlinx.coroutines.DefaultExecutor";

    /* renamed from: g */
    private static final long f43430g = 1000;

    /* renamed from: h */
    private static final long f43431h;

    /* renamed from: i */
    private static final int f43432i = 0;

    /* renamed from: j */
    private static final int f43433j = 1;

    /* renamed from: k */
    private static final int f43434k = 2;

    /* renamed from: l */
    private static final int f43435l = 3;

    /* renamed from: m */
    public static final DefaultExecutor f43436m;

    static {
        Long l;
        DefaultExecutor defaultExecutor = new DefaultExecutor();
        f43436m = defaultExecutor;
        AbstractC15133m1.m3995F(defaultExecutor, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f43431h = timeUnit.toNanos(l.longValue());
    }

    private DefaultExecutor() {
    }

    /* renamed from: f0 */
    private final synchronized void m3542f0() {
        if (m3538j0()) {
            debugStatus = 3;
            m3958Z();
            notifyAll();
        }
    }

    /* renamed from: g0 */
    private final synchronized Thread m3541g0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, f43429f);
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    /* renamed from: i0 */
    private static /* synthetic */ void m3539i0() {
    }

    /* renamed from: j0 */
    private final boolean m3538j0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    /* renamed from: l0 */
    private final synchronized boolean m3536l0() {
        if (m3538j0()) {
            return false;
        }
        debugStatus = 1;
        notifyAll();
        return true;
    }

    @Override // kotlinx.coroutines.AbstractC15150o1
    @NotNull
    /* renamed from: M */
    protected Thread mo3543M() {
        Thread thread = _thread;
        return thread != null ? thread : m3541g0();
    }

    @Override // kotlinx.coroutines.AbstractC15139n1, kotlinx.coroutines.InterfaceC15263z0
    @NotNull
    /* renamed from: e */
    public InterfaceC15064i1 mo3486e(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
        return m3955c0(j, runnable);
    }

    /* renamed from: h0 */
    public final synchronized void m3540h0() {
        debugStatus = 0;
        m3541g0();
        while (debugStatus == 0) {
            wait();
        }
    }

    /* renamed from: k0 */
    public final boolean m3537k0() {
        return _thread != null;
    }

    /* renamed from: m0 */
    public final synchronized void m3535m0(long j) {
        long currentTimeMillis = System.currentTimeMillis() + j;
        if (!m3538j0()) {
            debugStatus = 2;
        }
        while (debugStatus != 3 && _thread != null) {
            Thread thread = _thread;
            if (thread != null) {
                InterfaceC15152o3 m3872b = C15156p3.m3872b();
                if (m3872b != null) {
                    m3872b.m3930c(thread);
                } else {
                    LockSupport.unpark(thread);
                }
            }
            if (currentTimeMillis - System.currentTimeMillis() <= 0) {
                break;
            }
            wait(j);
        }
        debugStatus = 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean mo3966G;
        C15120k3.f43148b.m4081d(this);
        InterfaceC15152o3 m3872b = C15156p3.m3872b();
        if (m3872b != null) {
            m3872b.m3925h();
        }
        try {
            if (!m3536l0()) {
                if (mo3966G) {
                    return;
                }
                return;
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long mo3563J = mo3563J();
                if (mo3563J == Long.MAX_VALUE) {
                    InterfaceC15152o3 m3872b2 = C15156p3.m3872b();
                    long nanoTime = m3872b2 != null ? m3872b2.nanoTime() : System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = f43431h + nanoTime;
                    }
                    long j2 = j - nanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        m3542f0();
                        InterfaceC15152o3 m3872b3 = C15156p3.m3872b();
                        if (m3872b3 != null) {
                            m3872b3.m3928e();
                        }
                        if (mo3966G()) {
                            return;
                        }
                        mo3543M();
                        return;
                    }
                    mo3563J = _Ranges.m7457v(mo3563J, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (mo3563J > 0) {
                    if (m3538j0()) {
                        _thread = null;
                        m3542f0();
                        InterfaceC15152o3 m3872b4 = C15156p3.m3872b();
                        if (m3872b4 != null) {
                            m3872b4.m3928e();
                        }
                        if (mo3966G()) {
                            return;
                        }
                        mo3543M();
                        return;
                    }
                    InterfaceC15152o3 m3872b5 = C15156p3.m3872b();
                    if (m3872b5 != null) {
                        m3872b5.m3929d(this, mo3563J);
                    } else {
                        LockSupport.parkNanos(this, mo3563J);
                    }
                }
            }
        } finally {
            _thread = null;
            m3542f0();
            InterfaceC15152o3 m3872b6 = C15156p3.m3872b();
            if (m3872b6 != null) {
                m3872b6.m3928e();
            }
            if (!mo3966G()) {
                mo3543M();
            }
        }
    }
}
