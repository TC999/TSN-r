package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.f1;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Builders.kt */
@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BW\u0012-\u0010\u0015\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011\u00a2\u0006\u0002\b\u0014\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J!\u0010\r\u001a\u00020\f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0094@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u0010\u001a\u00020\u000fH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lkotlinx/coroutines/flow/f;", "T", "Lkotlinx/coroutines/flow/internal/e;", "Lkotlin/coroutines/f;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "k", "Lkotlinx/coroutines/channels/b0;", "scope", "Lkotlin/f1;", "j", "(Lkotlinx/coroutines/channels/b0;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "toString", "Lkotlin/Function2;", "Lkotlin/coroutines/c;", "", "Lkotlin/ExtensionFunctionType;", "block", "<init>", "(Ld2/p;Lkotlin/coroutines/f;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class f<T> extends kotlinx.coroutines.flow.internal.e<T> {

    /* renamed from: d  reason: collision with root package name */
    private final d2.p<kotlinx.coroutines.channels.b0<? super T>, kotlin.coroutines.c<? super f1>, Object> f60011d;

    public /* synthetic */ f(d2.p pVar, kotlin.coroutines.f fVar, int i4, BufferOverflow bufferOverflow, int i5, kotlin.jvm.internal.u uVar) {
        this(pVar, (i5 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : fVar, (i5 & 4) != 0 ? -2 : i4, (i5 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    static /* synthetic */ Object p(f fVar, kotlinx.coroutines.channels.b0 b0Var, kotlin.coroutines.c cVar) {
        Object h4;
        Object invoke = fVar.f60011d.invoke(b0Var, cVar);
        h4 = kotlin.coroutines.intrinsics.b.h();
        return invoke == h4 ? invoke : f1.f55527a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.e
    @Nullable
    public Object j(@NotNull kotlinx.coroutines.channels.b0<? super T> b0Var, @NotNull kotlin.coroutines.c<? super f1> cVar) {
        return p(this, b0Var, cVar);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    protected kotlinx.coroutines.flow.internal.e<T> k(@NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        return new f(this.f60011d, fVar, i4, bufferOverflow);
    }

    @Override // kotlinx.coroutines.flow.internal.e
    @NotNull
    public String toString() {
        return "block[" + this.f60011d + "] -> " + super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull d2.p<? super kotlinx.coroutines.channels.b0<? super T>, ? super kotlin.coroutines.c<? super f1>, ? extends Object> pVar, @NotNull kotlin.coroutines.f fVar, int i4, @NotNull BufferOverflow bufferOverflow) {
        super(fVar, i4, bufferOverflow);
        this.f60011d = pVar;
    }
}
