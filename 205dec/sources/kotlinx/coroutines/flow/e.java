package kotlinx.coroutines.flow;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.f1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Channels.kt */
@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b\u0012\u0006\u0010*\u001a\u00020(\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b+\u0010,J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a2\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0013\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00182\u0006\u0010\u0012\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0006\u0010\u0012\u001a\u00020\u0015H\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ!\u0010 \u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u001eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0014\u00a2\u0006\u0004\b#\u0010$R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010)\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lkotlinx/coroutines/flow/e;", "T", "Lkotlinx/coroutines/flow/internal/e;", "Lkotlin/f1;", "p", "()V", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "k", "(Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/internal/e;", "Lkotlinx/coroutines/flow/h;", "l", "()Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/channels/b0;", "scope", "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlinx/coroutines/q0;", "Lkotlinx/coroutines/CoroutineStart;", CampaignEx.JSON_NATIVE_VIDEO_START, "Lkotlinx/coroutines/channels/j;", "h", "(Lkotlinx/coroutines/q0;Lkotlinx/coroutines/CoroutineStart;)Lkotlinx/coroutines/channels/j;", "Lkotlinx/coroutines/channels/d0;", "o", "(Lkotlinx/coroutines/q0;)Lkotlinx/coroutines/channels/d0;", "Lkotlinx/coroutines/flow/i;", "collector", "e", "(Lkotlinx/coroutines/flow/i;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "g", "()Ljava/lang/String;", "d", "Lkotlinx/coroutines/channels/d0;", "channel", "", "Z", "consume", "<init>", "(Lkotlinx/coroutines/channels/d0;ZLkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e<T> extends kotlinx.coroutines.flow.internal.e<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f60008f = AtomicIntegerFieldUpdater.newUpdater(e.class, "consumed");
    private volatile int consumed;

    /* renamed from: d  reason: collision with root package name */
    private final kotlinx.coroutines.channels.d0<T> f60009d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f60010e;

    public /* synthetic */ e(kotlinx.coroutines.channels.d0 d0Var, boolean z3, kotlin.coroutines.f fVar, int i4, BufferOverflow bufferOverflow, int i5, kotlin.jvm.internal.u uVar) {
        this(d0Var, z3, (i5 & 4) != 0 ? EmptyCoroutineContext.INSTANCE : fVar, (i5 & 8) != 0 ? -3 : i4, (i5 & 16) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    private final void p() {
        if (this.f60010e) {
            if (!(f60008f.getAndSet(this, 1) == 0)) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // kotlinx.coroutines.flow.internal.e, kotlinx.coroutines.flow.h
    @Nullable
    public Object e(@NotNull i<? super T> iVar, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object h5;
        if (this.f60132b == -3) {
            p();
            Object f4 = l.f(iVar, this.f60009d, this.f60010e, cVar);
            h5 = kotlin.coroutines.intrinsics.b.h();
            if (f4 == h5) {
                return f4;
            }
        } else {
            Object e4 = super.e(iVar, cVar);
            h4 = kotlin.coroutines.intrinsics.b.h();
            if (e4 == h4) {
                return e4;
            }
        }
        return f1.f55527a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    protected String g() {
        return "channel=" + this.f60009d;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    public kotlinx.coroutines.channels.j<T> h(@NotNull q0 q0Var, @NotNull CoroutineStart coroutineStart) {
        p();
        return super.h(q0Var, coroutineStart);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @Nullable
    protected Object j(@NotNull kotlinx.coroutines.channels.b0<? super T> b0Var, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        Object h4;
        Object f4 = l.f(new kotlinx.coroutines.flow.internal.t(b0Var), this.f60009d, this.f60010e, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return f4 == h4 ? f4 : f1.f55527a;
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    protected kotlinx.coroutines.flow.internal.e<T> k(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return new e(this.f60009d, this.f60010e, fVar, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @Nullable
    public h<T> l() {
        return new e(this.f60009d, this.f60010e, null, 0, null, 28, null);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    public kotlinx.coroutines.channels.d0<T> o(@NotNull q0 q0Var) {
        p();
        if (this.f60132b == -3) {
            return this.f60009d;
        }
        return super.o(q0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull kotlinx.coroutines.channels.d0<? extends T> d0Var, boolean z3, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        super(fVar, i4, bufferOverflow);
        this.f60009d = d0Var;
        this.f60010e = z3;
        this.consumed = 0;
    }
}
