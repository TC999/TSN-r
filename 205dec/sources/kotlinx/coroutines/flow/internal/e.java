package kotlinx.coroutines.flow.internal;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.d0;
import kotlin.f1;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.b0;
import kotlinx.coroutines.channels.z;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ChannelFlow.kt */
@InternalCoroutinesApi
@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0016J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J&\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH$J!\u0010\u0010\u001a\u00020\u000f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u00a4@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00172\u0006\u0010\u000e\u001a\u00020\u0012H\u0016J!\u0010\u001b\u001a\u00020\u000f2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\n\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001f\u001a\u00020\u001dH\u0016R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010 R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00078BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b%\u0010&R9\u0010-\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0)\u0012\u0006\u0012\u0004\u0018\u00010*0(8@X\u0080\u0004\u00f8\u0001\u0000\u00a2\u0006\u0006\u001a\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lkotlinx/coroutines/flow/internal/e;", "T", "Lkotlinx/coroutines/flow/internal/o;", "Lkotlinx/coroutines/flow/h;", "l", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "a", "k", "Lkotlinx/coroutines/channels/b0;", "scope", "Lkotlin/f1;", "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlinx/coroutines/channels/j;", "h", "Lkotlinx/coroutines/channels/d0;", "o", "Lkotlinx/coroutines/flow/i;", "collector", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "g", "toString", "Lkotlin/coroutines/f;", "b", "I", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", "n", "()I", "produceCapacity", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "m", "()Ld2/p;", "collectToFun", "<init>", "(Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class e<T> implements o<T> {
    @JvmField
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final kotlin.coroutines.f f60131a;
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public final int f60132b;
    @JvmField
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final BufferOverflow f60133c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ChannelFlow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/q0;", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", i = {0}, l = {135}, m = "invokeSuspend", n = {"$this$coroutineScope"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends SuspendLambda implements d2.p<q0, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private q0 f60134a;

        /* renamed from: b  reason: collision with root package name */
        Object f60135b;

        /* renamed from: c  reason: collision with root package name */
        int f60136c;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.flow.i f60138e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlinx.coroutines.flow.i iVar, kotlin.coroutines.c cVar) {
            super(2, cVar);
            this.f60138e = iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f60138e, cVar);
            aVar.f60134a = (q0) obj;
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
            int i4 = this.f60136c;
            if (i4 == 0) {
                d0.n(obj);
                q0 q0Var = this.f60134a;
                kotlinx.coroutines.flow.i iVar = this.f60138e;
                kotlinx.coroutines.channels.d0<T> o4 = e.this.o(q0Var);
                this.f60135b = q0Var;
                this.f60136c = 1;
                if (kotlinx.coroutines.flow.k.q0(iVar, o4, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q0 q0Var2 = (q0) this.f60135b;
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: ChannelFlow.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "Lkotlinx/coroutines/channels/b0;", "it", "Lkotlin/f1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", f = "ChannelFlow.kt", i = {0}, l = {60}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends SuspendLambda implements d2.p<b0<? super T>, kotlin.coroutines.c<? super f1>, Object> {

        /* renamed from: a  reason: collision with root package name */
        private b0 f60139a;

        /* renamed from: b  reason: collision with root package name */
        Object f60140b;

        /* renamed from: c  reason: collision with root package name */
        int f60141c;

        b(kotlin.coroutines.c cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final kotlin.coroutines.c<f1> create(@Nullable Object obj, @NotNull kotlin.coroutines.c<?> cVar) {
            b bVar = new b(cVar);
            bVar.f60139a = (b0) obj;
            return bVar;
        }

        @Override // d2.p
        public final Object invoke(Object obj, kotlin.coroutines.c<? super f1> cVar) {
            return ((b) create(obj, cVar)).invokeSuspend(f1.f55527a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object h4;
            h4 = kotlin.coroutines.intrinsics.b.h();
            int i4 = this.f60141c;
            if (i4 == 0) {
                d0.n(obj);
                b0<? super T> b0Var = this.f60139a;
                e eVar = e.this;
                this.f60140b = b0Var;
                this.f60141c = 1;
                if (eVar.j(b0Var, this) == h4) {
                    return h4;
                }
            } else if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                b0 b0Var2 = (b0) this.f60140b;
                d0.n(obj);
            }
            return f1.f55527a;
        }
    }

    public e(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        this.f60131a = fVar;
        this.f60132b = i4;
        this.f60133c = bufferOverflow;
    }

    static /* synthetic */ Object i(e eVar, kotlinx.coroutines.flow.i iVar, kotlin.coroutines.c cVar) {
        Object h4;
        Object g4 = r0.g(new a(iVar, null), cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return g4 == h4 ? g4 : f1.f55527a;
    }

    private final int n() {
        int i4 = this.f60132b;
        if (i4 == -3) {
            return -2;
        }
        return i4;
    }

    @Override // kotlinx.coroutines.flow.internal.o
    @NotNull
    public kotlinx.coroutines.flow.h<T> a(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        kotlin.coroutines.f plus = fVar.plus(this.f60131a);
        if (bufferOverflow == BufferOverflow.SUSPEND) {
            int i5 = this.f60132b;
            if (i5 != -3) {
                if (i4 != -3) {
                    if (i5 != -2) {
                        if (i4 != -2 && (i5 = i5 + i4) < 0) {
                            i4 = Integer.MAX_VALUE;
                        }
                    }
                }
                i4 = i5;
            }
            bufferOverflow = this.f60133c;
        }
        return (f0.g(plus, this.f60131a) && i4 == this.f60132b && bufferOverflow == this.f60133c) ? this : k(plus, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.h
    @Nullable
    public Object e(@NotNull kotlinx.coroutines.flow.i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return i(this, iVar, cVar);
    }

    @Nullable
    protected String g() {
        return null;
    }

    @NotNull
    public kotlinx.coroutines.channels.j<T> h(@NotNull q0 q0Var, @NotNull CoroutineStart coroutineStart) {
        int n4;
        int i4 = d.f60130a[this.f60133c.ordinal()];
        if (i4 == 1) {
            n4 = n();
        } else if (i4 != 2) {
            if (i4 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            throw new IllegalArgumentException("Broadcast channel does not support BufferOverflow.DROP_LATEST");
        } else {
            n4 = -1;
        }
        return kotlinx.coroutines.channels.m.c(q0Var, this.f60131a, n4, coroutineStart, null, m(), 8, null);
    }

    @Nullable
    protected abstract Object j(@NotNull b0<? super T> b0Var, @NotNull kotlin.coroutines.c<? super f1> cVar);

    @NotNull
    protected abstract e<T> k(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow);

    @Nullable
    public kotlinx.coroutines.flow.h<T> l() {
        return null;
    }

    @NotNull
    public final d2.p<b0<? super T>, kotlin.coroutines.c<? super f1>, Object> m() {
        return new b(null);
    }

    @NotNull
    public kotlinx.coroutines.channels.d0<T> o(@NotNull q0 q0Var) {
        return z.h(q0Var, this.f60131a, n(), this.f60133c, CoroutineStart.ATOMIC, null, m(), 16, null);
    }

    @NotNull
    public String toString() {
        String X2;
        ArrayList arrayList = new ArrayList(4);
        String g4 = g();
        if (g4 != null) {
            arrayList.add(g4);
        }
        if (this.f60131a != EmptyCoroutineContext.INSTANCE) {
            arrayList.add("context=" + this.f60131a);
        }
        if (this.f60132b != -3) {
            arrayList.add("capacity=" + this.f60132b);
        }
        if (this.f60133c != BufferOverflow.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f60133c);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(u0.a(this));
        sb.append('[');
        X2 = kotlin.collections.f0.X2(arrayList, ", ", null, null, 0, null, null, 62, null);
        sb.append(X2);
        sb.append(']');
        return sb.toString();
    }
}
