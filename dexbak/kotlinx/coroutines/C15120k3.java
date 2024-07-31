package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: EventLoop.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0007J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\nR(\u0010\u000e\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000bj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0002`\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\b\u001a\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0011"}, m12616d2 = {"Lkotlinx/coroutines/k3;", "", "Lkotlinx/coroutines/m1;", "a", "()Lkotlinx/coroutines/m1;", "Lkotlin/f1;", "c", "()V", "eventLoop", "d", "(Lkotlinx/coroutines/m1;)V", "Ljava/lang/ThreadLocal;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "Ljava/lang/ThreadLocal;", "ref", "b", "<init>", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.k3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15120k3 {

    /* renamed from: b */
    public static final C15120k3 f43148b = new C15120k3();

    /* renamed from: a */
    private static final ThreadLocal<AbstractC15133m1> f43147a = new ThreadLocal<>();

    private C15120k3() {
    }

    @Nullable
    /* renamed from: a */
    public final AbstractC15133m1 m4084a() {
        return f43147a.get();
    }

    @NotNull
    /* renamed from: b */
    public final AbstractC15133m1 m4083b() {
        ThreadLocal<AbstractC15133m1> threadLocal = f43147a;
        AbstractC15133m1 abstractC15133m1 = threadLocal.get();
        if (abstractC15133m1 != null) {
            return abstractC15133m1;
        }
        AbstractC15133m1 m3877a = C15155p1.m3877a();
        threadLocal.set(m3877a);
        return m3877a;
    }

    /* renamed from: c */
    public final void m4082c() {
        f43147a.set(null);
    }

    /* renamed from: d */
    public final void m4081d(@NotNull AbstractC15133m1 abstractC15133m1) {
        f43147a.set(abstractC15133m1);
    }
}
