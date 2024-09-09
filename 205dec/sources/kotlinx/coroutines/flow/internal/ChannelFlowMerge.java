package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.f1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.channels.d0;
import kotlinx.coroutines.e2;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.sync.SemaphoreKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BA\u0012\u0012\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u0014\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0013\u001a\u00020\u0012H\u0014R \u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00140\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChannelFlowMerge;", "T", "Lkotlinx/coroutines/flow/internal/e;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "k", "Lkotlinx/coroutines/q0;", "scope", "Lkotlinx/coroutines/channels/d0;", "o", "Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "g", "Lkotlinx/coroutines/flow/h;", "d", "Lkotlinx/coroutines/flow/h;", "flow", "e", "I", "concurrency", "<init>", "(Lkotlinx/coroutines/flow/h;ILkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ChannelFlowMerge<T> extends e<T> {

    /* renamed from: d  reason: collision with root package name */
    private final kotlinx.coroutines.flow.h<kotlinx.coroutines.flow.h<T>> f60033d;

    /* renamed from: e  reason: collision with root package name */
    private final int f60034e;

    public /* synthetic */ ChannelFlowMerge(kotlinx.coroutines.flow.h hVar, int i4, kotlin.coroutines.f fVar, int i5, BufferOverflow bufferOverflow, int i6, kotlin.jvm.internal.u uVar) {
        this(hVar, i4, (i6 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : fVar, (i6 & 8) != 0 ? -2 : i5, (i6 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    protected String g() {
        return "concurrency=" + this.f60034e;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @Nullable
    protected Object j(@NotNull b0<? super T> b0Var, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object e4 = this.f60033d.e(new ChannelFlowMerge$collectTo$$inlined$collect$1((e2) cVar.getContext().get(e2.f59626i0), SemaphoreKt.b(this.f60034e, 0, 2, null), b0Var, new t(b0Var)), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return e4 == h4 ? e4 : f1.f55527a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    protected e<T> k(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return new ChannelFlowMerge(this.f60033d, this.f60034e, fVar, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    public d0<T> o(@NotNull q0 q0Var) {
        return l.a(q0Var, this.f60131a, this.f60132b, m());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ChannelFlowMerge(@NotNull kotlinx.coroutines.flow.h<? extends kotlinx.coroutines.flow.h<? extends T>> hVar, int i4, @NotNull kotlin.coroutines.f fVar, int i5, @NotNull BufferOverflow bufferOverflow) {
        super(fVar, i5, bufferOverflow);
        this.f60033d = hVar;
        this.f60034e = i4;
    }
}
