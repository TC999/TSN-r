package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CompletionState.kt */
@Metadata(bv = {}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aK\u0010\n\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012%\b\u0002\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000b\u001a0\u0010\u000e\u001a\u0004\u0018\u00010\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\fH\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000f\u001a6\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"T", "Lkotlin/Result;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "onCancellation", "", "b", "(Ljava/lang/Object;Ld2/l;)Ljava/lang/Object;", "Lkotlinx/coroutines/o;", "caller", "c", "(Ljava/lang/Object;Lkotlinx/coroutines/o;)Ljava/lang/Object;", "state", "Lkotlin/coroutines/c;", "uCont", "a", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i0 {
    @NotNull
    public static final <T> Object a(@Nullable Object obj, @NotNull kotlin.coroutines.c<? super T> cVar) {
        if (obj instanceof d0) {
            Result.a aVar = Result.Companion;
            return Result.m119constructorimpl(kotlin.d0.a(((d0) obj).f59534a));
        }
        Result.a aVar2 = Result.Companion;
        return Result.m119constructorimpl(obj);
    }

    @Nullable
    public static final <T> Object b(@NotNull Object obj, @Nullable d2.l<? super Throwable, kotlin.f1> lVar) {
        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
        if (m122exceptionOrNullimpl == null) {
            return lVar != null ? new e0(obj, lVar) : obj;
        }
        return new d0(m122exceptionOrNullimpl, false, 2, null);
    }

    @Nullable
    public static final <T> Object c(@NotNull Object obj, @NotNull o<?> oVar) {
        Throwable m122exceptionOrNullimpl = Result.m122exceptionOrNullimpl(obj);
        return m122exceptionOrNullimpl == null ? obj : new d0(m122exceptionOrNullimpl, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, d2.l lVar, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
