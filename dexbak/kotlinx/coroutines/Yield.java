package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.intrinsics.C14287b;
import kotlin.coroutines.intrinsics.IntrinsicsJvm;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlinx.coroutines.internal.C15080k;
import kotlinx.coroutines.internal.DispatchedContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0001\u001a\u00020\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\f\u0010\u0004\u001a\u00020\u0000*\u00020\u0003H\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, m12616d2 = {"Lkotlin/f1;", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/coroutines/f;", "a", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.v3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class Yield {
    /* renamed from: a */
    public static final void m3531a(@NotNull CoroutineContext coroutineContext) {
        Job job = (Job) coroutineContext.get(Job.f42281m0);
        if (job != null && !job.isActive()) {
            throw job.mo3825l();
        }
    }

    @Nullable
    /* renamed from: b */
    public static final Object m3530b(@NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        InterfaceC14268c m8650d;
        Object obj;
        Object m8642h;
        Object m8642h2;
        CoroutineContext context = interfaceC14268c.getContext();
        m3531a(context);
        m8650d = IntrinsicsJvm.m8650d(interfaceC14268c);
        if (!(m8650d instanceof DispatchedContinuation)) {
            m8650d = null;
        }
        DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) m8650d;
        if (dispatchedContinuation != null) {
            if (dispatchedContinuation.f43055g.isDispatchNeeded(context)) {
                dispatchedContinuation.m4309m(context, Unit.f41048a);
            } else {
                C15239u3 c15239u3 = new C15239u3();
                CoroutineContext plus = context.plus(c15239u3);
                obj = Unit.f41048a;
                dispatchedContinuation.m4309m(plus, obj);
                if (c15239u3.f43427a) {
                    if (C15080k.m4292h(dispatchedContinuation)) {
                        obj = C14287b.m8642h();
                    }
                }
            }
            obj = C14287b.m8642h();
        } else {
            obj = Unit.f41048a;
        }
        m8642h = C14287b.m8642h();
        if (obj == m8642h) {
            DebugProbes.m8616c(interfaceC14268c);
        }
        m8642h2 = C14287b.m8642h();
        return obj == m8642h2 ? obj : Unit.f41048a;
    }
}
