package kotlinx.coroutines;

import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Delay.kt */
@InternalCoroutinesApi
@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\u00022\n\u0010\r\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, m12616d2 = {"Lkotlinx/coroutines/z0;", "", "", RtspHeaders.Values.TIME, "Lkotlin/f1;", "k", "(JLkotlin/coroutines/c;)Ljava/lang/Object;", "timeMillis", "Lkotlinx/coroutines/o;", "continuation", "d", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/coroutines/f;", "context", "Lkotlinx/coroutines/i1;", "e", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.z0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC15263z0 {

    /* compiled from: Delay.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.z0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15264a {
        @Nullable
        /* renamed from: a */
        public static Object m3484a(@NotNull InterfaceC15263z0 interfaceC15263z0, long j, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
            InterfaceC14268c m8650d;
            Object m8642h;
            if (j <= 0) {
                return Unit.f41048a;
            }
            m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
            C15153p c15153p = new C15153p(m8650d, 1);
            c15153p.mo3915J();
            interfaceC15263z0.mo3487d(j, c15153p);
            Object m3883y = c15153p.m3883y();
            m8642h = C14287b.m8642h();
            if (m3883y == m8642h) {
                DebugProbes.m8616c(interfaceC14268c);
            }
            return m3883y;
        }

        @NotNull
        /* renamed from: b */
        public static InterfaceC15064i1 m3483b(@NotNull InterfaceC15263z0 interfaceC15263z0, long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext) {
            return C15246w0.m3522a().mo3486e(j, runnable, coroutineContext);
        }
    }

    /* renamed from: d */
    void mo3487d(long j, @NotNull InterfaceC15146o<? super Unit> interfaceC15146o);

    @NotNull
    /* renamed from: e */
    InterfaceC15064i1 mo3486e(long j, @NotNull Runnable runnable, @NotNull CoroutineContext coroutineContext);

    @Nullable
    /* renamed from: k */
    Object mo3485k(long j, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);
}
