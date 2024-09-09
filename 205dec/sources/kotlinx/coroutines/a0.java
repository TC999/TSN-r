package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableDeferred.kt */
@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a.\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"T", "Lkotlinx/coroutines/y;", "Lkotlin/Result;", "result", "", "d", "(Lkotlinx/coroutines/y;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/e2;", "parent", "b", "value", "a", "(Ljava/lang/Object;)Lkotlinx/coroutines/y;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a0 {
    @NotNull
    public static final <T> y<T> a(T t3) {
        z zVar = new z(null);
        zVar.v(t3);
        return zVar;
    }

    @NotNull
    public static final <T> y<T> b(@Nullable e2 e2Var) {
        return new z(e2Var);
    }

    public static /* synthetic */ y c(e2 e2Var, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            e2Var = null;
        }
        return b(e2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> boolean d(@NotNull y<T> yVar, @NotNull Object obj) {
        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
        return m122exceptionOrNullimpl == null ? yVar.v(obj) : yVar.c(m122exceptionOrNullimpl);
    }
}
