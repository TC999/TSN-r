package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.t0;
import kotlinx.coroutines.internal.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChannelFlow.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a]\u0010\u0010\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00028\u00012\b\b\u0002\u0010\f\u001a\u00020\u000b2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rH\u0080@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"T", "Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/internal/e;", "b", "Lkotlinx/coroutines/flow/i;", "Lkotlin/coroutines/f;", "emitContext", "e", "V", "newContext", "value", "", "countOrElement", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "block", "c", "(Lkotlin/coroutines/f;Ljava/lang/Object;Ljava/lang/Object;Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f {
    public static final /* synthetic */ kotlinx.coroutines.flow.i a(kotlinx.coroutines.flow.i iVar, kotlin.coroutines.f fVar) {
        return e(iVar, fVar);
    }

    @NotNull
    public static final <T> e<T> b(@NotNull kotlinx.coroutines.flow.h<? extends T> hVar) {
        e<T> eVar = (e) (!(hVar instanceof e) ? null : hVar);
        return eVar != null ? eVar : new h(hVar, null, 0, null, 14, null);
    }

    @Nullable
    public static final <T, V> Object c(@NotNull kotlin.coroutines.f fVar, V v3, @NotNull Object obj, @NotNull d2.p<? super V, ? super kotlin.coroutines.c<? super T>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        Object h4;
        Object c4 = o0.c(fVar, obj);
        try {
            u uVar = new u(cVar, fVar);
            if (pVar != null) {
                Object invoke = ((d2.p) t0.q(pVar, 2)).invoke(v3, uVar);
                o0.a(fVar, c4);
                h4 = kotlin.coroutines.intrinsics.b.h();
                if (invoke == h4) {
                    kotlin.coroutines.jvm.internal.e.c(cVar);
                }
                return invoke;
            }
            throw new NullPointerException("null cannot be cast to non-null type (R, kotlin.coroutines.Continuation<T>) -> kotlin.Any?");
        } catch (Throwable th) {
            o0.a(fVar, c4);
            throw th;
        }
    }

    public static /* synthetic */ Object d(kotlin.coroutines.f fVar, Object obj, Object obj2, d2.p pVar, kotlin.coroutines.c cVar, int i4, Object obj3) {
        if ((i4 & 4) != 0) {
            obj2 = o0.b(fVar);
        }
        return c(fVar, obj, obj2, pVar, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> kotlinx.coroutines.flow.i<T> e(kotlinx.coroutines.flow.i<? super T> iVar, kotlin.coroutines.f fVar) {
        return ((iVar instanceof t) || (iVar instanceof q)) ? iVar : new v(iVar, fVar);
    }
}
