package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: StateFlow.kt */
@Metadata(bv = {}, d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004\u001a\u001a\u0010\b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00050\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0000\u001a6\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0000\"\u001a\u0010\u0015\u001a\u00020\u00118\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0012\u0012\u0004\b\u0013\u0010\u0014\"\u001a\u0010\u0018\u001a\u00020\u00118\u0002X\u0083\u0004\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0012\u0012\u0004\b\u0017\u0010\u0014\u00a8\u0006\u0019"}, d2 = {"T", "value", "Lkotlinx/coroutines/flow/t;", "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/flow/t;", "", "delta", "Lkotlin/f1;", "g", "Lkotlinx/coroutines/flow/h0;", "Lkotlin/coroutines/f;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/h;", "d", "Lkotlinx/coroutines/internal/j0;", "Lkotlinx/coroutines/internal/j0;", "getNONE$annotations", "()V", "NONE", "b", "getPENDING$annotations", "PENDING", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.j0 f60182a = new kotlinx.coroutines.internal.j0("NONE");

    /* renamed from: b  reason: collision with root package name */
    private static final kotlinx.coroutines.internal.j0 f60183b = new kotlinx.coroutines.internal.j0("PENDING");

    @NotNull
    public static final <T> t<T> a(T t3) {
        if (t3 == null) {
            t3 = (T) kotlinx.coroutines.flow.internal.r.f60167a;
        }
        return new i0(t3);
    }

    @NotNull
    public static final <T> h<T> d(@NotNull h0<? extends T> h0Var, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return (((i4 < 0 || 1 < i4) && i4 != -2) || bufferOverflow != BufferOverflow.DROP_OLDEST) ? a0.e(h0Var, fVar, i4, bufferOverflow) : h0Var;
    }

    private static /* synthetic */ void e() {
    }

    private static /* synthetic */ void f() {
    }

    public static final void g(@NotNull t<Integer> tVar, int i4) {
        int intValue;
        do {
            intValue = tVar.getValue().intValue();
        } while (!tVar.compareAndSet(Integer.valueOf(intValue), Integer.valueOf(intValue + i4)));
    }
}
