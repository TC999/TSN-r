package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ThreadContext.kt */
@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0081\b\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0003\u00a2\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c2\u0003J\u0017\u0010\u0006\u001a\u00020\u00002\f\b\u0002\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0003H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003R\u0018\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/internal/q0;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/internal/p0;", "Ljava/lang/ThreadLocal;", "a", "threadLocal", "b", "", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/ThreadLocal;", "<init>", "(Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
@PublishedApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class q0 implements f.c<p0<?>> {

    /* renamed from: a  reason: collision with root package name */
    private final ThreadLocal<?> f60394a;

    public q0(@NotNull ThreadLocal<?> threadLocal) {
        this.f60394a = threadLocal;
    }

    private final ThreadLocal<?> a() {
        return this.f60394a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ q0 c(q0 q0Var, ThreadLocal threadLocal, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            threadLocal = q0Var.f60394a;
        }
        return q0Var.b(threadLocal);
    }

    @NotNull
    public final q0 b(@NotNull ThreadLocal<?> threadLocal) {
        return new q0(threadLocal);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof q0) && kotlin.jvm.internal.f0.g(this.f60394a, ((q0) obj).f60394a);
        }
        return true;
    }

    public int hashCode() {
        ThreadLocal<?> threadLocal = this.f60394a;
        if (threadLocal != null) {
            return threadLocal.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f60394a + ")";
    }
}
