package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CancellableContinuation.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a5\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0005\u0010\u0006\u001a5\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\u0080H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\u0006\u001a\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\u00002\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\r\u001a\u00020\fH\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlinx/coroutines/o;", "Lkotlin/f1;", "block", "d", "(Ld2/l;Lkotlin/coroutines/c;)Ljava/lang/Object;", "f", "Lkotlin/coroutines/c;", "delegate", "Lkotlinx/coroutines/p;", "b", "Lkotlinx/coroutines/internal/s;", "node", "c", "Lkotlinx/coroutines/i1;", "handle", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r {
    @InternalCoroutinesApi
    public static final void a(@NotNull o<?> oVar, @NotNull i1 i1Var) {
        oVar.B(new j1(i1Var));
    }

    @NotNull
    public static final <T> p<T> b(@NotNull kotlin.coroutines.c<? super T> cVar) {
        if (!(cVar instanceof kotlinx.coroutines.internal.j)) {
            return new p<>(cVar, 2);
        }
        p<T> k4 = ((kotlinx.coroutines.internal.j) cVar).k();
        if (k4 != null) {
            if (!k4.I()) {
                k4 = null;
            }
            if (k4 != null) {
                return k4;
            }
        }
        return new p<>(cVar, 2);
    }

    public static final void c(@NotNull o<?> oVar, @NotNull kotlinx.coroutines.internal.s sVar) {
        oVar.B(new w2(sVar));
    }

    @Nullable
    public static final <T> Object d(@NotNull d2.l<? super o<? super T>, kotlin.f1> lVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p pVar = new p(d4, 1);
        pVar.H();
        lVar.invoke(pVar);
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @Nullable
    private static final Object e(@NotNull d2.l lVar, @NotNull kotlin.coroutines.c cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        kotlin.jvm.internal.c0.e(0);
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p pVar = new p(d4, 1);
        pVar.H();
        lVar.invoke(pVar);
        Object y3 = pVar.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        kotlin.jvm.internal.c0.e(1);
        return y3;
    }

    @Nullable
    public static final <T> Object f(@NotNull d2.l<? super o<? super T>, kotlin.f1> lVar, @NotNull kotlin.coroutines.c<? super T> cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p b4 = b(d4);
        lVar.invoke(b4);
        Object y3 = b4.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        return y3;
    }

    @Nullable
    private static final Object g(@NotNull d2.l lVar, @NotNull kotlin.coroutines.c cVar) {
        kotlin.coroutines.c d4;
        Object h4;
        kotlin.jvm.internal.c0.e(0);
        d4 = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        p b4 = b(d4);
        lVar.invoke(b4);
        Object y3 = b4.y();
        h4 = kotlin.coroutines.intrinsics.b.h();
        if (y3 == h4) {
            kotlin.coroutines.jvm.internal.e.c(cVar);
        }
        kotlin.jvm.internal.c0.e(1);
        return y3;
    }
}
