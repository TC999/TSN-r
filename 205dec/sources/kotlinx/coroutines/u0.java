package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DebugStrings.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a\u0010\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0000\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00038@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00038@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lkotlin/coroutines/c;", "", "c", "", "b", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "a", "classSimpleName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u0 {
    @NotNull
    public static final String a(@NotNull Object obj) {
        return obj.getClass().getSimpleName();
    }

    @NotNull
    public static final String b(@NotNull Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    @NotNull
    public static final String c(@NotNull kotlin.coroutines.c<?> cVar) {
        String m119constructorimpl;
        if (cVar instanceof kotlinx.coroutines.internal.j) {
            return cVar.toString();
        }
        try {
            Result.a aVar = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(cVar + '@' + b(cVar));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m119constructorimpl = Result.m119constructorimpl(kotlin.d0.a(th));
        }
        if (Result.m122exceptionOrNullimpl(m119constructorimpl) != null) {
            m119constructorimpl = cVar.getClass().getName() + '@' + b(cVar);
        }
        return (String) m119constructorimpl;
    }
}
