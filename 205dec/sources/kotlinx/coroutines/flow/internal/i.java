package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Merge.kt */
@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u0012\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00130\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/flow/internal/i;", "T", "Lkotlinx/coroutines/flow/internal/e;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "k", "Lkotlinx/coroutines/q0;", "scope", "Lkotlinx/coroutines/channels/d0;", "o", "Lkotlinx/coroutines/channels/b0;", "Lkotlin/f1;", "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "Lkotlinx/coroutines/flow/h;", "d", "Ljava/lang/Iterable;", "flows", "<init>", "(Ljava/lang/Iterable;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i<T> extends e<T> {

    /* renamed from: d  reason: collision with root package name */
    private final Iterable<kotlinx.coroutines.flow.h<T>> f60148d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Merge.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0006\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelLimitedFlowMerge$collectTo$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private q0 f60149a;

        /* renamed from: b  reason: collision with root package name */
        Object f60150b;

        /* renamed from: c  reason: collision with root package name */
        int f60151c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.h f60152d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ b0 f60153e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ t f60154f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlinx.coroutines.flow.h hVar, kotlin.coroutines.c cVar, b0 b0Var, t tVar) {
            super(2, cVar);
            this.f60152d = hVar;
            this.f60153e = b0Var;
            this.f60154f = tVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f60152d, cVar, this.f60153e, this.f60154f);
            aVar.f60149a = (q0) obj;
            return aVar;
        }

        @Override // d2.p
        public final Object invoke(q0 q0Var, kotlin.coroutines.c<? super f1> cVar) {
            return ((a) create(q0Var, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f60151c;
            if (i4 == 0) {
                d0.n(obj);
                q0 q0Var = this.f60149a;
                kotlinx.coroutines.flow.h hVar = this.f60152d;
                t tVar = this.f60154f;
                this.f60150b = q0Var;
                this.f60151c = 1;
                if (hVar.e(tVar, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q0 q0Var2 = (q0) this.f60150b;
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    public /* synthetic */ i(Iterable iterable, kotlin.coroutines.f fVar, int i4, BufferOverflow bufferOverflow, int i5, kotlin.jvm.internal.u uVar) {
        this(iterable, (i5 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : fVar, (i5 & 4) != 0 ? -2 : i4, (i5 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @Nullable
    protected Object j(@NotNull b0<? super T> b0Var, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        t tVar = new t(b0Var);
        for (kotlinx.coroutines.flow.h<T> hVar : this.f60148d) {
            kotlinx.coroutines.j.f(b0Var, null, null, new a(hVar, null, b0Var, tVar), 3, null);
        }
        return f1.f55527a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    protected e<T> k(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return new i(this.f60148d, fVar, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    public kotlinx.coroutines.channels.d0<T> o(@NotNull q0 q0Var) {
        return l.a(q0Var, this.f60131a, this.f60132b, m());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(@NotNull Iterable<? extends kotlinx.coroutines.flow.h<? extends T>> iterable, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        super(fVar, i4, bufferOverflow);
        this.f60148d = iterable;
    }
}
