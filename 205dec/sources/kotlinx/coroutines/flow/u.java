package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.f1;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Share.kt */
@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0015\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0097A\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0016X\u0096\u0005\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/flow/u;", "T", "Lkotlinx/coroutines/flow/x;", "Lkotlinx/coroutines/flow/c;", "Lkotlinx/coroutines/flow/internal/o;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/h;", "a", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "d", "()Ljava/util/List;", "replayCache", "flow", "<init>", "(Lkotlinx/coroutines/flow/x;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class u<T> implements x<T>, c<T>, kotlinx.coroutines.flow.internal.o<T> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ x<? extends T> f60309a;

    public u(@NotNull x<? extends T> xVar) {
        this.f60309a = xVar;
    }

    @Override // kotlinx.coroutines.flow.internal.o
    @NotNull
    public h<T> a(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return a0.e(this, fVar, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.x
    @NotNull
    public List<T> d() {
        return (List<? extends T>) this.f60309a.d();
    }

    @Override // kotlinx.coroutines.flow.h
    @InternalCoroutinesApi
    @Nullable
    public Object e(@NotNull i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return this.f60309a.e(iVar, cVar);
    }
}
