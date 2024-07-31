package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H&J\u001e\u0010\u0007\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&R&\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0010"}, m12616d2 = {"Lkotlinx/coroutines/internal/b;", "", "Lkotlinx/coroutines/internal/d;", "op", "c", "failure", "Lkotlin/f1;", "a", "Lkotlinx/coroutines/internal/d;", "b", "()Lkotlinx/coroutines/internal/d;", "d", "(Lkotlinx/coroutines/internal/d;)V", "atomicOp", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class Atomic {
    @NotNull

    /* renamed from: a */
    public AbstractC15074d<?> f43029a;

    /* renamed from: a */
    public abstract void mo3623a(@NotNull AbstractC15074d<?> abstractC15074d, @Nullable Object obj);

    @NotNull
    /* renamed from: b */
    public final AbstractC15074d<?> m4382b() {
        AbstractC15074d<?> abstractC15074d = this.f43029a;
        if (abstractC15074d == null) {
            C14342f0.m8200S("atomicOp");
        }
        return abstractC15074d;
    }

    @Nullable
    /* renamed from: c */
    public abstract Object mo3622c(@NotNull AbstractC15074d<?> abstractC15074d);

    /* renamed from: d */
    public final void m4381d(@NotNull AbstractC15074d<?> abstractC15074d) {
        this.f43029a = abstractC15074d;
    }
}
