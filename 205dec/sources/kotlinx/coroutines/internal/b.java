package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Atomic.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H&J\u001e\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&R&\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/internal/b;", "", "Lkotlinx/coroutines/internal/d;", "op", "c", "failure", "Lkotlin/f1;", "a", "Lkotlinx/coroutines/internal/d;", "b", "()Lkotlinx/coroutines/internal/d;", "d", "(Lkotlinx/coroutines/internal/d;)V", "atomicOp", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public d<?> f60346a;

    public abstract void a(@NotNull d<?> dVar, @Nullable Object obj);

    @NotNull
    public final d<?> b() {
        d<?> dVar = this.f60346a;
        if (dVar == null) {
            kotlin.jvm.internal.f0.S("atomicOp");
        }
        return dVar;
    }

    @Nullable
    public abstract Object c(@NotNull d<?> dVar);

    public final void d(@NotNull d<?> dVar) {
        this.f60346a = dVar;
    }
}
