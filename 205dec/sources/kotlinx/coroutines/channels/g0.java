package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\b \u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0014\u0010\n\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH&J\b\u0010\u000b\u001a\u00020\u0006H\u0016R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/g0;", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/internal/s$d;", "otherOp", "Lkotlinx/coroutines/internal/j0;", "k0", "Lkotlin/f1;", "h0", "Lkotlinx/coroutines/channels/t;", "closed", "j0", "l0", "", "i0", "()Ljava/lang/Object;", "pollResult", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class g0 extends kotlinx.coroutines.internal.s {
    public abstract void h0();

    @Nullable
    public abstract Object i0();

    public abstract void j0(@NotNull t<?> tVar);

    @Nullable
    public abstract kotlinx.coroutines.internal.j0 k0(@Nullable s.d dVar);

    public void l0() {
    }
}
