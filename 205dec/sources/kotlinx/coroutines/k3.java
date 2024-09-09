package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: EventLoop.common.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c1\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0007J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0000\u00a2\u0006\u0004\b\t\u0010\nR(\u0010\u000e\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\b\u001a\u00020\u00028@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004\u00a8\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/k3;", "", "Lkotlinx/coroutines/m1;", "a", "()Lkotlinx/coroutines/m1;", "Lkotlin/f1;", "c", "()V", "eventLoop", "d", "(Lkotlinx/coroutines/m1;)V", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "Ljava/lang/ThreadLocal;", "ref", "b", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k3 {

    /* renamed from: b  reason: collision with root package name */
    public static final k3 f60465b = new k3();

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<m1> f60464a = new ThreadLocal<>();

    private k3() {
    }

    @Nullable
    public final m1 a() {
        return f60464a.get();
    }

    @NotNull
    public final m1 b() {
        ThreadLocal<m1> threadLocal = f60464a;
        m1 m1Var = threadLocal.get();
        if (m1Var != null) {
            return m1Var;
        }
        m1 a4 = p1.a();
        threadLocal.set(a4);
        return a4;
    }

    public final void c() {
        f60464a.set(null);
    }

    public final void d(@NotNull m1 m1Var) {
        f60464a.set(m1Var);
    }
}
