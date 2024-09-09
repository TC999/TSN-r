package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.f1;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ChannelFlow.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0002B3\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0010\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bH\u0016J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/flow/internal/h;", "T", "Lkotlinx/coroutines/flow/internal/g;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/internal/e;", "k", "Lkotlinx/coroutines/flow/h;", "l", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "s", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "flow", "<init>", "(Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h<T> extends g<T, T> {
    public /* synthetic */ h(kotlinx.coroutines.flow.h hVar, kotlin.coroutines.f fVar, int i4, BufferOverflow bufferOverflow, int i5, kotlin.jvm.internal.u uVar) {
        this(hVar, (i5 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : fVar, (i5 & 4) != 0 ? -3 : i4, (i5 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    protected e<T> k(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return new h(this.f60143d, fVar, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @Nullable
    public kotlinx.coroutines.flow.h<T> l() {
        return (kotlinx.coroutines.flow.h<T>) this.f60143d;
    }

    @Override // kotlinx.coroutines.flow.internal.g
    @Nullable
    protected Object s(@NotNull kotlinx.coroutines.flow.i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object e4 = this.f60143d.e(iVar, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    public h(@NotNull kotlinx.coroutines.flow.h<? extends T> hVar, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        super(hVar, fVar, i4, bufferOverflow);
    }
}
