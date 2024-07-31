package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.ranges._Ranges;
import kotlin.time.Duration;
import kotlin.time.ExperimentalTime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u001b\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001e\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0087@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0016\u0010\f\u001a\u00020\u0003*\u00020\bH\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\"\u0018\u0010\u0012\u001a\u00020\u000f*\u00020\u000e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, m12616d2 = {"", "a", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "timeMillis", "Lkotlin/f1;", "b", "(JLkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/time/d;", "duration", "c", "(DLkotlin/coroutines/c;)Ljava/lang/Object;", "e", "(D)J", "Lkotlin/coroutines/f;", "Lkotlinx/coroutines/z0;", "d", "(Lkotlin/coroutines/f;)Lkotlinx/coroutines/z0;", "delay", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.a1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Delay {
    @Nullable
    /* renamed from: a */
    public static final Object m5752a(@NotNull InterfaceC14268c<?> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @Nullable
    /* renamed from: b */
    public static final Object m5751b(long j, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object m8642h;
        if (j <= 0) {
            return Unit.f41048a;
        }
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        C15153p c15153p = new C15153p(m8650d, 1);
        c15153p.mo3915J();
        if (j < Long.MAX_VALUE) {
            m5749d(c15153p.getContext()).mo3487d(j, c15153p);
        }
        Object m3883y = c15153p.m3883y();
        m8642h = C14287b.m8642h();
        if (m3883y == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        return m3883y;
    }

    @ExperimentalTime
    @Nullable
    /* renamed from: c */
    public static final Object m5750c(double d, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        Object m8642h;
        Object m5751b = m5751b(m5748e(d), interfaceC14268c);
        m8642h = C14287b.m8642h();
        return m5751b == m8642h ? m5751b : Unit.f41048a;
    }

    @NotNull
    /* renamed from: d */
    public static final InterfaceC15263z0 m5749d(@NotNull CoroutineContext coroutineContext) {
        CoroutineContext.InterfaceC14275b interfaceC14275b = coroutineContext.get(ContinuationInterceptor.f41024k0);
        if (!(interfaceC14275b instanceof InterfaceC15263z0)) {
            interfaceC14275b = null;
        }
        InterfaceC15263z0 interfaceC15263z0 = (InterfaceC15263z0) interfaceC14275b;
        return interfaceC15263z0 != null ? interfaceC15263z0 : C15246w0.m3522a();
    }

    @ExperimentalTime
    /* renamed from: e */
    public static final long m5748e(double d) {
        long m7478o;
        if (Duration.compareTo-LRDsOJo(d, Duration.f41658e.getZERO-UwyO8pc()) > 0) {
            m7478o = _Ranges.m7478o(Duration.toLongMilliseconds-impl(d), 1L);
            return m7478o;
        }
        return 0L;
    }
}
