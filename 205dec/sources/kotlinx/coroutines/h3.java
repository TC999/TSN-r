package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Supervisor.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u001a\u001b\u0010\u0004\u001a\u00020\u00002\n\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001aO\u0010\r\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007\u00a2\u0006\u0002\b\u000bH\u0086@\u00f8\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u00a2\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/e2;", "parent", "Lkotlinx/coroutines/b0;", "a", "b", "(Lkotlinx/coroutines/e2;)Lkotlinx/coroutines/e2;", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "e", "(Ld2/p;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class h3 {
    @NotNull
    public static final b0 a(@Nullable e2 e2Var) {
        return new g3(e2Var);
    }

    public static /* synthetic */ b0 c(e2 e2Var, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            e2Var = null;
        }
        return a(e2Var);
    }

    public static /* synthetic */ e2 d(e2 e2Var, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            e2Var = null;
        }
        return a(e2Var);
    }

    @Nullable
    public static final <R> Object e(@NotNull d2.p<? super q0, ? super kotlin.coroutines.c<? super R>, ? extends Object> pVar, @NotNull kotlin.coroutines.c<? super R> cVar) {
        Object h4;
        f3 f3Var = new f3(cVar.getContext(), cVar);
        Object f4 = z2.b.f(f3Var, f3Var, pVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (f4 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return f4;
    }
}
