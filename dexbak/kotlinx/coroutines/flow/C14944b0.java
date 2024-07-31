package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.flow.internal.AbstractC14979c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SharedFlow.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016J)\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m12616d2 = {"Lkotlinx/coroutines/flow/b0;", "Lkotlinx/coroutines/flow/internal/c;", "Lkotlinx/coroutines/flow/y;", "flow", "", "c", "", "Lkotlin/coroutines/c;", "Lkotlin/f1;", "d", "(Lkotlinx/coroutines/flow/y;)[Lkotlin/coroutines/c;", "", "a", "J", "index", "b", "Lkotlin/coroutines/c;", "cont", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.b0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14944b0 extends AbstractC14979c<C15049y<?>> {
    @JvmPlatformAnnotations

    /* renamed from: a */
    public long f42679a = -1;
    @JvmPlatformAnnotations
    @Nullable

    /* renamed from: b */
    public InterfaceC14268c<? super Unit> f42680b;

    @Override // kotlinx.coroutines.flow.internal.AbstractC14979c
    /* renamed from: c */
    public boolean mo4574a(@NotNull C15049y<?> c15049y) {
        if (this.f42679a >= 0) {
            return false;
        }
        this.f42679a = c15049y.m4474Z();
        return true;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractC14979c
    @NotNull
    /* renamed from: d */
    public InterfaceC14268c<Unit>[] mo4573b(@NotNull C15049y<?> c15049y) {
        long j = this.f42679a;
        this.f42679a = -1L;
        this.f42680b = null;
        return c15049y.m4475Y(j);
    }
}
