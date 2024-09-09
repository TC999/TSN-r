package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadContextElement.kt */
@Metadata(bv = {}, d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0002\u001a\u00028\u0000\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0001H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u0001H\u0086H\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"T", "Ljava/lang/ThreadLocal;", "value", "Lkotlinx/coroutines/i3;", "a", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/i3;", "", "e", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/f1;", "c", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j3 {
    @NotNull
    public static final <T> i3<T> a(@NotNull ThreadLocal<T> threadLocal, T t3) {
        return new kotlinx.coroutines.internal.p0(t3, threadLocal);
    }

    public static /* synthetic */ i3 b(ThreadLocal threadLocal, Object obj, int i4, Object obj2) {
        if ((i4 & 1) != 0) {
            obj = threadLocal.get();
        }
        return a(threadLocal, obj);
    }

    @Nullable
    public static final Object c(@NotNull ThreadLocal<?> threadLocal, @NotNull kotlin.coroutines.c<? super kotlin.f1> cVar) {
        if (kotlin.coroutines.jvm.internal.a.a(cVar.getContext().get(new kotlinx.coroutines.internal.q0(threadLocal)) != null).booleanValue()) {
            return kotlin.f1.f55527a;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + cVar.getContext()).toString());
    }

    @Nullable
    private static final Object d(@NotNull ThreadLocal threadLocal, @NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }

    @Nullable
    public static final Object e(@NotNull ThreadLocal<?> threadLocal, @NotNull kotlin.coroutines.c<? super Boolean> cVar) {
        return kotlin.coroutines.jvm.internal.a.a(cVar.getContext().get(new kotlinx.coroutines.internal.q0(threadLocal)) != null);
    }

    @Nullable
    private static final Object f(@NotNull ThreadLocal threadLocal, @NotNull kotlin.coroutines.c cVar) {
        kotlin.jvm.internal.c0.e(3);
        throw null;
    }
}
