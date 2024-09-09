package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.f1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0014\u0010\u0007\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H&J%\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0010\u001a\u00020\r8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lkotlinx/coroutines/channels/c0;", "E", "Lkotlinx/coroutines/internal/s;", "Lkotlinx/coroutines/channels/e0;", "Lkotlinx/coroutines/channels/t;", "closed", "Lkotlin/f1;", "j0", "value", "Lkotlin/Function1;", "", "i0", "(Ljava/lang/Object;)Ld2/l;", "Lkotlinx/coroutines/internal/j0;", "h0", "()Lkotlinx/coroutines/internal/j0;", "offerResult", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class c0<E> extends kotlinx.coroutines.internal.s implements e0<E> {
    @Override // kotlinx.coroutines.channels.e0
    @NotNull
    /* renamed from: h0 */
    public kotlinx.coroutines.internal.j0 e() {
        return b.f59397e;
    }

    @Nullable
    public d2.l<Throwable, f1> i0(E e4) {
        return null;
    }

    public abstract void j0(@NotNull t<?> tVar);
}
