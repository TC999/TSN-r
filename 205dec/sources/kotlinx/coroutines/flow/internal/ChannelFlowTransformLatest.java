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
/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003Bz\u0012B\u0010\u0018\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0013\u0012\u00118\u0000\u00a2\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u0011\u00a2\u0006\u0002\b\u0017\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J!\u0010\u000f\u001a\u00020\u000e2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00010\fH\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowTransformLatest;", "T", "R", "Lkotlinx/coroutines/flow/internal/g;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/internal/e;", "k", "Lkotlinx/coroutines/flow/i;", "collector", "Lkotlin/f1;", "s", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "transform", "Lkotlinx/coroutines/flow/h;", "flow", "<init>", "(Ld2/q;Lkotlinx/coroutines/flow/h;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ChannelFlowTransformLatest<T, R> extends g<T, R> {

    /* renamed from: e  reason: collision with root package name */
    private final d2.q<kotlinx.coroutines.flow.i<? super R>, T, kotlin.coroutines.c<? super f1>, Object> f60044e;

    public /* synthetic */ ChannelFlowTransformLatest(d2.q qVar, kotlinx.coroutines.flow.h hVar, kotlin.coroutines.f fVar, int i4, BufferOverflow bufferOverflow, int i5, kotlin.jvm.internal.u uVar) {
        this(qVar, hVar, (i5 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : fVar, (i5 & 8) != 0 ? -2 : i4, (i5 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    protected e<R> k(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return new ChannelFlowTransformLatest(this.f60044e, this.f60143d, fVar, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.g
    @Nullable
    protected Object s(@NotNull kotlinx.coroutines.flow.i<? super R> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object c4 = l.c(new ChannelFlowTransformLatest$flowCollect$3(this, iVar, null), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return c4 == h4 ? c4 : f1.f55527a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowTransformLatest(@NotNull d2.q<? super kotlinx.coroutines.flow.i<? super R>, ? super T, ? super kotlin.coroutines.c<? super f1>, ? extends Object> qVar, @NotNull kotlinx.coroutines.flow.h<? extends T> hVar, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        super(hVar, fVar, i4, bufferOverflow);
        this.f60044e = qVar;
    }
}
