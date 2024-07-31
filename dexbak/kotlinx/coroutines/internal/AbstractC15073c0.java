package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlinx.coroutines.DebugStrings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Atomic.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000R\u001a\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\t8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/internal/c0;", "", "affected", "c", "", "toString", "that", "", "b", "Lkotlinx/coroutines/internal/d;", "a", "()Lkotlinx/coroutines/internal/d;", "atomicOp", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.c0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC15073c0 {
    @Nullable
    /* renamed from: a */
    public abstract AbstractC15074d<?> mo3621a();

    /* renamed from: b */
    public final boolean m4374b(@NotNull AbstractC15073c0 abstractC15073c0) {
        AbstractC15074d<?> mo3621a;
        AbstractC15074d<?> mo3621a2 = mo3621a();
        return (mo3621a2 == null || (mo3621a = abstractC15073c0.mo3621a()) == null || mo3621a2.mo3711g() >= mo3621a.mo3711g()) ? false : true;
    }

    @Nullable
    /* renamed from: c */
    public abstract Object mo3620c(@Nullable Object obj);

    @NotNull
    public String toString() {
        return DebugStrings.m3554a(this) + '@' + DebugStrings.m3553b(this);
    }
}
