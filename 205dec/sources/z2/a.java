package z2;

import d2.l;
import d2.p;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.d0;
import kotlin.f1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Cancellable.kt */
@Metadata(bv = {}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a@\u0010\u0006\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007\u001a{\u0010\u0010\u001a\u00020\u0005\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0000*\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\t2\u0006\u0010\n\u001a\u00028\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u00022%\b\u0002\u0010\u000f\u001a\u001f\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0001H\u0000\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u001a\u001e\u0010\u0013\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00050\u00022\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0000\u001a#\u0010\u0016\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"T", "Lkotlin/Function1;", "Lkotlin/coroutines/c;", "", "completion", "Lkotlin/f1;", "b", "(Ld2/l;Lkotlin/coroutines/c;)V", "R", "Lkotlin/Function2;", "receiver", "", "Lkotlin/ParameterName;", "name", "cause", "onCancellation", "c", "(Ld2/p;Ljava/lang/Object;Lkotlin/coroutines/c;Ld2/l;)V", "fatalCompletion", "d", "Lkotlin/Function0;", "block", "a", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    private static final void a(c<?> cVar, d2.a<f1> aVar) {
        try {
            aVar.invoke();
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            cVar.resumeWith(Result.m119constructorimpl(d0.a(th)));
        }
    }

    @InternalCoroutinesApi
    public static final <T> void b(@NotNull l<? super c<? super T>, ? extends Object> lVar, @NotNull c<? super T> cVar) {
        try {
            c d4 = kotlin.coroutines.intrinsics.a.d(kotlin.coroutines.intrinsics.a.b(lVar, cVar));
            Result.a aVar = Result.Companion;
            k.g(d4, Result.m119constructorimpl(f1.f55527a), null, 2, null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            cVar.resumeWith(Result.m119constructorimpl(d0.a(th)));
        }
    }

    public static final <R, T> void c(@NotNull p<? super R, ? super c<? super T>, ? extends Object> pVar, R r3, @NotNull c<? super T> cVar, @Nullable l<? super Throwable, f1> lVar) {
        try {
            c d4 = kotlin.coroutines.intrinsics.a.d(kotlin.coroutines.intrinsics.a.c(pVar, r3, cVar));
            Result.a aVar = Result.Companion;
            k.f(d4, Result.m119constructorimpl(f1.f55527a), lVar);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            cVar.resumeWith(Result.m119constructorimpl(d0.a(th)));
        }
    }

    public static final void d(@NotNull c<? super f1> cVar, @NotNull c<?> cVar2) {
        try {
            c d4 = kotlin.coroutines.intrinsics.a.d(cVar);
            Result.a aVar = Result.Companion;
            k.g(d4, Result.m119constructorimpl(f1.f55527a), null, 2, null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            cVar2.resumeWith(Result.m119constructorimpl(d0.a(th)));
        }
    }

    public static /* synthetic */ void e(p pVar, Object obj, c cVar, l lVar, int i4, Object obj2) {
        if ((i4 & 4) != 0) {
            lVar = null;
        }
        c(pVar, obj, cVar, lVar);
    }
}
