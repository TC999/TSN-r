package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.Nullable;

/* compiled from: TimeSource.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\t\u0010\u0001\u001a\u00020\u0000H\u0081\b\u001a\t\u0010\u0002\u001a\u00020\u0000H\u0081\b\u001a\u0019\u0010\u0006\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0081\b\u001a\t\u0010\b\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\t\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\n\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\u000b\u001a\u00020\u0007H\u0081\b\u001a\u0019\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0000H\u0081\b\u001a\u0011\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0081\b\"$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0001\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, m12616d2 = {"", "a", "c", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "k", "Lkotlin/f1;", "g", "h", "e", "j", "", "blocker", "nanos", "d", "Ljava/lang/Thread;", "thread", "i", "Lkotlinx/coroutines/o3;", "Lkotlinx/coroutines/o3;", "b", "()Lkotlinx/coroutines/o3;", "f", "(Lkotlinx/coroutines/o3;)V", "timeSource", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.p3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15156p3 {
    @Nullable

    /* renamed from: a */
    private static InterfaceC15152o3 f43214a;

    @InlineOnly
    /* renamed from: a */
    private static final long m3873a() {
        InterfaceC15152o3 m3872b = m3872b();
        return m3872b != null ? m3872b.m3932a() : System.currentTimeMillis();
    }

    @Nullable
    /* renamed from: b */
    public static final InterfaceC15152o3 m3872b() {
        return f43214a;
    }

    @InlineOnly
    /* renamed from: c */
    private static final long m3871c() {
        InterfaceC15152o3 m3872b = m3872b();
        return m3872b != null ? m3872b.nanoTime() : System.nanoTime();
    }

    @InlineOnly
    /* renamed from: d */
    private static final void m3870d(Object obj, long j) {
        InterfaceC15152o3 m3872b = m3872b();
        if (m3872b != null) {
            m3872b.m3929d(obj, j);
        } else {
            LockSupport.parkNanos(obj, j);
        }
    }

    @InlineOnly
    /* renamed from: e */
    private static final void m3869e() {
        InterfaceC15152o3 m3872b = m3872b();
        if (m3872b != null) {
            m3872b.m3925h();
        }
    }

    /* renamed from: f */
    public static final void m3868f(@Nullable InterfaceC15152o3 interfaceC15152o3) {
        f43214a = interfaceC15152o3;
    }

    @InlineOnly
    /* renamed from: g */
    private static final void m3867g() {
        InterfaceC15152o3 m3872b = m3872b();
        if (m3872b != null) {
            m3872b.m3927f();
        }
    }

    @InlineOnly
    /* renamed from: h */
    private static final void m3866h() {
        InterfaceC15152o3 m3872b = m3872b();
        if (m3872b != null) {
            m3872b.m3931b();
        }
    }

    @InlineOnly
    /* renamed from: i */
    private static final void m3865i(Thread thread) {
        InterfaceC15152o3 m3872b = m3872b();
        if (m3872b != null) {
            m3872b.m3930c(thread);
        } else {
            LockSupport.unpark(thread);
        }
    }

    @InlineOnly
    /* renamed from: j */
    private static final void m3864j() {
        InterfaceC15152o3 m3872b = m3872b();
        if (m3872b != null) {
            m3872b.m3928e();
        }
    }

    @InlineOnly
    /* renamed from: k */
    private static final Runnable m3863k(Runnable runnable) {
        Runnable m3926g;
        InterfaceC15152o3 m3872b = m3872b();
        return (m3872b == null || (m3926g = m3872b.m3926g(runnable)) == null) ? runnable : m3926g;
    }
}
