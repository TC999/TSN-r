package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: TimeSource.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\t\u0010\u0001\u001a\u00020\u0000H\u0081\b\u001a\t\u0010\u0002\u001a\u00020\u0000H\u0081\b\u001a\u0019\u0010\u0006\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004H\u0081\b\u001a\t\u0010\b\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\t\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\n\u001a\u00020\u0007H\u0081\b\u001a\t\u0010\u000b\u001a\u00020\u0007H\u0081\b\u001a\u0019\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0000H\u0081\b\u001a\u0011\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0081\b\"$\u0010\u0019\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0001\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001a"}, d2 = {"", "a", "c", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "k", "Lkotlin/f1;", "g", "h", "e", "j", "", "blocker", "nanos", "d", "Ljava/lang/Thread;", "thread", "i", "Lkotlinx/coroutines/o3;", "Lkotlinx/coroutines/o3;", "b", "()Lkotlinx/coroutines/o3;", "f", "(Lkotlinx/coroutines/o3;)V", "timeSource", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p3 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static o3 f60531a;

    @InlineOnly
    private static final long a() {
        o3 b4 = b();
        return b4 != null ? b4.a() : System.currentTimeMillis();
    }

    @Nullable
    public static final o3 b() {
        return f60531a;
    }

    @InlineOnly
    private static final long c() {
        o3 b4 = b();
        return b4 != null ? b4.nanoTime() : System.nanoTime();
    }

    @InlineOnly
    private static final void d(Object obj, long j4) {
        o3 b4 = b();
        if (b4 != null) {
            b4.d(obj, j4);
        } else {
            LockSupport.parkNanos(obj, j4);
        }
    }

    @InlineOnly
    private static final void e() {
        o3 b4 = b();
        if (b4 != null) {
            b4.h();
        }
    }

    public static final void f(@Nullable o3 o3Var) {
        f60531a = o3Var;
    }

    @InlineOnly
    private static final void g() {
        o3 b4 = b();
        if (b4 != null) {
            b4.f();
        }
    }

    @InlineOnly
    private static final void h() {
        o3 b4 = b();
        if (b4 != null) {
            b4.b();
        }
    }

    @InlineOnly
    private static final void i(Thread thread) {
        o3 b4 = b();
        if (b4 != null) {
            b4.c(thread);
        } else {
            LockSupport.unpark(thread);
        }
    }

    @InlineOnly
    private static final void j() {
        o3 b4 = b();
        if (b4 != null) {
            b4.e();
        }
    }

    @InlineOnly
    private static final Runnable k(Runnable runnable) {
        Runnable g4;
        o3 b4 = b();
        return (b4 == null || (g4 = b4.g(runnable)) == null) ? runnable : g4;
    }
}
